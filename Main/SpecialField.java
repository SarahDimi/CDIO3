package Main;

public class SpecialField {

    protected String name;

        public SpecialField(String name) {

        }

    public static class VisitJail extends SpecialField {
        public VisitJail() {
            super("Visit Jail"); // Example parameters
        }
    
        public void visitJail(Player player){
            System.out.println(player.getName() + " is just visiting jail.");
        }
    }
    

   public static class FreeParking extends SpecialField {
        public FreeParking() {
            super("Free Parking"); // Example parameters
        }
    
        public void park(Player player){
            System.out.println(player.getName() + " its relaxing at Free Parking.");
        }
    }    

    public static class InJail extends SpecialField {
        public InJail() {
            super("In Jail"); // Example parameters
        }
    
        public void inJail(Player player){
            System.out.println(player.getName() + " is in jail!");
        }
    }
    

public static class StartField extends SpecialField {
    private static final int SALARY = 2; // Example salary amount

    public StartField() {
        super("Start"); // Example parameters
    }

    public void landOnStart(Player player) {
        System.out.println(player.getName() + " has landed on Start. Collecting $" + SALARY);
        player.deposit(SALARY);
    }

    public void passStart(Player player) {
        System.out.println(player.getName() + " has passed Start. Collecting $" + SALARY);
        player.deposit(SALARY);
    }
}

}

