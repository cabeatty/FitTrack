package FitTrack.Components;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 * Created by colin on 02/11/16.
 */
public class sleepTracker
{
	private ArrayList<sleep> sleepHistory;

	public sleepTracker ()
	{
		sleepHistory = new ArrayList<sleep>();
	}

	public ArrayList<sleep> getSleepHistory()
	{
		return sleepHistory;
	}

	public void setSleepHistory(ArrayList<sleep> sleepHistory)
	{
		this.sleepHistory = sleepHistory;
	}

	public void addSleepHistory(int hours)
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		sleep sleepData = new sleep(df , hours);
		sleepHistory.add(sleepData);
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
