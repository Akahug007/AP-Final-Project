package Players;

import Cards.Card;
import java.util.ArrayList;

// Player1 interface
interface personInterface
{
    public ArrayList<Card> getCardDeck();
    public void setCardDeck(ArrayList<Card> deck);
}

// This is the parent class for the Player and Dealer classes
public class Person implements personInterface
{
    // Parent class Instance Variables
    // Name instance variable
    private String name = "";

    // Instance variable for a person's total balance
    private int totalBalance = 500;

    // Instance boolean variable
    private boolean isPlayer = false;

    // Declares an array of integers to represent the card deck
    private ArrayList<Card> cardDeck;

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
    public void setCardDeck(ArrayList<Card> cardList)
    {
        // Instantiates the cardDeck array with the deck
        this.cardDeck = cardList;

        // For loop that sets each card to a random card through
        // calling the setCardValue method
        for (int i = 0; i < this.cardDeck.size(); i++)
        {
            if (cardDeck.get(i) != null)
            {
                cardDeck.get(i).setCardValue();
            }
        }
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
