package shapes;

import java.util.*;
import java.awt.*;

/** 
 * ShapeContainer class contains various
 * shapes and allows to make certain operations
 * @author Bartu Atabek
 * @version 1.0 22.03.17
 */ 
public class ShapeContainer implements Iterable
{ 
   // properties
   ArrayList <Shape> shapes;
   double totalArea;
 
   // constructors 
   public ShapeContainer()
   {
      shapes = new ArrayList <Shape>();
      this.totalArea = totalArea;
   }
    
   // methods
   
   /**
    * add method to add a shape into shape container
    * which also updates the total area
    * @param s is any shape
    */
   public void add( Shape s)
   {
      shapes.add(s);
   }
   
   /**
    * get area method calculates and returns
    * the total area of the shapes that are in the container
    * @return total area of the shapes
    */
   public double getArea()
   {
      // find area with iterator
      Iterator iterator;
      iterator = shapes.iterator();
      while ( iterator.hasNext())
      {
         totalArea += ((Shape)iterator.next()).getArea();
      }
      return totalArea;
   }
   
   /**
    * to string method for the shapes
    * @return the string 
    */
    public String toString()
    {
       String str;
       str = "";
       
       for ( Shape s : shapes)
       {
          str += "\n" + s + "\n";
       }
       return str;
    }
    
    /**
    * finds the shape with the given point
    * @param x is the x cordinate of the point P
    * @param y is the y cordinate of the point P
    * @return the shape 
    */
    public Shape contains( int x, int y)
    {  
       Shape s;
       
       for (Shape shape : shapes)
       {
          s = ((Selectable)shape).contains(x, y);
          if (s != null)
             return s;
       }
       return null;
    }
    
    /**
    * removes all the selected shapes from the container
    */
    public void removeSelected()
    {
       for (int i = 0; i < shapes.size(); i++)
       {
          if (((Selectable)shapes.get(i)).getSelected())
          {
             shapes.remove(i);
             i--;
          }
       }
    }
    
    /**
    * gets the number of shapes in the container
    * @return the number of shapes in the container
    */
    public int size()
    {
       return shapes.size();
    }
    
    /**
    * returns the number of shapes found at the point x,y
    * and sets the selected property of those shapes to true
    * @param x is the x coordinate of the shape
    * @param y is the y coordinate of the shape
    * @return count of shapes found at the point x,y
    */
    public int selectAllAt( int x, int y)
    {
       int count;
       count = 0;
       
       for (Shape shape : shapes)
       {
          Shape s = ((Selectable)shape).contains(x, y);
          if (s != null)
          {
             ((Selectable)s).setSelected(true);
             count++;
          }
       }
       return count;
    }
    
    /**
    * creates an instance of BalloonIterator
    * @return BalloonIterator as interface type
    */
    @Override
    public Iterator<Shape> iterator()
  {
    return shapes.iterator();
  }
}