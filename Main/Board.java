package Main;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Field> fields;
    private List<Player> players;
    private int currentPlayerIndex;
    private List <ChanceCard> chancecard;

    public Board() {
        fields = new ArrayList<>();
        players = new ArrayList<>();
        currentPlayerIndex = 0;
        initializeBoard();
    }

    private void initializeBoard() {
        // Add your fields to the board
        fields.add(new Start());
        fields.add(new BrownField1());
        fields.add(new BrownField2());
        chancecard.add(new ChanceCard());
        fields.add(new LightBlueField1());
        fields.add(new LightBlueField2());
        fields.add(new VisitJail());
        fields.add(new Pinkfield1());
        fields.add(new PinkField2());
        chancecard.add(new ChanceCard());
        fields.add(new OrangeField1());
        fields.add(new OrangeField2());
        fields.add(new Parking());
        fields.add(new RedField1());
        fields.add(new RedField2());
        chancecard.add(new ChanceCard());
        fields.add(new YellowField1());
        fields.add(new YellowField2());
        fields.add(new injail());
        fields.add(new GreenField1());
        fields.add(new GreenField2());
        chancecard.add(new ChanceCard());
        fields.add(new DarkBlue1());
        fields.add(new DarkBlue2());
    }
}
