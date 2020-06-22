package cardgame;

import java.util.ArrayList;
// Creates a simple card game with scores, players, and cards
// @author Bartu Atabek
// @version 25.02.17
public class CardGame
{
    // properties
    private Cards             fullPack;
    private ArrayList<Player> players;
    private ScoreCard         scoreCard;
    private Cards[]           cardsOnTable;
    private int               roundNo;
    private int               turnOfPlayer;
    
    // constructor
    public CardGame( Player p1, Player p2, Player p3, Player p4)
    {
        // add players to the arraylist
        players = new ArrayList<Player>();
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        
        // create full pack of cards
        fullPack = new Cards(true);
        // shuffle the pack of cards
        fullPack.shuffle();
        
        // create new score card
        scoreCard = new ScoreCard(4);
        cardsOnTable = new Cards[4];
        
        for (int i = 0; i < this.cardsOnTable.length; i++)
        {
           this.cardsOnTable[i] = new Cards(false);
        }
        // initialize round & turn
        roundNo = 1;
        turnOfPlayer = 0;
        
        // distribute cards to players
        for ( int i = 0; i < 13; i++)
        {
           p1.add(fullPack.getTopCard());
           p2.add(fullPack.getTopCard());
           p3.add(fullPack.getTopCard());
           p4.add(fullPack.getTopCard());
        }
    }
    
    // methods
    
    /**
    * plays the top card in the players hand
    * @param p is the player 
    * @param c is the top card in the hand
    * @return true and false if playTurn succesful
    */
    public boolean playTurn( Player p, Card c)
    {  
       Card max;
       Card[] cards;
       cards = new Card[4];
       
       if ( this.isTurnOf(p)) // adding the top card to the table
       {
          this.cardsOnTable[this.turnOfPlayer].addTopCard( c);
          
          turnOfPlayer++;
          
          if ( turnOfPlayer == 3) // updating scores & resetting turns
          {
             for ( int i = 0; i < 4; i++)
             {
                cards[i] = cardsOnTable[i].getTopCard();
             }
             
             max = cards[0];
             
             for ( int i = 0; i < 3; i++)
             {
                if ( cards[i].compareTo(max) == 1) // finding the highest card
                {
                   max = cards[i]; 
                }
             }
             
             for ( int i = 0; i < 3; i++)
             {
                if ( cards[i].compareTo(max) == 0)
                {
                   scoreCard.update(i,1);
                }
             }
             turnOfPlayer = 0;
             roundNo++;
          }
          return true;
       }
       else // if player wants to playe before turn
       {
          System.out.println( "You can't play! Wait for your turn!");
          return false;
       }
       
       
    }
    
    /**
    * Checks the turn of the player
    * @param p is any player
    * @return true and false whether it's the turn of the player
    */
    public boolean isTurnOf( Player p)
    {
        if ( players.get( turnOfPlayer).equals( p))
           return true;
        return false;
    }
    
    /**
    * Checks if the game is over or not
    * @return true and false whether if the game is over or not
    */
    public boolean isGameOver()
    {
        if ( roundNo > 13)
           return true;
        return false;
    }
    
    /**
    * gets the score of the player
    * @param playerNumber is the player number of the player
    * @return the score of the player
    */
    public int getScore( int playerNumber)
    {
        return scoreCard.getScore( playerNumber);
    }
    
    /**
    * checks the name of the player
    * @param playerNumber is the player number of the player
    * @return the name of the player
    */
    public String getName( int playerNumber)
    {
       return players.get( playerNumber).getName();
    }
    
    /**
    * gets the round number
    * @return round number
    */
    public int getRoundNo()
    {
        return roundNo;
    }
    
    /**
    * gets the turn of the player 
    * @return the turn of the player 
    */
    public int getTurnOfPlayerNo()
    {
        return turnOfPlayer;
    }
    
    /**
    * gets the winners of the game
    * @return winners of the game as players
    */
    public Player[] getWinners()
    {
       Player[] winners;
          winners = new Player[scoreCard.getWinners().length];
          
          for ( int i = 0; i < winners.length; i++)
          {
             winners[i] = players.get( (scoreCard.getWinners())[i]);
          }
         
       return winners;
    }
    
    /**
    * shows the current score card
    * @return the score card of the game
    */
    public String showScoreCard()
    {
        return scoreCard.toString();
    }
    
}