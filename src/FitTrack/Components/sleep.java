package FitTrack.Components;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by colin on 21/11/16.
 */
public class sleep
{
	private DateFormat df;
	private int hours;

	public sleep(DateFormat df, int hours)
	{
		this.df = df;
		this.hours = hours;
	}

	@Override
	public String toString()
	{
		Date date = new Date();
		String sleepData = df.format(date) + " : " + hours + " hours slept.";
		return sleepData;
	}
}
