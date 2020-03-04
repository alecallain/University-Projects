import java.util.*;

public class Game {
	
	private static int number;
	private static int guess;
	private Random x = new Random();
	private static Scanner scnr = new Scanner(System.in);
	
	public Game() {
		x = new Random();
		scnr = new Scanner(System.in);
		number = x.nextInt(100) + 1;
		guess = 0;
		System.out.println("Welcome to the game.");
	}
	
	
	
	public static void main (String [] args) {
		Game go = new Game();
		

		System.out.println("What's your guess between 1 and 100?");
		scnr.nextInt(guess);
		
		if (number == guess) {
			System.out.println("You're right!");
		}
		else {
			System.out.println("Not really. Try again.");
		}
		
	}
	
	
}
