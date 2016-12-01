/*
 * Created by JFormDesigner on Wed Nov 09 13:22:18 EST 2016
 */

package FitTrack.Main.guiMain.Components;

import FitTrack.Components.sleep;
import FitTrack.Data.sleepDb;
import FitTrack.Main.guiMain.Utilities.fieldChecks;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import FitTrack.Main.guiMain.Display;
import FitTrack.Main.guiMain.Utilities.getDate;

/**
 * @author Colin Beatty
 */
public class addSleep extends JFrame
{
	public addSleep()
	{
		initComponents();
	}

	private void addButtonMouseReleased(MouseEvent e)
	{
		JTextField[] fieldsArr = { sleepField };

		if (fieldChecks.empty(fieldsArr))
		{
			try
			{
				int hours = Integer.parseInt(sleepField.getText());
				sleep ipSlp = new sleep(getDate.getTodaysDate(), hours);

				if (!Display.sleepTrk.tooManyHours(ipSlp))
				{
					Display.sleepTrk.addSleepHistory(ipSlp);
					this.dispose();
					Display.populateSleepField();
				}
				else
				{
					JOptionPane.showMessageDialog(this, "You can't sleep more than 24 hours in a day.");
				}
			}
			catch (Exception exc)
			{
				JOptionPane.showMessageDialog(this, "Input must be a whole number.");
				sleepField.setText("");
			}
		}
		else JOptionPane.showMessageDialog(this, "Fill in the fields to add sleep.");

	}

	private void cancelButtonMouseReleased(MouseEvent e)
	{
		this.dispose();
	}

	private void initComponents()
	{
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Colin Beatty
		hoursLabel = new JLabel();
		sleepField = new JTextField();
		addButton = new JButton();
		cancelButton = new JButton();

		//======== this ========
		setTitle("Add Sleep");
		Container contentPane = getContentPane();

		//---- hoursLabel ----
		hoursLabel.setText("How  many hours did you sleep?");

		//---- addButton ----
		addButton.setText("Add");
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				addButtonMouseReleased(e);
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
						.addComponent(hoursLabel, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
						.addComponent(sleepField, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(addButton)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
							.addComponent(cancelButton)))
					.addContainerGap())
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(hoursLabel)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(sleepField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(addButton)
						.addComponent(cancelButton))
					.addContainerGap())
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Colin Beatty
	private JLabel hoursLabel;
	private JTextField sleepField;
	private JButton addButton;
	private JButton cancelButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
