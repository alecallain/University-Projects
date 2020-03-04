import java.awt.*;
import java.util.*;

/**********************************************
 * The Hippo class extends GVcritter. It gives
 * us access to all public/protected members
 * in GVcritter
 * 
 * @author Alec Allain 
 * @version 11/16/16
 *********************************************/
public class Hippo extends GVcritter {
    
    // sets direction for this hippo
    private Direction dir;
    
    // randomizes the hippo's age
    private int hippoAge;
    private Random random;
    
    /**********************************
     * Create starting values for this Hippo.
     * @param loc given location for this critter
     *********************************/
    public Hippo (Location loc) {
        super(loc);
        random = new Random(3);
        setColor(Color.GRAY);
        setSpecies(Species.HIPPO);
        
        hippoAge = (int) (Math.random() * 300 + 200);
        
        // pick random start direction
        if (Math.random() >= 1 && Math.random() <= 3) {
            dir = Direction.NORTH;
        }
        if (Math.random() >= 4 && Math.random() <= 7) {
            dir = Direction.EAST;
        }
        if (Math.random() >= 8 && Math.random() <= 11) {
            dir = Direction.SOUTH;
        }
        if (Math.random() >= 12 && Math.random() <= 14) {
            dir = Direction.WEST;
        }
    }
    
    /**********************************
     * Hippos always POUNCE at their opponents
     * unless they reached their old age
     * 
     * @param opponent who the bird's fighting
     * @return specified attack
     *********************************/
    public Attack getAttack(GVcritter opponent) {
        if (hippoAge >= 300 && hippoAge <= 500) {
            return Attack.FORFEIT;
        }
        else {
            return Attack.POUNCE;
        }
    }
    
    /**********************************
     * Hippos move in a randomized pattern
     * 
     * @return direction of next critter step
     *********************************/
    public Direction getMoveDirection() {
        // increase number of steps for hippo
        steps++;
        
        // alternate directions 
        if (steps % 20 < 5) {
            dir = Direction.WEST;
        }
        if (steps % 20 >= 6 && steps % 20 <= 10) {
            dir = Direction.SOUTH;
        }
        if (steps % 20 <= 15) {
            dir = Direction.NORTH;
        }
        if (steps % 20 >= 16 && steps % 20 <=20) {
            dir = Direction.EAST;
        }
        
        return dir;
    }
}
