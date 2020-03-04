
/**
 * Write a description of class TestFirstApp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestFirstApp
{
    static void doIt(int x, int y, int m) {
        if (x == 5) {
            m=y;
        }
        else {
            m=x;
        }
    }
    
    public static void main(String [] args) {
        int i=6;
        int j=4;
        int k=9;
        
        TestFirstApp.doIt(i,j,k);
        System.out.println(k);
    }
}
