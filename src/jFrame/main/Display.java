/*
 * Created by JFormDesigner on Mon Nov 07 15:32:16 EST 2016
 */

package jFrame.main;

import jFrame.createAcc.createAcc;
import jFrame.login.login;
import FitTrack.Components.User;
import jFrame.main.Calories.addMeal;
import jFrame.main.Exersize.addWorkout;
import jFrame.main.Sleep.addSleep;
import jFrame.main.Water.addDrink;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Colin Beatty
 */
public class Display extends JFrame
{
	ImageIcon runningMan = new ImageIcon("/resources/man.png");

	public Display()
	{
		initComponents();
	}

	private void loginButtonMouseReleased(MouseEvent e)
	{
		System.out.println("Login Pressed");
		login lin = new login();
		lin.setVisible(true);
		lin.setResizable(false);
	}

	private void createAccButtonMouseReleased(MouseEvent e)
	{
		System.out.println("Create Account Pressed");
		createAcc cat = new createAcc();
		cat.setVisible(true);
		cat.setResizable(false);

	}

	private void addDrinkButtonMouseReleased(MouseEvent e)
	{
		addDrink drink = new addDrink();
		drink.setVisible(true);
		drink.setResizable(false);
	}

	private void addWorkoutButtonMouseReleased(MouseEvent e)
	{
		addWorkout wout = new addWorkout();
		wout.setVisible(true);
		wout.setResizable(false);
	}


	private void addSleepButtonMouseReleased(MouseEvent e)
	{
		addSleep sw = new addSleep();
		sw.setVisible(true);
		sw.setResizable(false);
	}

	private void addMealButtonMouseReleased(MouseEvent e)
	{
		addMeal mw = new addMeal();
		mw.setVisible(true);
		mw.setResizable(false);

	}

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
		exersizePanel = new JPanel();
		addWorkoutButton = new JButton();
		caloriePanel = new JPanel();
		addMealButton = new JButton();
		sleepPanel = new JPanel();
		addSleepButton = new JButton();
		waterPanel = new JPanel();
		addDrinkButton = new JButton();
		ammountDrankLabel = new JLabel();
		goalLabel = new JLabel();
		leftLabel = new JLabel();
		drankFeild = new JTextField();
		goalField = new JTextField();
		leftField = new JTextField();

		//======== this ========
		setTitle("FitTrack");
		Container contentPane = getContentPane();

		//======== tabbedPane1 ========
		{

			//======== homePanel ========
			{

				// JFormDesigner evaluation mark
				homePanel.setBorder(new javax.swing.border.CompoundBorder(
					new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
						"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
						javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
						java.awt.Color.red), homePanel.getBorder())); homePanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


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

				GroupLayout homePanelLayout = new GroupLayout(homePanel);
				homePanel.setLayout(homePanelLayout);
				homePanelLayout.setHorizontalGroup(
					homePanelLayout.createParallelGroup()
						.addGroup(homePanelLayout.createSequentialGroup()
							.addGap(22, 22, 22)
							.addGroup(homePanelLayout.createParallelGroup()
								.addComponent(homeLabel)
								.addComponent(homeSubLabel)
								.addGroup(homePanelLayout.createSequentialGroup()
									.addComponent(loginButton)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(createAccButton)))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
							.addGroup(homePanelLayout.createParallelGroup()
								.addComponent(iconLabel, GroupLayout.Alignment.TRAILING)
								.addComponent(logoutButton, GroupLayout.Alignment.TRAILING))
							.addGap(29, 29, 29))
				);
				homePanelLayout.setVerticalGroup(
					homePanelLayout.createParallelGroup()
						.addGroup(homePanelLayout.createSequentialGroup()
							.addGroup(homePanelLayout.createParallelGroup()
								.addGroup(homePanelLayout.createSequentialGroup()
									.addGap(29, 29, 29)
									.addComponent(homeLabel)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(homeSubLabel)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE))
								.addGroup(GroupLayout.Alignment.TRAILING, homePanelLayout.createSequentialGroup()
									.addContainerGap(11, Short.MAX_VALUE)
									.addComponent(iconLabel, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
							.addGroup(homePanelLayout.createParallelGroup()
								.addGroup(homePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(loginButton)
									.addComponent(createAccButton))
								.addComponent(logoutButton))
							.addContainerGap())
				);
			}
			tabbedPane1.addTab("Home", homePanel);

			//======== exersizePanel ========
			{

				//---- addWorkoutButton ----
				addWorkoutButton.setText("Add Workout");
				addWorkoutButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						addWorkoutButtonMouseReleased(e);
					}
				});

				GroupLayout exersizePanelLayout = new GroupLayout(exersizePanel);
				exersizePanel.setLayout(exersizePanelLayout);
				exersizePanelLayout.setHorizontalGroup(
					exersizePanelLayout.createParallelGroup()
						.addGroup(exersizePanelLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(addWorkoutButton)
							.addContainerGap(425, Short.MAX_VALUE))
				);
				exersizePanelLayout.setVerticalGroup(
					exersizePanelLayout.createParallelGroup()
						.addGroup(exersizePanelLayout.createSequentialGroup()
							.addContainerGap(305, Short.MAX_VALUE)
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

				GroupLayout caloriePanelLayout = new GroupLayout(caloriePanel);
				caloriePanel.setLayout(caloriePanelLayout);
				caloriePanelLayout.setHorizontalGroup(
					caloriePanelLayout.createParallelGroup()
						.addGroup(caloriePanelLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(addMealButton)
							.addContainerGap(448, Short.MAX_VALUE))
				);
				caloriePanelLayout.setVerticalGroup(
					caloriePanelLayout.createParallelGroup()
						.addGroup(GroupLayout.Alignment.TRAILING, caloriePanelLayout.createSequentialGroup()
							.addContainerGap(305, Short.MAX_VALUE)
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

				GroupLayout sleepPanelLayout = new GroupLayout(sleepPanel);
				sleepPanel.setLayout(sleepPanelLayout);
				sleepPanelLayout.setHorizontalGroup(
					sleepPanelLayout.createParallelGroup()
						.addGroup(sleepPanelLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(addSleepButton)
							.addContainerGap(444, Short.MAX_VALUE))
				);
				sleepPanelLayout.setVerticalGroup(
					sleepPanelLayout.createParallelGroup()
						.addGroup(GroupLayout.Alignment.TRAILING, sleepPanelLayout.createSequentialGroup()
							.addContainerGap(305, Short.MAX_VALUE)
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

				//---- drankFeild ----
				drankFeild.setEditable(false);

				//---- goalField ----
				goalField.setEditable(false);

				//---- leftField ----
				leftField.setEditable(false);

				GroupLayout waterPanelLayout = new GroupLayout(waterPanel);
				waterPanel.setLayout(waterPanelLayout);
				waterPanelLayout.setHorizontalGroup(
					waterPanelLayout.createParallelGroup()
						.addGroup(waterPanelLayout.createSequentialGroup()
							.addGap(56, 56, 56)
							.addGroup(waterPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(goalField, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
								.addGroup(waterPanelLayout.createSequentialGroup()
									.addGroup(waterPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addComponent(addDrinkButton)
										.addComponent(leftLabel)
										.addComponent(goalLabel)
										.addComponent(ammountDrankLabel))
									.addGroup(waterPanelLayout.createParallelGroup()
										.addGroup(waterPanelLayout.createSequentialGroup()
											.addGap(40, 40, 40)
											.addComponent(drankFeild, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
										.addGroup(GroupLayout.Alignment.TRAILING, waterPanelLayout.createSequentialGroup()
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(leftField, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)))))
							.addContainerGap(96, Short.MAX_VALUE))
				);
				waterPanelLayout.setVerticalGroup(
					waterPanelLayout.createParallelGroup()
						.addGroup(GroupLayout.Alignment.TRAILING, waterPanelLayout.createSequentialGroup()
							.addGap(64, 64, 64)
							.addGroup(waterPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(ammountDrankLabel)
								.addComponent(drankFeild, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18, 18, 18)
							.addGroup(waterPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(goalLabel)
								.addComponent(goalField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18, 18, 18)
							.addGroup(waterPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(leftLabel)
								.addComponent(leftField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18, 18, 18)
							.addComponent(addDrinkButton)
							.addContainerGap(115, Short.MAX_VALUE))
				);
			}
			tabbedPane1.addTab("Water", waterPanel);
		}

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(tabbedPane1)
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(tabbedPane1)
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Colin Beatty
	private JTabbedPane tabbedPane1;
	private JPanel homePanel;
	private JLabel homeLabel;
	private JLabel homeSubLabel;
	private JButton loginButton;
	private JButton createAccButton;
	private JLabel iconLabel;
	private JButton logoutButton;
	private JPanel exersizePanel;
	private JButton addWorkoutButton;
	private JPanel caloriePanel;
	private JButton addMealButton;
	private JPanel sleepPanel;
	private JButton addSleepButton;
	private JPanel waterPanel;
	private JButton addDrinkButton;
	private JLabel ammountDrankLabel;
	private JLabel goalLabel;
	private JLabel leftLabel;
	private JTextField drankFeild;
	private JTextField goalField;
	private JTextField leftField;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
