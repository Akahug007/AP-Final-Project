package Players;

// This is the parent class for the Player and Dealer classes
public class Person 
{
    // Parent class Instance Variables
    // Name instance variable
    private String name = "";
    // Instance variable for a person's total balance
    private int totalBalance = 500;

    // Parent class Constructor which takes in a name argument
    public Person(String theName)
    {
        this.name = theName;
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
