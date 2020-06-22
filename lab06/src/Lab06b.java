import java.util.Scanner; 

/** 
 * converts decimal value to its binary equivalent 
 * @author Bartu Atabek 
 * @version 1.0 26.04.2017 
 */  
public class Lab06b 
{ 
   public static void main( String[] args) 
   { 
      Scanner scan = new Scanner( System.in); 
      
      // constants 
      
      // variables 
      int input;
      
      // program code 
      System.out.print("Enter decimal number to convert to binary: ");
      input = scan.nextInt();
      
      binaryConverter(input);
   } 
   
   public static void binaryConverter(int num) {
     
      if (num < 2)
         System.out.print(num);
      else {
         binaryConverter(num / 2);
         System.out.print(num % 2);
      }
   }
}