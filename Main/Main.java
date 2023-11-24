package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPlayers = 0;

        System.out.println("Hello and Welcome to Monopoly Junior! If you are ready to play, write 'yes' in the terminal.");
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
        } else {
            System.out.println("Exiting game.");
            scanner.close();
            return; // Exit the program if the player does not enter 'yes'
        }

        scanner.nextLine(); // Consume the newline after integer input

        // Opret spillerobjekter
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter the name for Player " + (i + 1) + ": ");
            String playerName = scanner.nextLine();
            
            // Opret PlayerPiece-objekt baseret på indtastningen
            System.out.print("Enter " + playerName + "'s piece (e.g., hat, car, etc.): ");
            String playerPieceName = scanner.nextLine();
            PlayerPiece playerPiece = new PlayerPiece(playerPieceName);
            

            // Opret Player-objekt og tilføj det til listen
            Player player = new Player(playerName, playerPiece, new Account(10), numPlayers, i + 1, i, i);
            players.add(player);
        }

        // Initialiser GameController med spillerne
        GameController gameController = new GameController(players);

        // Start spillet
        gameController.startGame();

        scanner.close();
    }
}


        