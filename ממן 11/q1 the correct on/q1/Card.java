/*
 * The Card class represent a singal card from a 52 deck og Cards.
 * i'v added a "getValue" method to return the number value of each card
 * 
 * @author Matan Sharon
 * @version 1.0
 * @since 31.3.2020
 */
public class Card
{
    protected final String face;
    private final String suit;

    /**
     * Card Constructor
     *
     * @param cardFace A parameter like 2,3,4...jack,queen,king,ace
     * @param cardSuit A parameter like spades,hearts...\
     * @return Card this is return a pointer to an object of Card
     */
    public Card(String cardFace,String cardSuit)
    {
        this.face=cardFace;
        this.suit=cardSuit;
    }
    
    /**
     * Method toString simpley return a string that represnt the Card as a string
     * the String is combin from 2 Strings: 1.the "face"+2. the "suit"
     * the method does not receive any arguments
     * @return String that represnt a Card
     */
    public String toString()
    {
        return face+" of "+suit;
    }
    
    /**
     * Method getValue return the int/number value of each Card
     *
     * @return int the value of a Card
     */
    public int getValue()
    {

        if(this.face=="Deuce")return 2;
        else if(this.face=="Three")return 3;
        else if(this.face=="Four")return 4;
        else if(this.face=="Five")return 5;
        else if(this.face=="Six")return 6;
        else if(this.face=="Seven")return 7;
        else if(this.face=="Eight")return 8;
        else if(this.face=="Nine")return 9;
        else if(this.face=="Ten")return 10;
        else if(this.face=="Jack")return 10;
        else if(this.face=="Queen")return 10;
        else if(this.face=="King")return 10;
        else if(this.face=="Ace")return 11;
        else return 0;
    }
}