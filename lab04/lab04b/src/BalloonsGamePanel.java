import shapes.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Iterator;

/** 
 * BaloonsGamePanel creates a simple game of Balloons
 * where the user pops the balloons in order to get points
 * @author Bartu Atabek 
 * @version 1.0 29.03.17 
 */  
public class BalloonsGamePanel extends JPanel
{ 
   private final int WIDTH = 600;
   private final int HEIGHT = 800;
   
   // properties 
   ShapeContainer balloons;
   javax.swing.Timer timer;
   JLabel score;
   JOptionPane replay;
   int points;
   int elapsedTime;
   MouseListener pin;
   
   // constructors 
   public BalloonsGamePanel()
   {
      balloons = new ShapeContainer();
      
      setPreferredSize( new Dimension( HEIGHT, WIDTH));
      setBackground(Color.WHITE);  
      setVisible( true);
      
      // create timer for grow method which repeats every 250 ms
      timer = new Timer( 50, new TimerListener()); // changed to 100 to increase difficulty
      timer.start();
      
      // create 25 balloons at random locations on the panel
      for ( int i = 1; i <= 25; i++) 
      {
         int xCoordinate = (int) (Math.random() * (WIDTH));
         int yCoordinate = (int) (Math.random() * (HEIGHT));
         
         balloons.add( new Balloons( xCoordinate, yCoordinate));
      }
      // click listener for popping the balloons
      pin = new ClickListener();
      addMouseListener(pin);
      
      points = 0;
      score = new JLabel( "Points: " + points);
      add( score);
      
      replay = new JOptionPane();
      elapsedTime = 0;
   }
   
   // methods 
   
   /**
    * overrides the paintComponent method of the
    * BalloonsGamePanel so that it calls the draw
    * method of each shape in the container
    */ 
   public void paintComponent( Graphics g) 
   {
      super.paintComponent( g);
      Iterator iter;
      
      iter = balloons.iterator();
      
      while ( iter.hasNext())
      {
         ((Balloons) iter.next()).draw(g);
      }
   }
   
   private class TimerListener implements ActionListener
   {
      private TimerListener() {}
      
      public void actionPerformed( ActionEvent e )
      {
         Iterator iter = balloons.iterator();
         while (iter.hasNext())
         {
            ((Balloons)iter.next()).grow();
         }
         
         balloons.removeSelected();
         
         if (balloons.size() < 15) 
         {
            balloons.add( new Balloons( (int) (Math.random() * WIDTH), (int) (Math.random() * HEIGHT)) );
         }
         
         repaint();
         elapsedTime++;
         
         if (elapsedTime >= 250)
         {
            timer.stop();
            removeMouseListener(pin);
            
            // endgame menu
            int option = replay.showConfirmDialog( null, "Play Again?",null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            // restarting the game
            if ( option == JOptionPane.YES_OPTION )     
            {
               // resetting properties
               elapsedTime = 0;
               points = 0;
               score.setText( "Points: " + points );
               
               // adding balloons
               balloons = new ShapeContainer();
               for ( int i = 1; i <= 25; i++) 
               {
                  int xCoordinate = (int) (Math.random() * (WIDTH));
                  int yCoordinate = (int) (Math.random() * (HEIGHT));
                  
                  balloons.add( new Balloons( xCoordinate, yCoordinate));
               }
               addMouseListener(pin);
               timer.start();
            } 
         }
      }
   }
   
   private class ClickListener extends MouseAdapter
   {
      private ClickListener() {}
      
      @Override
      public void mousePressed( MouseEvent e )                      
      {
         // pops all selected balloons
         int burst = balloons.selectAllAt( e.getX(),  e.getY() );   
         
         // updates score if more than two balloons are burst with a single mouse press
         if( burst > 1 )                                             
         {
            points += burst ;
            score.setText( "Points: " + points );
         }
      } 
   }
}