package atmPack;

import static org.junit.Assert.*;
import org.junit.*;

/**********************************
 * This class test and confirms the
 * ATM class works correctly
 * 
 * @author Ira Woodring
 * @author Alec Allain
 * @date 1/24/17
 * @due 2/5/17
 *********************************/

public class TestATM {
	
	/**
	 * ***  Your assignment is to write many test cases  *****
	 */
	
	/** some examples provided to help you get started */

	// Testing valid constructors with wide range of values
	@Test
	public void testConstructor() {
		ATM s1 = new ATM(6, 5, 4);
		
		assertEquals (s1.getHundreds(), 6);
		assertEquals (s1.getFifties(), 5);
		assertEquals (s1.getTwenties(), 4);
		
		ATM s2 = new ATM();
		assertEquals (s2.getHundreds(), 0);
		assertEquals (s2.getFifties(), 0);
		assertEquals (s2.getTwenties(), 0);
		
		ATM s3 = new ATM(s1);
		assertEquals (s3.getHundreds(), 6);
		assertEquals (s3.getFifties(), 5);
		assertEquals (s3.getTwenties(), 4);
	}
	
	// testing valid takeOut with wide range of
	// quarters, dimes, nickels, pennies
	@Test
	public void testTakeOut1() {
		ATM s1 = new ATM(3,3,2);
		s1.takeOut(1,1,1);
		assertEquals (s1.getHundreds(), 2);
		assertEquals (s1.getFifties(), 2);
		assertEquals (s1.getTwenties(), 1);
	}
	
	// testing valid takeOut with wide range of amounts
	@Test
	public void testTakeOut2() {
		ATM s1 = new ATM(5,3,3);
		ATM s2 = s1.takeOut(120);
		
		assertEquals (s1.getHundreds(), 4);
		assertEquals (s1.getFifties(), 3);
		assertEquals (s1.getTwenties(), 2);
		
		assertEquals (s2.getHundreds(), 1);
		assertEquals (s2.getFifties(), 0);
		assertEquals (s2.getTwenties(), 1);
	}
	
	// testing putIn for valid low numbers
	@Test
	public void testPutIn() {
		ATM s1 = new ATM();
		s1.putIn(2,3,4);
		assertEquals (s1.getHundreds(), 2);
		assertEquals (s1.getFifties(), 3);
		assertEquals (s1.getTwenties(), 4);
	}
	
	// testing putIn and takeOut together
	@Test
	public void testPutInTakeOut() {
		ATM s1 = new ATM();
		s1.putIn(3,3,2);
		s1.takeOut(1,1,1);
		assertEquals (s1.getHundreds(), 2);
		assertEquals (s1.getFifties(), 2);
		assertEquals (s1.getTwenties(), 1);
	}

	// Testing equals for valid numbers
	@Test
	public void testEqual () {
		ATM s1 = new ATM(2, 5, 4);
		ATM s2 = new ATM(6, 5, 4);
		ATM s3 = new ATM(2, 5, 4);

		assertFalse(s1.equals(s2));
		assertTrue(s1.equals(s3));
	}

	// testing compareTo all returns
	@Test
	public void testCompareTo () {
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
	public void testLoadSave() {
		ATM s1 = new ATM(6, 5, 4);
		ATM s2 = new ATM(6, 5, 4);

		s1.save("file1");
		s1 = new ATM();  // resets to zero

		s1.load("file1");
		assertTrue(s1.equals(s2));

	}

	// testing not able to make change
	@Test
	public void testTakeOutNull() {
		ATM s1 = new ATM(3,1,2);
		ATM s2 = s1.takeOut(700);
		assertEquals(s2,  null);
	}
	
	@Test
	public void testMutate() {
		ATM s1 = new ATM(6, 5, 4);
		ATM.suspend(true);
		s1.takeOut(120);
		assertEquals (s1.getHundreds(), 6);
		assertEquals (s1.getFifties(), 5);
		assertEquals (s1.getTwenties(), 4);
		ATM.suspend(false);
	}
	
	// IMPORTANT: only one test per exception!!!

	// testing negative number quarters, for constructors
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNegHunderies() {
		new ATM(-300, 0, 0);		
	}
	
	// testing negative number for fifties, for constructor
	@Test
	public void testConstructorNegFifties() {
		new ATM(0,-25,0);
	}
	
	// testing negative number for twenties, for constructor
	@Test
	public void testConstructorNegTwenties() {
		new ATM(0,0,-45);
	}
	
	// testing negative number for quarters, putIn
	@Test(expected = IllegalArgumentException.class)
	public void testPutInNeghunderies() {
		ATM s = new ATM(2,3,4);
		s.putIn(-30,2,30);
	}
	
	// testing negative number for hundreds, takeOut
	@Test (expected = IllegalArgumentException.class)
	public void testTakeOutNegativeHundreds() {
		ATM b = new ATM(5,7,9);
		b.takeOut(-4,0,0);
	}
	
	// testing negative number for fifties, putIn
	@Test (expected = IllegalArgumentException.class)
	public void testPutInNegativeFifties() {
		ATM s2 = new ATM(2,4,3);
		s2.putIn(0,-10,0);
	}
	
	// testing negative number for fifties, takeOut
	@Test (expected = IllegalArgumentException.class)
	public void testTakeOutNegativeFifties() {
		ATM a = new ATM(1,5,4);
		a.takeOut(0,-10,0);
	}
	
	// testing negative number for twenties, putIn
	@Test (expected = IllegalArgumentException.class)
	public void testPutInNegativeTwenties() {
		ATM c = new ATM();
		c.putIn(1,5,-6);
	}
	
	// testing negative number for twenties, takeOut
	@Test (expected = IllegalArgumentException.class)
	public void testTakeOutNegativeTwenties() {
		ATM d = new ATM(5,8,13);
		d.takeOut(0,0,-12);
	}
	
	// testing suspend method, putIn(hundreds, fifties, twenties)
	@Test (expected = IllegalArgumentException.class)
	public void testSuspendPutIn() {
		ATM e = new ATM();
		ATM.suspend(true);
		e.putIn(1,5,3);
	}
	
	// testing suspend method, takeOut(hundreds, fifties, twenties)
	@Test (expected = IllegalArgumentException.class)
	public void testSuspendTakeOut() {
		ATM f = new ATM(5,11,21);
		ATM.suspend(true);
		f.takeOut(1,5,3);
	}
	
	// testing suspend method, putIn(other)
	@Test (expected = IllegalArgumentException.class)
	public void testSuspendSecondPutIn() {
		ATM g = new ATM(1,1,1);
		ATM h = new ATM(2,3,4);
		ATM.suspend(true);
		g.putIn(h);
	}
	
	// testing suspend method, takeOut(other)
	@Test (expected = IllegalArgumentException.class)
	public void testSuspendSecondTakeOut() {
		ATM i = new ATM(4,5,3);
		ATM j = new ATM(1,1,2);
		ATM.suspend(true);
		i.takeOut(j);
	}
}
