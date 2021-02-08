
/**
 * Abstract class CompoundExpression.
 * this class is in the middle of the hirrercy.
 * the SubtractionExpression and AdditionExpression extends this class
 * 
 * @author Matan Sharon
 * @version 7.4.2020
 */
public abstract class CompoundExpression extends Expression
{
    protected Expression _ex1,_ex2;
    /**
     * CompoundExpression Constructor get 2 Expression paramaters and check's
     * if the are an instance of Expression
     *
     * @param e1 Expression parameter
     * @param e2 Expression parameter
     */
    public CompoundExpression(Expression e1,Expression e2)
    {
        super();
        if(e1 instanceof AtomicExpression)_ex1 = new AtomicExpression( ((AtomicExpression)e1).getValue()); 
        else _ex1=e1;
        if(e2 instanceof AtomicExpression)_ex2 = new AtomicExpression( ((AtomicExpression)e2).getValue()); 
        else _ex2=e2;
    }
    public abstract String toString();
}
