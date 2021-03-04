import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class chooseTeam extends JFrame  {
    JFrame frame;
    //String league;
    //JPanel mainPanel;
    //JLabel atl,bos,bro,buc,bul,cav,cha,cli,dal,den,det,gsw,ind,jaz,lak,mem,mai,min,ny,no,okc,orl,phil,por,roc,sac;
    //JLabel spur,pho,tor,wiz;
    //ArrayList<JLabel>labelArrayList;
    private   Team yourTeam;
    NBA nba;


    public chooseTeam(String s) {
        frame=this;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setVisible(true);
        mouseListener mouseListener = new mouseListener();
        this.addMouseListener(mouseListener);

        if (s.equals("nba")) {
            this.createNbaLeague();


        }
        if (s.equals("eng")) {
            System.out.println("England");
        }
        if (s.equals("isr")) {
            System.out.println("Israel");
        }
        if (s.equals("spa")) {
            System.out.println("Spain");
        }
    }

    public void createNbaLeague() {
        nba= new NBA();

        JPanel nbaPanel = new JPanel();
        nbaPanel.setLayout(new GridLayout(6, 5));
            for(int i=0;i<nba.getMainList().size();i++)
            {
                Team t =nba.getMainList().get(i);
                nbaPanel.add(t.getLabel());
            }

        this.add(nbaPanel);





    }

    private class mouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {

            int i=Integer.parseInt(JOptionPane.showInputDialog(null,"choose your team"))-1;
            yourTeam=nba.getMainList().get(i);
            frame.dispose();
            LeagueGui leagueGui = new LeagueGui(nba, yourTeam);
        }
    }


}
  /*
        *
            if (e.getSource() == buc) yourTeam = nba.getMainList().get(0);
            else if (e.getSource() == lak) yourTeam = nba.getMainList().get(1);
            else if (e.getSource() == tor) yourTeam = nba.getMainList().get(2);
            else if (e.getSource() == cli) yourTeam = nba.getMainList().get(3);
            else if (e.getSource() == bos) yourTeam = nba.getMainList().get(4);
            else if (e.getSource() == den) yourTeam = nba.getMainList().get(5);
            else if (e.getSource() == jaz) yourTeam = nba.getMainList().get(6);
            else if (e.getSource() == mai) yourTeam = nba.getMainList().get(7);
            else if (e.getSource() == roc) yourTeam = nba.getMainList().get(8);
            else if (e.getSource() == okc) yourTeam = nba.getMainList().get(9);
            else if (e.getSource() == phil) yourTeam = nba.getMainList().get(10);
            else if (e.getSource() == dal) yourTeam = nba.getMainList().get(11);
            else if (e.getSource() == mem) yourTeam = nba.getMainList().get(12);
            else if (e.getSource() == bro) yourTeam = nba.getMainList().get(13);
            else if (e.getSource() == bro) yourTeam = nba.getMainList().get(14);
            else if (e.getSource() == orl) yourTeam = nba.getMainList().get(15);
            else if (e.getSource() == por) yourTeam = nba.getMainList().get(16);
            else if (e.getSource() == no) yourTeam = nba.getMainList().get(17);
            else if (e.getSource() == sac) yourTeam = nba.getMainList().get(18);
            else if (e.getSource() == spur) yourTeam = nba.getMainList().get(19);
            else if (e.getSource() == pho) yourTeam = nba.getMainList().get(20);
            else if (e.getSource() == wiz) yourTeam = nba.getMainList().get(21);
            else if (e.getSource() == cha) yourTeam = nba.getMainList().get(22);
            else if (e.getSource() == bul) yourTeam = nba.getMainList().get(23);
            else if (e.getSource() == ny) yourTeam = nba.getMainList().get(24);
            else if (e.getSource() == det) yourTeam = nba.getMainList().get(25);
            else if (e.getSource() == atl) yourTeam = nba.getMainList().get(26);
            else if (e.getSource() == min) yourTeam = nba.getMainList().get(27);
            else if (e.getSource() == cav) yourTeam = nba.getMainList().get(28);
            else if (e.getSource() == gsw) yourTeam = nba.getMainList().get(29);
        public void handelLabels()
        {
            labelArrayList.add(buc);
            labelArrayList.add(lak);
            labelArrayList.add(tor);
            labelArrayList.add(cli);
            labelArrayList.add(bos);
            labelArrayList.add(den);
            labelArrayList.add(jaz);
            labelArrayList.add(mai);
            labelArrayList.add(roc);
            labelArrayList.add(okc);
            labelArrayList.add(ind);
            labelArrayList.add(phil);
            labelArrayList.add(dal);
            labelArrayList.add(mem);
            labelArrayList.add(bro);
            labelArrayList.add(orl);
            labelArrayList.add(por);
            labelArrayList.add(no);
            labelArrayList.add(sac);
            labelArrayList.add(spur);
            labelArrayList.add(pho);
            labelArrayList.add(wiz);
            labelArrayList.add(cha);
            labelArrayList.add(bul);
            labelArrayList.add(ny);
            labelArrayList.add(det);
            labelArrayList.add(atl);
            labelArrayList.add(min);
            labelArrayList.add(cav);
            labelArrayList.add(gsw);
        }

 */
