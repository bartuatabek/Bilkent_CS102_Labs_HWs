import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import cs101.sosgame.*;
 
/** 
 * Testing of SOS class and it's methods
 * @author Bartu Atabek 
 * @version 1.0 05.04.17
 */  
public class SOSGUIPanelTest 
{ 
   public static void main( String[] args) 
   { 
      // constants 
 
      // variables 
      SOS game;
      SOSGUIPanel panel;
      JFrame frame;
      
      // program code 
       
      game = new SOS(5);
      
      frame = new JFrame("MYSOSGame: v1.0 ");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      panel = new SOSGUIPanel(game, "Bartu", "David");  
      frame.add(panel);
      
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
      
   }
}