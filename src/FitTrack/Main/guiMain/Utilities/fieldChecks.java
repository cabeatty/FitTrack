package FitTrack.Main.guiMain.Utilities;

import javax.swing.*;

/**
 * Created by colin on 07/11/16.
 */
public class fieldChecks
{

	public static boolean empty(JTextField[] list) //accepts lists of JTextFields, returns T if they are all nonempty
	{
		try
		{
			for (JTextField index : list)
			{
				if (index.getText().equals(""))
				{
					return false;
				}
			}

			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static boolean equal(JTextField a, JTextField b)
	{
		if (a.getText().equals(b.getText()))
		{
			return true;
		}

		return false;
	}

	public static boolean boxSelected( JComboBox[] boxes )
	{
		for (JComboBox box : boxes)
		{
			if ( box.getSelectedItem().toString().equals(" ") )
			{
				return false;
			}
		}
		return true;
	}
}
