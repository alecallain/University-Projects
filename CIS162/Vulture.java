import java.awt.*;

/*********************************************
 * The Vulture class extends GVcritter. It gives
 * us access to all public/protected members
 * in GVcritter
 * 
 * @author Alec Allain 
 * @version 11/16/16
 ********************************************/
public class Vulture extends GVcritter {

    // start direction for this vulture
    private Direction dir;

    /**********************************
     * Create starting values for this Vulture.
     * @param loc given location for this critter
     *********************************/
    public Vulture (Location loc) {
        super(loc);
        setColor(Color.BLACK);
        setSpecies(Species.VULTURE);

        // picks a random start direction
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
     * Vultures always ROAR at their opponents
     * unless they're Hippos
     * 
     * @param opponent who the bird's fighting
     * @return specified attack
     *********************************/
    public Attack getAttack (GVcritter opponent) {
        if (opponent.getSpecies() == Species.HIPPO) {
            return Attack.SCRATCH;
        }
        else {
            return Attack.ROAR;
        }
    }

    /**********************************
     * Vultures move in a counter-clockwise pattern
     * 
     * @return direction of next critter step
     *********************************/
    public Direction getMoveDirection() {
        // increase number of steps for bird
        steps++;

        // changing directions every other step
        if (steps % 14 < 4) {
            dir = Direction.NORTH;
        }
        if (steps % 14 >= 3) {
            dir = Direction.WEST;
        }
        if (steps % 14 >= 7) {
            dir = Direction.SOUTH;
        }
        if (steps % 14 >= 10) { 
            dir = Direction.EAST;
        }

        return dir;
    }
}
