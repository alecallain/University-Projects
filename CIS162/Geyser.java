
/**
 * This class stores information about a single geyser
 * 
 * @author Alec Allain 
 * @version 10/29/16
 */
public class Geyser
{
    String geyserName;
    int numEruptions;
    
    /****************************
     * Instanciates the geyser name
     ***************************/
    public Geyser(String name) {
        geyserName = name;
    }
    
    /****************************
     * Increases the number of eruptions
     ***************************/
    public void increment() {
        numEruptions += 1;
    }
    
    /****************************
     * @return name of geysers
     ***************************/
    public String getName() {
        return geyserName;
    }
    
    /****************************
     * @return number of eruptions
     ***************************/
    public int getNumEruptions() {
        return numEruptions;
    }
    
    /****************************
     * Tests each of the methods
     ***************************/
    public static void main (String [] args) {
        
    }
}
