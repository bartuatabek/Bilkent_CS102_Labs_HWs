import java.util.*; 
import cs1.SimpleURLReader;
 
/** 
 * Program that will read the contents of the entered url
 * and stores it in the collection which can be accessible 
 * by a series of menus.
 * @author Bartu Atabek 
 * @version 1.0 06/03/17 
 */  
public class Program   
{ 
   public static void main( String[] args) 
   { 
      Scanner scan = new Scanner( System.in); 
 
      // constants 
 
      // variables
      ArrayList<MySimpleURLReader> collection;
      int selection;
      int index;
      String url;
 
      // program code 
      
      collection = new ArrayList<MySimpleURLReader>();
      
      do
      {
         // welcome message & selection
         System.out.println( "___Welcome___");
         System.out.println( "(1) Enter the url of poem to add to collection");
         System.out.println( "(2) List all poems in the collection");
         System.out.println( "(3) Quit");
         System.out.print( "Choose an option from the menu above: ");
         selection = scan.nextInt();
         
         if ( selection == 1)
         {
            System.out.print( "Please enter the url of poem: ");
            url = scan.next();
            
            if ( url.substring( url.length() - 4).equals( "htm" )) 
               collection.add( new MySimpleURLReader(url));
            else
               collection.add( new HTMLFilteredReader(url));
               
            
            System.out.print( "\nPoem added to the collection.\n"); 
            
         }
         
         else if ( selection == 2)
         {
            do
            {
               if ( collection.size() == 0)
               {
                  System.out.println( "There are no poems in the collection!\n");
                  index = collection.size();
               }
               else
               {
                  for ( int i = 0; i < collection.size(); i++)
                  {
                     System.out.println( (i) + " - " + collection.get(i).getName());
                  }
                  
                  System.out.print( "Enter index number to view file: ");
                  index = scan.nextInt();
                  
                  // view file
                  if ( index < collection.size())
                     System.out.println( collection.get(index).getPageContents());
               }
            } while (  index < collection.size() ); // return main menu  
         } 
         
      } while ( selection != 3);
      
      System.out.println( "Goodbye...");
   }
}