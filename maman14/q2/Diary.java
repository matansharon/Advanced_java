import java.util.*;
import java.time.*;
/**
 * class Diary is a represntion of meeting diary with date's and the content of the meeting 
 * 
 * @author Matan Sharon 
 * @version 13.5.2020
 */
public class Diary
{
    //the hash map to save the meetings
    protected static HashMap<LocalDate,String>list;
    /**
     * Diary defulte Constructor
     * the constructor initialize the hashMap
     *
     */
    public Diary()
    {
        list=new HashMap<LocalDate,String>();
    }

    
    /**
     * Method add1 adding a meeting to the diary
     * String s is the content of the meeting
     * @param date a LocalDate parameter
     * @param s a String parameter
     */
    public void add1(LocalDate date,String s)
    {
        list.put(date,s);
    }

    /**
     * Method print print all the meeting in the diary
     *
     */
    public void print()
    {
        
        for (LocalDate i : list.keySet())
        {
            System.out.println(i+" "+list.get(i));
        }
        
        System.out.println("----------------------------------");
    }

    /**
     * Method toString return the HashMap reoresntion as a String
     *
     * @return String represntion of the hashMap
     */
    public String toString()
    {
        return list.toString();
    }
}
