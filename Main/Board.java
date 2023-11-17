package Main;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Field> fields;
    private List<Player> players;
    private int currentPlayerIndex;
    private List <ChanceCard> chancecard;
    private List <SpecialField> specialfield;

    public Board() {
        fields = new ArrayList<>();
        specialfield = new ArrayList<>();
        players = new ArrayList<>();
        currentPlayerIndex = 0;
        initializeBoard();
    }

    // Each Field is placed in correct order according to its place on the board. Name, Prices and Rent shown.

    private void initializeBoard() {

        specialfield.add(new SpecialField.StartField());    //Start field
        fields.add(new Field("Istergade number 0",1,1));    //Brown field 1
        fields.add(new Field("DTU",1,1));    //Brown fields 2
        chancecard.add(new ChanceCard());    //Chance field 1
        fields.add(new Field("Blaagaards Plads",1,1));  //Light blue field 1
        fields.add(new Field("Shamba",1,1));    //Light blue field 2
        specialfield.add(new SpecialField.VisitJail());     //Visiting Jail field
        fields.add(new Field("Alis kebabshop",2,2));     //Pink field 1
        fields.add(new Field("Noerrebros Runddel",2,2));     //Pink field 2
        chancecard.add(new ChanceCard());    //Chance field 2
        fields.add(new Field("Amager",2,2));    //Orange field 1
        fields.add(new Field("Vesterbro",2,2));     //Orange field 2
        specialfield.add(new SpecialField.FreeParking());     //Free parking field 
        fields.add(new Field("Holte",3,3));     //Red Field 1
        fields.add(new Field("Gammel Holte",3,3));     //Red Field 2
        chancecard.add(new ChanceCard());    //Chance field 3
        fields.add(new Field("Campus bar",3,3));     //Yellow field 1
        fields.add(new Field("Oesterbro",3,3));     //Yellow field 2
        specialfield.add(new SpecialField.InJail());     //In Jail field
        fields.add(new Field("Frederiksberg",4,4));     //Green Field 1
        fields.add(new Field("The Zoo",4,4));      //Green Field 2
        chancecard.add(new ChanceCard());      //Chance field 4
        fields.add(new Field("Strandvejen",5,5));    //Dark blue field 1
        fields.add(new Field("Hellerup",5,5));      //Dark blue field 2
   
    }
}
