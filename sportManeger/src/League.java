import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public abstract class League {
    private ArrayList<Team> mainList;
    private int numOfTeams;
    private String nameOfLeague;
    private Date date;
    public League(int numOfTeams,String nameOfLeague)
    {
        this.numOfTeams=numOfTeams;
        this.nameOfLeague=nameOfLeague;
        date= new Date();
        mainList=new ArrayList<>();

    }

    public int getNumOfTeams() {
        return numOfTeams;
    }
    public ArrayList<Team> getMainList()
    {
        return this.mainList;
    }

    public String getNameOfLeague() {
        return nameOfLeague;
    }

    public Date getDate() {
        return date;
    }

    public void setNumOfTeams(int numOfTeams) {
        this.numOfTeams = numOfTeams;
    }

    public void setNameOfLeague(String nameOfLeague) {
        this.nameOfLeague = nameOfLeague;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "League{" +
                "numOfTeams=" + numOfTeams +
                ", nameOfLeague='" + nameOfLeague + '\'' +
                ", date=" + date +
                '}';
    }
    public void generateScadual()
    {
        Random random=new Random();
        for(int i=0;i<mainList.size();i++)
        {
            Team team=mainList.get(i);
            while(team.scadual.size()<mainList.size()-2)
            {
                Team temp=mainList.get(random.nextInt(mainList.size()-1));
                if (!(team.equals(temp))&&!(team.scadual.contains(temp)))team.scadual.add(temp);
            }

        }
    }
    public void doRound()
    {
        for(Team team:mainList)
        {
            if(!(team.scadual.isEmpty()))doGame(team,team.scadual.get(0));
        }
    }
    public void doGame(Team A,Team B) {
        if (!(A.getName() == B.getName())) {
            int time = 2880;
            int diff;
            Random random = new Random();
            while (time > 0) {
                diff = A.getPoints() - B.getPoints();
                time -= random.nextInt(12) + 12;
                double positionThisTeam = Math.random() + diff + A.getRank();
                double positionOtherteam = Math.random() + B.getRank();
                double scoreSucsses = Math.random();
                double scorePoints = Math.random();
                if (scoreSucsses > 0.5) {
                    if (scorePoints > 0.7) {
                        if (positionOtherteam > positionThisTeam) A.setPoints(3);
                        else B.setPoints(3);
                    } else {
                        if (positionOtherteam > positionThisTeam)A.setPoints(2);
                        else B.setPoints(2);
                    }
                }
                if (time <= 0 && A.getPoints() == B.getPoints()) time = 300;
                //System.out.println(time+" ------>"+this.getName()+":"+this.getPoints()+"-"+Other.getName()+":"+Other.getPoints());
            }

            if (A.getPoints() > B.getPoints()) {
                A.incWins();
            } else {
                B.incWins();
            }

            //System.out.println(A.getName() + ": " + A.getPoints() + "- " + B.getName() + ": " + B.getPoints());

            A.clearPoints();
            B.clearPoints();
            B.scadual.remove(A);
            A.scadual.remove(B);
        }
    }
}
