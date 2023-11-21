package Main;

abstract class NormalField {
    protected String type;
    protected static int index;
    protected String name;
    protected int rent;
    private Player owner;

    public NormalField(int index, String name) {
        this.type = "normal";
        this.index = index;
        this.name = name;
    }

    // Getter og setter metoder for type, index og owner, hvis nødvendigt

    public String getType() {
        return type;
    }

    public int getIndex() {
        return index;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    // Andre metoder og egenskaber efter behov
}
