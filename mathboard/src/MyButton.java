import javax.swing.JButton;

public class MyButton extends JButton{

	private int index;
	
	public MyButton(String index){
		super(index);
		this.index = Integer.parseInt(index);
	}

	public int getIndex(){
		return index;
	}
}