import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

/**
 * This project is for my business card.
 * 
 * @author Alec Allain 
 * @version 1.0.12
 */
public class Drawing extends JPanel {
    
    public static void main(String[] a) {
        JFrame f = new JFrame();
        f.setContentPane(new Drawing());
        f.setSize(600, 400);
        f.setVisible(true);
        
    }
    
    public void paintComponent(Graphics g) {
        // integers defined
        int wordX = 100;
        int wordY = 200; 
        int l = 250; 
        int w = 250; 
        int shapeX = 250; 
        int shapeY = 150; 
        int shapeL = 100; 
        int shapeW = 50; 
        
        // This statement is required
        super.paintComponent(g);
        
        // Draws card layout (numbers stay permanent)
        setBackground(Color.WHITE);
        g.setColor(Color.black);
        g.drawRect(0, 0, 500, 300);
        
        // Inserts text on business card
        Font myFont = new Font("serif", Font.ITALIC, 20);
        g.setFont(myFont);
        g.setColor(Color.black); 
        g.drawString("Alec Allain", wordX-40, wordY+50);
        g.drawString("Main Programer", wordX-60, wordY+70);
        
        Font myFont2 = new Font("times", Font.PLAIN, 24);
        g.setFont(myFont2);
        g.drawString("White Box Studios", wordX+135, wordY-15);
        g.drawString("Call: 616-867-5309", wordX+135, wordY+45);
        g.drawString("Fax: 616-867-5310", wordX+137, wordY+70);
        
        // Draws box of logo
        g.setColor(Color.black);
        g.drawRect(shapeX+30, shapeY-50, shapeL, shapeW);
        
        // Draws ovals of logo 
        g.setColor(Color.BLUE);
        g.drawOval(shapeX+40, shapeY-140, shapeL-30, shapeW);
        g.setColor(Color.GREEN); 
        g.fillOval(shapeX+70, shapeY-110, shapeL-30, shapeW);
        
        // Draws lines 
        g.setColor(Color.RED); 
        g.drawLine(shapeX+60, shapeY-93, shapeX+40, shapeY-50); 
        g.drawLine(shapeX+80, shapeY-67, shapeX+60, shapeY-50); 
        g.drawLine(shapeX+100, shapeY-61, shapeX+80, shapeY-50);
        
        // This whole statement imports the user image
        BufferedImage photo = null;
        try {
            File PhotoOfMe = new File("PhotoofMe.jpg");
            photo = ImageIO.read(PhotoOfMe);
        } catch (IOException e) {
            g.drawString("Problem reading the file", 100, 100);
        }
        g.drawImage(photo, 30, 75, 150, 150, null);
        
    }
}
