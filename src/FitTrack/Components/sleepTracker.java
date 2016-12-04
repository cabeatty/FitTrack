package FitTrack.Components;

import FitTrack.Main.guiMain.Utilities.getDate;
import java.util.ArrayList;

import static FitTrack.Main.guiMain.Utilities.getDate.getTodaysDate;

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

		if (todaysTotal <= 24 && todaysTotal >= 0)
		{
			for (sleep slp : sleepHistory)
			{
				if (slp.getDf().equals(sleepData.getDf()))
				{
					exists = true;
					if (slp.getHours() + todaysTotal <= 24)
					{
						slp.setHours(slp.getHours() + todaysTotal);
					}
				}
			}
			if (!exists)
			{
				sleepHistory.add(sleepData);
			}
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

	public static int getHours()
	{
		int total = 0;
		for (sleep slp : sleepHistory)
		{
			if (slp.getDf().equals(getTodaysDate()))
				total += slp.getHours();
		}
		return total;
	}

	public static void reset()
	{
		sleepHistory.clear();
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
