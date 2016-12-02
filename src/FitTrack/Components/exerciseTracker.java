package FitTrack.Components;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Patrick on 02/11/16.
 */
public class exerciseTracker
{
	private static ArrayList<String> workoutData = new ArrayList<String>();
	private static User user;
	private static int weight;
	private static int age;
	private static String gender;
	private static double totalBurn = 0;

	public exerciseTracker(User user)
	{
		this.user = user;
		weight = user.getWeight();
		age = user.getAge();
		gender = user.getSex();
	}

	public static void addExercise(int bpm, int time)
	{
		double calBurn;
		if (bpm >= 60 && bpm <= 220  && time >= 0 && time <= 1440)
		{
			if (gender.equalsIgnoreCase("male"))
			{
				calBurn = ((age * 0.2017) - (weight * 0.09036) + (bpm * 0.6309) - 55.0969) * time / 4.184;
			}
			else
			{
				calBurn = ((age * 0.074) - (weight * 0.05741) + (bpm * 0.4472) - 20.4022) * time / 4.184;
			}

			//code to round the double up to two decimal places
			calBurn = Math.round(calBurn * 100);
			calBurn = calBurn / 100;
			addTotalBurn(calBurn);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			String exercise = "Date: " + df.format(date).toString() + " | Duration: " + time + " min | Calories burnt: " + calBurn;
			workoutData.add(exercise);
		}
	}

	public static ArrayList<String> getWorkoutData()
	{
		return workoutData;
	}

	public static void setWorkoutHistory(ArrayList<String> ipArr)
	{
		workoutData = ipArr;
	}

	public static double getTotalBurn()
	{
		return totalBurn;
	}

	public static void addTotalBurn(double val)
	{
		totalBurn = totalBurn + val;
	}

	public static void setTotalBurn(double val)
	{
		totalBurn = val;
	}

	@Override
	public String toString()
	{
		String temp = "";

		for (String ind : workoutData)
		{
			temp += ind + "\n";
		}

		return temp;
	}

}