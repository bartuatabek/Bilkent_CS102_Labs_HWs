import javax.swing.*;
 
/** 
 * Tests the Pot Luck Game 
 * @author Bartu Atabek 
 * @version 1.0 29.03.17
 */  
public class PotLuckTest
{ 
   public static void main( String[] args) 
   { 
 
      // variables 
      JFrame myFrame;
      PotLuck myGame;
      
      // program code 
      myFrame = new JFrame("Pot Luck Game");
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      myGame = new PotLuck();     
      myFrame.setContentPane(myGame);
      
      myFrame.pack();
      myFrame.setLocationRelativeTo(null);
      myFrame.setVisible(true);        
      
   } 
   
}