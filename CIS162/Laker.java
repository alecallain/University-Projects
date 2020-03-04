import java.awt.*;

/**************************************************
 * The MyCritter class extends GVcritter. It gives
 * us access o all public and protected members 
 * in GVcritter.
 * 
 * @author Alec Allain
 * @version 11/22/16
 *************************************************/
public class Laker extends GVcritter
{

    // start driection for myCritter
    private Direction dir;
    
    /**********************************
     * Create starting values for this Laker.
     * @param loc given location for this critter
     *********************************/
    public Laker (Location loc) {
        super(loc);
        setColor(Color.GREEN);
        setSpecies(Species.LAKER);
        
        if (Math.random() < 1) {
            dir = Direction.WEST;
        }
        else if (Math.random() >= 5 && Math.random() <= 10) {
            dir = Direction.EAST;
        }
        else {
            dir = Direction.SOUTH;
        }
    }

    /************************************
     * Lakers are the dominent species and
     * always attack with correct stratagy
     * 
     * @param opponent who is the critter fighting?
     * @return attack strategy
     ***********************************/
    public Attack getAttack (GVcritter opponent) {
        if (opponent.getSpecies() == Species.ANT) {
            return Attack.ROAR;
        }
        else if (opponent.getSpecies() == Species.BIRD) {
            return Attack.POUNCE;
        }
        else if (opponent.getSpecies() == Species.VULTURE) {
            return Attack.POUNCE;
        }
        else if (opponent.getSpecies() == Species.HIPPO) {
            return Attack.SCRATCH;
        }
        else {
            return Attack.ROAR;
        }
    }

    /************************************
     * Lakers move in a unique pattern
     * 
     * @return direction of next critter step
     ***********************************/
    public Direction getMoveDirection() {
        // increments the steps for laker
        steps++;
        
        // alternate directions every step
        if (steps % 18 < 3) {
            dir = Direction.WEST;
        }
        if (steps % 18 >= 3) {
            dir = Direction.SOUTH;
        }
        if (steps % 18 >= 8) {
            dir = Direction.EAST;
        }
        
        return dir;
    }
}
