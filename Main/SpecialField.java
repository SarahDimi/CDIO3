package Main;

public class SpecialField {
    
    public class VisitJail {
    public Void visitJail(){
            System.out.println("Enjoy your visit at jail");
        
    }
}
public class FreeParking {
    public void Parking(){
            System.out.println("Lazy fuck wait here");
    }
}

public class InJail {
    public void inJail(){
        System.out.println("You got busted with a kilo of coke, go straight to jail");
    }
}

public class StartField {

    private static final int SALARY = 2; // Constant salary amount for passing the start

    public void Start(Player player) {
        // When a player lands on Start, they collect a salary
        System.out.println(player.getName() + " has landed on Start. Collecting $" + SALARY);
        player.deposit(SALARY); // Assuming the Player class has a method to add money
    }

    public void passStart(Player player) {
        // When a player passes Start, they collect a salary
        System.out.println(player.getName() + " has passed Start. Collecting $" + SALARY);
        player.deposit(SALARY); // Assuming the Player class has a method to add money
    }
}

}
