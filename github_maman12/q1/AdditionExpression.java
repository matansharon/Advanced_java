
/**
 * AdditionExpression extends the CompoundExpression in the tree hirerchy
 * AdditionExpression represnt's a simple a+b. and return the value.
 * 
 * @author Matan Sharon 
 * @version 7.4.2020
 */
public class AdditionExpression extends CompoundExpression
{

    /**
     * AdditionExpression Constructor
     *
     * @param e1 the first Expression parameter for the constructor
     * @param e2 the second Expression parameter for the constructor
     */
    public AdditionExpression(Expression e1,Expression e2)
    {
        super(e1,e2);
    }

    /**
     * Method calculate will calculate the 2 atomic expression addition
     *
     * @return double as the addition
     */
    public double calculate()
    {
        return _ex1.calculate()+_ex2.calculate();
    }

    /**
     * Method toString return a String represntion of the class
     *
     * @return String reprsntion
     */
    public String toString()
    {
        String st=_ex1.toString()+" + "+_ex2.toString();
        return st;
    }
}
