import java.util.*;
   
/** 
 * IntBagIterator class enables the elements to be iterated 
 * through several times, and manages multiple independent iterations 
 * @author Bartu Atabek
 * @version 1.0 22.03.17
 */ 
public class IntBagIterator implements IntIterator 
{ 
   // properties 
   private IntBag aBag;
   private int index;
 
   // constructors 
   public IntBagIterator(IntBag bag)
   {
      aBag = bag;
      index = 0;
   }
    
   // methods 
   
   /**
    * checks whether the collection has a next value 
    * @return boolean result
    */
   public boolean hasNext()
   { 
      return index < aBag.size(); 
   } 
   
   /**
    * gets the next value from the collection
    * @return next value from the collection
    */
   public Object next()
   { 
      return (Integer)aBag.getValue(index++); 
   } 
   
   /**
    * custom nextInt method for avoiding changes in IntBag
    * @return next value from the collection
    */
   public int nextInt()
   { 
      return (Integer)aBag.getValue(index++); 
   }
   
}