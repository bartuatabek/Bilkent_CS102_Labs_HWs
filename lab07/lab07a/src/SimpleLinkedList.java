import java.util.*;

/** 
 * A simple linked list class 
 * @author Bartu Atabek
 * @version 1.0 03.05.2017
 */ 
public class SimpleLinkedList  
{ 
   // properties 
   private Node first;
   
   // constructors 
   public SimpleLinkedList()
   {
      first = null;
   }
   // methods 
   
   /**
    * Adds an element to the front of the linked list
    * @param item the item to add
    */ 
   public void addToHead( String item)
   {
      Node newNode = new Node();
      newNode.data = item;
      newNode.next = first;
      first = newNode;
   }
   
   /**
    * Removes the first element in the linked list
    * @return the removed element
    */ 
   public String removeFromHead()
   {
      if (first == null) { throw new NoSuchElementException();}
      
      String element = first.data;
      first = first.next;
      return element;
   }
   
   /**
    * Checks whether the list is empty or not
    * @return true if the list is empty
    */ 
   public boolean isEmpty()
   {
      return first == null;
   }
   
   /**
    * Gets the string in the given index if it exists
    * @param index is the index of the string in the list
    * @return string in the given index if it exists
    */ 
   public String get( int index)
   {
      if (index < 0)
         return null;
      Node current = null;
      if (first != null) 
      {
         current = first;
         for (int i = 0; i < index; i++) 
         {
            if (current.next == null)
               return null;
            
            current = current.next;
         }
         return current.data;
      }
      return current + "";
   }
   
   /**
    * Representation of the linked list and its elements in string form
    */ 
   public String toString()
   {
      Node current = first;
      String str = "" ;
      
      if (current == null)
         return "";
      
      while (current.next != null)
      {
         str += current.data + ", ";
         current = current.next;
      }
      return str + current.data;
      
   }
   
   
   
   // inner classes
   static class Node
   {
      public String data;
      public Node next;
   }
   
//   class LinkedListIterator implements ListIterator
//   {
//      private Node position;
//      private Node previous;
//      private boolean isAfterNext;
//      
//      /**
//       * Constructs an iterator that points to the front
//       * of the linked list
//       */
//      public LinkedListIterator()
//      {
//         position = null;
//         previous = null;
//         isAfterNext = false;
//      }
//      
//      // methods
//      
//      /**
//       * Moves the iterator past the next element
//       * return the transversed element
//       */
//      public String next()
//      {
//         if (!hasNext()) { throw new NoSuchElementException();}
//         System.out.println( "No such element!");
//         
//         previous = position; 
//         isAfterNext = true;
//         
//         if ( position == null)
//            position = first;
//         else
//            position = position.next;
//         return position.data;
//      }
//      
//      /**
//       * Tests if there is an element after the iterator position
//       * @return true if there is an element after the iterator position
//       */
//      public boolean hasNext()
//      {
//         if (position == null)
//            return first != null;
//         else
//            return position.next != null;
//      }
//   }
}