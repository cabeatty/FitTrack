package FitTrack.Main;

import FitTrack.Main.guiMain.Display;

import javax.swing.*;

/**
 * Created by colin on 07/11/16.
 */

public class Boot
{
	public static void main(String[] args)
	{
		setLookAndFeel();
		Display view = new Display();
		view.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		view.setResizable(false);
		view.setVisible(true);
	}

	private static void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
