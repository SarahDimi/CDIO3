package Main;
public class PlayerPiece {
    private int position; 
    private String pieceName;

    public PlayerPiece(String pieceName) {
        this.position = 0;
        this.pieceName = pieceName;
    }
    public String getPieceName() {
        return pieceName;
    }
    public int getPosition() {
        return position;
    } 
    public void resetPosition() {
        position = 0;
    }
    public void moveForward(int spacesToMove) {
        position += spacesToMove;
    }
    public void moveBackwards(int spacesToMove) {
        position -= spacesToMove;
    }
    public String toString() {
        return pieceName + " is at space " + position; 
    }
}