import java.awt.*;
/**
 * class MyLine represent a line
 * 
 * @author Matan Sharon 
 * @version 22.4.2020
 */
public class MyLine extends MyShape
{
    /**
     * MyLine Constructor will create a line object
     *
     * @param x1 A parameter for the top left corrner
     * @param y1 A parameter for the top left corrner
     * @param x2 A parameter for the width
     * @param y2 A parameter for the height
     * @param color A parameter for the color
     */
    public MyLine(int x1,int y1,int x2,int y2,Color color)
    {
        super(x1,y1,x2,y2,color);
        
    }
    
    /**
     * Method toString is a String represntion of the line
     *
     * @return an indicating that this is a line object
     */
    public String toString()
    {
        return "this is a line";
    }
    /**
     * Method draw will draw a line on the JPanel frame. 
     * the method recive a parameter from the class Graphics
     *
     * @param g A Grphics paramater
     */
    public void draw(Graphics g)
    {
        g.setColor(this.getColor());
        g.drawLine(this.getX1(),this.getY1(),this.getX2(),this.getY2());
    }
}
