/*
 * Project 1 ATM class
 * @author Jacob Walton
 * @version January 2017
 * 
 * A class that simulates a high-end ATM machine with hundreds, fifties, and twenties.
 * 
 * **Some comments copied from project description, credit to professors.
 * 
 */

 

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class ATM
{
	private int hundreds, fifties, twenties;

	private Boolean run = true;

	/***************************************************
	 * Empty constructor for ATM class
	 * 
	 ***************************************************/
	public ATM()
	{
		this.hundreds = 0;
		this.fifties = 0;
		this.twenties = 0;

		// TODO Auto-generated constructor stub
	}

	/***************************************************
	 * Constructor for ATM class
	 * 
	 * @param hundreds
	 *            number of hundred dollar bills
	 * @param fifties
	 *            number of fifty dollar bills
	 * @param twenties
	 *            number of twenty dollar bills
	 * 
	 ***************************************************/
	public ATM(int hundreds, int fifties, int twenties)
	{
		if ((hundreds >= 0) && (fifties >= 0) && (twenties >= 0))
		{
			this.hundreds = hundreds;
			this.fifties = fifties;
			this.twenties = twenties;
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}

	/***************************************************
	 * Constructor for ATM class
	 * 
	 * @param other
	 *            an ATM object that will be copied into this ATM
	 ***************************************************/
	public ATM(ATM other)
	{
		if (other instanceof ATM)
		{
			// initialize ATM to have nothing
			this.hundreds = 0;
			this.fifties = 0;
			this.twenties = 0;

			// put in the other ATM
			putIn(other);
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}

	/***************************************************
	 * @return the hundreds
	 ***************************************************/
	public int getHundreds()
	{
		return hundreds;
	}

	/***************************************************
	 * @param hundreds
	 *            the hundreds to set
	 ***************************************************/
	public void setHundreds(int hundreds)
	{
		if (hundreds >= 0)
		{
			this.hundreds = hundreds;
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}

	/****************************************************
	 * @return the fifties
	 ***************************************************/
	public int getFifties()
	{
		return fifties;
	}

	/****************************************************
	 * @param fifties
	 *            the fifties to set
	 ***************************************************/
	public void setFifties(int fifties)
	{
		if (fifties >= 0)
		{
			this.fifties = fifties;
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}

	/****************************************************
	 * @return the twenties
	 ***************************************************/
	public int getTwenties()
	{
		return twenties;
	}

	/****************************************************
	 * @param twenties
	 *            the twenties to set
	 ***************************************************/
	public void setTwenties(int twenties)
	{
		if (twenties >= 0)
		{
			this.twenties = twenties;
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}

	/***************************************************
	 * A method that returns the amount of this ATM object
	 * 
	 * @return amount of cash in the ATM
	 ***************************************************/
	public int getAmount()
	{
		int twenties, fifties, hundreds, total;

		// get values
		twenties = getTwenties();
		fifties = getFifties();
		hundreds = getHundreds();

		// calculate
		total = (twenties * 20) + (fifties * 50) + (hundreds * 100);

		return total;
	}

	/***************************************************
	 * A method that returns true if “this” ATM object is exactly the same as
	 * the other object (Note: you must cast the other object as a ATM object).
	 * That is, hundreds = other.hundreds, fifties = other.fifties.
	 * 
	 * 
	 * @param other1
	 *            an ATM object to be compared
	 * @return true false value of whether or not other is the same as this ATM
	 * @see java.lang.Object#equals(java.lang.Object)
	 ***************************************************/
	public boolean equals(Object other)
	{
		// Check if Object is of type ATM
		if (other instanceof ATM)
		{
			// Compare amounts in two ATM's
			return ATM.equals(this, (ATM) other);
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}

	/***************************************************
	 * A method that returns true if “this” ATM object is exactly the same as
	 * the other ATM object.
	 * 
	 * @param other
	 *            an ATM object to be compared
	 * @return true false value of whether or not other is the same as this ATM
	 ***************************************************/
	public boolean equals(ATM other)
	{
		return ATM.equals(this, other);
	}

	/***************************************************
	 * A static method that returns true if ATM object other1 is exactly the
	 * same as if ATM object other2.
	 * 
	 * @param other1
	 *            an ATM object to be compared
	 * @param other2
	 *            an ATM object to be compared
	 * @return true false value of whether or not other1 is the same as other2
	 ***************************************************/
	public static boolean equals(ATM other1, ATM other2)
	{
		// Compare ATMs
		boolean same = true;
		while (same)
		{
			if (!(other1.getTwenties() == other2.getTwenties()))
				same = false;
			if (!(other1.getFifties() == other2.getFifties()))
				same = false;
			if (!(other1.getHundreds() == other2.getHundreds()))
				same = false;
			break;
		}

		if (same)
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	/***************************************************
	 * A method that returns 1 if “this” ATM object is greater than (based upon
	 * the total in the ATM) the other ATM object; returns -1 if the “this” ATM
	 * object is less than the other ATM; returns 0 if the “this” ATM object is
	 * equal to the other ATM object.
	 * 
	 * 
	 * @param other
	 *            an ATM object to be compared
	 * @return value from 1(greater) to -1(less) whether or not other is
	 *         greater(1) than this ATM
	 ***************************************************/
	public int compareTo(ATM other)
	{

		return compareTo(this, other);
	}

	/***************************************************
	 * A method that returns other1 if ATM object other1 is greater than ATM
	 * object other2; returns -1 if the ATM object other1 is less than ATM
	 * other2; returns 0 if the ATM object other1 is equal to ATM object other2.
	 * 
	 * 
	 * @param other1
	 *            an ATM object to be compared
	 * @param other2
	 *            an ATM object to be compared
	 * @return value from 1(greater) to -1(less) whether or not other1 is
	 *         greater(1) than this other2
	 ***************************************************/
	public static int compareTo(ATM other1, ATM other2)
	{
		int flag = 0;
		if (other1.getAmount() > other2.getAmount())
			flag = 1;
		if (other1.getAmount() < other2.getAmount())
			flag = -1;

		return flag;
	}

	/***************************************************
	 * A method that adds the parameters from the “this” ATM object. You may
	 * assume all of the parameter are positive (only for step 2).
	 * 
	 * @param hundreds
	 *            the number of hundred dollar bills
	 * @param fifties
	 *            the number of fifty dollar bills
	 * @param twenties
	 *            the number of twenty dollar bills
	 ***************************************************/
	public void putIn(int hundreds, int fifties, int twenties)
	{
		if (this.run)
		{
			if ((hundreds >= 0) && (fifties >= 0) && (twenties >= 0))
			{
				this.twenties += twenties;
				this.fifties += fifties;
				this.hundreds += hundreds;
			}
			else
			{
				throw new IllegalArgumentException();
			}
		}
		else
		{
			return;
		}
	}

	/***************************************************
	 * A method that adds ATM other to the “this” ATM object.s\
	 * 
	 * @param other
	 *            an ATM object to be added
	 ***************************************************/
	public void putIn(ATM other)
	{
		if (this.run)
		{
			if (other instanceof ATM)
			{
				putIn(other.getHundreds(), other.getFifties(), other.getTwenties());
			}
			else
			{
				throw new IllegalArgumentException();
			}
		}

		else
		{
			return;
		}

	}

	/***************************************************
	 * A method that subtracts the parameters from the “this” ATM object. You
	 * may assume all of the parameter are positive, and there is sufficient
	 * quantities in the ATM (only for step 2).
	 * 
	 * @param hundreds
	 *            the number of hundred dollar bills
	 * @param fifties
	 *            the number of fifty dollar bills
	 * @param twenties
	 *            the number of twenty dollar bills
	 * 
	 ***************************************************/
	public void takeOut(int hundreds, int fifties, int twenties)
	{
		if (this.run)
		{
			if ((hundreds >= 0) && (fifties >= 0) && (twenties >= 0))
			{
				if ((this.twenties - twenties) >= 0)
					this.twenties -= twenties;
				else
					throw new IllegalArgumentException();
				if ((this.fifties - fifties) >= 0)
					this.fifties -= fifties;
				else
					throw new IllegalArgumentException();
				if ((this.hundreds - hundreds) >= 0)
					this.hundreds -= hundreds;
				else
					throw new IllegalArgumentException();
			}
			else
			{
				throw new IllegalArgumentException();
			}
		}
		else
		{
			return;
		}

	}

	/***************************************************
	 * A method that subtracts ATM other from the “this” ATM object.
	 * 
	 * @param other
	 *            an ATM object to be subtracted
	 ***************************************************/
	public void takeOut(ATM other)
	{
		if (this.run)
		{
			if (other instanceof ATM)
			{
				takeOut(other.getHundreds(), other.getFifties(), other.getTwenties());
			}
			else
			{
				throw new IllegalArgumentException();
			}
		}
		else
		{
			return;
		}
	}

	/***************************************************
	 * This method returns ATM that has the exact number of hundreds, fifties,
	 * twenties that would sum to the amount (Maximize the largest currency in
	 * the returned ATM). The amount must be divisible by 10. NOT NECESSARY ANYMORE.
	 ***************************************************/
	public ATM takeOut(double amount)
	{
		return null;

	}

	/***************************************************
	 * Method that returns a string that represents a ATM with the following
	 * format: “1 hundred dollar bill, 10 fty dollar bills, 1 twenty dollar
	 * bill”. Be sure to use proper pluralization. For example, bill or bills
	 * (see output in step 4). (non-Javadoc)
	 * 
	 * @return a string that represents an ATM
	 * @see java.lang.Object#toString()
	 ***************************************************/
	public String toString()
	{
		String hundredsStr, fiftiesStr, twentiesStr;
		if (this.hundreds != 1)
		{
			hundredsStr = this.hundreds + " hundred dollar bills, ";
		}
		else
		{
			hundredsStr = this.hundreds + " hundred dollar bill, ";
		}
		if (this.fifties != 1)
		{
			fiftiesStr = this.fifties + " fifty dollar bills, and ";
		}
		else
		{
			fiftiesStr = this.fifties + " fifty dollar bill, and ";
		}
		if (this.twenties != 1)
		{
			twentiesStr = this.twenties + " twenty dollar bills.";
		}
		else
		{
			twentiesStr = this.twenties + " twenty dollar bill.";
		}

		return hundredsStr + fiftiesStr + twentiesStr;
	}

	/**
	 * A method that saves the “this” ATM to a file; use the parameter filename
	 * for the name of the file.
	 * 
	 * @param fileName
	 */
	public void save(String fileName)
	{
		PrintWriter out = null;
		try
		{
			out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		String s = this.hundreds + "\n" + fifties + "\n" + twenties + "\n";
		out.println(s);
		out.close();
	}

	/**
	 * A method that loads the “this” ATM object from a file; use the parameter
	 * filename for the name of the file.
	 * 
	 * @param fileName
	 */
	public void load(String fileName)
	{
		try
		{
			// open the data file
			Scanner fileReader = new Scanner(new File(fileName));

			// read one String in of data and an int
			this.hundreds = fileReader.nextInt();
			this.fifties = fileReader.nextInt();
			this.twenties = fileReader.nextInt();
			System.out.println(toString());
			fileReader.close();
		}

		// could not find file
		catch (Exception error)
		{
			System.out.println("File not found ");
		}
	}

	/**
	 * A method that turns ‘off’ or ‘on’ any takeOut/putIn methods in. In other
	 * words, when true, prevents any takeOut/putIn method from changing
	 * (mutate) the state of the “this” object as it relates to the amount in
	 * the ATM.
	 * 
	 * @param on
	 */
	public void suspend(Boolean on)
	{
		if (!on)
		{
			this.run = true;
		}
		else
		{
			this.run = false;
		}
	}

	/***************************************************
	 * 
	 * main function to test the class.
	 * 
	 * @param args
	 ***************************************************/
	public static void main(String[] args)
	{
		ATM s = new ATM(10, 2, 3);
		System.out.println("Created ATM:$1160, result: " + s.getAmount());
		ATM s1 = new ATM();
		System.out.println("\nCreated ATM:$0, result: " + s1.getAmount());
		s1.putIn(10, 2, 3);
		System.out.println("\nAdded ATM:$1160, result: " + s1.getAmount());
		ATM s2 = new ATM(10, 2, 3);
		s2.putIn(0, 0, 0);
		System.out.println("\nAdded ATM:$1160, result: " + s2.getAmount());
		s2 = new ATM(2, 1, 3);
		// ATM temp = s2.takeOut(250);
		// System.out.println("\nTake out the following:\n" + temp);
		System.out.println("Remaining ATM:$310, result: " + s2.getAmount());
		s2 = new ATM(5, 4, 3);
		s2.save("pizza");
		s2 = new ATM();
		s2.load("pizza");
		if (s2.equals(new ATM(5, 4, 3)))
			System.out.println("\nLoad and Save and Equals works!");
		System.out.println(s2 + "\n\n");
		// Create many more test cases in this driver method to
		// prove the class is functioning correctly.

		// exception should be thrown for neg Hundreds
		try
		{
			@SuppressWarnings("unused")
			ATM t = new ATM(-10, 2, 3);
		}
		catch (Exception error)
		{
			System.out.println("Test constructor neg Hundreds passed.");
		}

		// exception should be thrown for neg fifties
		try
		{
			@SuppressWarnings("unused")
			ATM t1 = new ATM(10, -2, 3);
		}
		catch (Exception error)
		{
			System.out.println("Test constructor neg Fifties passed.");
		}

		// exception should be thrown for neg twenties
		try
		{
			@SuppressWarnings("unused")
			ATM t2 = new ATM(10, 2, -3);
		}
		catch (Exception error)
		{
			System.out.println("Test constructor neg Twenties passed.");
		}

		// testing putIn
		ATM test = new ATM();

		// exception should be thrown for neg Hundreds
		try
		{
			test.putIn(-100, 0, 0);
		}
		catch (Exception error)
		{
			System.out.println("Test putIn neg Hundreds passed.");
		}

		// exception should be thrown for neg fifties
		try
		{
			test.putIn(0, -100, 0);
		}
		catch (Exception error)
		{
			System.out.println("Test putIn neg Fifties passed.");
		}

		// exception should be thrown for neg twenties
		try
		{
			test.putIn(0, 0, -100);
		}
		catch (Exception error)
		{
			System.out.println("Test putIn neg Twenties passed.");
		}

		// testing takeOut
		// exception should be thrown for neg Hundreds
		try
		{
			test.takeOut(-100, 0, 0);
		}
		catch (Exception error)
		{
			System.out.println("Test takeOut neg Hundreds passed.");
		}

		// exception should be thrown for neg fifties
		try
		{
			test.takeOut(0, -100, 0);
		}
		catch (Exception error)
		{
			System.out.println("Test takeOut neg Fifties passed.");
		}

		// exception should be thrown for neg twenties
		try
		{
			test.takeOut(0, 0, -100);
		}
		catch (Exception error)
		{
			System.out.println("Test takeOut neg Twenties passed.");
		}
		
		
		//test suspend
		test.suspend(false);
		test.putIn(2,2,2);
		test.takeOut(1,1,1);
		System.out.println("\n" + test.toString() + "\nIf all values are 0, suspend works!\n");
		
		//test resume
		test.suspend(true);
		test.putIn(2,2,2);
		test.takeOut(1, 1, 1);
		System.out.println(test.toString() + "\nIf all values are 1, resume works!\n");
		
		
		//test setters
		test.takeOut(1,1,1);
		try
		{
			test.setFifties(-20);
		}
		catch (Exception error)
		{
			System.out.println("Test set neg fifties passed.");
		}
		
		try
		{
			test.setHundreds(-20);
		}
		catch (Exception error)
		{
			System.out.println("Test set neg hundreds passed.");
		}
		
		try
		{
			test.setTwenties(-20);
		}
		catch (Exception error)
		{
			System.out.println("Test set neg twenties passed.");
		}
		
		System.out.println("\nAll values should be zero for setter test: \n" + test.toString());
		

	}
}
