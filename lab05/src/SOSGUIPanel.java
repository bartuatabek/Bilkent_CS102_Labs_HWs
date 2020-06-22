import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import cs101.sosgame.*;

/*
 * Adds the extrea GUI components for the SOS game 
 * and adds interractions so that the game is playable
 * by using mouse clicks
 * @author Bartu Atabek 
 * @version 1.0 05.04.17
 */  
public class SOSGUIPanel extends JPanel
{
   // properties
   private JLabel name1;
   private JLabel name2;
   private JRadioButton buttonS;
   private JRadioButton buttonO;
   private JOptionPane replay;
   private ButtonGroup group;
   private int score1;
   private int score2;
   private SOSMouseListener press;
   private char selected;
   private String player1;
   private String player2;
   private String winner;
   SOS game;
   
   // constructors
   public SOSGUIPanel(SOS game, String player1, String player2)
   {
      // starting the game and adding players
      this.game = game;
      this.player1 = player1;
      this.player2 = player2;  
      
      JPanel info = new JPanel();
      SOSCanvas canvas = new SOSCanvas(game, press);
      setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
      
      // changing the font
      setFont(new Font("Vijaya", 1, 24)); 
      
      // setting player scores to 0
      score1 = game.getPlayerScore1();
      score2 = game.getPlayerScore2();
      
      // setting players on the panel
      name1 = new JLabel(player1 + ": " + score1);
      name2 = new JLabel(player2 + ": " + score2);
      name1.setOpaque(true);
      name2.setOpaque(true);
      name1.setBackground(Color.GREEN);
      name2.setBackground(Color.WHITE);
      
      // setting radio buttons
      buttonS = new JRadioButton("S");
      buttonO = new JRadioButton("O");
      
      group = new ButtonGroup();
      group.add(buttonS);
      group.add(buttonO);
      
      // setting actions to the buttons
      ButtonListener listener = new ButtonListener();
      buttonS.addActionListener(listener);
      buttonO.addActionListener(listener);
      
      // adding varibles to the panel
      info.add(name1);
      info.add(buttonS);
      info.add(buttonO);
      info.add(name2);  
      add(canvas);
      add(info);
      
      press = new SOSMouseListener();
      addMouseListener(press);
   }
   
   // methods 

   // classes
   
   /* SOS Mouse Listener inner class enables the player 
    * to play the game, and take turns by using the mouse
    * and also updates the score
    */ 
   private class SOSMouseListener extends MouseAdapter 
   {
      /*
       * mousePressed method enables playing on a 
       * specified tile for the speciifed player with the
       * specified letter and displays message if game is over
       * @param e is the mouseEvent
       */ 
      @Override
      public void mousePressed(MouseEvent e) 
      {
         int div;
         int playY;
         int playX ;
         
         // getting the point
         div = 500 / game.getDimension();
         playY = e.getX()/ div + 1;
         playX = e.getY()/ div + 1;
         
         // changing the color of the players if its their turn
         if (game.getTurn() == 1) 
         {
            name1.setBackground(Color.GREEN); 
            name2.setBackground(Color.WHITE);
         }
         
         if (game.getTurn() == 2)
         {
            name1.setBackground(Color.WHITE);
            name2.setBackground(Color.GREEN); 
         }
         
         // playing the turn and updating the score
         game.play( selected, playX, playY );
         
         score1 = game.getPlayerScore1();
         score2 = game.getPlayerScore2();
         name1.setText(player1 + ": " + score1);
         name2.setText(player2 + ": " + score2);
         repaint();
         
         // displaying message dialog if game is over
         if (game.isGameOver())
         {
            if (score1 > score2)
               winner = player1 + " is the winner!" ;
            else if (score2 > score1)
               winner = player2 + " is the winner!" ;
            else
               winner = "It's a draw";
            JOptionPane.showMessageDialog(null, winner, "Game Over!",  JOptionPane.INFORMATION_MESSAGE);
            
            // endgame menu
            int option = replay.showConfirmDialog( null, "Play Again?",null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            // restarting the game
            if ( option == JOptionPane.YES_OPTION )     
            {
                // resetting game
                game.resetGame();
                repaint();
            } 
         }
      }
   }  
   
   /* Button Listener inner class enables the player 
    * to choose between the letters 's' or 'o'
    */ 
   private class ButtonListener implements ActionListener
   {
      /*
       * gets the selected radio button from the display
       * @param event is an ActionEvent
       */ 
      public void actionPerformed(ActionEvent event)
      {
         Object source;
         source = event.getSource();
         
         if (source == buttonS)
            selected = 's';
         else
            selected = 'o';
      }
   }
}