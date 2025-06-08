// Documentation
// Add GUI
// Add 2D Array of cards instead of size of deck
// Use polymorphism as for:
    // Whether the player wants to add shuffling or not
    // if shuffling is wanted: Player1 is instantiated like this: Player1 obj = new Player1()
    // if not wanted: Player1 is instantiated like this: Player1 obj = new Person()
package Main;

// Imports classes from the Players package
import Cards.Card;
import Players.Dealer;
import Players.Person;
import Players.Player1;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

// This program is about Casino War
// The game is played with a chosen number of decks with 52 cards each
// This is the driver class where all code executions will happen
public class CasinoWarGame 
{
    // This is the main method where all java code executions will happen
    public static void main(String[] args) 
    {
        // Instantiating the Scanner class
        Scanner input = new Scanner(System.in);

        // Creates a string variables called getNumberString and getYesNoString1
        String getNumberString = "";
        String getYesNoString1 = "";

        // Creates a boolean variable called enableShuffling
        boolean enableShuffling = false;

        // Creates a 2D array of cards where each row is a deck
        ArrayList<Card> cardList = new ArrayList<>();
        
        // Program asks the user to enter an integer value for the size of a deck
        System.out.println("Enter a number of decks: 2, 4, or any even number");

        // getNumberString gets a string input from the user
        getNumberString = input.nextLine();

        // Initializes variable numberOfDeck with 0
        int numberOfDeck = 0;

        // Exception handling
        try 
        {
            // playerBetAmount gets the parseInt of getNumber
            numberOfDeck = (int)(Integer.parseInt(getNumberString));
        }
        catch (NumberFormatException e)
        {
            // If the string does not contain a number, then playerBetAmount gets integer 2
            // and the exception is printed
            numberOfDeck = 2;
            System.out.println("Exception: " + e.getMessage());
        }
        
        // If the numberOfDeck is not even then
        // numberOfDeck should stay the same
        if (numberOfDeck % 2 != 0)
        {
            System.out.println("Error: number of the decks is an odd number, initializing size to 2");
            numberOfDeck = 2;
        }
        System.out.println("numberOfDeck: " + numberOfDeck);

        // Program asks the user to enter an integer value for the size of a deck
        System.out.println("Enter the size of a deck(Even numbers only, larger than 8)");

        // getNumberString gets a string input from the user
        getNumberString = input.nextLine();

        // Initializes variable sizeOfDeck with 0
        int sizeOfDeck = 0;

        // Exception handling
        try 
        {
            // playerBetAmount gets the parseInt of getNumber
            sizeOfDeck = (int)(Integer.parseInt(getNumberString));
        }
        catch (NumberFormatException e)
        {
            // If the string does not contain a number, then playerBetAmount gets integer 2
            // and the exception is printed
            sizeOfDeck = 10;
            System.out.println("Exception: " + e.getMessage());
        }

        // If the numberOfDeck is not even then
        // numberOfDeck should stay the same
        if (sizeOfDeck % 2 != 0 || sizeOfDeck <= 8)
        {
            System.out.println("Error: size of the decks is a weird number, initializing size to 10");
            sizeOfDeck = 10;
        }
        System.out.println("Size of all decks: " + (sizeOfDeck*numberOfDeck) + " cards");

        // // Initialize each deck with Card objects
        // for (int i = 0; i < numberOfDeck; i++)
        // {
        //     for (int j = 0; j < sizeOfDeck; j++) 
        //     {
        //         // You may need to adjust the constructor parameters for Card as needed
        //         // Replace the following line with the correct Card constructor parameters if needed
        //         if (j <= sizeOfDeck/2)
        //         {
        //             // Adds a new Card to the arrayList
        //             cardList.add(new Card());
        //         }
        //         else
        //         {
        //             // Adds null to the arrayList
        //             cardList.add(null);
        //         }
        //     }
        // }

        // Asks the player if shuffling should be  added or not
        System.out.println("Would you like to add shuffling the funny game? (Yes or No)");

        // Input for the question is given to the getYesNoString1 variable
        getYesNoString1 = input.nextLine();
        
        // Conditional where if the first character of the getYesNoString1 is Y
        // then enableShuffling gets true
        // Else: enablingShuffling gets false
        if (getYesNoString1.substring(0, 1).equalsIgnoreCase("Y"))
        {
            enableShuffling = true;
        }
        else
        {
            enableShuffling = false;
        }
        
        // Program asks the user to enter a name for the player
        System.out.println("Enter your name: ");

        // Stores the user's input in the variable playerName
        String playerName = input.nextLine();

        // Conditional that looks into the string
        // From the output, you can tell the program is also evil
        if (playerName.substring(0, 1).equalsIgnoreCase("H"))
        {
            System.out.println("I don't like that name >:)");
        }
        else if (playerName.indexOf("H") > -1 || playerName.indexOf("h") > -1)
        {
            System.out.println("That name is alright");
        }
        else if (playerName.length() > 10)
        {
            System.out.println("That name is toooooooooooooooooooooooooooooooo(2) loooooooooooooooooooooooooooooooooooong");
        }
        else
        {
            System.out.println("cool name I guess");
        }
        
        System.out.println();

        // Creates an instance of Player1 class
        Person thePlayer;
       

        // Creates an instance of Dealer class
        Person theDealer;

        if (enableShuffling)
        {
            thePlayer = new Player1(playerName, true);
            theDealer = new Dealer("The Dealer", false);
        }
        else
        {
            thePlayer = new Person(playerName, true);
            theDealer = new Person("The Dealer", false);
        }

        // Boolean variable for the playAgain option
        boolean playAgain = true;

        // Output statement that outputs a message to the user/player if they are ready to play, no conditional statement
        // This program would force the player to play the game
        System.out.println("Are you ready to play?");
        input.nextLine();

        // Output statement that outputs a message to welcome the player to the game
        System.out.println();
        System.out.println("Welcome to Casino War!");

        // int variable for index
        int indexOfCardArray = 0;

        // Game loop
        while (playAgain)
        {
            boolean gameLoop = true;

            // Program assigns the deck to the player and dealer
            thePlayer.setCardDeck(numberOfDeck, sizeOfDeck);
            theDealer.setCardDeck(numberOfDeck, sizeOfDeck);
            indexOfCardArray++;

            // Program informs user of the player's bet amount
            System.out.println();
            System.out.println("Your current balance is: " + thePlayer.getBalance());
                
            // Program asks the user to enter a bet amount
            System.out.println("Enter a bet amount: ");

            getNumberString = input.nextLine();
            
            // Temporary variable to store the user's input
            int playerBetAmount = 0;

            // Exception handling
            try 
            {
                // playerBetAmount gets the parseInt of getNumber
                playerBetAmount = Integer.parseInt(getNumberString);
            }
            catch (NumberFormatException e)
            {
                // If the string does not contain a number, then playerBetAmount gets integer 2
                // and the exception is printed
                playerBetAmount = 2;
                System.out.println(e.getMessage());
            }

            // Temporary variable to store the dealer's bet amount
            int dealerBetAmount = playerBetAmount;

            while(gameLoop)
            {
                // Boolean variables
                boolean playerWins = false;
                boolean dealerWins = false;

                // Print each card in the player's deck
                System.out.print("Player's deck: ");
                for (Card card : thePlayer.getCardDeck()) 
                {
                    if (card != null) 
                    {
                        System.out.print(card.getCardName() + ", ");
                    }
                }
                System.out.println();

                // Print each card in the dealer's deck
                System.out.print("Dealer's deck: ");
                for (Card card : theDealer.getCardDeck()) {
                    if (card != null) 
                    {
                        System.out.print(card.getCardName() + ", ");
                    }
                }
                System.out.println();

                // Adds a buffer to the scanner
                input.nextLine();

                // Conditional statement
                // If the player's bet amount is greater than the player's balance
                // Bet amount is divided by 2
                if (playerBetAmount > thePlayer.getBalance())
                {
                    System.out.println("Your bet amount is greater than your balance. All bets split in half.");
                    playerBetAmount /= 2;
                    dealerBetAmount = playerBetAmount;       
                }

                // If the player's bet amount is greater than the dealer's balance
                // Bet amount is divided by 2
                else if (dealerBetAmount > theDealer.getBalance())
                {
                    System.out.println("Your bet amount is greater than the Dealer's balance. All bets split in half.");
                    dealerBetAmount /= 2;
                    playerBetAmount = dealerBetAmount; 
                }
                
                // Program informs user of the beginning of the game
                System.out.println("\nPlayer is ready, Dealer is ready ");

                // Program questions user if they are ready to flip their card
                // Will continue without any conditional statement
                System.out.println("Are you ready to flip your card? ");
                input.nextLine();

                System.out.println();

                // Temporary variables that store references to the player's and dealer's card deck
                ArrayList<Card> playerTempDeck = thePlayer.getCardDeck();
                ArrayList<Card> dealerTempDeck = theDealer.getCardDeck();    
                System.out.println("Number of cards in your current deck: " + getLastIndex(playerTempDeck));
                System.out.println();

                // Informs the player what card they drew
                System.out.println("You drew a: " + (playerTempDeck.get(0).getCardName()) + " card");

                // Informs the player what card the dealer drew
                System.out.println("The dealer drew a: " + (dealerTempDeck.get(0).getCardName()) + " card");

                // Conditional statement to check if the first element has null
                if (playerTempDeck.get(0) == null || dealerTempDeck.get(0) == null) 
                {
                    moveElements(dealerTempDeck);
                    moveElements(playerTempDeck);
                }

                // Conditional statement to check the values between the dealer's and player's card
                if (playerTempDeck.get(0).getCardValue() > dealerTempDeck.get(0).getCardValue())
                {
                    System.out.println("You win the round!");
                    playerTempDeck.set(getFirstEmptyIndex(playerTempDeck), dealerTempDeck.get(0));
                    playerTempDeck.set(getFirstEmptyIndex(playerTempDeck), playerTempDeck.get(0));
                    moveElements(dealerTempDeck);
                    moveElements(playerTempDeck);
                }
                else if (playerTempDeck.get(0).getCardValue() == dealerTempDeck.get(0).getCardValue())
                {
                    System.out.println("WAR");
                    System.out.println("Would you like to continue?");
                    input.nextLine();
                    startWar(playerTempDeck, dealerTempDeck);
                }
                else if (playerTempDeck.get(0).getCardValue() < dealerTempDeck.get(0).getCardValue())
                {
                    System.out.println("You lost the round!");
                    dealerTempDeck.set(getFirstEmptyIndex(dealerTempDeck), playerTempDeck.get(0));
                    dealerTempDeck.set(getFirstEmptyIndex(dealerTempDeck), dealerTempDeck.get(0));
                    moveElements(dealerTempDeck);
                    moveElements(playerTempDeck);
                }
                // Program informs user of what deck they get and what deck the dealer gets
                System.out.println(thePlayer.getName() + " gets deck #" + (indexOfCardArray + 1));
                System.out.println(theDealer.getName() + " gets deck #" + (indexOfCardArray + 2));
                System.out.println("All cards get shuffled");

                // Conditional where if enableShuffling is true, then both dealer and player cards get shuffled
                if (enableShuffling)
                {
                    // Creates new objects that used Casted versions of the person objects
                    Player1 playerCasted = (Player1) thePlayer;
                    Dealer dealerCasted = (Dealer) theDealer;

                    // Calls methods from the casted objects to shuffle
                    // the cards
                    playerCasted.shuffleRedCards(playerTempDeck);
                    dealerCasted.shuffleBlackCards(dealerTempDeck);
                }

                System.out.println();

                // Condition to see if one of the players has the full number of cards
                if (getLastIndex(playerTempDeck) == sizeOfDeck)
                {
                    playerWins = true;
                }
                else if (getLastIndex(dealerTempDeck) == sizeOfDeck)
                {
                    dealerWins = true;
                }

                // Program questions user if they are ready to flip their card
                // Will continue without any conditional statement
                System.out.println("Would you like to continue?");
                input.nextLine();

                // Conditional that checks if the boolean variable playerWins is true
                if (playerWins)
                {
                    System.out.println("You win the round!");
                    System.out.println("You've gained $" + dealerBetAmount + "!");
                    thePlayer.addBalance(dealerBetAmount);
                    theDealer.deductBalance(dealerBetAmount);
                    gameLoop = false;
                }
                // Conditional that checks if the boolean variable dealerWins is true
                else if (dealerWins)
                {
                    System.out.println("You lost the round! The Dealer wins!");
                    System.out.println("You've losted $" + playerBetAmount + "!");
                    thePlayer.deductBalance(playerBetAmount);
                    theDealer.addBalance(playerBetAmount);
                    gameLoop = false;
                }
                // Program informs user of what deck they get and what deck the dealer gets
                System.out.println(thePlayer.getName() + " gets deck #" + (indexOfCardArray + 1));
                System.out.println(theDealer.getName() + " gets deck #" + (indexOfCardArray + 2));
            }
            // Conditional that checks the game can be played again if both the player and dealer still have money
            if (thePlayer.getBalance() > 0 && theDealer.getBalance() > 0)
            {
                // If true, the program will the prompt the user if they want to play again
                System.out.println("Would you like to play another round? Yes or No");
                String redo = input.nextLine();
                // If true, then the game restarts
                if (redo.equalsIgnoreCase("Yes"))
                {
                    playAgain = true;
                }
                // If false, then the game stops
                else
                {
                    playAgain = false;
                    System.out.println("The game has ended. Results:");
                    // If true, the program states the player has won
                    if (thePlayer.getBalance() > theDealer.getBalance())
                    {
                        System.out.println("You have won the game!");
                    }
                    // If true, the program states the player has tied
                    else if (theDealer.getBalance() == thePlayer.getBalance()) 
                    {
                        System.out.println("This game ends in a tie!");
                    }
                    // If all conditionals are false, the program states the player has lost the game
                    else
                    {
                        System.out.println("You have lost the game!");
                    }
                }
            }
            else
            {
                // If false, then the game will stop and more conditionals start
                playAgain = false;
                System.out.println("The game has ended. Results:");
                // If true, the program states the player has won
                if (thePlayer.getBalance() > theDealer.getBalance())
                {
                    System.out.println("You have won the game!");
                }
                // If true, the program states the player has tied
                else if (theDealer.getBalance() == thePlayer.getBalance()) 
                {
                    System.out.println("This game ends in a tie!");
                }
                // If all conditionals are false, the program states the player has lost the game
                else
                {
                    System.out.println("You have lost the game!");
                }
            }
        }
    }
    // Method that moves elements in the array to the left 1 time
    // This is to simulate the removal of the card from the deck
    public static void moveElements(ArrayList<Card> list)
    {
        for (int i = 1; i < list.size(); i++)
        {
            list.set(i-1, list.get(i));
        }
    }
    // Method that returns the first empty index in an ArrayList (i.e., the first null element)
    /*\
     * Returns the index of the first empty (null) element in the given list of cards,
     * where the previous element is not null. This is typically used to find the first
     * available slot after a sequence of non-null elements.
    \*/
    public static int getFirstEmptyIndex(ArrayList<Card> list)
    {
        int index = 0;
        for (int i = 1; i < list.size(); i++)
        {
            if (list.get(i) == null && (list.get(i-1) != null))
            {
                index = i;
                i = list.size();
            }
        }
        return index;
    }

    // Method that returns the count of non-null elements in the ArrayList
    public static int getLastIndex(ArrayList<Card> list)
    {
        int count = 0;
        for (Card card : list)
        {
            if (card != null)
            {
                count++;
            }
        }
        return count;
    }
    // Debug method that traverses through an array and prints out the card names
    public static void debugArray(Card[] arr1, Card[] arr2)
    {
        // Player's card deck traversing
        System.out.println("Your card deck: ");
        int j = 0;
        for (int i = 0; i < arr1.length; i++)
        {
            if (arr1[i] == null)
            {
                i = arr1.length;
            }
            else
            {
                j = i;
                System.out.print(arr1[j].getCardName() + ", ");
            }
            
        }
        System.out.println();
        // Dealer's card deck traversing
        System.out.println("Dealer's card deck: ");
        int k = 0;
        for (int i = 0; i < arr2.length; i++)
        {
            if (arr2[i] == null)
            {
                i = arr1.length;
            }
            else
            {
                k = i;
                System.out.print(arr2[k].getCardName() + ", ");
            }
            
        }
        System.out.println();       
    }
    // War Method
    public static void startWar(ArrayList<Card> arr1, ArrayList<Card> arr2)
    {
        int index = 3;
        boolean war = true;
        while (war)
        {
            // Check for nulls or out-of-bounds to avoid exceptions
            if (index >= arr1.size() || index >= arr2.size() || arr1.get(index) == null || arr2.get(index) == null) 
            {
                System.out.println("Not enough cards to continue war!");
                war = false;
                // Player wins war
                if (arr1.get(index).getCardValue() > arr2.get(index).getCardValue())
                {
                    System.out.println("You win the War round!");
                    for (int i = 0; i < index; i++)
                    {
                        arr1.set(getFirstEmptyIndex(arr1), arr2.get(i));
                        arr1.set(getFirstEmptyIndex(arr1), arr1.get(i));
                        moveElements(arr2);
                        moveElements(arr1);
                    }
                    war = false;
                }
                // Dealer wins war
                else if (arr1.get(index).getCardValue() < arr2.get(index).getCardValue())
                {
                    System.out.println("You lose the War round!");
                    for (int i = 0; i < index; i++)
                    {
                        arr2.set(getFirstEmptyIndex(arr2), arr1.get(i));
                        arr2.set(getFirstEmptyIndex(arr2), arr2.get(i));
                        moveElements(arr2);
                        moveElements(arr1);
                    }
                    war = false;
                }
                // Tie, continue war
                else
                {
                    System.out.println("You and the Dealer tied the War round!");
                    index += 4;
                }
            }
            
        }
    }
}