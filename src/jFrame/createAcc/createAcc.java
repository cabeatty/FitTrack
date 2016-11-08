/*
 * Created by JFormDesigner on Mon Nov 07 16:40:33 EST 2016
 */
/**
 * @author Colin Beatty
 */

package jFrame.createAcc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

//Local imports
import FitTrack.Components.User;
import jFrame.Utilities.changed;

public class createAcc extends JFrame
{
	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Colin Beatty
	private JLabel unameLabel;
	private JTextField uNameField;
	private JLabel genderLabel;
	private JComboBox<String> genderComboBox;
	private JLabel ageLabel;
	private JTextField ageField;
	private JLabel weightLabel;
	private JTextField weightField;
	private JLabel heightLabel;
	private JTextField heightField;
	private JLabel emailLabel1;
	private JTextField emailField1;
	private JLabel emailLabel2;
	private JTextField emailField2;
	private JLabel pWordLabel1;
	private JPasswordField passwordField1;
	private JLabel pWordLabel2;
	private JPasswordField passwordField2;
	private JButton createAccButton;
	private JButton cancelButton;

	//Non-generated env variables;
	String username, gender, age, weight, height, email, password;
	//JTextField[] fieldsArr = {uNameField, ageField, weightField, heightField, emailField1, emailField2, passwordField1, passwordField2};

	public createAcc()
	{
		initComponents();
	}

	public void changed()
	{
		if (
				uNameField.getText().equals("") && ageField.getText().equals("") && weightField.getText().equals("") &&
						heightField.getText().equals("") && emailField1.getText().equals("") && emailField2.getText().equals("") &&
						passwordField1.getText().equals("") && passwordField2.getText().equals("")
				)
		{
			createAccButton.setEnabled(false);
			JOptionPane.showMessageDialog(this, "Fill in all of the fields to create an account.");
		}
		else
		{
			if (passwordField1.getText().equals(passwordField2.getText()))
			{
				if (emailField1.getText().equals(emailField2.getText()))
				{
					username = uNameField.getText();
					gender = genderComboBox.getSelectedItem().toString();
					age = ageField.getText();
					weight = weightField.getText();
					height = heightField.getText();
					email = emailField1.getText();
					password = passwordField1.getText();

					createAccButton.setEnabled(true);

				}
				else
				{
					JOptionPane.showMessageDialog(this, "Emails don't match.");
				}

			}
			else
			{
				JOptionPane.showMessageDialog(this, "Passwords don't match.");
			}

		}

	}

	private void createAccButtonMouseReleased(MouseEvent e)
	{
		changed();


		username = uNameField.getText();
		gender = genderComboBox.getSelectedItem().toString();
		age = ageField.getText();
		weight = weightField.getText();
		height = heightField.getText();
		email = emailField1.getText();
		password = passwordField1.getText();

		User tempUser = new User(username, gender, Integer.parseInt(age), Integer.parseInt(weight), Double.parseDouble(height),
				email, password);

		tempUser.print();
		JOptionPane.showMessageDialog(this, "Account: " + username + " created!");
		this.dispose();


	}

	private void cancelButtonMouseReleased(MouseEvent e)
	{
		this.dispose();
	}

	private void initComponents()
	{
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Colin Beatty
		unameLabel = new JLabel();
		uNameField = new JTextField();
		genderLabel = new JLabel();
		genderComboBox = new JComboBox<>();
		ageLabel = new JLabel();
		ageField = new JTextField();
		weightLabel = new JLabel();
		weightField = new JTextField();
		heightLabel = new JLabel();
		heightField = new JTextField();
		emailLabel1 = new JLabel();
		emailField1 = new JTextField();
		emailLabel2 = new JLabel();
		emailField2 = new JTextField();
		pWordLabel1 = new JLabel();
		passwordField1 = new JPasswordField();
		pWordLabel2 = new JLabel();
		passwordField2 = new JPasswordField();
		createAccButton = new JButton();
		cancelButton = new JButton();

		//======== this ========
		setTitle("Create Account");
		Container contentPane = getContentPane();

		//---- unameLabel ----
		unameLabel.setText("Username");

		//---- genderLabel ----
		genderLabel.setText("Gender");

		//---- genderComboBox ----
		genderComboBox.setModel(new DefaultComboBoxModel<>(new String[]{
				"Male",
				"Female",
				"Other"
		}));

		//---- ageLabel ----
		ageLabel.setText("Age");

		//---- weightLabel ----
		weightLabel.setText("Weight (in lbs)");

		//---- heightLabel ----
		heightLabel.setText("Height (in ft.in)");

		//---- emailLabel1 ----
		emailLabel1.setText("Email");

		//---- emailLabel2 ----
		emailLabel2.setText("Email (Confirm)");

		//---- pWordLabel1 ----
		pWordLabel1.setText("Password");

		//---- pWordLabel2 ----
		pWordLabel2.setText("Password (Confirm)");

		//---- createAccButton ----
		createAccButton.setText("Create Account");
		createAccButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
				createAccButtonMouseReleased(e);
			}
		});

		//---- cancelButton ----
		cancelButton.setText("Cancel");
		cancelButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
				cancelButtonMouseReleased(e);
			}
		});

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
				contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(contentPaneLayout.createParallelGroup()
										.addComponent(genderComboBox)
										.addComponent(uNameField)
										.addComponent(weightField)
										.addComponent(ageField, GroupLayout.Alignment.TRAILING)
										.addComponent(emailField1)
										.addComponent(heightField)
										.addGroup(contentPaneLayout.createSequentialGroup()
												.addComponent(createAccButton)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(cancelButton))
										.addGroup(contentPaneLayout.createSequentialGroup()
												.addGroup(contentPaneLayout.createParallelGroup()
														.addComponent(unameLabel)
														.addComponent(genderLabel)
														.addComponent(ageLabel)
														.addComponent(weightLabel)
														.addComponent(heightLabel)
														.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
																.addComponent(passwordField1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
																.addComponent(emailLabel1, GroupLayout.Alignment.LEADING)
																.addComponent(emailLabel2, GroupLayout.Alignment.LEADING)
																.addComponent(emailField2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
														.addComponent(pWordLabel1)
														.addComponent(pWordLabel2)
														.addComponent(passwordField2, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE))
												.addGap(0, 0, Short.MAX_VALUE)))
								.addContainerGap())
		);
		contentPaneLayout.setVerticalGroup(
				contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(unameLabel)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(uNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(genderLabel)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(genderComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(ageLabel)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(ageField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(weightLabel)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(weightField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(heightLabel)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(heightField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(emailLabel1)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(emailField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(emailLabel2)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(emailField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(pWordLabel1)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(pWordLabel2)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(passwordField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
								.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(createAccButton)
										.addComponent(cancelButton))
								.addContainerGap())
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}


	//public JTextField[] fieldsArr = {uNameField, ageField, weightField, heightField, emailField1, emailField2, passwordField1, passwordField2 };
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
