package FitTrack.Main;

import jFrame.main.Display;

import javax.swing.*;

/**
 * Created by colin on 07/11/16.
 */

public class Boot
{
	public static void main(String[] args)
	{
		Display view = new Display();
		view.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		view.setResizable(false);
		view.setVisible(true);
	}
}
