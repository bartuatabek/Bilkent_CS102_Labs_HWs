import java.util.Scanner; 
 
/** 
 * ShapeTester class with given a menu that allows the user
 * to create an empty set of shapes, add shapes to it compute 
 * the total surface area of the entire set of shapes, and print out 
 * information about all of the shapes in the container
 * @author Bartu Atabek 
 * @version 1.0 22.03.17
 */  
public class ShapeTester  
{ 
   public static void main( String[] args) 
   { 
      Scanner scan = new Scanner( System.in); 
 
      // constants 
 
      // variables 
      int selection;
      int selection2;
      int radius;
      int height;
      int width;
      int side;
      double x;
      double y;
      ShapeContainer container;
 
      // program code 
      
      container = new ShapeContainer();
     
      do
      {
         // welcome message and menu
         System.out.println( "___Welcome___\nPlease choose an option from the menu below."); 
         System.out.println( "1. Create empty set of shapes");
         System.out.println( "2. Add shape");
         System.out.println( "3. Compute the total surface area");
         System.out.println( "4. Get information about all the shapes");
         System.out.println( "5. Find the first shape containing a point");
         System.out.println( "6. Remove all selected shapes");
         System.out.println( "7. Exit");
         
         selection = scan.nextInt();
         
         {
            if ( selection == 1)
            {
               container = new ShapeContainer();
               System.out.println( "Empty set created.\n");
            }
            
            if ( selection == 2)
            {
               do 
               {
                  // secindary menu for shape creation and addition
                  System.out.println( "\nChoose a shape from the menu below.");
                  System.out.println( "1. Circle");
                  System.out.println( "2. Rectangle");
                  System.out.println( "3. Square");
                  System.out.println( "4. Go back to main menu");
                  
                  selection2 = scan.nextInt();
                  
                  if ( selection2 == 1) // creating and adding a circle
                  {
                     System.out.println( "Enter radius: ");
                     radius = scan.nextInt();
                     if ( radius < 0)
                     {
                        System.out.println( "Enter a positive integer!");
                        radius = scan.nextInt();
                     }
                     container.add( new Circle( radius, false));
                     System.out.println( "Shape added to the container.\n");
                  }
                  
                  if ( selection2 == 2) // creating and adding a rectangle
                  {
                     System.out.println( "Enter width:");
                     width = scan.nextInt();
                     if ( width < 0)
                     {
                        System.out.println( "Enter a positive integer!");
                        width = scan.nextInt();
                     }
                     
                     System.out.println( "Enter height:");
                     height = scan.nextInt();
                     if ( height < 0)
                     {
                        System.out.println( "Enter a positive integer!");
                        height = scan.nextInt();
                     }
                     
                     container.add( new Rectangle( width, height, false));
                     System.out.println( "Shape added to the container.\n");
                  }
                  
                  if ( selection2 == 3) // creating and adding a square
                  {
                     System.out.println( "Enter side:");
                     side = scan.nextInt();
                     if ( side < 0)
                     {
                        System.out.println( "Enter a positive integer!");
                        side = scan.nextInt();
                     }
                     
                     container.add( new Square( side, false));
                     System.out.println( "Shape added to the container.\n");
                  }
               } while ( selection2 != 4);
            }
            
            if ( selection == 3)
            {
               // calculating and printing the total area
               System.out.println( "Total Area: " + container.getArea() + "\n");
            }
            
            if ( selection == 4)
            {
               System.out.println( container); // printing info of each shape
            } 
            
            if ( selection == 5)
            {
               System.out.println( "Enter x:");
               x = scan.nextInt();
               System.out.println( "Enter y:");
               y = scan.nextInt();
                  
               System.out.println( container.findShape( x, y) + "\n");
            }
            
            if ( selection == 6) 
            {
               container.remove();
               System.out.println( "Selected shapes removed.\n");
            }
         }
      } while ( selection != 7);
      System.out.println( "GoodBye..."); 
   } 
}

