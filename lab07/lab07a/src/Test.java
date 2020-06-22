import java.util.Scanner; 

/** 
 * Testing simple linked list 
 * @author Bartu Atabek
 * @version 1.0 03.05.2017
 */ 
public class Test
{ 
   public static void main( String[] args) 
   { 
      Scanner scan = new Scanner( System.in); 
      
      // constants 
      
      // variables 
      SimpleLinkedList list;
      
      // program code 
      list = new SimpleLinkedList(); // create list
      
      // add elements
      list.addToHead("Apple"); 
      list.addToHead("David");
      list.addToHead("Bartu");
      list.addToHead("Bias"); 
      list.addToHead("Jarvis"); 
      
      System.out.println("List: " + list); // print the entire list
      System.out.println();
      
      // get the items at various index locations
      System.out.println(list.get(0));
      System.out.println(list.get(3));
      System.out.println(list.get(4));
      System.out.println();
      
      // remove elements
      while (!list.isEmpty())
      {
         System.out.println(list.removeFromHead());
         System.out.println("List: " + list);
      }
      
   } 
   
}