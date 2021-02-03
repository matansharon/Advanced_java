import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.String;
/**
 * Write a description of class GameManeger here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameManeger extends JPanel
{

    private JButton cmdYes ,cmdNo,cmdStart;
    private DeckOfCards deck;
    private int playerSum=0,dealerSum=0,playerNumOfCards=0,dealerNumOfCards=0;
    private Card []playerHand;Card[]dealerHand;
    private int y,y2;
    boolean startFlag=false,noFlag=false;
    private String messege,name="player",introMessege;
    public GameManeger()
    {
        JFrame frame = new JFrame("Black Jack");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        deck=new DeckOfCards();
        deck.shuffle();
        playerHand=new Card[5];
        dealerHand=new Card[5];
        cmdYes=new JButton("Yes");
        cmdNo=new JButton("No");
        cmdStart=new JButton("Start");
        this.cmdStart.addActionListener(new StartButtonListner());
        this.cmdYes.addActionListener(new yesButtonListner());
        this.cmdNo.addActionListener(new noButtonListner());
        this.add(cmdStart);
        this.add(cmdYes);
        this.add(cmdNo);
        frame.add(this);
        frame.setVisible(true);
        name=JOptionPane.showInputDialog("what is your name?");
        introMessege="welcome to Black Jack "+name+"!";
        introMessege+="\n1.to start the game press the 'start' button";
        introMessege+="\n2.to get another card press the 'yes' button";
        introMessege+="\n3.to end your turn and pass it to the dealer press the 'no' button";
        introMessege+="\n4.to start another game press the 'start button'";
        JOptionPane.showMessageDialog(null,introMessege);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        y=110;
        y2=110;
        String psum=Integer.toString(playerSum);
        String dsum=Integer.toString(dealerSum);
        g.setFont(new Font("Serif",Font.BOLD,35));
        g.drawString(name+" Hand",200,100);
        g.drawString("Dealer Hand",600,100);
        g.setFont(new Font("Serif",Font.PLAIN,27));

        for(int i=0;i<5;i++)
        {
            if(playerHand[i]!=null){y+=50;g.drawString(playerHand[i].toString(),200,y);}
            if(dealerHand[i]!=null){y2+=50;g.drawString(dealerHand[i].toString(),600,y2);}
        }
        g.drawString("the player sum is: "+psum,200,y+50);
        g.drawString("the dealer sum is: "+dsum,600,y2+50);
        if(messege!=null)
        {
            g.setFont(new Font("Serif",Font.BOLD,30));
            g.drawString(messege,200,500);
        }
    }

    private class StartButtonListner implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            deck=new DeckOfCards();
            deck.shuffle();
            startFlag=true;
            noFlag=false;
            for(int i=0;i<5;i++){playerHand[i]=null;dealerHand[i]=null;}
            Card a=deck.dealCard();
            Card b=deck.dealCard();
            dealerSum=0;dealerNumOfCards=0;messege=null;
            playerSum=a.getValue()+b.getValue();
            playerNumOfCards=2;
            playerHand[0]=a;
            playerHand[1]=b;
            if(playerSum==21)messege="you've got Black Jack!you win!!!";
            repaint();
        }
    }
    private class yesButtonListner implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(startFlag==true&&noFlag==false)
            {
                if(playerNumOfCards<5&&playerSum<21)
                {
                    Card a=deck.dealCard();
                    playerSum+=a.getValue();
                    playerHand[playerNumOfCards]=a;
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
        public void actionPerformed(ActionEvent e)
        {
            if(startFlag==true)
            {
                Card a;
                noFlag=true;
                if(playerSum<21)
                {
                    while(dealerSum<16)
                    {
                        a=deck.dealCard();
                        dealerSum+=a.getValue();
                        dealerHand[dealerNumOfCards]=a;
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
