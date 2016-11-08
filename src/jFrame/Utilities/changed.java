package jFrame.Utilities;

import javax.swing.*;

/**
 * Created by colin on 07/11/16.
 */
public class changed
{
	public static void changed(JFrame frame, JButton button, JTextField[] list)
	{
		boolean flag = false;

		for (JTextField index : list)
		{
			if (index.getText().equals(""))
			{
				flag = false;
			}
		}

		if(flag == false)
		{
			JOptionPane.showMessageDialog(frame, "Fill in all of the fields to create an account.");
			button.setEnabled(false);
		}

		else
		{
			button.setEnabled(true);
		}
	}
}
