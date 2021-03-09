// Exercise 26.5 Solution: RepaintTimer.java
// Repaints the JPanel with bouncing balls.
import javax.swing.JFrame;

public class RepaintTimer implements Runnable
{
   private final JFrame repaintComponent;

   public RepaintTimer( JFrame frame )
   {
      // specify component to be repainted
      repaintComponent = frame;
   } // end RepaintTimer constructor
   
   public void run()
   {
      while ( true )
      {
         try
         {
            Thread.sleep( 20 );
         } // end try
         catch ( InterruptedException ex )
         {
            ex.printStackTrace();
         } // end catch
         
         repaintComponent.repaint(); // repaint the component
     } // end while
   } // end method run
} // end class RepaintTimer



/**************************************************************************
 * (C) Copyright 1992-2010 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
