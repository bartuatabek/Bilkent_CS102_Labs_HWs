import java.util.*; 

/** 
 * PostFix calculator that uses stack operations
 * @author Bartu Atabek 
 * @version 1.0 03.05.2017
 */  
public class PostFixCalc 
{ 
   public static void main( String[] args) 
   { 
      Scanner scan = new Scanner( System.in); 
      
      // constants 
      
      // variables 
      String input;
      SimpleStack calc; 
      
      // program code 
      calc = new SimpleStack();
      input = scan.next(); 

      while(scan.hasNext())
      {
         for(int i = 0; i < input.length(); i++)
         {
            char c = input.charAt(i);
            int x = 0;
            int y = 0;
            int r = 0;
            
            if (Character.isDigit(c))
            {
               int t = Character.getNumericValue(c);
               calc.push(c);
            }
            else if (c == '+')
            {
               x = calc.pop();
               y = calc.pop();
               r = x + y;
               calc.push(r);
            }
            else if (c == '-')
            {
               x = calc.pop();
               y = calc.pop();
               r = x - y;
               calc.push(r);
            }
            else if (c == '*')
            {
               x = calc.pop();
               y = calc.pop();
               r = x * y;
               calc.push(r);
            }
            else if (c == '/')
            {
               x = calc.pop();
               y = calc.pop();
               r = x / y;
               calc.push(r);
            }
         }
      }
      int result = calc.pop();
      System.out.println(result);
   } 
   
}
