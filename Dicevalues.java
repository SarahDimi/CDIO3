package Main;
    import java.util.Random;
    
    public class Dicevalues {
        public int rollDice() {
            Random random = new Random();
            int dice1 = random.nextInt(6) + 1;
            int dice2 = random.nextInt(6) + 1;
            int sum = dice1 + dice2;
            return sum;
        }
    }
