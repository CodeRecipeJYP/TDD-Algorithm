package probs.prob49;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class RobotMain {
    private static final int ROAD = 0;

    private enum Statement {
        GO_1, GO_2, GO_3, TURNLEFT, TURNRIGHT
    }

    private static final int[] UP = new int[] { -1, 0 };
    private static final int[] LEFT = new int[] { 0, 1 };
    private static final int[] DOWN = new int[] { 1, 0 };
    private static final int[] RIGHT = new int[] { 0, -1 };

    private static final int[][] DIRECTIONS = new int[][] {
            UP, LEFT, DOWN, RIGHT
    };


    private static final int EAST = 1;
    private static final int WEST = 2;
    private static final int SOUTH = 3;
    private static final int NORTH = 4;

    private static final int ROW = 0;
    private static final int COL = 1;

    private static final int IMPOSSIBLE = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowCountM = scanner.nextInt();
        int colCountN = scanner.nextInt();
        scanner.nextLine();

        int[][] map = new int[rowCountM][colCountN];
        for (int rowIdx = 0; rowIdx < rowCountM; rowIdx++) {
            for (int colIdx = 0; colIdx < colCountN; colIdx++) {
                map[rowIdx][colIdx] = scanner.nextInt();
            }
            scanner.nextLine();
        }

        int rowStartIdx = scanner.nextInt() - 1;
        int colStartIdx = scanner.nextInt() - 1;
        int directionStartIdx = adaptDirection(scanner.nextInt());
        State startState = new State(rowStartIdx, colStartIdx, directionStartIdx);
        scanner.nextLine();

        int rowEndIdx = scanner.nextInt() - 1;
        int colEndIdx = scanner.nextInt() - 1;
        int directionEndIdx = adaptDirection(scanner.nextInt());
        State endState = new State(rowEndIdx, colEndIdx, directionEndIdx);
        scanner.nextLine();

        System.out.println(getShortestPath(map, startState, endState));
    }

    private static int adaptDirection(int inputDirection) {
        switch (inputDirection) {
            case EAST:
                return 1;
            case WEST:
                return 3;
            case SOUTH:
                return 2;
            case NORTH:
                return 0;
        }

        assert(false);
        return -1;
    }

    private static int getShortestPath(int[][] map, State startState, State endState) {
        Set<State> currentDepthStates = new HashSet<>();
        Set<State> uniqueStates = new HashSet<>();

        uniqueStates.add(startState);
        currentDepthStates.add(startState);

        int depth = 0;

        while (!currentDepthStates.isEmpty()) {
            Set<State> nextDepthStates = new HashSet<>();

            for (State eachState :
                    currentDepthStates) {
                if (eachState.equals(endState)) {
                    return depth;
                }

                for (Statement statement:
                        Statement.values()) {
                    State copy = eachState.copy();
                    switch (statement) {
                        case GO_1:
                            copy = copy.goWithValidCheck(1, map);
                            break;
                        case GO_2:
                            copy = copy.goWithValidCheck(2, map);
                            break;
                        case GO_3:
                            copy = copy.goWithValidCheck(3, map);
                            break;
                        case TURNLEFT:
                            copy.turnLeft();
                            break;
                        case TURNRIGHT:
                            copy.turnRight();
                            break;
                    }

                    if (copy == null) {
                        continue;
                    }

                    if (uniqueStates.contains(copy)) {
                        continue;
                    }
                    nextDepthStates.add(copy);
                    uniqueStates.add(copy);
                }
            }

            depth++;
            currentDepthStates = nextDepthStates;
        }

        return IMPOSSIBLE;
    }

    private static boolean isValid(int[][] map, State state) {
        if (!(0 <= state.row && state.row < map.length
                && 0 <= state.col && state.col < map[0].length)) {
            return false;
        }

        if (map[state.row][state.col] == ROAD) {
            return true;
        }

        return false;
    }

    static class State {
        int row;
        int col;
        int directionIdx;

        public State(int row, int col, int directionIdx) {
            this.row = row;
            this.col = col;
            this.directionIdx = directionIdx;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return row == state.row &&
                    col == state.col &&
                    directionIdx == state.directionIdx;
        }

        @Override
        public int hashCode() {

            return Objects.hash(row, col, directionIdx);
        }

        public State copy() {
            return new State(row, col, directionIdx);
        }

        public void turnLeft() {
            directionIdx = (directionIdx + 3) % DIRECTIONS.length;
        }

        public void turnRight() {
            directionIdx = (directionIdx + 1) % DIRECTIONS.length;
        }

        public State goWithValidCheck(int distance, int[][] map) {
            for (int step = 0; step < distance; step++) {
                row += DIRECTIONS[directionIdx][ROW];
                col += DIRECTIONS[directionIdx][COL];

                if (!isValid(map, this)) {
                    return null;
                }
            }

            return this;
        }
    }
}
