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
                        scoreBoard.add(getScore(currBoard));
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

    public static int getScore(int[][] currBoard) {
        int max = 0;

        for (int[] eachRow :
                currBoard) {
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

        int[][] tiltedBoard = board.clone();

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

            int colStart;
            if (direction[COL] == -1) {
                colStart = 0;
            } else {
                colStart = colCount - 1;
            }

            for (int rowIdx = 0; rowIdx < rowCount; rowIdx++) {
                List<Integer> tiltedRow = tiltedRows.get(rowIdx);
                int colIdx = 0;
                for (int tiltedIdx = 0; tiltedIdx < tiltedRow.size(); tiltedIdx++) {
                    colIdx = colStart + tiltedIdx * -direction[COL];
                    tiltedBoard[rowIdx][colIdx] = tiltedRow.get(tiltedIdx);
                }

                for (colIdx = colIdx + 1; colIdx < colCount; colIdx++) {
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

            int rowStart;
            if (direction[ROW] == -1) {
                rowStart = 0;
            } else {
                rowStart = rowCount - 1;
            }

            for (int colIdx = 0; colIdx < colCount; colIdx++) {
                List<Integer> tiltedCol = tiltedCols.get(colIdx);
                for (int tiltedIdx = 0; tiltedIdx < tiltedCol.size(); tiltedIdx++) {
                    int rowIdx = rowStart + tiltedIdx * -direction[ROW];
                    tiltedBoard[rowIdx][colIdx] = tiltedCol.get(tiltedIdx);
                }
            }
        }

        return tiltedBoard;
    }
}
