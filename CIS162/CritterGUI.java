import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

/**********************************************************
GUI for a critter simulation.  Impements Runnable to allow
a method to run in the background while the user continues
to click on buttons.

@author Scott Grissom
@author Alec Allain
@version 11/20/16
 ***********************************************************/
public class CritterGUI extends JFrame implements ActionListener, Runnable{

    /** simulation speed */
    private final int DELAY = 50;

    /** is simulation currently runnning? */
    private boolean isRunning;  

    /** the simulation object that controls everything */
    private Simulation world; 

    /** displays updated statistics */
    private JTextArea statsArea;

    // define buttons as neeeded
    private JButton ants;
    private JButton birds;
    private JButton hippos;
    private JButton vultures;
    private JButton lakers;
    private JButton start;
    private JButton stop;

    // define menu items as needed
    private JMenuBar menu;
    private JMenu fileMenu;
    private JMenuItem quitItem;
    private JMenuItem clearItem;
    
    /************************************************************
    Main method displays the simulation GUI
     ************************************************************/
    public static void main(String arg[]){
        CritterGUI gui = new CritterGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Critter Simulation");
        gui.setSize(600,600);
        gui.pack();
        gui.setVisible(true);
    }

    /************************************************************
    Create the GUI
     ************************************************************/
    public CritterGUI() {

        // simulation is turned off 
        isRunning = false;

        // create the lay out
        setLayout(new GridBagLayout());
        GridBagConstraints position = new GridBagConstraints();

        // Place the simulation on the screen
        position.gridx = 0;
        position.gridy = 1;
        position.gridwidth = 6;           
        world = new Simulation();
        add(world, position);

        // Place a label
        position.gridx = 6;
        position.gridy = 0;  
        add(new JLabel("Live Stats"),position);

        // Place stats area below the label
        statsArea = new JTextArea(7,12);
        statsArea.setBackground(Color.YELLOW);
        position.gridx = 6;
        position.gridy = 1;    
        position.anchor = GridBagConstraints.PAGE_START;
        add(statsArea, position);  
        statsArea.setText(world.getStats());

        // button for Start
        start = new JButton("Start");
        position.gridx = 1;
        position.gridy = 0;
        position.gridwidth = 1;
        add(start, position);
        
        // button for Stop
        stop = new JButton("Stop");
        position.gridx = 2;
        position.gridy = 0;
        position.gridwidth = 1;
        add (stop, position);
        
        // button for Ants
        ants = new JButton("Ants");
        ants.setForeground(Color.RED);
        position.gridx = 0;
        position.gridy = 3; 
        position.gridwidth = 1;
        add(ants, position);
        
        // button for Birds
        birds = new JButton("Birds");
        birds.setForeground(Color.BLUE);
        position.gridx = 1;
        position.gridy = 3;
        position.gridwidth = 1;
        add(birds, position);
        
        // button for Hippos
        hippos = new JButton("Hippos");
        hippos.setForeground(Color.GRAY);
        position.gridx = 2;
        position.gridy = 3;
        position.gridwidth = 1;
        add(hippos, position);
        
        // button for Vultures
        vultures = new JButton("Vultures");
        vultures.setForeground(Color.BLACK);
        position.gridx = 3;
        position.gridy = 3;
        position.gridwidth = 1;
        add(vultures, position);
        
        // button for Laker critter
        lakers = new JButton("Lakers");
        lakers.setForeground(Color.GREEN);
        position.gridx = 4;
        position.gridy = 3;
        position.gridwidth = 1;
        add(lakers, position);

        // create menu components
        menu = new JMenuBar();
        fileMenu = new JMenu("File");
        quitItem = new JMenuItem("Quit");
        clearItem = new JMenuItem("Clear");
        
        // add action listeners for each button
        ants.addActionListener(this);
        birds.addActionListener(this);
        vultures.addActionListener(this);
        hippos.addActionListener(this);
        lakers.addActionListener(this);
        start.addActionListener(this);
        stop.addActionListener(this);
        
        // action listeners for menu items
        quitItem.addActionListener(this);
        clearItem.addActionListener(this);
        
        // displays menu components
        fileMenu.add(clearItem);
        fileMenu.add(quitItem);
        
        menu.add(fileMenu);
        setJMenuBar(menu);

        // Advanced topic! this must be at the end of this method
        // start the simulation in separate thread
        new Thread(this).start();
    }

    /************************************************************
    Respond to button clicks
    @param e action even triggered by user
     ************************************************************/
    public void actionPerformed(ActionEvent e){
        
        // exit application if QUIT menu item
        if (e.getSource() == quitItem) {
            System.exit(1);
        }

        // set running variable to true if START button
        if (e.getSource() == start) {
            isRunning = true;
        }

        // set running variable to false if STOP button
        if (e.getSource() == stop) {
            isRunning = false;
        }
        
        // reset simulation if CLEAR menu item
        if (e.getSource() == clearItem) {
            world.reset();
        }

        // inject 10 ants if ANTS button
        if (e.getSource() == ants) { 
            world.addAnts(10);
        }

        // inject 10 birds if BIRDS button
        if (e.getSource() == birds) {
            world.addBirds(10);
        }
        
        // inject 10 hippos if HIPPOS button
        if (e.getSource() == hippos) {
            world.addHippos(10);
        }
        
        // inject 10 vultures if VULTURES button
        if (e.getSource() == vultures) {
            world.addVultures(10);
        }
        
        // inject 10 lakers if LAKERS button
        if (e.getSource() == lakers) {
            world.addLakers(10);
        }

        // Afterwards, update display and statistics
        world.repaint();
        statsArea.setText(world.getStats());
    }

    /************************************************************
    Once started, this method runs forever in a separate thread
    The simulation only advances and displays if the boolean
    variable is currently true
     ************************************************************/
    public void run(){
        try {

            // run forever
            while(true) {

                // only update simulation if it is running
                if (isRunning) {
                    world.oneStep();
                    statsArea.setText(world.getStats());
                }

                // pause between steps.  Otherwise, the simulation
                // would move too quickly to see
                Thread.sleep(DELAY);
            }
        }
        catch (InterruptedException ex) {
        }
    }    
}