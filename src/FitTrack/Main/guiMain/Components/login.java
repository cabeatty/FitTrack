/*
 * Created by JFormDesigner on Mon Nov 07 16:27:15 EST 2016
 */

package FitTrack.Main.guiMain.Components;

import FitTrack.Components.User;
import FitTrack.Data.loadUserData;
import FitTrack.Main.guiMain.Utilities.fieldChecks;
import FitTrack.Main.guiMain.Display;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Colin Beatty
 */
public class login extends JFrame
{
	public login()
	{
		initComponents();
	}

	private void loginButtonMouseReleased(MouseEvent e)
	{
		JTextField[] fieldsArr = {uNameField, pWordField};
		if ( fieldChecks.empty( fieldsArr ) )
		{
			String uName = uNameField.getText();
			String pWord = pWordField.getText();
			User ent = loadUserData.checkLoad(uName, pWord);

			if (ent != null)
			{
				Display.usr = ent;
				Display.LOGGEDINFLAG = true;
				Display.NEWUSER = false;
				Display.updateLoginStatus();
				this.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Incorrect username or password.");
				pWordField.setText("");
				uNameField.setText("");
			}
		}
		else JOptionPane.showMessageDialog(this, "Fill in fields to login");
	}

	private void cancelButtonMouseReleased(MouseEvent e)
	{
		this.dispose();
	}

	private void initComponents()
	{
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Colin Beatty
		uNameLabel = new JLabel();
		uNameField = new JTextField();
		pWordLabel = new JLabel();
		pWordField = new JPasswordField();
		loginButton = new JButton();
		cancelButton = new JButton();

		//======== this ========
		setTitle("Login");
		Container contentPane = getContentPane();

		//---- uNameLabel ----
		uNameLabel.setText("Username");

		//---- pWordLabel ----
		pWordLabel.setText("Password");

		//---- loginButton ----
		loginButton.setText("Login");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				loginButtonMouseReleased(e);
			}
		});

		//---- cancelButton ----
		cancelButton.setText("Cancel");
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
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
						.addComponent(uNameField)
						.addComponent(pWordField, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
						.addComponent(uNameLabel)
						.addComponent(pWordLabel)
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(loginButton)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(cancelButton)))
					.addContainerGap())
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(17, 17, 17)
					.addComponent(uNameLabel)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(uNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(pWordLabel)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(pWordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(loginButton)
						.addComponent(cancelButton))
					.addContainerGap())
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Colin Beatty
	private JLabel uNameLabel;
	private JTextField uNameField;
	private JLabel pWordLabel;
	private JPasswordField pWordField;
	private JButton loginButton;
	private JButton cancelButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables

}
