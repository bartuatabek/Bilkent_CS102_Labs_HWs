package shapes;

import java.awt.*;

/** 
 * Circle class that generates a circle
 * object with desired radius
 * @author Bartu Atabek
 * @version 1.0 22.03.17
 */ 
public class Circle extends Shape implements Selectable
{ 
   // constants
   final double PI = Math.PI;
   
   // properties 
   int radius;
   boolean selectable;
 
   // constructors 
   public Circle( int radius, boolean selectable, int x, int y)
   {
      this.radius = radius;
      this.selectable = selectable;
      this.setLocation( x, y);
   }
   
   //methods
   
   /**
    * get area method calculates and returns
    * the area of the circle
    * @return area of the circle
    */
   public double getArea()
   {
      return Math.pow(radius, 2) * PI;
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
    * @param  b is the boolean value whether true or false
    */
   public void setSelected( boolean b)
   {
      selectable = b;
   }
   
   /**
    * checks whether the circle contains the point 
    * or not with the according boolean result
    * @return boolean result wheter the circle contains the point
    */
   public Shape contains(  int x, int y)
   {
      int X;
      int Y;
      
      // get x and y value of the circle
      X = (x - getX()) * (x - getX());
      Y = (y - getY()) * (y - getY());
      
      // check if the point is within the boundaries
      if (X + Y <= radius * radius) 
         return this;
      return null;
   }
   
   /**
    * toString method creates a 
    * string representation for the cirlce
    * @return toString of the circle
    */
   public String toString()
   {
      return "Circle\n" + "x: " + getX() + "\ny: " + getY() + "\nRadius: " + radius +
             "\nArea: " + this.getArea() + "\nSelected: " + this.getSelected();
   }
   
   /**
    * changes the radius of the circle
    * @param radius is the radius of the circle
    */
   public void setRadius( int radius)
   {
      this.radius = radius;
   }

   /**
    * gets the radius of the circle
    * @return radius is the radius of the circle
    */
   public int getRadius()
   {
      return radius;
   }
   
}