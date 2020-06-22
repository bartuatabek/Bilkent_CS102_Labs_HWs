import shapes.*;
import java.awt.*;
import java.util.*;

/** 
 * Baloons
 * @author Bartu Atabek 
 * @version 1.0 29.03.17 
 */  
public class Balloons extends Circle implements Drawable
{ 
   // properties 
   static final int DEFAULT_SIZE = 25;
   Color randomColor;
   int R;
   int G;
   int B;
   Random r;
   
   // constructors 
   public Balloons( int x, int y)
   {
      super( DEFAULT_SIZE, false, x, y);
      
      // generate random color for the balloons
      R = (int) (Math.random( ) * 256);
      G = (int) (Math.random( ) * 256);
      B = (int) (Math.random( ) * 256);
      randomColor = new Color(R, G, B);
      
      // random boolean value
      r = new Random(); 
   }
    
   // methods 
   
   /**
    * increases the radius of the balloon
    * from default to 100 then resets and
    * sets balloon to selectable 
    */ 
   public void grow()
   {
      setRadius( getRadius() + 1); // increases radius of the balloons
      setLocation( getX(), getY() - 5); // increases the position of the balloons
      
      if (r.nextBoolean())
         setLocation( getX() + (int) Math.random() * 10, getY() + (int) Math.random() * 10); // random wind effect to increase difficulty
      if ( super.getRadius() > 100)
      {
         super.setSelected(true);
         super.setRadius(0);
      }
   }
   
   /**
    * draws the balloon by using the information
    * of the circle
    * @param g is an instance of the graphics object
    */
   public void draw( Graphics g)
   { 
      int radius = getRadius();
      
      g.setColor(randomColor); 
      g.fillOval(getX() - radius, getY() - radius, radius * 2, radius * 2);
   }
   
}