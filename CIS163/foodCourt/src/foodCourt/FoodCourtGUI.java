package foodCourt;

import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.awt.*;
import javax.swing.*;

/************************************
 * This class simulates a graphical
 * user interface for the
 * FoodCourt class
 * 
 * @author Alec Allain
 * @author Trevor Sundelius 
 * @author Colton Scranton
 ***********************************/
public class FoodCourtGUI extends JFrame implements ActionListener, ClockListener {
	
	private static final long serialVersionUID = 1L;
 	// section for instance variables
 	
 	/** integers for gui */
 	private int nextPeople;
 	private int cashierSec;
 	private int totalTimes;
 	private int averageSeconds;
 	private int secondsLeave;
 	private int eateryNumber;
 	
 	private int maxPeople;
 	private int throughPeople;
 	private int time;
 	private int linePeople;
 	private int queLine;
 	
 	/** start and stop interaction buttons */
 	JButton start;
 	JButton stop;
 	
 	/** text fields for customer information */
 	JTextField personNext;
 	JTextField secondsCashier;
 	JTextField timeTotal;
 	JTextField secondsEatery;
 	JTextField leavingPerson;
 	JTextField eateryTotal;
 	
 	/** text area for statistics */
 	// JTextArea stats;
 	
 	/** labels for customer information */
 	// input labels
 	JLabel insertInfo;
 	JLabel nextPerson;
 	JLabel cashierSeconds;
 	JLabel totalTime;
 	JLabel eaterySeconds;
 	JLabel personLeaves;
 	JLabel totalEateries;
 	
 	// output labels
 	JLabel outputInfo;
 	JLabel through;
 	JLabel startToFinish;
 	JLabel peopleLeft;
 	JLabel queLength;
 	
 	JLabel throughOutput;
 	JLabel startFinish;
 	JLabel leftPeople;
 	JLabel lengthOfQue;
 	
 	/********************
 	 * constructor for gui
 	 *******************/
 	public FoodCourtGUI() {
 		
 		// instantiates instance integers
 		maxPeople = 0;
 		throughPeople = 0;
 		time = 0;
 		linePeople = 0;
 		queLine = 0;
 		
 		setLayout(new GridBagLayout());
 		GridBagConstraints position = new GridBagConstraints();
 		
 		// creates start button
 		start = new JButton("Start Simulation");
 		position.gridx = 1;
 		position.gridy = 8;
 		position.gridwidth = 1;
 		add(start, position);
 		start.addActionListener(this);
 		
 		// created stop button
 		stop = new JButton("Stop Simulation");
 		position.gridx = 2;
 		position.gridy = 8;
 		position.gridwidth = 1;
 		add(stop, position);
 		stop.addActionListener(this);
 		
 		// creates new text area
 		
 		// i don't think this works correctly
 		//stats = new JTextArea(15,30);
 		//position.gridx = 0;
 		//position.gridy = 9;
 		//position.gridwidth = 3;
 		//add(stats, position);
 		//stats.setText(getStats());
 		
 		// creates new labels for text fields
 		// input information labels
 		insertInfo = new JLabel("Input information");
 		position.gridx = 2;
 		position.gridy = 0;
 		add(insertInfo, position);
 		
 		nextPerson = new JLabel("Seconds to the next person");
 		position.gridx = 0;
 		position.gridy = 2;
 		position.gridwidth = 1;
 		add(nextPerson, position);
 		
 		cashierSeconds = new JLabel("Average seconds per cashier");
 		position.gridx = 0;
 		position.gridy = 3;
 		position.gridwidth = 1;
 		add(cashierSeconds, position);
 		
 		totalTime = new JLabel("Total time in seconds");
 		position.gridx = 0;
 		position.gridy = 4;
 		position.gridwidth = 1;
 		add(totalTime, position);
 		
 		eaterySeconds = new JLabel("Average seconds per eatery");
 		position.gridx = 0;
 		position.gridy = 5;
 		position.gridwidth = 1;
 		add(eaterySeconds, position);
 		
 		personLeaves = new JLabel("Seconds before person leaves");
 		position.gridx = 0;
 		position.gridy = 6;
 		position.gridwidth = 1;
 		add(personLeaves, position);
 		
 		totalEateries = new JLabel("Number of eateries");
 		position.gridx = 0;
 		position.gridy = 7;
 		position.gridwidth = 1;
 		add(totalEateries, position);
 		
 		// output information labels
 		outputInfo = new JLabel("Output Information");
 		position.gridx = 0;
 		position.gridy = 9;
 		position.gridheight = 1;
 		add(outputInfo, position);
 		
 		through = new JLabel("Throughput");
 		position.gridx = 0;
 		position.gridy = 10;
 		position.gridheight = 1;
 		add(through, position);
 		
 		startToFinish = new JLabel("Average time for person from start to finish");
 		position.gridx = 0;
 		position.gridy = 11;
 		position.gridheight = 1;
 		add(startToFinish, position);
 		
 		peopleLeft = new JLabel("Number of people left in line");
 		position.gridx = 0;
 		position.gridy = 12;
 		position.gridheight = 1;
 		add(peopleLeft, position);
 		
 		queLength = new JLabel("Max Q length cashier line");
 		position.gridx = 0;
 		position.gridy = 13;
 		position.gridheight = 1;
 		add(queLength, position);
 		
 		throughOutput = new JLabel("0");
 		position.gridx = 2;
 		position.gridy = 10;
 		position.gridheight = 1;
 		add(throughOutput, position);
 		
 		startFinish = new JLabel("0");
 		position.gridx = 2;
 		position.gridy = 11;
 		position.gridheight = 1;
 		add(startFinish, position);
 		
 		leftPeople = new JLabel("0");
 		position.gridx = 2;
 		position.gridy = 12;
 		position.gridheight = 1;
 		add(leftPeople, position);
 		
 		lengthOfQue = new JLabel("0");
 		position.gridx = 2;
 		position.gridy = 13;
 		position.gridheight = 1;
 		add(lengthOfQue, position);
 		
 		// creates new text fields
 		personNext = new JTextField(15);
 		position.gridx = 2;
 		position.gridy = 2;
 		position.gridwidth = 1;
 		add(personNext, position);
 		
 		secondsCashier= new JTextField(15);
 		position.gridx = 2;
 		position.gridy = 3;
 		position.gridwidth = 1;
 		add(secondsCashier, position);
 		
 		timeTotal = new JTextField(15);
 		position.gridx = 2;
 		position.gridy = 4;
 		position.gridwidth = 1;
 		add(timeTotal, position);
 		
 		secondsEatery = new JTextField(15);
 		position.gridx = 2;
 		position.gridy = 5;
 		position.gridwidth = 1;
 		add(secondsEatery, position);
 		
 		leavingPerson = new JTextField(15);
 		position.gridx = 2;
 		position.gridy = 6;
 		position.gridwidth = 1;
 		add(leavingPerson, position);
 		
 		eateryTotal = new JTextField(15);
 		position.gridx = 2;
 		position.gridy = 7;
 		position.gridwidth = 1;
 		add(eateryTotal, position);
 		
 	}
 	
 	/***********************
 	 * handles all button and menu selections
 	 * 
 	 * @param e is the component pressed
 	 **********************/
 	public void actionPerformed(ActionEvent e) {
 		if (e.getSource() == start) {
 			runSim();
 		}
 		
 		if (e.getSource() == stop) {
 			updateLabels();
 		}
 	}
 	
 	/***************************
 	 *  updates the statistics area
 	 **************************/
 	public void updateLabels() {
 		
 		throughOutput.setText(throughPeople + " people with Max = " + maxPeople);
 		startFinish.setText(time + " seconds");
 		leftPeople.setText(linePeople + " people");
 		lengthOfQue.setText(queLine + "");
 		
 	}
 	
 	/**
 	 * runs entire simulation
 	 */
 	public void runSim() {
 
 		Random r = new Random();
 		double rt;
 		double se;
 		
 		nextPeople = Integer.parseInt(personNext.getText());
 		cashierSec = Integer.parseInt(secondsCashier.getText());
 		totalTimes = Integer.parseInt(timeTotal.getText());
 		averageSeconds = Integer.parseInt(secondsEatery.getText());
 		secondsLeave = Integer.parseInt(leavingPerson.getText());
 		eateryNumber = Integer.parseInt(eateryTotal.getText());
 		
 		rt = cashierSec * 0.1 * r.nextGaussian() + cashierSec;
 		se = averageSeconds * 0.1 * r.nextGaussian() + averageSeconds;
 		
 		Clock clk = new Clock();
 		//Eatery booth = new Eatery();
 		Cashier cash1 = new Cashier();
 		Cashier cash2 = new Cashier();
 		
 		List<Eatery> eatList = new ArrayList<Eatery>();
 		for (int i = 0; i < eateryNumber; i++) {
 			Eatery booth = new Eatery();
 			eatList.add(booth);
 		  // or new Card(i) as the case may be
 		}
 		
 		List<Cashier> cashList = new ArrayList<Cashier>();
 		  // or new Card(i) as the case may be
 			
 
 		int check = 0; 
 		for (int i = 0; i < eateryNumber; i++) {
 		if ( check == 0 ){
 			cashList.clear();
 			cashList.add(cash1);
 			check = 1;
 		}
 		else{
 			cashList.clear();
 			cashList.add(cash2);
 			check = 0;
 		}
 		
 		PersonProducer produce = new PersonProducer(eatList.get(i), cashList.get(0), nextPeople, averageSeconds, cashierSec);
 		
 		clk.add(eatList.get(i));
 		clk.add(produce);
 		}
 		
 		clk.add(cash1);
 		clk.add(cash2);
 		
 		clk.run(totalTimes);
 		this.time = clk.getNumListeners();
 		startFinish.setText(time + " seconds");
 		
 		int through = cash2.getThroughPut() + cash1.getThroughPut();
 		String thu = Integer.toString(through);
 		throughPeople = through;
 		maxPeople = through;
 		throughOutput.setText(thu + " people with Max = " + thu);
 		
 		int left = cash1.getLeft() + cash2.getLeft();
 		String l = Integer.toString(left);
 		linePeople = left;
 		leftPeople.setText(l + " people");
 		
 		int que = cash1.getMaxQlength() + cash2.getMaxQlength();
 		String q = Integer.toString(que);
 		queLine = que;
 		lengthOfQue.setText(q);
 		
 		
 	}
 
 	/************************
 	 * main method
 	 ***********************/
 	public static void main(String [] args) {
 		FoodCourtGUI gui = new FoodCourtGUI();
 		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		gui.setTitle("Food Court Simulation");
 		gui.setSize(1000,1000);
 		gui.pack();
 		gui.setVisible(true);
 	}
 
 	@Override
 	public void event(int tick) {
 		if (tick == 20) {
 			
 		}
 		
 		if (tick == 40) {
 			
 		}
 		
 	}
 	
	
}
