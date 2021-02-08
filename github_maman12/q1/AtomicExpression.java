
/**
 * Write a description of class AtomicExpression here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AtomicExpression extends Expression
{
    private double _value;
    
    public AtomicExpression(double n)
    {
       super();
       _value=n;
    }
    public double calculate(){return this.getValue();}
    public double getValue(){return this._value;}
    public void setValue(double n){this._value=n;}
    
    public String toString()
    {
        String st=Double.toString(this.getValue());
        return st;
    }
}
