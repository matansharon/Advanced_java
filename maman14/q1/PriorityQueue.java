import java.util.*;
/**
 *  class PriorityQueue represent a queue ordered by a priority
 * 
 * @author Matan Sharon 
 * @version 13.5.2020
 */
public class PriorityQueue
{
    protected LinkedList<Priority> list;//the queue to hold th objects
    private int _priority;//the max priority variable

    /**
     * PriorityQueue Constructor Initializing the instance variables
     *
     * @param a An int parameter
     */
    public PriorityQueue(int a)
    {
        list= new LinkedList<Priority>(); 
        _priority=a;
    }

    /**
     * Method add1 add an object to the queue.
     * add1 recive an object and the object priority and add it to the queue at the correct loction
     *
     * @param o an object parameter
     * @param p a priority parameter
     */
    public void add1(Object o,int p)
    {
        Priority t=new Priority(o,p);
        
        int length=list.size();
        for(int i=0;i<length;i++)
        {
            if(list.get(i).getPriority()>t.getPriority())
            {
                list.add(i,t);
                return;
            }
        }
        list.add(t);

    }
    /**
     * Method print simply print the current queue with a chosen signs
     *
     */
    public void print()
    {
        for(int i=0;i<list.size();i++)
        {

            System.out.printf("%s---> ",list.get(i).toString()); 
        }
        System.out.println("|||");
    }

    /**
     * Method size return the size of the queue
     *
     * @return the queue size
     */
    public int size()
    {
        return list.size();
    }

    /**
     * Method get recive a loction and return the object at the loction
     *
     * @param i the loction in the queue
     * @return the object
     */
    public Priority get(int i)
    {
        return list.get(i);
    }

    /**
     * Method poll return the first object in the queue and pool it out of the queue
     *
     * @return The object
     */
    public Object poll()
    {
        return list.poll();
    }

    /**
     * Method contains recive an object and checks if the object is in the queue
     * the method compare adress
     *
     * @param o An object parameter
     * @return true if the object is in the queue and false otherwise.
     */
    public boolean contains(Object o)
    {
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).obj.equals(o)==true)return true;
        }
        return false;
    }
    
    /**
     * Method remove recive a loction and remove the object at the loction
     *
     * @param o An object parameter
     * @return return ture if the remove was success and false otherwise
     */
    public boolean remove(Object o)
    {
       for(int i=0;i<list.size();i++)
        {
            if(list.get(i).getObj().equals(o)==true){list.remove(i);return true;}
        }
        return false;
    }
    /**
     * Method remove recive a loction in the queue and remove the object at the loction
     *
     * @param i a loction
     */
    public void remove(int i)
    {
        list.remove(i);
        
    }
    /**
     * Method iterator create an Iterator object to run over the queue
     *
     * @return Iterator object
     */
    public Iterator iterator()
    {
        Iterator itr=list.iterator();
        return itr;
    }
}
