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

    if (numPlayer >= 2 && numPlayer <= 4) {

        for(int i = 1; i <= numPlayer; i++ ){
            players.add(new Player("Player " + i));
        } 
    } else {
        System.out.println("Invalid number of players! Try again. The maximum amount is 4, and the minimum is 2.");
    }

    scanner.close();
}
}
