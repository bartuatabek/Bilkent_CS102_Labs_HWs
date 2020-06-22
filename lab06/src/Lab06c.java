import java.util.*; 

/** 
 * Checks whether the Arraylist of Strings is  lexicographic or not 
 * @author Bartu Atabek 
 * @version 1.0 26.04.2017 
 */  
public class Lab06c 
{ 
   public static void main( String[] args) 
   { 
      Scanner scan = new Scanner( System.in); 
      
      // constants 
      
      // variables 
      ArrayList<String> list;
      
      // program code 
      list = new ArrayList<String>();
      
      // case 1
//      list.add("Bartu");
      // case 2
//      list.add("Bartu");
//      list.add("Cevahir");
//      list.add("David");
      // case 3
      list.add("David");
      list.add("Yusuf");
      list.add("Bartu");
      
      System.out.println( "Sorted: " + isSorted(list,list.size()) );
      
   }
   
   /**
    * checks whether the ArrayList of Strings is  lexicographic or not 
    * @param list is the ArrayList containing String values
    * @param n is the index value
    * @return true if it is sorted or false otherwise
    */
   public static boolean isSorted(ArrayList<String> list, int n) {
      // Null or less then 2 elements is sorted.
      if ( list == null || n < 2) {
         return true;
      }
      else if ( (list.get(n - 2).compareTo(list.get(n - 1)) ) > 0){
         // If the element before (n-2) this one (n-1) is greater,
         return false;
      }
      // recursion
      return isSorted(list, n - 1);
   }
   
}