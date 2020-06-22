import java.util.Scanner; 
 
/** 
 * Program computes and displays the first 100 prime numbers 
 * @author Bartu Atabek 
 * @version 1.0 10/02/17 
 */  
public class Lab01b 
{ 
   public static void main( String[] args) 
   { 
      Scanner scan = new Scanner( System.in); 
 
      // constants 
 
      // variables
      IntBag primes;
      int value;
      int size;
      int index;
      
 
      // program code
      
      // ask the user for the size
      System.out.println("Enter your size.");
      size = scan.nextInt();
      
      // initialization an instance of IntBag class 
      // and addition the first prime number (2)
      primes = new IntBag(size); 
      primes.add(2); 
      value = 3;
      
      for ( int i = 1; i < size; i++)
      {
         index = 0;
         while ( index < i)
         {
            if ( value % primes.getValue(index) == 0)
            {
               value++;
               index = -1;
            }
            index++;
         }
         primes.add(value);
         value++;
      }      
      
      // printing the entire collection
      System.out.println( "Primes: " + primes);
      
     
         
               

   } 
 
}