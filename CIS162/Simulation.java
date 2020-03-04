import java.util.*;
import javax.swing.*;
import java.awt.*;

/****************************************************
 * Simulates a 2D world of critters that move around
 * and fight if they inhabit the same location.
 * 
 * @author Scott Grissom
 * @author Alec Allain
 * @version 11/25/16
 ***************************************************/
public class Simulation extends JPanel{

    /** a 2D world of critters */
    private GVcritter[][] theWorld;

    /** a collection of all live critters */
    private ArrayList <GVcritter> allCritters;

    /** control size of the world */
    private final int ROWS=50, COLUMNS=70, SIZE=10;

    /** keeps track of total steps */
    private int numSteps;

    /** number of species alive in the simulation */
    private int numAnts;
    private int numBirds;
    private int numVultures;
    private int numHippos;
    private int numLakers;

    /****************************************************
    Constructor instantiates and initializes all 
    instance members.
     ****************************************************/
    public Simulation(){
        theWorld = new GVcritter[ROWS][COLUMNS];
        allCritters = new ArrayList<GVcritter>();   
        numAnts=0;   
        numBirds = 0;
        numVultures = 0;
        numHippos = 0;
        numLakers = 0;
        numSteps = 0;

        // set the appropriate size of the invisibile drawing area
        setPreferredSize(new Dimension(COLUMNS*SIZE, ROWS*SIZE));
    }

    /****************************************************
     * prints out the status of the simulation
     ***************************************************/
    public String getStats() {
        String stats = "";
        stats = "Steps: " + numSteps + "\n" + "Ants: " + numAnts + "\n" + "Birds: " + numBirds + "\n" + "Hippos: " + numHippos + "\n" + "Vultures: " + numVultures + "\n" + "Lakers: " + numLakers + "\n";
        return stats;
    }

    /****************************************************
     * @return a random location that has no critter
     ***************************************************/
    private Location getOpenLocation() {
        // Still working on this method
        Location loc = new Location(1,1);

        int randomRow;
        int randomCol;
        Random rand = new Random();

        do {
            randomRow = rand.nextInt(ROWS);
            randomCol = rand.nextInt(COLUMNS);
        }
        while (theWorld[randomRow][randomCol] != null);

        if (theWorld[randomRow][randomCol] == null) {
            loc = new Location(randomRow,randomCol);
        }

        return loc;
    }

    /****************************************************
     * places critters in the world
     ***************************************************/
    private void placeCritter(GVcritter c) {
        allCritters.add(c);

        Location loc = c.getLocation();

        int row = loc.getRow();
        int col = loc.getCol();
        theWorld[row][col] = c;
    }

    /****************************************************
     * @return the neighbor of loc
     ***************************************************/
    private Location getRelativeLocation(Location loc, GVcritter.Direction d) {
        // Still working on this method
        int row = loc.getRow();
        int col = loc.getCol();

        if (d == GVcritter.Direction.NORTH) {
            // update row but check if it goes below 0
            row = row - 1;
            
            if (row < 0) {
                row = ROWS - 1;
            }
        }
        if (d == GVcritter.Direction.EAST) {
            // update column but check if it goes to COLUMN
            col = col + 1;
            
            if (col == COLUMNS) {
                col = 0;
            }

        }
        if (d == GVcritter.Direction.SOUTH) {
            // update row but check if it goes up to ROWS
            row = row + 1;
            
            if (row == ROWS) {
                row = 0;
            }

        }
        if (d == GVcritter.Direction.WEST) {
            // update column but check if it goes below 0
            col = col - 1;
            
            if (col < 0) {
                col = COLUMNS - 1;
            }

        }

        return new Location(row, col);
    }

    /****************************************************
     * resets the whole simulation
     ***************************************************/
    public void reset() {
        numSteps = 0;
        numAnts = 0;
        numBirds = 0;
        numHippos = 0;
        numVultures = 0;
        numLakers = 0;

        allCritters.clear();
        theWorld = new GVcritter[ROWS][COLUMNS];
    }

    /****************************************************
    Add the requested number of Ants into the simulation.
    Repeatedly ask for a random location that is free.
    Increment the number of Ants in the simulation.

    @param num number of ants
     ****************************************************/ 
    public void addAnts(int num){
        numAnts += num;
        for(int i=1;i<=num;i++){
            // create a new Ant at an open location
            Location loc = getOpenLocation();
            Ant c = new Ant(loc);
            placeCritter(c);
        }
    }

    /****************************************************
     * Adds the requested number of Birds
     * 
     * @param num number of birds
     ***************************************************/
    public void addBirds (int num) {
        numBirds += num;
        for (int i = 1; i <= num; i++) {
            // create a new Bird at an open location
            Location loc = getOpenLocation();
            Bird c = new Bird(loc);
            placeCritter(c);
        }
    }

    /****************************************************
     * Adds the requested number of Hippos
     * 
     * @param num number of hippos
     ***************************************************/
    public void addHippos (int num) {
        numHippos += num;
        for (int i = 1; i <= num; i++) {
            // create a new Hippo at an open location
            Location loc = getOpenLocation();
            Hippo c = new Hippo(loc);
            placeCritter(c);
        }
    }

    /****************************************************
     * Adds the requested number of Vultures
     * 
     * @param num number of vultures
     ***************************************************/
    public void addVultures (int num) {
        numVultures += num;
        for (int i = 1; i <= num; i++) {
            // create a new Vulture at an open location
            Location loc = getOpenLocation();
            Vulture c = new Vulture(loc);
            placeCritter(c);
        }
    }

    /****************************************************
     * Adds the requested number of myCritters/Lakers
     * 
     * @param num number of myCritters(Lakers)
     ***************************************************/
    public void addLakers (int num) {
        numLakers += num;
        for (int i = 1; i <= num; i++) {
            // create a new Vulture at an open location
            Location loc = getOpenLocation();
            Laker c = new Laker(loc);
            placeCritter(c);
        }
    }

    /**************************************
     * Determines the death of specific critter
     * 
     * @param c selects critter
     *************************************/
    private void critterDies(GVcritter c) {
        if (c.getSpecies() == GVcritter.Species.ANT) {
            numAnts--;
            allCritters.remove(c);
        }
        if (c.getSpecies() == GVcritter.Species.BIRD) {
            numBirds--;
            allCritters.remove(c);
        }
        if (c.getSpecies() == GVcritter.Species.VULTURE) {
            numVultures--;
            allCritters.remove(c);
        }
        if (c.getSpecies() == GVcritter.Species.HIPPO) {
            numHippos--;
            allCritters.remove(c);
        }
        if (c.getSpecies() == GVcritter.Species.LAKER) {
            numLakers--;
            allCritters.remove(c);
        }
    }
    
    /**************************************
     * Critters fighting for territory
     * 
     * @param attacker invades defender
     * @param defender protects itself
     *************************************/
    private void fight(GVcritter attacker, GVcritter defender) {
        // if critter has pounce attacker
        if (attacker.getAttack(defender) == GVcritter.Attack.POUNCE) {
            if (defender.getAttack(attacker) == GVcritter.Attack.SCRATCH) {
                theWorld[attacker.getLocation().getRow()][attacker.getLocation().getCol()] = null;
                
                critterDies(attacker);
            }
            else if (defender.getAttack(attacker) == GVcritter.Attack.ROAR)  {
                theWorld[defender.getLocation().getRow()][defender.getLocation().getCol()] = null;
                
                critterDies(defender);
            }
            else if (defender.getAttack(attacker) == GVcritter.Attack.FORFEIT) {
                theWorld[defender.getLocation().getRow()][defender.getLocation().getCol()] = null;
                
                critterDies(defender);
            }
        }
        // if critter has scratch attack 
        if (attacker.getAttack(defender) == GVcritter.Attack.SCRATCH) {
            if (defender.getAttack(attacker) == GVcritter.Attack.ROAR) {
                theWorld[attacker.getLocation().getRow()][attacker.getLocation().getCol()] = null;
                
                critterDies(attacker);
            }
            else if (defender.getAttack(attacker) == GVcritter.Attack.POUNCE)  {
                theWorld[defender.getLocation().getRow()][defender.getLocation().getCol()] = null;
                
                critterDies(defender);
            }
            else if (defender.getAttack(attacker) == GVcritter.Attack.FORFEIT) {
                theWorld[defender.getLocation().getRow()][defender.getLocation().getCol()] = null;
                
                critterDies(defender);
            }
        }
        // if critter has roar attack
        if (attacker.getAttack(defender) == GVcritter.Attack.ROAR) {
            if (defender.getAttack(attacker) == GVcritter.Attack.POUNCE) {
                theWorld[attacker.getLocation().getRow()][attacker.getLocation().getCol()] = null;
                
                critterDies(attacker);
            }
            else if (defender.getAttack(attacker) == GVcritter.Attack.SCRATCH) {
                theWorld[defender.getLocation().getRow()][defender.getLocation().getCol()] = null;
                
                critterDies(defender);
            }
            else if (defender.getAttack(attacker) == GVcritter.Attack.FORFEIT) {
                theWorld[defender.getLocation().getRow()][defender.getLocation().getCol()] = null;
                
                critterDies(defender);
            }
        }
    }
    
    /******************************************************
    Move forward on step of the simulation
     *****************************************************/  
    public void oneStep(){

        // shuffle the arraylist of critters for better performance
        Collections.shuffle(allCritters);
        numSteps++;

        // step throgh all critters using traditional for loop
        for(int i=0; i<allCritters.size(); i++){
            GVcritter attacker = allCritters.get(i);

            // what location does critter want to move to?
            GVcritter.Direction dir = attacker.getMoveDirection();
            Location previousLoc = attacker.getLocation();
            Location nextLoc = getRelativeLocation(previousLoc, dir);  

            // who is at the next location?
            GVcritter defender = theWorld[nextLoc.getRow()][nextLoc.getCol()];

            // no critters here so OK for critter 1 to move
            if(defender == null){
                theWorld[nextLoc.getRow()][nextLoc.getCol()] = attacker;
                attacker.setLocation(nextLoc);
                theWorld[previousLoc.getRow()][previousLoc.getCol()] = null;

                // both critters the same species so peacefully bypass 
            }else if(attacker.getSpecies() == defender.getSpecies()){

                // update critter locations
                attacker.setLocation(nextLoc);
                defender.setLocation(previousLoc);

                // update positions in the world
                theWorld[nextLoc.getRow()][nextLoc.getCol()] = attacker;
                theWorld[previousLoc.getRow()][previousLoc.getCol()] = defender;

                //different species so they fight at location of critter 2
            }else if(attacker.getSpecies() != defender.getSpecies()){
                fight(attacker, defender);
            }
        }

        // update drawing of the world
        repaint();
    }

    /******************************************************
    Step through the 2D world and paint each location white
    (for no critter) or the critter's color.  The SIZE of 
    each location is constant.

    @param g graphics element used for display
     *****************************************************/      
    public void paintComponent(Graphics g) {
        for(int row=0; row<ROWS; row++){
            for(int col=0; col<COLUMNS; col++){
                GVcritter c = theWorld[row][col];

                // set color to white or critter color
                if(c == null){
                    g.setColor(Color.WHITE);
                }else{    
                    g.setColor(c.getColor());
                }

                // paint the location
                g.fillRect(col*SIZE, row*SIZE, SIZE, SIZE);
            }
        }
    }  
}