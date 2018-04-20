package probs.samsung.day02.prob22;

import java.util.*;

public class Game2048 {
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

    static int[][] getInput(Scanner scanner) {
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
        Stack<Board> stack = new Stack();

        stack.push(new Board(board, 0, UP));

        List<Integer> scoreBoard = new ArrayList<>();

        while (!stack.isEmpty()) {
            Board currBoard = stack.pop();

            if (currBoard.isDirectionIncrementable()) {
                Board copy = currBoard.copy();
                copy.incrementDirection();
                stack.push(copy);
            }

            currBoard.executeTilt();

            if (currBoard.depth != trials) {
                stack.push(currBoard);
            } else {
                scoreBoard.add(getScore(currBoard.board));
            }
        }

        return getMaximum(scoreBoard);
    }

    private static void printBoard(String message, int[][] board) {
        System.out.println(message);
        for (int[] eachRow:
        board){
            Arrays.stream(eachRow)
                    .forEach(it -> System.out.print(it + " "));
            System.out.println();
        }
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

    public static List<Integer> tiltEachLine(int[] line, boolean reversed) {
        List<Integer> tilted = new ArrayList<>();
        int len = line.length;
        int prev = EMPTY;

        if (!reversed) {
            line = reverseArray(line);
        }

        for (int idx = 0; idx < len; idx ++) {
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

        if (!reversed) {
            tilted = reverseList(tilted);
        }

        return tilted;
    }

    private static List<Integer> reverseList(List<Integer> list) {
        List<Integer> reversed = new ArrayList<>();
        for (int idx = list.size() - 1; idx >= 0; idx--) {
            reversed.add(list.get(idx));
        }

        return reversed;
    }

    private static int[] reverseArray(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int idx = 0; idx < arr.length; idx++) {
            reversed[arr.length - 1 - idx] = arr[idx];
        }
        return reversed;
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
        public int depth;
        public int directionIdx;
        public List<Integer> prevDirections = new ArrayList<>();

        public Board(int[][] board, int depth, int direction) {
            this.board = board;
            this.depth = depth;
            this.directionIdx = direction;
        }

        public void incrementDepth(int[][] tilted) {
            board = tilted;
            depth += 1;
            prevDirections.add(directionIdx);
            directionIdx = UP;
        }

        public boolean incrementDirection() {
            if (directionIdx == RIGHT) {
                return false;
            } else {
                directionIdx += 1;
                return true;
            }
        }

        public boolean isDirectionIncrementable() {
            return !(directionIdx == RIGHT);
        }

        public Board copy() {
            Board copy = new Board(board, depth, directionIdx);
            copy.prevDirections = new ArrayList(prevDirections);
            return copy;
        }

        public void executeTilt() {
            int[] direction = DIRECTIONS[directionIdx];

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
                List<Integer> tiltedPiece = tiltEachLine(eachLine, isReversedDirection);
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

            incrementDepth(tiltedBoard);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            sb.append("Board{");
            sb.append("board= ");
            sb.append(toString2darr(board));
            sb.append(", depth=" + depth);

            for (int direction:
            prevDirections) {
                switch (direction) {
                    case UP:
                        sb.append("UP");
                        break;
                    case DOWN:
                        sb.append("DOWN");
                        break;
                    case RIGHT:
                        sb.append("RIGHT");
                        break;
                    case LEFT:
                        sb.append("LEFT");
                        break;
                }
                sb.append(" ");
            }

            sb.append('}');

            return sb.toString();
        }

        private String toString2darr(int[][] board) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");

            for (int[] eachRow:
            board){
                for (int each:
                eachRow) {
                    sb.append(String.format("%4d ", each));
                }

                sb.append("\n");
            }

            return sb.toString();
        }
    }
}
