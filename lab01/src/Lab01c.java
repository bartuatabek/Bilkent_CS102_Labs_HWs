import java.util.Scanner; 

/** 
 * Program presents the user with a menu having a range of 
 * options which can be selected in any order by typing 
 * the corresponding number to do certain actions for a collection
 * @author Bartu Atabek 
 * @version 1.0 10/02/17 
 */  
public class Lab01c 
{ 
   public static void main( String[] args) 
   { 
      Scanner scan = new Scanner( System.in); 
      
      // constants 
      
      // variables
      IntBag collection;
      IntBag result;
      int selection;
      int maxCap;
      int value;
      int count;
      int index;
      int testValue;
      Boolean check;
      
      // program code
      
      // initialization of cetain variables
      collection = new IntBag();
      count = 0;
      maxCap = 100; // initial max capacity for the collection
      testValue = 0;
      check = true;
      result = new IntBag();
      
      do 
      {  
         // User menu for selection
         System.out.println( "1. Create a new empty collection with a specified maximum capacity." );
         System.out.println( "2. Read a set of positive values into the collection (use a negative value to indicate all the values have been entered.)");
         System.out.println( "3. Print the collection of values.");
         System.out.println( "4. Add a value to the collection of values at a specified location.");
         System.out.println( "5. Remove the value at a specified location from the collection of values.");
         System.out.println( "6. Read a single test value.");
         System.out.println( "7. Compute the set of locations of the test value within the collection.");
         System.out.println( "8. Print the set of locations.");
         System.out.println( "9. Quit the program.");
         selection = scan.nextInt();
         
         // menu option #1 for creating the collection
         if ( selection == 1)
         {
            System.out.print( "Enter the max capacity for the collection.");
            maxCap = scan.nextInt(); // specified max capacity by the user
            
            collection = new IntBag(maxCap);
            System.out.println( "Collection created. \n");
         }
         
         // menu option #2 for adding values into the collection
         if ( selection == 2)
         {
            if ( count == maxCap) // max capacity warning
               System.out.println( "Collection at maximum capacity! \n");
            else
            {
               System.out.println( "Enter your values:");
               do
               {
                  // adding numbers until collection is full or adding is done
                  value = scan.nextInt();
                  if ( value >= 0)
                  {
                     collection.add(value);
                     count++;
                  }
               } while ( value >= 0 && count < maxCap);
               
               System.out.println( "Values added. \n");
            }
         }
         
         // menu option #3 for printing the collection
         if ( selection == 3)
         {
            System.out.println( "Collection: " + collection + "\n");
         }
         
         // menu option #4 for adding a value at a specific location in collection
         if ( selection == 4)
         {
            if ( count == maxCap) // max capacity warning
               System.out.println( "Collection at maximum capacity! \n");
            else
            {
               System.out.print( "Enter value:");
               value = scan.nextInt();
               System.out.print( "Enter location:");
               index = scan.nextInt();
               
               // adding the value to the specified location
               collection.addAt(value, index);
               System.out.println( "Value added. \n");
            }
         }
         
         // menu option #5 for removing a value from a specific location in collection
         if ( selection == 5)
         {
            System.out.print( "Enter location:");
            index = scan.nextInt(); 
            
            // removing the value from the specific location
            collection.remove(index);
            System.out.println( "Value at the location removed. \n");
            count--;
         }
         
         // menu option #6 for reading a single test value
         if ( selection == 6)
         {
            System.out.println( "Enter a test value.");
            testValue = scan.nextInt();
            
            // check if test value is valid
            for ( int i = 0; i < collection.size(); i++)
            {
               if ( collection.getValue(i) == testValue)
                  check = true;
            }
            if (!check)
            {
               System.out.println("Test value is not valid!");
               testValue = scan.nextInt();
            }
         }
                  
         // menu option #7 for the computing the set of locations of the test value within the collection
         if ( selection == 7)
         {
            result = collection.findAll(testValue);
         }
         
         // menu option #8 for showing the results to the user
         if ( selection == 8)
         {
            System.out.println(result);
         }
         
         } while ( selection != 9);
         
         // goodbye message
         System.out.println( "Goodbye.");
         
         }
}