public class Card
{
    protected final String face;
    private final String suit;

    public Card(String cardFace,String cardSuit)
    {
        this.face=cardFace;
        this.suit=cardSuit;
    }

    public String toString()
    {
        return face+" of "+suit;
    }

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