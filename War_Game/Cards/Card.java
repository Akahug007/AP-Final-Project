// Package declaration for Cards
package Cards;

// Interface for Card functionality
// Defines methods that all Card classes must implement
interface CardInterface
{
    // Method to get the card's value
    public int getCardValue();
    // Method to get the card's name
    public String getCardName();
}

// Card class, where it creates card objects
public class Card implements CardInterface
{
    // Numbers that represent type of cards that do not contain a number: 
    // 11 - Jack 
    // 12 - Queen 
    // 13 - King 
    // 14 - Ace

    // Instance variable for the card's number
    private int theCardNumber = 0;
    // Instance variable indicating if the card color is red
    private boolean isCardColorRed = true;
    // Instance variable for the card's name
    private String CardName = "";
    // Instance variable for the card's color
    private String CardColor = "";

    // Default constructor for Card class
    public Card()
    {
        // Initializes CardName to an empty string
        CardName = "";
        // Initializes theCardNumber to 0
        theCardNumber = 0;
        // Initializes isCardColorRed to true
        isCardColorRed = true;
    }

    // Setter method to set the card number with a random number between 14 and 2
    public void setCardValue()
    {
        // cardNumber gets declared and initialized with a random number between 1 and 13
        int cardNumber = (int)(Math.random()*12 + 1);
        // theCardNumber is set to cardNumber
        theCardNumber = cardNumber;
        // Calls the setCardName method with the cardNumber as an argument
        setCardName(cardNumber);
    }

    // Setter method to set the card number with a directly implicit number
    public void setCardValue(int num, String color)
    {
        // cardNumber gets declared and initialized with num
        int cardNumber = num;
        // Sets theCardNumber to cardNumber
        this.theCardNumber = cardNumber;
        // Sets CardColor to color
        this.CardColor = color;
        // Calls the setCardName method with the cardNumber as an argument
        setCardName(cardNumber);

        // Conditional that sets the isCardColorRed to either
        // true if color is red or false otherwise
        if (color.equalsIgnoreCase("red"))
        {
            isCardColorRed = true;
        }
        else
        {
            isCardColorRed = false;
        }
    }

    // Setter method to set the card display name
    public void setCardName(int cardNumber)
    {
        // Switch statement to set the card name based on the card number
        switch(cardNumber)
        {
            // If cardNumber is 1, randomly select another card number between 2 and 13
            case 1:
                int randomCard = (int)(Math.random() * 12 + 2);
                setCardName(randomCard);
                break;
            // If cardNumber is 2, set CardName to "Two"
            case 2:
                CardName = "Two";
                break;
            // If cardNumber is 3, set CardName to "Three"
            case 3:
                CardName = "Three";
                break;
            // If cardNumber is 4, set CardName to "Four"
            case 4:
                CardName = "Four";
                break;
            // If cardNumber is 5, set CardName to "Five"
            case 5:
                CardName = "Five";
                break;
            // If cardNumber is 6, set CardName to "Six"
            case 6:
                CardName = "Six";
                break;
            // If cardNumber is 7, set CardName to "Seven"
            case 7:
                CardName = "Seven";
                break;
            // If cardNumber is 8, set CardName to "Eight"
            case 8:
                CardName = "Eight";
                break;
            // If cardNumber is 9, set CardName to "Nine"
            case 9:
                CardName = "Nine";
                break;
            // If cardNumber is 10, set CardName to "Ten"
            case 10:
                CardName = "Ten";
                break;
            // If cardNumber is 11, set CardName to "Jack"
            case 11:
                CardName = "Jack";
                break;
            // If cardNumber is 12, set CardName to "Queen"
            case 12:
                CardName = "Queen";
                break;
            // If cardNumber is 13, set CardName to "King"
            case 13:
                CardName = "King";
                break;
            // If cardNumber is 14, set CardName to "Ace"
            case 14:
                CardName = "Ace";
                break;
            // Default case, set theCardNumber to 2 and CardName to "Two"
            default:
                theCardNumber = 2;    
                CardName = "Two";
                break;
        }
    }

    // Setter method to set the card color
    public void setCardColor(String color)
    {
        // Sets CardColor to color
        this.CardColor = color;
    }

    // Getter method to return Card Number
    public int getCardValue()
    {
        // Returns theCardNumber
        return theCardNumber;
    }
    
    // Getter method to return Card Name
    public String getCardName()
    {
        // Returns CardName
        return CardName;
    }

    // Getter method to return the card's color
    public String getCardColor()
    {
        // Returns CardColor
        return CardColor;
    }
}
