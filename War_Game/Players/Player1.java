// Players package
package Players;

// Card class is in the Cards package
import Cards.Card;
import Main.CasinoWarGame;

//  Imports the ArrayList library
import java.util.ArrayList;

// Player1 class, where it is a subclass of the Person class
// Object class for the player/user
// Player1 class extends the Person class and represents a player in the game.
public class Player1 extends Person
{
    // Constructor of Player1 class that initializes playerName, theBalance, and player status.
    public Player1(String playerName, int theBalance, boolean player) 
    {
        // Calls the superclass constructor with playerName, theBalance, and player.
        super(playerName, theBalance, player);
    }
    // Constructor of Player1 class that initializes playerName and player status.
    public Player1(String playerName, boolean player) 
    {
        // Calls the superclass constructor with playerName and player.
        super(playerName, player);
    }

    // Overrides the getPlayer method to always return true for Player1.
    @Override
    public boolean getPlayer()
    {
        // Returns true indicating this is a player.
        return true;
    }

    // Shuffles the red cards in the first half of the deck.
    // Accepts an ArrayList of Card objects as the deck to shuffle.
    public ArrayList<Card> shuffleHalfRedCards(ArrayList<Card> deck) 
    {
        // Initializes tempCardDeck to reference the input deck.
        ArrayList<Card> tempCardDeck = deck;

        // Boolean variable to control the shuffling loop.
        boolean loopControl1 = true;

        // Checks if the deck is null or empty and prints a message if so.
        if (deck == null || deck.isEmpty()) 
        {
            // Prints a message indicating the deck is null.
            System.out.println("Card Deck contains null");
        }
        else
        {
            // Loops while the first card is red and loopControl1 is true.
            while (loopControl1 && tempCardDeck.get(0).getCardColor().substring(0, 1).equalsIgnoreCase("R"))
            {
                // Generates a random index within the total size of the deck.
                int randomIndex = (int)(Math.random()*CasinoWarGame.getTotalSize());
                // Checks if the card at the random index is null.
                if (tempCardDeck.get(randomIndex) == null)
                {
                    // Sets loopControl1 to false to exit the loop.
                    loopControl1 = false;
                }
                else
                {
                    // Checks if the first card is red.
                    if (tempCardDeck.get(0).getCardColor().substring(0, 1).equalsIgnoreCase("R"))
                    {
                        // Swaps the first card with the card at the random index.
                        Card temp1 = tempCardDeck.get(randomIndex);
                        Card temp2 = tempCardDeck.get(0);
                        tempCardDeck.set(0, temp1);
                        tempCardDeck.set(randomIndex, temp2);
                    }
                    else
                    {
                        // Sets loopControl1 to false to exit the loop.
                        loopControl1 = false;
                    }
                }
            }
        }

        // Returns the shuffled deck.
        return tempCardDeck;
    }
    // Checks if a Card array contains only null values.
    public boolean checkArrayContainAllNull(Card[] temp)
    {
        // Copies the input array to aCardArray.
        Card[] aCardArray = temp;
        // Boolean output to track if all elements are null.
        boolean output = true;
        // Index for iterating through the array.
        int index = 0;
        // Loops while output is true.
        while (output)
        {
            // Checks if the current element is not null.
            if (aCardArray[index] != null)
            {
                // Sets output to false if a non-null element is found.
                output = false;
            }
            // Increments the index.
            index++;
        }
        // Returns true if all elements are null, false otherwise.
        return output;
    }
    // Overloaded method to check if a Card array contains only a specific object.
    public boolean checkArrayContainAllNull(Card[] temp, Object obj)
    {
        // Copies the input array to aCardArray.
        Card[] aCardArray = temp;
        // Boolean output to track if all elements match obj.
        boolean output = true;
        // Index for iterating through the array.
        int index = 0;
        // Loops while output is true.
        while (output)
        {
            // Checks if the current element does not match obj.
            if (aCardArray[index] != obj)
            {
                // Sets output to false if a non-matching element is found.
                output = false;
            }
            // Increments the index.
            index++;
        }
        // Returns true if all elements match obj, false otherwise.
        return output;
    }

    // toString method for this class
    @Override
    public String toString()
    {
        // Creates a string that is formatted by the programmer
        // Then stored into output String object
        String output = "|Player: " + getName() + "\n" +
                        "|Your Balance" + getBalance() +
                        "\n|You are a player";
        // Returns the output String object
        return output;
    }
}
