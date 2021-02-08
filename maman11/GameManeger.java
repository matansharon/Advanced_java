import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.String;
import java.util.ArrayList;
/**
 * GameManeger class is the calss the responsable for the gui, and to active the whole program
 * 
 * @author Matan Sharon
 * @version 1.0
 * @since 31.3.2020
 */
public class GameManeger extends JPanel
{
    //instance variables
    private JButton cmdYes ,cmdNo,cmdStart;//the buttons
    private DeckOfCards deck;//a singal deck for each hand
    //4 ints to hold the sum of the player and the dealer.and for the number of cards
    private int playerSum=0,dealerSum=0,playerNumOfCards=0,dealerNumOfCards=0;
    //the 2 arrays to save the cards that what drawn for the player and for the dealer
    private ArrayList<Card>playerHand=new ArrayList<Card>();
    private ArrayList<Card>dealerHand=new ArrayList<Card>();
    private int y,y2;//these 2 int is to print on the screen the card's hight.y if for the player coloum,y2 is for the dealer coloum is
    boolean startFlag=false,noFlag=false;//these 2 boolean simply prevent to active the program at incorrect order(explain ahead))
    private String messege,name="player",introMessege;//(explain ahead)
    /**
     * GameManeger Constructor to Initialize all the instance variabels
     * the Constructor also build the frame and add all the components and listeners
     *
     */
    public GameManeger()
    {
        //these 4 lines are basicly deafualt line to create a frame
        JFrame frame = new JFrame("Black Jack");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        //these lines Initializing all the instance variabels and add them to the frame.
        deck=new DeckOfCards();
        deck.shuffle();
        cmdYes=new JButton("Yes");
        cmdNo=new JButton("No");
        cmdStart=new JButton("Start");
        //activate the listners
        this.cmdStart.addActionListener(new StartButtonListner());
        this.cmdYes.addActionListener(new yesButtonListner());
        this.cmdNo.addActionListener(new noButtonListner());
        this.add(cmdStart);
        this.add(cmdYes);
        this.add(cmdNo);
        frame.add(this);
        frame.setVisible(true);
        name=JOptionPane.showInputDialog("what is your name?");//this is for a welcome message
        //all thse lines is for the intro message
        introMessege="welcome to Black Jack "+name+"!";
        introMessege+="\n1.to start the game press the 'start' button";
        introMessege+="\n2.to get another card press the 'yes' button";
        introMessege+="\n3.to end your turn and pass it to the dealer press the 'no' button";
        introMessege+="\n4.to start another game press the 'start button'";
        JOptionPane.showMessageDialog(null,introMessege);
    }

    /**
     * Method paintComponent is the method that print and draw to the frame
     *
     * @param g A parameter
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);//clear the screen
        y=110;//the hight from the player components
        y2=110;//the hight from the dealer components
        String psum=Integer.toString(playerSum);//convert an int to a String
        String dsum=Integer.toString(dealerSum);//convert an int to a String
        g.setFont(new Font("Serif",Font.BOLD,35));
        g.drawString(name+" Hand",200,100);
        g.drawString("Dealer Hand",600,100);
        g.setFont(new Font("Serif",Font.PLAIN,27));

        for(int i=0;i<playerHand.size();i++)//for loop to draw the player hand
        {
            if(playerHand.get(i)!=null){y+=50;g.drawString(playerHand.get(i).toString(),200,y);}
        }
        for(int i=0;i<dealerHand.size();i++)//for loop to draw the player hand
        {
            if(dealerHand.get(i)!=null){y2+=50;g.drawString(dealerHand.get(i).toString(),600,y2);}
        }
        g.drawString("the player sum is: "+psum,200,y+50);
        g.drawString("the dealer sum is: "+dsum,600,y2+50);
        if(messege!=null)//the message will display after the game is over. the message will notify who won
        {
            g.setFont(new Font("Serif",Font.BOLD,30));
            g.drawString(messege,200,500);
        }
    }

    private class StartButtonListner implements ActionListener
    {
        /**
         * Method actionPerformed is for the start game button
         *
         * @param e A is an ActionEvent
         */
        public void actionPerformed(ActionEvent e)
        {
            startFlag=true;//notify that the game has started
            deck=new DeckOfCards();
            deck.shuffle();
            dealerSum=0;dealerNumOfCards=0;messege=null;
            noFlag=false;
            playerHand.clear();dealerHand.clear();//clear the arrays of the player and the dealr to start a new onr
            //the player recive automatically 2 cards
            Card a=deck.dealCard();//
            Card b=deck.dealCard();
            playerSum=a.getValue()+b.getValue();
            playerNumOfCards=2;
            playerHand.add(a);
            playerHand.add(b);
            if(playerSum==21)messege="you've got Black Jack!you win!!!";
            repaint();
        }
    }
    private class yesButtonListner implements ActionListener
    {
        /**
         * Method actionPerformed is for the yes button
         * the yes button draw another card if the player wnats one
         * @param e A is an ActionEvent
         */
        public void actionPerformed(ActionEvent e)
        {
            if(startFlag==true&&noFlag==false)//a conditions that will make sure the yes button will not performed ar in correct order
            {
                if(playerSum<21)
                {
                    Card a=deck.dealCard();
                    playerSum+=a.getValue();
                    playerHand.add(a);
                    playerNumOfCards++;

                }
                if(playerSum>21)messege="your sum is over 21. you lose!!!!";
                if(playerSum==21)messege="you've got Black Jack!you win!!!";
                repaint();
            }
        }
    }
    private class noButtonListner implements ActionListener
    {

        /**
         * Method actionPerformed is for the no button
         * no button is responsable if the player wants to end his turn. and pass it to the dealer
         * @param e A is an ActionEvent
         */
        public void actionPerformed(ActionEvent e)
        {
            if(startFlag==true)//a conditions that will make sure the no button will not performed ar in correct order
            {
                Card a;
                noFlag=true;
                if(playerSum<21)
                {
                    while(dealerSum<16)//the dealer will continue to draw cards while the sum is under 16
                    {
                        a=deck.dealCard();
                        dealerSum+=a.getValue();
                        dealerHand.add(a);
                        dealerNumOfCards++;
                        repaint();
                    }
                    if(dealerSum>21)messege="dealer sum is over 21. you win!!!!";
                    else if(dealerSum>playerSum)messege="dealer score is higher then your's.you lose!";
                    else if(playerSum>dealerSum)messege="your score is higher then the dealer.you win!"; 
                    else messege="your score and the dealer score are equal. this is a draw!";
                    repaint();
                }
            }
        }
    }
}
