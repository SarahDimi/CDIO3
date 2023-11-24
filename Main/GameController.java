package Main;
import Main.SpecialField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GameController {

    private Board board;
    private Bank bank;
    private List<Player> players;
    private Dice dice;
    private boolean gameOver;
    private List<ChanceCard> chanceCards; // Tilføjet liste af chancekort

    

    public GameController(List<Player> players) {
        this.board = new Board();
        this.bank = new Bank();
        this.players = players;
        this.dice = new Dice(6); // Assuming 6-sided dice
        this.gameOver = false;
        this.chanceCards = initializeChanceCards(); // Initialiser chancekortene
    }

    public void startGame() {

        
        while (!gameOver) {
            for (Player player : players) {
                if (!player.isBankrupt()) {
                    System.out.println("Its "+ player.getName() +" turn");
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
        System.out.println("You have : "+ player.getAccount().getBalance()+ " money left");
        int roll = dice.rollDice();
        System.out.println("You have rolled a: " +roll);
        player.getPiece().moveForward(roll);
        int position = player.getPiece().getPosition() % board.getBoardSize();

        NormalField currentField = board.normalFields.get(position);

        if (currentField.getType().equals("property")) {
            handlePropertyField(player, (Field) currentField);

        } else if (currentField.getType().equals("special")) {
            handleSpecialField(player, (SpecialField) currentField);
        } else if (currentField.getType().equals("chance")) {
            drawChanceCard(player);
        }

         // Prompt to press Enter to end the turn
         Scanner turnScanner = new Scanner(System.in);
         System.out.println("Press Enter to end " + player.getName() + "'s turn.");
         System.out.println("--------------------------------");
         turnScanner.nextLine(); // Waits for the user to press Enter

    }


    private void handlePropertyField(Player player, Field propertyField) {
        if (propertyField.getOwner() == null) {
            // Property is not owned, allow the player to buy it
            bank.buyField(player, propertyField.getIndex(), propertyField.getPrice());
            System.out.println("You landed on: " + propertyField.getName() + " It is a: " + propertyField.getColor());
            player.addProperty(propertyField); // Add property to the player's list
        } else {
            // Property is already owned, handle rent
            Player owner = propertyField.getOwner();
            if (!owner.equals(player)) {
                // The player is not the owner, charge rent
                int rentAmount = propertyField.getRent();
                if (player.ownsAllPropertiesOfColor(propertyField.getColor())) {
                    rentAmount *= 2; // Double rent if the player owns all properties of this color
                }
                System.out.println("Pay rent of $" + rentAmount + " to " + owner.getName());
                Bank.payRent(player, owner, rentAmount);
            } else {
                // The player owns this property, no rent is charged
                System.out.println("You own this property. No rent is charged.");
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

    private void drawChanceCard(Player player) {
        if (!chanceCards.isEmpty()) {
            // Træk et chancekort og følg instruktionerne
            ChanceCard card = chanceCards.remove(0); // Fjern det trukne kort fra bunken
            String cardMessage = card.drawCard();
            card.applyCardEffect(player, cardMessage, player.getPiece().getPosition(), board, players);
    
            // Tilføj kortet tilbage til en tilfældig placering i bunken
            int randomPosition = (int) (Math.random() * (chanceCards.size() + 1)); // +1 to allow insertion at the end
            chanceCards.add(randomPosition, card);
    
            // Valgfrit: Bland bunken
            Collections.shuffle(chanceCards);
        } else {
            // Håndter situationen, hvor der ikke er flere kort i bunken
            System.out.println("No chance cards left to draw");
        }
    }
    
    private List<ChanceCard> initializeChanceCards() {
        List<ChanceCard> cards = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            cards.add(new ChanceCard("Chance Card " + (i + 1)));
        }
        return cards;
    }

    private void declareWinner() {
        Player winner = null;
        int highestNetWorth = -1; // Start med et lavt nummer
    
        for (Player player : players) {
            int playerNetWorth = player.getMoney();
    
            // Tæl værdien af spillerens ejendomme og læg til pengebeholdningen
            for (Field property : player.getProperties()) {
                playerNetWorth += property.getPrice();
                playerNetWorth += player.getAccount().getBalance();
            }
    
            if (playerNetWorth > highestNetWorth) {
                highestNetWorth = playerNetWorth;
                winner = player;
            } else if (playerNetWorth == highestNetWorth) {
            }
        }
    
        if (winner != null) {
            System.out.println("Player " + winner.getName() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
