package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {
    private Board board;
    private Bank bank;
    private List<Player> players;
    private Dice dice;
    private boolean gameOver;

    public GameController() {
         Scanner scanner = new Scanner(System.in);
        int numPlayers = 0;
        
        //Initializes game with welcome message
        System.out.println("Hello and Welcome to Monopoly Junior! If you are ready to play, write 'yes' in the terminal.");
        String answer = scanner.nextLine();

        //Gets the name of the players
        if(answer.equalsIgnoreCase("yes")){
            while(numPlayers < 2 || numPlayers > 4){
                System.out.print("Enter the number of players (2-4): ");
                if(scanner.hasNextInt()){
                    numPlayers = scanner.nextInt();
                    if(numPlayers < 2 || numPlayers > 4){
                        System.out.println("Invalid number of players! The number of players must be between 2 and 4."); 
                    }
                } else {
                    System.out.println("Please enter a number between 2 and 4.");
                    scanner.next(); // Clear the invalid input
                }
            }
        } else {
            System.out.println("Exiting game.");
            scanner.close();
            return; // Exit the program if the player does not enter 'yes'
        }

        scanner.nextLine(); // Consume the newline after integer input
    
    }

    public GameController(List<Player> players) {
        this.board = new Board();
        this.bank = new Bank();
        this.players = players;
        this.dice = new Dice(6); // Assuming 6-sided dice
        this.gameOver = false;
    }

    public void startGame() {
        while (!gameOver) {
            for (Player player : players) {
                if (!player.isBankrupt()) {
                    takeTurn(player);
                } else {
                    gameOver = true;
                    break;
                }
            }
        }
        declareWinner();
    }

    private void takeTurn(Player player) {
        int roll = dice.rollDice();
        player.getPiece().moveForward(roll);
        int position = player.getPiece().getPosition() % board.getBoardSize();

        handleFieldAction(player, position);
        // Additional logic for double rent, etc.
    }

    private void handleFieldAction(Player player, int position) {
        // The actual implementation will depend on how you differentiate between field types
        // Assuming you have a way to check if a field is a property, chance, or special field
        Field currentField = board.getField(position);

        // Check field type and take action
        // You'll need to add methods or properties to your Field class to support this
        if (currentField.isPropertyField()) {
            handlePropertyField(player, currentField);
        } else if (currentField.isChanceField()) {
            handleChanceField(player);
        } else if (currentField.isSpecialField()) {
            handleSpecialField(player, currentField);
        }
    }

    private void handlePropertyField(Player player, Field propertyField) {
        int fieldIndex = propertyField.getFieldIndex(); // Assuming getFieldIndex method exists
        Player owner = Bank.getFieldOwner(fieldIndex);
    
        if (owner == null) {
            // Offer the player the option to buy the property
            // ...
        } else if (!owner.equals(player)) {
            // Pay rent to the owner
            int rent = propertyField.getRent(); // Assuming getRent method exists
    
            if (ownerOwnsAllInGroup(owner, propertyField)) {
                rent *= 2; // Double the rent
            }
    
            player.getAccount().withdraw(rent);
            owner.getAccount().deposit(rent);
            // Display rent payment information
        }
    }
    private boolean ownerOwnsAllInGroup(Player owner, Field propertyField) {
        String group = propertyField.getGroup();
        for (Field field : board.getFields()) { // Assuming getFields returns all fields on the board
            if (field.getGroup().equals(group)) {
                if (!Bank.fieldOwnership.getOrDefault(field.getFieldIndex(), null).equals(owner)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void handleChanceField(Player player) {
        // Implement chance card drawing and effect
    }

    private void handleSpecialField(Player player, Field specialField) {
        // Implement special field logic (Go to Jail, Free Parking, etc.)
    }

    private void declareWinner() {
        // Logic to determine and declare the winner
    }

    // Additional methods as needed...
}
}

