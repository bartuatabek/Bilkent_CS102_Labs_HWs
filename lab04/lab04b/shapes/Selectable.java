package shapes;

/** 
 * Selectable interface
 * @author Bartu Atabek 
 * @version 1.0 22.03.17 
 */  
public interface Selectable
{
   public boolean getSelected();
   
   public void setSelected( boolean b);
   
   public Shape contains( int x, int y);
}