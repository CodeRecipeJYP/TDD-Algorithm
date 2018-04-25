package probs.prob47;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;


public class BreakingWallMain {
    private static final int[] UP = new int[] {-1, 0};
    private static final int[] RIGHT = new int[] {0, 1};
    private static final int[] DOWN = new int[] {1, 0};
    private static final int[] LEFT = new int[] {0, -1};

    private static final int ROW = 0;
    private static final int COL = 1;

    private static final int[][] DIRECTIONS = new int[][] {
        UP, RIGHT, DOWN, LEFT
    };

    private static int EMPTY = 0;
    private static int WALL = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowCountN = scanner.nextInt();
        int colCountM = scanner.nextInt();
        scanner.nextLine();

        int[][] map = new int[rowCountN][colCountM];
        for (int rowIdx = 0; rowIdx < rowCountN; rowIdx++) {
            String eachRow = scanner.nextLine();
            for (int colIdx = 0; colIdx < colCountM; colIdx++) {
                map[rowIdx][colIdx] = eachRow.charAt(colIdx) - '0';
            }
        }

        System.out.println(bfs(map));
    }

    private static int bfs(int[][] map) {
        int depth = 1;
        State initialState = new State(0, 0);

        Set<State> currDepthStates = new HashSet<>();
        Set<State> uniqueStates = new HashSet<>();
        currDepthStates.add(initialState);
        uniqueStates.add(initialState);

        while (!currDepthStates.isEmpty()) {
            Set<State> nextDepthStates = new HashSet<>();

            for (State eachState :
                    currDepthStates) {
                if (eachState.row == map.length - 1 && eachState.col == map[0].length - 1) {
                    return depth;
                }

                for (int[] direction :
                        DIRECTIONS) {
                    State moved = eachState.copyAndMove(direction);
                    if (isValid(map, moved)) {
                        if (uniqueStates.contains(moved)) {
                            continue;
                        }

                        nextDepthStates.add(moved);
                        uniqueStates.add(moved);
                    }
                }
            }

            depth++;
            currDepthStates = nextDepthStates;
        }

        return -1;
    }

    private static boolean isValid(int[][] map, State moved) {
        if (!(0 <= moved.row && moved.row < map.length
            && 0 <= moved.col && moved.col < map[0].length)) {
            return false;
        }

        if (map[moved.row][moved.col] == WALL) {
            if (moved.breakUsed) {
                return false;
            } else {
                moved.breakUsed = true;
                return true;
            }
        } else if (map[moved.row][moved.col] == EMPTY) {
            return true;
        }

        assert(false);
        return false;
    }

    static class State {
        int row;
        int col;
        boolean breakUsed = false;

        public State(int row, int col) {
            this.row = row;
            this.col = col;
        }

        private State(int row, int col, boolean breakUsed) {
            this.row = row;
            this.col = col;
            this.breakUsed = breakUsed;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return row == state.row &&
                    col == state.col &&
                    breakUsed == state.breakUsed;
        }

        @Override
        public int hashCode() {

            return Objects.hash(row, col, breakUsed);
        }

        public State copyAndMove(int[] direction) {
            State copy = copy();
            copy.move(direction);

            return copy;
        }

        private void move(int[] direction) {
            row += direction[ROW];
            col += direction[COL];
        }

        private State copy() {
            return new State(row, col, breakUsed);
        }
    }
}
