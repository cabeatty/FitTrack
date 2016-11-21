package FitTrack.Components;

import jFrame.main.Exersize.addWorkout;
import jFrame.main.Display;

import javax.swing.*;

/**
 * Created by Patrick on 02/11/16.
 */
public class exersizeTracker
{

	public static int totalTime;

	public static int addExerciseTime(int time)
	{
		totalTime += time;
		return totalTime;
	}


	public static String getWorkoutType()
	{
		return "Cardio";
	}

	public static String getIntensity()
	{
		return "Medium";
	}

	public void determineExercise()
	{

		if (totalTime <30)
		{

		}

	}

}