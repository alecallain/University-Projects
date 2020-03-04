import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

/**
 * This class maintains all the numbers of geyser eruptions
 * 
 * @author Alec Allain
 * @version 10/29/16
 */
public class GeyserDatabase
{
    /** Lists containing all geyser information */
    ArrayList<Eruption> eruption;
    ArrayList<Geyser> geyser;

    /******************************************
     * Instantiates the ArrayLists
     *****************************************/
    public GeyserDatabase() {
        eruption = new ArrayList<Eruption>();
        geyser = new ArrayList<Geyser>();
        readGeyserData("GeyserData.txt");
        //createGeyserList();
    }

    /******************************************
     * Opens the provided file and reads all the data
     *****************************************/
    public void readGeyserData(String filename) {
        ArrayList<Eruption> eruption = new ArrayList<Eruption>();

        // Attempt to read the complete set of data from a text file
        try{ 
            // open the text file and use a Scanner to read the text
            File f = new File(filename);
            Scanner sc = new Scanner(f);
            String text;

            // keep reading as long as there is more data
            while(sc.hasNext()) {
                text = sc.nextLine();

                // FIX ME: remove this print statement after method works
                System.out.println(text);

                Eruption e = new Eruption(text);
                eruption.add(e);
            }
            sc.close();
        }
        catch(IOException e) {
            System.out.println("Failed to read the data file: " + filename);
        }
        createGeyserList();
    }

    /******************************************
     * Adds an eruption to the ArrayList
     *****************************************/
    public void addEruption(Eruption e) {
        eruption.add(e);
    }

    /******************************************
     * @return eruption ArrayList
     *****************************************/
    public ArrayList<Eruption> getEruptionList() {
        return eruption;
    }

    /******************************************
     * @return geyser ArrayList
     *****************************************/
    public ArrayList<Geyser> getGeyserList() {
        return geyser;
    }

    /******************************************
     * @return number of items in eruption ArrayList
     *****************************************/
    public int getNumEruptions() {
        return eruption.size();
    }

    /******************************************
     * @return eruptions for a specified day
     *****************************************/
    public int getNumEruptions (int m, int d, int y) {
        int total = 0;
        for (Eruption e: eruption ) {
            if (e.getGeyserMonth() == m && e.getGeyserDay() == d && e.getGeyserYear() == y) {
                total++;
            }
        }
        return total;
    }

    /******************************************
     * @return latest occuring eruption
     *****************************************/
    public Eruption getLateNightEruption() {
        Eruption latest = eruption.get(0);
        for (Eruption e : eruption) {
            if (e.getGeyserHour() > latest.getGeyserHour()) {
                latest = e;
            }
        }
        return latest;
    }

    /******************************************
     * @return eruptions for a specified geyser
     *****************************************/
    public ArrayList<Eruption> getEruptions(String geysers) {
        ArrayList<Eruption> list = new ArrayList<Eruption>();
        geysers = geysers.toLowerCase();

        for (Eruption e : eruption) {
            if (e.getGeyserName().startsWith(geysers)) {
                list.add(e);
            }
        }

        return list;
    }

    /******************************************
     * @return date with most eruptions
     *****************************************/
    public String findDayWithMostEruptions(int y) {
        int most = 0;
        int theMonth = 0;
        int theDay = 0;
        String result = "";
        // update month, day and year if new maximum is found

        for(int m = 1; m<=12; m++){
            for(int d=1; d<=31; d++){
                int count = getNumEruptions(m,d,y);
                // update month. Day and year if new maximum is found
                if (count > most) {
                    most = count;
                    theMonth = m;
                    theDay = d;
                }
            }
        }

        //System.out.println("Day with the most eruptions in " + y);
        result = most + "eruptions on " + theMonth + "/" + theDay + "/" + y;
        return result;
    }

    /******************************************
     * Creates a list of geysers
     *****************************************/
    public void createGeyserList() {
        ArrayList<String> nameList = new ArrayList<String>();

        // create temporary list of unique geyser names
        for(Eruption e : eruption){
            if(!nameList.contains(e.getGeyserName())){
                nameList.add(e.getGeyserName());
            }
        }

        // create a list of geysers
        ArrayList<Geyser> geyserList = new ArrayList<Geyser>();
        for(String s:nameList){
            Geyser g = new Geyser(s);

            // count number of eruptions for current geyser name
            for(Eruption e:eruption){
                if(e.getGeyserName().equals(g.getName()))
                    g.increment();
            }
            geyserList.add(g);
        }

    }

    /******************************************
     * @return number of items in geyser ArrayList
     *****************************************/
    public int getNumGeysers() {
        return geyser.size();
    }

    /******************************************
     * @return geyser with most eruptions
     *****************************************/
    public Geyser findMostActiveGeyser() {
        Geyser active = geyser.get(0);

        for (Geyser g : geyser) {
            if (g.getNumEruptions() > active.getNumEruptions()) {
                active = g;
            }
        }

        return active;
    }

    /******************************************
     * @return geyser with least eruptions
     *****************************************/
    public Geyser findLeastActiveGeyser() {
        Geyser least = geyser.get(0);
        
        for (Geyser g : geyser) {
            if (g.getNumEruptions() < least.getNumEruptions()) {
                least = g;
            }
        }
        
        return least;
    }

}
