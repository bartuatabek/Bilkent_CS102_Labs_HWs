package cardgame;

/**
 * Cards - Maintains a collection of zero or more playing cards.
 *         Provides facilities to create a full pack of 52 cards
 *         and to shuffle the cards.
 * @author Bartu Atabek
 * @version 25.02.17
 */
public class Cards
{
   final int NOOFCARDSINFULLPACK = 52;
   
   // properties
   Card[] cards;
   int    valid;  // number of cards currently in collection
   
   // constructors
   public Cards( boolean fullPack)
   {
      cards = new Card[ NOOFCARDSINFULLPACK ];
      valid = 0;
      
      if ( fullPack)
         createFullPackOfCards();
   }
   
   // methods
   
   /**
    * gets the top card from the hand
    * @return tmp the top card
    */
   public Card getTopCard()
   {
      Card tmp;
      
      if ( valid <= 0)
         return null;
      else
      {
         valid--;
         tmp = cards[valid];
         cards[valid] = null;
         return tmp;
      }
   }
   
   /**
    * adds the top card to the hand
    * @param c is any card
    * @return true or false accordingly
    * whether the operation is succesful or not
    */
   public boolean addTopCard( Card c)
   {
      if ( valid < cards.length)
      {
         cards[valid] = c; 
         valid++;
         return true;
      }
      return false;
   }
   
   /**
    * creates full pack of cards
    */
   private void createFullPackOfCards()
   {
      for ( int i = 0; i < 52; i++)
      {
         cards[i] = new Card(i);
         valid = NOOFCARDSINFULLPACK;
      }
   }
   
   /**
    * shuffles the full pack of cards randomly
    */
   public void shuffle()
   {
      for (int i = 0; i < NOOFCARDSINFULLPACK; i++) 
      {
         int index;
         Card temp;
         
         index = (int) ( Math.random()  * NOOFCARDSINFULLPACK );
         temp = cards[i];
         cards[i] = cards[index];
         cards[index] = temp;
      }
   }
   
} // end class Cards
