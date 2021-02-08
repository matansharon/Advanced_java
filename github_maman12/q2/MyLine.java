    import java.lang.Math;
/**
 * Write a description of class Myline here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyLine extends MyShape
{
    /**
     * MyLine Constructor empty Constructor create an unvisable line
     *
     */
    public MyLine()
    {
        super();
    }
    /**
     * MyLine Constructor recive all the needed parameters 
     * and initilaized all the instance varivabels 
     *
     * @param x1 A parameter for the first point
     * @param y1 A parameter for the first point
     * @param x2 A parameter for the second point
     * @param y2 A parameter for the second point
     * @param r A parameter for the red component
     * @param g A parameter for the green component
     * @param b A parameter for the blue comonent
     */
    public MyLine(int x1,int y1,int x2,int y2,int r,int g,int b)
    {
        super(x1,y1,x2,y2,r,g,b);
    }
    /**
     * MyLine Constructor is a copy constuctor
     *
     * @param m A parameter
     */
    public MyLine(MyLine m)
    {
        this.setX1(m.getX1());
        this.setY1(m.getY1());
        this.setX2(m.getX2());
        this.setY2(m.getY2());
        this.setX2(m.getX2());
        this.setR(m.getR());
        this.setG(m.getG());
        this.setB(m.getB());
    }
    
    /**
     * Method length return the length of the line 
     * the calcultion useing the Pitagors triangle to calculate the length
     *
     * @return the length of the line
     */
    public int length()
    {
        int a,b,c;
        a=this.getY1()-this.getY2();
        b=this.getX1()-this.getX2();
        a=(int)Math.pow(a,2);
        b=(int)Math.pow(b,2);
        c=a+b;
        c=(int)Math.sqrt(c);
        return c;
    }

    /**
     * Method equals override the MyShape equls and check if the other line is
     * actualy a line and if both lines have the same length
     *
     * @param m A parameter of MyShape
     * @return if the both are lines and both are the same length
     */
    public boolean equals(MyShape m)
    {
        if(!(m instanceof MyLine))return false;
        if(m instanceof MyLine)
        {
            if(((MyLine)m).length()==this.length())return true;
        }
        return false;
    }

    /**
     * Method toString return the String represntion of a line 
     * and indicating: this is MyLine class and the length 
     *
     * @return the MyLine represntion as a String
     */
    public String toString()
    {
        String st="this is MyLine "+Integer.toString(this.length());
        return st;
    }
}
