package Players;

import Cards.Card;
import Main.CasinoWarGame;

//  Imports the ArrayList library
import java.util.ArrayList;

// Dealer class, where it is a subclass of the Person class
// Object class for the dealer/computer
// Dealer class extends the Person class and represents the dealer in the game.
public class Dealer extends Person
{
    
    // Constructor for Dealer class with dealer name, balance, and player status.
    public Dealer(String dealerName, int theBalance, boolean player) 
    {
        // Calls the superclass constructor with dealer name, balance, and player status.
        super(dealerName, theBalance, player);
    }
    // Constructor for Dealer class with dealer name and player status.
    public Dealer(String dealerName, boolean player) 
    {
        // Calls the superclass constructor with dealer name and player status.
        super(dealerName, player);
    }

    // Returns the name of the dealer as "The Dealer".
    @Override
    public String getName()
    {
        // Returns the string "The Dealer".
        return "The Dealer";
    }

    // Returns false, indicating the dealer is not a player.
    @Override
    public boolean getPlayer()
    {
        // Returns false for dealer.
        return false;
    }

    // Shuffles the black cards in the first half of the deck.
    // Accepts an ArrayList of Card objects representing the deck.
    // Returns the shuffled ArrayList of Card objects.
    public ArrayList<Card> shuffleHalfBlackCards(ArrayList<Card> deck) 
    {
        // Initializes tempCardDeck to reference the input deck.
        ArrayList<Card> tempCardDeck = deck;

        // Boolean variable to control the while loop for shuffling.
        boolean loopControl1 = true;

        // Checks if the deck is null or empty and prints a message if so.
        if (deck == null || deck.isEmpty()) 
        {
            // Prints a message if the deck is null or empty.
            System.out.println("Card Deck contains null");
        }
        else
        {
            // Loops while the first card is black and loopControl1 is true.
            while (loopControl1 && tempCardDeck.get(0).getCardColor().substring(0, 1).equalsIgnoreCase("B"))
            {
                // Generates a random index within the total size of the deck.
                int randomIndex = (int)(Math.random()*CasinoWarGame.getTotalSize());
                // Checks if the card at the random index is null.
                if (tempCardDeck.get(randomIndex) == null)
                {
                    // Sets loopControl1 to false if the card is null.
                    loopControl1 = false;
                }
                else
                {
                    // Checks if the first card is black.
                    if (tempCardDeck.get(0).getCardColor().substring(0, 1).equalsIgnoreCase("B"))
                    {
                        // Swaps the first card with the card at the random index.
                        Card temp1 = tempCardDeck.get(randomIndex);
                        Card temp2 = tempCardDeck.get(0);
                        tempCardDeck.set(0, temp1);
                        tempCardDeck.set(randomIndex, temp2);
                    }
                    else
                    {
                        // Sets loopControl1 to false if the first card is not black.
                        loopControl1 = false;
                    }
                }
            }
        }
        // Returns the shuffled deck.
        return tempCardDeck;
    }
    
    // Checks if a Card array contains only null values.
    // Accepts an array of Card objects.
    // Returns true if all elements are null, false otherwise.
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
    // Accepts an array of Card objects and an Object to compare.
    // Returns true if all elements are equal to the object, false otherwise.
    public boolean checkArrayContainAllNull(Card[] temp, Object obj)
    {
        // Copies the input array to aCardArray.
        Card[] aCardArray = temp;
        // Boolean output to track if all elements match the object.
        boolean output = true;
        // Index for iterating through the array.
        int index = 0;
        // Loops while output is true.
        while (output)
        {
            // Checks if the current element is not equal to the object.
            if (aCardArray[index] != obj)
            {
                // Sets output to false if a non-matching element is found.
                output = false;
            }
            // Increments the index.
            index++;
        }
        // Returns true if all elements match the object, false otherwise.
        return output;
    }
}
