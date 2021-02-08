
/**
 * SubtractionExpression extends the CompoundExpression in the tree hirerchy
 * SubtractionExpression represnt's a simple a-b. and return the value
 * 
 * @author Matan Sharon
 * @version 7.4.2020
 */
public class SubtractionExpression extends CompoundExpression
{
    
    /**
     * SubtractionExpression Constructor
     *
     * @param e1 the first Expression parameter for the constructor
     * @param e2 the second Expression parameter for the constructor
     */
    public SubtractionExpression(Expression e1,Expression e2)
    {
        super(e1,e2);
    }
    
    /**
     * Method calculate will calculate the 2 atomic expression subscripion
     *
     * @return double as the subscription
     */
    public double calculate()
    {
        return _ex1.calculate()-_ex2.calculate();
    }
    /**
     * Method toString return a String represntion of the class
     *
     * @return String reprsntion
     */
    public String toString()
    {
        String st=_ex1.toString()+" - "+_ex2.toString();
        return st;
    }
}
