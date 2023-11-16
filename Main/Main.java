package Main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numPlayers = 0;

        // Welcome message and game start confirmation
        System.out.println("Hello and welcome to Monopoly Junior! If you are readu to play, write: " + "'yes' " + "in the terminal!");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("yes")) {
        
        //Initialize the game with the corect amount of players
        while (numPlayers < 2 || numPlayers > 4) {
            System.out.print("Enter the number of players (2-4): ");
            if (scanner.hasNextInt()) {
                numPlayers = scanner.nextInt();
                if (numPlayers < 2 || numPlayers > 4) {
                    System.out.println("Invalid number of players! The number of players must be between 2 and 4.");
                }
            } else {
                System.out.println("Please enter a number between 2 and 4: ");
                scanner.next(); // Will loop the invalid input
            }
        }

        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter the name for Player " + i + ": ");
            String playerName = scanner.next();
            PlayerPiece playerPiece = new PlayerPiece(playerName); // Assuming default constructor
            Account account = new Account(20000); // Assuming default constructor
            players.add(new Player(playerName, playerPiece, account, numPlayers));
        }

        scanner.close();

    
    }
}
}