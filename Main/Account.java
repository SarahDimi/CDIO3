package Main;

public class Account {
    public int balance;
    private int amount;

    public Account(int initialBalance) {
        this.balance = initialBalance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        int newBalance = balance + amount;
        balance = newBalance;
    }

    public void withdraw(int amount) {
        int newBalance = balance - amount ;
        balance = Math.max(0, newBalance);
    }
    
}
