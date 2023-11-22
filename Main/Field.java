package Main;

public class Field extends NormalField {
    private Player owner;
    private int price;
    private int rent;
    private String name;

    public Field(String name, int price, int rent) {
        super(index,name);
        this.price = price;
        this.rent = rent;
        this.type = "property";
    
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }

    public int getRent() {
        return rent;
    }

    public int getIndex() {
        return super.getIndex(); 
    }


    public Object getColor() {
        return null;
    }
}

