/** 
 * Square class that generates a square
 * object with desired side lenght
 * @author Bartu Atabek
 * @version 1.0 22.03.17
 */ 
public class Square extends Rectangle
{ 
   // properties 
   int side; 
   boolean selectable;
 
   // constructors 
   public Square( int side, boolean selectable)
   {
      super( side, side, selectable);
      this.side = side;
      this.selectable = selectable;
   }
    
   // methods 
   
   /**
    * gets the selectable property
    * @return selectable
    */
   public boolean getSelected()
   {
      return selectable;
   }
   
   /**
    * creates the toString representation of 
    * the square object
    * @return toString of the square
    */
   public String toString()
   {
      return "Square\n" + "x: " + getX() + "\ny: " + getY() + "\nSide: " + side 
             + "\nArea: " + super.getArea() + "\nSelected: " + selectable;
   }
   
 
}