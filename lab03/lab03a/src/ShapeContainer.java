import java.util.*;

/** 
 * ShapeContainer class contains various
 * shapes and allows to make certain operations
 * @author Bartu Atabek
 * @version 1.0 22.03.17
 */ 
public class ShapeContainer
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
      //totalArea += s.getArea();
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
    public Shape findShape( double x, double y)
    {  
       for ( int i = 0; i < shapes.size(); i++)
       {
          if ( ( (Selectable)shapes.get(i)).contains( x, y) != null)
          {
             ((Selectable)shapes.get(i)).setSelected( true);
             return shapes.get(i);
          }
       }
       return null;
    }
    
    /**
    * removes all the selected shapes from the container
    */
    public void remove()
    {
       for ( int i = 0; i < shapes.size(); i++)
       {
          if ( ( (Selectable)shapes.get(i)).getSelected())
          {
              shapes.remove(i--);
              
          }
            
       }
    }
}