import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class chooseLeague extends JFrame  {
    JLabel welcome,spa_lbl,eng_lbl,isr_lbl,nba_lbl ;
    JPanel mainPanel;
    JFrame frame;
   public  chooseLeague()
    {
        frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,300);
        frame.setVisible(true);
        mainPanel=new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JPanel imagePanel=new JPanel(new GridLayout(1,4));
        mouseListener m=new mouseListener();

        welcome=new JLabel("                                  welcome to Sport manager game! \n please choose your league you wnat to play...");
        spa_lbl=new JLabel(new ImageIcon("league_icons/spanish_league.png"));
        eng_lbl=new JLabel(new ImageIcon("league_icons/preimer_league.png"));
        isr_lbl=new JLabel(new ImageIcon("league_icons/iseral_football_league.jpg"));
        nba_lbl=new JLabel(new ImageIcon("league_icons/nba_league.jfif"));
        nba_lbl.addMouseListener(m);
        eng_lbl.addMouseListener(m);
        isr_lbl.addMouseListener(m);
        spa_lbl.addMouseListener(m);
        imagePanel.add(spa_lbl);
        imagePanel.add(eng_lbl);
        imagePanel.add(isr_lbl);
        imagePanel.add(nba_lbl);
        mainPanel.add(imagePanel,BorderLayout.CENTER);
        mainPanel.add(welcome,BorderLayout.NORTH);
        frame.add(mainPanel);
    }
    private class mouseListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource()==nba_lbl)
            {
                frame.dispose();
                chooseTeam chooseTeam = new chooseTeam("nba");
            }
            if(e.getSource()==spa_lbl){
                frame.dispose();
                chooseTeam chooseTeam = new chooseTeam("spa");

            }
            if(e.getSource()==eng_lbl)
            {

                frame.dispose();
                chooseTeam chooseTeam = new chooseTeam("eng");
            }
            if(e.getSource()==isr_lbl)
            {

                frame.dispose();
                chooseTeam chooseTeam = new chooseTeam("isr");
            }
        }
    }


}
