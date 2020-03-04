import java.util.Scanner;

/**
 * This class stores information about a single geyser eruption
 * 
 * @author Alec Allain 
 * @version 10/29/16
 */
public class Eruption
{
    /** Geyser date information */
    private int geyserMonth;
    private int geyserDay;
    private int geyserYear;
    
    /** Geyser time information */
    private int geyserHour;
    private int geyserMinutes;
    
    /** Geyser name information */
    private String geyserName;

    /******************************
     * Initializes all the variables to a single string
     *****************************/
    public Eruption (String info) {
        geyserMonth = 0;
        geyserDay = 0;
        geyserYear = 0;
        geyserHour = 0;
        geyserMinutes = 0;
        geyserName = "";
        
        info = "1/15/2010,Old Faithful,16:43";
        Scanner scnr = new Scanner(info);
        scnr.useDelimiter("/|,|:");
        geyserMonth = scnr.nextInt();
        geyserDay = scnr.nextInt();
        geyserYear = scnr.nextInt();
        geyserName = scnr.next();
        geyserHour = scnr.nextInt();
        geyserMinutes = scnr.nextInt();
    }

    /******************************
     * @return month of geyser eruption
     *****************************/
    public int getGeyserMonth() {
        return geyserMonth;
    }
    
    /******************************
     * @return day of geyser eruption
     *****************************/
    public int getGeyserDay() {
        return geyserDay;
    }
    
    /******************************
     * @return year of geyser eruption
     *****************************/
    public int getGeyserYear() {
        return geyserYear;
    }
    
    /******************************
     * @return hour of geyser eruption
     *****************************/
    public int getGeyserHour() {
        return geyserHour;
    }
    
    /******************************
     * @return minute of geyser eruption
     *****************************/
    public int getGeyserMinutes() {
        return geyserMinutes;
    }
    
    /******************************
     * @return geyser's name
     *****************************/
    public String getGeyserName() {
        return geyserName;
    }
    
    /******************************
     * Sets the geyser's month
     *****************************/
    public int setGeyserMonth(int m) {
        geyserMonth = m;
        return geyserMonth;
    }
    
    /******************************
     * Sets the geyser's day
     *****************************/
    public int setGeyserDay(int d) {
        geyserDay = d;
        return geyserDay;
    }
    
    /******************************
     * Sets the geyser's year
     *****************************/
    public int setGeyserYear(int y) {
        geyserYear = y;
        return geyserYear;
    }
    
    /******************************
     * Sets the geyser's hour
     *****************************/
    public int setGeyserHour(int h) {
        geyserHour = h;
        return geyserHour;
    }
    
    /******************************
     * Sets the geyser's minutes
     *****************************/
    public int setGeyserMinutes(int mi) {
        geyserMinutes = mi;
        return geyserMinutes;
    }
    
    /******************************
     * Sets the geyser's name
     *****************************/
    public String setGeyserName(String n) {
        geyserName = n;
        return geyserName;
    }
    
    /******************************
     * @return a formatted string
     *****************************/
    public String toString() {
        String result = geyserName + " on " + geyserMonth + "/" + geyserDay + "/" + geyserYear + " at " + geyserHour + ":" + geyserMinutes;
        return result;
    }
    
    /******************************
     * Main tests the other methods in the class
     *****************************/
    public static void main(String [] args) {
        
    }
    
}

