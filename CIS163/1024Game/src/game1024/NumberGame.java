package game1024;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

/**
 * Created by dulimarh on 6/30/14.
 */
public class NumberGame implements NumberSlider {
	private int GOAL_VALUE;
	private int[][] grid;
	private ArrayList<Cell> cells;
	private Stack<ArrayList<Cell>> moves;
	private Random rgen;
	private GameStatus gameStatus;
	private int numFilledCells;

	@Override
	public void resizeBoard (int NROW, int NCOL, int goal)
	{
		grid = new int[NROW][NCOL];
		cells = new ArrayList<Cell>();
		rgen = new Random();
		numFilledCells = 0;
		GOAL_VALUE = goal;
		gameStatus = GameStatus.IN_PROGRESS;
		if (moves != null)
			moves.clear();
		else
			moves = new Stack<ArrayList<Cell>>();

		//	        generateNewCell();
	}

	@Override
	public void reset() {
		gameStatus = GameStatus.IN_PROGRESS;
		for (int k = 0; k < grid.length; k++)
			for (int m = 0; m < grid[k].length; m++)
				grid[k][m] = 0;
		placeRandomValue();
		placeRandomValue();
	}

	/* The setValues() method is needed for testing */
	@Override
	public void setValues (final int[][] input)
	{
		for (int k = 0; k < grid.length; k++)
			for (int m = 0; m < grid[0].length; m++)
				grid[k][m] = input[k][m];
	}

	private int randomTileValue() /* generate random value  2, 4, 8, 16 */
	{
		int val = 2;
		for (int k = 0; k < rgen.nextInt(2); k++)
			val *= 2;
		return val;
	}

	@Override
	public Cell placeRandomValue() {
		int r, c;
		boolean foundEmpty = false;
		for (int[] row : grid)
			for (int x : row)
				if (x == 0) {
					foundEmpty = true;
					break;
				}
		if (!foundEmpty)
			throw new IllegalStateException("No empty spot to place random value");
		do {
			r = rgen.nextInt(grid.length);
			c = rgen.nextInt(grid[0].length);
		} while (grid[r][c] != 0);
		grid[r][c] = randomTileValue();
		Cell val = new Cell();
		val.row = r;
		val.column = c;
		val.value = grid[r][c];
		return val;
	}

	private boolean moveInRow(int r, int startCol, int endCol, int dCol)
	{
		if (startCol == endCol) return false;
		int dest = startCol; /* index of destination cell */
		int c = startCol + dCol;
		while (c != endCol && grid[r][c] == 0)
			c += dCol;
		int lastValueMoved;
		if (grid[r][startCol] == 0)
			lastValueMoved = -1;
		else
			lastValueMoved = grid[r][startCol];
		/* when lastValueMoved is -1, dest is the position of an empty cell
	           when lastValueMoved is >= 0, dest is the position of a filled cell
		 */
		int updateCount = 0;
		while (c != endCol) {
			if (grid[r][c] == 0) {
				c += dCol;
				continue;
			}
			if (lastValueMoved == -1) { /* nothing was moved last time */
				grid[r][dest] = grid[r][c];
				lastValueMoved = grid[r][c];
				grid[r][c] = 0;
				updateCount++;
			}
			else {
				/* we moved a cell last time */
				if (grid[r][c] == lastValueMoved) {
					grid[r][dest] *= 2; /* merge and sum */
					grid[r][c] = 0;
					lastValueMoved = -1;
					dest += dCol;
					updateCount++;
				} else {
					dest += dCol;
					if (grid[r][dest] == 0) {
						grid[r][dest] = grid[r][c];
						grid[r][c] = 0;
						updateCount++;
					}
					lastValueMoved = grid[r][dest];
				}
			}
			c += dCol;
		}
		return updateCount != 0;
	}

	private boolean moveInColumn(int c, int startRow, int endRow, int dRow)
	{
		if (startRow == endRow) return false;
		int dest = startRow; /* index of destination cell */
		int r = startRow + dRow;
		while (r != endRow && grid[r][c] == 0)
			r += dRow;
		int lastValueMoved;
		if (grid[startRow][c] == 0)
			lastValueMoved = -1;
		else
			lastValueMoved = grid[startRow][c];
		/* when lastValueMoved is -1, dest is the position of an empty cell
	           when lastValueMoved is >= 0, dest is the position of a filled cell
		 */
		int updateCount = 0;
		while (r != endRow) {
			if (grid[r][c] == 0) {
				r += dRow;
				continue;
			}
			if (lastValueMoved == -1) { /* nothing was moved last time */
				grid[dest][c] = grid[r][c];
				lastValueMoved = grid[r][c];
				grid[r][c] = 0;
				updateCount++;
			}
			else {
				/* we moved a cell last time */
				if (grid[r][c] == lastValueMoved) {
					grid[dest][c] *= 2; /* merge and sum */
					lastValueMoved = -1;
					dest += dRow;
					grid[r][c] = 0;
					updateCount++;
				} else {
					dest += dRow;
					if (grid[dest][c] == 0) {
						grid[dest][c] = grid[r][c];
						grid[r][c] = 0;
						updateCount++;
					}
					lastValueMoved = grid[dest][c];
				}
			}
			r += dRow;
		}
		return updateCount != 0;
	}

	/*
	 * THe following solution is from Hans and does not use and 
	 * arraylist... I think it can simplified a bit. 
	 */
	/* return true if the move changes the board */
	@Override
	public boolean slide(SlideDirection dir)
	{
		boolean moveMade = false;
		for (int k = 0; k < grid.length; k++)
			for (int m = 0; m < grid[k].length; m++)
				grid[k][m] = Math.abs(grid[k][m]);

		/* We must must a new object because my implementation of
		 * getNonEmptyTiles() reuses the same ArrayList object */
		moves.push(new ArrayList(getNonEmptyTiles()));

		switch (dir) {
		case UP:
			for (int k = 0; k < grid[0].length; k++)
				moveMade |= moveInColumn(k, 0, grid.length, +1);
			break;
		case DOWN:
			for (int k = 0; k < grid[0].length; k++)
				moveMade |= moveInColumn(k, grid.length - 1, -1, -1);
			break;
		case LEFT:
			for (int k = 0; k < grid.length; k++)
				moveMade |= moveInRow(k, 0, grid[k].length, +1);
			break;
		case RIGHT:
			for (int k = 0; k < grid.length; k++)
				moveMade |= moveInRow(k, grid[k].length - 1, -1, -1);
			break;
		default:
		}
		if (moveMade) {
			for (int[] row : grid) {
				for (int v : row)
					if (v == GOAL_VALUE) {
						gameStatus = GameStatus.USER_WON;
						return true;
					}
			}
			try {
				placeRandomValue();
			}
			catch (IllegalStateException e)
			{
				gameStatus = GameStatus.USER_LOST;
			}
		}
		else {
			moves.pop();
		}
		return moveMade;
	}

	/*
	 * THe following solution is from Me (Roger) and does use an 
	 * arraylist... It is very simple and only covers the 'up' 
	 * direction.  However, it would be very easy to solve 
	 * for the the other directions. 
	 */
	/* return true if the move changes the board */
	//@Override
//	public boolean slide1(SlideDirection dir)
//	{
//		boolean moveMade = false;
//		for (int k = 0; k < grid.length; k++)
//			for (int m = 0; m < grid[k].length; m++)
//				grid[k][m] = Math.abs(grid[k][m]);
//
//		/* We must must a new object because my implementation of
//		 * getNonEmptyTiles() reuses the same ArrayList object */
//		moves.push(new ArrayList(getNonEmptyTiles()));
//
//		switch (dir) {
//		case UP:
//			// first remove spaces
//			for (int c = 0; c < grid[0].length; c++) {
//				// should use Integer wrapper class for generic
//				ArrayList list = new ArrayList();
//				for (int r = 0; r < grid.length; r++)
//					if (grid[r][c] != 0)
//						list.add(grid[r][c]);
//
//				ArrayList list2 = new ArrayList();
//				list.add(0); // taking 2 at a time, need extra 0 
//				for (int i = 0; i < list.size() - 1; i++)
//					if (list.get(i) == list.get(i + 1)) {
//						list2.add((int) list.get(i) + (int)list.get(i + 1));
//						i++;
//					}
//			
//			else if ((int) list.get(i) != 0) {
//					list2.add(list.get(i));
//				}
//
//			for (int i = 0; i < grid.length; i++)
//				grid[i][c] = 0;
//
//			for (int i = 0; i < list2.size(); i++)
//				grid[i][c] = (int) list2.get(i);
//
//			placeRandomValue();
//		}
//		break;
//	case DOWN:
//
//		break;
//	case LEFT:
//
//		break;
//	case RIGHT:
//
//		break;
//	default:
//	}
//	if (moveMade) {
//		for (int[] row : grid) {
//			for (int v : row)
//				if (v == GOAL_VALUE) {
//					gameStatus = GameStatus.USER_WON;
//					return true;
//				}
//		}
//		try {
//			placeRandomValue();
//		}
//		catch (IllegalStateException e)
//		{
//			gameStatus = GameStatus.USER_LOST;
//		}
//	}
//	else {
//		moves.pop();
//	}
//	return moveMade;
//}


@Override
public ArrayList<Cell> getNonEmptyTiles()
{
	cells.clear();
	for (int k = 0; k < grid.length; k++)
		for (int m = 0; m < grid[0].length; m++)
			if (grid[k][m] != 0) {
				Cell c = new Cell();
				c.row = k;
				c.column = m;
				c.value = grid[k][m];
				cells.add(c);
			}
	return cells;
}

private boolean movePossible()
{
	/* check for zero */
	for (int r = 0; r < grid.length; r++) {
		for (int c = 0; c < grid[r].length; c++)
			if (grid[r][c] == 0) return true;
	}

	/* check for adjacent duplicate entries in row */
	for (int r = 0; r < grid.length; r++)
		for (int c = 0; c + 1 < grid[r].length; c++)
			if (grid[r][c] == grid[r][c+1]) return true;

	/* check for adjacent duplicate entries in column */
	for (int r = 0; r + 1 < grid.length; r++)
		for (int c = 0; c < grid[r].length; c++)
			if (Math.abs(grid[r][c]) == Math.abs(grid[r+1][c])) return true;
	//	        System.out.println ("NO MORE MOVES");
	return false;

}

//	    public boolean hasWon ()
//	    {
//	        for (int[] rows : grid)
//	            for (int x : rows)
//	                if (x == GOAL_VALUE) return true;
//	        return false;
//	    }

@Override
public GameStatus getStatus() {
	if (movePossible())
		return gameStatus;
	else
		return GameStatus.USER_LOST;
}

@Override
public void undo() {
	if (moves.size() > 0) {
		for (int k = 0; k < grid.length; k++)
			for (int m = 0; m < grid[k].length; m++)
				grid[k][m] = 0;
		for (Cell c : moves.peek()) {
			grid[c.row][c.column] = c.value;
		}
		moves.pop();
	}
	else
		throw new IllegalStateException("Can't undo further....");
}

public int[][] getGrid() {
	return grid;
}

}
