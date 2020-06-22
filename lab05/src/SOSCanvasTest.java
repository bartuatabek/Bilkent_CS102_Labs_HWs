import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import cs101.sosgame.*;

/** 
 * Testing of SOSCanvas class  
 * @author Bartu Atabek 
 * @version 1.0 05.04.17
 */  
public class SOSCanvasTest 
{ 
   public static void main( String[] args) 
   { 
      // constants 
      
      // variables 
      SOS game;
      SOSCanvas Mygame;
      JFrame frame;
      
      // program code 
      
      game = new SOS(3);
      
      frame = new JFrame("MYSOSGame: v1.0 ");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //Mygame = new SOSCanvas(game);  
      //frame.add(Mygame);
      
      // using play method in order to see the letters on the frame
      game.play('s', 1, 1);
      game.play('o', 2, 2);
      game.play('s', 3, 3);
      
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);  
      
   }
}