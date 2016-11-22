package FitTrack.Main;

/**
 * Created by JColin
 */

/**
 * @author Colin Beatty
 */

import FitTrack.Components.*;
import jFrame.Utilities.fieldChecks;
import jFrame.main.Calories.addMeal;
import jFrame.main.Exersize.addWorkout;
import jFrame.main.Home.createAcc.createAcc;
import jFrame.main.Home.login.login;
import jFrame.main.Sleep.addSleep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;

public class Display extends JFrame
{
	ImageIcon runningMan = new ImageIcon("/resources/man.png");
	public static User usr;

	public static boolean LOGGEDINFLAG = false;
	public static waterIntakeTracker waterTrk = new waterIntakeTracker();
	public static sleepTracker sleepTrk = new sleepTracker();
	public static calorieTracker calTrk;

	public Display()
	{
		initComponents();
	}

	private void loginButtonMouseReleased(MouseEvent e)
	{
		if (LOGGEDINFLAG == false)
		{
			login lin = new login();
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
			JOptionPane.showMessageDialog(this, "username" + " logged out.");
			LOGGEDINFLAG = false;
			updateLoginStatus();
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
			System.out.println("Create Account Pressed");
			createAcc cat = new createAcc();
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
			loginStatus.setText("Not logged in.");
			logoutButton.setVisible(false);
			loginButton.setVisible(true);
		}
		else
		{
			loginStatus.setText("Logged in as: " + usr.getuName());
			logoutButton.setVisible(true);
			loginButton.setVisible(false);
		}
	}

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

				}
				catch (Exception drinkEx)
				{
					JOptionPane.showMessageDialog(this, "Invalid input.");
					addDrinkField.setText("");
				}

			}
			else JOptionPane.showMessageDialog(this, "Type an amount in oz to add a drink.");
		}
		else JOptionPane.showMessageDialog(this, "Must log in to use functionality");
	}

	private void addWorkoutButtonMouseReleased(MouseEvent e)
	{
		if (LOGGEDINFLAG == true)
		{
			addWorkout wout = new addWorkout();
			wout.setVisible(true);
			wout.setResizable(false);
		}
		else JOptionPane.showMessageDialog(this, "Must log in to use functionality");
	}


	private void addSleepButtonMouseReleased(MouseEvent e)
	{
		if (LOGGEDINFLAG == true)
		{
			addSleep sw = new addSleep();
			sw.setVisible(true);
			sw.setResizable(false);
		}
		else JOptionPane.showMessageDialog(this, "Must log in to use functionality");
	}

	private void addMealButtonMouseReleased(MouseEvent e)
	{
		if (LOGGEDINFLAG == true)
		{
			addMeal mw = new addMeal();
			mw.setVisible(true);
			mw.setResizable(false);
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

	private void initComponents()
	{

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

		//======== tabbedPane1 ========
		{

			//======== homePanel ========
			{

				// JFormDesigner evaluation mark
				//homePanel.setBorder(new javax.swing.border.CompoundBorder(
				//		new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
				//				"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
				//				javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
				//				java.awt.Color.red), homePanel.getBorder())); homePanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


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
				iconLabel.setIcon(new ImageIcon(getClass().getResource("/resources/man2.png")));

				//---- logoutButton ----
				logoutButton.setText("Logout");
				logoutButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						logoutButtonMouseReleased(e);
					}
				});

				//---- loginStatus ----
				loginStatus.setText("text");

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
			tabbedPane1.addTab("Exersize", exersizePanel);

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
				diffCalLabel.setText("Difference");

				//---- diffCalField ----
				diffCalField.setEditable(false);

				GroupLayout caloriePanelLayout = new GroupLayout(caloriePanel);
				caloriePanel.setLayout(caloriePanelLayout);
				caloriePanelLayout.setHorizontalGroup(
						caloriePanelLayout.createParallelGroup()
								.addGroup(caloriePanelLayout.createSequentialGroup()
										.addContainerGap()
										.addGroup(caloriePanelLayout.createParallelGroup()
												.addComponent(mealsScrollPane, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
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
										.addComponent(mealsScrollPane, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
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
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
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
														.addGap(0, 438, Short.MAX_VALUE))
												.addComponent(sleepScrollPane, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE))
										.addContainerGap())
				);
				sleepPanelLayout.setVerticalGroup(
						sleepPanelLayout.createParallelGroup()
								.addGroup(GroupLayout.Alignment.TRAILING, sleepPanelLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(sleepScrollPane, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(addSleepButton)
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
				goalLabel.setText("Goal Ammount");
				goalLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

				//---- leftLabel ----
				leftLabel.setText("Ammount Left");
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
		loginStatus.setText("Not logged in.");
		sleepField.setText("No sleep logged, click 'Add Sleep' to get started");
		workoutField.setText("No workouts logged, click 'Add Workout' to get started");
		mealsField.setText("No meals logged, click 'Add Meal' to get started");
		this.repaint();
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Colin Beatty
	private JTabbedPane tabbedPane1;
	private JPanel homePanel;
	private JLabel homeLabel;
	private JLabel homeSubLabel;
	private static JButton loginButton;
	private JButton createAccButton;
	private JLabel iconLabel;
	private static JButton logoutButton;
	private static JLabel loginStatus;
	private JPanel exersizePanel;
	private JButton addWorkoutButton;
	private JScrollPane workoutScrollPane;
	private JTextArea workoutField;
	private JPanel caloriePanel;
	private JButton addMealButton;
	private JLabel mealListLabel;
	private JScrollPane mealsScrollPane;
	private JTextArea mealsField;
	private JLabel totalCalLabel;
	private JTextField totalCalField;
	private JLabel targetCalLabel;
	private JTextField targetCalField;
	private JLabel diffCalLabel;
	private JTextField diffCalField;
	private JPanel sleepPanel;
	private JButton addSleepButton;
	private JScrollPane sleepScrollPane;
	private static JTextArea sleepField;
	private JPanel waterPanel;
	private JButton addDrinkButton;
	private JLabel ammountDrankLabel;
	private JLabel goalLabel;
	private JLabel leftLabel;
	private JTextField goalField;
	private JTextField leftField;
	private JLabel ozLabel1;
	private JLabel ozLabel2;
	private JLabel ozLabel3;
	private JTextField addDrinkField;
	private JLabel ozLabel4;
	private JTextField drankField;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}