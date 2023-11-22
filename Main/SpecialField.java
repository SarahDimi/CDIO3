package Main;

public class SpecialField extends NormalField {
    protected String name;

    public SpecialField(String name) {
        super(index, name);
        this.type = "special";
        this.name = name;
    }

    static class StartField extends SpecialField{
        public StartField(String name) {
            super(name);
            
        }
        
    }

    static class VisitJail extends SpecialField{
        public VisitJail(String name){
            super(name);
        }
    }

   static class FreeParking extends SpecialField{
        public FreeParking(String name){
            super(name);    
        }
    }



    static class InJail extends SpecialField{
        public InJail(String name){
            super(name);
        }
    }

    // Metode for "Visit Jail"
    public void visitJail(Player player) {
        System.out.println(player.getName() + " is just visiting jail.");
    }

    // Metode for "Free Parking"
    public void park(Player player) {
        System.out.println(player.getName() + " is relaxing at Free Parking.");
    }

    // Metode for "In Jail"
    public void inJail(Player player) {
        System.out.println(player.getName() + " is in jail!");
    }

    // Metode for "Start Field", med startløn og passage af startløn
    public void landOnStart(Player player) {
        System.out.println(player.getName() + " has landed on Start. Collecting $" + 2000);
        player.getAccount().deposit(2000);
    }

    public void passStart(Player player) {
        System.out.println(player.getName() + " has passed Start. Collecting $" + 2000);
        player.getAccount().deposit(2000);
    }

    public String getName() {
        return name;
    }

}



// We have placed the special fields into a serperate file in order to keep better track of the code.
