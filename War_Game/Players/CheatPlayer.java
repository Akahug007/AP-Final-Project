// Players package
package Players;

// Card class is in the Cards package
import Cards.Card;
import Main.CasinoWarGame;

//  Imports the ArrayList library
import java.util.ArrayList;

// Player1 class, where it is a subclass of the Person class
// Object class for the player/user
// CheatPlayer class extends the Person class and represents a player that can cheat in the game.
public class CheatPlayer extends Person
{
    // Constructor for CheatPlayer that takes playerName, theBalance, and player as parameters.
    public CheatPlayer(String playerName, int theBalance, boolean player) 
    {
        super(playerName, theBalance, player);
    }
    
    // Constructor for CheatPlayer that takes playerName and player as parameters.
    public CheatPlayer(String playerName, boolean player) 
    {
        super(playerName, player);
    }

    // Overrides the getPlayer method to always return true, indicating this is a player.
    @Override
    public boolean getPlayer()
    {
        return true;
    }

    // Shuffles only the red cards in the given deck.
    // Uses String methods in if, loop, parameter, and return type.
    public ArrayList<Card> shuffleHalfRedCards(ArrayList<Card> deck) 
    {
        // Initializes tempCardDeck to deck
        ArrayList<Card> tempCardDeck = deck;

        // Boolean variable that controls a while loop
        boolean loopControl1 = true;

        // Checks if the deck is null or empty and prints a message if so.
        if (deck == null || deck.isEmpty()) 
        {
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
                        // Ends the loop if the first card is not red.
                        loopControl1 = false;
                    }
                }
            }
        }

        // Returns the shuffled deck.
        return tempCardDeck;
    }

    // Method to check if a card array entirely contains null values only.
    public boolean checkArrayContainAllNull(Card[] temp)
    {
        // Array of Cards assigned from parameter.
        Card[] aCardArray = temp;
        // Output flag to indicate if all elements are null.
        boolean output = true;
        // Index for iterating through the array.
        int index = 0;
        // Loops through the array while output is true.
        while (output)
        {
            // If a non-null card is found, set output to false.
            if (aCardArray[index] != null)
            {
                output = false;
            }
            // Increment the index.
            index++;
        }
        // Returns true if all elements are null, false otherwise.
        return output;
    }

    // Overloaded method to check if a card array contains only the specified object.
    public boolean checkArrayContainAllNull(Card[] temp, Object obj)
    {
        // Array of Cards assigned from parameter.
        Card[] aCardArray = temp;
        // Output flag to indicate if all elements match the object.
        boolean output = true;
        // Index for iterating through the array.
        int index = 0;
        // Loops through the array while output is true.
        while (output)
        {
            // If an element does not match the object, set output to false.
            if (aCardArray[index] != obj)
            {
                output = false;
            }
            // Increment the index.
            index++;
        }
        // Returns true if all elements match the object, false otherwise.
        return output;
    }

    // Method to set the card deck with a specified number of decks, size, and color.
    @Override
    public void setCardDeck(int numDeck, int sizeDeck, String color)
    {
        // Assigns totalDeckSize with numDeck times the sizeDeck.
        totalDeckSize = numDeck * sizeDeck;
        
        // Initialize each deck with Card objects or null.
        for (int i = 0; i < totalDeckSize; i++)
        {
            // Adds a new Card to the arrayList if within half the deck size.
            if (i <= sizeDeck/2)
            {
                // Adds a new Card to the arrayList.
                getCardDeck().add(new Card());
                // Sets the card value and color.
                getCardDeck().get(i).setCardValue(14, color);
            }
            else
            {
                // Adds null to the arrayList.
                getCardDeck().add(null);
            }
        }
    }

    // Returns a reference to the card deck.
    public ArrayList<Card> getCardDeckRef()
    {
        return getCardDeck();
    }
}
