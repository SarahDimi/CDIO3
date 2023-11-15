package Main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello and Welcome to the Monopoly Game Junior! Enter the number of players: ");

        int numPlayers = scanner.nextInt();

        if (numPlayers >= 2 && numPlayers <= 4) {
            for (int i = 1; i <= numPlayers; i++) {
                System.out.print("Enter the name for Player " + i + ": ");
                String playerName = scanner.next();
                players.add(new Player(playerName));
            }
        } else {
            System.out.println("Invalid number of players! The number of players must be between 2 and 4.");
        }

        scanner.close();
    }
}