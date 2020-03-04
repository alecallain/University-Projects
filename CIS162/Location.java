
/**************************************************
 * This class maintains the row/column location
 * of a critter
 * 
 * @author Alec Allain 
 * @version 11/14/16
 *************************************************/
public class Location
{
    
    /** variables for row and column */
    private int row;
    private int col;

    /********************************
     * initialize the instance variables
     * 
     * @param r is set to row
     * @param c is set to col
     *******************************/
    public Location (int r, int c) {
        row = r;
        col = c;
    }

    /********************************
     * sets row number
     * 
     * @param r sets the row
     *******************************/
    public void setRow(int r) {
        row = r;
    }

    /********************************
     * sers column number
     * 
     * @param c sets the column
     *******************************/
    public void setCol(int c) {
        col = c;
    }

    /********************************
     * @return row number
     *******************************/
    public int getRow() {
        return row;
    }

    /********************************
     * @return column number
     *******************************/
    public int getCol() {
        return col;
    }
}
