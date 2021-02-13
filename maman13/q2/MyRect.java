import java.awt.*;
/**
 * class MyRect represent a rectangle, this class extends MyBoundedShape 
 * as recangle can be full or empty
 * 
 * @author Matan Sharon 
 * @version 22.4.2020
 */
public class MyRect extends MyBoundedShape
{
    /**
     * MyRect Constructor  will create an rectangle object
     *
     * @param x1 A parameter for the top left corrner
     * @param y1 A parameter for the top left corrner
     * @param x2 A parameter for the width
     * @param y2 A parameter for the height
     * @param color A parameter for the color
     * @param full A parameter to decide if the rectangle is full or empty
     */
    public MyRect(int x1,int y1,int x2,int y2,Color color,boolean full)
    {
        super(x1,y1,x2,y2,color,full);
    }
     /**
     * Method toString is a String represntion of the rectangle
     *
     * @return an indicating that this is a rectangle object
     */
    public String toString()
    {
        return "this is a rect";
    }
    /**
     * Method draw will draw a recangle on the JPanel frame. 
     * the method recive a parameter from the class Graphics
     *  
     * @param g A Grphics paramater
     */
    public void draw(Graphics g)
    {
        boolean f=this.getFull();
        g.setColor(this.getColor());
        if(f==true)g.fillRect(this.getX1(),this.getY1(),this.getX2(),this.getY2());
        else g.drawRect(this.getX1(),this.getY1(),this.getX2(),this.getY2());
    }
}
