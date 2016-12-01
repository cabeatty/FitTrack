package FitTrack.Components;

import FitTrack.Main.guiMain.Utilities.getDate;
import java.util.ArrayList;

/**
 * Created by colin on 02/11/16.
 */
public class sleepTracker
{
	private static ArrayList<sleep> sleepHistory;

	public sleepTracker ()
	{
		sleepHistory = new ArrayList<sleep>();
	}

	public static ArrayList<sleep> getSleepHistory()
	{
		return sleepHistory;
	}

	public void setSleepHistory(ArrayList<sleep> sleepHistory)
	{
		this.sleepHistory = sleepHistory;
	}

	public void addTo(sleep sleepData)
	{
		int todaysTotal = sleepData.getHours();
		boolean exists = false;

		for (sleep slp : sleepHistory)
		{
			if (slp.getDf().equals(sleepData.getDf()))
			{
				exists = true;
				slp.setHours(slp.getHours() + todaysTotal);
			}
		}
		if(!exists)
		{
			sleepHistory.add(sleepData);
		}
	}

	public void addSleepHistory(sleep sleepData)
	{
		addTo(sleepData);
	}

	public static boolean tooManyHours(sleep input)
	{
		int total = input.getHours();
		boolean flag = false;

		for (sleep slp : sleepHistory)
		{
			if (slp.getDf().equals(input.getDf()))
				total += slp.getHours();
		}
		if(total >= 24)
			flag = true;

		return flag;
	}

	@Override
	public String toString()
	{
		String hist = "";
		for(sleep slp : sleepHistory)
		{
			hist += slp.toString() + "\n";
		}

		return  hist;
	}




}
