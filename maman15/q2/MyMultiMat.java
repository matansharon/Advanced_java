import java.util.*;

/**
 * Write a description of class MyMat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyMultiMat 
{
    protected static  MyMat MatA,MatB;
    protected static int [][]resMat;
    private int size,row,col,total,done,count;
    private boolean buffer=false;
    private MyThread prev=null;
    private Vector<MyThread>list;

    public MyMultiMat()
    {
        Random rand=new Random();
        row=rand.nextInt(10);
        size=rand.nextInt(10);
        col=rand.nextInt(10);
        list=new Vector<>();

        MatA=new MyMat(row,size);
        MatB=new MyMat(size,col);
        total=row*col;
        done=count=0;
        MatA.print();
        System.out.println("-----------------------------");
        MatB.print();
        System.out.println("-----------------------------");
        resMat=new int[row][col];
        this.run();

    }

    public synchronized void run()
    {
        int []temp1=new int[size];
        int []temp2=new int[size];
        Random rand=new Random();
        for(int i=0;i<row;i++)
        {
            for(int k=0;k<size;k++)temp1[k]=MatA._mat[i][k];
            for(int j=0;j<col;j++)
            {
                for(int t=0;t<size;t++)temp2[t]=MatB._mat[t][j];

                if(count<total)
                {
                   count++;
                   MyThread p=new MyThread(temp1,temp2,i,j,resMat,this);
                   list.add(p);
                   p.start();
                    try{p.sleep(100);}
                   catch(InterruptedException e){}
                   //while(p.isAlive());
                }

            }

        }
        print();
    }

    public  void print()
    {
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                System.out.printf("%d ",resMat[i][j]);
            }
            System.out.println();
        }
        System.out.println("----------------------");

    }

    public void printList()
    {
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
    }

    public Vector getList(){return this.list;}

    //public boolean getBuffer(){return buffer;}

    //public void setBuffer(boolean f){this.buffer=f;}
}
