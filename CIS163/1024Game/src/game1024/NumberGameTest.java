package game1024;

import static org.junit.Assert.*;
import org.junit.Test;

import game1024.NumberGame;
import game1024.SlideDirection;

/***********************************
 * This JUnit class is a replacement
 * for the TenTwentyFourTester class
 * 
 * @author Alec Allain
 * @due 3/3/17
 **********************************/
public class NumberGameTest {
	
	// Many test cases for NumberGame class

	@Test (expected = IllegalArgumentException.class)
	public void testResizeBoardHeight () {
		
		NumberGame g1 = new NumberGame();
		g1.resizeBoard(-5, 5, 2048);
		fail("Height proves to catch negative");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testResizeBoardWidth() {
		
		NumberGame g2 = new NumberGame();
		
		g2.resizeBoard(5,-4, 2048);
		fail("Width proves to catch negative");
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testResizeBoardValue() {
		
		NumberGame g3 = new NumberGame();
		
		g3.resizeBoard(4, 4, 2090);
		fail("Catches number not power of two");
		
	}
	
	@Test
	public void testSetValues() {
		
		NumberGame g4 = new NumberGame();
		
		g4.setValues(new int[4][3]);
		System.out.println("Values are placed into gameBoard");
		
	}
	
	@Test
	public void testPlaceRandomValue() {
		
		NumberGame g5 = new NumberGame();
		
		g5.resizeBoard(5, 5, 2048);
		g5.placeRandomValue();
		System.out.println("New value was placed");
		
	}

	@Test 
	public void testResetGame() {
		
		NumberGame g6 = new NumberGame();
		g6.resizeBoard(4,4,2048);
		g6.reset();
		System.out.println("Board was reset");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSaveAndUndo() {
		
		NumberGame g7 = new NumberGame();
		
		g7.resizeBoard(4, 4, 1024);
		g7.slide(SlideDirection.UP);
		g7.save();
		g7.slide(null);
		g7.save();
		g7.undo();
		System.out.println("Board didn't undo");
	}
}
