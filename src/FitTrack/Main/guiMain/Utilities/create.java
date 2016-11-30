package FitTrack.Main.guiMain.Utilities;

import javax.swing.*;
import FitTrack.Components.User;

/**
 * Created by colin on 10/11/16.
 */
public class create
{
	public static User createAccount(JTextField name, JComboBox gender, JTextField age, JTextField weight, JTextField height,
	                                 JTextField email, JTextField password)
	{
		String nam = name.getText();
		String gen = gender.getSelectedItem().toString().trim();
		int ag = Integer.parseInt(age.getText().trim());
		int wei = Integer.parseInt(weight.getText().trim());
		double hei = Double.parseDouble(height.getText().trim());
		String ema = email.getText().trim();
		String pass = password.getText().trim();

		User newUser = new User(nam, gen, ag, wei, hei, ema, pass);
		return newUser;
	}
}
