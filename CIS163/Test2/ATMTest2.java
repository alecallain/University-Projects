/*
 * Project 1 ATM JUnit test class
 * @author Jacob Walton and cis163 professors
 * @version January 2017
 * 
 * A class that tests a high-end ATM machine program with hundreds, fifties, and twenties.
 * 
 * 
 */
 

import static org.junit.Assert.*;
import org.junit.*;

public class ATMTest
{

	/**
	 * *** Your assignment is to write many test cases *****
	 */
	/* some examples provided to help you get started */

	// Testing valid constructors with wide range of values
	@Test
	public void testConstructor()
	{
		ATM s1 = new ATM(6, 5, 4);

		assertEquals(s1.getHundreds(), 6);
		assertEquals(s1.getFifties(), 5);
		assertEquals(s1.getTwenties(), 4);

		ATM s2 = new ATM();
		assertEquals(s2.getHundreds(), 0);
		assertEquals(s2.getFifties(), 0);
		assertEquals(s2.getTwenties(), 0);

		ATM s3 = new ATM(s1);
		assertEquals(s3.getHundreds(), 6);
		assertEquals(s3.getFifties(), 5);
		assertEquals(s3.getTwenties(), 4);
		
	}

	// testing negative number quarters, for constructors
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNegTwenties()
	{
		new ATM(0, 0, -50);
	}

	// testing negative number quarters, for constructors
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNegFifties()
	{
		new ATM(0, -3, 0);
	}

	// testing negative number quarters, for constructors
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNegHundreds()
	{
		new ATM(-300, 0, 0);
	}
	
	//testing negative number for twenties in setter
	@Test(expected = IllegalArgumentException.class)
	public void testSetTwenties()
	{
		ATM s1 = new ATM();
		s1.setTwenties(-100);
	}
	
	//testing negative number for fifties in setter
	@Test(expected = IllegalArgumentException.class)
	public void testSetFifties()
	{
		ATM s1 = new ATM();
		s1.setFifties(-100);
	}
	
	//testing negative number for hundreds in setter
	@Test(expected = IllegalArgumentException.class)
	public void testSetHundreds()
	{
		ATM s1 = new ATM();
		s1.setHundreds(-100);
	}

	

	// IMPORTANT: only one test per exception!!!

	// testing valid takeOut with wide range of
	// quarters, dimes, nickels, pennies
	@Test
	public void testTakeOut1()
	{
		ATM s1 = new ATM(3, 3, 2);
		s1.takeOut(1, 1, 1);
		assertEquals(s1.getHundreds(), 2);
		assertEquals(s1.getFifties(), 2);
		assertEquals(s1.getTwenties(), 1);
	}

	// testing valid takeOut with wide range of amounts
	@Test
	public void testTakeOut2()
	{
		ATM s1 = new ATM(5, 3, 3);
		s1.takeOut(1, 0, 1);

		assertEquals(s1.getHundreds(), 4);
		assertEquals(s1.getFifties(), 3);
		assertEquals(s1.getTwenties(), 2);

	}

	// testing not able to make change
	@Test
	public void testTakeOutNull()
	{
		ATM s1 = new ATM(3, 1, 2);
		ATM s2 = s1.takeOut(700);
		assertEquals(s2, null);
	}

	// testing negative number for nickels, takeOut
	@Test(expected = IllegalArgumentException.class)
	public void testTakeOutNegTwenties()
	{
		ATM s1 = new ATM(2, 2, 2);
		s1.takeOut(1, 1, -1);
	}

	// testing negative number for fifties, takeOut
	@Test(expected = IllegalArgumentException.class)
	public void testTakeOutNegFifties()
	{
		ATM s1 = new ATM(2, 2, 2);
		s1.takeOut(1, -1, 1);
	}

	// testing negative number for hundreds, takeOut
	@Test(expected = IllegalArgumentException.class)
	public void testTakeOutNegHundreds()
	{
		ATM s1 = new ATM(2, 2, 2);
		s1.takeOut(-1, 1, 1);
	}

	// testing putIn and takeOut together
	@Test
	public void testPutInTakeOut()
	{
		ATM s1 = new ATM();
		s1.putIn(3, 3, 2);
		s1.takeOut(1, 1, 1);
		assertEquals(s1.getHundreds(), 2);
		assertEquals(s1.getFifties(), 2);
		assertEquals(s1.getTwenties(), 1);
	}

	// testing putIn for valid low numbers
	@Test
	public void testPutIn()
	{
		ATM s1 = new ATM();
		s1.putIn(2, 3, 4);
		assertEquals(s1.getHundreds(), 2);
		assertEquals(s1.getFifties(), 3);
		assertEquals(s1.getTwenties(), 4);
	}

	// testing negative number for twenties, putIn
	@Test(expected = IllegalArgumentException.class)
	public void testPutInNegTwenties()
	{
		ATM s = new ATM(2, 3, 4);
		s.putIn(30, 2, -30);
	}

	// testing negative number for fifties, putIn
	@Test(expected = IllegalArgumentException.class)
	public void testPutInNegFifties()
	{
		ATM s = new ATM(2, 3, 4);
		s.putIn(30, -2, 30);
	}

	// testing negative number for hundreds, putIn
	@Test(expected = IllegalArgumentException.class)
	public void testPutInNegHundreds()
	{
		ATM s = new ATM(2, 3, 4);
		s.putIn(-30, 2, 30);
	}

	// Testing equals for valid numbers
	@Test
	public void testEqual()
	{
		ATM s1 = new ATM(2, 5, 4);
		ATM s2 = new ATM(6, 5, 4);
		ATM s3 = new ATM(2, 5, 4);
	
		assertFalse(s1.equals(s2));
		assertTrue(s1.equals(s3));
	}

	// testing compareTo all returns
	@Test
	public void testCompareTo()
	{
		ATM s1 = new ATM(2, 5, 4);
		ATM s2 = new ATM(6, 5, 4);
		ATM s3 = new ATM(2, 3, 4);
		ATM s4 = new ATM(2, 5, 4);
	
		assertTrue(s2.compareTo(s1) > 0);
		assertTrue(s3.compareTo(s1) < 0);
		assertTrue(s1.compareTo(s4) == 0);
	}

	// load and save combined.
	@Test
	public void testLoadSave()
	{
		ATM s1 = new ATM(6, 5, 4);
		ATM s2 = new ATM(6, 5, 4);
	
		s1.save("file1");
		s1 = new ATM(); // resets to zero
	
		s1.load("file1");
		assertTrue(s1.equals(s2));
	
	}

	@Test
	public void testSuspend()
	{
		ATM s1 = new ATM(6, 5, 4);
		s1.suspend(true);
		s1.takeOut(1,1,1);
		assertEquals(s1.getHundreds(), 6);
		assertEquals(s1.getFifties(), 5);
		assertEquals(s1.getTwenties(), 4);
		s1.suspend(false);
	}
}
