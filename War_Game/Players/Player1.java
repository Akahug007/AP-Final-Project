// Players package
package Players;

// Card class is in the Cards package
import Cards.Card;

//  Imports the ArrayList library
import java.util.ArrayList;

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

    // Returns the boolean variable isPlayer
    @Override
    public boolean getPlayer()
    {
        return true;
    }

    // Shuffles the cards around
    // possibly a brain method
    public ArrayList<Card> shuffleRedCards(ArrayList<Card> test)
    {
        // ArrayList of Cards
        ArrayList<Card> temp = test;

        // Temporary Card object
        Card tempCard = temp.get(0);

        // Conditional to check if first letter of the first element's 
        // color from temp contains the letter B
        if (temp.get(0).getCardColor().equalsIgnoreCase("B"))
        {

        }
        // Checking if temp is null or entirely contains nulls
        else if (temp == null || temp.isEmpty() || checkArrayContainAllNull(temp.toArray(new Card[0])) || checkArrayContainAllNull(temp.toArray(new Card[0]), null))
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
            if (temp.get(0).getCardColor().substring(0,1).equalsIgnoreCase("R")) 
            {
                // Initializes an int variable called index
                int index = 1;
                // While index is less than the size of temp or fixed is true
                // then a conditional is used
                while ((index < temp.size() && !fixed) || temp.get(0).getCardColor().equalsIgnoreCase("B"))
                {
                    // Conditional that checks if the selected element's color contains the letter B
                    if (temp.get(index).getCardColor().substring(0,1).equalsIgnoreCase("B")) 
                    {
                        // Found a suitable card, swap it with temp.get(0)
                        Card tempSwap = tempCard;
                        tempCard = temp.get(index);
                        temp.set(index, tempSwap);
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
