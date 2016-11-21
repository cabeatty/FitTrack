/*
 * Created by JFormDesigner on Wed Nov 09 13:21:59 EST 2016
 */

package jFrame.main.Calories;

import jFrame.Utilities.fieldChecks;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Colin Beatty
 */
public class addMeal extends JFrame
{
	public addMeal()
	{
		initComponents();
	}

	private void addButtonMouseReleased(MouseEvent e)
	{
		JTextField[] fieldsArr = { calorieField };

		if ( fieldChecks.empty(fieldsArr) )
		{
			JOptionPane.showMessageDialog(this, "Meal added.");
			this.dispose();
		}
	}

	private void cancelButtonMouseReleased(MouseEvent e)
	{
		this.dispose();
	}

	private void initComponents()
	{
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Colin Beatty
		mealLabel = new JLabel();
		calorieField = new JTextField();
		addButton = new JButton();
		cancelButton = new JButton();

		//======== this ========
		setTitle("Add Meal");
		Container contentPane = getContentPane();

		//---- mealLabel ----
		mealLabel.setText("Number of calories");

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
						.addComponent(calorieField, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(mealLabel)
							.addGap(0, 0, Short.MAX_VALUE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(addButton)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
							.addComponent(cancelButton)))
					.addContainerGap())
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(mealLabel)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(calorieField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(addButton)
						.addComponent(cancelButton))
					.addContainerGap(3, Short.MAX_VALUE))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Colin Beatty
	private JLabel mealLabel;
	private JTextField calorieField;
	private JButton addButton;
	private JButton cancelButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
