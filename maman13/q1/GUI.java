import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String;
/**
 * This is the GUI for the quiz project
 * 
 * 
 * @author Matan Sharon 
 * @version 4.5.2020
 */
public class GUI extends JFrame 
{
    private JButton cmdNew,cmdFinish,cmdSubmit;//the buttons
    private JPanel panel;//the panel
    private JFrame frame;//the frame
    private MyQuiz quiz;//the quiz variable
    private int xpos,ypos;//temprory positions 
    private int score=0;//the score variable
    private JLabel label;
    
    private  String choices[];//the array to save the choices 1..4
    private  JComboBox cbChoices;//temperory comboBox

    private int givenLast=0;//var for the last answer was given
    private int lastLabel=0;//var for the last label was called
    private int[]correctAnswers;//array to save all the correct answers
    
    JLabel[]answers;//array of labels for the answers
    int[]givenAnswers;//array for the answers the user give
    /**
     * GUI Constructor initilazed all the instance varibels
     * the contructor also build the listeners and build the frame.
     * the constructor positions all the components,
     * of the quiz in the correct loction in the frame.
     *
     */
    public GUI()
    {
        //from here until the for loop at line 66 it's just simple initilizion for the instance varibales
        quiz=new MyQuiz();
        answers=new JLabel[40];
        correctAnswers=new int[10];
        givenAnswers=new int[10];
        choices=new String[]{"1","2","3","4"};
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1800, 1000);
        panel=new JPanel();
        quiz=new MyQuiz();
        cmdNew=new JButton("new quiz");
        cmdFinish=new JButton("finish?");
        panel.add(cmdNew);
        panel.add(cmdFinish);
        panel.setLayout(null);
        cmdNew.setBounds(this.getWidth()/2,this.getHeight()-120,120,40);
        cmdFinish.setBounds(this.getWidth()/2-130,this.getHeight()-120,120,40);
        this.add(cmdNew);
        this.add(cmdFinish);
        this.cmdFinish.addActionListener(new FinishButtonListner());
        this.cmdNew.addActionListener(new NewQuizButtonListner());
        //////////////////////////////////////////////////////////////////////
        xpos=30;ypos=30;
        String q,a;
        //this for loop position all the questions and answers in the correct postions
        for(int i=0;i<quiz.list.size();i++)
        {
            q=quiz.list.get(i).getQuestion();

            if(i%4==0&&i>0){xpos=30;}
            if(i>=0&&i<=3)ypos=30;
            else if(i>=4&&i<=7)ypos=330;
            else if(i>=8&&i<=10)ypos=630;

            label=new JLabel(i+1+"."+q);
            label.setBounds(xpos,ypos,450,50);
            label.setFont(new Font("Serif",Font.BOLD,25));
            panel.add(label);
            

            ypos+=30;
            for(int j=0;j<4;j++)
            {
                a=quiz.list.get(i).getAnswer(j);

                if(quiz.list.get(i).isCorrect(a))correctAnswers[i]=j+1;
                label=new JLabel(j+1+"."+a);
                answers[lastLabel]=label;
                lastLabel++;
                label.setBounds(xpos,ypos,150,50);
                label.setFont(new Font("Serif",Font.PLAIN,20));
                panel.add(label);
                
                ypos+=30;
            }
            ypos+=15;
            cbChoices=new JComboBox<String>(choices);
            cbChoices.setBounds(xpos,ypos,100,40);
            cbChoices.addActionListener(new comboBoxListner());
            panel.add(cbChoices);
            xpos+=450;
        }
        //////////////////////////////////////////////////////////////////////

        this.add(panel);

        this.setVisible(true);
    }
    /*
     * listener for the comboBox
     */
    private class comboBoxListner implements ActionListener
    {
        public void actionPerformed(ActionEvent e)throws ArrayIndexOutOfBoundsException
        {
            cbChoices=(JComboBox)e.getSource();

            int value=cbChoices.getSelectedIndex()+1;
            if(givenLast<10)//if number of answers is over 10 the listner will ignore
            {
                givenAnswers[givenLast]=value;
                givenLast++;
            }
        }
    }
    /*
     * FinishButtonListner is the listener for the Finish button
     * the listener compare the answers that was given from the user to the correct answers
     * finnaly rise a notice for the final score of the exam.
     */
    private class FinishButtonListner implements ActionListener
    {
        public void actionPerformed(ActionEvent e) throws ArrayIndexOutOfBoundsException
        {

            int correct=0;
            for(int i=0;i<correctAnswers.length;i++)
            {
                if(correctAnswers[i]==givenAnswers[i])correct++;
            }

            score=correct*10;
            JOptionPane.showMessageDialog( frame,"Your score is "+score+"!!!");
            int c=0,w=0;
            for(int i=0;i<10;i++)
            {
                w=givenAnswers[i];
                c=correctAnswers[i];
                
                if((i*4+w-1)>=0&&i*4+w-1<40)answers[i*4+w-1].setForeground(Color.red);
                
                if((i*4+c-1)>=0&&(i*4+c-1)<40)answers[i*4+c-1].setForeground(Color.green);

            }

        }
    }
    
    /*
     * NewQuizButtonListner simple create a new quiz and close the old one.
     * 
     */
    private class NewQuizButtonListner implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

            GUI g=new GUI(); 
            dispose();
        }
    }
}
