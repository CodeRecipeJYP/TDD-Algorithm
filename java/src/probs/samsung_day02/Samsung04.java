package probs.samsung_day02;

import javafx.util.Pair;

import java.util.*;

public class Samsung04 {
    public static final int[][] DIRECTIONS = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;

    public static final int ROW = 0;
    public static final int COL = 1;

    public static final int EMPTY = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int memberCount = scanner.nextInt();

        scanner.nextLine();
        int[][] board = new int[memberCount][memberCount];
        for (int rowIdx = 0; rowIdx < memberCount; rowIdx++) {
            for (int colIdx = 0; colIdx < memberCount; colIdx++) {
                board[rowIdx][colIdx] = scanner.nextInt();
            }
        }

        System.out.println(getMaximumScoreIn(board, 5));
    }

    public static int getMaximumScoreIn(int[][] board, int trials) {
        Set<int[][]> prevMaps = new HashSet<>();
        prevMaps.add(board);

        Queue<Pair<int[][], Integer>> queue = new LinkedList<>();
        queue.add(new Pair<int[][], Integer>(board, 0));

        List<Integer> scoreBoard = new ArrayList<>();

        while (!queue.isEmpty()) {
            Pair<int[][], Integer> poll = queue.poll();

            int[][] currBoard = poll.getKey();
            int currTrials = poll.getValue();

            for (int[] direction :
                    DIRECTIONS) {
                int[][] resultBoard = executeTilt(currBoard, direction);

                if (!prevMaps.contains(resultBoard)) {
                    prevMaps.add(resultBoard);
                    if (currTrials + 1 == trials) {
                        scoreBoard.add(getScore(resultBoard));
                    } else {
                        queue.add(new Pair(resultBoard, currTrials + 1));
                    }
                }
            }
        }

        return getMaximum(scoreBoard);
    }

    private static int getMaximum(List<Integer> scoreBoard) {
        int max = 0;
        for (int score:
             scoreBoard) {
            if (max < score) {
                max = score;
            }
        }

        return max;
    }

    public static int getScore(int[][] board) {
        int max = 0;

        for (int[] eachRow :
                board) {
            for (int score:
                    eachRow) {
                if (max < score) {
                    max = score;
                }
            }
        }

        return max;
    }

    public static int[][] executeTilt(int[][] board, int[] direction) {
        int rowCount = board.length;
        int colCount = board[0].length;

        int[][] tiltedBoard = clone2darr(board);

        if (direction[COL] != 0) {
            List<List<Integer>> tiltedRows = new ArrayList<>();
            for (int rowIdx = 0; rowIdx < rowCount; rowIdx++) {
                List<Integer> resultEachRow = new ArrayList<>();
                int prev = EMPTY;

                for (int colIdx = 0; colIdx < colCount; colIdx++) {
                    int each = board[rowIdx][colIdx];
                    if (each == EMPTY) {
                        continue;
                    }

                    if (each == prev) {
                        resultEachRow.add(each * 2);
                        prev = EMPTY;
                    } else {
                        if (prev != EMPTY) {
                            resultEachRow.add(prev);
                        }
                        prev = each;
                    }
                }

                if (prev != EMPTY) {
                    resultEachRow.add(prev);
                }

                tiltedRows.add(resultEachRow);
            }

            int startBlanks;
            int endBlanks;

            for (int rowIdx = 0; rowIdx < rowCount; rowIdx++) {
                List<Integer> tiltedRow = tiltedRows.get(rowIdx);

                if (direction[COL] == -1) {
                    startBlanks = 0;
                    endBlanks = colCount - tiltedRow.size();
                } else {
                    startBlanks = colCount - tiltedRow.size();
                    endBlanks = colCount;
                }

                for (int tiltedIdx = 0; tiltedIdx < tiltedRow.size(); tiltedIdx++) {
                    int colIdx = startBlanks + tiltedIdx;
                    tiltedBoard[rowIdx][colIdx] = tiltedRow.get(tiltedIdx);
                }

                for (int colIdx = 0; colIdx < startBlanks; colIdx++) {
                    tiltedBoard[rowIdx][colIdx] = EMPTY;
                }

                for (int colIdx = endBlanks; colIdx < colCount; colIdx++) {
                    tiltedBoard[rowIdx][colIdx] = EMPTY;
                }
            }

            //
        } else if (direction[ROW] != 0) {
            List<List<Integer>> tiltedCols = new ArrayList<>();
            for (int colIdx = 0; colIdx < colCount; colIdx++) {
                List<Integer> resultEachCol = new ArrayList<>();
                int prev = EMPTY;

                for (int rowIdx = 0; rowIdx  < rowCount; rowIdx++) {
                    int each = board[rowIdx][colIdx];
                    if (each == EMPTY) {
                        continue;
                    }

                    if (each == prev) {
                        resultEachCol.add(each * 2);
                        prev = EMPTY;
                    } else {
                        if (prev != EMPTY) {
                            resultEachCol.add(prev);
                        }
                        prev = each;
                    }
                }

                if (prev != EMPTY) {
                    resultEachCol.add(prev);
                }

                tiltedCols.add(resultEachCol);
            }

            int startBlanks;
            int endBlanks;

            for (int colIdx = 0; colIdx < colCount; colIdx++) {
                List<Integer> tiltedCol = tiltedCols.get(colIdx);

                if (direction[ROW] == -1) {
                    startBlanks = 0;
                    endBlanks = rowCount - tiltedCol.size();
                } else {
                    startBlanks = rowCount - tiltedCol.size();
                    endBlanks = rowCount;
                }

                for (int tiltedIdx = 0; tiltedIdx < tiltedCol.size(); tiltedIdx++) {
                    int rowIdx = startBlanks + tiltedIdx;
                    tiltedBoard[rowIdx][colIdx] = tiltedCol.get(tiltedIdx);
                }

                for (int rowIdx = 0; rowIdx < startBlanks; rowIdx++) {
                    tiltedBoard[rowIdx][colIdx] = EMPTY;
                }

                for (int rowIdx = endBlanks; rowIdx < rowCount; rowIdx++) {
                    tiltedBoard[rowIdx][colIdx] = EMPTY;
                }
            }
        }

        return tiltedBoard;
    }

    private static int[][] clone2darr(int[][] board) {
        int rowCount = board.length;
        int colCount = board[0].length;

        int[][] clone = new int[rowCount][colCount];

        for (int rowIdx = 0; rowIdx < rowCount; rowIdx++) {
            for (int colIdx = 0; colIdx < colCount; colIdx++) {
                clone[colIdx][rowIdx] = board[colIdx][rowIdx];
            }
        }

        return clone;
    }
}
