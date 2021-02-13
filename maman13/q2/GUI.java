import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * this GUI class is the User inteface
 * in this class i'v decided to seperate for 2 diffrent frames.
 * the first one is panel of buttons
 * and the second frame is for the drawing
 * a note: i know i can use in the listeners implementions with e.getSource().
 * but i choose to create seperate class for each listener because it's more clean code to me
 * so if this is a mistake please forgive me.
 * @author Matan Sharon
 * @version 22.4.2020
 */
public class GUI extends JPanel
{
    private JFrame frame,frame2;//the 2 frames. frame will contain the buttons and frame2 will be the drawing panel
    private JComboBox cbColor,cbFull,cbShapes;//all the ComboBox buttons
    JButton cmdUndo,cmdClear,cmdExit;//regular buttons
    private JPanel panel;
    private String []colors;//the array for the colors choices
    private String []shapes;//the array for the shpaes choices
    private  String []fullOrEmpty;//the array to decide if the shape will be full or empty
    ArrayList<MyShape>list;//list of shapes to hold the previos shapes
    //from here on is the variables to initilazed the currunt shape
    private Color _color=Color.black;
    private int _x1,_x2,_y1,_y2,_lastindex;
    private final int SIZE=20;
    private boolean _full=true;
    private String _shape="line";
    

    /**
     * GUI Constructor initilaized all the instance variables,arrays,buttons and comboBoxes
     * in the constuctor i'v also connected all the buttons to their listeners
     *
     */
    public GUI()
    {
        //the next 7 lines is simple commands for the frame
        frame=new JFrame("q2 app");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 300);
        frame2=new JFrame("q2 app");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(1000,1000);
        //the next 2 lines create a jpanel and set the layout to be null
        panel=new JPanel();
        panel.setLayout(null);
        //allocate and initilazed a memory for the lists
        list=new ArrayList<>();
        colors=new String[]{"red","green","blue","black"};
        fullOrEmpty=new String[]{"full","empty"};
        shapes=new String[]{"line","rectangle","oval","roundedRectangle"};
        //initialize all the bottuns and comboBoxes
        cmdUndo=new JButton("undo");
        cmdClear=new JButton("clear");
        cmdExit=new JButton("exit");
        cbColor=new JComboBox<String>(colors);
        cbFull=new JComboBox<String>(fullOrEmpty);
        cbShapes=new JComboBox<String>(shapes);
        //connect the buttons and comboBoxes to their listeners
        cbColor.addActionListener(new colorListener());
        cbFull.addActionListener(new fullListener());
        cbShapes.addActionListener(new shapeListener());
        cmdUndo.addActionListener(new undoListener());
        cmdClear.addActionListener(new clearListener());
        cmdExit.addActionListener(new exitListener());
        //locate all the buttons and comboBoxes in the buttons frame
        cmdUndo.setBounds(frame.getWidth()/2,20,100,40);
        cmdClear.setBounds(frame.getWidth()/2-110,20,100,40);
        cbFull.setBounds(frame.getWidth()/2-220,20,100,40);
        cmdExit.setBounds(frame.getWidth()/2+110,20,100,40);
        cbColor.setBounds(frame.getWidth()/2+220,20,100,40);
        cbShapes.setBounds(frame.getWidth()/2-330,20,100,40);
        //add the buttons and comboBoxes to the panel
        panel.add(cmdUndo);
        panel.add(cmdClear);
        panel.add(cmdExit);
        panel.add(cbColor);
        panel.add(cbFull);
        panel.add(cbShapes);
        //listeners for the mouse events
        Listener lis=new Listener(); 
        this.addMouseListener(lis);
        this.addMouseMotionListener(lis);

        frame.add(panel);
        frame2.add(this);
        frame2.setVisible(true);
        frame.setVisible(true);

    }

    /**
     * Method paintComponent will start each time by cleaning the screen.
     * then it will draw all the previous shapes in the for loop.
     * and the will draw the current shape until the mouse will be realesed
     *
     * @param g A Graphics parameter
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);//clear the screen
        MyShape m;//varibles to iterate the list
        for(int i=0;i<list.size();i++)
        {
            m=list.get(i);
            if(m instanceof MyLine) m.draw(g);
            else if(m instanceof MyOval)m.draw(g);
            else if(m instanceof MyRect)m.draw(g);
            else if(m instanceof MyRoundedRect)m.draw(g);
        }
        //from here to the end of method paintComponent it will draw the current shape
        //the shape that will be drawn depends on the state of the instance varibels
        g.setColor(_color);
        if(_shape=="oval")
        {
            if(_full==true)g.fillOval(_x1,_y1,_x2,_y2);
            else g.drawOval(_x1,_y1,_x2,_y2);
        }
        if(_shape=="rectangle")
        {
            if(_full==true)g.fillRect(_x1,_y1,_x2,_y2);
            else g.drawRect(_x1,_y1,_x2,_y2);
        }
        if(_shape=="roundedRectangle")
        {
            if(_full==true)g.fillRoundRect(_x1,_y1,_x2,_y2,SIZE,SIZE);
            else g.drawRoundRect(_x1,_y1,_x2,_y2,SIZE,SIZE);
        }
        if(_shape=="line")g.drawLine(_x1,_y1,_x2,_y2);
    }
    
    private class colorListener implements ActionListener
    {
        /**
         * Method actionPerformed as this class will change the color instance variable
         * depends the state of cbColor ComboBox
         *
         * @param e A parameter of ActionEvent class
         */
        public void actionPerformed(ActionEvent e)
        {
            String st=(String)cbColor.getSelectedItem();
            if(st=="black")_color=Color.black;
            else if(st=="red")_color=Color.red;
            else if(st=="blue")_color=Color.blue;
            else _color=Color.green;
        }
    }
    private class shapeListener implements ActionListener
    {
        /**
         * Method actionPerformed as this class will change the shape instance variable
         * depends the state of cbShape ComboBox
         *
         * @param e A parameter of ActionEvent class
         */
        public void actionPerformed(ActionEvent e)
        {
            _shape=(String)cbShapes.getSelectedItem();

        }
    }
    private class exitListener implements ActionListener
    {
        /**
         * Method actionPerformed at this class will close the frames
         *
         * @param e A parameter of ActionEvent class
         */
        public void actionPerformed(ActionEvent e)
        {
            frame.dispose();
            frame2.dispose();
        }   
    }
    private class undoListener implements ActionListener
    {
        /**
         * Method actionPerformed in this class will erase the last shape
         * and will call the paintComponent again
         *
         * @param e A parameter of ActionEvent class
         */
        public void actionPerformed(ActionEvent e)
        {
            _x1=_x2=_y1=_y2=0;
            if(list.size()>0)
            {
                list.remove(_lastindex-1);
                _lastindex--;//a variable to hold the loction of the last shape
            }
            
            repaint();
        }
    }
    private class clearListener implements ActionListener
    {
        /**
         * Method actionPerformed in this class will clean the frame2 screen 
         * from all the old shapes
         *
         * @param e A parameter of ActionEvent class
         */
        public void actionPerformed(ActionEvent e)
        {
            _x1=_x2=_y1=_y2=0;
            list.clear();
            _lastindex=0;
            repaint();
        }
    }
    private class fullListener implements ActionListener
    {
        /**
         * Method actionPerformed in this class is changing the _full variable
         * depends of the cbFull ComboBox
         *
         * @param e A parameter of ActionEvent class
         */
        public void actionPerformed(ActionEvent e)
        {
            String st=(String)cbFull.getSelectedItem();
            if(st=="full")_full=true;
            if(st=="empty")_full=false;

        }
    }
    /*
     * this next classes if for all the mouse event we need in this little project
     * 
     */
    private class Listener extends MouseAdapter
    {
        /**
         * Method mousePressed indicate that the mouse was pressed and save the
         * loction the he was pressed
         *
         * @param m A parameter of MouseEvent class
         */
        public void mousePressed(MouseEvent m)
        {
            
            _x1=m.getX();
            _y1=m.getY();
            _x2=_x1;
            _y2=_y1;
            repaint();
        }

        /**
         * Method mouseDragged save the loction of the mouse was dragged to 
         *
         * @param m A parameter of MouseEvent class
         */
        public void mouseDragged(MouseEvent m)
        {
            _x2=m.getX();
            _y2=m.getY();
            repaint();
        }

        /**
         * Method mouseReleased it's a bit diffrent
         * this method will indicate that the drawing was end. 
         * and the shape need to be save at the back-end of the program.
         * this method will create a new shape depends of the state of the insatance variables
         * @param m A parameter of MouseEvent class
         */
        public void mouseReleased(MouseEvent m)
        {
            MyShape s=null;
            if(_shape=="line")s=new MyLine(_x1,_y1,_x2,_y2,_color);
            if(_shape=="oval")s=new MyOval(_x1,_y1,_x2,_y2,_color,_full);
            if(_shape=="rectangle")s=new MyRect(_x1,_y1,_x2,_y2,_color,_full);
            if(_shape=="roundedRectangle")s=new MyRoundedRect(_x1,_y1,_x2,_y2,_color,_full);
            list.add(s);//add the shape to the list
            _lastindex++;//promot the loction of the last shape
            repaint();
        }
    } 
}
