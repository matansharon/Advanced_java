import java.security.SecureRandom;
/*
 * The class deckOfCards is a class that represent a real deck of cards(without the 2 jokers)
 * 
 * 
 * @author Matan Sharon
 * @version 1.0
 * @since 31.3.2020
 */
public class DeckOfCards
{
    //instance variabels
   private Card[]deck;
   private int currentCard;//for the value of a temporary Card
   private static final int NUMBER_OF_CARDS=52;//the size of a deck
   private static final SecureRandom randomNumbers= new SecureRandom();//random to shuffle the deck
   
   /**
    * DeckOfCards Constructor initialize the 2 arrays.
    * the first array of Faces(2,3,4,...10,jack,queen,king,ace)
    * the second array of suits(hearts,dimonds...)
    * and then with a for loop  that initialize the deckOfCards.
    */
   public DeckOfCards()
   {
       String []faces={"Ace","Deuce","Three","Four","Five","Six",
                        "Seven","Eight","Nine","Ten","Jack","Queen","King"};
       String []suits={"Hearts","Diamonds","Clubs","Spades"};
       
       deck=new Card[NUMBER_OF_CARDS];
       currentCard=0;//represent the top Card of the deck
       for(int count=0;count<deck.length;count++)
       {
          deck[count]=new Card(faces[count%13],suits[count/13]);
       }
   }
   
   /**
    * Method shuffle simply shuffle the deck
    *
    */
   public void shuffle()
   {
      currentCard=0;
      for(int first=0;first<deck.length;first++)
      {
         int second=randomNumbers.nextInt(NUMBER_OF_CARDS);//generate a random number between 0-52
         //the next 3 lines is a simply switch algorithm
         Card temp=deck[first];
         deck[first]=deck[second];
         deck[second]=temp;
      }
   }
   
   /**
    * Method dealCard return a pointer of the top Card from the deck
    *
    * @return Card return the top Card
    */
   public Card dealCard()
   {
     if(currentCard<deck.length)return deck[currentCard++];
     else 
        return null;
   }
   
   
}