package Main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private Board board;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPlayers = 0;
        

        System.out.println("Hello and Welcome to Monopoly Junior! If you are ready to play, write 'yes' in the terminal.");
        String answer = scanner.nextLine();

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

        List<Player> players = setupPlayers(scanner, numPlayers);
        Board board = new Board(); // Initialize the board
        Bank bank = new Bank(); // Initialize the bank
        ChanceCard chanceCard = new ChanceCard(); // Initialize ChanceCard
        Dice dice = new Dice(6); // Initialize a dice with 6 sides

        // Main game loop

        public static void playTurn(Player player, Dicevalues roll, Field fields, ChanceCard chancecard, Board board, Account acount, Bank bank, SpecialField specialField, PlayerPiece playerPiece){
             int diceRoll = dice.rollDice(); // Roll the dice
            player.updatePosition(diceRoll, board.getBoardSize()); // Update player's position
            Field landedField = board.getField(player.getPosition()); 
            applyCardEffect(player, playerPiece, landedField,)



        }
        while (!isGameOver(players)) {
            if(player.numberOfJailTurns <= 0){
            for (Player player : players) {
                // Player's turn
                int diceRoll = dice.rollDice(); // Roll the dice
                player.updatePosition(diceRoll, board.getBoardSize()); // Update player's position

                Field landedField = board.getField(player.getPosition()); 
                applyCardEffect(player, landedField, bank, board, chanceCard);
         }
                
                if (bank.checkBankruptcy(player)) {
                    System.out.println(player.getName() + " has gone bankrupt!");
                    break;
                }
            
              }else if(numberOfJailCards > 0){
                    numberOfJailCards -1;
                    numberOfJailTurns -1 ;
            } else{
                player.getAccount().withdraw(1);
                numberOfJailTurns -1;
        } }

        Player winner = determineWinner(players);
        System.out.println("Winner is: " + winner.getName());
        scanner.close();
    }

    private static List<Player> setupPlayers(Scanner scanner, int numPlayers) {
        List<Player> players = new ArrayList<>();
    
        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter the name for Player " + i + ": ");
            String name = scanner.nextLine();
            PlayerPiece playerPiece = new PlayerPiece(name); 
            Account account = new Account(20000); // Starting balance
            players.add(new Player(name, playerPiece, account, numPlayers));
        }
        return players;
    }

    private static boolean isGameOver(List<Player> players) {
        for (Player player : players) {
            if (player.getAccount().getBalance() <= 0) { 
                return true;
            }
        }
        return false;
    }

    private static void handleFieldActions(Player player, Field landedField, Bank bank, Board board, ChanceCard chanceCard) {
        // Implement logic based on field type and game rules
    }

    private static Player determineWinner(List<Player> players) {
        Player winner = null;
        int maxWealth = 0;
        for (Player player : players) {
            int wealth = player.getAccount().getBalance(); 
            // Add property values if needed
            if (wealth > maxWealth) {
                maxWealth = wealth;
                winner = player;
            }
        }
        return winner;
    }
}

