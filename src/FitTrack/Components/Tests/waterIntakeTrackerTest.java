package FitTrack.Components.Tests;

import FitTrack.Components.waterIntakeTracker;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Colin on 12/4/2016.
 */
public class waterIntakeTrackerTest extends TestCase
{
	waterIntakeTracker genericTracker = new waterIntakeTracker();

	@Test
	public void testBaseCase()
	{
		genericTracker.reset();
		genericTracker.addDrink(5);
		assertEquals(Integer.parseInt(genericTracker.getTotal()), 5);
		assertEquals(Integer.parseInt(genericTracker.getRemaining()), 64 - 5);
	}

	@Test
	public void testZeroCase()
	{
		genericTracker.reset();
		genericTracker.addDrink(0);
		assertEquals(Integer.parseInt(genericTracker.getTotal()), 0);
	}

	@Test
	public void testNegativeCase()
	{
		genericTracker.reset();
		genericTracker.addDrink(-8);
		assertEquals(Integer.parseInt(genericTracker.getTotal()), 0);
	}

	@Test
	public void testMultipleCase()
	{
		genericTracker.reset();
		genericTracker.addDrink(6);
		genericTracker.addDrink(4);
		assertEquals(Integer.parseInt(genericTracker.getTotal()), 10);
		assertEquals(Integer.parseInt(genericTracker.getRemaining()), 64 - 10);
	}

}