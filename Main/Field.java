package Main;

public class Field {

    protected int owner;
    protected int price;
    protected int rent;
    protected String name;
    protected String group;

        public Field(String name, int price, int rent, String group) {
            this.group = group;

        
    
    }

    public String getGroup() {
        return group;
    }
}