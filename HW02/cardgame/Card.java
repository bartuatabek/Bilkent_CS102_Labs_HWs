package cardgame;

/**
 * Card - a single playing card
 * @author Bartu Atabek
 * @version 25.02.17
 */
public class Card
{ 
   final String[] SUITS = { "Hearts", "Diamonds", "Spades", "Clubs"};
   final String[] FACES = { "A", "2", "3", "4", "5",
      "6", "7", "8", "9", "10",
      "J", "Q", "K"};
   
   final int NOOFCARDSINSUIT = 13;
   
   // properties
   int  cardNo;
   
   // constructors
   public Card( int faceValue, int suit )
   {
      cardNo = faceValue + suit * NOOFCARDSINSUIT;
   }
   
   public Card( int cardNumber)
   {
      cardNo = cardNumber;
   }
   
   // methods
   
   /**
    * gets face value of the card
    * @return face value
    */
   public int getFaceValue()
   {
      return cardNo % NOOFCARDSINSUIT;
   }
   
   /**
    * gets suit of the card
    * @return suit
    */
   public int getSuit()
   {
      return cardNo / NOOFCARDSINSUIT;
   }
   
   /**
    * To string representation of the cards
    * @return the card
    */
   public String toString()
   {
      return FACES[ getFaceValue() ] + " of " + SUITS[ getSuit() ];
   }
   
   /**
    * equals method checks the equality of two cards
    * @param c is any card
    * @return true if cards equal, false if cards different
    */
   public boolean equals( Card c)
   {
      if ( ( this.getFaceValue() != c.getFaceValue() ) )
         return false;
      else
         return true;
   }
   
   /**
    * compareTo method compares two cards according to their
    * difference in face values
    * @param c is any card
    * @return -1 if c is smaller, 1 if c is bigger, 0 if c is equal to the card
    */
   public int compareTo( Card c)
   {
      if ( this.equals( c))
         return 0;
      else if ( this.getFaceValue() > c.getFaceValue())
         return 1;
      else 
         return -1;
   }
}