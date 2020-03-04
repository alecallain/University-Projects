package game1024;

import java.util.*;
import java.util.ArrayList;

/**********************************
 * This class simulates a variation
 * of the 1024/2048 game
 * 
 * @author Alec Allain
 * @date 2/10/17
 * @due 3/3/17
 *********************************/

public class OldNumberGame implements NumberSlider {
	// instance variables
	/** keeps track of rows and columns in the game board */
	private int row;
	private int col;
	
	/** simulates a game board*/
	private int[][] gameBoard;
	
	/** determines what value will be the winning number */
	private int winningValue;
	
	/** references back to a previous move */
	private Stack<int[][]> reference;
	
	/*******************************
	 * Constructor sets game board
	 ******************************/
	public OldNumberGame() {
		// instance variables instantiated
		row = 0;
		col = 0;
		gameBoard = new int[row][col];
		winningValue = 0;
		reference = new Stack<int[][]>();
	}

	@Override
	/*******************************
	 * reevaluates the board size and winning number
	 * @throw IllegalArgumentException if win number
	 * is less than 0 or not a power of 2
	 ******************************/
	public void resizeBoard(int height, int width, int winningValue) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
		// cancels if exception is thrown
		if (height < 0 || width < 0 || height != width || winningValue < 0 || winningValue > 2048 || isPowerOfTwo(winningValue) == false) {
			throw new IllegalArgumentException();
		}
		
		// proceeds if exception isn't thrown
		row = height;
		col = width;
		gameBoard = new int[row][col];
		this.winningValue = winningValue;
	}
	
	/************************
	 * Helper method
	 * Checks value to determine if power of 2
	 * @param num holds value
	 * @return true if power of two
	 ***********************/
	public static boolean isPowerOfTwo(int num) {
		int temp = 0;
		final int BASE = 2;
		boolean result = false;
		
		temp = (int) (Math.log (num) / Math.log(BASE));
		
		// determines power of 2
		if (num == (int) Math.pow(2, temp)) {
			result = true;
		}
		else {
			result = false;
		}
		
		return result;
		
	}

	@Override
	/*******************************
	 * resets entire game
	 ******************************/
	public void reset() {
		// TODO Auto-generated method stub
		
		row = 0;
		col = 0;
		gameBoard = new int[row][col];
		winningValue = 0;
		placeRandomValue();
		placeRandomValue();
	}

	@Override
	/*******************************
	 * sets the game board values 
	 * @param ref sets values for gameBoard
	 ******************************/
	public void setValues(final int[][] ref) {
		// TODO Auto-generated method stub
		
		// puts values from ref into gameBoard
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard.length ; j++) {
				gameBoard[i][j] = ref[i][j];
			}
		}
	}

	@Override
	/*******************************
	 * inserts new random cell onto game board
	 * @throw IllegalStateException if no empty cells
	 * @return c as new cell
	 ******************************/
	public Cell placeRandomValue() throws IllegalStateException {
		// TODO Auto-generated method stub
		
		// work in progress
		int tempValue = 0;
		
		// throws exception if no cells are open
		if (gameBoard == null) {
			throw new IllegalStateException();
		}
		
		// value of new cell can only be 2 or 4
		Random r = new Random(4);
		tempValue = r.nextInt();
		while (tempValue != 2 || tempValue != 4) {
			tempValue = r.nextInt();
		}
		
		// while loop checks for empty cells
		int co = r.nextInt();
		int ro = r.nextInt(); 
		
		while (gameBoard[ro][co] != 0) {
			co = r.nextInt();
			ro = r.nextInt();
		}
		
		// new cell is created
		Cell c = new Cell(ro, co, tempValue);
		return c;
		
	}

	@Override
	/*******************************
	 * slides all tiles in desired direction
	 * @param dir move direction for tiles
	 * @return true when board changes
	 ******************************/
	public boolean slide(SlideDirection dir) {
		// TODO Auto-generated method stub
		
		int[] temp = new int[0];
		int value = 0;
		boolean result = false;
		
		switch (dir) {
		// shifts cells upward
		case UP: 
			for (int i = 0; i < gameBoard.length; i++) {
				for (int j = 0; j < gameBoard[0].length; j++) {
					temp[value] = gameBoard[i][j];
					for (int h = row; h > 1; h--) {
						gameBoard[h][j] = temp[value] * 2;
					}
				}
			}
			placeRandomValue();
			result = true;
			break;
		// shifts cells downward
		case DOWN:
			for (int i = 0; i < gameBoard.length; i++) {
				for (int j = 0; j < gameBoard[0].length; j++) {
					temp[value] = gameBoard[i][j];
					for (int h = 1; h < row; h++) {
						gameBoard[h][j] = temp[value] * 2;
					}
				}
			}
			placeRandomValue();
			result = true;
			break;
		// shifts cells to the left
		case LEFT:
			for (int i = 0; i < gameBoard.length; i++) {
				for (int j = 0; j < gameBoard[0].length; j++) {
					temp[value] = gameBoard[i][j];
					for (int h = col; h > 1; h--) {
						gameBoard[i][h] = temp[value] * 2;
					}
				}
			}
			placeRandomValue();
			result = true;
			break;
		// shifts cells to the right
		case RIGHT:
			for (int i = 0; i < gameBoard.length; i++) {
				for (int j = 0; j < gameBoard[0].length; j++) {
					temp[value] = gameBoard[i][j];
					for (int h = 1; h < col; h++){
						gameBoard[i][h] = temp[value] * 2;
					}
				}
			}
			placeRandomValue();
			result = true;
			break;
		}
		
		return result;
	}

	@Override
	/*******************************
	 * Checks cells available cells 
	 * in 2D array
	 * 
	 * @return cell ArrayList of cells
	 ******************************/
	public ArrayList<Cell> getNonEmptyTiles() {
		// TODO Auto-generated method stub
		
		// determines empty/available cells
		ArrayList<Cell> cell = new ArrayList<Cell>();
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[row].length; j++) {
				if (gameBoard[i][j] == 0) {
					cell.add(new Cell(i,j, gameBoard[i][j]));
				}
			}
		}
		
		return cell;
	}

	@Override
	/*******************************
	 * @return current state of game
	 ******************************/
	public GameStatus getStatus() {
		// TODO Auto-generated method stub
		
		// tests win or in progress
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[row].length; j++) {
				
				// if no win or no loss, in progress
				if (gameBoard[i][j] != winningValue) { 
					return GameStatus.IN_PROGRESS;
				}
				// check if gameBoard contains a win
				else if (gameBoard[i][j] == winningValue) {
					return GameStatus.USER_WON;
					
				}
			}
		}
		
		// end if cells are all full
		if (gameBoard == null) {
			return GameStatus.USER_LOST;
		}
		else {
			return GameStatus.IN_PROGRESS;
		}
	}

	/*********************
	 * helper method
	 * saves the most recent play in the game
	 ********************/
	public void save() {
		int[][] temp = new int[0][0];
		// stores previous play
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[row].length; j++) {
				temp[i][j] = gameBoard[i][j];
				reference.push(temp);
			}
		}
		
	}
	
	@Override
	/*******************************
	 * undos the most recent play in the game
	 * @throws IllegalStateException if undo is not possible
	 ******************************/
	public void undo() {
		// TODO Auto-generated method stub
		
		// replaces current cell locations with previous
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[row].length; j++) {
				int[][] temp = reference.pop();
				setValues(temp);
			}
		}
		
	}
	
	/*******************
	 * main method for class
	 ******************/
	public static void main(String [] args) {
		
	}

}
