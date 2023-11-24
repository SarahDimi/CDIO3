package Main;

public class Field extends NormalField {
    private Player owner;
    private int price;
    private int rent;
    private String name;
    private String color;

    public Field(String name, int price, int rent, String color) {
        super(index,name);
        this.price = price;
        this.rent = rent;
        this.type = "property";
        this.color = color;
        
    
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player player) {
        this.owner = player;
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


    public String getColor() {
        return color;
    }
    public  String getName(){
        return name;
    }
   
}

