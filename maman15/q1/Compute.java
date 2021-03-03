
/**
 * Write a description of class Compute here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Compute extends Thread
{
    private Repository rep;
    
    public Compute(Repository r)
    {
        rep=r;
    }
    
    public void run()
    {
        int[] couple;
        couple=rep.removeCouple();
        while(couple!=null)
        {
            rep.insert(couple[0]+couple[1]);
            couple=rep.removeCouple();
        }
    }
}
