/*
 * Created by cabeatty on Mon Nov 07 15:32:16 EST 2016
 */

package FitTrack.Main.guiMain;

import FitTrack.Components.*;
import FitTrack.Data.calorieDb;
import FitTrack.Data.sleepDb;
import FitTrack.Data.workoutDb;
import FitTrack.Main.guiMain.Components.*;
import FitTrack.Main.guiMain.Utilities.fieldChecks;
import org.jfree.ui.RefineryUtilities;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Colin Beatty
 */
public class Display extends JFrame
{
	public static User usr;

	public static boolean NEWUSER = false;
	public static boolean LOGGEDINFLAG = false;
	public static waterIntakeTracker waterTrk;
	public static sleepTracker sleepTrk = new sleepTracker();
	public static calorieTracker calTrk;
	public static exerciseTracker excTrk;
	//TODO work on database shit

	public Display()
	{
		initComponents();
	}

	//-----------------Login/Logout/Create Account---------------------------------------

	private void loginButtonMouseReleased(MouseEvent e)
	{
		if (LOGGEDINFLAG == false)
		{
			login lin = new login();
			lin.setLocationRelativeTo(this);
			lin.setVisible(true);
			lin.setResizable(false);
			this.repaint();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Already logged in.");
		}
	}
	private void logoutButtonMouseReleased(MouseEvent e)
	{
		if(LOGGEDINFLAG == true)
		{
			this.repaint();
			JOptionPane.showMessageDialog(this, usr.getuName() + " logged out.");
			LOGGEDINFLAG = false;
			updateLoginStatus();
			deLoadData();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Already logged out.");
		}
	}
	private void createAccButtonMouseReleased(MouseEvent e)
	{
		if (LOGGEDINFLAG == false)
		{
			createAcc cat = new createAcc();
			cat.setLocationRelativeTo(this);
			cat.setVisible(true);
			cat.setResizable(false);
			this.revalidate();
			this.repaint();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Already logged in.");
		}

	}
	public static void updateLoginStatus()
	{
		if (LOGGEDINFLAG == false)
		{
			loginStatus.setText("");
			logoutButton.setVisible(false);
			loginButton.setVisible(true);

			//Display boxes
			sleepField.setText("Not logged in, go to the home tab and login to get started.");
			workoutField.setText("Not logged in, go to the home tab and login to get started.");
			mealsField.setText("Not logged in, go to the home tab and login to get started.");
			checkDrinkGoal();
			drankField.setText("0");
			leftField.setText("64");

			//Buttons
			addDrinkButton.setBackground(Color.RED);
			addMealButton.setBackground(Color.RED);
			addSleepButton.setBackground(Color.RED);
			addWorkoutButton.setBackground(Color.RED);
			mapButton.setBackground(Color.RED);

		}
		else
		{
			loginStatus.setText(usr.getuName());
			logoutButton.setVisible(true);
			loginButton.setVisible(false);
			calTrk = new calorieTracker(usr);
			excTrk = new exerciseTracker(usr);
			loadData();
			checkDrinkGoal();
			diffCalField.setText(calTrk.getDiff());
			totalCalField.setText(calTrk.getTotal());
			targetCalField.setText(calTrk.getTarget());

			//Buttons

			addDrinkButton.setBackground(null);
			addMealButton.setBackground(null);
			addSleepButton.setBackground(null);
			addWorkoutButton.setBackground(null);
			mapButton.setBackground(null);

		}
	}

	//-------------Load & De-Load data and display-------------------------------

	public static void loadData()
	{
		if(NEWUSER)  //if the user is new, dont try to load cached data that doesnt exist
		{
			sleepField.setText("No sleep logged, click 'Add Sleep' to get started.");
			workoutField.setText("No workouts logged, click 'Add Workout' to get started.");
			mealsField.setText("No meals logged, click 'Add Meal' to get started.");
			waterTrk = new waterIntakeTracker();
		}
		else
		{
			waterTrk = new waterIntakeTracker();
			workoutField.setText("No workouts logged, click 'Add Workout' to get started.");
			mealsField.setText("No meals logged, click 'Add Meal' to get started.");
			sleepTrk.setSleepHistory(sleepDb.loadSleep());
			excTrk.setWorkoutHistory(workoutDb.loadWorkout());
			calTrk.setMealHistory(calorieDb.loadMeals());
			calTrk.setTodaysCal();
			populateSleepField();
			populateWorkoutField();
			populateMealField();
		}
	}
	public static void deLoadData()
	{
		waterTrk = new waterIntakeTracker();
		sleepDb.saveSleep();
		workoutDb.saveWorkout();
		calorieDb.saveMeals();
	}

	//-----------------Water intake tracker---------------------------------------

	private void addDrinkButtonMouseReleased(MouseEvent e)
	{
		if (LOGGEDINFLAG == true)
		{
			JTextField[] fieldsArr = {addDrinkField};
			if (fieldChecks.empty(fieldsArr))
			{
				try
				{
					int drink = Integer.parseInt(addDrinkField.getText());
					waterTrk.addDrink(drink);
					drankField.setText(waterTrk.getTotal());
					leftField.setText(waterTrk.getRemaining());
					addDrinkField.setText("");
					checkDrinkGoal();
				}
				catch (Exception drinkEx)
				{
					JOptionPane.showMessageDialog(this, "Invalid input.");
					addDrinkField.setText("");
				}

			}
			else JOptionPane.showMessageDialog(this, "Type an amount in oz to add a drink.");
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Must log in to use functionality");
			addDrinkField.setText("");
		}
	}
	public static void checkDrinkGoal()
	{
		if(waterTrk.getRemainingInt() <= 0)
		{
			drankField.setForeground(Color.GREEN);
			leftField.setForeground(Color.GREEN);
			goalField.setForeground(Color.GREEN);
		}
		else
		{
			drankField.setForeground(null);
			leftField.setForeground(null);
			goalField.setForeground(null);
		}

		if (!LOGGEDINFLAG)
		{
			drankField.setForeground(null);
			leftField.setForeground(null);
			goalField.setForeground(null);
		}
	}

	//-----------------Workout Tracker---------------------------------------

	private void addWorkoutButtonMouseReleased(MouseEvent e)
	{
		if (LOGGEDINFLAG == true)
		{
			addWorkout wout = new addWorkout();
			wout.setLocationRelativeTo(this);
			wout.setVisible(true);
			wout.setResizable(false);
		}
		else JOptionPane.showMessageDialog(this, "Must log in to use functionality");
	}
	public static void populateWorkoutField()
	{
		ArrayList<String> wout = excTrk.getWorkoutData();

		if( wout.isEmpty() )
		{
			workoutField.setText("No workouts logged, click 'Add Workout' to get started");
		}
		else
		{
			workoutField.setText("");
			workoutField.setText(excTrk.toString());
		}
	}

	//-----------------Sleep Tracker---------------------------------------

	private void addSleepButtonMouseReleased(MouseEvent e)
	{
		if (LOGGEDINFLAG == true)
		{
			addSleep sw = new addSleep();
			sw.setLocationRelativeTo(this);
			sw.setVisible(true);
			sw.setResizable(false);
		}
		else JOptionPane.showMessageDialog(this, "Must log in to use functionality");
	}
	public static void populateSleepField()
	{
		ArrayList<sleep> slp = sleepTrk.getSleepHistory();

		if (slp.isEmpty())
		{
			sleepField.setText("No sleep logged, click 'Add Sleep' to get started");
		}
		else
		{
			sleepField.setText("");
			sleepField.setText(sleepTrk.toString());
		}
	}
	private void mapButtonMouseReleased(MouseEvent e)
	{
		if (LOGGEDINFLAG == true)
		{
			sleepGraph chart = new sleepGraph("Sleep Day to Day" , "Hours Slept Per Day", sleepTrk.getSleepHistory());
			chart.pack( );
			RefineryUtilities.centerFrameOnScreen( chart );
			chart.setVisible( true );
			chart.setFocusable( true );
			chart.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
		else JOptionPane.showMessageDialog(this, "Must log in to use functionality");

	}


	//-----------------Calorie tracker---------------------------------------

	private void addMealButtonMouseReleased(MouseEvent e)
	{
		if (LOGGEDINFLAG == true)
		{
			addMeal mw = new addMeal();
			mw.setLocationRelativeTo(this);
			mw.setVisible(true);
			mw.setResizable(false);
		}
		else JOptionPane.showMessageDialog(this, "Must log in to use functionality");
	}
	public static void populateMealField()
	{
		ArrayList<String> mls = calTrk.getMealHistory();

		if (mls.isEmpty())
		{
			mealsField.setText("No meals logged, click 'Add Meal' to get started");
		}
		else
		{
			mealsField.setText("");
			mealsField.setText(calTrk.toString());
			totalCalField.setText(calTrk.getTotal());
			targetCalField.setText(calTrk.getTarget());
			diffCalField.setText(calTrk.getDiff());

		}
	}

	//-----------------JForm shit---------------------------------------

	private void initComponents()
	{
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Colin Beatty
		tabbedPane1 = new JTabbedPane();
		homePanel = new JPanel();
		homeLabel = new JLabel();
		homeSubLabel = new JLabel();
		loginButton = new JButton();
		createAccButton = new JButton();
		iconLabel = new JLabel();
		logoutButton = new JButton();
		loginStatus = new JLabel();
		exersizePanel = new JPanel();
		addWorkoutButton = new JButton();
		workoutScrollPane = new JScrollPane();
		workoutField = new JTextArea();
		caloriePanel = new JPanel();
		addMealButton = new JButton();
		mealListLabel = new JLabel();
		mealsScrollPane = new JScrollPane();
		mealsField = new JTextArea();
		totalCalLabel = new JLabel();
		totalCalField = new JTextField();
		targetCalLabel = new JLabel();
		targetCalField = new JTextField();
		diffCalLabel = new JLabel();
		diffCalField = new JTextField();
		sleepPanel = new JPanel();
		addSleepButton = new JButton();
		mapButton = new JButton();
		sleepScrollPane = new JScrollPane();
		sleepField = new JTextArea();
		waterPanel = new JPanel();
		addDrinkButton = new JButton();
		ammountDrankLabel = new JLabel();
		goalLabel = new JLabel();
		leftLabel = new JLabel();
		goalField = new JTextField();
		leftField = new JTextField();
		ozLabel1 = new JLabel();
		ozLabel2 = new JLabel();
		ozLabel3 = new JLabel();
		addDrinkField = new JTextField();
		ozLabel4 = new JLabel();
		drankField = new JTextField();

		//======== this ========
		setTitle("FitTrack");
		Container contentPane = getContentPane();

		setIconImage(new ImageIcon("src/resources/man.png").getImage());

		//======== tabbedPane1 ========
		{

			//======== homePanel ========
			{
				//---- homeLabel ----
				homeLabel.setText("FitTrack");
				homeLabel.setFont(new Font("Ubuntu", Font.PLAIN, 48));

				//---- homeSubLabel ----
				homeSubLabel.setText("Wellness Tracker");
				homeSubLabel.setFont(new Font("Ubuntu", Font.PLAIN, 18));

				//---- loginButton ----
				loginButton.setText("Login");
				loginButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						loginButtonMouseReleased(e);
					}
				});

				//---- createAccButton ----
				createAccButton.setText("Create Account");
				createAccButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						createAccButtonMouseReleased(e);
					}
				});

				//---- iconLabel ----
				iconLabel.setIcon(new ImageIcon(getClass().getResource("/resources/man.png")));

				//---- logoutButton ----
				logoutButton.setText("Logout");
				logoutButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						logoutButtonMouseReleased(e);
					}
				});

				//---- loginStatus ----
				loginStatus.setText("");
				loginStatus.setFont(new Font("Ubuntu", Font.PLAIN, 14));

				GroupLayout homePanelLayout = new GroupLayout(homePanel);
				homePanel.setLayout(homePanelLayout);
				homePanelLayout.setHorizontalGroup(
						homePanelLayout.createParallelGroup()
								.addGroup(homePanelLayout.createSequentialGroup()
										.addGap(22, 22, 22)
										.addGroup(homePanelLayout.createParallelGroup()
												.addComponent(homeSubLabel)
												.addComponent(homeLabel)
												.addGroup(homePanelLayout.createSequentialGroup()
														.addComponent(createAccButton)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(loginButton)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(logoutButton))
												.addComponent(loginStatus))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(iconLabel)
										.addGap(29, 29, 29))
				);
				homePanelLayout.setVerticalGroup(
						homePanelLayout.createParallelGroup()
								.addGroup(homePanelLayout.createSequentialGroup()
										.addGroup(homePanelLayout.createParallelGroup()
												.addGroup(homePanelLayout.createSequentialGroup()
														.addContainerGap(11, Short.MAX_VALUE)
														.addComponent(iconLabel, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE))
												.addGroup(homePanelLayout.createSequentialGroup()
														.addGap(29, 29, 29)
														.addComponent(homeLabel)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(homeSubLabel)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
														.addComponent(loginStatus)))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(homePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(createAccButton)
												.addComponent(logoutButton)
												.addComponent(loginButton))
										.addContainerGap())
				);
			}
			tabbedPane1.addTab("Home", homePanel);

			//======== exersizePanel ========
			{
				exersizePanel.setFocusable(false);
				exersizePanel.setEnabled(false);

				//---- addWorkoutButton ----
				addWorkoutButton.setText("Add Workout");
				addWorkoutButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						addWorkoutButtonMouseReleased(e);
					}
				});

				//======== workoutScrollPane ========
				{

					//---- workoutField ----
					workoutField.setEditable(false);
					workoutScrollPane.setViewportView(workoutField);
				}

				GroupLayout exersizePanelLayout = new GroupLayout(exersizePanel);
				exersizePanel.setLayout(exersizePanelLayout);
				exersizePanelLayout.setHorizontalGroup(
						exersizePanelLayout.createParallelGroup()
								.addGroup(exersizePanelLayout.createSequentialGroup()
										.addContainerGap()
										.addGroup(exersizePanelLayout.createParallelGroup()
												.addGroup(exersizePanelLayout.createSequentialGroup()
														.addComponent(addWorkoutButton)
														.addGap(0, 419, Short.MAX_VALUE))
												.addComponent(workoutScrollPane, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE))
										.addContainerGap())
				);
				exersizePanelLayout.setVerticalGroup(
						exersizePanelLayout.createParallelGroup()
								.addGroup(exersizePanelLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(workoutScrollPane, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(addWorkoutButton)
										.addContainerGap())
				);
			}
			tabbedPane1.addTab("Exercise", exersizePanel);

			//======== caloriePanel ========
			{

				//---- addMealButton ----
				addMealButton.setText("Add Meal");
				addMealButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						addMealButtonMouseReleased(e);
					}
				});

				//---- mealListLabel ----
				mealListLabel.setText("Todays Meals");

				//======== mealsScrollPane ========
				{

					//---- mealsField ----
					mealsField.setEditable(false);
					mealsScrollPane.setViewportView(mealsField);
				}

				//---- totalCalLabel ----
				totalCalLabel.setText("Total Calories");

				//---- totalCalField ----
				totalCalField.setEditable(false);

				//---- targetCalLabel ----
				targetCalLabel.setText("Target Calories");

				//---- targetCalField ----
				targetCalField.setEditable(false);

				//---- diffCalLabel ----
				diffCalLabel.setText("Remaining Calories");

				//---- diffCalField ----
				diffCalField.setEditable(false);

				GroupLayout caloriePanelLayout = new GroupLayout(caloriePanel);
				caloriePanel.setLayout(caloriePanelLayout);
				caloriePanelLayout.setHorizontalGroup(
						caloriePanelLayout.createParallelGroup()
								.addGroup(caloriePanelLayout.createSequentialGroup()
										.addContainerGap()
										.addGroup(caloriePanelLayout.createParallelGroup()
												.addComponent(mealsScrollPane, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)  //NOTE VALUE WAS ORIGINALLY 529
												.addGroup(caloriePanelLayout.createSequentialGroup()
														.addGroup(caloriePanelLayout.createParallelGroup()
																.addComponent(addMealButton)
																.addComponent(mealListLabel)
																.addGroup(caloriePanelLayout.createSequentialGroup()
																		.addGroup(caloriePanelLayout.createParallelGroup()
																				.addComponent(totalCalLabel)
																				.addComponent(targetCalLabel)
																				.addComponent(diffCalLabel))
																		.addGap(70, 70, 70)
																		.addGroup(caloriePanelLayout.createParallelGroup()
																				.addComponent(targetCalField, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
																				.addComponent(totalCalField, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
																				.addComponent(diffCalField, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))))
														.addGap(0, 168, Short.MAX_VALUE)))
										.addContainerGap())
				);
				caloriePanelLayout.setVerticalGroup(
						caloriePanelLayout.createParallelGroup()
								.addGroup(GroupLayout.Alignment.TRAILING, caloriePanelLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(mealListLabel)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(mealsScrollPane, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)  //NOTE VALUE WAS ORIGINALLY 124
										.addGap(18, 18, 18)
										.addGroup(caloriePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(totalCalLabel)
												.addComponent(totalCalField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(caloriePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(targetCalLabel)
												.addComponent(targetCalField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(caloriePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(diffCalLabel)
												.addComponent(diffCalField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE) //NOTE VALUE WAS ORIGINALLY 51
										.addComponent(addMealButton)
										.addContainerGap())
				);
			}
			tabbedPane1.addTab("Calories", caloriePanel);

			//======== sleepPanel ========
			{

				//---- addSleepButton ----
				addSleepButton.setText("Add Sleep");
				addSleepButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						addSleepButtonMouseReleased(e);
					}
				});

				//---- mapButton ----
				mapButton.setText("Show Trend");
				mapButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						mapButtonMouseReleased(e);
					}
				});

				//======== sleepScrollPane ========
				{

					//---- sleepField ----
					sleepField.setEditable(false);
					sleepScrollPane.setViewportView(sleepField);
				}

				GroupLayout sleepPanelLayout = new GroupLayout(sleepPanel);
				sleepPanel.setLayout(sleepPanelLayout);
				sleepPanelLayout.setHorizontalGroup(
						sleepPanelLayout.createParallelGroup()
								.addGroup(sleepPanelLayout.createSequentialGroup()
										.addContainerGap()
										.addGroup(sleepPanelLayout.createParallelGroup()
												.addGroup(sleepPanelLayout.createSequentialGroup()
														.addComponent(addSleepButton)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 384, Short.MAX_VALUE)
														.addComponent(mapButton))
												.addComponent(sleepScrollPane, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE))
										.addContainerGap())
				);
				sleepPanelLayout.setVerticalGroup(
						sleepPanelLayout.createParallelGroup()
								.addGroup(GroupLayout.Alignment.TRAILING, sleepPanelLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(sleepScrollPane, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(sleepPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(addSleepButton)
												.addComponent(mapButton))
										.addContainerGap())
				);
			}
			tabbedPane1.addTab("Sleep", sleepPanel);
			//======== waterPanel ========
			{

				//---- addDrinkButton ----
				addDrinkButton.setText("Add Drink");
				addDrinkButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						addDrinkButtonMouseReleased(e);
					}
				});

				//---- ammountDrankLabel ----
				ammountDrankLabel.setText("Water Drank Today");
				ammountDrankLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

				//---- goalLabel ----
				goalLabel.setText("Goal Amount");
				goalLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

				//---- leftLabel ----
				leftLabel.setText("Amount Left");
				leftLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

				//---- goalField ----
				goalField.setEditable(false);
				goalField.setText("64");

				//---- leftField ----
				leftField.setEditable(false);
				leftField.setText("64");

				//---- ozLabel1 ----
				ozLabel1.setText("oz");

				//---- ozLabel2 ----
				ozLabel2.setText("oz");

				//---- ozLabel3 ----
				ozLabel3.setText("oz");

				//---- ozLabel4 ----
				ozLabel4.setText("oz");

				//---- drankField ----
				drankField.setEditable(false);
				drankField.setText("0");

				GroupLayout waterPanelLayout = new GroupLayout(waterPanel);
				waterPanel.setLayout(waterPanelLayout);
				waterPanelLayout.setHorizontalGroup(
						waterPanelLayout.createParallelGroup()
								.addGroup(waterPanelLayout.createSequentialGroup()
										.addGap(56, 56, 56)
										.addGroup(waterPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
												.addComponent(addDrinkButton)
												.addComponent(leftLabel)
												.addComponent(goalLabel)
												.addComponent(ammountDrankLabel))
										.addGap(40, 40, 40)
										.addGroup(waterPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
												.addComponent(goalField, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
												.addComponent(leftField, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
												.addComponent(addDrinkField, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
												.addComponent(drankField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(waterPanelLayout.createParallelGroup()
												.addComponent(ozLabel1)
												.addComponent(ozLabel2)
												.addComponent(ozLabel3)
												.addComponent(ozLabel4))
										.addGap(92, 92, 92))
				);
				waterPanelLayout.setVerticalGroup(
						waterPanelLayout.createParallelGroup()
								.addGroup(GroupLayout.Alignment.TRAILING, waterPanelLayout.createSequentialGroup()
										.addGap(64, 64, 64)
										.addGroup(waterPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(ammountDrankLabel)
												.addComponent(ozLabel1)
												.addComponent(drankField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(waterPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(goalLabel)
												.addComponent(goalField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(ozLabel2))
										.addGap(18, 18, 18)
										.addGroup(waterPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(leftLabel)
												.addComponent(leftField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(ozLabel3))
										.addGap(18, 18, 18)
										.addGroup(waterPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(addDrinkButton)
												.addComponent(addDrinkField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(ozLabel4))
										.addContainerGap(115, Short.MAX_VALUE))
				);
			}
			tabbedPane1.addTab("Water", waterPanel);
		}

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
				contentPaneLayout.createParallelGroup()
						.addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
		);
		contentPaneLayout.setVerticalGroup(
				contentPaneLayout.createParallelGroup()
						.addComponent(tabbedPane1)
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents

		logoutButton.setVisible(false);
		updateLoginStatus();
		this.repaint();
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Colin Beatty
	private static JTabbedPane tabbedPane1;
	private static JPanel homePanel;
	private static JLabel homeLabel;
	private static JLabel homeSubLabel;
	private static JButton loginButton;
	private static JButton createAccButton;
	private static JLabel iconLabel;
	private static JButton logoutButton;
	private static JLabel loginStatus;
	private static JPanel exersizePanel;
	private static JButton addWorkoutButton;
	private static JScrollPane workoutScrollPane;
	private static JTextArea workoutField;
	private static JPanel caloriePanel;
	private static JButton addMealButton;
	private static JLabel mealListLabel;
	private static JScrollPane mealsScrollPane;
	private static JTextArea mealsField;
	private static JLabel totalCalLabel;
	private static JTextField totalCalField;
	private static JLabel targetCalLabel;
	private static JTextField targetCalField;
	private static JLabel diffCalLabel;
	private static JTextField diffCalField;
	private static JPanel sleepPanel;
	private static JButton addSleepButton;
	private static JButton mapButton;
	private static JScrollPane sleepScrollPane;
	private static JTextArea sleepField;
	private static JPanel waterPanel;
	private static JButton addDrinkButton;
	private static JLabel ammountDrankLabel;
	private static JLabel goalLabel;
	private static JLabel leftLabel;
	private static JTextField goalField;
	private static JTextField leftField;
	private static JLabel ozLabel1;
	private static JLabel ozLabel2;
	private static JLabel ozLabel3;
	private static JTextField addDrinkField;
	private static JLabel ozLabel4;
	private static JTextField drankField;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
