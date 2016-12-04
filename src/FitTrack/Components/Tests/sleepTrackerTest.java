package FitTrack.Components.Tests;

import FitTrack.Components.sleep;
import FitTrack.Components.sleepTracker;
import junit.framework.TestCase;
import org.junit.Test;

import static FitTrack.Main.guiMain.Utilities.getDate.getTodaysDate;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Colin on 12/4/2016.
 */
public class sleepTrackerTest extends TestCase
{
	sleepTracker testTracker = new sleepTracker();

	@Test
	public void testBasicCase()
	{
		testTracker.reset();
		sleep genericSleep = new sleep(getTodaysDate(), 5);
		testTracker.addSleepHistory(genericSleep);
		assertEquals(testTracker.getHours(), 5);
	}

	@Test
	public void testZeroCase()
	{
		testTracker.reset();
		sleep genericSleep = new sleep(getTodaysDate(), 0);
		testTracker.addSleepHistory(genericSleep);
		assertEquals(testTracker.getHours(), 0);
	}

	@Test
	public void testSingleMaxCase()
	{
		testTracker.reset();
		sleep genericSleep = new sleep(getTodaysDate(), 24);
		testTracker.addSleepHistory(genericSleep);
		assertEquals(testTracker.getHours(), 24);
	}

	@Test
	public void testSingleOverCase()
	{
		testTracker.reset();
		sleep genericSleep = new sleep(getTodaysDate(), 60);
		testTracker.addSleepHistory(genericSleep);
		assertEquals(testTracker.getHours(), 0);
	}

	@Test
	public void testSeveralMaxCase()
	{
		testTracker.reset();
		sleep genericSleep = new sleep(getTodaysDate(), 24);
		testTracker.addSleepHistory(genericSleep);
		testTracker.addSleepHistory(genericSleep);  //added twice
		assertEquals(testTracker.getHours(), 24);
	}

	@Test
	public void testNegativeCase()
	{
		testTracker.reset();
		sleep genericSleep = new sleep(getTodaysDate(), -2);
		testTracker.addSleepHistory(genericSleep);
		assertEquals(testTracker.getHours(), 0);
	}



}