import java.util.Scanner; 

/** 
 * Counts the occurrences of the character 'e' in a string 
 * @author Bartu Atabek 
 * @version 1.0 26.04.2017 
 */  
public class Lab06a 
{ 
   private static int index = 0;
   
   public static void main( String[] args) 
   { 
      Scanner scan = new Scanner( System.in); 
      
      // constants 
      char c = 'e';
      
      // variables 
      String line;
      
      // program code 
      
      System.out.print("Add String: ");
      line = scan.nextLine();
      
      System.out.println(occur(line,c));
   } 
   
   /**
    * 
    * @param str is any string
    * @param c is the char that will be counted
    * @return number of times char counted
    */
   public static int occur(String str, char c) {
      if (index >= str.length()) //checking strings length 
         return 0;
      index++;
      if (str.charAt(index - 1) == c) // finding the occurrence recursively
         return 1 + occur(str,c);
      else
         return 0 + occur(str,c);
   }
   
}