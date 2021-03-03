import java.util.*;
//import java.lang.Exception;

/**
 * Write a description of class MyRep here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyRep implements Repository
{
    private ArrayList<Integer>numbers;
    private int maxThreads,waitings=0;
    private boolean done=false;
    public MyRep(ArrayList<Integer> a,int n)throws NullPointerException

    {
        maxThreads=n;
        Random rand=new Random();
        numbers=new ArrayList<>();
        for(Integer x:a)numbers.add(x);
        
        System.out.println(numbers);
    }
    public synchronized int[] removeCouple()
    {
        while(numbers.size()<=1&&done==false)
        {
            if(waitings==maxThreads-1)
            {
                notifyAll();
                done=true;
            }
            else {
                waitings++;
                try{wait();}
                catch(InterruptedException e){}
                waitings--;
            }
        }
        if(done==true)return null;
        int []res=new int[2];
        res[0]= numbers.remove(0);
        res[1]=numbers.remove(0);
        return res;
    }
    public synchronized void insert(int n)
    {
        numbers.add(n);
        notifyAll();
    }
    public synchronized int getSum()
    {
       while(!done){
           try{wait();}
           catch(InterruptedException e){}
        }
       return numbers.get(0);
       
    }
}
