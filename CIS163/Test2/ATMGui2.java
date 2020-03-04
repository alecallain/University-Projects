/*
 * Project 1 ATM GUI
 * @author Jacob Walton
 * @version January 2017
 * 
 * A GUI class that simulates my high-end ATM machine program with hundreds,
 *  fifties, and twenties.
 * 
 * 
 */
 

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class ATMGui
{
    public static void main (String[] args)
    {
        JFrame frame = new JFrame ("ATM's");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        
        JTabbedPane tp = new JTabbedPane();
        tp.addTab("ATM 1", new MyATMPanel());
        tp.addTab("ATM 2", new MyATMPanel());
        tp.addTab("ATM 3", new MyATMPanel());
                
        frame.getContentPane().add(tp);
        frame.setSize(500, 200);
        frame.setVisible(true);
    }
}
