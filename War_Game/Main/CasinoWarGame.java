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
import Players.CheatPlayer;
import Players.Dealer;
import Players.Person;
import Players.Player1;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

// This program is about Casino War
// The game is played with a chosen number of decks with 52 cards each
// This is the driver class where all code executions will happen
// The CasinoWarGame class represents the main entry point for the Casino War card game application.
public class CasinoWarGame 
{
    // Static integer variable to store the total size of all decks combined.
    private static int totalDeckSize = 0;
    
    // The main method where the execution of the Casino War game begins.
    public static void main(String[] args) 
    {
        // Instantiates the Scanner class to receive user input from the console.
        Scanner input = new Scanner(System.in);

        // String variable to store user input for numbers.
        String getNumberString = "";
        // String variable to store user input for yes/no questions (shuffling).
        String getYesNoString1 = "";
        // String variable to store user input for yes/no questions (cheating).
        String getYesNoString2 = "";

        // Boolean variable to determine if shuffling is enabled.
        boolean enableShuffling = false;
        // Boolean variable to determine if cheating is enabled.
        boolean enableCheating = false;

        // ArrayList to store the cards for the game (all decks).
        ArrayList<Card> cardList = new ArrayList<>();

        // Temporary ArrayList to store a reference to the player's cards.
        ArrayList<Card> tempPlayerList = null;
        
        // Prompts the user to enter the number of decks to use in the game.
        System.out.println("Enter a number of decks: 2, 4, or any even number");

        // Reads the user's input for the number of decks.
        getNumberString = input.nextLine();

        // Integer variable to store the parsed number of decks.
        int numberOfDeck = 0;

        // Tries to parse the user's input for the number of decks.
        try 
        {
            // Parses the input string to an integer for the number of decks.
            numberOfDeck = (int)(Integer.parseInt(getNumberString));
        }
        // Catches exceptions if the input is not a valid integer.
        catch (NumberFormatException e)
        {
            // Sets the number of decks to 2 if input is invalid and prints the exception message.
            numberOfDeck = 2;
            System.out.println("Exception: " + e.getMessage());
        }
        
        // Checks if the number of decks is even; if not, sets it to 2.
        if (numberOfDeck % 2 != 0)
        {
            System.out.println("Error: number of the decks is an odd number, initializing size to 2");
            numberOfDeck = 2;
        }
        // Prints the number of decks being used.
        System.out.println("numberOfDeck: " + numberOfDeck);

        // Prompts the user to enter the size of each deck.
        System.out.println("Enter the size of a deck(Even numbers only, larger than 8)");

        // Reads the user's input for the size of the deck.
        getNumberString = input.nextLine();

        // Integer variable to store the parsed size of the deck.
        int sizeOfDeck = 0;

        // Tries to parse the user's input for the size of the deck.
        try 
        {
            // Parses the input string to an integer for the size of the deck.
            sizeOfDeck = (int)(Integer.parseInt(getNumberString));
        }
        // Catches exceptions if the input is not a valid integer.
        catch (NumberFormatException e)
        {
            // Sets the size of the deck to 10 if input is invalid and prints the exception message.
            sizeOfDeck = 10;
            System.out.println("Exception: " + e.getMessage());
        }

        // Checks if the size of the deck is even and greater than 8; if not, sets it to 10.
        if (sizeOfDeck % 2 != 0 || sizeOfDeck <= 8)
        {
            System.out.println("Error: size of the decks is a weird number, initializing size to 10");
            sizeOfDeck = 10;
        }
        // Prints the total number of cards in all decks.
        System.out.println("Size of all decks: " + (sizeOfDeck*numberOfDeck) + " cards");

        // Sets the totalDeckSize to the product of sizeOfDeck and numberOfDeck.
        totalDeckSize = sizeOfDeck * numberOfDeck;

        // Prompts the user to decide if shuffling should be enabled.
        System.out.println("Would you like to add shuffling the funny game? (Yes or No)");

        // Reads the user's input for shuffling.
        getYesNoString1 = input.nextLine();
        
        // Checks if the user wants to enable shuffling based on their input.
        if (getYesNoString1.substring(0, 1).equalsIgnoreCase("Y"))
        {
            enableShuffling = true;
        }
        else
        {
            enableShuffling = false;
        }
        
        // Prompts the user to enter their name.
        System.out.println("Enter your name: ");

        // Reads the user's input for their name.
        String playerName = input.nextLine();

        // Checks for special cases in the player's name and prints appropriate messages.
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
        
        // Prompts the user to decide if they want to cheat.
        System.out.println("Would you like to cheat?");
        // Reads the user's input for cheating.
        getYesNoString2 = input.nextLine();

        // Sets enableCheating based on the user's input.
        if (getYesNoString2.equalsIgnoreCase("Yes"))
        {
            enableCheating = true;
        }
        else
        {
            enableCheating = false;
        }

        // Prints the user's response to the cheating question.
        System.out.println("Response" + getYesNoString2);

        // Declares a Person object to represent the player.
        Person thePlayer;
       
        // Declares a Person object to represent the dealer.
        Person theDealer;

        // Instantiates the player and dealer objects based on shuffling and cheating options.
        if (!enableCheating)
        {
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
        }
        else
        {
            if (enableShuffling)
            {
                thePlayer = new CheatPlayer(playerName, true);
                theDealer = new Dealer("The Dealer", false);
            }
            else
            {
                thePlayer = new CheatPlayer(playerName, true);
                theDealer = new Person("The Dealer", false);
            }
        }

        // Boolean variable to control the main game loop for playing again.
        boolean playAgain = true;

        // Prompts the user if they are ready to play (no conditional, game will proceed).
        System.out.println("Are you ready to play?");
        // Waits for user input before starting the game.
        input.nextLine();

        // Prints a welcome message to the player.
        System.out.println();
        System.out.println("Welcome to Casino War!");

        // Integer variable to keep track of the card array index.
        int indexOfCardArray = 0;

        // Main game loop that continues as long as playAgain is true.
        while (playAgain)
        {
            // Boolean variable to control the inner game loop for a round.
            boolean gameLoop = true;

            // Assigns decks to the player and dealer.
            thePlayer.setCardDeck(numberOfDeck, sizeOfDeck, "Black");
            theDealer.setCardDeck(numberOfDeck, sizeOfDeck, "Red");

            // Prints the total number of cards in play.
            System.out.println((numberOfDeck*sizeOfDeck) + "");

            // Prints the player's current balance.
            System.out.println();
            System.out.println("Your current balance is: " + thePlayer.getBalance());
                
            // Prompts the user to enter a bet amount.
            System.out.println("Enter a bet amount: ");

            // Reads the user's input for the bet amount.
            getNumberString = input.nextLine();
            
            // Integer variable to store the player's bet amount.
            int playerBetAmount = 0;

            // Tries to parse the user's input for the bet amount.
            try 
            {
                // Parses the input string to an integer for the bet amount.
                playerBetAmount = Integer.parseInt(getNumberString);
            }
            // Catches exceptions if the input is not a valid integer.
            catch (NumberFormatException e)
            {
                // Sets the bet amount to 2 if input is invalid and prints the exception message.
                playerBetAmount = 2;
                System.out.println(e.getMessage());
            }

            // Integer variable to store the dealer's bet amount (same as player's).
            int dealerBetAmount = playerBetAmount;

            // Retrieves the player's current deck.
            ArrayList<Card> playerTempDeck = thePlayer.getCardDeck();
            // Retrieves the dealer's current deck.
            ArrayList<Card> dealerTempDeck = theDealer.getCardDeck();

            // Inner game loop for a single round.
            while(gameLoop)
            {
                // Boolean variable to indicate if the player wins the round.
                boolean playerWins = false;
                // Boolean variable to indicate if the dealer wins the round.
                boolean dealerWins = false;

                // Adds a buffer to the scanner to wait for user input.
                input.nextLine();

                // Checks if the player's bet is greater than their balance and splits the bet if necessary.
                if (playerBetAmount > thePlayer.getBalance())
                {
                    System.out.println("Your bet amount is greater than your balance. All bets split in half.");
                    playerBetAmount /= 2;
                    dealerBetAmount = playerBetAmount;       
                }
                // Checks if the dealer's bet is greater than their balance and splits the bet if necessary.
                else if (dealerBetAmount > theDealer.getBalance())
                {
                    System.out.println("Your bet amount is greater than the Dealer's balance. All bets split in half.");
                    dealerBetAmount /= 2;
                    playerBetAmount = dealerBetAmount; 
                }
                
                // Prints a message indicating the start of the round.
                System.out.println("\nPlayer is ready, Dealer is ready ");

                // Prompts the user if they are ready to flip their card.
                System.out.println("Are you ready to flip your card? ");
                // Waits for user input before flipping cards.
                input.nextLine();

                // Prints a blank line for formatting.
                System.out.println();

                // Prints the player's current deck.
                System.out.print("Player's deck: ");
                for (Card card : thePlayer.getCardDeck()) 
                {
                    if (card != null) 
                    {
                        System.out.print(card.getCardName() + ", ");
                    }
                    else
                    {
                        System.out.print(", ");
                    }
                }
                // Prints the value of the first card in the player's deck.
                System.out.println(thePlayer.getCardDeck().get(0).getCardValue());

                // Prints the dealer's current deck.
                System.out.print("Dealer's deck: ");
                for (Card card : theDealer.getCardDeck()) {
                    if (card != null) 
                    {
                        System.out.print(card.getCardName() + ", ");
                    }
                    else
                    {
                        System.out.print(", ");
                    }
                }
                
                // Prints the number of cards in the player's current deck.
                System.out.println("Number of cards in your current deck: " + getLastIndex(playerTempDeck));
                // Prints blank lines for formatting.
                System.out.println();
                System.out.println();

                // Informs the player of the card they drew.
                System.out.println("You drew a: " + (playerTempDeck.get(0).getCardName()) + " card");

                // Informs the player of the card the dealer drew.
                System.out.println("The dealer drew a: " + (dealerTempDeck.get(0).getCardName()) + " card");

                // Checks if the first card in the player's deck is null and moves elements if needed.
                if (playerTempDeck.get(0) == null) 
                {
                    moveElements(playerTempDeck);
                }
                // Checks if the first card in the dealer's deck is null and moves elements if needed.
                else if (dealerTempDeck.get(0) == null)
                {
                    moveElements(dealerTempDeck);
                }

                // Compares the values of the player's and dealer's cards to determine the round outcome.
                if (playerTempDeck.get(0).getCardValue() > dealerTempDeck.get(0).getCardValue())
                {
                    // Player wins the round and takes both cards.
                    System.out.println("You win the round!");
                    playerTempDeck.set(getFirstEmptyIndex(playerTempDeck), dealerTempDeck.get(0));
                    playerTempDeck.set(getFirstEmptyIndex(playerTempDeck), playerTempDeck.get(0));
                    moveElements(dealerTempDeck);
                    moveElements(playerTempDeck);
                }
                // Checks for a tie (war scenario).
                else if (playerTempDeck.get(0).getCardValue() == dealerTempDeck.get(0).getCardValue())
                {
                    // Initiates the war scenario.
                    System.out.println("WAR");
                    System.out.println("Would you like to continue?");
                    input.nextLine();
                    startWar(playerTempDeck, dealerTempDeck);
                }
                // Dealer wins the round and takes both cards.
                else if (playerTempDeck.get(0).getCardValue() < dealerTempDeck.get(0).getCardValue())
                {
                    System.out.println("You lost the round!");
                    dealerTempDeck.set(getFirstEmptyIndex(dealerTempDeck), playerTempDeck.get(0));
                    dealerTempDeck.set(getFirstEmptyIndex(dealerTempDeck), dealerTempDeck.get(0));
                    moveElements(dealerTempDeck);
                    moveElements(playerTempDeck);
                }

                // Prints the player's deck after the round.
                System.out.print("Player's deck: ");
                for (Card card : thePlayer.getCardDeck()) 
                {
                    if (card != null) 
                    {
                        System.out.print(card.getCardName() + ", ");
                    }
                }
                // Prints the dealer's deck after the round.
                System.out.print("Dealer's deck: ");
                for (Card card : theDealer.getCardDeck()) {
                    if (card != null) 
                    {
                        System.out.print(card.getCardName() + ", ");
                    }
                }

                // Checks if the player or dealer has all the cards or none, to determine the winner.
                if (getLastIndex(playerTempDeck) == sizeOfDeck*numberOfDeck || getLastIndex(dealerTempDeck) == 0)
                {
                    playerWins = true;
                }
                else if (getLastIndex(dealerTempDeck) == sizeOfDeck*numberOfDeck || getLastIndex(playerTempDeck) == 0)
                {
                    dealerWins = true;
                }
                else
                {
                    // Informs the user that all cards will be shuffled.
                    System.out.println("All cards get shuffled");

                    // If shuffling is enabled and cheating is not, shuffle both decks.
                    if (enableShuffling && !enableCheating)
                    {
                        // Casts the player and dealer to their respective classes for shuffling.
                        Player1 playerCasted = (Player1) thePlayer;
                        Dealer dealerCasted = (Dealer) theDealer;

                        // Shuffles half of the red and black cards for player and dealer.
                        playerTempDeck = playerCasted.shuffleHalfRedCards(playerTempDeck);
                        dealerTempDeck = dealerCasted.shuffleHalfBlackCards(dealerTempDeck);
                        
                        // Prints the player's deck after shuffling.
                        System.out.print("Player's deck: ");
                        for (Card card : thePlayer.getCardDeck()) 
                        {
                            if (card != null) 
                            {
                                System.out.print(card.getCardName() + ", ");
                            }
                        }
                        System.out.println(thePlayer.getCardDeck().get(0).getCardValue());

                        // Prints the dealer's deck after shuffling.
                        System.out.print("Dealer's deck: ");
                        for (Card card : theDealer.getCardDeck()) {
                            if (card != null) 
                            {
                                System.out.print(card.getCardName() + ", ");
                            }
                        }
                    }
                    // If shuffling and cheating are both enabled, shuffle using CheatPlayer.
                    else if (enableShuffling && enableCheating)
                    {
                        // Casts the player and dealer to their respective classes for shuffling.
                        CheatPlayer playerCasted = (CheatPlayer) thePlayer;
                        Dealer dealerCasted = (Dealer) theDealer;

                        // Shuffles half of the red and black cards for player and dealer.
                        playerTempDeck = playerCasted.shuffleHalfRedCards(playerTempDeck);
                        dealerTempDeck = dealerCasted.shuffleHalfBlackCards(dealerTempDeck);
                    }

                    // Prints the player's deck after shuffling.
                    System.out.print("Player's deck: ");
                    for (Card card : thePlayer.getCardDeck()) 
                    {
                        if (card != null) 
                        {
                            System.out.print(card.getCardName() + ", ");
                        }
                    }
                    System.out.println(thePlayer.getCardDeck().get(0).getCardValue());

                    // Prints the dealer's deck after shuffling.
                    System.out.print("Dealer's deck: ");
                    for (Card card : theDealer.getCardDeck()) {
                        if (card != null) 
                        {
                            System.out.print(card.getCardName() + ", ");
                        }
                    }

                    // Prints a blank line for formatting.
                    System.out.println();
                }

                // Prompts the user if they would like to continue to the next round.
                System.out.println("Would you like to continue?");
                input.nextLine();

                // Checks if the player has won the round.
                if (playerWins)
                {
                    // Player wins, updates balances and ends the round.
                    System.out.println("You win the round!");
                    System.out.println("You've gained $" + dealerBetAmount + "!");
                    thePlayer.addBalance(dealerBetAmount);
                    theDealer.deductBalance(dealerBetAmount);
                    gameLoop = false;
                }
                // Checks if the dealer has won the round.
                else if (dealerWins)
                {
                    // Dealer wins, updates balances and ends the round.
                    System.out.println("You lost the round! The Dealer wins!");
                    System.out.println("You've losted $" + playerBetAmount + "!");
                    thePlayer.deductBalance(playerBetAmount);
                    theDealer.addBalance(playerBetAmount);
                    gameLoop = false;
                }
            }
            // Checks if both the player and dealer have money to play another round.
            if (thePlayer.getBalance() > 0 && theDealer.getBalance() > 0)
            {
                // Prompts the user if they want to play another round.
                System.out.println("Would you like to play another round? Yes or No");
                String redo = input.nextLine();
                // If yes, the game restarts.
                if (redo.equalsIgnoreCase("Yes"))
                {
                    playAgain = true;
                }
                // If no, the game ends and prints the results.
                else
                {
                    playAgain = false;
                    System.out.println("The game has ended. Results:");
                    // Checks if the player has won the game.
                    if (thePlayer.getBalance() > theDealer.getBalance())
                    {
                        System.out.println("You have won the game!");
                    }
                    // Checks if the game is a tie.
                    else if (theDealer.getBalance() == thePlayer.getBalance()) 
                    {
                        System.out.println("This game ends in a tie!");
                    }
                    // If not, the player has lost the game.
                    else
                    {
                        System.out.println("You have lost the game!");
                        // Prints the player's deck.
                        System.out.print("Player's deck: ");
                        for (Card card : thePlayer.getCardDeck()) 
                        {
                            if (card != null) 
                            {
                                System.out.print(card.getCardName() + ", ");
                            }
                        }
                        System.out.println(thePlayer.getCardDeck().get(0).getCardValue());

                        // Prints the dealer's deck.
                        System.out.print("Dealer's deck: ");
                        for (Card card : theDealer.getCardDeck()) {
                            if (card != null) 
                            {
                                System.out.print(card.getCardName() + ", ");
                            }
                        }
                    }
                }
            }
            // If either player or dealer is out of money, the game ends and prints the results.
            else
            {
                playAgain = false;
                System.out.println("The game has ended. Results:");
                // Checks if the player has won the game.
                if (thePlayer.getBalance() > theDealer.getBalance())
                {
                    System.out.println("You have won the game!");
                }
                // Checks if the game is a tie.
                else if (theDealer.getBalance() == thePlayer.getBalance()) 
                {
                    System.out.println("This game ends in a tie!");
                }
                // If not, the player has lost the game.
                else
                {
                    System.out.println("You have lost the game!");
                    // Prints the player's deck.
                    System.out.print("Player's deck: ");
                    for (Card card : thePlayer.getCardDeck()) 
                    {
                        if (card != null) 
                        {
                            System.out.print(card.getCardName() + ", ");
                        }
                    }
                    System.out.println(thePlayer.getCardDeck().get(0).getCardValue());

                    // Prints the dealer's deck.
                    System.out.print("Dealer's deck: ");
                    for (Card card : theDealer.getCardDeck()) {
                        if (card != null) 
                        {
                            System.out.print(card.getCardName() + ", ");
                        }
                    }
                }
            }
        }
    }
    // Moves all elements in the given ArrayList one position to the left, simulating card removal.
    public static void moveElements(ArrayList<Card> list)
    {
        for (int i = 1; i < list.size(); i++)
        {
            list.set(i-1, list.get(i));
        }
    }
    // Returns the index of the first empty (null) element in the given list of cards.
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

    // Returns the count of non-null elements in the ArrayList, representing the number of cards.
    public static int getLastIndex(ArrayList<Card> list)
    {
        int count = 0;
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i) != null)
            {
                count++;
            }
        }
        return count;
    }
    // Debug method that prints out the card names in two arrays for player and dealer.
    public static void debugArray(Card[] arr1, Card[] arr2)
    {
        // Prints the player's card deck.
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
        // Prints the dealer's card deck.
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
    // Handles the "war" scenario when both player and dealer draw cards of equal value.
    public static void startWar(ArrayList<Card> arr1, ArrayList<Card> arr2)
    {
        int index = 3;
        boolean war = true;
        while (war)
        {
            // Checks for nulls or out-of-bounds to avoid exceptions during war.
            if (index >= arr1.size() || index >= arr2.size() || arr1.get(index) == null || arr2.get(index) == null) 
            {
                System.out.println("Not enough cards to continue war!");
                war = false;
            }
            else
            {
                // Player wins the war round.
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
                // Dealer wins the war round.
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
                // Tie, continue war with more cards.
                else
                {
                    System.out.println("You and the Dealer tied the War round!");
                    index += 4;
                }
            }
            
        }
    }

    // Returns the total size of all decks combined.
    public static int getTotalSize()
    {
        return totalDeckSize;
    }
}