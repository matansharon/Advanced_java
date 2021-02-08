import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.String;
/**
 * TempYear class is a class to display the average temperature for the year's 2015-2019
 * 
 * @author Matan Sharon
 * @version 1.0
 * @since 31.3.2020
 */
public class tempYear extends JPanel
{
    //instance variables
    private JLabel lblChooseYear,lblNum;//labels
    private JButton cmdChooseYear;//buttons
    private int x,y,h,w,minTemp,maxTemp,year=0;//temporary variabels to save for the printing to the screen
    private String avg,month;
    private int []data=new int[12];//this is the array that will be cpied to the 2015-2019 arrays to be printed
    //these next array is the data for each year
    private int []data_2015=new int[]{100,200,80,180,240,300,100,50,400,200,150,330};
    private int []data_2016=new int[]{80,170,300,210,310,120,150,90,380,200,100,180};
    private int []data_2017=new int[]{300,200,100,50,150,400,200,250,55,170,280,160};
    private int []data_2018=new int[]{150,120,180,80,250,270,330,440,200,300,70,60};
    private int []data_2019=new int[]{200,240,100,230,140,190,300,330,70,40,150,120};
    private final int yearMonth=12;
    /**
     * tempYear Constructor theat will create the frame and initialized all the instance variabels
     *
     */
    public tempYear()
    {
        JFrame frame = new JFrame("temp year");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700); 
        lblChooseYear=new JLabel("This Graph is-"+year);
        add(lblChooseYear);
        cmdChooseYear=new JButton("change year");
        this.cmdChooseYear.addActionListener(new ButtonListener());
        add(cmdChooseYear);
        frame.add(this);
        frame.setVisible(true);
    }
    
    /**
     * Method paintComponent is the method that display the appliction and draw it to the frame.
     *
     * @param g A parameter from the Graphics library
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //the next couple lines decided witch year is to be printed
        if(year==2015)copyArray(data,data_2015);
        else if(year==2016)copyArray(data,data_2016);
        else if(year==2017)copyArray(data,data_2017);
        else if(year==2018)copyArray(data,data_2018);
        else if(year==2019)copyArray(data,data_2019);
        else clearScreen();//if the input is not from 2015 to 2019
        findMinMax(data);//function to find the min month and the maximum month and paint them in a proper color
        g.setFont(new Font("Serif",Font.BOLD,18));
        g.setColor(Color.GRAY);
        x=-70;w=70;//the starting coloum position
        for(int i=0;i<yearMonth;i++)
        {
            h=data[i];//temporary variables to save a month deatil
            x+=80;
            avg=Integer.toString(h/10);//convert a String to an int
            month=Integer.toString(i+1);////convert a String to an int
            if(h==minTemp)g.setColor(Color.BLUE);//if the current coloum is the minimum month
            if(h==maxTemp)g.setColor(Color.RED);//if the current coloum is the maximum month
            g.fillRect(x,530-h,w,h);
            g.drawString(month,x+20,550);
            g.drawString(avg,x+20,520-h);
            if(h==minTemp)g.setColor(Color.GRAY);//if it was true at line 70 then it return back to gray color
            if(h==maxTemp)g.setColor(Color.GRAY);//if it was true at line 71 then it return back to gray color
        }
    }
    
    /**
     * Method findMinMax finds the minimum and the maximum monthes. 
     * and the the correct instance varibels mintemp,and maxtemp
     *
     * @param arr A parameter is the current year to check
     */
    public void findMinMax(int []arr)
    {
        int min=10000;
        int max=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<min)min=arr[i];
            if(arr[i]>max)max=arr[i];
        }
        minTemp=min;
        maxTemp=max;
    }

    /**
     * Method copyArray is the method to copy a specific year to the defualt array
     *
     * @param arr1 A parameter the destnion array
     * @param arr2 A parameter the source array
     */
    public void copyArray(int []arr1,int []arr2)
    {
        for(int i=0;i<yearMonth;i++)
        {
            arr1[i]=arr2[i];
        }
    }
    
    /**
     * Method clearScreen clear the destntion array
     *
     */
    public void clearScreen()
    {
        for(int i=0;i<yearMonth;i++)data[i]=0;
    }
    /*
     * class ButtonListener represnt for the buttons activity
     * 
     */
    private class ButtonListener implements ActionListener
    {
        
        public void actionPerformed(ActionEvent e)
        {
            String str= JOptionPane.showInputDialog("what year would you like to see? ");//the input parameter to pass
            year=Integer.parseInt(str);//convert a String to int
            repaint();//call the paintComponent again
            
            
        }
    } 
    
}
