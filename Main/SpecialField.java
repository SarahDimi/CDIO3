package Main;

public class SpecialField {

    protected String name;

        public SpecialField(String name) {

        }

        // Visit Jail.
    public static class VisitJail extends SpecialField {
        public VisitJail() {
            super("Visit Jail"); 
        }
    
        public void visitJail(Player player){
            System.out.println(player.getName() + " is just visiting jail.");
        }
    }
    
        //Free Parking.
   public static class FreeParking extends SpecialField {
        public FreeParking() {
            super("Free Parking"); 
        }
    
        public void park(Player player){
            System.out.println(player.getName() + " is relaxing at Free Parking.");
        }
    }    
        //In Jail.
    public static class InJail extends SpecialField {
        public InJail() {
            super("In Jail"); 
        }
    
        public void inJail(Player player){
            System.out.println(player.getName() + " is in jail!");
        }
    }
    
        //Start Field, with start salary and passing start salary.
public static class StartField extends SpecialField {
    private static final int SALARY = 2; // Salary amount

    public StartField() {
        super("Start"); 
    }

    public void landOnStart(Player player) {
        System.out.println(player.getName() + " has landed on Start. Collecting $" + SALARY);
        player.getAccount().deposit(SALARY);
    }

    public void passStart(Player player) {
        System.out.println(player.getName() + " has passed Start. Collecting $" + SALARY);
        player.getAccount().deposit(SALARY);
    }
}

}

// We have placed the special fields into a serperate file in order to keep better track of the code.
