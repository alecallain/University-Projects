
/**
 * This class tests the GeyserDatabase
 * 
 * @author Alec Allain 
 * @version 11/1/16
 */
public class GeyserTest
{
    public static void main(String args[]){
        GeyserDatabase db = new GeyserDatabase();

        // read small data file created just for testing
        db.readGeyserData("mySampleData.txt");

        // check number of eruptions and geysers
        if(db.getNumEruptions() != 4){
            System.out.println("Error: Number of eruptions should be 4");
        }
        if(db.getNumGeysers() != 2){
            System.out.println("Error: Number of geysers should be 2");
        }

        // check late night eruption
        Eruption e = db.getLateNightEruption();
        if(e.getGeyserHour() != 20 && e.getGeyserMinutes() != 35){
            System.out.println("Error: Latest eruption should be at 20:35");
        }
        
        
        
        System.out.println("Scanning complete.");
    }
}
