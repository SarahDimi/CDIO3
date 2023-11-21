package Main;

public class Field extends NormalField {
    private int owner;
    private int price;
    private int rent;
    private String name;

    public Field(String name, int price, int rent) {
        super(name); // Assuming NormalField has a constructor that takes a name parameter
        this.price = price;
        this.rent = rent;
        this.owner = -1; // -1 represents no owner, adjust as needed
    }

    public int getOwner() {
        return owner;
    }

    public int getPrice() {
        return price;
    }

    public int getRent() {
        return rent;
    }

    public int getIndex() {
        return super.getIndex(); // Assuming NormalField has a method to get the index
    }

    public void setOwner(int playerNumber) {
        this.owner = playerNumber;
    }
}
