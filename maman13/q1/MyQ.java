import java.util.*;
/**
 * MyQ represnt a single question and the answers.
 * every question has 4 answers.
 * this class also contian a shuffle method to show the answers randomly at the gui
 * @author Matan Sharon
 * @version 4.5.2020
 */
public class MyQ
{
    private String question,correct;
    private String []answer;
    
    /**
     * MyQ Constructor build a single question and 4 answers attached
     *
     * @param q A parameter for the question
     * @param a1 A parameter for the first answer
     * @param a2 A parameter for the second answer
     * @param a3 A parameter for the third answer
     * @param a4 A parameter for the fourth answer
     */
    public MyQ(String q,String a1,String a2,String a3,String a4)
    {
        question=q;
        answer=new String[4];
        answer[0]=a1;answer[1]=a2;answer[2]=a3;answer[3]=a4;
        correct=a1;//the correct answer will always start at the first one
        this.shuffle();//and after that will shuffel
    }
    /**
     * Method getQuestion return the question from this class
     *
     * @return The question as a String
     */
    public String getQuestion()
    {
        return question;
    }
    /**
     * Method getAnswer return a specific answer
     *
     * @param i A parameter for the answer to get
     * @return the answer as a String
     */
    public String getAnswer(int i)
    {
        if(i<0||i>3)return "";
        else return answer[i];
    }
    /**
     * Method getCorrect return the correct answer
     *
     * @return the answer as a String
     */
    public String getCorrect()
    {
        return correct;
    }
    /**
     * Method isCorrect checks if a given String is equal to the correct answer
     *
     * @param s an answer to be checked
     * @return true if both Strings are equal, false otherwise
     */
    public boolean isCorrect(String s)
    {
        if(s==correct)return true;
        else return false;
    }
    /**
     * Method print simply print the question and the answers
     *
     */
    public void print()
    {
        System.out.println(question);
        for(int i=0;i<4;i++)
        {
            System.out.println(answer[i]);
        }
    }
    /**
     * Method shuffle randomly shuffle the 4 answers
     *
     */
    public void shuffle()
    {
        Random rand=new Random();
        String temp;
        for(int i=0;i<4;i++)
        {
            int q=rand.nextInt(4);
            temp=answer[q];
            answer[q]=answer[i];
            answer[i]=temp;
        }
    }
}
