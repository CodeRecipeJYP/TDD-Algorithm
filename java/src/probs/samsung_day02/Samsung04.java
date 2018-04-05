package probs.samsung_day02;

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
        int[][] board = getInput(new Scanner(System.in));

        System.out.println(getMaximumScoreIn(board, 5));
    }

    public static int[][] getInput(Scanner scanner) {
        int memberCount = scanner.nextInt();

        scanner.nextLine();
        int[][] board = new int[memberCount][memberCount];
        for (int rowIdx = 0; rowIdx < memberCount; rowIdx++) {
            for (int colIdx = 0; colIdx < memberCount; colIdx++) {
                board[rowIdx][colIdx] = scanner.nextInt();
            }
        }

        return board;
    }

    public static int getMaximumScoreIn(int[][] board, int trials) {
        Queue<int[][]> prevBoardStates = new LinkedList<>();
        int currTrials = 0;
        prevBoardStates.add(board);

        while (currTrials < trials) {
            currTrials++;

            Queue<int[][]> nextBoardStates = new LinkedList<>();

            while (!prevBoardStates.isEmpty()) {
                int[][] currBoard = prevBoardStates.poll();

                for (int[] direction :
                        DIRECTIONS) {
                    int[][] resultBoard = executeTilt(currBoard, direction);

                    nextBoardStates.add(resultBoard);
                }
            }

            prevBoardStates = nextBoardStates;
        }

        List<Integer> scoreBoard = new ArrayList<>();
        for (int[][] eachBoard:
            prevBoardStates) {
            scoreBoard.add(getScore(eachBoard));
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

        List<int[]> eachLines;
        boolean isReversedDirection;
        if (direction[COL] != 0) {
            eachLines = getEachRows(tiltedBoard);
            isReversedDirection = (direction[COL] == -1);
        } else {
            eachLines = getEachCols(tiltedBoard);
            isReversedDirection = (direction[ROW] == -1);
        }

        List<int[]> eachTiltedLines = new ArrayList<>();
        for (int lineIdx = 0; lineIdx < rowCount; lineIdx++) {
            int[] eachLine = eachLines.get(lineIdx);
            List<Integer> tiltedPiece = tiltEachLine(eachLine);
            int[] tiltedLine = new int[eachLine.length];
            if (isReversedDirection) {
                for (int idx = 0; idx < tiltedPiece.size(); idx++) {
                    tiltedLine[idx] = tiltedPiece.get(idx);
                }
            } else {
                for (int idx = 0; idx < tiltedPiece.size(); idx++) {
                    tiltedLine[eachLine.length - tiltedPiece.size() + idx] = tiltedPiece.get(idx);
                }
            }

            eachTiltedLines.add(tiltedLine);
        }

        if (direction[COL] != 0) {
            for (int rowIdx = 0; rowIdx < eachTiltedLines.size(); rowIdx++) {
                int[] eachRow = eachTiltedLines.get(rowIdx);
                for (int colIdx = 0; colIdx < eachRow.length; colIdx++) {
                    tiltedBoard[rowIdx][colIdx] = eachRow[colIdx];
                }
            }
        } else {
            for (int colIdx = 0; colIdx < eachTiltedLines.size(); colIdx++) {
                int[] eachCol = eachTiltedLines.get(colIdx);
                for (int rowIdx = 0; rowIdx < eachCol.length; rowIdx++) {
                    tiltedBoard[rowIdx][colIdx] = eachCol[rowIdx];
                }
            }
        }

        return tiltedBoard;
    }

    public static List<Integer> tiltEachLine(int[] line) {
        List<Integer> tilted = new ArrayList<>();
        int len = line.length;
        int prev = EMPTY;

        for (int idx = 0; idx < len; idx++) {
            int each = line[idx];
            if (each == EMPTY) {
                continue;
            }

            if (each == prev) {
                tilted.add(each * 2);
                prev = EMPTY;
            } else {
                if (prev != EMPTY) {
                    tilted.add(prev);
                }
                prev = each;
            }
        }

        if (prev != EMPTY) {
            tilted.add(prev);
        }

        return tilted;
    }

    public static List<int[]> getEachCols(int[][] board) {
        List<int[]> result = new ArrayList<>();

        int rowCount = board.length;
        int colCount = board[0].length;

        for (int colIdx = 0; colIdx < colCount; colIdx++) {
            int[] eachCol = new int[rowCount];
            for (int rowIdx = 0; rowIdx < rowCount; rowIdx++) {
                eachCol[rowIdx] = board[rowIdx][colIdx];
            }

            result.add(eachCol);
        }

        return result;
    }

    public static List<int[]> getEachRows(int[][] board) {
        List<int[]> result = new ArrayList<>();

        for (int[] eachRow :
                board) {
            result.add(eachRow);
        }

        return result;
    }

    public static int[][] clone2darr(int[][] board) {
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

    static class Board {
        public int[][] board;

        public Board(int[][] board) {
            this.board = board;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Board)) return false;
            Board board = (Board) o;
            return hashCode() == board.hashCode();
        }

        @Override
        public int hashCode() {
            return java.util.Arrays.deepHashCode(board);
        }
    }
}
