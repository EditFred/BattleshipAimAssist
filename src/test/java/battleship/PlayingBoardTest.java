package battleship;

import static org.junit.Assert.*;
import org.junit.Test;

public class PlayingBoardTest {

    @Test
    public void correctStartingBoard(){
        PlayingBoard startBoard = new PlayingBoard();
        char[][] board = new char[10][10];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = '~';
            }
        }
        assertArrayEquals(board, startBoard.getBoard());
    }

    @Test
    public void tooSmallSingleCavitiesRemoved(){
        PlayingBoard testBoard = new PlayingBoard();
        int[][] hitCords = {{0,5},{0,6},{0,7},{1,1},{1,3},{1,7},{1,9},{2,0},{2,2},{2,4},{2,8},
        {3,3},{4,4},{4,9},{6,0},{6,2},{6,8},{7,1},{7,7},{7,9},{8,2},{8,6},{8,8},{9,3},{9,7}};

        for(int i = 0; i< hitCords.length; i++){
            testBoard.updateBoard(hitCords[i], 'O');
        }
        testBoard.removeTooSmallCavities();
        char[][] finalBoard = {
            {'~', '~', '~', '~', '~', 'O', 'O', 'O', '~', '~'},
            {'~', 'O', '~', 'O', '~', '~', '~', 'O', '~', 'O'},
            {'O', '~', 'O', 'O', 'O', '~', '~', '~', 'O', '~'},
            {'~', '~', '~', 'O', '~', '~', '~', '~', '~', '~'},
            {'~', '~', '~', '~', 'O', '~', '~', '~', '~', 'O'},
            {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
            {'O', '~', 'O', '~', '~', '~', '~', '~', 'O', '~'},
            {'~', 'O', '~', '~', '~', '~', '~', 'O', 'O', 'O'},
            {'~', '~', 'O', '~', '~', '~', 'O', 'O', 'O', '~'},
            {'~', '~', '~', 'O', '~', '~', '~', 'O', '~', '~'}
        };
        assertArrayEquals(finalBoard, testBoard.getBoard());
    }
    @Test
    public void tooSmallDoubleCavitiesRemoved(){
        PlayingBoard testBoard = new PlayingBoard();
        testBoard.setSmallestShip(3);
        int[][] hitCords = {{0,5},{0,6},{0,7},{1,1},{1,3},{1,7},{1,9},{2,0},{2,2},{2,4},{2,8},
        {3,3},{4,4},{4,9},{6,0},{6,2},{6,8},{7,1},{7,7},{7,9},{8,2},{8,6},{8,8},{9,3},{9,7}};

        for(int i = 0; i< hitCords.length; i++){
            testBoard.updateBoard(hitCords[i], 'O');
        }
        testBoard.removeTooSmallCavities();
        char[][] finalBoard = {
            {'~', '~', '~', '~', '~', 'O', 'O', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'O', '~', '~', '~', 'O', 'O', 'O'},
            {'O', '~', 'O', 'O', 'O', '~', '~', '~', 'O', 'O'},
            {'~', '~', '~', 'O', '~', '~', '~', '~', '~', '~'},
            {'~', '~', '~', '~', 'O', '~', '~', '~', '~', 'O'},
            {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
            {'O', '~', 'O', '~', '~', '~', '~', '~', 'O', 'O'},
            {'~', 'O', '~', '~', '~', '~', '~', 'O', 'O', 'O'},
            {'~', 'O', 'O', '~', '~', '~', 'O', 'O', 'O', 'O'},
            {'~', '~', '~', 'O', '~', '~', '~', 'O', 'O', 'O'}
        };
        assertArrayEquals(finalBoard, testBoard.getBoard());
    }
    @Test
    public void tooSmallTripleCavitiesRemoved(){
        PlayingBoard testBoard = new PlayingBoard();
        testBoard.setSmallestShip(4);
        int[][] hitCords = {{0,5},{0,6},{0,7},{1,1},{1,3},{1,7},{1,9},{2,0},{2,2},{2,4},{2,8},
        {3,3},{4,4},{4,9},{6,0},{6,2},{6,8},{7,1},{7,7},{7,9},{8,2},{8,6},{8,8},{9,3},{9,7}};

        for(int i = 0; i< hitCords.length; i++){
            testBoard.updateBoard(hitCords[i], 'O');
        }
        testBoard.removeTooSmallCavities();
        char[][] finalBoard = {
            {'~', '~', '~', '~', '~', 'O', 'O', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'O', 'O', '~', '~', 'O', 'O', 'O'},
            {'O', '~', 'O', 'O', 'O', '~', '~', '~', 'O', 'O'},
            {'O', '~', 'O', 'O', '~', '~', '~', '~', '~', '~'},
            {'~', '~', '~', '~', 'O', '~', '~', '~', '~', 'O'},
            {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
            {'O', '~', 'O', '~', '~', '~', '~', '~', 'O', 'O'},
            {'O', 'O', '~', '~', '~', '~', '~', 'O', 'O', 'O'},
            {'O', 'O', 'O', '~', '~', '~', 'O', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'O', '~', '~', 'O', 'O', 'O', 'O'}
        };
        assertArrayEquals(finalBoard, testBoard.getBoard());
    }
    @Test
    public void tooSmallQuadCavitiesRemoved(){
        PlayingBoard testBoard = new PlayingBoard();
        testBoard.setSmallestShip(5);
        int[][] hitCords = {{0,5},{0,6},{0,7},{1,1},{1,3},{1,7},{1,9},{2,0},{2,2},{2,4},{2,8},
        {3,3},{4,4},{4,9},{6,0},{6,2},{6,8},{7,1},{7,7},{7,9},{8,2},{8,6},{8,8},{9,3},{9,7}};

        for(int i = 0; i< hitCords.length; i++){
            testBoard.updateBoard(hitCords[i], 'O');
        }
        testBoard.removeTooSmallCavities();
        char[][] finalBoard = {
            {'~', '~', '~', '~', '~', 'O', 'O', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'O', 'O', '~', '~', 'O', 'O', 'O'},
            {'O', '~', 'O', 'O', 'O', '~', '~', '~', 'O', 'O'},
            {'O', '~', 'O', 'O', '~', '~', '~', '~', '~', '~'},
            {'O', '~', 'O', '~', 'O', '~', '~', '~', 'O', 'O'},
            {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
            {'O', '~', 'O', '~', '~', '~', '~', '~', 'O', 'O'},
            {'O', 'O', '~', '~', '~', '~', '~', 'O', 'O', 'O'},
            {'O', 'O', 'O', '~', '~', '~', 'O', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'O', '~', '~', 'O', 'O', 'O', 'O'}
        };
        assertArrayEquals(finalBoard, testBoard.getBoard());
    }


}
