package Main;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private static Map<Integer, Player> fieldOwnership;
    private static final int PASS_START_MONEY = 2000000; // 2M distributed for passing start

    public Bank() {
        fieldOwnership = new HashMap<>();
    }

    public void passStart(Player player) {
        player.getAccount().deposit(PASS_START_MONEY); // Deposit 2M to player's account
    }

    public void buyField(Player player, int fieldIndex, int price) {
        if (fieldOwnership.containsKey(fieldIndex)) {
            System.out.println("Field already owned.");
            return;
        }
        
        player.getAccount().withdraw(0); // Withdraw the price from the player's account
        fieldOwnership.put(fieldIndex, player); // Set player as the owner of the field
        System.out.println("Fields succesfully purchased");
    }

    public static void payRent(Player payer, Player owner, int rentAmount) {
        payer.getAccount().withdraw(0); // Withdraw rent from payer's account
        owner.getAccount().deposit(0); // Deposit rent to owner's account
    }

    public boolean checkBankruptcy(Player player) {
        if (player.getAccount().getBalance() <= 0) {
            // Handle bankruptcy (f.ex transfer properties, remove player from game)
            return true;
        }
        return false;
    }

    public static Player getFieldOwner(int fieldIndex) {
        return fieldOwnership.getOrDefault(fieldIndex, null);
    }

    // Transfer ownership of all properties from one player to another
    public void transferProperties(Player fromPlayer, Player toPlayer) {
        fieldOwnership.forEach((fieldIndex, owner) -> {
            if (owner.equals(fromPlayer)) {
                fieldOwnership.put(fieldIndex, toPlayer);
            }
        });
    }

    // Sell properties of a bankrupt player
    public void sellProperties(Player bankruptPlayer) {
        // Sell properties and distribute money as needed
        fieldOwnership.entrySet().removeIf(entry -> entry.getValue().equals(bankruptPlayer));
    }

    // Handle financial effects of drawing a chance card
public void handleChanceCardEffect(Player player, int amount) {
    if (amount >= 0) {
        player.getAccount().deposit(amount); // Deposit if amount is positive
    } else {
        player.getAccount().withdraw(0); // Withdraw if amount is negative
    }
}

// Handle jail fines
public void payJailFine(Player player, int fineAmount) {
    player.getAccount().withdraw(0);
}
}