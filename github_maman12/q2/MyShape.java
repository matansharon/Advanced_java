import java.awt.*; 
/**
 * Abstract class Shape is the top of the hirarchey
 * 
 * @author Matan Sharon
 * @version 7.4.2020
 */
public abstract class MyShape
{
    //the x and y corrdinate and RGB component
    private int _x1,_x2,_y1,_y2,_r,_g,_b;
    
    
    /**
     * MyShape Constructor
     *  initilazed all the instance variabels to 0
     */
    public MyShape()
    {
        _x1=_x2=_y1=_y2=_r=_g=_b=0;
        
    }
    /**
     * MyShape Constructor
     *
     * @param x1 A parameter the width loction for the first point
     * @param y1 A parameter the height loction for the first point
     * @param x2 A parameter the width loction for the second point
     * @param y2 A parameter the height loction for the second point
     * @param r A parameter the red component
     * @param g A parameter the green component
     * @param b A parameter the blue component
     */
    public MyShape(int x1,int y1,int x2,int y2,int r,int g,int b)
    {
        _x1=x1;_y1=y1;_x2=x2;_y2=y2;_r=r;_g=g;_b=b;
        
    }
    /*
     * simply geter's and seter's functions
     */
    public int getX1(){return _x1;}
    public int getX2(){return _x2;}
    public int getY1(){return _y1;}
    public int getY2(){return _y2;}
    public int getR(){return _r;}
    public int getG(){return _g;}
    public int getB(){return _b;}
    public void setX1(int a){_x1=a;}
    public void setX2(int a){_x2=a;}
    public void setY1(int a){_y1=a;}
    public void setY2(int a){_y2=a;}
    public void setR(int a){_r=a;}
    public void setG(int a){_g=a;}
    
    public void setB(int a){_b=a;}
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
    public abstract String toString();
}
