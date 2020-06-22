package cardgame;

/**
 * ScoreCard - Maintains one integer score per player, for any number of players
 *             Caution: invalid playernumbers result in run-time exception!
 * @author Bartu Atabek
 * @version 25.02.17
 */
public class ScoreCard
{
   // properties
   int[] scores;
   
   // constructors
   public ScoreCard( int noOfPlayers)
   {
      scores = new int[noOfPlayers];
      
      // init all scores to zero
      for ( int i = 0; i < scores.length; i++)
         scores[i] = 0;
   }
   
   // methods
   
   /** gets the score of the selected player
     * @param playerNo is the player no of the player
     * @return the score of the player
     */
   public int getScore( int playerNo)
   {
      return scores[ playerNo];
   }
   
    /** updates the score of the selected player
     * @param playerNo is the player no of the player
     * @param amount is the amount of points wanted to be added
     */
   public void update( int playerNo, int amount)
   {
      scores[playerNo] += amount;
   }
   
    /** string representation of the score card
     * @return s the String representation of the score card
     */
   public String toString()
   {
      String s;
      s = "\n"
         + "_____________\n"
         + "\nPlayer\tScore\n"
         + "_____________\n";
      
      for ( int playerNo = 0; playerNo < scores.length; playerNo++)
      {
         s = s + (playerNo + 1) + "\t" + scores[playerNo] + "\n";
      }
      
      s += "_____________\n";
      return s;
   }
   
   /** get winners from the scores
     * @return winners the winners of the game as their number
     */
   public int[] getWinners()
   {
      int[] winners;
      
      int highScore;
      highScore = -1; // a negative number in order to avoid 0 as a winner
      
      int noOFWinners;
      int noOfWinners = 1;
      
      int index;
      index = 0;
      
      // searching for the high score among scores
      for ( int i = 0; i < scores.length; i++)
      {
         if ( scores[i] == highScore)
         {
            noOfWinners++;
         }
         if ( scores[i] > highScore)
         {
            highScore = scores[i];
         }
      }
      
      // initialize the winners array with the size of noOfWinners
      winners = new int[noOfWinners];
      
      // finding the winners
      for ( int i = 0; i < scores.length; i++)
      {
         if ( scores[i] == highScore)
         {
            winners[index] = i;
            index++;
         }
      }
      return winners;
   }
   
} // end class ScoreCard
