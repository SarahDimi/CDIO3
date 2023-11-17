package Main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Player> players = new ArrayList<>();
        int numPlayers = 0;

        System.out.println("Hello and welcome to Monopoly Junior! If you are ready to play, write: 'yes' in the terminal!");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("yes")) {
            while (numPlayers < 2 || numPlayers > 4) {
                System.out.print("Enter the number of players (2-4): ");
                if (scanner.hasNextInt()) {
                    numPlayers = scanner.nextInt();
                    if (numPlayers < 2 || numPlayers > 4) {
                        System.out.println("Invalid number of players! The number of players must be between 2 and 4.");
                    }
                } else {
                    System.out.println("Please enter a number between 2 and 4.");
                    scanner.next(); // Clear the invalid input
                }
            }

            // Initialize players
            for (int i = 1; i <= numPlayers; i++) {
                System.out.print("Enter the name for Player " + i + ": ");
                String playerName = scanner.next();
                PlayerPiece playerPiece = new PlayerPiece(playerName); // Assuming constructor for PlayerPiece
                Account account = new Account(20000); // Assuming constructor for Account
                players.add(new Player(playerName, playerPiece, account, numPlayers));
            }

            // Initialize Board and ChanceCard
            Board board = new Board();
            ChanceCard chanceCard = new ChanceCard();

            // Game Loop - Fixed Number of Rounds Example
            int maxRounds = 30; // Example number of rounds
            int currentRound = 0;

            while (currentRound < maxRounds) {
            for (Player player : players) {
                System.out.println(player.getName() + "'s turn.");

                // Roll dice
                int diceRoll = random.nextInt(6) + 1; // Rolls a dice (1-6)
                System.out.println(player.getName() + " rolls a " + diceRoll);

                // Move player
                int boardSize = board.getBoardSize(40); // Assuming getBoardSize() method in Board class
                player.updatePosition(diceRoll, boardSize); // Assuming updatePosition method in Player class
                System.out.println(player.getName() + " moves to position " + player.getPosition());


                System.out.println(player.getName() + "'s turn ends.");
            }
            currentRound++;
            System.out.println("Round " + currentRound + " ends.");
        }

        System.out.println("Game Over after " + maxRounds + " rounds!");
        scanner.close();

        while(true){
            
        }
    
    }
}
