import java.util.*;
import java.sql.Timestamp;  
import java.time.Instant; 
/**
 * Write a description of class Tester2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tester2
{
    public static void main(String []args)
    {
        
        ArrayList<Integer>a=new ArrayList<>();
        Random rand=new Random();
        for(int i=0;i<100;i++)a.add(rand.nextInt(100));
        MyRep r=new MyRep(a,10);
        for(int i=0;i<10;i++)
        {
            (new Compute(r)).start();
        }
        
        System.out.println(r.getSum());
        
    }
}
