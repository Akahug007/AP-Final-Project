package Players;

import Cards.Card;
import java.util.ArrayList;

// Person interface
interface personInterface
{
    public ArrayList<Card> getCardDeck();
    public void setCardDeck(int numDeck, int sizeDeck);
}

// This is the parent class for the Player and Dealer classes
// Class representing a person in the game, implementing personInterface
public class Person implements personInterface
{
    // Parent class Instance Variables

    // Name instance variable
    private String name = "";

    // Instance variable for a person's total balance
    private int totalBalance = 500;

    // int variable to set the total size of the cardDeck
    public static int totalDeckSize = 0;

    // Instance boolean variable to indicate if this person is a player
    private boolean isPlayer = false;

    // Declares an array of integers to represent the card deck
    private ArrayList<Card> cardDeck = new ArrayList<>();

    // Parent class Constructor which takes in a name, balance, and player status
    public Person(String theName, int theBalance, boolean player)
    {
        // Assigns the name to the person
        this.name = theName;
        // Sets the total balance for the person
        this.totalBalance = theBalance;
        // Sets whether this person is a player
        this.isPlayer = player;
    }

    // Parent class Constructor which takes in a name and player status
    public Person(String theName, boolean player)
    {
        // Assigns the name to the person
        this.name = theName;
        // Sets whether this person is a player
        this.isPlayer = player;
    }

    // Getter methods

    // Returns the total balance of a person
    public int getBalance()
    {
        return totalBalance;
    }

    // Returns the name of a person
    public String getName()
    {
        return this.name;
    }

    // Returns the boolean variable isPlayer
    public boolean getPlayer()
    {
        return isPlayer;
    }

    // Method to get the card deck
    public ArrayList<Card> getCardDeck()
    {
        return cardDeck;
    }

    // Setter methods

    // When player loses a bet, deducts the balance from the total balance
    public void deductBalance(int balance)
    {
        this.totalBalance -= balance;
    }

    // When player wins a bet/game, adds the bet from the dealer to the total balance
    public void addBalance(int balance)
    {
        this.totalBalance += balance;
    }

    // Method to set the card deck with number of decks and size of each deck
    public void setCardDeck(int numDeck, int sizeDeck)
    {
        // Assigns totalDeckSize with numDeck times the sizeDeck
        totalDeckSize = numDeck * sizeDeck;
        
        // Initialize each deck with Card objects
        for (int i = 0; i < totalDeckSize; i++)
        {
            // If index is less than or equal to half the deck size, add a new Card
            if (i <= sizeDeck/2)
            {
                // Adds a new Card to the arrayList
                cardDeck.add(new Card());
                // Sets the card value for the card at index i
                cardDeck.get(i).setCardValue();
            }
            else
            {
                // Adds null to the arrayList
                cardDeck.add(null);
            }
        }
    }

    // Method to set the card deck with number of decks, size, and color
    public void setCardDeck(int numDeck, int sizeDeck, String color)
    {
        // Assigns totalDeckSize with numDeck times the sizeDeck
        totalDeckSize = numDeck * sizeDeck;
        
        // Initialize each deck with Card objects
        for (int i = 0; i < totalDeckSize; i++)
        {
            // If index is less than or equal to half the deck size, add a new Card with color
            if (i <= sizeDeck/2)
            {
                // Adds a new Card to the arrayList
                cardDeck.add(new Card());
                // Sets the card value for the card at index i with a random value and color
                cardDeck.get(i).setCardValue((int)(Math.random()*12 + 1), color);
            }
            else
            {
                // Adds null to the arrayList
                cardDeck.add(null);
            }
        }
    }

    // Method to access a card at a specific index in a given card deck
    public Card accessCard(ArrayList<Card> tempCardDeck, int index)
    {
        return tempCardDeck.get(index);
    }

    // Method to change the card deck to a new card deck
    public void changeCardDeck(ArrayList<Card> newCardDeck)
    {
        cardDeck = newCardDeck;
    }

    // Method to return totalDeckSize
    public static int getTotalDeckSize()
    {
        return totalDeckSize;
    }

    // toString method for this class
    public String toString()
    {
        // Creates a string that is formatted by the programmer
        // Then stored into output String object
        String output = "|Player: " + getName() + "\n" +
                        "|Balance: " + getBalance();
        // Returns the output String object
        return output;
    }
}
