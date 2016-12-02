package FitTrack.Data;

import FitTrack.Components.User;
import FitTrack.Main.guiMain.Display;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Created by colin on 02/12/16.
 */
public class workoutDb
{
	private static User usr;
	public static BufferedWriter writer;
	public static BufferedReader reader;
	public static ArrayList<String> workoutData = new ArrayList<String>();

	public static void saveWorkout()
	{
		try
		{
			usr = Display.usr;
			workoutData.clear();
			writer = new BufferedWriter(new FileWriter("src/resources/" + usr.getuName() + "workout.txt"));
			String data = "";
			workoutData = Display.excTrk.getWorkoutData();
			for (String wout : workoutData)
			{
				data += wout + "\n";
			}
			writer.write(data);
			writer.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static ArrayList<String> loadWorkout()
	{
		usr = Display.usr;
		ArrayList<String> tempWout = new ArrayList<String>();
		try
		{
			reader = new BufferedReader(new FileReader("src/resources/" + usr.getuName() + "workout.txt"));
			String temp;
			while( ( temp = reader.readLine() ) != null)
			{
				tempWout.add(temp);
			}
			reader.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return tempWout;
	}

}