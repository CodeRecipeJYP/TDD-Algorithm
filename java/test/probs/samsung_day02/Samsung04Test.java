package probs.samsung_day02;

import org.junit.Test;

import static org.junit.Assert.*;
import static probs.samsung_day02.Samsung04.*;

public class Samsung04Test {

    @Test
    public void getMaximumScoreIn() {
    }

    @Test
    public void getScore() {
    }

    @Test
    public void executeTilt() {
        int[][] board = new int[][] {
                {2, 2, 2},
                {4, 4, 4},
                {8, 8, 8}
        };

        int[] direction = DIRECTIONS[UP];

        int[][] expected = new int[][] {
                {2, 2, 2},
                {4, 4, 4},
                {8, 8, 8}
        };

        assertArrayEquals(
                expected,
                Samsung04.executeTilt(board, direction)
        );
    }

    @Test
    public void executeTilt_2() {
        int[][] board = new int[][] {
                {2, 2, 2},
                {4, 4, 4},
                {8, 8, 8}
        };

        int[] direction = DIRECTIONS[LEFT];

        int[][] expected = new int[][] {
                {4, 2, 0},
                {8, 4, 0},
                {16, 8, 0}
        };

        assertArrayEquals(
                expected,
                Samsung04.executeTilt(board, direction)
        );
    }
}