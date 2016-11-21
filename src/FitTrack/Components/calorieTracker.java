package FitTrack.Components;

import com.sun.imageio.plugins.bmp.BMPImageReader;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by colin on 02/11/16.
 */
public class calorieTracker
{

	//Global variables to be accessed throughout the class
	//variable used to hold the total calories allowed
	private static double BMR;
	//Hold entered calories
	private static double calories;

	//Holds information that is passed in from the user class
	private static int weight;
	private static double height;
	private static int age;
	private static String gender;

	private static ArrayList<String> meals = new ArrayList<String>();

	public calorieTracker (User usr)
	{
		calories  = 0;
		weight = usr.getWeight();
		height = usr.getHeight();
		age = usr.getAge();
		gender = usr.getSex();
	}

	public static String getTotal()
	{
		return Double.toString(calories);
	}

	public static String getTarget()
	{
		if(gender.equalsIgnoreCase("male"))
		{
			BMR = 66 + (6.2 * weight) + (12.7 * height) - (6.76 * age);  //calculation of calories available in a day for a man
			return Double.toString(BMR);
		}
		else
		{
			BMR = 655.1 + (4.35 * weight) + (4.7 * height) - (4.7 * age);  //calculation of calories available in a day for a woman
			return Double.toString(BMR);
		}
	}

	public static String getDiff()
	{
		double total = BMR - calories;
		return Double.toString(total);
	}

	public static void addMeal(double cal)
	{
		calories += cal;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm ");
		Date date = new Date();
		String mealData = df.format(date).toString() + " : " + cal + " calories eaten.";
		meals.add(mealData);
	}

	public static ArrayList<String> getMeals()
	{
		return meals;
	}

	@Override
	public String toString()
	{
		String mls = "";
		for (String temp : meals)
		{
			mls += temp + "\n";
		}
		return mls;
	}

}