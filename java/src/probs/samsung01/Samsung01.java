package probs.samsung01;

import java.util.*;

public class Samsung01 {
    public static final int X = 1;
    public static final int Y = 0;
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowCount = scanner.nextInt();
        int colCount = scanner.nextInt();
        scanner.nextLine();
        char[][] map = new char[rowCount][colCount];
        for (int rowIdx = 0; rowIdx < rowCount; rowIdx++) {
            String line = scanner.nextLine();
            line.getChars(0, line.length(), map[rowIdx], 0);
        }

        System.out.println(getMinimumNumOfTrials(map));
//        printMap(map);
    }

    public static int getMinimumNumOfTrials(char[][] map) {
        // 현상태 구하기 + 기록(횟수0)
        // {현상태 + 상} @+하, @+좌, @+우 큐에 넣음
        // 상 빼낸후 시행후
        // 현상태 구하기
        // 중복아니면 {현상태 + 상하좌우} 큐에넣음.
        // 현상태 solved면 수행횟수 리턴
        TwoValue<State, char[][]> initialStateAndCleanMap = getInitialStateAndCleanMap(map);
        State initialState = initialStateAndCleanMap.val1;
        char[][] cleanMap = initialStateAndCleanMap.val2;

        Map<State, State> stateList = new HashMap<State, State>();
        stateList.put(initialState, initialState);

        Queue<TwoValue<State, Integer>> queue
                = new LinkedList<TwoValue<State, Integer>>();

        queue.add(new TwoValue<>(initialState, 0));

        while(!queue.isEmpty()) {
            TwoValue<State, Integer> stateAndTrials = queue.poll();
            State currState = stateAndTrials.val1;
            int currTrials = stateAndTrials.val2;

            if (currTrials >= 10) {
                break;
            }

            for (int[] direction :
                    DIRECTIONS) {
                State resultState = executeTilt(cleanMap, currState, direction);

                if (resultState.isGameClear()) {
                    return currTrials + 1;
                }

                if (resultState.isGameOver()) {
                    continue;
                }

                if (!stateList.containsKey(resultState)) {
                    stateList.put(resultState, resultState);
                    queue.add(new TwoValue(resultState, currTrials + 1));
                }
            }
        }

        return -1;
    }

    public static State executeTilt(char[][] cleanMap, State state, int[] direction) {
        int dirX = direction[0];
        int dirY = direction[1];
        int redWeight = state.redY * dirY + state.redX * dirX;
        int blueWeight = state.blueY * dirY + state.blueX * dirX;

        TwoValue redBall = new TwoValue<>(state.redX, state.redY);
        TwoValue blueBall = new TwoValue<>(state.blueX, state.blueY);

        TwoValue<Integer, Integer> redTilted, blueTilted;

        State result = new State();

        if (redWeight > blueWeight) {
            redTilted = executeTilt(cleanMap, redBall, blueBall, direction);
            blueTilted = executeTilt(cleanMap, blueBall, redTilted, direction);
        } else {
            blueTilted = executeTilt(cleanMap, blueBall, redBall, direction);
            redTilted = executeTilt(cleanMap, redBall, blueTilted, direction);
        }

        result.redX = redTilted.val1;
        result.redY = redTilted.val2;
        result.blueX = blueTilted.val1;
        result.blueY = blueTilted.val2;

        return result;
    }

    public static TwoValue<Integer, Integer> executeTilt(char[][] cleanMap,
                                                          TwoValue<Integer, Integer> ballLocation,
                                                          TwoValue<Integer, Integer> anotherBallLocation,
                                                          int[] direction) {
        int currY = ballLocation.val1;
        int currX = ballLocation.val2;

        int anotherY = anotherBallLocation.val1;
        int anotherX = anotherBallLocation.val2;

        while (true) {
            int nextX = currX + direction[X];
            int nextY = currY + direction[Y];

            if (nextX == anotherX && nextY == anotherY) {
                break;
            }
            else if (cleanMap[nextY][nextX] == '#') {
                break;
            }
            else if (cleanMap[nextY][nextX] == 'O') {
                currX = nextX;
                currY = nextY;
                break;
            }

            currX = nextX;
            currY = nextY;
        }

        return new TwoValue(currX, currY);
    }

    public static TwoValue<State, char[][]> getInitialStateAndCleanMap(char[][] map) {
        State state = getState(map);
        map[state.redY][state.redX] = '.';
        map[state.blueY][state.blueX] = '.';

        return new TwoValue(state, map);
    }

    public static State getState(char[][] map) {
        State result = new State();

        for (int rowIdx = 1; rowIdx < map.length - 1; rowIdx++) {
            for (int colIdx = 1; colIdx < map[0].length - 1; colIdx++) {
                if (map[rowIdx][colIdx] == 'R') {
                    result.redY = rowIdx;
                    result.redX = colIdx;

                    if (result.isEnough()) {
                        return result;
                    }
                } else if (map[rowIdx][colIdx] == 'B') {
                    result.blueY = rowIdx;
                    result.blueX = colIdx;

                    if (result.isEnough()) {
                        return result;
                    }
                }
            }
        }

        return result;
    }

    private static void printMap(char[][] map) {
        Arrays.stream(map).forEach(System.out::println);
    }

    static class State {
        public int redX = -1;
        public int redY = -1;
        public int blueX = -1;
        public int blueY = -1;

        public boolean isEnough() {
            return redX != -1 && redY != -1
                    && blueX != -1 && blueY != -1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof State)) return false;
            State state = (State) o;
            return redX == state.redX &&
                    redY == state.redY &&
                    blueX == state.blueX &&
                    blueY == state.blueY;
        }

        @Override
        public int hashCode() {
            return Objects.hash(redX, redY, blueX, blueY);
        }

        public boolean isGameClear() {
            return false;
        }

        public boolean isGameOver() {
            return false;
        }
    }

    static class TwoValue<T, U> {
        public T val1;
        public U val2;

        public TwoValue(T val1, U val2) {
            this.val1 = val1;
            this.val2 = val2;
        }
    }
}
