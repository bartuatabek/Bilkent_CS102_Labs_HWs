import java.util.*; 
 
/** 
 * Progtram test the IntBagIterator class and it's methods 
 * @author Bartu Atabek 
 * @version 1.0 22.03.17 
 */  
public class Testiterators 
{ 
   public static void main( String[] args) 
   { 
      Scanner scan = new Scanner( System.in); 
      
      // variables 
      IntBag bag;
      Iterator i, j;
      
      // program code 
      bag = new IntBag();
      
      // adding random values to the collection
      for ( int k = 1; k <= 10; k++)
      {
         bag.add( k);
      }
      
      // testing the iterator
      i = new IntBagIterator( bag);
      
      while ( i.hasNext() ) 
      {
         System.out.println( i.next() );
         
       // j = new IntBagIterator( bag);
          j = bag.iterator();
         
         while ( j.hasNext() )
         {
            System.out.println( "--" + j.next() );
         }
      }
   } 
   
}