import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
   List<Player> players = new ArrayList<>();
    Dicevalues roll = new Dicevalues(); //Initialize the dice roll
    
    Scanner s = new Scanner(System.in); 

    System.out.println("Hello and Welcome to the Monopoly Game Junior! Enter the number of players: ");

    int numPlayer = s.nextInt(); 

    if (numPlayers >= 2 && numPlayers <= 4) {

        for(int i = 1; i <= numPlayers; i++ ){
            players.add(new Player("Player " + i));
        }

    }
}
}
