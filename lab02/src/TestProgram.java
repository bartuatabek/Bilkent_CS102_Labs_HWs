import java.util.*; 
import cs1.SimpleURLReader;
 
/** 
 * Test program that will read the contents of this url
 * and print it and the number of lines it contains, on the console. 
 * @author Bartu Atabek 
 * @version 1.0 06/03/17 
 */  
public class TestProgram   
{ 
   public static void main( String[] args) 
   { 
      Scanner scan = new Scanner( System.in); 
 
      // constants 
 
      // variables
      SimpleURLReader var1;
      MySimpleURLReader var2 ;
      HTMLFilteredReader var3;
      SuperHTMLFilteredReader var4;
     
 
      // program code 
      
      // testing SimleURLReader class
      var1 = new SimpleURLReader("http://www.cs.bilkent.edu.tr/~david/housman.txt");
      // printing the url
      System.out.println( "Page Contents: " + "\n" + var1.getPageContents()); 
      // printing the # of lines in the url
      System.out.println( "Line Count: " + var1.getLineCount()); 
      
      // testing MySimleURLReader class
      var2 = new MySimpleURLReader("http://www.cs.bilkent.edu.tr/~david/housman.txt");
      // get url
      System.out.println( "URL: " + var2.getURL());
      // get name
      System.out.println( "Name: " + var2.getName());
      
      // testing HTMLFilteredReader class
      var3 = new HTMLFilteredReader("http://www.cs.bilkent.edu.tr/~david/housman.htm");
      // get contents
      System.out.println( "Contents: " + var3.getPageContents());
      // get unfiltered page contents
      System.out.println( "Unfiltered contents: " + var3.getUnfilteredPageContents());
      
      // testing SuperHTMLFilteredReader class
      var4 = new  SuperHTMLFilteredReader("http://www.cs.bilkent.edu.tr/~david/index.html");
      // get overhead
      System.out.println( "Overhead: " + var4.getOverhead());
      // get links
      System.out.println( "Links: " + var4.getLinks());
      
      //  testing extended type checking mechanism
      var3 = var4;
      var4 = (SuperHTMLFilteredReader) var3;
      
      ( (SuperHTMLFilteredReader)var3).getOverhead();                  
                         
   } 
 
}