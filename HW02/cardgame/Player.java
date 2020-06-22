package cardgame;

/**
 * Player - Simple card game player with name and hand of cards
 * @author Bartu Atabek
 * @version 25.02.17
 */
public class Player
{
   // properties
   private String name;
   Cards hand;
   
   // constructors
   public Player( String name)
   {
      this.name = name;
      hand = new Cards(false); // initialize the hand with 0 cards
   }
   
   // methods
   
   /**
    * gets the name of the player
    * @return name of the player
    */
   public String getName()
   {
      return name;
   }
   
   /**
    * adds the card to the player's hand
    * @param c is any card
    */
   public void add( Card c)
   {
      hand.addTopCard( c);
   }
   
   /**
    * The method plays the top card in the hand of the player
    * @return the top card in the hand
    */
   public Card playCard()
   {
      return hand.getTopCard();
   }
   
} // end class Player
