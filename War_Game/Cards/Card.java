// Documentation
// Add GUI
// Fix the text code first

package Cards;
interface CardInterface
{
    public int getCardValue();
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
	// 15 - Joker

    // Instance Variables
    private int theCardNumber = 0;
    private boolean isCardColorRed = true;
    private String CardName = "";
    private String CardColor = "";

    public Card()
    {
        CardName = "";
        theCardNumber = 0;
        isCardColorRed = true;
    }

    // Setter methods:
    // Sets the card number with a random number between 14 and 2
    public void setCardValue()
    {
        // cardNumber gets declared and initialized with a random number between 1 and 43
        int cardNumber = (int)(Math.random()*12 + 1);

        // theCardNumber is set to cardNumber
        theCardNumber = cardNumber;

        // Calls the setCardName method with the cardNumber as an argument
        setCardName(cardNumber);
    }

    // Sets the card number with a directly implicit number
    public void setCardValue(int num)
    {
        // cardNumber gets decalred and initialized with num
        int cardNumber = num;

        // Calls the setCardName method with the cardNumber as an argument
        setCardName(cardNumber);
    }

    // Sets the card display name
    public void setCardName(int cardNumber)
    {
        // Switch statement to set the card name based on the card number
        switch(cardNumber)
        {
            case 1:
                int randomCard = (int)(Math.random() * 12 + 2);
                setCardName(randomCard);
                break;
            case 2:
                CardName = "Two";
                break;
            case 3:
                CardName = "Three";
                break;
            case 4:
                CardName = "Four";
                break;
            case 5:
                CardName = "Five";
                break;
            case 6:
                CardName = "Six";
                break;
            case 7:
                CardName = "Seven";
                break;
            case 8:
                CardName = "Eight";
                break;
            case 9:
                CardName = "Nine";
                break;
            case 10:
                CardName = "Ten";
                break;
            case 11:
                CardName = "Jack";
                break;
            case 12:
                CardName = "Queen";
                break;
            case 13:
                CardName = "King";
                break;
            case 14:
                CardName = "Ace";
                break;
            // case 15:
            //     CardName = "Joker";
            //     break;
            default:
                theCardNumber = 2;    
                CardName = "Two";
                break;
        }
    }

    // Getter methods:
    // Returns Card Number
    public int getCardValue()
    {
        return theCardNumber;
    }
    
    // Returns Card Name
    public String getCardName()
    {
        return CardName;
    }

    // Access method that returns the card's boolean variable
    public String getCardColor()
    {
        return CardColor;
    }
    // Accessor method that returns the card location/filepath
    // public String getCardLocation()
    // {
    //     return CardTypeLocation;
    // }
    // // Mutator method that sets the card filepath
    // public String setCardLocation()
    // {
    //     return CardTypeLocation;
    // }
    

}
