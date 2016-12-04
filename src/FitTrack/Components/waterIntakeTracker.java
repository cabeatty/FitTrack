package FitTrack.Components;

/**
 * Created by colin on 02/11/16.
 */
public class waterIntakeTracker
{
	private static int total;  //Total water drank
	private static int rem;    //Total water remaining to drink

	public waterIntakeTracker()
	{
		total = 0;
		rem = 64;
	}

	public static void addDrink(int drink)
	{
		if(drink >= 0)
		{
			total = total + drink;
			rem = rem - drink;
		}
	}

	public static String getTotal()
	{
		return Integer.toString(total);
	}

	public static String getRemaining()
	{
		return Integer.toString(rem);
	}

	public static int getRemainingInt()
	{
		return rem;
	}

	public static void reset()
	{
		total = 0;
		rem = 64;
	}
}
