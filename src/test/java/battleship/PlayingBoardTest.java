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

}
