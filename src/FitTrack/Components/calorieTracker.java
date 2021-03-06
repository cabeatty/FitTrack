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

	public static void setTodaysCal()
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String todaysDate = df.format(date);

		for (String st : meals)
		{
			String[] tempSp = st.split(" ");
			if( tempSp[1].equals(todaysDate) )
			{
				System.out.println("Loaded meal: " + st);
				calories = calories + Double.parseDouble( tempSp[6] );
			}
		}
	}

	public static String getTotal()
	{
		double rCal = calories;
		rCal = Math.round(rCal * 100);
		rCal = rCal/100;
		return Double.toString(rCal);
	}

	public static String getTarget()
	{
		//height/weight conversion, for accuracy
		String[] arr =String.valueOf(height).split("\\.");
		int[] intArr = new int[2];
		intArr[0] = Integer.parseInt(arr[0]);
		intArr[1] = Integer.parseInt(arr[1]);

		double adjHeight = 2.54 * ( ( intArr[0]*12 ) + intArr[1] );
		double adjWeight = (weight/2.2);

		if(gender.equalsIgnoreCase("male"))
		{
			BMR = (66 + (13.75 * adjWeight) + (5 * adjHeight) - (6.75 * age)) * 1.2;  //calculation of calories available in a day for a man

		}
		else
		{
			BMR = (655.1 + (9.56 * adjWeight) + (1.84 * adjHeight) - (4.67 * age)) * 1.2;  //calculation of calories available in a day for a woman
		}


		double rBMR = Math.round(BMR * 100);
		rBMR = rBMR/100;
		return Double.toString(rBMR);
	}

	public static String getDiff()
	{
		double total = BMR - calories;
		total = Math.round(total * 100);
		total = total/100;
		return Double.toString(total);
	}

	public static void addMeal(double cal)
	{
		if( cal >= 0 && cal <= 3500)
		{
			calories += cal;
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
			Date date = new Date();
			String mealData = "Date: " + df.format(date).toString() + " | Calories eaten: " + cal;
			meals.add(mealData);
		}
	}

	public static void restCal()  //For testing only
	{
		calories = 0;
	}

	public static ArrayList<String> getMealHistory()
	{
		return meals;
	}

	public static void setMealHistory(ArrayList<String> mealHistory)
	{
		meals = mealHistory;
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