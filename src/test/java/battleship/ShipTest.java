package battleship;

import static org.junit.Assert.*;

import org.junit.Test;


public class ShipTest {
    
    @Test
    public void shipLengthCheck(){
        Ship patrol = new Ship("Patrol Boat");
        Ship submarine = new Ship("Submarine");
        Ship destroyer = new Ship("Destroyer");
        Ship battleship = new Ship("Battleship");
        Ship carrier = new Ship("Carrier");

        assertEquals(2, patrol.getLength());
        assertEquals(3, submarine.getLength());
        assertEquals(3, destroyer.getLength());
        assertEquals(4, battleship.getLength());
        assertEquals(5, carrier.getLength());
    }

    public void shipHitSignatureCheck(){
        Ship patrol = new Ship("Patrol Boat");
        Ship submarine = new Ship("Submarine");
        Ship destroyer = new Ship("Destroyer");
        Ship battleship = new Ship("Battleship");
        Ship carrier = new Ship("Carrier");

        assertEquals('P', patrol.getHitSig());
        assertEquals('S', submarine.getHitSig());
        assertEquals('D', destroyer.getHitSig());
        assertEquals('B', battleship.getHitSig());
        assertEquals('C', carrier.getHitSig());
    }


    public void gotHitEqualsCordinate(){
        Ship patrol = new Ship("Patrol Boat");
        patrol.gotHit("E5");
        assertEquals("E5", patrol.getHitsLocation()[0]);
    }

    public void shipOrientationEqualsVertical(){
        Ship battleship = new Ship("Battleship");
        battleship.gotHit("J5");
        battleship.gotHit("I5");
        assertEquals("vertical", battleship.getOrientation());
    }

    public void shipOrientationEqualsHorizontal(){
        Ship battleship = new Ship("Battleship");
        battleship.gotHit("I4");
        battleship.gotHit("I5");
        assertEquals("horizontal", battleship.getOrientation());
    }
    public void shipOrientationEqualsUnknown(){
        Ship battleship = new Ship("Battleship");
        battleship.gotHit("I4");
        assertEquals("unknown", battleship.getOrientation());
    }

    public void shipHasSunk(){
        Ship carrier = new Ship("Carrier");
        carrier.gotHit("E5");
        carrier.gotHit("E4");
        carrier.gotHit("E3");
        carrier.gotHit("E6");
        carrier.gotHit("E7");
        assertTrue(carrier.isSunk());
    }
    public void shipHasNotSunk(){
        Ship carrier = new Ship("Carrier");
        carrier.gotHit("E5");
        carrier.gotHit("E4");
        carrier.gotHit("E6");
        carrier.gotHit("E7");
        assertFalse(carrier.isSunk());
    }
}
