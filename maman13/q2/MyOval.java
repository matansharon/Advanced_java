import java.awt.*;
/**
 * class MyOval represent an oval, this class extends MyBoundedShape 
 * as rectangle can be full or empty
 * 
 * @author Matan Sharon 
 * @version 22.4.2020
 */
public class MyOval extends MyBoundedShape
{
    
    /**
     * MyOval Constructor  will create an oval object
     *
     * @param x1 A parameter for the top left corrner
     * @param y1 A parameter for the top left corrner
     * @param x2 A parameter for the width
     * @param y2 A parameter for the height
     * @param color A parameter for the color
     * @param full A parameter to decide if the oval is full or empty
     */
    public MyOval(int x1,int y1,int x2,int y2,Color color,boolean full)
    {
        super(x1,y1,x2,y2,color,full);
    }
     /**
     * Method toString is a String represntion of the oval
     *
     * @return an indicating that this is a oval object
     */
    public String toString()
    {
        return "this is an oval";
    }
    /**
     * Method draw will draw an oval on the JPanel frame. 
     * the method recive a parameter from the class Graphics
     *  
     * @param g A Grphics paramater
     */
    public void draw(Graphics g)
    {
        boolean f=this.getFull();
        g.setColor(this.getColor());
        if(f==true)g.fillOval(this.getX1(),this.getY1(),this.getX2(),this.getY2());
        else g.drawOval(this.getX1(),this.getY1(),this.getX2(),this.getY2());
    }
}
