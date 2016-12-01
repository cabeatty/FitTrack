package FitTrack.Main.guiMain.Utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by colin on 01/12/16.
 */
public class getDate
{
	public static String getTodaysDate()
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String dfStr = df.format(date);
		return dfStr;
	}
}
