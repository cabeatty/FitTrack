/*
 * Created by JFormDesigner on Wed Nov 23 12:50:29 EST 2016
 */

package FitTrack.Main.guiMain.Components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Colin Beatty
 */
public class sleepMapper extends JFrame {
	public sleepMapper() {
		initComponents();
	}

	private void exitButtonMouseReleased(MouseEvent e) {
		this.dispose();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Colin Beatty
		exitButton = new JButton();
		scrollPane1 = new JScrollPane();

		//======== this ========
		setTitle("Sleep Trend");
		Container contentPane = getContentPane();

		//---- exitButton ----
		exitButton.setText("Exit");
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				exitButtonMouseReleased(e);
			}
		});

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(0, 525, Short.MAX_VALUE)
							.addComponent(exitButton)))
					.addContainerGap())
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(exitButton)
					.addContainerGap())
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Colin Beatty
	private JButton exitButton;
	private JScrollPane scrollPane1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
