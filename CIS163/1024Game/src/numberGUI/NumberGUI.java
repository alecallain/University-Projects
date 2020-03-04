package numberGUI;
import game1024.GameStatus;
import game1024.NumberGame;
import game1024.SlideDirection;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/************************************
 * This class simulates a Graphical
 * User Interface for the 
 * NumberGame/2048 game class
 * 
 * @author Alec Allain
 * @date 3/4/17
 * @due 3/22/17
 ***********************************/
public class NumberGUI extends JFrame implements ActionListener, KeyListener {

	/**************************
	 * necessary line for code to run
	 *************************/
	private static final long serialVersionUID = 1L;

	// instance variables section for class
	
	/** creates new NumberGame */
	private NumberGame game;
	
	/** creates new dialog box */
	private JFrame popUp;
	
	/** creates new buttons */
	private JButton reset;
	private JButton exit;
	private JButton resize;
	private JButton undo;
	
	/** creates menu items */
	private JMenuBar menu;
	private JMenu file;
	private JMenuItem resetItem;
	private JMenuItem exitItem;
	private JMenuItem undoItem;
	
	/** creates new updated statistics area */
	private JTextArea statsArea;
	
	/** creates new grid and border layouts */
	private GridLayout grid;
	private BorderLayout border;
	private JPanel panel;
	
	/** creates temporary integers */
	private int r;
	private int c;
	private int w;
	
	/** creates instance integers */
	private int numSlides;
	private int numGames;
	private int prevHighScore;
	
	/** creates game status indicator */
	private GameStatus status;
	
	
	/************************
	* Constructor for class
	 ***********************/
	public NumberGUI() {
		// instantiated new number game
		game = new NumberGame();
		game.resizeBoard(4, 4, 2048);
		game.reset();
		
		// instantiated text area
		statsArea = new JTextArea(7,12);
		
		// instantiated pop up window
		popUp = new JFrame("Resize frame");
		
		// instantiated panel for board
		panel = new JPanel();
		
		statsArea.setText(getStatus());
		
		// sets up basic layout for gui
		setupMenus();
		setupLayout();
		setupBoard();
		// refreshBoard();
		
		// adds key listener to entire program
		this.addKeyListener(this);
		this.setFocusable(true);
		
		pack();
	}
	
	/***************************************
	 * handles all button and menu selections
	 * 
	 * @param e is the component pressed
	 **************************************/
	public void actionPerformed(ActionEvent e) {
		// resets whole game over
		if (e.getSource() == reset || e.getSource() == resetItem) {
			game.reset();
			refreshBoard();
			numGames++;
			numSlides = 0;
			newHighScore();
		}
		
		// quits game completely
		if (e.getSource() == exit || e.getSource() == exitItem) {
			System.exit(1);
		}
		
		// undoes current move
		if (e.getSource() == undo || e.getSource() == undoItem) {
			game.undo();
			refreshBoard();
		}
		
		// resizes board without reseting game
		if (e.getSource() == resize) {
			String message1 = JOptionPane.showInputDialog(popUp, "Enter number of rows: ");
			r = Integer.parseInt(message1);
			String message2 = JOptionPane.showInputDialog(popUp, "Enter number of columns: ");
			c = Integer.parseInt(message2);
			String message3 = JOptionPane.showInputDialog(popUp, "Enter winning value: ");
			w = Integer.parseInt(message3);
			game.resizeBoard(r, c, w);
			refreshBoard();
		}
		
		// updates statistics
		statsArea.setText(getStatus());
	}
	
	/**************************
	 * sets up the menu items
	 *************************/
	public void setupMenus() {
		// instantiated menu items
		menu = new JMenuBar();
		file = new JMenu("File");
		resetItem = new JMenuItem("Reset");
		exitItem = new JMenuItem("Exit");
		undoItem = new JMenuItem("Undo");
		
		// assigns action listeners
		resetItem.addActionListener(this);
		exitItem.addActionListener(this);
		undoItem.addActionListener(this);
		
		// displays menu components
		file.add(undoItem);
		file.add(resetItem);
		file.add(exitItem);
		
		menu.add(file);
		setJMenuBar(menu);
	}
	
	/**************************
	 * sets up main layout of user interface
	 *************************/
	public void setupLayout() {
		border = new BorderLayout();
		this.setLayout(border);
		grid = new GridLayout(4,4);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 200));
		panel.setLayout(grid);
		this.add(panel);
		
		// new panel for buttons
		JPanel buttons = new JPanel();
		// creates reset button
			reset = new JButton("Reset");
			reset.addActionListener(this);
				
		// creates exit button
			exit = new JButton("Exit");
			exit.addActionListener(this);
				
		// creates undo button
			undo = new JButton("Undo");
			undo.addActionListener(this);
				
		// creates resize button
			resize = new JButton("Resize Board");
			resize.addActionListener(this);
			
			buttons.add(exit);
			buttons.add(reset);
			buttons.add(undo);
			buttons.add(resize);
			
			this.add(buttons, BorderLayout.NORTH);
			this.add(statsArea, BorderLayout.EAST);
			this.add(panel, BorderLayout.CENTER);
		
	}
	
	/******************************
	 * basic setup for board at beginning of game 
	 *****************************/
	public void setupBoard() {
		
		panel.setLayout(new GridLayout(4,4));
		for (int i = 0; i < 16; i++) {
			panel.add(new JButton("Welcome!"));
		}
		
	}
	
	/*********************
	 * cleans and updates the board
	 ********************/
	public void refreshBoard() {
		int[][] gameBoard = game.getGrid();
		int[][] temp = game.getGrid();
		String result = "";
		
		// cleans grid panel for new values
		panel.removeAll();
		panel.setLayout(new GridLayout(gameBoard.length, gameBoard[0].length));

		for (int row = 0; row < gameBoard.length; row++) {
			for (int col = 0; col < gameBoard[0].length ; col++) {
				temp[row][col] = gameBoard[row][col];
				// result = temp + "";
				result = Integer.toString(temp[row][col]);
				panel.add(new JButton(result));
			}
		}
		
		// this.setFocusable(true);
		this.requestFocus();
		
	}
	
	
	/**************************
	 * listens for certain keyboard
	 * inputs for movement of
	 * board slides
	 * 
	 * @param e is the key pressed
	 *************************/
	public void keyPressed(KeyEvent e) {
		// System.out.println("Test");
		// moves tiles up
		if (e.getKeyChar() == 'w' || e.getKeyCode() == KeyEvent.VK_UP) {
			game.slide(SlideDirection.UP);
			numSlides++;
			checkWinningNumber();
			
		}
		// moves tiles left
		if (e.getKeyChar() == 'a' || e.getKeyCode() == KeyEvent.VK_LEFT) {
			game.slide(SlideDirection.LEFT);
			numSlides++;
			checkWinningNumber();
			
		}
		// moves tiles right
		if (e.getKeyChar() == 'd' || e.getKeyCode() == KeyEvent.VK_RIGHT) {
			game.slide(SlideDirection.RIGHT);
			numSlides++;
			checkWinningNumber();
			
		}
		// moves tiles down
		if (e.getKeyChar() == 's' || e.getKeyCode() == KeyEvent.VK_DOWN) {
			game.slide(SlideDirection.DOWN);
			numSlides++;
			checkWinningNumber();
			
		}
		
		// updates statistics and game board
		refreshBoard();
		statsArea.setText(getStatus());
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// System.out.println("Test");

		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// System.out.println("Test");

		// TODO Auto-generated method stub
	}
	
	/**************************
	 * updates status area in GUI
	 *************************/
	public String getStatus() {
		String result = "";
		result = "Number of moves: " + numSlides + "\n" + "Number of games: " + numGames + "\n" + "Previous high score: " + prevHighScore;
		return result;
	}
	
	/********************
	 * checks if winning number is on board
	 *******************/
	public void checkWinningNumber() {
		int[][] grid = game.getGrid();
		int tempHighScore = 0;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] > tempHighScore) {
					tempHighScore = grid[i][j];
				}
			}
		}
		
		if (tempHighScore == w) {
			prevHighScore = tempHighScore;
			status = GameStatus.USER_WON;
			JOptionPane.showMessageDialog(popUp, "You win!");
		}
		else {
			status = GameStatus.IN_PROGRESS;
		}
		
	}
	
	/******************
	 * sets newest high score to board
	 *****************/
	public void newHighScore() {
		int[][] grid = game.getGrid();
		int tempHighScore = 0;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] > tempHighScore) {
					tempHighScore = grid[i][j];
				}
			}
		}
		prevHighScore = tempHighScore;
	}
	
	/************************
	 * Main method for GUI
	 ***********************/
	public static void main(String [] args) {
		NumberGUI gui = new NumberGUI();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setTitle("Number Game (2048)");
		//gui.pack();
		gui.setVisible(true);
	}

}
