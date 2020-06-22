/** 
 * Rectangle class that generates a rectangle
 * object with desired width and height
 * @author Bartu Atabek
 * @version 1.0 22.03.17
 */ 
public class Rectangle extends Shape implements Selectable
{ 
   // properties 
   int width; 
   int height;
   boolean selectable;
 
   // constructors 
   public Rectangle( int width, int height, boolean selectable)
   {
      this.width = width;
      this.height = height;
      this.selectable = selectable;
      //this.setLocation( width / 2, height / 2);
   }
    
   // methods 
   
   /**
    * get area method calculates and returns
    * the area of the rectangle
    * @return area of the rectangle
    */
   public double getArea()
   {
      return width * height;
   }
   
   /**
    * gets the selectable property
    * @return selectable
    */
   public boolean getSelected()
   {
      return selectable;
   }
   
   
   /**
    * sets the selectable with desired boolean result
    * @param b is the boolean value whether true or false
    */
   public void setSelected( boolean b)
   {
      selectable = b;
   }
   
   /**
    * checks whether the rectangle contains the point 
    * or not with the according boolean result
    * @return boolean result wheter the rectangle contains the point
    */
   public Shape contains( double x, double y)
   {
      if ( ( x <= this.getX() + width) && y <= ( this.getY() + height) && y >= this.getY() && x >= this.getX() ) 
         return this; 
      else 
         return null; 
   }
   
   /**
    * creates the toString representation of 
    * the rectangle object
    * @return toString of the rectangle
    */
   public String toString()
   {
      return "Rectangle\n" + "x: " + getX() + "\ny: " + getY() + "\nWidth: "
             + width + "\nHeight: " + height + "\nArea: " + this.getArea() 
             + "\nSelected: " + selectable;
   }
 
}