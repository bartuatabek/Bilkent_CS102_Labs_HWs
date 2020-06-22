import java.util.*; 

/** 
 * enumerates and prints all n-digit even numbers in which each digit
 * of the number, from its most-significant to least-significant digits,
 * is greater than the previous one
 * @author Bartu Atabek 
 * @version 1.0 26.04.2017 
 */  
public class Lab06d 
{ 
   public static void main( String[] args) 
   { 
      Scanner scan = new Scanner( System.in); 
      
      // constants 
      
      // variables 
      int n;
      
      // program code 
      System.out.print("Enter an integer: ");
      n = scan.nextInt();
      
      int max = (int) Math.pow(10,n) - 1;
      int min = (int) Math.pow(10,n-1);
      
      evenFinder(max, min, n);
   }
   
   /**
    * finds even numbers with n digits
    * @param max maximum number with n digits
    * @param min minimum number with n digits
    * @param n is the number of digits
    */
   public static int evenFinder(int max, int min, int n)
   {
      if ( max == min)
         return min;
      if ( min % 2 == 0) 
      {
         eliminate(min, n); 
      }
      return evenFinder(max, min + 1, n);
   }
   
   /**
    * checks wheather the significant digits are greater than previous
    * @param n  is an even number 
    * @param digit is the digit of the number
    */ 
   public static void eliminate(int n, int digit)
   {
      if ( digit == 1)
         System.out.print(n + " ");
      else 
      {
         if (("" + (("" + n).charAt(digit - 2))).compareTo(("" + (("" + n).charAt(digit - 1)))) < 0)
            eliminate(n, digit - 1);
      }
   }
   
}