package Main;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<NormalField> board;
    private List<Field> fields;
    private List<Player> players;
    private int currentPlayerPosition;
    private List<ChanceCard> chancecard; // Assuming ChanceCard is a class you've defined
    private List<SpecialField> specialfield;
    private static final int BOARDSIZE = 24;

    public Board() {
        fields = new ArrayList<>();
        specialfield = new ArrayList<>();
        players = new ArrayList<>();
        chancecard = new ArrayList<>(); // Initialize the chancecard list here
        currentPlayerPosition = 0;
        initializeBoard();
    }



    // Each Field is placed in correct order according to its place on the board. Name, Prices and Rent shown.

    private void initializeBoard() {

        board.add(new SpecialField.StartField());    //Start field
        board.add(new Field("Istergade number 0",1,1));    //Brown field 1
        board.add(new Field("DTU",1,1));    //Brown fields 2
        board.add(new ChanceCard());    //Chance field 1
        board.add(new Field("Blaagaards Plads",1,1));  //Light blue field 1
        board.add(new Field("Shamba",1,1));    //Light blue field 2
        board.add(new SpecialField.VisitJail());     //Visiting Jail field
        board.add(new Field("Alis kebabshop",2,2));     //Pink field 1
        board.add(new Field("Noerrebros Runddel",2,2));     //Pink field 2
        board.add(new ChanceCard());    //Chance field 2
        board.add(new Field("Amager",2,2));    //Orange field 1
        board.add(new Field("Vesterbro",2,2));     //Orange field 2
        board.add(new SpecialField.FreeParking());     //Free parking field 
        board.add(new Field("Holte",3,3));     //Red Field 1
        board.add(new Field("Gammel Holte",3,3));     //Red Field 2
        board.add(new ChanceCard());    //Chance field 3
        board.add(new Field("Campus bar",3,3));     //Yellow field 1
        board.add(new Field("Oesterbro",3,3));     //Yellow field 2
        board.add(new SpecialField.InJail());     //In Jail field
        board.add(new Field("Frederiksberg",4,4));     //Green Field 1
        board.add(new Field("The Zoo",4,4));      //Green Field 2
        board.add(new ChanceCard());      //Chance field 4
        board.add(new Field("Strandvejen",5,5));    //Dark blue field 1
        board.add(new Field("Hellerup",5,5));      //Dark blue field 2
   
    }

    



    public Field getField(int position) {
        return null;
    }


    public int getBoardSize(){
        return BOARDSIZE;
    }

    public String getFieldname(){
        return Field(Board());
    }

}
