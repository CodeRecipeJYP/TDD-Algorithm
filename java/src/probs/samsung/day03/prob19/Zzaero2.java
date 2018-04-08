package probs.samsung.day03.prob19;

import javafx.util.Pair;

import java.util.*;

public class Zzaero2 {
    public static final int[][] DIRECTIONS = new int[][] {
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

    public static final char EMPTY = '.';
    public static final char RED = 'R';
    public static final char BLUE = 'B';
    public static final char HOLE = 'O';
    public static final char WALL = '#';

    public static final int IMPOSSIBLE = -1;

    public static final int GAMENOTEND = 0;
    public static final int GAMECLEAR = 1;
    public static final int GAMEOVER = 2;

    public static final int SIZE_MAX = 10;

    public static void main(String[] args) {
        char[][] map = getInput(new Scanner(System.in));

        System.out.println(getMinimumTrials(map));
    }

    public static int getMinimumTrials(char[][] map) {
        char[][] cleanMap = getCleanMap(map);
        Queue<State> currQueue = new LinkedList();
        Set<State> duplicateValidateSet = new HashSet();

        State initialState = getState(map);
        duplicateValidateSet.add(initialState);
        currQueue.add(initialState);
        int currTrials = 0;

        while (!currQueue.isEmpty() && currTrials < 10) {
            currTrials++;
            Queue<State> nextQueue = new LinkedList();

            while (!currQueue.isEmpty()) {
                State currState = currQueue.poll();
                for (int[] direction :
                        DIRECTIONS) {
                    State state = executeTilt(cleanMap, currState, direction);
                    int gameResult = getGameResult(cleanMap, state);
                    if (gameResult == GAMEOVER) {
                        continue;
                    } else if (gameResult == GAMECLEAR) {
                        return currTrials;
                    }

                    if (duplicateValidateSet.contains(state)) {
                        continue;
                    } else {
                        duplicateValidateSet.add(state);
                        nextQueue.add(state);
                    }
                }
            }

            currQueue = nextQueue;
        }

        return IMPOSSIBLE;
    }

    public static int getGameResult(char[][] cleanMap, State state) {
        if (cleanMap[state.blueRow][state.blueCol] == HOLE) {
            return GAMEOVER;
        } else if (cleanMap[state.redRow][state.redCol] == HOLE) {
            return GAMECLEAR;
        }

        return GAMENOTEND;
    }

    public static char[][] getCleanMap(char[][] map) {
        char[][] cleanMap = copy2darr(map);
        State state = getState(cleanMap);

        cleanMap[state.redRow][state.redCol] = EMPTY;
        cleanMap[state.blueRow][state.blueCol] = EMPTY;

        return cleanMap;
    }

    public static State executeTilt(char[][] map, State state, int[] direction) {
        char[][] tilted = copy2darr(map);
        State tiltedState = new State();

        Queue<Pair<Character, Pair<Integer, Integer>>> queue
                = new LinkedList();
        Pair red = new Pair('R', new Pair(state.redRow, state.redCol));
        Pair blue = new Pair('B', new Pair(state.blueRow, state.blueCol));

        boolean isRedFirst = conv(state.redRow, state.redCol, direction[ROW], direction[COL])
                > conv(state.blueRow, state.blueCol, direction[ROW], direction[COL]);

        if (isRedFirst) {
            queue.add(red);
            queue.add(blue);
        } else {
            queue.add(blue);
            queue.add(red);
        }

        while (true) {
            if (queue.isEmpty()) {
                break;
            }

            Pair<Character, Pair<Integer, Integer>> ball = queue.poll();
            char ballCharactor = ball.getKey();
            Pair<Integer, Integer> location = ball.getValue();
            int row = location.getKey();
            int col = location.getValue();
            int nextRow = row;
            int nextCol = col;
            tilted[row][col] = EMPTY;

            while (true) {
                nextRow += direction[ROW];
                nextCol += direction[COL];

                char next = tilted[nextRow][nextCol];
                if (next == WALL || next == RED || next == BLUE) {
                    tilted[row][col] = ballCharactor;
                    break;
                } else if (next == HOLE) {
                    row = nextRow;
                    col = nextCol;
                    break;
                }

                row = nextRow;
                col = nextCol;
            }

            if (ballCharactor == BLUE) {
                tiltedState.setBlue(row, col);
            } else {
                tiltedState.setRed(row, col);
            }
        }

        return tiltedState;
    }

    private static int conv(int row1, int col1, int row2, int col2) {
        return row1 * row2 + col1 * col2;
    }

    public static State getState(char[][] map) {
        int rowCount = map.length;
        int colCount = map[0].length;

        State state = new State();

        for (int rowIdx = 1; rowIdx < rowCount - 1; rowIdx++) {
            for (int colIdx = 1; colIdx < colCount - 1; colIdx++) {
                if (map[rowIdx][colIdx] == RED) {
                    state.setRed(rowIdx, colIdx);
                    if (state.isEnough()) {
                        break;
                    }
                } else if (map[rowIdx][colIdx] == BLUE) {
                    state.setBlue(rowIdx, colIdx);
                    if (state.isEnough()) {
                        break;
                    }
                }
            }
        }

        return state;
    }

    private static char[][] copy2darr(char[][] map) {
        int rowCount = map.length;
        int colCount = map[0].length;

        char[][] copy = new char[rowCount][colCount];

        for (int rowIdx = 0; rowIdx < rowCount; rowIdx++) {
            for (int colIdx = 0; colIdx < colCount; colIdx++) {
                copy[rowIdx][colIdx] = map[rowIdx][colIdx];
            }
        }

        return copy;
    }

    static char[][] getInput(Scanner scanner) {
        int rowCount = scanner.nextInt();
        int colCount = scanner.nextInt();

        scanner.nextLine();

        char[][] map = new char[rowCount][colCount];
        for (int rowIdx = 0; rowIdx < rowCount; rowIdx++) {
            String eachRow = scanner.nextLine();
            for (int colIdx = 0; colIdx < colCount; colIdx++) {
                map[rowIdx][colIdx] = eachRow.charAt(colIdx);
            }
        }

        return map;
    }

    static class State {
        public int redRow = -1;
        public int redCol = -1;
        public int blueRow = -1;
        public int blueCol = -1;

        public boolean isEnough() {
            return redRow != -1 && redCol != -1
                    && blueRow != -1 && blueCol != -1;
        }

        public void setRed(int rowIdx, int colIdx) {
            redRow = rowIdx;
            redCol = colIdx;
        }

        public void setBlue(int rowIdx, int colIdx) {
            blueRow = rowIdx;
            blueCol = colIdx;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof State)) return false;
            State state = (State) o;
            return redRow == state.redRow &&
                    redCol == state.redCol &&
                    blueRow == state.blueRow &&
                    blueCol == state.blueCol;
        }

        @Override
        public int hashCode() {
            int base = SIZE_MAX + 1;
            int hash = (int) (Math.pow(base, 0) * redRow +
                                Math.pow(base, 1) * redCol +
                                Math.pow(base, 2) * blueRow +
                                Math.pow(base, 3) * blueCol);

            return hash;
        }
    }
}
