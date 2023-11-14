package Main;

public class Account {
    private int balance;
    Dicevalues roll = new Dicevalues();
    FieldEffects fieldEffects = new FieldEffects();

    public Account(int initialBalance) {
        this.balance = initialBalance;
    }

    public int getBalance() {
        return balance;
    }

    public void collect(int rollResult, int effectAmount, int specialFieldResult) {
        int newBalance = balance + effectAmount;
        balance = newBalance;
    }

    public void pay(int rollResult, int effectAmount, int specialFieldResult) {
        int newBalance = balance;
        newBalance -= effectAmount;
        balance = Math.max(0, newBalance);
    }
    
}
