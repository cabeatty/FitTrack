package FitTrack.Components;

/**
 * Created by colin on 21/11/16.
 */
public class sleep
{
	private String df;
	private int hours;

	public sleep(String df, int hours)
	{
		this.df = df;
		this.hours = hours;
	}

	@Override
	public String toString()
	{
		String sleepData = df + " : " + hours + " hours slept.";
		return sleepData;
	}
}
