// Exercise 26.5 Solution: BallPanel.java
// JPanel that creates a ball when the mouse is pressed.  Ball bounces
// around the JPanel.
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class BallPanel extends JPanel
{
   private Ball blueBall; // bouncing ball
   private ExecutorService threadExecutor; // for running Ball runnable
   private JFrame parentWindow; // parent window of JPanel
   private final int MAX_X = 200; // horizontal edge of JPanel
   private final int MAX_Y = 200; // vertical edge of JPanel

   public BallPanel( JFrame window )
   {
      parentWindow = window; // set parent window of JPanel

      // create ExecutorService for running ball runnable
      threadExecutor = Executors.newCachedThreadPool();

      // anonymous inner class handles mouse events
      this.addMouseListener( 
         new MouseAdapter() 
         {
            public void mousePressed( MouseEvent event ) 
            {
               createBall( event ); // delegate call to ball starter
               RepaintTimer timer = new RepaintTimer( parentWindow );
               threadExecutor.execute( timer );
            } // end method mousePressed
         } // end anonymous inner class
      ); // end call to addMouseListener
   } // end BallPanel constructor

   // create a ball if no ball exists and set it in motion
   private void createBall( MouseEvent event )
   {
      if ( blueBall == null ) // if no ball exists
      {
         int x = event.getX(); // get x position of mouse press
         int y = event.getY(); // get y position of mouse press
         blueBall = new Ball( x, y ); // create new ball
         threadExecutor.execute( blueBall ); // set ball in motion
      } // end if
   } // end method createBall

   // return minimum size of animation
   public Dimension getMinimumSize()
   { 
      return getPreferredSize(); 
   } // end method getMinimumSize

   // return preferred size of animation
   public Dimension getPreferredSize()
   {
      return new Dimension( MAX_X, MAX_Y );
   } // end method getPreferredSize

   // draw ball at current position
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );

      if ( blueBall != null ) // if ball exists
      {
         g.setColor( Color.blue ); // set color to blue
         g.fillOval( blueBall.getX(), blueBall.getY(), 10, 10 ); // draws
      } // end if
   } // end method paintComponent
} // end class BallPanel


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
