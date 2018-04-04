package probs.samsung_day02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;
import static probs.samsung_day02.Samsung04.*;

public class Samsung04Test {

    @Test
    public void getMaximumScoreIn() {
        int[][] board = new int[][] {
                {2, 2, 2},
                {4, 4, 4},
                {8, 8, 8}
        };

        assertEquals(16,
                Samsung04.getMaximumScoreIn(board, 1));
    }

    @Test
    public void getMaximumScoreIn_2() {
        int[][] board = new int[][] {
                {0, 2, 0},
                {2, 0, 0},
                {0, 0, 0}
        };

        assertEquals(2,
                Samsung04.getMaximumScoreIn(board, 1));

        assertEquals(4,
                Samsung04.getMaximumScoreIn(board, 2));
    }

    @Test
    public void getMaximumScoreIn_3() {
        int[][] board = new int[][] {
                {2, 4, 8, 2},
                {2, 4, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 2}
        };

        assertEquals(8,
                Samsung04.getMaximumScoreIn(board, 1));

        assertEquals(16,
                Samsung04.getMaximumScoreIn(board, 2));

        assertEquals(16,
                Samsung04.getMaximumScoreIn(board, 5));
    }

    @Test
    public void getMaximumScoreIn_4() {
        int[][] board = new int[][] {
                {2, 4, 8, 2},
                {2, 4, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 2}
        };

        assertEquals(8,
                Samsung04.getMaximumScoreIn(board, 1));

        assertEquals(16,
                Samsung04.getMaximumScoreIn(board, 2));

        assertEquals(16,
                Samsung04.getMaximumScoreIn(board, 5));
    }

    @Test
    public void getMaximumScoreIn_5() {
        int[][] board = new int[][] {
                {8, 1, 16, 32, 4},
                {4, 16, 2, 1, 1},
                {16, 1, 32, 1, 16},
                {32, 8, 8, 1, 16},
                {8, 32, 16, 8, 2}
        };

        assertEquals(128,
                Samsung04.getMaximumScoreIn(board, 5));
    }

    @Test
    public void getMaximumScoreIn_6() {
        int[][] board = new int[][] {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1}
        };

        assertEquals(1,
                Samsung04.getMaximumScoreIn(board, 5));
    }

    @Test
    public void getMaximumScoreIn_2_1() {
        ArrayList<String> rawInput = new ArrayList<>();
        rawInput.add("1 1 4 16 16 16 32 16 8 1 1 1 1 32 2 1 8 4 4 4");
        rawInput.add("16 8 8 8 1 4 2 2 16 1 4 4 32 32 8 8 2 2 16 8");
        rawInput.add("16 1 32 1 1 2 16 16 8 1 32 1 32 4 4 32 1 1 2 8");
        rawInput.add("8 16 4 16 8 2 16 4 16 32 16 1 16 2 2 2 16 1 8 16");
        rawInput.add("16 8 2 16 1 32 8 1 4 8 16 1 8 16 16 8 4 2 8 2");
        rawInput.add("1 16 32 8 16 8 4 4 32 4 2 16 4 2 8 32 1 32 2 16");
        rawInput.add("8 2 16 2 4 8 1 1 1 2 1 8 1 1 16 4 4 8 8 2");
        rawInput.add("2 16 4 8 32 4 4 2 4 1 2 1 4 8 1 4 16 1 2 8");
        rawInput.add("16 32 2 32 32 32 1 2 32 1 2 2 32 8 1 32 4 16 16 4");
        rawInput.add("8 16 1 32 8 4 8 2 8 4 1 32 32 4 2 16 2 1 32 8");
        rawInput.add("4 32 2 16 16 1 16 1 16 2 4 32 8 8 1 4 1 32 32 2");
        rawInput.add("32 32 8 1 1 4 32 4 1 2 4 1 32 2 4 2 32 2 2 4");
        rawInput.add("32 32 8 8 8 2 32 8 8 32 2 32 8 2 2 4 4 16 16 1");
        rawInput.add("2 8 32 1 8 8 16 32 1 16 2 1 1 1 1 16 32 32 4 16");
        rawInput.add("2 2 4 16 8 2 8 16 2 16 16 2 1 32 8 8 2 2 4 32");
        rawInput.add("4 16 4 32 32 2 8 4 4 4 16 4 8 32 2 16 2 2 1 4");
        rawInput.add("32 1 16 2 1 32 8 1 1 1 4 16 32 32 4 8 16 1 4 8");
        rawInput.add("32 16 8 32 32 1 16 4 16 32 4 8 32 2 16 16 16 2 32 2");
        rawInput.add("32 1 32 32 8 4 4 2 2 1 4 32 2 1 2 1 4 1 4 32");
        rawInput.add("16 1 1 1 16 32 2 32 2 32 1 16 16 32 16 1 8 16 16 32");

        int n = 20;

        int[][] board = new int[n][n];

        for (int rowIdx = 0; rowIdx < rawInput.size(); rowIdx++) {
            String eachline = rawInput.get(rowIdx);
            Scanner scanner = new Scanner(eachline);
            for (int colIdx = 0; colIdx < n; colIdx++) {
                board[rowIdx][colIdx] = scanner.nextInt();
            }
        }

        assertEquals(128,
                Samsung04.getMaximumScoreIn(board, 5));
    }

    @Test
    public void getMaximumScoreIn_2_2() {
        ArrayList<String> rawInput = new ArrayList<>();
        rawInput.add("8 16");
        rawInput.add("16 8");

        int n = 2;

        int[][] board = new int[n][n];

        for (int rowIdx = 0; rowIdx < rawInput.size(); rowIdx++) {
            String eachline = rawInput.get(rowIdx);
            Scanner scanner = new Scanner(eachline);
            for (int colIdx = 0; colIdx < n; colIdx++) {
                board[rowIdx][colIdx] = scanner.nextInt();
            }
        }

        assertEquals(16,
                Samsung04.getMaximumScoreIn(board, 5));
    }

    @Test
    public void getMaximumScoreIn_2_3() {
        ArrayList<String> rawInput = new ArrayList<>();
        rawInput.add("0 0 0 0 0 32 8 64 8 16");
        rawInput.add("0 0 0 0 0 0 0 16 8 16");
        rawInput.add("0 0 0 0 0 0 0 0 0 2");
        rawInput.add("0 0 0 0 0 0 0 0 0 0");
        rawInput.add("0 0 0 0 0 0 0 0 0 0");
        rawInput.add("0 0 0 0 0 0 0 0 0 0");
        rawInput.add("0 0 0 0 0 0 0 0 0 0");
        rawInput.add("0 0 0 0 0 0 0 0 0 0");
        rawInput.add("0 0 0 0 0 0 0 0 0 0");
        rawInput.add("0 0 0 0 0 0 0 0 0 0");

        int n = 10;

        int[][] board = new int[n][n];

        for (int rowIdx = 0; rowIdx < rawInput.size(); rowIdx++) {
            String eachline = rawInput.get(rowIdx);
            Scanner scanner = new Scanner(eachline);
            for (int colIdx = 0; colIdx < n; colIdx++) {
                board[rowIdx][colIdx] = scanner.nextInt();
            }
        }

        assertEquals(128,
                Samsung04.getMaximumScoreIn(board, 5));
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

    @Test
    public void executeTilt_3() {
        int[][] board = new int[][] {
                {0, 2, 0},
                {2, 0, 0},
                {0, 0, 0}
        };

        int[] direction = DIRECTIONS[LEFT];

        int[][] expected = new int[][] {
                {2, 0, 0},
                {2, 0, 0},
                {0, 0, 0}
        };

        assertArrayEquals(
                expected,
                Samsung04.executeTilt(board, direction)
        );
    }

    @Test
    public void executeTilt_4() {
        int[][] board = new int[][] {
                {0, 2, 0},
                {2, 0, 0},
                {0, 0, 0}
        };

        int[] direction = DIRECTIONS[LEFT];

        int[][] expected = new int[][] {
                {2, 0, 0},
                {2, 0, 0},
                {0, 0, 0}
        };

        assertArrayEquals(
                expected,
                Samsung04.executeTilt(board, direction)
        );
    }

    @Test
    public void executeTilt_2_1() {
        int[][] board = new int[][] {
                {1, 2, 3},
                {0, 0, 0},
                {0, 0, 0}
        };

        int[] direction = DIRECTIONS[RIGHT];

        int[][] expected = new int[][] {
                {1, 2, 3},
                {0, 0, 0},
                {0, 0, 0}
        };

        assertArrayEquals(
                expected,
                Samsung04.executeTilt(board, direction)
        );
    }

    @Test
    public void executeTilt_2_2() {
        int[][] board = new int[][] {
                {1, 2, 3, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        int[] direction = DIRECTIONS[RIGHT];

        int[][] expected = new int[][] {
                {0, 1, 2, 3},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        assertArrayEquals(
                expected,
                Samsung04.executeTilt(board, direction)
        );
    }

    @Test
    public void executeTilt_5() {
        int[][] board = new int[][] {
                {0, 2, 0},
                {2, 0, 0},
                {0, 0, 0}
        };

        int[] direction = DIRECTIONS[LEFT];

        int[][] expected = new int[][] {
                {2, 0, 0},
                {2, 0, 0},
                {0, 0, 0}
        };

        assertArrayEquals(
                expected,
                Samsung04.executeTilt(board, direction)
        );
    }

    @Test
    public void executeTilt_6() {
        int[][] board = new int[][] {
                {0, 2, 0},
                {2, 0, 0},
                {0, 0, 0}
        };

        int[] direction = DIRECTIONS[UP];

        int[][] expected = new int[][] {
                {2, 2, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        assertArrayEquals(
                expected,
                Samsung04.executeTilt(board, direction)
        );
    }

    @Test
    public void executeTilt_7() {
        int[][] board = new int[][] {
                {0, 2, 0},
                {2, 0, 0},
                {0, 0, 0}
        };

        int[] direction = DIRECTIONS[DOWN];

        int[][] expected = new int[][] {
                {0, 0, 0},
                {0, 0, 0},
                {2, 2, 0}
        };

        assertArrayEquals(
                expected,
                Samsung04.executeTilt(board, direction)
        );
    }

    @Test
    public void executeTilt_8() {
        int[][] board = new int[][] {
                {0, 2, 0},
                {2, 0, 0},
                {0, 0, 0}
        };

        int[] direction = DIRECTIONS[RIGHT];

        int[][] expected = new int[][] {
                {0, 0, 2},
                {0, 0, 2},
                {0, 0, 0}
        };

        assertArrayEquals(
                expected,
                Samsung04.executeTilt(board, direction)
        );
    }
}