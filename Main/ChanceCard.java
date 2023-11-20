package Main;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
class ChanceCard {
    private List<String> cards;

    public ChanceCard() {
        cards = new ArrayList<>();
        cards.add("Advance to Go (Collect $2)");
        cards.add("Move up to 5 fields forward");
        cards.add("Free field! Move to a ORANGE field. If the field is available, you get it for free otherwise you must pay rent to the owner");
        cards.add("Move one field forward or pull a Chancecard more");
        cards.add("You have eaten to much candy, pay $2 to the bank");
        cards.add("Free field! Move to a ORANGE or GREEN field. If the field is available, you get it for free otherwise you must pay rent to the owner");
        cards.add("Free field! Move to a LIGHT BLUE field. If the field is available, you get it for free otherwise you must pay rent to the owner");
        cards.add("You can get out of jail. Keep this card until you need it");
        cards.add("Move to the beach"); // beach can be changed to antoher field
        cards.add("It is you birthdday!! All the other player must give you $1. Congratulations!!");
        cards.add("Free field! Move to a PINK or DARK BLUE field. If the field is available, you get it for free otherwise you must pay rent to the owner");
        cards.add("You have made all your homework. You will get $2 form the bank");
        cards.add("Free field! Move to a RED field. If the field is available, you get it for free otherwise you must pay rent to the owner");
        cards.add("Free field! Move to the SKATEPARK field. If the field is available, you get it for free otherwise you must pay rent to the owner");
        cards.add("Free field! Move to a LIGHT BLUE or RED field. If the field is available, you get it for free otherwise you must pay rent to the owner");
        cards.add("Free field! Move to a BROWN or YELLOW field. If the field is available, you get it for free otherwise you must pay rent to the owner");
       
    }

    public String drawCard() {
        int randomIndex = (int)(Math.random() * cards.size());
        String message = cards.get(randomIndex);
        cards.remove(randomIndex); // Remove the drawn card from the deck
        return message;
    }
    public void applyCardEffect(Player player, String cardMessage, PlayerPiece playerPiece, int currentPlayerPosition) {
        if (cardMessage.equals("Advance to Go (Collect $2)")) {
            // Also need to move the player to Go
            player.getAccount().deposit(2);
            System.out.println(player.getName() + " Advances to Go and collects $2");
        } else if (cardMessage.equals("Move up to 5 fields forward")) {
            Random random = new Random();
            int spacesToMove = random.nextInt(6); // Generates a random number between 0 and 5 (inclusive)
            playerPiece.moveForward(spacesToMove);
            System.out.println(player.getName() + " moves " + spacesToMove + " spaces forward.");
        } else if (cardMessage.equals("Free field! Move to an ORANGE field. If available, you get it for free, otherwise pay rent.")) {
            // Determine the target field index for the ORANGE field
            int orangeFieldIndex = // Set the index for the ORANGE field;
        
            // Get the current position of the player
            currentPlayerPosition = playerPiece.getPosition();
        
            // Calculate the number of spaces to move to reach the ORANGE field
            int spacesToMove = (orangeFieldIndex - currentPlayerPosition + Board.fields.size()) % Board.fields.size();
        
            // Move the player to the ORANGE field
            playerPiece.moveForward(spacesToMove);
        
            // Check if the ORANGE field is available
            Player owner = Bank.getFieldOwner(orangeFieldIndex);
            if (owner == null) {
                // The field is available, the player gets it for free
                Bank.fieldOwnership.put(orangeFieldIndex, player);
                System.out.println(player.getName() + " acquires the ORANGE field for free.");
            } else {
                // The field is owned by another player, pay rent
                int rentAmount = // Set the rent amount for the ORANGE field;
                Bank.payRent(player, owner, rentAmount);
                System.out.println(player.getName() + " pays rent to " + owner.getName() + " for the ORANGE field.");
            }
        } else if (cardMessage.equals("Move one field forward or draw another Chance card")) {
            // Implement the logic to move the player forward by one field or draw another chance card
        } else if (cardMessage.equals("You have eaten too much candy, pay $2 to the bank")) {
            player.getAccount().deposit(2);
            System.out.println(player.getName() + " pays $2 to the bank for eating to much candy");
        } else if (cardMessage.equals("Free field! Move to an ORANGE or GREEN field. If available, you get it for free, otherwise pay rent.")) {
            // Implement logic for moving to an ORANGE or GREEN field and handling property transactions
        } else if (cardMessage.equals("Free field! Move to a LIGHT BLUE field. If available, you get it for free, otherwise pay rent.")) {
            // Implement logic for moving to a LIGHT BLUE field and handling property transactions
        } else if (cardMessage.equals("You can get out of jail. Keep this card until you need it")) {
            // Implement logic to keep the card for later use when the player is in jail
        } else if (cardMessage.equals("Move to the beach")) {
            // Implement logic to move the player to the beach or any other specified field
        } else if (cardMessage.equals("It is your birthday!! All other players must give you $1. Congratulations!!")) {
            // Implement logic to collect $1 from all other players
        } else if (cardMessage.equals("Free field! Move to a PINK or DARK BLUE field. If available, you get it for free, otherwise pay rent.")) {
            // Implement logic for moving to a PINK or DARK BLUE field and handling property transactions
        } else if (cardMessage.equals("You have completed your homework. You receive $2 from the bank")) {
            player.getAccount().deposit(2);
            System.out.println(player.getName() + " gets $2 for completing all of there homwwork");
        } else if (cardMessage.equals("Free field! Move to a RED field. If available, you get it for free, otherwise pay rent.")) {
            // Implement logic for moving to a RED field and handling property transactions
        } else if (cardMessage.equals("Free field! Move to the SKATEPARK field. If available, you get it for free, otherwise pay rent.")) {
            // Implement logic for moving to the SKATEPARK field and handling property transactions
        } else if (cardMessage.equals("Free field! Move to a LIGHT BLUE or RED field. If available, you get it for free, otherwise pay rent.")) {
            // Implement logic for moving to a LIGHT BLUE or RED field and handling property transactions
        } else if (cardMessage.equals("Free field! Move to a BROWN or YELLOW field. If available, you get it for free, otherwise pay rent.")) {
            // Implement logic for moving to a BROWN or YELLOW field and handling property transactions
        }
    }
}