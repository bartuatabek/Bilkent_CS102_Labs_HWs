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
public class SOSTest 
{ 
   public static void main( String[] args) 
   { 
      // constants 
 
      // variables 
      SOS game;
      SOSCanvas Mygame;
      JFrame frame;
      
      // program code 
      
      // testing the SOS class 
      game = new SOS(3);
      
      // testing SOS class methods
      
      game.printBoard();
      System.out.println();
      System.out.println( "Player 1: " + game.getPlayerScore1());
      System.out.println( "Player 2: " + game.getPlayerScore2());
      System.out.println( "Turn of Player: " + game.getTurn());
      System.out.println( "Game Over: " + game.isGameOver());
      System.out.println( "\n" + game.play('s', 2, 2) + "\n");
      game.printBoard();
      
      System.out.println( "Cell Contents: " + game.getCellContents(1, 1));
      System.out.println("Dimension: " + game.getDimension());
      
      
    
      
      
      
      
   } 
 
}