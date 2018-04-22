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

        getMimimumTrials();
        System.out.println(-1);
    }

    private static void getMimimumTrials() {
        for (int trialIdx = 1; trialIdx <= MAXIMUM_TRIALS; trialIdx++) {
            backTrack(new ArrayList<>(), 0, trialIdx);
        }
    }

    private static void backTrack(List<Integer> directionArr, int depth, int length) {
        if (depth == length) {
            executeTrials(directionArr);

            return;
        }

        for (int directionIdx = 0; directionIdx < DIRECTION_COUNT; directionIdx++) {
            int prevIdx = directionArr.size() - 1;
            if (prevIdx >= 0 && directionArr.get(prevIdx) == directionIdx) {
                continue;
            }

            int twostepPrevIdx = directionArr.size() - 2;
            if (twostepPrevIdx >= 0 && directionArr.get(twostepPrevIdx) == directionIdx
                    && directionArr.get(prevIdx) == rotate180(directionIdx)) {
                continue;
            }


            directionArr.add(directionIdx);
            backTrack(directionArr, depth + 1, length);
            directionArr.remove(directionArr.size() - 1);
        }
    }

    private static int rotate180(int directionIdx) {
        return (directionIdx + 2) % DIRECTION_COUNT;
    }

    private static void executeTrials(List<Integer> directionArr) {
//        System.out.println(directionArr.toString());

        State state = getState(sMap);

        for (int directionIdx = 0; directionIdx < directionArr.size(); directionIdx++) {
            int[] direction = DIRECTIONS[directionArr.get(directionIdx)];

            executeTilt(state, direction);
            if (isGameOver(state)) {
                return;
            }
        }

//        System.out.println(state);

        if (isGameClear(state)) {
            System.out.println(directionArr.size());
            System.exit(0);
        }
    }

    private static boolean isGameOver(State state) {
        return sMap[state.blue.row][state.blue.col] == HOLE;
    }

    private static void executeTilt(State state, int[] direction) {
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
            state.red = outputBallQueue.poll();
            state.blue = outputBallQueue.poll();
        } else {
            state.blue = outputBallQueue.poll();
            state.red = outputBallQueue.poll();
        }
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

        @Override
        public String toString() {
            return "State{" +
                    "red=" + red +
                    ", blue=" + blue +
                    ", hole=" + hole +
                    '}';
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
        public String toString() {
            return "Location{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }
}
