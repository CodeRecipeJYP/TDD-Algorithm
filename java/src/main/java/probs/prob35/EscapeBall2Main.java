package probs.prob35;


import java.util.*;


public class EscapeBall2Main {
    private static final int MAXIMUM_TRIALS = 10;
    private static final int DIRECTION_COUNT = 4;
    private static final int[][] DIRECTIONS = new int[][] {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    private static final int ROW = 0;
    private static final int COL = 1;
    private static int[][] sMap;

    private static int BLUE = 'B';
    private static int RED = 'R';
    private static int HOLE = 'O';
    private static int WALL = '#';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowCountN = scanner.nextInt();
        int colCountM = scanner.nextInt();
        scanner.nextLine();

        sMap = new int[rowCountN][colCountM];

        for (int rowIdx = 0; rowIdx < rowCountN; rowIdx++) {
            String row = scanner.nextLine();
            for (int colIdx = 0; colIdx < colCountM; colIdx++) {
                sMap[rowIdx][colIdx] = row.charAt(colIdx);
            }
        }

        System.out.println(getMimimumTrials());
    }

    private static int getMimimumTrials() {
        return bfs(MAXIMUM_TRIALS);
    }

    private static int bfs(int maximumTrials) {
        Set<State> uniquePreviousStates = new HashSet();
        List<State> currStates = new ArrayList<>();

        State state = getState(sMap);
        uniquePreviousStates.add(state);
        currStates.add(state);

        for (int trials = 1; trials <= maximumTrials; trials++) {
            List<State> prevStates = currStates;
            currStates = new ArrayList<>();
            for (int prevStateIdx = 0; prevStateIdx < prevStates.size(); prevStateIdx++) {
                State eachPrevState = prevStates.get(prevStateIdx);
                for (int[] direction :
                        DIRECTIONS) {
                    State currEachState = executeTilt(eachPrevState, direction);
                    if (uniquePreviousStates.contains(currEachState)) {
                        continue;
                    }

                    uniquePreviousStates.add(currEachState);
                    if (isGameClear(currEachState)) {
                        return trials;
                    }

                    if (isGameOver(currEachState)) {
                        continue;
                    }

                    currStates.add(currEachState);
                }
            }

        }

        return -1;
    }

    private static State executeTilt(State state, int[] direction) {
        State resultState = state.copy();

        int mainDirection = ROW;
        int subDirection = COL;
        if (direction[ROW] == 0) {
            mainDirection = COL;
            subDirection = ROW;
        }

        int mainDiff = state.red.get(mainDirection) - state.blue.get(mainDirection);
        boolean isRedFirst = (mainDiff * direction[mainDirection]) >= 0;

        Queue<Location> inputBallQueue = new LinkedList<>();
        Queue<Location> outputBallQueue = new LinkedList();

        if (isRedFirst) {
            inputBallQueue.add(state.red);
            inputBallQueue.add(state.blue);
        } else {
            inputBallQueue.add(state.blue);
            inputBallQueue.add(state.red);
        }

        while (!inputBallQueue.isEmpty()) {
            Location ball = inputBallQueue.poll();
            int[] currLocation = new int[2];

            currLocation[subDirection] = ball.get(subDirection);
            currLocation[mainDirection] = ball.get(mainDirection);

            while (true) {
                int nextRow = currLocation[ROW] + direction[ROW];
                int nextCol = currLocation[COL] + direction[COL];

                int nextItem = sMap[nextRow][nextCol];
                if (nextItem == WALL) {
                    break;
                } else if (nextItem == HOLE) {
                    currLocation[ROW] = nextRow;
                    currLocation[COL] = nextCol;
                    break;
                } else if(!outputBallQueue.isEmpty() && outputBallQueue.peek().equals(nextRow, nextCol)) {
                    break;
                }

                currLocation[ROW] = nextRow;
                currLocation[COL] = nextCol;
            }

            outputBallQueue.add(new Location(currLocation));
        }

        if (isRedFirst) {
            resultState.red = outputBallQueue.poll();
            resultState.blue = outputBallQueue.poll();
        } else {
            resultState.blue = outputBallQueue.poll();
            resultState.red = outputBallQueue.poll();
        }

        return resultState;
    }

    private static boolean isGameOver(State state) {
        return sMap[state.blue.row][state.blue.col] == HOLE;
    }

    private static boolean isGameClear(State state) {
        if (isGameOver(state)) {
            return false;
        }

        if (sMap[state.red.row][state.red.col] == HOLE) {
            return true;
        }

        return false;
    }

    private static State getState(int[][] sMap) {
        Location blue = null;
        Location red = null;
        Location hole = null;

        for (int rowIdx = 1; rowIdx < (sMap.length - 1); rowIdx++) {
            for (int colIdx = 1; colIdx < (sMap[0].length - 1); colIdx++) {
                int each = sMap[rowIdx][colIdx];
                if (each == BLUE) {
                    blue = new Location(rowIdx, colIdx);
                } else if (each == RED) {
                    red = new Location(rowIdx, colIdx);
                } else if (each == HOLE) {
                    hole = new Location(rowIdx, colIdx);
                }
            }
        }

        return new State(red, blue, hole);
    }

    static class State {
        Location red;
        Location blue;
        Location hole;

        public State(Location red, Location blue, Location hole) {
            this.red = red;
            this.blue = blue;
            this.hole = hole;
        }

        State copy() {
            return new State(red, blue, hole);
        }

        State deepCopy() {
            return new State(red.copy(), blue.copy(), hole);
        }

        @Override
        public String toString() {
            return "State{" +
                    "red=" + red +
                    ", blue=" + blue +
                    ", hole=" + hole +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return Objects.equals(red, state.red) &&
                    Objects.equals(blue, state.blue);
        }

        @Override
        public int hashCode() {

            return Objects.hash(red, blue);
        }
    }

    static class Location {
        int row;
        int col;

        Location(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public Location(int[] rowNcol) {
            this.row = rowNcol[ROW];
            this.col = rowNcol[COL];
        }

        int get(int direction) {
            if (direction == ROW) {
                return row;
            }

            return col;
        }

        public boolean equals(int row, int col) {
            if (this.row != row) {
                return false;
            }

            if (this.col != col) {
                return false;
            }

            return true;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Location location = (Location) o;
            return row == location.row &&
                    col == location.col;
        }

        @Override
        public int hashCode() {

            return Objects.hash(row, col);
        }

        @Override
        public String toString() {
            return "Location{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }

        public Location copy() {
            return new Location(row, col);
        }
    }
}
