/*
 * Created by JFormDesigner on Tue Nov 08 21:54:02 EST 2016
 */

package jFrame.main.Water;

import jFrame.Utilities.fieldChecks;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Colin Beatty
 */
public class addDrink extends JFrame
{
	public addDrink()
	{
		initComponents();
	}

	private void addButtonMouseReleased(MouseEvent e)
	{
		JTextField[] fieldsArr = {inputField};
		if(fieldChecks.empty(fieldsArr))
		{
			JOptionPane.showMessageDialog(this, "Drink added");
			this.dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "You have to fill in the field to add a drink.");
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
		addButton = new JButton();
		cancelButton = new JButton();
		descLabel = new JLabel();
		inputField = new JTextField();

		//======== this ========
		setTitle("Add Drink");
		Container contentPane = getContentPane();

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

		//---- descLabel ----
		descLabel.setText("Type in ammount drank in ml and click Add");
		descLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
								.addComponent(inputField, GroupLayout.Alignment.LEADING)
								.addComponent(descLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addContainerGap(9, Short.MAX_VALUE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(addButton)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
							.addComponent(cancelButton)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(descLabel)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(inputField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
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
	private JButton addButton;
	private JButton cancelButton;
	private JLabel descLabel;
	private JTextField inputField;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
