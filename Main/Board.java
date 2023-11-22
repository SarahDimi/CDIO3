package Main;
import Main.SpecialField;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public List<NormalField> normalFields;
    private List<Field> fields;
    private List<Player> players;
    private int currentPlayerPosition;
    private List<ChanceCard> chancecard;
    private List<SpecialField> specialfield;
    private static final int BOARDSIZE = 24;

    public Board() {
        normalFields = new ArrayList<>();
        fields = new ArrayList<>();
        specialfield = new ArrayList<>();
        players = new ArrayList<>();
        chancecard = new ArrayList<>(); // Initialize the chancecard list here
        currentPlayerPosition = 0;
        initializeBoard();
    }



    // Each Field is placed in correct order according to its place on the board. Name, Prices and Rent shown.

    private void initializeBoard() {
    normalFields.add(new SpecialField.StartField("Start"));    //Start field
    normalFields.add(new Field("Istergade number 0",1,1, "Brown"));    //Brown field 1
    normalFields.add(new Field("DTU",1,1, "Brown"));    //Brown fields 2
    normalFields.add(new ChanceCard("Chancecard"));    //Chance field 1
    normalFields.add(new Field("Blaagaards Plads",1,1,"Lightblue"));  //Light blue field 1
    normalFields.add(new Field("Shamba",1,1,"Lightblue"));    //Light blue field 2
    normalFields.add(new SpecialField.VisitJail("Visit Jail"));     //Visiting Jail field
    normalFields.add(new Field("Alis kebabshop",2,2,"Pink"));     //Pink field 1
    normalFields.add(new Field("Noerrebros Runddel",2,2,"Pink"));     //Pink field 2
    normalFields.add(new ChanceCard("Chancecard"));    //Chance field 2
    normalFields.add(new Field("Amager",2,2,"Orange"));    //Orange field 1
    normalFields.add(new Field("Vesterbro",2,2,"Orange"));     //Orange field 2
    normalFields.add(new SpecialField.FreeParking("Freeparking"));     //Free parking field 
    normalFields.add(new Field("Holte",3,3,"Red"));     //Red Field 1
    normalFields.add(new Field("Gammel Holte",3,3,"Red"));     //Red Field 2
    normalFields.add(new ChanceCard("Chancecard"));    //Chance field 3
    normalFields.add(new Field("Campus bar",3,3,"Yellow"));     //Yellow field 1
    normalFields.add(new Field("Oesterbro",3,3,"Yellow"));     //Yellow field 2
    normalFields.add(new SpecialField.InJail("InJail"));     //In Jail field
    normalFields.add(new Field("Frederiksberg",4,4,"Green"));     //Green Field 1
    normalFields.add(new Field("The Zoo",4,4,"Green"));      //Green Field 2
    normalFields.add(new ChanceCard("Chancecard"));      //Chance field 4
    normalFields.add(new Field("Strandvejen",5,5,"Dark blue"));    //Dark blue field 1
    normalFields.add(new Field("Hellerup",5,5,"Dark blue"));      //Dark blue field 2
   
    }

    



    public int getNoramlField(int position) {
        return position;
        }
    


    public int getBoardSize(){
        return BOARDSIZE;
    }

    }




