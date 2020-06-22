import java.util.*;

/** 
 * A simple linked list class 
 * @author Bartu Atabek
 * @version 1.0 03.05.2017
 */ 
public class SimpleStack extends SimpleLinkedList
{ 
   // properties 

   // constructors
   public SimpleStack()
   {
      super();
   }
   
   // methods
   
   /**
    * Adds an element to the top of the stack
    * @param element the element to add
    */
   public void push(String element)
   {
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      first = newNode;
   }
   
   /**
    * Removes the element from the top of the stack
    * @return the removed element
    */
   public Object pop()
   {
      if (first == null) { throw new NoSuchElementException(); }
      String element  = first.data;
      first = first.next;
      return element;
   }
   
   /**
    * Checks whether this stack is empty
    * @return true if stack is empty
    */
   public boolean isEmpty()
   {
      return super.isEmpty();
   }
   
}
   