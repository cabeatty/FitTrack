/*
 * Created by JFormDesigner on Wed Nov 09 12:47:26 EST 2016
 */

package jFrame.main.Exersize;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import jFrame.Utilities.fieldChecks;

/**
 * @author Colin Beatty
 */
public class addWorkout extends JFrame
{
	public addWorkout()
	{
		initComponents();
	}

	private void addButtonMouseReleased(MouseEvent e)
	{
		JTextField[] fieldsArr = { bpmField, timeField };
		if ( fieldChecks.empty(fieldsArr) )
		{
			try
			{
				int bpm = Integer.parseInt(bpmField.getText());
				int time = Integer.parseInt(timeField.getText());
				//JOptionPane.showMessageDialog(this, "Workout added.");
				this.dispose();
			}
			catch (Exception ex)
			{
				JOptionPane.showMessageDialog(this, "Input must be a number.");
				bpmField.setText("");
				timeField.setText("");
			}
		}
		else JOptionPane.showMessageDialog(this, "Fill in all fields and boxes to add a workout.");
	}

	private void cancelButtonMouseReleased(MouseEvent e)
	{
		this.dispose();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Colin Beatty
		bpmLabel = new JLabel();
		timeLabel = new JLabel();
		timeField = new JTextField();
		addButton = new JButton();
		cancelButton = new JButton();
		bpmField = new JTextField();

		//======== this ========
		setTitle("Add Workout");
		Container contentPane = getContentPane();

		//---- bpmLabel ----
		bpmLabel.setText("Heart Rate (In BPM)");

		//---- timeLabel ----
		timeLabel.setText("Duration? (In minutes)");

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
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(addButton)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
							.addComponent(cancelButton))
						.addComponent(bpmLabel, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
						.addComponent(timeLabel, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
						.addComponent(timeField, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
						.addComponent(bpmField, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
					.addContainerGap())
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(bpmLabel)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(bpmField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(timeLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(timeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(28, 28, 28)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(addButton)
						.addComponent(cancelButton))
					.addContainerGap(4, Short.MAX_VALUE))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Colin Beatty
	private JLabel bpmLabel;
	private JLabel timeLabel;
	private JTextField timeField;
	private JButton addButton;
	private JButton cancelButton;
	private JTextField bpmField;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
