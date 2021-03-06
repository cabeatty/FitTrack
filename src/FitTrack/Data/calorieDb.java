package FitTrack.Data;

import FitTrack.Components.User;
import FitTrack.Main.guiMain.Display;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by colin on 02/12/16.
 */
public class calorieDb
{
	private static User usr;
	public static BufferedWriter writer;
	public static BufferedReader reader;
	public static ArrayList<String> mealData = new ArrayList<String>();

	public static void saveMeals()
	{
		try
		{
			usr = Display.usr;
			mealData.clear();
			writer = new BufferedWriter(new FileWriter("src/resources/" + usr.getuName() + "meals.txt"));
			String data = "";
			mealData = Display.calTrk.getMealHistory();
			for (String wout : mealData)
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

	public static ArrayList<String> loadMeals()
	{
		usr = Display.usr;
		ArrayList<String> tempMeal = new ArrayList<String>();
		try
		{
			reader = new BufferedReader(new FileReader("src/resources/" + usr.getuName() + "meals.txt"));
			String temp;
			while( ( temp = reader.readLine() ) != null)
			{
				tempMeal.add(temp);
			}
			reader.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return tempMeal;
	}

	public static void reset()
	{
		mealData.clear();
	}

}
