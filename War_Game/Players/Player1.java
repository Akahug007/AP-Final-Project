// Players package
package Players;

// Card class is in the Cards package
import Cards.Card; 

// Player1 class, where it is a subclass of the Person class
// Object class for the player/user
public class Player1 extends Person
{
    // Constructor of Player1 class
    public Player1(String playerName, int theBalance, boolean player) 
    {
		super(playerName, theBalance, player);
	}
    // Constructor of Player1 class
    public Player1(String playerName, boolean player) 
    {
		super(playerName, player);
	}

    // Shuffles the cards around
    // possibly a brain method
    public Card[] shuffleRedCards(Card[] test)
    {
        // Array of Cards
        Card[] temp = test;
        
        // Temporary Card object
        Card tempCard = temp[0];
        
        // Conditional to check if first letter of the first element's 
        // name from temp contains the letter B
        if (temp[0].getCardColor().equalsIgnoreCase("B"))
        {
            
        }
        // Checking if temp is null or entirely contains nulls
        else if (temp == null || checkArrayContainAllNull(temp) || checkArrayContainAllNull(temp, null))
        {
            temp = null;
        }
        // If they are not valid, then else, an entire algorithm happens
        else
        {
            // Initializes a boolean variable called fixed
            boolean fixed = false;
            // If the card at index 0 is false then
            // a shuffling algorithm starts
            if (temp[0].getCardColor().substring(0,1).equalsIgnoreCase("R")) 
            {
                // Initializes an int variable called index
                int index = 1;
                // While index is less than the length of temp or fixed is true
                // then a conditional is used
                while ((index < temp.length && !fixed) || temp[0].getCardColor().equalsIgnoreCase("B"))
                {
                    // Conditional that checks if the selected element's name contains the letter R
                    if (temp[index].getCardColor().substring(0,1).equalsIgnoreCase("B")) 
                    {
                        // Found a suitable card, swap it with temp[0]
                        Card tempSwap = tempCard;
                        tempCard = temp[index];
                        temp[index] = tempSwap;
                        // Fixed gets assigned with true
                        fixed = true;
                    }
                    index++;
                }
            }
        }
        return temp;
    }
    // Method to check if a card array entirely contains null values only
    public boolean checkArrayContainAllNull(Card[] temp)
    {
        // Array of Cards
        Card[] aCardArray = temp;
        boolean output = true;
        int index = 0;
        while (output)
        {
            if (aCardArray[index] != null)
            {
                output = false;
            }
            index++;
        }
        return output;
    }
    // Overloaded method
    public boolean checkArrayContainAllNull(Card[] temp, Object obj)
    {
        // Array of Cards
        Card[] aCardArray = temp;
        boolean output = true;
        int index = 0;
        while (output)
        {
            if (aCardArray[index] != obj)
            {
                output = false;
            }
            index++;
        }
        return output;
    }
}
