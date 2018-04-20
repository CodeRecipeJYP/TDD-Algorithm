package probs.samsung.day02.prob22;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.*;
import static probs.RunAllSuite.TEST_PROJECT_ROOT;
import static probs.samsung.day02.prob22.Game2048.*;
import static probs.samsung.day02.prob22.Game2048.DOWN;
import static probs.samsung.day02.prob22.Game2048.LEFT;
import static probs.samsung.day02.prob22.Game2048.RIGHT;
import static probs.samsung.day02.prob22.Game2048.UP;
import static probs.samsung.day02.prob22.Game2048.getInput;

public class Game2048Test {
    private static final String CLASS_ROOT = TEST_PROJECT_ROOT + "/samsung/day02/prob22";

    @Test
    public void getMaximumScoreIn() {
        int[][] board = new int[][] {
                {2, 2, 2},
                {4, 4, 4},
                {8, 8, 8}
        };

        assertEquals(16,
                Game2048.getMaximumScoreIn(board, 1));
    }

    @Test
    public void getMaximumScoreIn_2() {
        int[][] board = new int[][] {
                {0, 2, 0},
                {2, 0, 0},
                {0, 0, 0}
        };

        assertEquals(2,
                Game2048.getMaximumScoreIn(board, 1));

        assertEquals(4,
                Game2048.getMaximumScoreIn(board, 2));
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
                Game2048.getMaximumScoreIn(board, 1));

        assertEquals(16,
                Game2048.getMaximumScoreIn(board, 2));

        assertEquals(16,
                Game2048.getMaximumScoreIn(board, 5));
    }

    @Test
    public void getMaximumScoreIn_4() {
        int[][] board = new int[][] {
                {2, 4, 8, 2},
                {2, 4, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 2}
        };

//        assertEquals(8,
//                Game2048.getMaximumScoreIn(board, 1));

//        assertEquals(16,
//                Game2048.getMaximumScoreIn(board, 2));

        assertEquals(16,
                Game2048.getMaximumScoreIn(board, 5));
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
                Game2048.getMaximumScoreIn(board, 5));
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
                Game2048.getMaximumScoreIn(board, 5));
    }

    @Test
    public void getMaximumScoreIn_3_1() {
        String pathPrefix = CLASS_ROOT + "/01";
        String inPath = pathPrefix + ".in";
        String outPath = pathPrefix + ".out";

        int expected = 0;
        Scanner scanner = null;
        int[][] board = null;
        try {
            scanner = new Scanner(new File(inPath));
            board = getInput(scanner);
            scanner = new Scanner(new File(outPath));
            expected = scanner.nextInt();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        assertEquals(expected,
                Game2048.getMaximumScoreIn(board, 5));
    }

    @Test
    public void getMaximumScoreIn_3_2() {
        String pathPrefix = CLASS_ROOT + "/01_case02";
        String inPath = pathPrefix + ".in";
        String outPath = pathPrefix + ".out";

        int expected = 0;
        Scanner scanner = null;
        int[][] board = null;
        try {
            scanner = new Scanner(new File(inPath));
            board = getInput(scanner);
            scanner = new Scanner(new File(outPath));
            expected = scanner.nextInt();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        assertEquals(expected,
                Game2048.getMaximumScoreIn(board, 5));
    }

    @Test
    public void getMaximumScoreIn_3_3() {
        String pathPrefix = CLASS_ROOT + "/01_case03";
        String inPath = pathPrefix + ".in";
        String outPath = pathPrefix + ".out";

        int expected = 0;
        Scanner scanner = null;
        int[][] board = null;
        try {
            scanner = new Scanner(new File(inPath));
            board = getInput(scanner);
            scanner = new Scanner(new File(outPath));
            expected = scanner.nextInt();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        assertEquals(expected,
                Game2048.getMaximumScoreIn(board, 5));
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
                Game2048.getMaximumScoreIn(board, 5));
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
                Game2048.getMaximumScoreIn(board, 5));
    }


    @Test
    public void getScore() {
    }

    @Test
    public void executeTilt_5_1() {
        int[][] board = new int[][] {
                {4, 8, 8, 4},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        Board instance = new Board(board, 0, UP);
        instance.executeTilt();

        int[][] expected = new int[][] {
                {8, 8, 8, 4},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        assertArrayEquals(expected, instance.board);
    }

    @Test
    public void executeTilt_twice_1() {
        int[][] board = new int[][] {
                {2, 8, 8, 4},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0}
        };
        Board instance = new Board(board, 0, UP);
        instance.executeTilt();
        instance.executeTilt();

        int[][] expected = new int[][] {
                {8, 8, 8, 4},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        assertArrayEquals(expected, instance.board);
    }

    @Test
    public void executeTilt_priority_1() {
        int[][] board = new int[][] {
                {2, 8, 8, 4},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0}
        };
        Board instance = new Board(board, 0, UP);
        instance.executeTilt();

        int[][] expected = new int[][] {
                {4, 8, 8, 4},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        assertArrayEquals(expected, instance.board);
    }

    @Test
    public void executeTilt_priority_2() {
        int[][] board = new int[][] {
                {2, 8, 8, 4},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0}
        };
        Board instance = new Board(board, 0, DOWN);
        instance.executeTilt();

        int[][] expected = new int[][] {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {4, 8, 8, 4}
        };
        assertArrayEquals(expected, instance.board);
    }

    @Test
    public void executeTilt_priority_left() {
        int[][] board = new int[][] {
                {2, 2, 2, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        Board instance = new Board(board, 0, LEFT);
        instance.executeTilt();

        int[][] expected = new int[][] {
                {4, 2, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        assertArrayEquals(expected, instance.board);
    }

    @Test
    public void executeTilt_priority_right() {
        int[][] board = new int[][] {
                {2, 2, 2, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        Board instance = new Board(board, 0, RIGHT);
        instance.executeTilt();

        int[][] expected = new int[][] {
                {0, 0, 2, 4},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        assertArrayEquals(expected, instance.board);
    }
//
//    @Test
//    public void executeTilt() {
//        int[][] board = new int[][] {
//                {2, 2, 2},
//                {4, 4, 4},
//                {8, 8, 8}
//        };
//
//        int[] direction = DIRECTIONS[UP];
//
//        int[][] expected = new int[][] {
//                {2, 2, 2},
//                {4, 4, 4},
//                {8, 8, 8}
//        };
//
//        assertArrayEquals(
//                expected,
//                Game2048.executeTilt(board, direction)
//        );
//    }
//
//    @Test
//    public void executeTilt_2() {
//        int[][] board = new int[][] {
//                {2, 2, 2},
//                {4, 4, 4},
//                {8, 8, 8}
//        };
//
//        int[] direction = DIRECTIONS[LEFT];
//
//        int[][] expected = new int[][] {
//                {4, 2, 0},
//                {8, 4, 0},
//                {16, 8, 0}
//        };
//
//        assertArrayEquals(
//                expected,
//                Game2048.executeTilt(board, direction)
//        );
//    }
//
//    @Test
//    public void executeTilt_3() {
//        int[][] board = new int[][] {
//                {0, 2, 0},
//                {2, 0, 0},
//                {0, 0, 0}
//        };
//
//        int[] direction = DIRECTIONS[LEFT];
//
//        int[][] expected = new int[][] {
//                {2, 0, 0},
//                {2, 0, 0},
//                {0, 0, 0}
//        };
//
//        assertArrayEquals(
//                expected,
//                Game2048.executeTilt(board, direction)
//        );
//    }
//
//    @Test
//    public void executeTilt_4() {
//        int[][] board = new int[][] {
//                {0, 2, 0},
//                {2, 0, 0},
//                {0, 0, 0}
//        };
//
//        int[] direction = DIRECTIONS[LEFT];
//
//        int[][] expected = new int[][] {
//                {2, 0, 0},
//                {2, 0, 0},
//                {0, 0, 0}
//        };
//
//        assertArrayEquals(
//                expected,
//                Game2048.executeTilt(board, direction)
//        );
//    }
//
//    @Test
//    public void executeTilt_2_1() {
//        int[][] board = new int[][] {
//                {1, 2, 3},
//                {0, 0, 0},
//                {0, 0, 0}
//        };
//
//        int[] direction = DIRECTIONS[RIGHT];
//
//        int[][] expected = new int[][] {
//                {1, 2, 3},
//                {0, 0, 0},
//                {0, 0, 0}
//        };
//
//        assertArrayEquals(
//                expected,
//                Game2048.executeTilt(board, direction)
//        );
//    }
//
//    @Test
//    public void executeTilt_2_2() {
//        int[][] board = new int[][] {
//                {1, 2, 3, 0},
//                {0, 0, 0, 0},
//                {0, 0, 0, 0},
//                {0, 0, 0, 0}
//        };
//
//        int[] direction = DIRECTIONS[RIGHT];
//
//        int[][] expected = new int[][] {
//                {0, 1, 2, 3},
//                {0, 0, 0, 0},
//                {0, 0, 0, 0},
//                {0, 0, 0, 0}
//        };
//
//        assertArrayEquals(
//                expected,
//                Game2048.executeTilt(board, direction)
//        );
//    }
//
//    @Test
//    public void executeTilt_2_3() {
//        int[][] board = new int[][] {
//                {1, 2, 3, 0},
//                {0, 0, 0, 0},
//                {0, 1, 0, 0},
//                {0, 4, 0, 0}
//        };
//
//        int[] direction = DIRECTIONS[DOWN];
//
//        int[][] expected = new int[][] {
//                {0, 0, 0, 0},
//                {0, 2, 0, 0},
//                {0, 1, 0, 0},
//                {1, 4, 3, 0}
//        };
//
//        assertArrayEquals(
//                expected,
//                Game2048.executeTilt(board, direction)
//        );
//    }
//
//    @Test
//    public void executeTilt_2_4() {
//        int[][] board = new int[][] {
//                {0, 2, 0, 0},
//                {0, 0, 0, 0},
//                {0, 0, 0, 0},
//                {1, 4, 3, 0}
//        };
//
//        int[] direction = DIRECTIONS[UP];
//
//        int[][] expected = new int[][] {
//                {1, 2, 3, 0},
//                {0, 4, 0, 0},
//                {0, 0, 0, 0},
//                {0, 0, 0, 0}
//        };
//
//        assertArrayEquals(
//                expected,
//                Game2048.executeTilt(board, direction)
//        );
//    }
//
//    @Test
//    public void executeTilt_2_5() {
//        int[][] board = new int[][] {
//                {0, 2, 0, 0},
//                {0, 0, 0, 0},
//                {0, 0, 0, 0},
//                {1, 4, 3, 0}
//        };
//
//        int[] direction = DIRECTIONS[RIGHT];
//
//        int[][] expected = new int[][] {
//                {0, 0, 0, 2},
//                {0, 0, 0, 0},
//                {0, 0, 0, 0},
//                {0, 1, 4, 3}
//        };
//
//        assertArrayEquals(
//                expected,
//                Game2048.executeTilt(board, direction)
//        );
//    }
//
//    @Test
//    public void originDoesntChange_afterExecuteTilt() {
//        int[][] board = new int[][] {
//                {0, 2, 0, 0},
//                {0, 0, 0, 0},
//                {0, 0, 0, 0},
//                {1, 4, 3, 0}
//        };
//
//        int[] direction = DIRECTIONS[RIGHT];
//
//        int[][] expected = new int[][] {
//                {0, 2, 0, 0},
//                {0, 0, 0, 0},
//                {0, 0, 0, 0},
//                {1, 4, 3, 0}
//        };
//
//        Game2048.executeTilt(board, direction);
//
//        assertArrayEquals(
//                expected,
//                board
//        );
//    }
//
//    @Test
//    public void executeTilt_5() {
//        int[][] board = new int[][] {
//                {0, 2, 0},
//                {2, 0, 0},
//                {0, 0, 0}
//        };
//
//        int[] direction = DIRECTIONS[LEFT];
//
//        int[][] expected = new int[][] {
//                {2, 0, 0},
//                {2, 0, 0},
//                {0, 0, 0}
//        };
//
//        assertArrayEquals(
//                expected,
//                Game2048.executeTilt(board, direction)
//        );
//    }
//
//    @Test
//    public void executeTilt_6() {
//        int[][] board = new int[][] {
//                {0, 2, 0},
//                {2, 0, 0},
//                {0, 0, 0}
//        };
//
//        int[] direction = DIRECTIONS[UP];
//
//        int[][] expected = new int[][] {
//                {2, 2, 0},
//                {0, 0, 0},
//                {0, 0, 0}
//        };
//
//        assertArrayEquals(
//                expected,
//                Game2048.executeTilt(board, direction)
//        );
//    }
//
//    @Test
//    public void executeTilt_7() {
//        int[][] board = new int[][] {
//                {0, 2, 0},
//                {2, 0, 0},
//                {0, 0, 0}
//        };
//
//        int[] direction = DIRECTIONS[DOWN];
//
//        int[][] expected = new int[][] {
//                {0, 0, 0},
//                {0, 0, 0},
//                {2, 2, 0}
//        };
//
//        assertArrayEquals(
//                expected,
//                Game2048.executeTilt(board, direction)
//        );
//    }
//
//    @Test
//    public void executeTilt_8() {
//        int[][] board = new int[][] {
//                {0, 2, 0},
//                {2, 0, 0},
//                {0, 0, 0}
//        };
//
//        int[] direction = DIRECTIONS[RIGHT];
//
//        int[][] expected = new int[][] {
//                {0, 0, 2},
//                {0, 0, 2},
//                {0, 0, 0}
//        };
//
//        assertArrayEquals(
//                expected,
//                Game2048.executeTilt(board, direction)
//        );
//    }
}