
/**
 * Abstract class MyBoundedShape - will be extends by two other classes.
 * this class represnt the shapes that can be filled
 * @author Matan Sharon
 * @version 7.4.2020
 */
public abstract class MyBoundedShape extends MyShape
{
    private boolean full;//a parameter to decide if the shape will be fill or not
    /**
     * MyBoundedShape Constructor default constructor
     *
     */
    public MyBoundedShape()
    {
        super();
        full=false;
    }
    /**
     * MyBoundedShape Constructor
     *
     * @param x1 A parameter for the first point
     * @param y1 A parameter for the first point
     * @param x2 A parameter for the second point
     * @param y2 A parameter for the second point
     * @param r A parameter for the red component
     * @param g A parameter for the green component
     * @param b A parameter for the blue comonent
     */
    public MyBoundedShape(int x1,int y1,int x2,int y2,int r,int g,int b,boolean f)
    {
        super(x1,y1,x2,y2,r,g,b);
        full=f;
    }
    public abstract double volume();//will be override and explain in the extends classs
    public abstract String toString();//will be override and explain in the extends classs
    public boolean getFull(){return this.full;}//return if the shape is full or not
    public void setFull(boolean f){this.full=f;}//set the full parameter
    /**
     * Method equals check's if two shapes are the same.
     * the function checks if the 2 shapes are from the same instance and have the same volume
     * @param m a MyBoundedShape
     * @return true if both are the same shapes and same value.false otherwise
     */
    public boolean equals(MyBoundedShape m)
    {
        if(!(m instanceof MyBoundedShape))return false;
        if(m instanceof MyBoundedShape)
        {
            if(m.volume()==this.volume())return true;
        }
        return false;
    }
}
