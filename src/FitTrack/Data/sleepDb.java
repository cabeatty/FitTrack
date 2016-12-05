package FitTrack.Data;

import FitTrack.Components.User;
import FitTrack.Components.sleep;
import FitTrack.Components.sleepTracker;
import FitTrack.Main.guiMain.Display;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by colin on 30/11/16.
 */
public class sleepDb
{
	private static User usr;
	public static BufferedWriter writer;
	public static BufferedReader reader;
	public static ArrayList<sleep> sleepData = new ArrayList<sleep>();

	public static void saveSleep()
	{
		try
		{
			usr = Display.usr;
			sleepData.clear();
			writer = new BufferedWriter(new FileWriter("src/resources/" + usr.getuName() + "sleep.txt"));
			String data = "";
			sleepData = Display.sleepTrk.getSleepHistory();
			for (sleep sl : sleepData)
			{
				data += sl.toString() + "\n";
			}
			writer.write(data);
			writer.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static ArrayList<sleep> loadSleep()
	{
		ArrayList<sleep> tempSlp = new ArrayList<sleep>();
		usr = Display.usr;
		try
		{
			reader = new BufferedReader(new FileReader("src/resources/" + usr.getuName() + "sleep.txt"));
			String temp;
			while( ( temp = reader.readLine() ) != null)
			{
				String[] data = temp.split(" ");
				sleep slp = new sleep(data[0],Integer.parseInt(data[2]));
				tempSlp.add(slp);
			}
			reader.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return tempSlp;
	}

	public static void reset()
	{
		sleepData.clear();
	}

}
