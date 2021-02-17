
/**
 * class Priority accept any object and paste the object a priority
 * 
 * @author MatanSharon
 * @version 13.5.2020
 */
public  class Priority
{
    int _priority;//the priority variable
    Object obj;//the object variable
    
    /**
     * Priority  defulte contructor
     *
     */
    public Priority()
    {
        _priority=0;
        
    }
    /**
     * Priority Constructor that recive an object and an int and create a Priority on it
     *
     * @param o An object parameter
     * @param i A priority parameter
     */
    public Priority(Object o,int i)
    {
        _priority=i;
        obj=o;
    }
    /**
     * Method getObj return the object part of the priority
     *
     * @return The object
     */
    public Object getObj()
    {
        return this.obj;
    }
    /**
     * Method getPriority return the priority of the object represnt as an int
     *
     * @return The priority
     */
    public int getPriority()
    {
        return _priority;
    }
    /**
     * Method setPriority allow to change the priority
     *
     * @param i An int parameter
     */
    public void setPriority(int i)
    {
       _priority=i;
    }
    /**
     * Method toString return the toString method of the object
     *
     * @return the String representation of the object
     */
    public String toString()
    {
        return obj.toString();
    }
}
