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
        
        NormalField currentField = board.normalFields.get(position);

        if (currentField.getType().equals("property")) {
            handlePropertyField(player, (Field) currentField);
        } else if (currentField.getType().equals("special")) {
            handleSpecialField(player, (SpecialField) currentField);
        }
    }

    private void handlePropertyField(Player player, Field propertyField) {
        if (propertyField.getOwner() == null) {
          
                bank.buyField(player, propertyField.getIndex(), propertyField.getPrice());
            }
         else {
            // Field is owned, player must pay rent to the owner
            Player owner = propertyField.getOwner();
            int rentAmount = propertyField.getRent();

            if (owner.equals(player)) {
                System.out.println("You own this property. No rent is charged.");
            } else {
                System.out.println("Pay rent of $" + rentAmount + " to " + owner.getName());
                bank.payRent(player, owner, rentAmount);
            }
        }
    }

    private void handleSpecialField(Player player, SpecialField specialField) {
        String fieldType = specialField.getName();

        switch (fieldType) {
            case "Visit Jail":
                specialField.visitJail(player);
                break;
            case "Free Parking":
                specialField.park(player);
                break;
            case "In Jail":
                specialField.inJail(player);
                break;
            case "Start":
                specialField.landOnStart(player);
                break;
            default:
                System.out.println("Unhandled special field type: " + fieldType);
        }
    }

    private void declareWinner() {
        // Implement logic to declare the winner based on some criteria
    }
}
