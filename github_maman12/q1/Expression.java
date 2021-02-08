
/**
 * the top class in the Expression hierarchy
 * @Matan Sharon
 * @1.2v since 7.4.2020
 */
public abstract class Expression
{
    
    /**
     * Method calculate will be override by the son's and grand son's of Expression
     *
     * @return double as a resulte of the calcultion
     */
    public abstract double calculate();

    /**
     * Method equals comperse beatween 2 expressions
     *
     * @param j An Expression parameter
     * @return booleane if both Expression are indicating to the same adress
     */
    public boolean equals(Expression j)
    {
        if(j==null)return false;
        
        return this.calculate()==j.calculate();
    }
    
    /**
     * Method toString return the Expression as a String represntion
     * Method toString will be override by the son's and grand son's of Expression
     *
     * @return the String represntion
     */
    public abstract String toString();
}
