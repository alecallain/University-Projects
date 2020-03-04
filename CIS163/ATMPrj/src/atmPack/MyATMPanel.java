package atmPack;
import java.awt.GridBagConstraints;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/******************************
 * This class simulates a live
 * display of 3 different ATMs
 * 
 * @author Alec Allain
 * @date 1/29/17
 * @due 2/5/17
 *****************************/

public class MyATMPanel extends JFrame implements ActionListener {
	
	/** Creates ATM machine */
	private ATM ATM;
	private ATM ATM2;
	private ATM ATM3;
	
	/** Labels the different machines */
	private JLabel firstATM;
	private JLabel secondATM;
	private JLabel thirdATM;
	
	/** Add buttons for machines */
	private JButton add1;
	private JButton add2;
	private JButton add3;
	
	/** Take out buttons for machines */
	private JButton subtract1;
	private JButton subtract2;
	private JButton subtract3;
	
	/** Suspend buttons for machines */
	private JButton suspend;
	private JButton unsuspend;
	
	/** Scanner for machines */
	private Scanner scnr;
	
	public static void main (String [] arg) {
		JFrame gui = new JFrame();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setName("ATM Machines");
		gui.setSize(600, 600);
		gui.pack();
		gui.setVisible(true);
	}

	public MyATMPanel() {
		
		GridBagConstraints position = new GridBagConstraints();
		
		// creates new machine
		ATM = new ATM();
		ATM2 = new ATM();
		ATM3 = new ATM();
		
		// creates label for ATM machine 1
		firstATM = new JLabel("ATM 1: " + ATM.getHundreds() + " hundreds, " + ATM.getFifties() + " fifties, & " + ATM.getTwenties() + " twenties");
		position.gridx = 0;
		position.gridy = 0;
		add (firstATM, position);
		
		// creates buttons for ATM machine 1
		add1 = new JButton("Deposit");
		position.gridx = 0;
		position.gridy = 1;
		position.gridwidth = 1;
		add (add1, position);
		
		subtract1 = new JButton("Withdrawl");
		position.gridx = 0;
		position.gridy = 2;
		position.gridwidth = 1;
		add (subtract1, position);
		
		// creates label for ATM machine 2
		secondATM = new JLabel("ATM 2: " + ATM2.getHundreds() + " hundreds, " + ATM2.getFifties() + " fifties, & " + ATM2.getTwenties() + " twenties");
		position.gridx = 1;
		position.gridy = 0;
		add (secondATM, position);
		
		// creates buttons for ATM machine 2
		add2 = new JButton("Deposit");
		position.gridx = 1;
		position.gridy = 1;
		position.gridwidth = 1;
		add (add2, position);
		
		subtract2 = new JButton("Withdrawl");
		position.gridx = 1;
		position.gridy = 2;
		position.gridwidth = 1;
		add (subtract2, position);
		
		// creates label for ATM machine 3
		thirdATM = new JLabel("ATM 3: " + ATM3.getHundreds() + " hundreds, " + ATM3.getFifties() + " fifties, & " + ATM3.getTwenties() + " twenties");
		position.gridx = 2;
		position.gridy = 0;
		add (thirdATM, position);
		
		// creates buttons for ATM machine 3
		add3 = new JButton("Deposit");
		position.gridx = 2;
		position.gridy = 1;
		position.gridwidth = 1;
		add (add3, position);
		
		subtract3 = new JButton("Withdrawl");
		position.gridx = 2;
		position.gridy = 2;
		position.gridwidth = 1;
		add (subtract3, position);
		
		// creates suspend buttons for all machines
		suspend = new JButton("Suspend");
		position.gridx = 0;
		position.gridy = 3;
		position.gridwidth = 1;
		add (suspend, position);
		
		unsuspend = new JButton("Unsuspend");
		position.gridx = 1;
		position.gridy = 3;
		position.gridwidth = 1;
		add (unsuspend, position);
		
		// Add Action Listeners to all buttons
		add1.addActionListener(this);
		subtract1.addActionListener(this);
		add2.addActionListener(this);
		subtract2.addActionListener(this);
		add3.addActionListener(this);
		subtract3.addActionListener(this);
		suspend.addActionListener(this);
		unsuspend.addActionListener(this);
		
	}
	
	public void actionPerformed (ActionEvent e) {
		scnr = new Scanner(System.in);
		
		int tempHundreds = 0;
		int tempFifties = 0;
		int tempTwenties = 0;
		
		if (e.getSource() == add1) {
			// asks user to insert money
			System.out.println("Please enter amount of hundreds");
			tempHundreds = scnr.nextInt();
			System.out.println("Please enter amount of fifties");
			tempFifties = scnr.nextInt();
			System.out.println("Please enter amount of twenties");
			tempTwenties = scnr.nextInt();
			ATM.putIn(tempHundreds, tempFifties, tempTwenties);
			// updates ATM 1 label
			firstATM.setText("ATM 1: " + ATM.getHundreds() + " hundreds, " + ATM.getFifties() + " fifties, & " + ATM.getTwenties() + " twenties");
		}
		
		if (e.getSource() == subtract1) {
			// asks user amount to withdraw
			System.out.println("Please enter amount of hundreds");
			tempHundreds = scnr.nextInt();
			System.out.println("Please enter amount of fifties");
			tempFifties = scnr.nextInt();
			System.out.println("Please enter amount of twenties");
			tempTwenties = scnr.nextInt();
			ATM.takeOut(tempHundreds, tempFifties, tempTwenties);
			// updates ATM 1 label
			firstATM.setText("ATM 1: " + ATM.getHundreds() + " hundreds, " + ATM.getFifties() + " fifties, & " + ATM.getTwenties() + " twenties");
		}
		
		if (e.getSource() == add2) {
			// asks user to insert money
			System.out.println("Please enter amount of hundreds");
			tempHundreds = scnr.nextInt();
			System.out.println("Please enter amount of fifties");
			tempFifties = scnr.nextInt();
			System.out.println("Please enter amount of twenties");
			tempTwenties = scnr.nextInt();
			ATM2.putIn(tempHundreds, tempFifties, tempTwenties);
			// updates ATM 2 label
			secondATM.setText("ATM 2: " + ATM2.getHundreds() + " hundreds, " + ATM2.getFifties() + " fifties, & " + ATM2.getTwenties() + " twenties");
			
		}
		
		if (e.getSource() == subtract2) {
			// asks user to take out money
			System.out.println("Please enter amount of hundreds");
			tempHundreds = scnr.nextInt();
			System.out.println("Please enter amount of fifties");
			tempFifties = scnr.nextInt();
			System.out.println("Please enter amount of twenties");
			tempTwenties = scnr.nextInt();
			ATM2.takeOut(tempHundreds, tempFifties, tempTwenties);
			// updates ATM 2 label
			secondATM.setText("ATM 2: " + ATM2.getHundreds() + " hundreds, " + ATM2.getFifties() + " fifties, & " + ATM2.getTwenties() + " twenties");
		}
		
		if (e.getSource() == add3) {
			// asks user to insert money
			System.out.println("Please enter amount of hundreds");
			tempHundreds = scnr.nextInt();
			System.out.println("Please enter amount of fifties");
			tempFifties = scnr.nextInt();
			System.out.println("Please enter amount of twenties");
			tempTwenties = scnr.nextInt();
			ATM3.putIn(tempHundreds, tempFifties, tempTwenties);
			// updates ATM 3 label
			thirdATM.setText("ATM 3: " + ATM3.getHundreds() + " hundreds, " + ATM3.getFifties() + " fifties, & " + ATM3.getTwenties() + " twenties");
			
		}
		
		if (e.getSource() == subtract3) {
			// asks user to take out money
			System.out.println("Please enter amount of hundreds");
			tempHundreds = scnr.nextInt();
			System.out.println("Please enter amount of fifties");
			tempFifties = scnr.nextInt();
			System.out.println("Please enter amount of twenties");
			tempTwenties = scnr.nextInt();
			ATM3.takeOut(tempHundreds, tempFifties, tempTwenties);
			// updates ATM 3 label
			thirdATM.setText("ATM 3: " + ATM3.getHundreds() + " hundreds, " + ATM3.getFifties() + " fifties, & " + ATM3.getTwenties() + " twenties");
		}
		
		if (e.getSource() == suspend) {
			atmPack.ATM.suspend(true);
			ATM2.suspend(true);
			ATM3.suspend(true);
		}
		
		if (e.getSource() == unsuspend) {
			atmPack.ATM.suspend(false);
			ATM2.suspend(false);
			ATM3.suspend(false);
		}
		
	}
			
}
