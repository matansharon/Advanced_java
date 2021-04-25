import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MathBoard extends JFrame{


private final int SIZE = 5;
private int num1=0, num2=0, sum=0, counter=0;
private JPanel bcontainer;
private MyButton[][] barray = new MyButton[SIZE ][SIZE ];
private JButton finish = new JButton("finish");

public MathBoard(){

	super("MathBoard");
bcontainer = new JPanel();
bcontainer.setLayout(new GridLayout(5,5));

Handler handler = new Handler();
String bname = "";
for(int i=0; i<SIZE ; i++)
	for(int j=0; j<SIZE ; j++)
		{
		bname  = ""+((i)*SIZE + (j+1) );
		barray[i][j] = new MyButton(bname  );
		barray[i][j].addActionListener( handler  );
		bcontainer.add(  barray[i][j] );
		}
finish.addActionListener( 
	new ActionListener(){
	public void actionPerformed(ActionEvent e){
	
	System.out.println("you got " + counter + " right! \nend of program");}}
);
	
	this.setLayout(new BorderLayout());
	this.add(bcontainer, BorderLayout.CENTER);
	this.add(finish ,BorderLayout.SOUTH);
	
	setSize(500,500);
	setVisible(true);
	
	}//end of constructor

private class Handler implements ActionListener{
	public void actionPerformed(ActionEvent e){
		if(num1==0)
			num1 = ((MyButton) e.getSource()).getIndex();
		else if(num2==0)
			num2 = ((MyButton) e.getSource()).getIndex();
		else if(sum==0)
			{
			sum =  ((MyButton) e.getSource()).getIndex();
			if(num1+num2 == sum)
				{
				counter++;
				num1--;num2--;sum--;
				barray[num1/SIZE][num1%SIZE].setEnabled(false);
				barray[num2/SIZE][num2%SIZE].setEnabled(false);
				barray[sum/SIZE][sum%SIZE].setEnabled(false);
				num1=0;num2=0;sum=0;
				}
				else  {
				System.out.println("Wrong sum! try again...");
				num1=0;num2=0;sum=0;
				}
			}
		}
	}//end of listener


}
