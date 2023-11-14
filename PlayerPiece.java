public class PlayerPiece {
    private int position; 
    private String pieceName;

    Public PlayerPiece(String PieceName) {
        this.position = 0;
        this.playerName = pieceName;
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
    public void moveFoward(int spaces) {
        position += spaces;
    }
    public void moveBackwards(int spaces) {
        position -= spaces;
    }
    public String toString() {
        return pieceName + " is at space " + position; 
    }
}
