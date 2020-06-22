import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/** 
 * Pot Luck is a GUI application that presents 
 * a game based on a 5 by 5 matrix of buttons.
 * @author Bartu Atabek 
 * @version 1.0 29.03.17
 */  
public class PotLuck extends JPanel
{
   // properties
   final int RAW = 6;
   final int COLUMN = 5;
   final int B_NUM = 25;
   
   private int count ;
   private int guess;
   private JLabel num ;
   private JPanel p1;
   private JPanel p2;
   private ArrayList <JButton> buttons;
   
   // constructor
   public PotLuck()
   {
      // generating random value
      guess = 1 + (int)(Math.random() * 25); 
      count = 0;
      setLayout( new BoxLayout( this,BoxLayout.Y_AXIS));
      
      // panels
      p1 = new JPanel(); // text panel
      p2 = new JPanel(); // button panel
      
      // creating text panel
      num = new JLabel( "Guesses: " + count);
      p1.add(num); 
      
      // creating button panel
      p2.setLayout( new GridLayout( RAW, COLUMN));
      
      // buttons
      buttons = new ArrayList <JButton>();
      
      for ( int i = 0; i <B_NUM; i++)
      {
        buttons.add( new JButton( "?")); 
      }
      
      // button actions
      for ( int i = 0; i < buttons.size(); i++)
      {
         ((JButton) buttons.get(i)).addActionListener( new Guess(i));
         p2.add( (JButton) buttons.get(i)); // adding buttons to button panel
      }
      
      // seting dimentions
      p1.setPreferredSize( new Dimension(300,40));
      p2.setPreferredSize( new Dimension(300,300));
      
      // adding frame
      add(p1);
      add(p2);
   }
   
   // action listener
   public class Guess implements ActionListener
   {
      // properties
      private int enter;
      // constructor
      public Guess( int enter)
      {
         this.enter = enter;
      }
      
      /**
       * updates the counter when the button pressed 
       * if guess if true sets the buttons invisible
       * @param event is an ActionEvent
       */ 
      public void actionPerformed( ActionEvent event)
      {
         count++;
         if( !check())
         {
            num.setText( "Guesses: "+ count);
            ((JButton) event.getSource()).setEnabled(false);
         }
         else
         {
            p2.setVisible(false); 
         }
      }
      
      /**
       * checks whether the pressed button
       * is the right one
       * @return boolean true or false 
       */ 
      public boolean check()
      {
         if ( enter == guess)
         {
            num.setText( "You got it in " + count + " attempts!"); 
            return true;
         }
         else 
            return false;
      }
   }
}
