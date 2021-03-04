public class NBA extends League {

    public NBA() {

        super(30, "NBA");

        generateLeague();
        generateScadual();
    }
    public void generateLeague()
    {
        Team atlanta=new Team(27,"ATL","nba_teams/atl.png");
        Team boston=new Team(5,"BOS","nba_teams/boston.png");
        Team brooklyn=new Team(15, "BRO", "nba_teams/broklyn.png");
        Team buck=new Team(1, "BUC", "nba_teams/bucks.png");
        Team bulls=new Team(24,"BUL","nba_teams/bulls.jpg");
        Team cavs=new Team(29, "CAV", "nba_teams/cavs.png");
        Team charlot=new Team(23,"CHA","nba_teams/char.png");
        Team clippers=new Team(4,"CLI","nba_teams/clip.png");
        Team dallas=new Team(13, "DAL", "nba_teams/dallas.png");
        Team denver=new Team(6, "DEN", "nba_teams/denv.png");
        Team detriot=new Team(26,"DET","nba_teams/detroit.png");
        Team gsw=new Team(30, "GSW", "nba_teams/gsw.png");
        Team indiana=new Team(11, "IND", "nba_teams/ind.png");
        Team jazz=new Team(7, "JAZ", "nba_teams/jazz.png");
        Team lakers=new Team(2, "LAK", "nba_teams/lakers.png");
        Team memphis=new Team(14,"MEM","nba_teams/memphis.png");
        Team miami=new Team(8,"MIA","nba_teams/mia.png");
        Team minnesota=new Team(28,"MIN","nba_teams/min.png");
        Team new_york=new Team(25,"NY","nba_teams/new york.png");
        Team new_or=new Team(18,"NO","nba_teams/new_o.png");
        Team okc=new Team(10,"OKC","nba_teams/okc.png");
        Team orlando=new Team(16, "ORL", "nba_teams/orla.png");
        Team philadelphia=new Team(12, "PHI", "nba_teams/phili.png");
        Team portland=new Team(17,"POR","nba_teams/por.png");
        Team rockets=new Team(9,"HOU","nba_teams/rockets.png");
        Team san_antonio=new Team(20,"SPU","nba_teams/spurs.jpg");
        Team sacramento=new Team(19,"SAC","nba_teams/sac.png");
        Team phoenix=new Team(21,"PHO","nba_teams/suns.png");
        Team toronto=new Team(3, "TOR", "nba_teams/toronto.png");
        Team washington=new Team(22,"WAS","nba_teams/wiz.png");
        this.getMainList().add(buck);this.getMainList().add(lakers);this.getMainList().add(toronto);this.getMainList().add(clippers);this.getMainList().add(boston);this.getMainList().add(denver);this.getMainList().add(jazz);this.getMainList().add(miami);this.getMainList().add(rockets);this.getMainList().add(okc);this.getMainList().add(indiana);this.getMainList().add(philadelphia);this.getMainList().add(dallas);this.getMainList().add(memphis);this.getMainList().add(brooklyn);this.getMainList().add(orlando);this.getMainList().add(portland);this.getMainList().add(new_or);this.getMainList().add(sacramento);this.getMainList().add(san_antonio);this.getMainList().add(phoenix);this.getMainList().add(washington);this.getMainList().add(charlot);this.getMainList().add(bulls);this.getMainList().add(new_york);this.getMainList().add(detriot);this.getMainList().add(atlanta);this.getMainList().add(minnesota);this.getMainList().add(cavs);this.getMainList().add(gsw);

    }
}