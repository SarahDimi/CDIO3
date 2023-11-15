package Main;
import java.util.Random;

public class Dice {
    private int faceValue;
    private final int sides;
    private Random random = new Random();

    public Dice(int sides){
        this.sides = sides;
    }

    public int rollDice() {
        faceValue = random.nextInt(sides) + 1;
        return faceValue;
    }
}
