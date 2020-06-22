import javax.swing.*;
import java.awt.*;
import shapes.*;
 
/** 
 * Balloons game application 
 * @author Bartu Atabek 
 * @version 1.0 29.03.17 
 */  
public class Lab04b 
{ 
   public static void main( String[] args) 
   { 
      // variables 
      JFrame frame;
      BalloonsGamePanel game;
 
      // program code 
      frame = new JFrame("Lab04b-Balloons");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      game = new BalloonsGamePanel();  
      frame.add(game);

      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);  
   } 
}