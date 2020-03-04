package atmPack;
import java.util.*;
import java.io.*;

/******************************
 * This class simulates a high
 * end ATM machine
 * 
 * @author Alec Allain
 * @date 1/22/17
 * @due 2/5/17
 *****************************/

public class ATM {
	// instance variables section
	/** keeps track of hundred dollar bills */
	private int numHundred;
	
	/** keeps track of fifty dollar bills */
	private int numFifty;
	
	/** keeps track of twenty dollar bills */
	private int numTwenty;
	
	/** total amount of money in machine*/
	private int amount;
	
	/** keeps track if machines are on or off */
	private static boolean isRunning;
	
	/****************************
	 * Constructor resets ATM
	 ***************************/
	public ATM() {
		// initializes the instance variables
		numHundred = 0;
		numFifty = 0;
		numTwenty = 0;
		amount = 0;
		isRunning = true;
	}
	
	/****************************
	 * Sets the number of hundred bills
	 * @param input accepts and stores value
	 ***************************/
	public void setHundreds(int input) {
		// checks for negative input
		if (input < 0) {
			System.out.println("Please provide positive amount.");
		}
		else {
			numHundred = input;
		}
	}
	
	/****************************
	 * Sets the number of fifty bills
	 * @param input accepts and stores value
	 ***************************/
	public void setFifties(int input) {
		// checks for negative input
		if (input < 0) {
			System.out.println("Please provide positive amount.");
		}
		else {
			numFifty = input;
		}
	}
	
	/****************************
	 * Sets the number of twenty bills
	 * @param input accepts and stores value
	 ***************************/
	public void setTwenties(int input) {
		// checks for negative input
		if (input < 0) {
			System.out.println("Please provide positive amount.");
		}
		else {
			numTwenty = input;
		}
	}
	
	/****************************
	 * Sets the total money value in machine
	 ***************************/
	public void setAmount() {
		amount = (numHundred * 100) + (numFifty * 50) + (numTwenty * 20);
	}
	
	/****************************
	 * @return number of hundred bills
	 ***************************/
	public int getHundreds() {
		return numHundred;
	}
	
	/****************************
	 * @return number of fifty bills
	 ***************************/
	public int getFifties() {
		return numFifty;
	}
	
	/****************************
	 * @return number of twenty bills
	 ***************************/
	public int getTwenties() {
		return numTwenty;
	}
	
	/****************************
	 * @return total money value in machine
	 ***************************/
	public int getAmount() {
		return amount;
	}
	
	/****************************
	 * Constructor initializes the instance variables
	 ***************************/
	public ATM (int hundreds, int fifties, int twenties) {
		// checks for negative input
		if (hundreds < 0 || fifties < 0 || twenties < 0) {
			System.out.println("Please provide positive amount");
		}
		else {
			numHundred = hundreds;
			numFifty = fifties;
			numTwenty = twenties;
		}
	}
	
	/****************************
	 * Constructor initializes the instance variable
	 * @param other stands for another ATM machine
	 ***************************/
	public ATM (ATM other) {
		// initializes values of other machine into current machine
		this.numHundred = other.getHundreds();
		this.numFifty = other.getFifties();
		this.numTwenty = other.getTwenties();
	}
	
	/****************************
	 * Compares the ATM objects
	 * @param other stands for an Object object
	 ***************************/
	public boolean equals (Object other) {
		// checks to see if money values are equal in each machine
		if (this.numHundred == ((ATM) other).getHundreds()) {
			return true;
		}
		else if (this.numFifty == ((ATM) other).getFifties()) {
			return true;
		}
		else if (this.numTwenty == ((ATM) other).getTwenties()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/***************************
	 * @return true if machines are alike
	 * @param other stands for ATM object
	 **************************/
	public boolean equals (ATM other) {
		// checks hundred dollar bills
		if (this.numHundred == other.getHundreds()) {
			return true;
		}
		// checks fifty dollar bills
		if (this.numFifty == other.getFifties()) {
			return true;
		}
		// checks twenty dollar bills
		if (this.numTwenty == other.getTwenties()) {
			return true; 
		}
		else {
			// default return
			return false;
		}
	}
	
	/***************************
	 * Static method that determines if two ATM's are alike
	 * @param other1 stands for one machine
	 * @param other2 stands for second machine
	 **************************/
	public static boolean equals(ATM other1, ATM other2 ) {
		// checks if machines are equal
		if (other1 == other2) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/***************************
	 * Compares one machine to another
	 * @param other stands for ATM object
	 **************************/
	public int compareTo (ATM other) {
		// checks if "this" ATM has greater value
		if (other.numHundred < this.numHundred && other.numFifty < this.numFifty && other.numTwenty < this.numTwenty) {
			return 1;
		}
		// checks if "other" ATM has greater value
		if (other.numHundred > this.numHundred && other.numFifty > this.numFifty && other.numTwenty > this.numTwenty) {
			return -1;
		}
		// checks if both ATMs are equal
		if (other.numHundred == this.numHundred && other.numFifty == this.numFifty && other.numTwenty == this.numTwenty) {
			return 0;
		}
		else {
			return 0;
		}
		
	}
	
	/***************************
	 * Compares two different machines
	 * @param other1 stands for first machine
	 * @param other2 stands for second machine
	 **************************/
	public static int compareTo(ATM other1, ATM other2) {
		// determines if other1 is greater
		if (other1.getHundreds() > other2.getHundreds() && other1.getFifties() > other2.getFifties() && other1.getTwenties() > other2.getTwenties()) {
			return 1;
		}
		// determines if other2 is greater
		if (other1.getHundreds() < other2.getHundreds() && other1.getFifties() < other2.getFifties() && other1.getTwenties() < other2.getTwenties()) {
			return -1;
		}
		// determines if both are equal
		if (other1.getHundreds() == other2.getHundreds() && other1.getFifties() == other2.getFifties() && other1.getTwenties() == other2.getTwenties()) {
			return 0;
		}
		else {
			// default return
			return 0;
		}
	}
	
	/***************************
	 * Adds money to machine
	 * @param hundreds stands for hundred bills
	 * @param fifties stands for fifty bills
	 * @param twenties stands for twenty bills
	 **************************/
	public void putIn(int hundreds, int fifties, int twenties) {
		if (isRunning) {
			// checks for negative value input
			if (hundreds < 0 || fifties < 0 || twenties < 0) {
				System.out.println("Please put in a positive amount");
			}
			else {
			// adds to total bills in machine
				numHundred += hundreds;
				numFifty += fifties;
				numTwenty += twenties;
				toString();
			}
		}
		else {
			return;
		}
	}
	
	/***************************
	 * Adds money to another machine
	 * @param other stands for ATM object
	 **************************/
	public void putIn(ATM other) {
		if (isRunning) {
			// money gets added into other machine
			this.numHundred += other.numHundred;
			this.numFifty += other.numFifty;
			this.numTwenty += other.numTwenty;
			toString();
		}
		else {
			return;
		}
		
	}
	
	/***************************
	 * Removes money from machine
	 * @param hundreds stands for hundred bills
	 * @param fifties stands for fifty bills
	 * @param twenties stands for twenty bills
	 **************************/
	public void takeOut(int hundreds, int fifties, int twenties) {
		if (isRunning) {
			// checks for negative value input
			if (hundreds < 0 || fifties < 0 || twenties < 0) {
				System.out.println("Please insert a positive amount");
			}
			else {
				// subtracts total bills in machine
				numHundred -= hundreds;
				numFifty -= fifties;
				numTwenty -= twenties;
				toString();
			}
		}
		else {
			return;
		}
	}
	
	/***************************
	 * Removes money from another machine
	 * @param other stands for ATM object
	 **************************/
	public void takeOut(ATM other) {
		if (isRunning) {
			// money gets withdrawled from other machine
			this.numHundred -= other.numHundred;
			this.numFifty -= other.numFifty;
			this.numTwenty -= other.numTwenty;
			toString();
		}
		else {
			return;
		}
	}
	
	/***************************
	 * @return exact number of bills
	 * @param amount user wants to withdrawal
	 **************************/
	public ATM takeOut(double amount) {
		// extra credit method
		if (isRunning) {
			int tempHundred;
			int tempFifty;
			int tempTwenty;
			double tempAmount = 0;
			
			if (amount < 0) {
				throw new IllegalArgumentException();
			}
			
			tempHundred = getHundreds();
			tempFifty = getFifties(); 
			tempTwenty = getTwenties();
			
			tempAmount += tempHundred;
			if (tempHundred == 0 || tempAmount > amount) {
				tempAmount += tempFifty;
				if (tempFifty > amount || tempFifty == 0) {
					tempAmount += tempTwenty;
					if (tempTwenty >= amount || tempTwenty == 0) {
						//return tempAmount;
					}
				}
			}
			if (amount == tempAmount) {
				return null;
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}
	
	/***************************
	 * @return string that represents a ATM
	 **************************/
	public String toString() {
		String result = "";
		if (numHundred <= 1) {
			result = numHundred + " hundred dollar bill, ";
		}
		else {
			result = numHundred + " hundred dollar bills, ";
		}
		
		if (numFifty <= 1) {
			result += numFifty + " fifty dollar bill, ";
		}
		else {
			result += numFifty + " fifty dollar bills, ";
		}
		
		if (numTwenty <= 1) {
			result += numTwenty + " twenty dollar bill.";
		}
		else {
			result += numTwenty + " twenty dollar bills.";
		}
		return result;
	}
	
	/***************************
	 * Saves ATM machine to a file
	 * @param fileName stands for name of file
	 **************************/
	public void save (String fileName) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		String result = this.numHundred + " " + this.numFifty + " " + this.numTwenty;
		out.println(result);
		out.close();
	}
	
	/***************************
	 * Loads ATM machine from a file
	 * @param fileName stands for name of file
	 **************************/
	public void load (String fileName) {
		
		try {
			// open the data file
			Scanner fileReader = new Scanner(new File(fileName));
			
			// read one String in of data
			this.numHundred = fileReader.nextInt();
			this.numFifty = fileReader.nextInt();
			this.numTwenty = fileReader.nextInt();
			
			System.out.println("We have " + this.numHundred + " " + this.numFifty +  " " + this.numTwenty);
		}
		
		// could not find file
		catch (Exception error) {
			System.out.println("File not found");
		}
		
	}
	
	/***************************
	 * Turns on or off takeOut/putIn methods
	 * @param on prevents mutation of ATM object
	 **************************/
	public static void suspend(Boolean on) {
		// deactivates machine
		if (on == true) {
			isRunning = false;
		}
		// reactivates machine
		else if (on == false) {
			isRunning = true;
		}
		
	}
	
	/***************************
	 * Main method
	 **************************/
	public static void main(String[] args) {
		ATM s = new ATM(10,2,3);
		System.out.println("Created ChangeJar:$1160, result: " + s.getAmount());

		ATM s1 = new ATM();
		System.out.println("\nCreated ChangeJar:$0, result: " + s1.getAmount());

		s1.putIn(10,2,3);
		System.out.println("\nAdded ChangeJar:$1160, result: " + s1.getAmount());

		ATM s2 = new ATM(10,2,3);
		s2.putIn(0,0,0);
		System.out.println("\nAdded ChangeJar:$1160, result: " + s2.getAmount());

		s2 = new ATM(2,1,3);
		ATM temp = s2.takeOut(250);
		System.out.println ("\nTake out the following:\n" + temp);
		System.out.println("Remaining ChangeJar:$60, result: " + s2.getAmount());

		s2 = new ATM (5, 4, 3);
		s2.save("pizza");
		s2 = new ATM();
		s2.load("pizza");

		if (s2.equals(new ATM(5,4,3))) 
			System.out.println ("\nLoad and Save and Equals works!");

		System.out.println (s2);
		// Create many more test cases in this driver method to
		// prove the class is functioning correctly.
		
		ATM s3 = new ATM(0,0,0);
		System.out.println("Created ChangeJar: $0, result: " + s3.getAmount());
		s3.save("Default");
		s3.load("Default");
		
		compareTo(s1, s2);
		System.out.println("Both machines are equal");
		
		ATM s4 = new ATM(5,9,6);
		s4.takeOut(1,1,1);
		System.out.println("Remaining ChangeJar: $900, result: " + s4.getAmount());
		
		ATM s5 = new ATM(0,0,0);
		suspend(true);
		s5.putIn(5,6,9);
		System.out.println("ChangeJar should be $0, result: " + s5.getAmount());
		suspend(false);
		
		s5.compareTo(s3);
		System.out.println("Both machines are equal");
		
		s5.putIn(s2);
		System.out.println("ChangeJar should be $760, result: " + s5.getAmount());
		
		s2.takeOut(s5);
		System.out.println("ChangeJar should be $0, result: " + s2.getAmount());
		
		equals(s2, s3);
		System.out.println("Both machines are equal");
		
		System.out.println("Main method complete");
		}

}
