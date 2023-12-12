package battleship;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShipTest {
    
    @Test
    public void patrolShipLengthEqualsTwo(){
        Ship patrol = new Ship("Patrol Boat");
        assertEquals(2, patrol.getLength());
    }

}
