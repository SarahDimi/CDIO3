package Main;
import java.util.Arrays;

class Player {
    
    String name;
    PlayerPiece playerPiece;
    Account account;
    Player[] players;
    int position;
    int numberOfPlayers;
    int numberOfJailCards;
    int numberOfJailTurns;
    int playerNumber;

    public Player(String name, PlayerPiece playerPiece, Account account, int numberOfPlayers, int playerNumber){
        this.name = name;
        this.playerPiece = playerPiece;
        this.account = account;
        this.numberOfPlayers = numberOfPlayers;
        this.playerNumber=playerNumber;
        this.numberOfJailCards = numberOfJailCards;
        this.numberOfJailTurns = numberOfJailTurns;

    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name; 
    }

    public PlayerPiece getPiece(){
        return playerPiece;
    }

    public Account getAccount(){
        return account;
    }

    public Player(int numberOfPlayers) {
		players = new Player[numberOfPlayers];
	}
	
	public void addPlayer(Player player, int index) {
		players[index] = player;
	}

	public Player getPlayer(int index) {
		return players[index];
	}
	
	public int numberOfPlayers() {
		return players.length;
	}

    public void updatePosition(int spaces, int boardSize) {
        position = (position + spaces) % boardSize;
    }

    public int getPosition() {
        return position;
    }

	
	@Override
	public String toString() {
		return "Playerlist: " + Arrays.toString(players);
	}
    
}

