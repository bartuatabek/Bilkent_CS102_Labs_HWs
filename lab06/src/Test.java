public class Test
{ 
   public static void main( String[] args) 
   { 
      
      // constants 
      
      // variables 
      
      // program code 
      int number = 142;
      eliminate(number,10,99);
   }
   
   public static void eliminate(int n, int start, int end) {    
      int digits = ("" + n).length();
       if ( digits == 1)
          System.out.println(n);
       else 
       {
          if ( ("" + ("" + n).charAt(digits-2)).compareTo(("" + ("" + n).charAt(digits-1))) == -1)
             eliminate(digits-1, start,end);
       }
   }
}