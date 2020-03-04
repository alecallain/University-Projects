import java.awt.*;

/************************************************
 * The Bird class extends GVcritter. It gives us
 * access to all public/protected members 
 * in GVcritter
 * 
 * @author Alec Allain 
 * @version 11/14/16
 ***********************************************/
public class Bird extends GVcritter{
    
    // start direction for this bird
    private Direction dir;

    /************************************
     * Starting values for a bird
     * @param loc gives location for bird
     ***********************************/
    public Bird(Location loc) {
        super(loc);
        setColor(Color.BLUE);
        setSpecies(Species.BIRD);

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

    /************************************
     * Birds always ROAR at their opponents
     * 
     * @param opponent who the bird's fighting
     * @return specified attack
     ***********************************/
    public Attack getAttack(GVcritter opponent) {
        return Attack.ROAR;
    }

    /************************************
     * Birds move in a counter-clockwise pattern
     * 
     * @return direction of next critter step
     ***********************************/
    public Direction getMoveDirection() {
        // increments the steps for bird
        steps++;

        // alternate directions every step
        if (steps % 14 < 3) {
            dir = Direction.NORTH;
        }
        if (steps % 14 >= 4) {
            dir = Direction.EAST;
        }
        if (steps % 14 >= 7 ) {
            dir = Direction.SOUTH;
        }
        if (steps % 14 >= 11) {
            dir = Direction.WEST;
        }
        
        return dir;
    }
}
