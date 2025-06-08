package Players;

import Cards.Card;
import java.util.ArrayList;

// Player1 interface
interface personInterface
{
    public ArrayList<Card> getCardDeck();
    public void setCardDeck(int numDeck, int sizeDeck);
}

// This is the parent class for the Player and Dealer classes
public class Person implements personInterface
{
    // Parent class Instance Variables
    // Name instance variable
    private String name = "";

    // Instance variable for a person's total balance
    private int totalBalance = 500;

    // int variable to set the total size of the cardDeck
    public static int totalDeckSize = 0;

    // Instance boolean variable
    private boolean isPlayer = false;

    // Declares an array of integers to represent the card deck
    private ArrayList<Card> cardDeck = new ArrayList<>();

    

    // Parent class Constructor which takes in a name argument
    public Person(String theName, int theBalance, boolean player)
    {
        this.name = theName;
        this.totalBalance = theBalance;
        this.isPlayer = player;
    }
    
    // Parent class Constructor which takes in a name argument
    public Person(String theName, boolean player)
    {
        this.name = theName;
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

    // Method to set the card deck
    public void setCardDeck(int numDeck, int sizeDeck)
    {
        // Assigns totalDeckSize with numDeck times the sizeDeck
        totalDeckSize = numDeck * sizeDeck;
        
        // Initialize each deck with Card objects
        for (int i = 0; i < numDeck; i++)
        {
            for (int j = 0; j < sizeDeck; j++) 
            {
                // You may need to adjust the constructor parameters for Card as needed
                // Replace the following line with the correct Card constructor parameters if needed
                if (j <= sizeDeck/2)
                {
                    // Adds a new Card to the arrayList
                    cardDeck.add(new Card());
                    cardDeck.get(j).setCardValue();
                }
                else
                {
                    // Adds null to the arrayList
                    cardDeck.add(null);
                }
            }
        }
    }

    // Method to change the card deck
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
        String output = "Player " + getName() + "\n" +
                        "Here is your balance" + getBalance();
        // Returns the output String object
        return output;
    }
    
}
