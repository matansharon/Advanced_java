import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public  class Team implements Comparable<Team>{
    private final int rank;
    private int points;
    private String name;
    private  int wins;

    private String logoPath;
    private JLabel label;
    protected ArrayList <Team>scadual;


    public Team(int rank,String name,String logoPath)
    {
        wins=0;
        points=0;

        this.rank=rank;
        this.name=name;
        this.logoPath=logoPath;
        scadual=new ArrayList<>();
        String s=this.getRank()+".";
        label=new JLabel(s);
        label.setIcon( new ImageIcon(this.getLogoPath()));

    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return this.wins;
    }
    public void incWins()
    {
        this.wins+=1;
    }



    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points += points;
    }

    public int getRank() {
        return rank;
    }

    public JLabel getLabel() {
        return label;
    }



    public String getLogoPath() {
        return logoPath;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }
    public int compareTo(Team t)
    {
        if(this.wins>t.getWins())return 1;
        if(this.wins<t.getWins())return -1;
        else return 0;
    }
    public String toString()
    {
        return this.name;
    }
    public void clearPoints(){this.points=0;}
    public boolean equals(Object other)
    {
        if(!(other instanceof Team))return false;
        else if(((Team) other).getName().equals(this.getName()))return true;
        else return false;
    }




}
