package shapes;
import java.util.*;

/**
 * ShapeIterator class enables the elements to be iterated 
 * through several times, and manages multiple independent iterations 
 * @author Bartu Atabek
 * @version 1.0 29.03.17
 */ 
public class BalloonIterator implements ShapeIterator
{
   // properties
   private ShapeContainer container;
   private int index;
   
   // constructor
   public BalloonIterator( ShapeContainer shapes)
   {
      container = shapes;
      index = 0;
   }
   
   // methods
   
   /**
    * checks whether the collection has a next value 
    * @return boolean result
    */
   public boolean hasNext()
   { 
      return index < container.size(); 
   } 
   
   /**
    * gets the next value from the collection
    * @return next value from the collection
    */
   public Shape nextShape()
   { 
      return (Shape)container.shapes.get(index++); 
   } 
   
   /**
    * custom nextInt method for avoiding changes
    * @return next value from the collection
    */
   public Object next()
   {
      return (Shape)container.shapes.get(index++); 
   }
}