import java.awt.*; 
/**
 * Abstract class Shape is the top of the hirarchey
 * 
 * @author Matan Sharon
 * @version 22.4.2020
 */
public abstract class MyShape
{
    private int _x1,_x2,_y1,_y2;//corrdinate for the shape
    private Color _color;//the color of the shpae
    
    /**
     * MyShape Constructor create an abstract shape to be override later
     * by a more specific shape
     *
     * @param x1 A parameter for the top left corrner
     * @param y1 A parameter for the top left corrner
     * @param x2 A parameter for the width
     * @param y2 A parameter for the height
     * @param color A parameter for the color
     */
    public MyShape(int x1,int y1,int x2,int y2,Color color)
    {
        _x1=x1;_y1=y1;_x2=x2;_y2=y2;
        _color=color;
        
    }
    //simply geter's and setr's for the instance variabels
    public int getX1(){return _x1;}
    public int getX2(){return _x2;}
    public int getY1(){return _y1;}
    public int getY2(){return _y2;}
    public Color getColor(){return _color;}
    public void setX1(int x){_x1=x;}
    public void setY1(int y){_y1=y;}
    public void setX2(int x){_x2=x;}
    public void setY2(int y){_y2=y;}
    /**
     * Method equals check if 2 shapes pointing to the same adress memory
     *
     * @param m A Shape
     * @return true if the 2 Shapes pointing to the same loction, false otherwise
     */
    public  boolean  equals(MyShape m)
    {
        if(this==m)return true;
        else return false;
    }
    
    public abstract void draw(Graphics g);
    public abstract String toString();

}
