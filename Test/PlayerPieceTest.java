package Test;
import Main.PlayerPiece;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerPieceTest {
    private PlayerPiece playerPiece;

    @Before
    public void setUp() {
        playerPiece = new PlayerPiece("TestPiece");
    }

    @Test
    public void getPieceName() {
        assertEquals("TestPiece", playerPiece.getPieceName());
    }

    @Test
    public void getPosition() {
        assertEquals(0, playerPiece.getPosition());
    }

    @Test
    public void resetPosition() {
        playerPiece.moveForward(5);
        playerPiece.resetPosition();
        assertEquals(0, playerPiece.getPosition());
    }

    @Test
    public void moveForward() {
        playerPiece.moveForward(3);
        assertEquals(3, playerPiece.getPosition());
    }

    @Test
    public void moveBackwards() {
        playerPiece.moveForward(5);
        playerPiece.moveBackwards(2);
        assertEquals(3, playerPiece.getPosition());
    }

    @Test
    public void toStringTest() {
        assertEquals("TestPiece is at space 0", playerPiece.toString());
    }
}