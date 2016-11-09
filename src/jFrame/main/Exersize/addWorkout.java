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
		JTextField[] fieldsArr = { timeField };
		JComboBox[] boxesArr = { intensityBox, typeBox };
		if ( fieldChecks.empty(fieldsArr) &&  fieldChecks.boxSelected(boxesArr))
		{
			//TODO add an exersize
			JOptionPane.showMessageDialog(this, "Workout added.");
			this.dispose();
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
		intensityBox = new JComboBox<>();
		workoutType = new JLabel();
		timeLabel = new JLabel();
		timeField = new JTextField();
		addButton = new JButton();
		label1 = new JLabel();
		typeBox = new JComboBox<>();
		cancelButton = new JButton();

		//======== this ========
		setTitle("Add Workout");
		Container contentPane = getContentPane();

		//---- intensityBox ----
		intensityBox.setModel(new DefaultComboBoxModel<>(new String[] {
			" ",
			"High",
			"Medium",
			"Low"
		}));

		//---- workoutType ----
		workoutType.setText("Select workout type");

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

		//---- label1 ----
		label1.setText("Select intensity");

		//---- typeBox ----
		typeBox.setModel(new DefaultComboBoxModel<>(new String[] {
			" ",
			"Cardio",
			"Muscle Building"
		}));

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
						.addComponent(timeLabel, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
						.addComponent(timeField, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(addButton)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
							.addComponent(cancelButton))
						.addComponent(typeBox, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
						.addComponent(intensityBox, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
						.addComponent(workoutType, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
						.addComponent(label1, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
					.addContainerGap())
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(16, 16, 16)
					.addComponent(workoutType)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(typeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(label1)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(intensityBox, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(timeLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(timeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
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
	private JComboBox<String> intensityBox;
	private JLabel workoutType;
	private JLabel timeLabel;
	private JTextField timeField;
	private JButton addButton;
	private JLabel label1;
	private JComboBox<String> typeBox;
	private JButton cancelButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
