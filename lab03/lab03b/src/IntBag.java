import java.util.*;

/** 
 * IntBag class enables the creation of integer collections
 * of desired size and modifies the collection with the
 * included methods.
 * @author Bartu Atabek 
 * @version 2.0 22.03.17 
 */ 
public class IntBag implements Iterable
{ 
   // properties
   private int[] bag;
   private int valid;
 
   // constructors
   public IntBag()
   {
      bag = new int[100];
      valid = 0;
   }
   
   public IntBag( int maxNumberOfElements)
   {
      bag = new int[maxNumberOfElements];
      valid = 0;
   }
    
   // methods
   
   /** 
    * Creates a String representation of the collection
    * @return the string representation of the collection
    */ 
   public String toString()
   {
      String str;
      str = "[";
      for ( int i = 0; i < valid; i++)
      {
         if ( i == 0)
            str += bag[i];
         else
            str +=  "," + bag[i] ;
      }
      return str + "]";
   }
   
   /** 
    * Adds an integer to the collection
    * @param n is any integer number
    */ 
   public void add( int n)
   {
      bag[valid] = n;
      valid++;
   }
   
   /** 
    * Adds an integer to any location chosen by user and
    * shifts the collection respectively
    * @param n is any integer number
    * @param index is a particular index location for the integer n
    */ 
   public void addAt( int n, int index)
   {
      if ( index < 0 || index > 100)
         System.out.print( "Index not in bounds!");
      else
      {
         for ( int i = valid - 1; i >= index - 1; i--)
         {
            bag[i + 1] = bag[i];
         }
         bag[index - 1] = n;
         valid++;
      }
   }
   
   /** 
    * removes the integer at a particular index location from the collection 
    * @param index is the particular index location of the number to be removed
    */ 
   public void remove( int index)
   {
      if ( index < 0 || index > 100)
         System.out.print( "Index not in bounds!");
      else
      {
         for (int i = index; i < valid; i++)
         {
            bag[i - 1] = bag[i];
         }
         valid--;
      }
   }
   
   /** 
    * Checks the entire collection for whether it contains a given value or not
    * @param n is any integer number
    * @return true if value is in the collection 
    * returns false if value is not in the collection
    */ 
   public boolean isContain( int n)
   {
      for ( int i = 0; i <= valid; i++)
      {
         if ( i == n)
            return true;
      }
      return false;
   }
   
   /** 
    * Calculates the size of the collection
    * @return the size of the collection as an integer
    */ 
   public int size()
   {
      return valid;
   }
   
   /** 
    * Gets the value at location i within the collection.
    * @param index is a particular index location for the value
    * @return null if index is not within boundaries
    * else the value at location i
    */ 
   public Integer getValue( int index)
   {
      if ( index < 0 || index > size())
      {
         System.out.print( "Index not in bounds!");
         return null;
      }
      else
      {
         return bag[index];
      }
   }
   
  /** 
   * Gets the indexes of the entered number in the collection.
   * @param n is any particular value in the collection
   * @return the the locations (indexes) of all instances 
   * of a given value in the collection
   */ 
   public IntBag findAll (int n)
   {
      IntBag index;
      index = new IntBag();
      
      for ( int i = 0; i < valid; i++)
      {
         if ( bag[i] == n)
            index.add(i);
      }
      return index;
   }
         
    /** 
    * create an instance of IntBagIterator
    * @return return IntBagIteratort as the interface type
    */ 
   public Iterator iterator()
   {
      return new IntBagIterator(this);
   }
}