import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class test1 implements ActionListener
{
    // int variable for setting up the stage
    private int stage = 0;

    // Instantiates the JLabel object as mainText1
    private JLabel mainText1 = new JLabel("<html>Welcome to Casino War Game!<br>Click yes to play game</html>");
    private JLabel mainText2 = new JLabel("<html>Enter your name:</html>");

    // Instantiates the JButton object as jBtnYes andjBtnNo
    private JButton jbtnYes = new JButton("Yes");
    private JButton jbtnNo = new JButton("No");

    // Load the original image for the player side
    private ImageIcon playerIcon = new ImageIcon("res/Player/nonePlayer.png");
    private JLabel imageLabelPlayer = new JLabel(playerIcon);

    // Load the original image for the dealer side
    private ImageIcon dealerIcon = new ImageIcon("res/Dealer/noneDealer.png");
    private JLabel imageLabelDealer = new JLabel(dealerIcon);

    // Scale the image to half its original size
    private int scaledWidth = playerIcon.getIconWidth() / 2;
    private int scaledHeight = playerIcon.getIconHeight() / 2;
    
    // Instantiates Image
    private Image scaledImagePlayer = playerIcon.getImage().getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
    private Image scaledImageDealer = dealerIcon.getImage().getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);

    // Instantiates ImageIcon objects
    private ImageIcon scaledIconPlayer = new ImageIcon(scaledImagePlayer);
    private ImageIcon scaledIconDealer = new ImageIcon(scaledImageDealer);

    // Gets the screen size of the computing device
    private java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    private int screenWidth = screenSize.width;
    private int screenHeight = screenSize.height;
    
    // Creates new JFrame container
    private JFrame jfrm = new JFrame("Casino War Game with GUI");

    // Creates a text input field
    private JTextField nameInput = new JTextField();

    // String variable
    private String playerName = nameInput.getText();

    // Creates a text input field for number
    private JTextField numberInput = new JTextField();

    // duckNum int variable to get the numberInput text
    private int deckNum = 0;

    // Main method
    public static void main(String args[])
    {
        // Creates the frame on the event dispatching thread
        SwingUtilities.invokeLater(new Runnable()
        {
            // Creates a new test1 object constructor
            public void run()
            {
                new test1();
            }
        });
    }

    // test1 constructor
    public test1()
    {
        // Give frame an initial size
        jfrm.setSize(screenWidth, screenHeight);

        // Terminate the program when the user closes the application
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout to null for absolute positioning
        jfrm.setLayout(null);
        
        // Set the position and size of the image label player
        imageLabelPlayer.setBounds((screenWidth/2) - 400, 1000, scaledWidth, scaledHeight);

        // Sets the imageLabel to the scaled player image
        imageLabelPlayer.setIcon(scaledIconPlayer);

        // Set the position and size of the image label dealer
        imageLabelDealer.setBounds((screenWidth/2) + 100, 1000, scaledWidth, scaledHeight);

        // Sets the imageLabel to the scaled dealer image
        imageLabelDealer.setIcon(scaledIconDealer);
        
        // Change font: new Font(fontName, style, size)
        mainText1.setFont(new Font("Arial", Font.BOLD, 24));

        // Set the position and size of the label (x, y, width, height)
        mainText1.setBounds((screenWidth/2) - 200, 30, 2000, 75);

        // Change font: new Font(fontName, style, size)
        mainText2.setFont(new Font("Arial", Font.BOLD, 24));

        // Set the position and size of the label (x, y, width, height)
        mainText2.setBounds((screenWidth/2) + 200, 3000, 2000, 75);

        // Set the position and size of the button
        jbtnYes.setBounds((screenWidth/2) - 200, 125, 150, 50);

        // Sets the position and size of the nameInput text field
        nameInput.setBounds((screenWidth/2) - 200, 2050, 150, 50);

        // Sets the position and size of the nameInput text field
        numberInput.setBounds((screenWidth/2) - 200, 2050, 150, 50);

        // Set the position and size of the button
        jbtnNo.setBounds((screenWidth/2), 125, 150, 50);

        // Adds the actionlisteners to the buttons
        jbtnYes.addActionListener(this);
        jbtnNo.addActionListener(this);

        // Add the image label player to the frame
        jfrm.add(imageLabelPlayer);

        // Add the image label dealer to the frame
        jfrm.add(imageLabelDealer);

        // Add the JLabel text to the frame
        jfrm.add(mainText1);

        // Add the JLabel text to the frame
        jfrm.add(mainText2);

        // Adds nameInput to the frame
        jfrm.add(nameInput);

        // Adds number to the frame
        jfrm.add(numberInput);

        // Add the JButton to the frame
        jfrm.add(jbtnYes);

        // Add the JButton to the frame
        jfrm.add(jbtnNo);

        // Display the frame
        jfrm.setVisible(true);
    }
    
    // Event Handler method
    public void actionPerformed(ActionEvent event)
    {
        // First calls method called startGame
        startGame(event);
    }

    // Method to update the dealer image with a new file path
    public void setDealerImage(String filepath) 
    {
        dealerIcon = new ImageIcon(filepath);
        // Scale the new image
        Image scaledImage = dealerIcon.getImage().getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        imageLabelDealer.setIcon(scaledIcon);
        imageLabelDealer.repaint();
    }

    // Method to update the dealer image with a new file path
    public void setPlayerImage(String filepath) 
    {
        // playerIcon gets a new ImageIcon
        playerIcon = new ImageIcon(filepath);
        // Scale the new image
        Image scaledImage = playerIcon.getImage().getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
        // ScaledIcon is instantiated as a ImageIcon object
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        // Sets the image to a new scaledIcon
        imageLabelPlayer.setIcon(scaledIcon);
        // Repaints the image
        imageLabelPlayer.repaint();
    }
    
    // Method that starts the game in it's start stage
    public void startGame(ActionEvent anEvent)
    {
        // Conditional if the No button is clicked and the stage is 0
        // then the stage is incremented and the jframe is disposed
        if (anEvent.getActionCommand().equals("No") && stage == 0)
        {
            stage++;
            jfrm.dispose();
        }
        // Conditional if the Yes button is clicked and the stage is 0
        else if (anEvent.getActionCommand().equals("Yes") && stage == 0)
        {
            stage++;

            // Calls the method setMainText
            mainText1.setText(stage + "");

            // Set the position and size of the image label player
            imageLabelPlayer.setBounds((screenWidth/2) - 400, 200, scaledWidth, scaledHeight);

            // Set the position and size of the image label dealer
            imageLabelDealer.setBounds((screenWidth/2) + 100, 200, scaledWidth, scaledHeight);

            // Show the name input and mainText2
            nameInput.setBounds((screenWidth/2) + 200, 90, 150, 50);
            // Do not get playerName here; wait until user submits
            mainText2.setBounds((screenWidth/2) + 200, 30, 2000, 75);
        }
        // Conditional if the Yes button is clicked and the stage is 1
        else if (anEvent.getActionCommand().equals("Yes") && stage == 1)
        {
            // Stage gets incremented
            stage++;
            
            // Playername gets the text of nameInput
            playerName = nameInput.getText(); // Get the name after user input
            
            // Conditional that makes the computer hates any person that has their name start with the letter h
            if (playerName.substring(0,1).equalsIgnoreCase("h"))
                playerName = "Hello " + nameInput.getText() + "! Also please shut up";
            else
                playerName = "Hello " + nameInput.getText() + "! You are not welcome btw"; // Get the name after user input

            // Calls method setMainText
            mainText1.setText(playerName);

            // Sets the mainText2 to a different position
            mainText2.setBounds((screenWidth/2) + 200, 3000, 2000, 75);

            // Sets the name input text field to a different position
            nameInput.setBounds((screenWidth/2) + 200, 9000, 150, 50);
        }
        // Conditional if the No button is clicked and the stage is 1
        else if (anEvent.getActionCommand().equals("No") && stage == 1)
        {
            // Stage gets incremented
            stage++;
            
            // Playername gets the text of nameInput
            playerName = "I DID NOT ASK FOR A NO " + nameInput.getText().toUpperCase() + "!"; // Get the name after user input

            // Calls method setMainText
            mainText1.setText(playerName);

            // Sets the mainText2 to a different position
            mainText2.setBounds((screenWidth/2) + 200, 3000, 2000, 75);

            // Sets the name input text field to a different position
            nameInput.setBounds((screenWidth/2) + 200, 9000, 150, 50);
        }
        // Conditional if the Yes button is clicked and the stage is 2
        // then the stage is incremented
        else if ((anEvent.getActionCommand().equals("Yes") || anEvent.getActionCommand().equals("No"))  && stage == 2)
        {
            // Stage gets incremented
            stage++;
            
            // Sets the mainText
            mainText1.setText("Would you like to play the game?");
        }
        // Conditional if the Yes or No button is clicked and the stage is 3
        else if ((anEvent.getActionCommand().equals("Yes") || anEvent.getActionCommand().equals("No"))  && stage == 3)
        {
            // Stage gets incremented
            stage++;

            // Show mainText2 and change both maintexts
            if (anEvent.getActionCommand().equals("No"))
            {
                mainText1.setBounds((screenWidth/2) - 600, 30, 2000, 75);
                mainText1.setText("YOU ARE GOING TO PLAY GAME Answer question on right"); 
            }
            else
            {
                mainText1.setText("Answer question on right"); 
            }
            // Chnages font of mainText2 then changes mainText2's text and change its position            
            mainText2.setFont(new Font("Arial", Font.BOLD, 15));
            mainText2.setText("Enter a deck number (even numbers only)");
            mainText2.setBounds((screenWidth/2) + 200, 30, 2000, 75);
            // Show number input
            numberInput.setBounds((screenWidth/2) + 200, 90, 150, 50);

           

        }
        // Conditional if the Yes or No button is clicked and the stage is 4
        else if ((anEvent.getActionCommand().equals("Yes") || anEvent.getActionCommand().equals("No"))  && stage == 4)
        {
            // Increment stage
            stage++;
            // Stores the text of the text input into getNumber Stirng
            String getNumber = numberInput.getText();
            // Exception handling
            try 
            {
                // deckNum gets the parseInt of getNumber
                deckNum = Integer.parseInt(getNumber);
            }
            catch (NumberFormatException e)
            {
                // If the string does not contain a number, then deckNum gets integer 2
                // and the exception is printed
                deckNum = 2;
                System.out.println(e.getMessage());
            }
            mainText1.setBounds((screenWidth/2) - 200, 30, 2000, 75);
            mainText1.setText("Magic number: " + deckNum); 
        }
    }
}