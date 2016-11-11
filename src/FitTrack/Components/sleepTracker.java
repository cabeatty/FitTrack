package FitTrack.Components;

import java.util.ArrayList;

/**
 * Created by colin on 02/11/16.
 */
public class sleepTracker
{
    private ArrayList<Integer> sleepHistory = new ArrayList<Integer>();

    public sleepTracker( ArrayList<Integer> sleepHistory )
    {
        this.sleepHistory = sleepHistory;
    }

    public ArrayList<Integer> getSleepHistory()
    {
        return sleepHistory;
    }

    public void setSleepHistory( ArrayList<Integer> sleepHistory )
    {
        this.sleepHistory = sleepHistory;
    }

    public void addSleepHistory( int sleepData )
    {

        this.sleepHistory.add(sleepData);
    }
}
