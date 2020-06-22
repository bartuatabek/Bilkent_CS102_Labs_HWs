package shapes;
import java.util.*;

/** 
 * adds an additional int nextShape() method to the iterator class
 * @author Bartu Atabek 
 * @version 1.0 29.03.17 
 */ 
public interface ShapeIterator extends Iterator
{ 
   public Shape nextShape(); 
}