import java.util.*;
/**
 * class Tester is simply the main method
 * this class run a lot of example on the Priority Queue
 * 
 * @author Matan Sharon 
 * @version 13.5.2020
 */
public class Tester
{
    public static void main(String args[])
    {
        Random rand=new Random();//random number to use for the tests
        PriorityQueue pqlist=new PriorityQueue(10);//initilized of the priority queue
        //demonstrate Primitive variables and then adding them to the priority queue
        Integer i=new Integer(5);
        Double d=new Double(3.3);
        String s=new String("sns");
        Character c=new Character('e');
        pqlist.add1(i,3);
        pqlist.add1(d,5);
        pqlist.add1(s,1);
        pqlist.add1(c,3);
        pqlist.add1(3,3);
        pqlist.add1("spp",2);
        pqlist.add1(10.1,4);
        pqlist.add1('e',1);
        pqlist.print();
        Object y=pqlist.poll();//demonstrate the poll function
        pqlist.print();
        System.out.println("this is y toString(): "+y.toString());
        System.out.println(pqlist.contains(c));//demonstrate the contian function
        System.out.println(pqlist.remove(d));//demonstrate the remove function
        pqlist.print();
        Iterator it=pqlist.iterator();//demonstrate the iterator function
        while(it.hasNext()){it.next();it.remove();}
        pqlist.print();
        ////demonstrate the Customer class and some functions
        Customer c1=new Customer(2828292,"ori","i like big butts");
        Customer c2=new Customer(5736278,"koby","fly bird");
        Customer c3=new Customer(8347803,"lila","somthing just like this");
        Customer c4=new Customer(2282827,"motca","pain");
        Customer c5=new Customer(7819911,"dor","snow");
        Customer c6=new Customer(8828821,"paz","under the bridge");
        pqlist.add1(c1,1);
        pqlist.add1(c2,6);
        pqlist.add1(c3,2);
        pqlist.add1(c4,7);
        pqlist.add1(c5,1);
        pqlist.add1(c6,4);
        pqlist.print();
        pqlist.poll();
        pqlist.print();
        pqlist.remove(c4);
        pqlist.print();
        System.out.println(pqlist.contains(c3));
        System.out.println(pqlist.get(2).equals(i));
        System.out.println(pqlist.get(2).toString());
        pqlist.print();
        Customer p=(Customer)pqlist.get(2).getObj();
        int pazId=p.getId();
        System.out.printf("%s %d %b\n",p.toString(),pazId,p.equals(c6));
        p.setId(i);
        System.out.printf("%s %d %b\n",p.toString(),p.getId(),p.equals(c6));
        for(int u=0;u<4;u++)//for loop to add some char's to the queue
        {
            Integer temp=rand.nextInt(30);
            char a=(char)(rand.nextInt(26)+'a');
            pqlist.add1(temp,rand.nextInt(10));
            pqlist.add1(a,rand.nextInt(10));
        }
        pqlist.print();
        int u=0;
        while(u!=pqlist.size())//loop to remove all char's from the list
        {
            if(pqlist.get(u).getObj() instanceof Character)
            {
                pqlist.remove(u);
                u-=1;
            }
            u++;
        }
        Double d8=new Double(rand.nextDouble());
        pqlist.add1(d8,5);
        pqlist.print();
        while(pqlist.size()>0)pqlist.poll();//clear the queue
        pqlist.print();
    }
}

