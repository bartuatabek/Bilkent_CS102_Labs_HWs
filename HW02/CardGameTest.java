import java.util.Scanner;
import cardgame.*;

/**
 * CardGameTest tests various classes for the cardgame
 * @author Bartu Atabek
 * @version 25.02.17
 */
public class CardGameTest
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      
      System.out.println( "Start of CardGameTest\n");
      
      // CONSTANTS
      
      // VARIABLES
      Card       c;
      Cards      cards;
      ScoreCard  scores;
      Player     p1;
      Player     p2;
      Player     p3;
      Player     p4;
      CardGame   game;
      
      // PROGRAM CODE
      
      // test Card class
      c = new Card( 1);
      System.out.println( c);
      System.out.println();
      
      // test Cards class
      cards = new Cards( true);
      cards.addTopCard( c);
      
      // test ScoreCard class
      scores = new ScoreCard( 4);
      scores.update( 3, 1);
      scores.update( 1, 2);
      System.out.println( "\n" + scores );
      
      // test Player class
      p1 = new Player( "Bartu"); // adding 4 new players
      p2 = new Player( "Deniz");
      p3 = new Player( "Cevahir");
      p4 = new Player( "Musab");
      System.out.println(p1.getName());
      p1.add( c);
      p1.playCard(); //playing card
      
      // test CardGame class
      game = new CardGame(p1,p2,p3,p4);
      
      System.out.println(game.showScoreCard());
      
      System.out.print( "Winners: ");
      for (int i = 0; i < game.getWinners().length; i++)
      {
         System.out.print( game.getWinners()[i].getName() + " ");
      }
      
      System.out.println("\n");
      
      System.out.println( "Turn of player No: " + game.getTurnOfPlayerNo());
      System.out.println( "Round no: " + game.getRoundNo());
      System.out.println();
      
      for (int i = 0; i < 4; i++)
      {
         System.out.println( "Player: " + game.getName(i) + " " + "Score: " + game.getScore(i));
      }
      System.out.println();
      System.out.println( "Is game over: " + game.isGameOver());
      
      System.out.println( "Is turn of Player 1: " + game.isTurnOf( p1));
      
      c = p1.playCard();
      
      System.out.println( "Play Turn: " + game.playTurn(p1,c));
      
      // Once you have all the bits working, complete the MyCardGame program
      // that provides a menu allowing any of the players to play their card,
      // an option to see the score card, and one to quit the game at any time.
      // When the game is over it should print out the winners.
      
      System.out.println( "\nEnd of CardGameTest\n" );
   }
   
} // end of class CardGameTest
