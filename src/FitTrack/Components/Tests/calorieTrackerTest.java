package FitTrack.Components.Tests;

import FitTrack.Components.User;
import FitTrack.Components.calorieTracker;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Colin on 12/2/2016.
 */
public class calorieTrackerTest extends TestCase
{
	User genericTestUser = new User("Generic", "Male", 20, 200, 5.10, "generic", "generic");
	calorieTracker testTracker = new calorieTracker(genericTestUser);
	double genericUserTotalCal = Double.parseDouble(testTracker.getTarget());

	@Test
	public void testAddMealBasic()  //total should be only 200 less
	{
		testTracker.restCal();
		testTracker.addMeal(200);
		double calculated = Double.parseDouble(testTracker.getDiff());
		double expected = genericUserTotalCal - 200;
		assertEquals(calculated, expected);
		testTracker.addMeal(-200);
	}

	@Test
	public void testAddMealNone()  //Total should not change
	{
		testTracker.restCal();
		testTracker.addMeal(0);
		double calculated = Double.parseDouble(testTracker.getDiff());
		double expected = genericUserTotalCal;
		assertEquals(calculated, expected);
	}

	@Test
	public void testAddMealFull()  //Should be zero when total calories are added as a meal
	{
		testTracker.restCal();
		testTracker.addMeal(genericUserTotalCal);
		double calculated = Double.parseDouble(testTracker.getDiff());
		double expected = 0;
		assertEquals(calculated, expected);
	}

	@Test
	public void testAddMealNegative()  //Doesn't accept negative values, so total should not change.  Input is sanitized for values outside this range
	{
		testTracker.restCal();
		testTracker.addMeal(-200);
		double calculated = Double.parseDouble(testTracker.getDiff());
		double expected = genericUserTotalCal;
		assertEquals(calculated, expected);
	}

	@Test
	public void testAddMealTooBig()  //Doesn't accept values over 3500, so total should not change.  Input is sanitized for values outside this range
	{
		testTracker.restCal();
		testTracker.addMeal(3501);
		double calculated = Double.parseDouble(testTracker.getDiff());
		double expected = genericUserTotalCal;
		assertEquals(calculated, expected);
	}

	@Test
	public void testAddMealAtMax()  //Doesn't accept values over 3500, so total should be total - 3500.  Input is sanitized for values outside this range
	{
		testTracker.restCal();
		testTracker.addMeal(3500);
		double calculated = Double.parseDouble(testTracker.getDiff());
		double expected = genericUserTotalCal - 3500;
		assertEquals((int)calculated, (int)expected);  //Typecast both values as ints as to avoid precision errors.  The tracker rounds up.
	}

}