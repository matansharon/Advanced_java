import java.util.*;
import java.io.*;
/**
 *  class MyQuiz represnt a Quiz for all of it's data.
 *  the class read line by line from a text file and build the backend data 
 *  for the gui inteface
 * 
 * @author Matan Sharon 
 * @version 4.5.2020
 */
public class MyQuiz
{
    protected ArrayList<MyQ> list=new ArrayList<>();//list of all the quistions
    String q,a1,a2,a3,a4;//instance strings to hold the quistions and answers
    /**
     * MyQuiz Constructor try to open the extern text file.
     * if the opening succeces. the while loop will go until there is an input
     * to read.
     *  MyQ represnt a single question
     */
    public MyQuiz()
    {
        try
        {
            Scanner scan=new Scanner(new FileReader("Exam.txt"));
            while(scan.hasNext())
            {
                q=scan.nextLine();
                a1=scan.nextLine();
                a2=scan.nextLine();
                a3=scan.nextLine();
                a4=scan.nextLine();
                MyQ question=new MyQ(q,a1,a2,a3,a4);
                list.add(question);
            }
        }
        catch (FileNotFoundException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    /**
     * Method print simply print to the screen the data from the text file
     *
     */
    public void print()
    {
        for(int i=0;i<list.size();i++)
        {
            MyQ t=list.get(i);
            list.get(i).print();
        }
    }
    /**
     * Method doQuiz run the backend quiz data.
     * the method run over the given answers and check them if they correct.
     *  finnaly the program will notify and popup a message to the final score
     */
    public void doQuiz()
    {
        Scanner sc=new Scanner(System.in);
        String temp="";//temperory String variable to save a specific answer
        int answer;
        boolean bol=false;//an instance variable to indicate that the answer is correct
        int numOfCorrect=0;
        for(int i=0;i<list.size();i++)
        {
            MyQ q=list.get(i);
            q.print();
            answer=sc.nextInt();
            if(answer==1)temp=q.getAnswer(0);
            else if(answer==2)temp=q.getAnswer(1);
            else if(answer==3)temp=q.getAnswer(2);
            else if(answer==4)temp=q.getAnswer(3);
            if(temp==q.getCorrect())bol=true;
            else bol=false;
            if(bol==true)numOfCorrect++;
            
        }
        double res=(double)numOfCorrect/(double)list.size()*100;
        int res2=(int)res;
        System.out.println("your score is: "+res2+"!!!");
    }
}

