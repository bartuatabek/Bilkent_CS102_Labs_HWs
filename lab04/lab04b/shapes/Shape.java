package shapes;

import java.util.*;

/** 
 * A shape class for the extended shape hierarchy
 * which includes square, rectangle and circle
 * @author Bartu Atabek
 * @version 1.0 22.03.17
 */ 
public abstract class Shape implements Locatable
{ 
   // properties
   int x;
   int y;
 
   // constructors 
    
   // methods 
   public abstract double getArea(); // abstract get area method
   
   /** 
    * Sets the location of the shape
    * @param x is the x coordinate
    * @param y is the y coordinate
    */
   public void setLocation(  int x, int y)
   {
      this.x = x;
      this.y = y;
   }
   
   /**
    * gets the x coordinate of the shape
    * @return x is the x coordinate
    */
   public int getX()
   {
      return x;
   }
   
   /**
    * gets the y coordinate of the shape
    * @return y is the y coordinate
    */
   public int getY()
   {
      return y;
   }
}
