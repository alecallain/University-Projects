/*
 * Game 1024/2048
 * 
 * Acknowlegements: 
	 * Some comments taken from the outline given by Hans Dulimarta.
	 * I worked with Nate Fasbender on the project.
	 * I also received help from my friend/co-worker Jarred Parr and
	 * his friend with code structure.
 * @author Jake Walton
 * @version 1.0.0
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import game1024.Cell;
import game1024.GameStatus;
import game1024.SlideDirection;

public class NumberGame implements NumberSlider {

	// instance variables
	private ArrayList<Cell> cells;
	private GameStatus currentStatus;
	private int width;
	private int height;
	private int winningValue;
	private int[][] boardValues;
	private boolean[][] hasMerged;
	private Stack<int[][]> savedBoards;

	/**
	 * Reset the game logic to handle a board of a given dimension
	 *
	 * @param height
	 *            the number of rows in the board
	 * @param width
	 *            the number of columns in the board
	 * @param winningValue
	 *            the value that must appear on the board to win the game
	 * @throws IllegalArgumentException
	 *             when the winning value is not power of two or negative
	 */
	@Override
	public void resizeBoard(int height, int width, int winningValue) {
		if (isPowerOf2(winningValue)) {
			this.width = width;
			this.height = height;
			this.winningValue = winningValue;
			this.boardValues = new int[height][width];
			this.hasMerged = new boolean[height][width];
			this.savedBoards = new Stack<>();
			this.currentStatus = GameStatus.IN_PROGRESS;
			this.cells = new ArrayList<>();

			// set all board values to 0
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					this.boardValues[i][j] = 0;
					this.hasMerged[i][j] = false;
				}
			}

		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Remove all numbered tiles from the board and place TWO non-zero values at
	 * random location
	 */
	@Override
	public void reset() {
		// reset all the related variables
		this.savedBoards.clear();
		this.cells.clear();
		this.boardValues = new int[height][width];
		this.hasMerged = new boolean[height][width];

		// reset all of the board values to 0
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				this.boardValues[i][j] = 0;
				this.hasMerged[i][j] = false;
			}
		}

		// sets the status of the game for jUnit Test
		this.currentStatus = GameStatus.IN_PROGRESS;

		// place 2 random values on the board
		placeRandomValue();
		placeRandomValue();

	}

	/**
	 * Set the game board to the desired values given in the 2D array. This
	 * method should use nested loops to copy each element from the provided
	 * array to your own internal array. Do not just assign the entire array
	 * object to your internal array object. Otherwise, your internal array may
	 * get corrupted by the array used in the JUnit test file. This method is
	 * mainly used by the JUnit tester.
	 * 
	 * @param ref
	 */
	@Override
	public void setValues(int[][] ref) {
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				// sets this board values to the passed in reference
				this.boardValues[i][j] = ref[i][j];
			}
		}
	}

	/**
	 * Insert one random tile into an empty spot on the board.
	 *
	 * @return a Cell object with its row, column, and value attributes
	 *         initialized properly Illegal argument thrown in helper method
	 * 
	 */
	@Override
	public Cell placeRandomValue() {
		Random random = new Random();

		// gets a random cell from a private helper method so the method can
		// actually find one
		ArrayList<Cell> randomCellList = getEmptyTiles();
		Cell randomCell = randomCellList.get(random.nextInt(getEmptyTiles().size()));

		// gets the info of the random cell
		int col = randomCell.column;
		int row = randomCell.row;

		// decides if a 1 or a 2 will be placed
		int val = random.nextInt(2) + 1;
		this.boardValues[row][col] = val;

		// returns the new cell
		return new Cell(row, col, val);
	}

	/**
	 * Slide all the tiles in the board in the requested direction
	 * 
	 * @param dir
	 *            move direction of the tiles
	 *
	 * @return true when the board changes
	 */
	@Override
	public boolean slide(SlideDirection dir) {

		// value to check if values did slide
		boolean slided = false;

		// if first move, save the board
		if (this.savedBoards.size() == 0) {
			saveBoard();
		}

		// move directions: -1 is left/up and 1 right/down in the array
		if (dir == SlideDirection.UP) {
			if (moveVertically(-1)) {
				slided = true;
			}
		} else if (dir == SlideDirection.DOWN) {
			if (moveVertically(1)) {
				slided = true;
			}
		} else if (dir == SlideDirection.LEFT) {
			if (moveHorizontally(-1)) {
				slided = true;
			}
		} else if (dir == SlideDirection.RIGHT) {
			if (moveHorizontally(1)) {
				slided = true;
			}
		}

		// place a random cell value and save board if slide occurred
		if (slided) {
			placeRandomValue();
			saveBoard();
		}

		// reset the merged cells every slide
		resetMerges();

		return slided;

	}

	/**
	 * Finds cells that have data in them.
	 *
	 * @return an arraylist of Cells. Each cell holds the (row,column) and value
	 *         of a tile
	 */
	@Override
	public ArrayList<Cell> getNonEmptyTiles() {

		// temp array list to hold cells of nonEmptyTiles
		ArrayList<Cell> nonEmptyTiles = new ArrayList<>();

		// loop to add the non empty tiles
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				// checks if value is empty, if not, it adds it to the
				// nonEmptyTiles array list
				if (this.boardValues[i][j] != 0) {
					nonEmptyTiles.add(new Cell(i, j, this.boardValues[i][j]));
				}
			}
		}
		return nonEmptyTiles;
	}

	/**
	 * Return the current state of the game
	 * 
	 * @return one of the possible values of GameStatus enum
	 */
	@Override
	public GameStatus getStatus() {

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {

				// if the board value is equivalent to the winning value,
				// say you win
				if (this.boardValues[i][j] == this.winningValue) {
					// set the current status to WON
					this.currentStatus = GameStatus.USER_WON;
					return this.currentStatus;
				}
			}
		}

		// checks if the board is full and the user lost
		if (getNonEmptyTiles().size() == (this.width * this.height)) {

			// checks to see if there are any moves left
			for (int i = 0; i < this.height; i++) {
				for (int j = 0; j < this.width; j++) {
					if (i > 0) {
						// checks the above tiles
						if (canMerge(i, j, i - 1, j)) {
							this.currentStatus = GameStatus.IN_PROGRESS;
							return this.currentStatus;
						}

						if (i < this.height - 1) {

							// checks below tiles if they can be merged
							if (canMerge(i, j, i + 1, j)) {
								this.currentStatus = GameStatus.IN_PROGRESS;
								return this.currentStatus;
							}
						}
					}

					if (j > 0) {

						// checks if tile to the right of the current tile can
						// be merged
						if (canMerge(i, j, i, j - 1)) {
							this.currentStatus = GameStatus.IN_PROGRESS;
							return this.currentStatus;
						}

						if (j < this.width - 1) {

							// checks if tile to the left of the current tile
							// can be merged
							if (canMerge(i, j, i, j + 1)) {
								this.currentStatus = GameStatus.IN_PROGRESS;
								return this.currentStatus;
							}
						}
					}

				}
			}

			// if the method still hasn't returned anything, then the there are
			// no moves
			this.currentStatus = GameStatus.USER_LOST;
			return this.currentStatus;
		} else {
			this.currentStatus = GameStatus.IN_PROGRESS;
			return this.currentStatus;
		}

	}

	/**
	 * Undo the most recent action, i.e. restore the board to its previous
	 * state. Calling this method multiple times will ultimately restore the
	 * game to the very first initial state of the board holding two random
	 * values. Further attempt to undo beyond this state will throw an
	 * IllegalStateException.
	 *
	 * @throws IllegalStateException
	 *             when undo is not possible
	 */
	@Override
	public void undo() {

		// if this is not the first move, follow through with the undo
		if (this.savedBoards.size() > 1) {

			// pop twice to remove the current and get the next board
			this.savedBoards.pop();

			// previous board values saved
			int[][] prevBoard = this.savedBoards.pop();

			// change to the previous board
			setValues(prevBoard);
		} else {
			throw new IllegalStateException();
		}
	}

	/**
	 * Checks if the given value is a power of 2. Some code found online on a
	 * blog to assist
	 * 
	 * @param n
	 * @return boolean value of whether or not is a power of 2
	 */
	private static boolean isPowerOf2(final int n) {
		if (n <= 0) {
			return false;
		}
		return (n & (n - 1)) == 0;
	}

	/**
	 * Setter for winning value.
	 * 
	 * @param winningValue
	 *            the desired winning value of the game
	 */
	public void setwinningValue(int winningValue) {
		this.winningValue = winningValue;
	}

	/**
	 * Method to control vertical motion.
	 * 
	 * @return true if tiles moved, else false
	 */
	private boolean moveVertically(int dir) {
		// variables
		int i = 0;
		int j = 0;
		int iInitial = 0;
		int jInitial = 0;
		boolean slided = false;

		// set the start tiles based on initial direction
		if (dir == 1) {
			iInitial = this.height - 1;
			jInitial = this.width - 1;
		} else {
			iInitial = 0;
			jInitial = 0;
		}

		for (i = iInitial; dir == 1 ? (i >= 0) : (i < this.height); i -= dir) {
			for (j = jInitial; dir == 1 ? (j >= 0) : (j < this.width); j -= dir) {

				// don't slide empties
				if (this.boardValues[i][j] != 0) {
					// temp value for i
					int y = i;

					// loops vertically, depending on direction to check for
					// merges
					while (dir == -1 ? (y > 0) : y < (this.height - 1)) {
						if (canMerge(y, j, y + dir, j)) {
							merge(y, j, y + dir, j);
							slided = true;
						}

						if (canMove(y, j, y + dir, j)) {
							move(y, j, y + dir, j);
							slided = true;
						}

						// next line
						y += dir;
					}

				}
			}
		}
		return slided;
	}

	/**
	 * Method to control horizontal direction
	 * 
	 * @return true if tiles moved, else false
	 */
	private boolean moveHorizontally(int dir) {
		// variables
		int i = 0;
		int j = 0;
		int iInitial = 0;
		int jInitial = 0;
		boolean slided = false;

		// set the start tiles based on initial direction
		if (dir == 1) {
			iInitial = this.height - 1;
			jInitial = this.width - 1;
		} else {
			iInitial = 0;
			jInitial = 0;
		}

		for (i = iInitial; dir == 1 ? (i >= 0) : (i < this.height); i -= dir) {
			for (j = jInitial; dir == 1 ? (j >= 0) : (j < this.width); j -= dir) {

				// don't slide empties
				if (this.boardValues[i][j] != 0) {
					// temp value for i
					int x = j;

					// loops vertically, depending on direction to check for
					// merges
					while (dir == -1 ? (x > 0) : x < (this.width - 1)) {
						if (canMerge(i, x, i, x + dir)) {
							merge(i, x, i, x + dir);
							slided = true;
						}

						if (canMove(i, x, i, x + dir)) {
							move(i, x, i, x + dir);
							slided = true;
						}

						// next line
						x += dir;
					}

				}
			}
		}
		return slided;
	}

	/**
	 * Method that gets all tiles that are 0, or empty.
	 * 
	 * @return an ArrayList of type Cell that are equal to 0.
	 * 
	 * @throws IllegalStateException
	 *             when the board has no empty cell
	 */
	private ArrayList<Cell> getEmptyTiles() {

		ArrayList<Cell> emptyTiles = new ArrayList<>();
		boolean flag = false;

		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				if (this.boardValues[i][j] == 0) {
					emptyTiles.add(new Cell(i, j, 0));
					flag = true;
				}
			}
		}

		if (!flag) {
			throw new IllegalStateException();
		}
		return emptyTiles;

	}

	/**
	 * Method that saves the current board into the savedBoards stack.
	 */
	private void saveBoard() {

		// temp board array of ints
		int[][] temp = new int[this.height][this.width];

		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				temp[i][j] = this.boardValues[i][j];
			}
		}

		// push the board to its stack
		this.savedBoards.push(temp);
	}

	/**
	 * Method that resets the hasMerged 2d boolean array.
	 */
	private void resetMerges() {
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				this.hasMerged[i][j] = false;
			}
		}
	}

	/**
	 * Method that merges two cells together to create a new one.
	 */
	private void merge(int i1, int j1, int i2, int j2) {

		// setting the new tile to the multiple of the tiles to be merged
		this.boardValues[i2][j2] = this.boardValues[i1][j1] * 2;
		this.boardValues[i1][j1] = 0;

		// set hasMerged to true and save the score
		this.hasMerged[i2][j2] = true;
	}

	/**
	 * Moves the first tile into the second and resets the first
	 * 
	 * First Tile:
	 * 
	 * @param i1
	 * @param j1
	 * 
	 *            Second Tile:
	 * @param i2
	 * @param j2
	 */
	private void move(int i1, int j1, int i2, int j2) {
		this.boardValues[i2][j2] = this.boardValues[i1][j1];
		this.boardValues[i1][j1] = 0;
	}

	/**
	 * Method that checks if two tiles can merge.
	 * 
	 * @return true if they are the same tile, have not merged in the same move,
	 *         and if they are not 0. Returns false otherwise.
	 */
	private boolean canMerge(int i1, int j1, int i2, int j2) {

		// check if both are 0
		boolean notZero = (this.boardValues[i1][j1] != 0) && (this.boardValues[i2][j2] != 0);

		// check if same number
		boolean sameTile = (this.boardValues[i1][j1] == this.boardValues[i2][j2]);

		// avoid double merge in same slide
		boolean didMerge = (this.hasMerged[i1][j1] || this.hasMerged[i2][j2]);

		return (sameTile && !didMerge && notZero);
	}

	/**
	 * Helper to check if the first tile can move into the second tile.
	 * 
	 * @return true if the move is valid.
	 */
	private boolean canMove(int i1, int j1, int i2, int j2) {
		return (this.boardValues[i1][j1] != 0) && (this.boardValues[i2][j2] == 0);
	}

}
