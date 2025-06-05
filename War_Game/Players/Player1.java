// Players package
package Players;

// Card class is in the Cards package
import Cards.Card; 

// Player1 interface
interface PlayerInterface
{
    public Card[] getCardDeck();
    public void setCardDeck(int deckSize);
}

// Player1 class, where it is a subclass of the Person class
// Object class for the player/user
public class Player1 extends Person implements PlayerInterface
{
	// Declares an array of integers to represent the card deck
    private Card[] cardDeck;

    // Constructor of Player1 class
    public Player1(String playerName) 
    {
		super(playerName);
	}
    
    // Method to get the card deck
    public Card[] getCardDeck()
    {
        return cardDeck;
    }

    // Method to set the card deck
    public void setCardDeck(int deckSize)
    {
        // Instantiates the cardDeck array with the size of the deck
        cardDeck = new Card[deckSize];
        
        // Uses a for loop that iterates through half of the deck size
        // Where it instantiates a new card object and sets the card value
        for (int i = 0; i < (int)(deckSize/2); i++)
        {
            cardDeck[i] = new Card();
            cardDeck[i].setCardValue();
        }
    }

    // Shuffles the cards around
    // possibly a brain method
    public Card[] shuffleCards()
    {
        // Array of Cards
        Card[] temp = getCardDeck();
        // Temporary Card object
        Card tempCard = temp[0];
        // Loop to randomize the entire temporary array of cards
        for (int i = 0; i < temp.length; i++)
        {
            int randomIndex = (int)(Math.random() * temp.length);
            // Swap temp[i] with temp[randomIndex]
            Card swap = temp[i];
            temp[i] = temp[randomIndex];
            temp[randomIndex] = swap;

            if (temp[0] == tempCard && temp[0].getCardColor() == false)
            {
                // Swap temp[0] with another random card to further randomize
                Card anotherTempCard = temp[randomIndex];
                temp[randomIndex] = temp[0];
                temp[0] = anotherTempCard;
                // If temp[0] is still the same or it's color is still false
                // then it does another randomization and swaps temp[0]
                // with another randomized card
                if (temp[0] == tempCard || temp[0].getCardColor() == false)
                {
                    // Swap temp[0] with another random card to further randomize
                    int anotherIndex = (int)(Math.random() * temp.length);
                    anotherTempCard = temp[anotherIndex];
                    temp[anotherIndex] = temp[0];
                    temp[0] = anotherTempCard;
                }
            }
            else if (temp[0].getCardColor() == false)
            {
                // Swap temp[0] with another random card to further randomize
                int anotherIndex = (int)(Math.random() * temp.length);
                Card anotherSwap = temp[0];
                temp[0] = temp[anotherIndex];
                temp[anotherIndex] = anotherSwap;
            }
        }
        return temp;
    }
}
