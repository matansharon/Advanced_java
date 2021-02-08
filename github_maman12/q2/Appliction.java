import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.String;
/**
 * this class is th GUI UI for Q2
 * basicly what it does, is to generate 2 shapes for each at random positions
 * with random sizes.
 * 
 * @author Matan Sharon
 * @version 7.4.2020
 */
public class Appliction extends JPanel
{
    private JButton cmdClonable,cmdNewList;
    private MyShape []list;//the array to hold the first 6 objects
    private MyShape []list2;//the array to hold the clonable 6 objects
    MyShape clonableObject;
    boolean list2Flag=false;//a boolean to indicate that the clonable button is pressed
    /**
     * Appliction default Constructor
     *
     */
    public Appliction()
    {
        JFrame frame=new JFrame("q2 appliction");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        cmdNewList=new JButton("new list");
        cmdClonable=new JButton("clonable");
        BuildList();
        this.cmdNewList.addActionListener(new NewListButtonListner());
        this.cmdClonable.addActionListener(new ClonableButtonListner());
        frame.add(this);
        this.add(cmdNewList);
        this.add(cmdClonable);
        frame.setVisible(true);
    }

    /**
     * Method paintComponent simply draw the shapes to the frame
     *
     * @param g a Graphics parameter
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int w,x,y,z,r,_g,b;
        boolean bol;
        Color c;

        for(int i=0;i<6;i++)
        {

            w=list[i].getX1();
            x=list[i].getY1();
            y=list[i].getX2();            
            z=list[i].getY1();
            r=list[i].getR();
            _g=list[i].getG();
            b=list[i].getB();

            if(list[i] instanceof MyLine)
            {
                Color color=new Color(r,_g,b);
                g.setColor(color);
                g.drawLine(w,x,y,z);

            }
            if(list[i] instanceof MyOval)
            {
                if(((MyOval)list[i]).getFull()==true)
                {
                    Color color=new Color(r,_g,b);
                    g.setColor(color);
                    g.fillOval(w,x,y,z);

                }
                else
                {
                    Color color=new Color(r,_g,b);
                    g.setColor(color);
                    g.drawOval(w,x,y,z);  
                }
            }
            if(list[i] instanceof MyRectangle)
            {
                if(((MyRectangle)list[i]).getFull()==true)
                {
                    Color color=new Color(r,_g,b);
                    g.setColor(color);
                    g.fillRect(w,x,y,z);

                }
                else
                {
                    Color color=new Color(r,_g,b);
                    g.setColor(color);
                    g.drawRect(w,x,y,z); 
                }
            }
        }
        if(list2Flag==true)
        {
            for(int i=0;i<6;i++)
            {

                w=list2[i].getX1();
                x=list2[i].getY1();
                y=list2[i].getX2();            
                z=list2[i].getY1();
                r=list2[i].getR();
                _g=list2[i].getG();
                b=list2[i].getB();

                if(list2[i] instanceof MyLine)
                {
                    Color color=new Color(r,_g,b);
                    g.setColor(color);
                    g.drawLine(w,x,y,z);

                }
                if(list2[i] instanceof MyOval)
                {
                    if(((MyOval)list2[i]).getFull()==true)
                    {
                        Color color=new Color(r,_g,b);
                        g.setColor(color);
                        g.fillOval(w,x,y,z);

                    }
                    else
                    {
                        Color color=new Color(r,_g,b);
                        g.setColor(color);
                        g.drawOval(w,x,y,z);  
                    }
                }
                if(list2[i] instanceof MyRectangle)
                {
                    if(((MyRectangle)list2[i]).getFull()==true)
                    {
                        Color color=new Color(r,_g,b);
                        g.setColor(color);
                        g.fillRect(w,x,y,z);

                    }
                    else
                    {
                        Color color=new Color(r,_g,b);
                        g.setColor(color);
                        g.drawRect(w,x,y,z); 
                    }
                }
            }
        }
    }

    /**
     * Method BuildList generate some random numbers and initilayzed the first
     * list.
     * the method also set the shapes color to be red
     *
     */
    public void BuildList()
    {
        Random rand=new Random();
        list=new MyShape[6];
        int width=getWidth();
        int height=getHeight();
        int w,x,y,z,r,g,b;r=255;g=b=0;
        boolean bol=true;
        for(int i=0;i<6;i+=3)
        {
            w=rand.nextInt(500);x=rand.nextInt(500);y=rand.nextInt(100);z=rand.nextInt(100);
            list[i]=new MyLine(w,x,y,z,r,g,b);
            w=rand.nextInt(500);x=rand.nextInt(500);y=rand.nextInt(100);z=rand.nextInt(100);
            list[i+1]=new MyOval(w,x,y,z,r,g,b,bol);
            w=rand.nextInt(500);x=rand.nextInt(500);y=rand.nextInt(100);z=rand.nextInt(100);
            list[i+2]=new MyRectangle(w,x,y,z,r,g,b,bol);
        }
    }
    private class NewListButtonListner implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            BuildList();
            list2Flag=false;
            repaint();
        }
    }
    private class ClonableButtonListner implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            list2=new MyShape [6];
            list2Flag=true;
            for(int i=0;i<6;i++)
            {
                if(list[i] instanceof MyLine)
                {
                    list2[i]=new MyLine((MyLine)list[i]);

                }
                if(list[i] instanceof MyOval)
                {
                    list2[i]=new MyOval((MyOval)list[i]);
                    ((MyOval)list2[i]).setFull(false);
                }
                if(list[i] instanceof MyRectangle)
                {
                    list2[i]=new MyRectangle((MyRectangle)list[i]);
                    ((MyRectangle)list2[i]).setFull(false);
                }
                list2[i].setX1(list2[i].getX1()+10);
                list2[i].setY1(list2[i].getY1()+10);
                list2[i].setR(0);
                list2[i].setG(255);
                
            }
            repaint();
        }
    }
}

