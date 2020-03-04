/*
 * Project 1 ATM JPanel class
 * @author Jacob Walton
 * @version January 2017
 * 
 * A class that creates a JPanel for the GUI of my high-end ATM machine
 *  with hundreds, fifties, and twenties.
 * 
 * 
 */

 


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyATMPanel extends JPanel
{

	/**
	 * Label to fix error
	 */
	private static final long serialVersionUID = 3103492074416375503L;

	ATM atm1 = new ATM();

	private JLabel label_fiftyDollars, label_twentyDollars, label_hundredDollars;
	private JLabel label_totalAmount;

	private JButton addHundred, addFifty, addTwenty;
	private JButton subHundred, subFifty, subTwenty, suspend, resume;

	public MyATMPanel () {

			ButtonListener buttonListen = new ButtonListener();
			//setLayout(new GridLayout(3,4));
			
			//Labels
			label_hundredDollars = new JLabel("# of Hundreds: " + atm1.getHundreds());
			add(label_hundredDollars);
			label_fiftyDollars = new JLabel("# of Fifties: " + atm1.getFifties());
			add(label_fiftyDollars);
			label_twentyDollars = new JLabel("# of Twenties: " + atm1.getTwenties());
			add(label_twentyDollars);
			label_totalAmount = new JLabel("Total Amount: $" + atm1.getAmount());
			add(label_totalAmount);
			
			//add Buttons
			addHundred = new JButton("add $100");
			addHundred.addActionListener(buttonListen);
			add(addHundred);
			addFifty = new JButton("add $50");
			addFifty.addActionListener(buttonListen);
			add(addFifty);
			addTwenty = new JButton("add $20");
			addTwenty.addActionListener(buttonListen);
			add(addTwenty);
			
			
			//Subtract buttons
			subHundred = new JButton("Subtract $100");
			subHundred.addActionListener(buttonListen);
			add(subHundred);
			subFifty = new JButton("Subtract $50");
			subFifty.addActionListener(buttonListen);
			add(subFifty);
			subTwenty = new JButton("Subtract $20");
			subTwenty.addActionListener(buttonListen);
			add(subTwenty);
			
			//suspend and resume buttons
			suspend = new JButton("suspend");
			suspend.addActionListener(buttonListen);
			add(suspend);
			resume = new JButton("resume");
			resume.addActionListener(buttonListen);
			add(resume);

		}

	private class ButtonListener implements ActionListener
	{

		public void actionPerformed(ActionEvent arg0)
		{

			// add or subtract
			if (arg0.getSource() == addHundred)
				atm1.putIn(1, 0, 0);
			if (arg0.getSource() == addFifty)
				atm1.putIn(0, 1, 0);
			if (arg0.getSource() == addTwenty)
				atm1.putIn(0, 0, 1);
			if (arg0.getSource() == subHundred)
				atm1.takeOut(1, 0, 0);
			if (arg0.getSource() == subFifty)
				atm1.takeOut(0, 1, 0);
			if (arg0.getSource() == subTwenty)
				atm1.takeOut(0, 0, 1);
			if (arg0.getSource() == suspend)
				atm1.suspend(true);
			if (arg0.getSource() == resume)
				atm1.suspend(false);
			

			// Update labels
			label_hundredDollars.setText("# of Hundreds: " + atm1.getHundreds());
			label_fiftyDollars.setText("# of Fifties: " + atm1.getFifties());
			label_twentyDollars.setText("# of Twenties: " + atm1.getTwenties());
			label_totalAmount.setText("Total Amount: $" + atm1.getAmount());

		}

	}
}
