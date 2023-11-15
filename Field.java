package Main;
public abstract class Field {
    private String name;
    private Player owner;

    public Field(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player player) {
        this.owner = player;
    }



    public void displayInfo() {
        System.out.println("This is " + name + " field.");
        if (owner != null) {
            System.out.println("Owned by: " + owner.getName());
        } else {
            System.out.println("Unowned");
        }
    }


public class BrownField extends Field {
    private int price;
    private int rent;
    private boolean isOwned;

    public BrownField(String name, int price, int rent) {
        super(name);
        this.price = price;
        this.rent = rent;
        this.isOwned = false;
    }

   
}

public class BrownField1 extends BrownField {   
    public BrownField1() {
        super("Istergade number 0", 1, 1); 
    }
}


public class BrownField2 extends BrownField {
    public BrownField2() {
        super("DTU ", 1, 1); 
    }
}


public class LightBlueField extends Field {
    private int price;
    private int rent;
    private boolean isOwned;

    public LightBlueField(String name, int price, int rent) {
        super(name);
        this.price = price;
        this.rent = rent;
        this.isOwned = false;
    }

   
        }
  
    


public class LightBlueField1 extends LightBlueField {
    public LightBlueField1() {
        super("Blaagaards Plads", 1, 1); 
    }
}


public class LightBlueField2 extends LightBlueField {
    public LightBlueField2() {
        super("Lightblue 2", 1, 1); 
    }
}



public class PinkField extends Field {
    private int price;
    private int rent;
    private boolean isOwned;

    public PinkField(String name, int price, int rent) {
        super(name);
        this.price = price;
        this.rent = rent;
        this.isOwned = false;
    }

   
        }


public class Pinkfield1 extends PinkField {
    public Pinkfield1 () {
        super("Ali's kebabshop", 2, 2); 
    }
}


public class PinkField2 extends PinkField {
    public PinkField2() {
        super("Noerrebro's runddel", 120, 12); 
    }
}



public class OrangeField extends Field {
    private int price;
    private int rent;
    private boolean isOwned;

    public OrangeField(String name, int price, int rent) {
        super(name);
        this.price = price;
        this.rent = rent;
        this.isOwned = false;
    }

   
}


public class OrangeField1 extends OrangeField {
    public OrangeField1() {
        super("Amager", 2, 2); 
    }
}


public class OrangeField2 extends OrangeField {
    public OrangeField2() {
        super("Vesterbro", 2, 2);
    }
}

public class RedField  extends Field {
    private int price;
    private int rent;
    private boolean isOwned;

    public RedField(String name, int price, int rent) {
        super(name);
        this.price = price;
        this.rent = rent;
        this.isOwned = false;
    }

   
        }



public class RedField1 extends RedField {
    public RedField1() {
        super("Holte", 3, 3); 
    }
}


public class RedField2 extends RedField {
    public RedField2() {
        super("Gammel holte", 3, 3); 
    }
}

public class YellowField extends Field {
    private int price;
    private int rent;
    private boolean isOwned;

    public YellowField(String name, int price, int rent) {
        super(name);
        this.price = price;
        this.rent = rent;
        this.isOwned = false;
    }

   
        }
    



public class YellowField1 extends YellowField {
    public YellowField1() {
        super("Campus bar", 3, 3); 
    }
}


public class YellowField2 extends YellowField {
    public YellowField2() {
        super("Oesterbro", 3, 3);
    }
}

public class GreenField extends Field {
    private int price;
    private int rent;
    private boolean isOwned;

    public GreenField(String name, int price, int rent) {
        super(name);
        this.price = price;
        this.rent = rent;
        this.isOwned = false;
    }

   
}


public class GreenField1 extends GreenField {
    public GreenField1() {
        super("Frederiksberg", 4, 4); 
    }
}


public class GreenField2 extends GreenField {
    public GreenField2() {
        super("The ZOO", 4, 4); 
    }
}

public class DarkBlue extends Field {
    private int price;
    private int rent;
    private boolean isOwned;

    public DarkBlue(String name, int price, int rent) {
        super(name);
        this.price = price;
        this.rent = rent;
        this.isOwned = false;
    }

   
        }



public class DarkBlue1 extends DarkBlue {
    public DarkBlue1() {
        super("Strandvejen", 5, 5); 
    }
}


public class DarkBlue2 extends DarkBlue {
    public DarkBlue2() {
        super("Hellerup", 5, 5); 
    }
}
}