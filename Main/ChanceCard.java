package Main;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class ChanceCard extends NormalField {
    private List<String> cards;


    public ChanceCard( String name) {
        super(index,name);
        this.type= "chance";
    
        cards = new ArrayList<>();
        cards.add("Advance to Go (Collect $2)");
        cards.add("Move up to 5 fields forward");
        cards.add("Free field! Move to a ORANGE field. If the field is available, you get it for free otherwise you must pay rent to the owner");
        cards.add("Move one field forward or pull a Chancecard more");
        cards.add("You have eaten to much candy, pay $2 to the bank");
        cards.add("Free field! Move to a ORANGE or GREEN field. If the field is available, you get it for free otherwise you must pay rent to the owner");
        cards.add("Free field! Move to a LIGHT BLUE field. If the field is available, you get it for free otherwise you must pay rent to the owner");
        cards.add("You can get out of jail. Keep this card until you need it");
        cards.add("It is you birthdday!! All the other player must give you $1. Congratulations!!");
        cards.add("Free field! Move to a PINK or DARK BLUE field. If the field is available, you get it for free otherwise you must pay rent to the owner");
        cards.add("You have made all your homework. You will get $2 form the bank");
        cards.add("Free field! Move to a RED field. If the field is available, you get it for free otherwise you must pay rent to the owner");
        cards.add("Free field! Move to a LIGHT BLUE or RED field. If the field is available, you get it for free otherwise you must pay rent to the owner");
        cards.add("Free field! Move to a BROWN or YELLOW field. If the field is available, you get it for free otherwise you must pay rent to the owner");
       
    }

    public String drawCard() {
        int randomIndex = (int)(Math.random() * cards.size());
        String message = cards.get(randomIndex);
        cards.remove(randomIndex); 
        return message;
    }
    public void applyCardEffect(Player player, String cardMessage, PlayerPiece playerPiece, int currentPlayerPosition, Board boardSize,List<Player> players) {
        Scanner scanner = new Scanner(System.in);
        if (cardMessage.equals("Advance to Go (Collect $2)")) {
            player.getAccount().deposit(2);
            System.out.println(player.getName() + " Advances to Go and collects $2");

            int startFieldIndex = 0; 
        
            currentPlayerPosition = playerPiece.getPosition();
        
           int spacesToMove = ((startFieldIndex - currentPlayerPosition + boardSize.getBoardSize() )%boardSize.getBoardSize() );
        
            playerPiece.moveForward(spacesToMove);

        } else if (cardMessage.equals("Move up to 5 fields forward")) {
            Random random = new Random();

            int spacesToMove = random.nextInt(6); 
            playerPiece.moveForward(spacesToMove);
            System.out.println(player.getName() + " moves " + spacesToMove + " spaces forward.");

        } else if (cardMessage.equals("Free field! Move to an ORANGE field. If available, you get it for free, otherwise pay rent.")) {
            int orangeFieldIndex = 10; 
        
            currentPlayerPosition = playerPiece.getPosition();
        
            int spacesToMove = ((orangeFieldIndex - currentPlayerPosition + boardSize.getBoardSize() )%boardSize.getBoardSize() );
            
        
            playerPiece.moveForward(spacesToMove);
        
            Player owner = Bank.getFieldOwner(orangeFieldIndex);
            if (owner == null) {
                Bank.fieldOwnership.put(orangeFieldIndex, player);
                System.out.println(player.getName() + " acquires the ORANGE field for free.");
            } else {
                int rentAmount = 2; 
                Bank.payRent(player, owner, rentAmount);
                System.out.println(player.getName() + " pays rent to " + owner.getName() + " for the ORANGE field.");
            }
        } else if (cardMessage.equals("Move one field forward or draw another Chance card")) {
            String answer = scanner.nextLine();

            if(answer == "1"){
                playerPiece.moveForward(1);
            } else {
                drawCard();
            }
        } else if (cardMessage.equals("You have eaten too much candy, pay $2 to the bank")) {
            player.getAccount().deposit(2);
            System.out.println(player.getName() + " pays $2 to the bank for eating to much candy");
        } else if (cardMessage.equals("Free field! Move to an ORANGE or GREEN field. If available, you get it for free, otherwise pay rent.")) {

            System.out.println("You can now choose between a ORANGE field or a GREEN field. Write which you choose in the");
            String fieldAnswer = scanner.nextLine();

            if(fieldAnswer.equalsIgnoreCase ("orange")){
            int orangeFieldIndex = 10; 
        
            currentPlayerPosition = playerPiece.getPosition();
        
            int spacesToMove = ((orangeFieldIndex - currentPlayerPosition + boardSize.getBoardSize() )%boardSize.getBoardSize() );
        
            playerPiece.moveForward(spacesToMove);
        
            Player owner = Bank.getFieldOwner(orangeFieldIndex);
            if (owner == null) {
                Bank.fieldOwnership.put(orangeFieldIndex, player);
                System.out.println(player.getName() + " acquires the ORANGE field for free.");
            } else {
                int rentAmount = 2; 
                Bank.payRent(player, owner, rentAmount);
                System.out.println(player.getName() + " pays rent to " + owner.getName() + " for the ORANGE field.");
            }
        } else {
            int greenFieldIndex = 19; 
        
            currentPlayerPosition = playerPiece.getPosition();
        
           int spacesToMove = ((greenFieldIndex - currentPlayerPosition + boardSize.getBoardSize() )%boardSize.getBoardSize() );
        
            playerPiece.moveForward(spacesToMove);
        
            Player owner = Bank.getFieldOwner(greenFieldIndex);
            if (owner == null) {
                Bank.fieldOwnership.put(greenFieldIndex, player);
                System.out.println(player.getName() + " acquires the GREEN field for free.");
            } else {
                int rentAmount = 4; 
                Bank.payRent(player, owner, rentAmount);
                System.out.println(player.getName() + " pays rent to " + owner.getName() + " for the GREEN field.");
            }
        }
        } else if (cardMessage.equals("Free field! Move to a LIGHT BLUE field. If available, you get it for free, otherwise pay rent.")) {
            int lightBlueFieldIndex = 4; 
        
            currentPlayerPosition = playerPiece.getPosition();
        
            int spacesToMove = ((lightBlueFieldIndex - currentPlayerPosition + boardSize.getBoardSize() )%boardSize.getBoardSize() );
        
            playerPiece.moveForward(spacesToMove);
        
            Player owner = Bank.getFieldOwner(lightBlueFieldIndex);
            if (owner == null) {
                Bank.fieldOwnership.put(lightBlueFieldIndex, player);
                System.out.println(player.getName() + " acquires the ORANGE field for free.");
            } else {
                int rentAmount = 1; 
                Bank.payRent(player, owner, rentAmount);
                System.out.println(player.getName() + " pays rent to " + owner.getName() + " for the ORANGE field.");
            }
        } else if (cardMessage.equals("You can get out of jail. Keep this card until you need it")) {
            // Implement logic to keep the card for later use when the player is in jail
        } else if (cardMessage.equals("It is your birthday!! All other players must give you $1. Congratulations!!")) {
            // Implement logic to collect $1 from all other players
        } else if (cardMessage.equals("Free field! Move to a PINK or DARK BLUE field. If available, you get it for free, otherwise pay rent.")) {
            System.out.println("You can now choose between a DARK BLUE field or a PINK field. Write which you choose in the");
            String fieldAnswer = scanner.nextLine();
            if(fieldAnswer.equalsIgnoreCase ("dark blue")){
            int darkBlueFieldIndex = 22; 
        
            currentPlayerPosition = playerPiece.getPosition();
        
            int spacesToMove = ((darkBlueFieldIndex - currentPlayerPosition + boardSize.getBoardSize() )%boardSize.getBoardSize() );
        
            playerPiece.moveForward(spacesToMove);
        
            Player owner = Bank.getFieldOwner(darkBlueFieldIndex);
            if (owner == null) {
                Bank.fieldOwnership.put(darkBlueFieldIndex, player);
                System.out.println(player.getName() + " acquires the DARK BLUE field for free.");
            } else {
                int rentAmount = 5; 
                Bank.payRent(player, owner, rentAmount);
                System.out.println(player.getName() + " pays rent to " + owner.getName() + " for the DARK BLUE field.");
            }
        } else {
            int pinkFieldIndex = 7; 
        
            currentPlayerPosition = playerPiece.getPosition();
        
            int spacesToMove = ((pinkFieldIndex - currentPlayerPosition + boardSize.getBoardSize() )%boardSize.getBoardSize() );
        
            playerPiece.moveForward(spacesToMove);
        
            Player owner = Bank.getFieldOwner(pinkFieldIndex);
            if (owner == null) {
                Bank.fieldOwnership.put(pinkFieldIndex, player);
                System.out.println(player.getName() + " acquires the GREEN field for free.");
            } else {
                int rentAmount = 2;
                Bank.payRent(player, owner, rentAmount);
                System.out.println(player.getName() + " pays rent to " + owner.getName() + " for the GREEN field.");
            }
        }
        } else if (cardMessage.equals("You have completed your homework. You receive $2 from the bank")) {
            player.getAccount().deposit(2);
            System.out.println(player.getName() + " gets $2 for completing all of there homwwork");
        } else if (cardMessage.equals("Free field! Move to a RED field. If available, you get it for free, otherwise pay rent.")) {
            int redFieldIndex = 13; 
        
            currentPlayerPosition = playerPiece.getPosition();
        
            int spacesToMove = ((redFieldIndex - currentPlayerPosition + boardSize.getBoardSize() )%boardSize.getBoardSize() );
        
            playerPiece.moveForward(spacesToMove);
        
            Player owner = Bank.getFieldOwner(redFieldIndex);
            if (owner == null) {
                Bank.fieldOwnership.put(redFieldIndex, player);
                System.out.println(player.getName() + " acquires the ORANGE field for free.");
            } else {
                int rentAmount = 2;
                Bank.payRent(player, owner, rentAmount);
                System.out.println(player.getName() + " pays rent to " + owner.getName() + " for the ORANGE field.");
            }
        } else if (cardMessage.equals("Free field! Move to a LIGHT BLUE or RED field. If available, you get it for free, otherwise pay rent.")) {
            System.out.println("You can now choose between a LIGHT BLUE field or a RED field. Write which you choose");
            String fieldAnswer = scanner.nextLine();
            if(fieldAnswer.equalsIgnoreCase ("light blue")){
            int lightBlueFieldIndex = 4; 
        
            currentPlayerPosition = playerPiece.getPosition();
        
            int spacesToMove = ((lightBlueFieldIndex - currentPlayerPosition + boardSize.getBoardSize() )%boardSize.getBoardSize() );
        
            playerPiece.moveForward(spacesToMove);
        
            Player owner = Bank.getFieldOwner(lightBlueFieldIndex);
            if (owner == null) {
                Bank.fieldOwnership.put(lightBlueFieldIndex, player);
                System.out.println(player.getName() + " acquires the DARK BLUE field for free.");
            } else {
                int rentAmount = 1;
                Bank.payRent(player, owner, rentAmount);
                System.out.println(player.getName() + " pays rent to " + owner.getName() + " for the DARK BLUE field.");
            }
        } else {
            int redFieldIndex = 13; 
        
            currentPlayerPosition = playerPiece.getPosition();
        
            int spacesToMove = ((redFieldIndex - currentPlayerPosition + boardSize.getBoardSize() )%boardSize.getBoardSize() );
        
            playerPiece.moveForward(spacesToMove);
        
            Player owner = Bank.getFieldOwner(redFieldIndex);
            if (owner == null) {
                Bank.fieldOwnership.put(redFieldIndex, player);
                System.out.println(player.getName() + " acquires the GREEN field for free.");
            } else {
                int rentAmount = 3;
                Bank.payRent(player, owner, rentAmount);
                System.out.println(player.getName() + " pays rent to " + owner.getName() + " for the GREEN field.");
            }
        }
        } else if (cardMessage.equals("Free field! Move to a BROWN or YELLOW field. If available, you get it for free, otherwise pay rent.")) {
            System.out.println("You can now choose between a BROWN field or a YELLOW field. Write which you choose in the");
            String fieldAnswer = scanner.nextLine();
            if(fieldAnswer.equalsIgnoreCase ("brown")){
            int brownFieldIndex = 1; 
        
            currentPlayerPosition = playerPiece.getPosition();
        
            int spacesToMove = ((brownFieldIndex - currentPlayerPosition + boardSize.getBoardSize() )%boardSize.getBoardSize() );
        
            playerPiece.moveForward(spacesToMove);
        
            Player owner = Bank.getFieldOwner(brownFieldIndex);
            if (owner == null) {
                Bank.fieldOwnership.put(brownFieldIndex, player);
                System.out.println(player.getName() + " acquires the DARK BLUE field for free.");
            } else {
                int rentAmount = 1;
                Bank.payRent(player, owner, rentAmount);
                System.out.println(player.getName() + " pays rent to " + owner.getName() + " for the DARK BLUE field.");
            }
        } else {
            int yellowFieldIndex = 16; 
        
            currentPlayerPosition = playerPiece.getPosition();
        
            int spacesToMove = ((yellowFieldIndex - currentPlayerPosition + boardSize.getBoardSize() )%boardSize.getBoardSize() );
        
            playerPiece.moveForward(spacesToMove);
        
            Player owner = Bank.getFieldOwner(yellowFieldIndex);
            if (owner == null) {
                Bank.fieldOwnership.put(yellowFieldIndex, player);
                System.out.println(player.getName() + " acquires the GREEN field for free.");
            } else {
                int rentAmount = 3; 
                Bank.payRent(player, owner, rentAmount);
                System.out.println(player.getName() + " pays rent to " + owner.getName() + " for the GREEN field.");
            }
        }
        }else if(cardMessage.equals("You can get out of jail. Keep this card until you need it")){
            player.numberOfJailCards++;

        } else if(cardMessage.equals("It is you birthdday!! All the other player must give you $1. Congratulations!!")){
            for (Player otherPlayer : players) {
                if(!otherPlayer.equals(player)){
                    otherPlayer.getAccount().withdraw(1);
                    player.getAccount().deposit(1);
                    System.out.println(otherPlayer.getName()+ " gives 1M to "+ player.getName()+ " for their birthday! ");
                }
            }
        }
    }

    public void applyCard(Player player, Bank bank) {
    }
}