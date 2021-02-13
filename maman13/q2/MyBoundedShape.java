import java.awt.*;
/**
 * MyBoundedShape is the class that common al the shapes in the project that can
 * be full or empty
 * 
 * @author Matan Sharon 
 * @version 22.4.2020
 */
public abstract class MyBoundedShape extends MyShape
{
    private boolean _full;//an boolean to decide if the shape will be full or not
    
    /**
     * MyBoundedShape Constructor calling to the MyShape contructor and send him
     * all the parameters wothout the boolean _full. the is innitited here in this class
     *
     * @param x1 A parameter for the top left corrner
     * @param y1 A parameter for the top left corrner
     * @param x2 A parameter for the width
     * @param y2 A parameter for the height
     * @param color A parameter for the color
     * @param full A parameter to decided if the shape is full or not
     */
    public MyBoundedShape(int x1,int y1,int x2,int y2,Color color,boolean full)
    {
        super(x1,y1,x2,y2,color);
        _full=full;
    }
    
    /**
     * Method getFull return the boolean _full state 
     *
     * @return _full
     */
    public boolean getFull(){return _full;}
    public abstract void draw(Graphics g);
    public abstract String toString();
}
