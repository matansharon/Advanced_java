import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class LeagueGui  extends JFrame implements ActionListener {
    League league;
    Team yourTeam;
    JPanel tablePanel,matchPanel,btnPanel;
    JLabel tableLabel;
    ArrayList<JLabel>labelArrayList;
    JButton doRound;




    public LeagueGui(League l,Team yourTeam)
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        if(l instanceof NBA) league=new NBA();
        this.yourTeam=yourTeam;
        tablePanel=new JPanel(new GridLayout(30,1));
        btnPanel=new JPanel();
        matchPanel=new JPanel();
        matchPanel.setLayout(new GridLayout(1,4));
        handelMatchPanel();
        doRound = new JButton("do round");
        doRound.addActionListener(this);

        btnPanel.add(doRound);

        this.add(btnPanel,BorderLayout.SOUTH);
        labelArrayList=new ArrayList<>();
        this.yourTeam=yourTeam;
        tableLabel =new JLabel();
        CreateTable();




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==doRound)
        {
                league.doRound();
                matchPanel.removeAll();
                handelMatchPanel();
                tablePanel.removeAll();
                Collections.sort(league.getMainList());
                CreateTable();
            }




    }

    public void CreateTable()
    {
        for(int i=league.getMainList().size()-1;i>=0;i--)
        {
            Team team=league.getMainList().get(i);

            JLabel label = new JLabel(team.getName()+" "+team.getWins());
            //labelArrayList.add(label);
            tablePanel.add(label);
        }
        this.add(tablePanel,BorderLayout.WEST);
    }
    public void handelMatchPanel()
    {
        JLabel yourLabel=new JLabel();
        yourLabel.setIcon(new ImageIcon(yourTeam.getLogoPath()));
        JLabel emptyLabel=new JLabel();
        matchPanel.add(emptyLabel);
        matchPanel.add(yourLabel);

        JLabel vs=new JLabel("VS");
        matchPanel.add(vs);

        JLabel opponentLabel=new JLabel();
        opponentLabel.setIcon(new ImageIcon(yourTeam.scadual.get(0).getLogoPath()));
        matchPanel.add(opponentLabel);


        this.add(matchPanel,BorderLayout.CENTER);
    }

}

