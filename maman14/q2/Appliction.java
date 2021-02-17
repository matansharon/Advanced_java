import java.util.*;
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.time.*;
/**
 *  class Appliction is the user inteface for this question
 * 
 * @author Matan Sharon 
 * @version 13.5.2020
 */
public class Appliction extends JFrame 
{
    protected LocalDate date;//the instace date for each meeting
    protected int year,month;
    protected static Diary diary=new Diary();
    private JLabel lblyear,lblmonth;//instance labels
    private JButton cmdChooseYear,cmdChooseMonth,cmdDate,cmdPrint,cmdNext,cmdPrev;//the buttons
    
    private JFrame frame;
    private JPanel panel;
    int xpos=100,ypos=200;//first initialize positions
    /**
     * Appliction defualt Constructor
     * the constructor initialize the LocalDate to be 1.1.20
     * and then call the other constructor that recive a year and a month
     */
    public Appliction()
    {
        date=LocalDate.of(2020,1,1);//just a start point for the calendar
        Appliction p=new Appliction(date.getYear(),date.getMonthValue());
    }

    /**
     * Appliction Constructor to initialize all the instance variables
     * the constuctor also handel the buttons and the listeners
     *
     * @param y A parameter
     * @param m A parameter
     */
    public Appliction(int y,int m)
    {
        year=y;month=m;
        frame=new JFrame("Calender");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        panel=new JPanel();
        cmdChooseYear=new JButton("change year");
        cmdChooseMonth=new JButton("change Month");
        cmdPrint=new JButton("print");
        cmdNext=new JButton("next>>");
        cmdPrev=new JButton("<<prev");
        this.cmdPrint.addActionListener(new PrintListner());
        this.cmdChooseYear.addActionListener(new ChooseYearListner());
        this.cmdChooseMonth.addActionListener(new ChooseMonthListner());
        this.cmdNext.addActionListener(new NextListner());
        this.cmdPrev.addActionListener(new PrevListner());
        panel.add(cmdChooseYear);
        panel.add(cmdChooseMonth);
        panel.add(cmdPrint);
        panel.add(cmdNext);
        panel.add(cmdPrev);
        buildMonth();
        frame.add(panel);
        panel.setLayout(null);
        String st;
        Font myFont= new Font("Courier", Font.BOLD,20);
        st=Integer.toString(year);
        lblyear=new JLabel(st);
        st=intToMonth(month);

        lblmonth=new JLabel(st);
        lblyear.setFont(new Font("David", Font.BOLD, 20));
        lblmonth.setFont(new Font("David", Font.BOLD, 20));
        panel.add(lblyear);
        panel.add(lblmonth);
        panel.add(lblmonth);
        lblyear.setBounds(frame.getWidth()/2-85,60,120,30);
        lblmonth.setBounds(frame.getWidth()/2+75,60,120,30);
        cmdChooseYear.setBounds(frame.getWidth()/2-200,20,120,30);
        cmdChooseMonth.setBounds(frame.getWidth()/2-70,20,120,30);
        cmdPrint.setBounds(frame.getWidth()/2+60,20,120,30);
        cmdPrev.setBounds(frame.getWidth()/2-330,20,120,30);
        cmdNext.setBounds(frame.getWidth()/2+190,20,120,30);
        frame.add(panel);
        frame.setVisible(true);
    }

    /**
     * Method intToMonth convert an to a month as a String
     *
     * @param an int parameter represent a month
     * @return the String represntion of the month
     */
    public String intToMonth(int a)
    {
        if(a==1)return "Januray";
        else if(a==2)return "February";
        else if(a==3)return "March";
        else if(a==4)return "April";
        else if(a==5)return "May";
        else if(a==6)return "June";
        else if(a==7)return "July";
        else if(a==8)return "August";
        else if(a==9)return "September";
        else if(a==10)return "October";
        else if(a==11)return "November";
        else if(a==12)return "December";
        else return "";
    }

    /**
     * Method buildMonth bulding the wanted month on the frame.
     * the method uses the instance varibles of the month and year and start
     * to run the for loop and create buttons and the listeners, and after
     * locate the buttons in the correct postion in the frame
     *
     */
    public void buildMonth()
    {
        int i=0,k=0;
        date=LocalDate.of(year,month,1);
        String st;
        for(int j=0;date.getMonthValue()==month;j++)
        {

            if(date.getDayOfWeek().name()=="SUNDAY"){k=0;i++;}
            else if(date.getDayOfWeek().name()=="MONDAY"){k=1;}
            else if(date.getDayOfWeek().name()=="TUESDAY"){k=2;}
            else if(date.getDayOfWeek().name()=="WEDNESDAY"){k=3;}
            else if(date.getDayOfWeek().name()=="THURSDAY"){k=4;}
            else if(date.getDayOfWeek().name()=="FRIDAY"){k=5;}
            else if(date.getDayOfWeek().name()=="SATURDAY"){k=6;}
            st=String.valueOf(date.getDayOfMonth());
            cmdDate=new JButton(st);
            cmdDate.setBounds(xpos+k*110,ypos+i*50,100,50);
            this.cmdDate.addActionListener(new DayListner());
            panel.add(cmdDate);
            date = date.plusDays(1);
        }

    }

    /*
     * ChooseYearListner change the year instance variable and the call to the appliction
     * class again and close the old frame
     */
    private class ChooseYearListner implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String y = JOptionPane.showInputDialog("enter a year");
            year=Integer.valueOf(y);

            frame.dispose();
            Appliction p=new Appliction(year,month);
        }
    }
    /*
     * ChooseMonthListner  change the month instance variable and the call to the appliction
     * class again and close the old frame
     */
    private class ChooseMonthListner implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String m = JOptionPane.showInputDialog("enter a month");
            month=Integer.valueOf(m);
            if(month<13&&month>0)
            {
                frame.dispose();
                Appliction p=new Appliction(year,month);
            }
        }
    }
    /*
     * DayListner class is responsable to create a new meeting
     * the listener popup inputdialog and wait for the contant of the meeting
     * then create a new meeting and add it to the diary
     */
    private class  DayListner implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String message = JOptionPane.showInputDialog("please enter meeting deatils?");
            String d=((JButton)e.getSource()).getText();
            int day=Integer.parseInt(d);
            LocalDate date1 =LocalDate.of(year,month,day);
            diary.add1(date1,message);
        } 
    }
    /*
     * PrintListner class simply call to the diary print method
     */
    private class  PrintListner implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            diary.print();
        }
    }
    /*
     * NextListner class is just a shortcut i made to simply move to the next month
     */
    private class  NextListner implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            month++;
            if(month>12){month=1;year++;}
            frame.dispose();
            Appliction p=new Appliction(year,month);
        }
    }
    /*
     * PrevListner class is just a shortcut i made to simply move to the previos month
     */
    private class  PrevListner implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            month--;
            if(month<1){month=12;year--;}
            frame.dispose();
            Appliction p=new Appliction(year,month);

        }
    }
}

