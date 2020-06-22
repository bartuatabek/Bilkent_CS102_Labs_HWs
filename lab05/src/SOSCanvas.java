import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import cs101.sosgame.*;

/*
 * Creates the GUI for the SOS game class with paint
 * methods in order to print the grid layout
 * @author Bartu Atabek 
 * @version 1.0 05.04.17
 */  
public class SOSCanvas extends JPanel
{
   //varibles
   private int size;
   private int row;
   private int column;
   private ArrayList<Rectangle> cells;
   MouseListener event;
   SOS game;  
   
   //constructor
   public SOSCanvas(SOS game, MouseListener e)
   {
      event = e;
      this.game = game;
      cells = new ArrayList<Rectangle>(column * row);
      size = game.getDimension();
      setBackground(Color.GREEN);
      setPreferredSize(new Dimension(500, 500));
   }
   
   /*
    * paint component method that draws the grid
    * for the SOS game
    * @param g is the graphics object
    */ 
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      size = game.getDimension();
      String str;
      int d;
      row = 0;
      column = 0;
      
      str = "";
      d = (int) 500 / size;
      
      // extra changing the font
      Font myFont = new Font ("Vijaya", 1, 24);
      g.setFont (myFont);
      
      for (int i = 0; i < size; i++)
      {
         for (int j = 0; j < size ; j++)
         {
            g.drawRect(row, column, d, d);
            row += d;
            str += game.getCellContents(i, j);
            if (!str.equals("."))
               g.drawString( str, row - (d / 2), column + (d / 2)); 
            str = "";
         }
         column += d;
         row = 0;  
      }         
   }
}