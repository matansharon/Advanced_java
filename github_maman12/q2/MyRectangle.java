
/**
 *  class MyRectangle represnt an rectangle object.
 *  the rectangle can be full or not
 *  this class extends the MyBoundedShape clsss
 * 
 * @author Matan Sharon
 * @version 7.4.2020
 */
public class MyRectangle extends MyBoundedShape
{
    /**
     * MyRectangle defualt Constructor
     *
     */
    public MyRectangle(){super();}

    /**
     * MyRectangle Constructor
     *
     * @param x1 A parameter for the first point
     * @param y1 A parameter for the first point
     * @param x2 A parameter for the second point
     * @param y2 A parameter for the second point
     * @param r A parameter for the red component
     * @param g A parameter for the green component
     * @param b A parameter for the blue comonent
     */
    public MyRectangle(int x1,int y1,int x2,int y2,int r,int g,int b,boolean f)
    {
        super(x1,y1,x2,y2,r,g,b,f);

    }

    /**
     *  MyRectangle copy Constructor
     *
     * @param m other rectangle
     */
    public MyRectangle(MyRectangle m)
    {
        this.setX1(m.getX1());
        this.setY1(m.getY1());
        this.setX2(m.getX2());
        this.setY2(m.getY2());
        this.setX2(m.getX2());
        this.setR(m.getR());
        this.setG(m.getG());
        this.setB(m.getB());
        this.setFull(m.getFull());
    }

    /**
     * Method volume return the volume of the rectangle
     *
     * @return the volume as a double
     */
    public double volume()
    {
        int w,l;
        w=this.getX1()-this.getX2();
        l=this.getY1()-this.getY2();
        if(w<0)w*=-1;
        if(l<0)l*=-1;
        return (w+l)*2;
    }

    /**
     * Method toString represnt the rectangle as a String
     *
     * @return String as a represntion of the rectangle
     */
    public String toString()
    {

        String st="this is MyRectangle "+Double.toString(this.volume())+" "+Boolean.toString(this.getFull());
        return st;
    }
}
