package FitTrack.Components.Tests;

import FitTrack.Components.User;
import FitTrack.Components.exerciseTracker;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Colin on 12/2/2016.
 */
public class exerciseTrackerTest extends TestCase
{
	User genericTestUser = new User("Generic", "Male", 20, 200, 5.10, "generic", "generic");
	exerciseTracker testTracker = new exerciseTracker(genericTestUser);

	@Test
	public void testAddTrivialCase()
	{
		testTracker.setTotalBurn(0);
		testTracker.addExercise(180, 20);
		double calculated = testTracker.getTotalBurn();
		double expected = 212.37; //Calculated with independent web calculator
		assertEquals(calculated, expected);
	}

	@Test
	public void testAddZeroCase()
	{
		testTracker.setTotalBurn(0);
		testTracker.addExercise(0, 0);
		double calculated = testTracker.getTotalBurn();
		double expected = 0;
		assertEquals(calculated, expected);
	}

	@Test
	public void testAddBothNegativeCase()
	{
		testTracker.setTotalBurn(0);
		testTracker.addExercise(-180, -20);
		double calculated = testTracker.getTotalBurn();
		double expected = 0; //should not add anything
		assertEquals(calculated, expected);
	}

	@Test
	public void testAddTimeNegativeCase()
	{
		testTracker.setTotalBurn(0);
		testTracker.addExercise(180, -20);
		double calculated = testTracker.getTotalBurn();
		double expected = 0; //should not add anything
		assertEquals(calculated, expected);
	}

	@Test
	public void testAddBPMNegativeCase()
	{
		testTracker.setTotalBurn(0);
		testTracker.addExercise(-180, 20);
		double calculated = testTracker.getTotalBurn();
		double expected = 0; //should not add anything
		assertEquals(calculated, expected);
	}

	@Test
	public void testAddBothMaxValCase()
	{
		testTracker.setTotalBurn(0);
		testTracker.addExercise(220, 1440);
		double calculated = testTracker.getTotalBurn();
		double expected = 23975.83;  //Calculated with independent web calculator
		assertEquals(calculated, expected);
	}

	@Test
	public void testAddBothMinValCase()
	{
		testTracker.setTotalBurn(0);
		testTracker.addExercise(60, 0);
		double calculated = testTracker.getTotalBurn();
		double expected = 0;  //Calculated with independent web calculator
		assertEquals(calculated, expected);
	}

}