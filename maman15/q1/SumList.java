import java.util.*;
import java.sql.Timestamp;  
import java.time.Instant;
/**
 * Write a description of class SumList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SumList
{
    LinkedList<Integer>BL; 
    LinkedList<Integer>SL;
    int numOfThreads;
    int count=1;
    
    public SumList(int a,int b)
    {
         
       
        Random rand=new Random();
        BL=new LinkedList<Integer>();
        SL=new LinkedList<>();
        for(int i=0;i<a;i++)BL.add(rand.nextInt(100));
        numOfThreads=b;
        System.out.println(BL);
        run();
    }

    public void run()
    {
        boolean empty=false;
        int a=0,b=0,c;
        while(BL.size()!=1)
        {
            for(int i=0;i<numOfThreads;i++)
            {
                if(!(BL.isEmpty()))
                {
                    a=BL.poll();
                    empty=true;
                }
                else a=0;
                if(!(BL.isEmpty()))
                {
                    b=BL.poll();
                    empty=true;
                }
                else b=0;
                if(empty=true)
                {
                    c=a+b;
                    SL.add(c);
                }
                empty=false;
            }
            while(!(SL.isEmpty()))
            {
                int res=SL.poll();
                if(res!=0)BL.add(res);
            }
            System.out.println(BL);
            count++;
        }
        System.out.println("the number of rounds it took to finish: "+count);
    }
}
