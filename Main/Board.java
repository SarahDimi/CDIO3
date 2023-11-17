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

    private void initializeBoard() {
        // Add your fields to the board
        specialfield.add(new SpecialField.StartField());
        fields.add(new Field("Istergade number 0",1,1));
        fields.add(new Field("DTU",1,1));
        chancecard.add(new ChanceCard());
        fields.add(new Field("Blaagaards Plads",1,1));
        fields.add(new Field("Shamba",1,1));
        specialfield.add(new SpecialField.VisitJail());
        fields.add(new Field("Alis kebabshop",2,2));
        fields.add(new Field("Noerrebros Runddel",2,2));
        chancecard.add(new ChanceCard());
        fields.add(new Field("Amager",2,2));
        fields.add(new Field("Vesterbro",2,2));
        specialfield.add(new SpecialField.FreeParking());
        fields.add(new Field("Holte",3,3));
        fields.add(new Field("Gammel Holte",3,3));
        chancecard.add(new ChanceCard());
        fields.add(new Field("Campus bar",3,3));
        fields.add(new Field("Oesterbro",3,3));
        specialfield.add(new SpecialField.InJail());
        fields.add(new Field("Frederiksberg",4,4));
        fields.add(new Field("The Zoo",4,4));
        chancecard.add(new ChanceCard());
        fields.add(new Field("Strandvejen",5,5));
        fields.add(new Field("Hellerup",5,5));
    }
}
