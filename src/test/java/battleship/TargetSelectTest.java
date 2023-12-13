package battleship;

import static org.junit.Assert.*;
import org.junit.Test;


public class TargetSelectTest {
    
    @Test
    public void checkOutOfBounds(){
        int[][] cordsToTest = {{0,0},{0,-1},{10,10},{9,9},{5,5},{0,9},{0,10}};

        assertFalse (TargetSelect.outOfBounds(cordsToTest[0]));
        assertTrue(TargetSelect.outOfBounds(cordsToTest[1]));
        assertTrue(TargetSelect.outOfBounds(cordsToTest[2]));
        assertFalse(TargetSelect.outOfBounds(cordsToTest[3]));
        assertFalse(TargetSelect.outOfBounds(cordsToTest[4]));
        assertFalse(TargetSelect.outOfBounds(cordsToTest[5]));
        assertTrue(TargetSelect.outOfBounds(cordsToTest[6]));
    }

    @Test
    public void checkDirections(){
        int[] startCordinate = {5,5};
        int[] upOne = {4,5};
        int[] downOne = {6,5};
        int[] rightOne = {5,6};
        int[] leftOne = {5,4};
        assertArrayEquals(upOne, TargetSelect.goUp(startCordinate));
        assertArrayEquals(downOne, TargetSelect.goDown(startCordinate));
        assertArrayEquals(rightOne, TargetSelect.goRight(startCordinate));
        assertArrayEquals(leftOne, TargetSelect.goLeft(startCordinate));
    }


    @Test
    public void randomTargetIsInBounds(){
        TargettingMaps radar = new TargettingMaps();
        PlayingBoard board = new PlayingBoard();

        int[] randomTarget = TargetSelect.randomTarget(radar, board);
        assertFalse(TargetSelect.outOfBounds(randomTarget));
    }

    @Test
    public void reTargetUnknownOrientation(){
        assertTrue(true);
    }

    @Test
    public void reTargetVertical(){
        assertTrue(true);
    }
    @Test
    public void reTargetHorizontal(){
        assertTrue(true);
    }
}
