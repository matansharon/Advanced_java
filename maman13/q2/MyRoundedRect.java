import java.awt.*;
/**
 * class MyRect represent a rectangle with rounded corners, this class extends MyBoundedShape 
 * as the recangle can be full or empty
 * 
 * @author Matan Sharon 
 * @version 22.4.2020
 */
public class MyRoundedRect extends MyBoundedShape
{
    //the varible to set how much the corners will be rounded
    private final int SIZE=10;
    

    /**
     * MyRoundedRect Constructor  will create an rectangle object
     *
     * @param x1 A parameter for the top left corrner
     * @param y1 A parameter for the top left corrner
     * @param x2 A parameter for the width
     * @param y2 A parameter for the height
     * @param color A parameter for the color
     * @param full A parameter to decide if the rectangle is full or empty
     */
    public MyRoundedRect(int x1,int y1,int x2,int y2,Color color,boolean full)
    {
        super(x1,y1,x2,y2,color,full);
    }
     /**
     * Method toString is a String represntion of the rounded rectangle
     *
     * @return an indicating that this is a rounded rectangle object
     */
    public String toString()
    {
        return "this is a roundedRect";
    }
     /**
     * Method draw will draw a rounded recangle on the JPanel frame. 
     * the method recive a parameter from the class Graphics
     *  
     * @param g A Grphics paramater
     */
    public void draw(Graphics g)
    {
        boolean f=this.getFull();
        g.setColor(this.getColor());
        if(f==true)g.fillRoundRect(this.getX1(),this.getY1(),
        this.getX2(),this.getY2(),SIZE,SIZE);
        else g.drawRoundRect(this.getX1(),this.getY1(),
        this.getX2(),this.getY2(),SIZE,SIZE);
    }
}
