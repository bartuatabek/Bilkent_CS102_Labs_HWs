import java.util.Scanner; 

/** 
 * Basic Fibonacci sequence demonstrates basic functional recursion 
 * @author Bartu Atabek 
 * @version 1.0 26.04.2017 
 */  
public class Lab06e 
{ 
   public static void main( String[] args) 
   { 
      Scanner scan = new Scanner( System.in); 
      
      // constants 
      
      // variables 
      int n;
      
      // program code 
      System.out.println( "Enter number: ");
      n = scan.nextInt();
      
      System.out.println(fibonacci(n));
   }
   
   /** 
    * basic Fibonacci sequence demonstrates basic functional recursion
    * @param n is any integer
    */
   public static int fibonacci(int n)
   {
      if (n == 0)
         return 0;
      if (n < 2) 
         return 1;
      else 
         return fibonacci(n - 1) + fibonacci(n - 2);
      
   }
   
   
}