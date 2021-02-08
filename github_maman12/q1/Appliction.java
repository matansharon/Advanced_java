import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.String;
/**
 * this is the GUI class.
 * i'v decided to show the implements of this question by drawing a random list of expretions
 * instead of useing a lot of printing commands
 * 
 * @author Matan Sharon 
 * @version 7.4.2020
 */
public class Appliction extends JPanel
{
    private JButton cmdNewList,cmdDraw;//the 2 buttons
    private Expression []list;//the list to hold the expressions
    int temp1,temp2,op;//some parameters to generate random numbers
    Expression e1,e2;
    AtomicExpression at;
    AdditionExpression ad;
    SubtractionExpression su;
    boolean drawFlag=false;//check if the draw button was pushed
    public Appliction()
    {
        JFrame frame=new JFrame("q1 appliction");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        cmdNewList=new JButton("new list");
        cmdDraw=new JButton("draw");
        this.cmdDraw.addActionListener(new DrawButtonListner());
        this.cmdNewList.addActionListener(new newListButtonListner());
        frame.add(this);
        this.add(cmdNewList);
        this.add(cmdDraw);
        frame.setVisible(true);
        list=new Expression[10];
        int temp;
        //this for loop will generate 10 random numbers and will store them in a new list list
        for(int i=0;i<10;i++)
        {
            temp=new Random().nextInt(20);;
            list[i]=new AtomicExpression((double)temp);

        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int y=50;
        g.setFont(new Font("Serif",Font.BOLD,30));
        g.drawString("this is the list: ",100,50);

        g.setFont(new Font("Serif",Font.PLAIN,23));
        for(int i=0;i<10;i++)
        {
            y+=50;
            g.drawString("list["+i+"]"+"="+list[i].toString(),100,y);
        }
        if(drawFlag==true)
        {
            g.drawString("list["+temp1+"]"+"="+list[temp1].toString(),400,100);
            if(at==null)g.drawString("list["+temp2+"]"+"="+list[temp2].toString(),400,150);
            if(at!=null)g.drawString("AtomicExpression was chosen: "+at.calculate(),570,100);
            if(ad!=null)g.drawString("AdditionExpression was chosen: "+ad.calculate(),570,100);
            if(su!=null)g.drawString("SubtractionExpression was chosen: "+su.calculate(),570,100);
        }

    }

    private class newListButtonListner implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            drawFlag=false;
            list=new Expression[10];
            double temp;
            for(int i=0;i<10;i++)
            {
                temp=new Random().nextInt(20);
                list[i]=new AtomicExpression((double)temp);

            }
            repaint();
        }
    }

    private class DrawButtonListner implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            drawFlag=true;
            temp1=new Random().nextInt(10);
            temp2=new Random().nextInt(10);
            op=new Random().nextInt(3);
            e1=list[temp1];
            e2=list[temp2];
            at=null;
            ad=null;
            su=null;
            if(op==0)
            {
                ad=new AdditionExpression(e1,e2);
            }
            if(op==1)
            {
                su=new SubtractionExpression(e1,e2);
            }
            if(op==2)
            {
                at=new AtomicExpression(((AtomicExpression)e1).getValue());
            }
            repaint();
        }
    }
}
