import java.util.Scanner;

/**
 * Main method creates an instance of the Hangman
 * class and access it's methods in order to generate
 * a hangman game.
 * @author Bartu Atabek
 * @version 1.0 18.02.2017
 */ 
public class HangmanGame
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      
      // variables
      Hangman hangman;
      boolean isGameOver;
      char letter;
      char playAgain;
      
      // Program code
      System.out.println( "__Welcome to the Hangman Game!__");
      
      do 
      {
         hangman = new Hangman(); // initialize the Hangman object
         isGameOver = false; // set game over to false
         
         // simple text based menu for the hangman game
         do 
         {
            System.out.println( "\n" + hangman.getAllLetters() );
            System.out.println( "\nHere is the word: " + hangman.getKnownSoFar() );
            System.out.println( "\nLives Remaining: " + ( hangman.getMaxAllowedIncorrectTries() - hangman.getNumOfIncorrectTries() ) );
            System.out.println( "\nUsed Letters: " + hangman.getUsedLetters() );
            System.out.print( "\nEnter a letter: ");
            
            letter = scan.nextLine().charAt(0);
            
            if (hangman.tryThis( letter ) == -1)
            {
               System.out.println( "\nThe letter you entered is invalid" );
            }
            else if (hangman.tryThis( letter ) == -2)
            {
               System.out.println( "\nThe letter was already used. Try another one!" );
            }
            else if (hangman.tryThis( letter ) == -3) 
            {
               System.out.println( "Game over!" );
               
               if ( ( hangman.getMaxAllowedIncorrectTries() - hangman.getNumOfIncorrectTries() ) > 0 )
                  System.out.println( "You Win!" );
               if ( hangman.hasLost() )
               {
                  System.out.println( "\nThe word was: " + hangman.getSecretWord() + "\n" );
                  System.out.println( "You Lost!" );
               }
               
               isGameOver = true;
            }
            
         } while (isGameOver == false);
         
         // ask the player to replay
         System.out.print( "\nDo you want to play again? (Y/N): " );
         playAgain = scan.nextLine().charAt(0);
         
      } while (playAgain == 'Y' || playAgain == 'y');
      
      System.out.println( "Goodbye..." );
   }
}
