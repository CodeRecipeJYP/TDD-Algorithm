package probs.prob52;

import java.util.*;

public class CrushFeverMain {
    private static final int[] DR = new int[] { 1, -1, 0, 0 };
    private static final int[] DC = new int[] { 0, 0, 1, -1 };
    private static final int WALL = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int colCountM = scanner.nextInt();
        int rowCountN = scanner.nextInt();
        scanner.nextLine();

        int[][] map = new int[rowCountN + 2][colCountM + 2];

        for (int rowIdx = 0; rowIdx < map.length; rowIdx++) {
            map[rowIdx][0] = WALL;
            map[rowIdx][map[0].length - 1] = WALL;
        }

        for (int colIdx = 0; colIdx < map[0].length; colIdx++) {
            map[0][colIdx] = WALL;
            map[map.length - 1][colIdx] = WALL;
        }

        for (int rowIdx = 1; rowIdx <= rowCountN; rowIdx++) {
            for (int colIdx = 1; colIdx <= colCountM; colIdx++) {
                map[rowIdx][colIdx] = scanner.nextInt();
            }
            scanner.nextLine();
        }

        System.out.println(getHighestScore(map));
    }

    private static int getHighestScore(int[][] map) {
        int rowCount = map.length;
        int colCount = map[0].length;

        int maxScore = 0;

        Queue<State> queue = new LinkedList();
        queue.add(new State(0, 0, map));

        while (!queue.isEmpty()) {
            State currState = queue.poll();
            if (currState.depth == 3) {
                maxScore = Math.max(maxScore, currState.score);
                continue;
            }

            boolean[][] currStateChecked = new boolean[rowCount][colCount];
            for (int rowIdx = 1; rowIdx < rowCount - 1; rowIdx++) {
                for (int colIdx = 1; colIdx < colCount - 1; colIdx++) {
                    if (currStateChecked[rowIdx][colIdx]) {
                        continue;
                    }

                    List<Location> arr = findConnectedBlocks(currState.map, rowIdx, colIdx);
                    int connectedCount = arr.size();

                    int[][] nextMap = getNextMap(currState.map, arr);

                    checkCurrVisited(currStateChecked, arr);
                    int nextScore = currState.score + connectedCount * connectedCount;
                    if (currState.map[rowIdx][colIdx] == WALL) {
                        nextScore = currState.score;
                    }

                    queue.add(new State(nextScore, currState.depth + 1, nextMap));
                }
            }
        }

        return maxScore;
    }

    private static void checkCurrVisited(boolean[][] currStateChecked, List<Location> arr) {
        for (Location each :
                arr) {
            currStateChecked[each.row][each.col] = true;
        }
    }

    private static int[][] getNextMap(int[][] map, List<Location> arr) {
        int[][] copy = copy2darr(map);

        for (Location each :
                arr) {
            for (int rowIdx = each.row; rowIdx >= 0; rowIdx--) {
                if (copy[rowIdx][each.col] == WALL) {
                    break;
                }

                copy[rowIdx][each.col] = copy[rowIdx - 1][each.col];
            }
        }

        return copy;
    }

    private static List<Location> findConnectedBlocks(int[][] map, int rowIdx, int colIdx) {
        Queue<Location> queue = new LinkedList();
        queue.add(new Location(rowIdx, colIdx));
        List<Location> result = new ArrayList<>();

        boolean[][] visited = new boolean[map.length][map[0].length];
        int initialValue = map[rowIdx][colIdx];
        visited[rowIdx][colIdx] = true;
        while (!queue.isEmpty()) {
            Location curr = queue.poll();
            result.add(curr);
            for (int directionIdx = 0; directionIdx < DR.length; directionIdx++) {
                int nextRow = curr.row + DR[directionIdx];
                int nextCol = curr.col + DC[directionIdx];
                if (map[nextRow][nextCol] == WALL) {
                    continue;
                }

                if (visited[nextRow][nextCol]) {
                    continue;
                }

                visited[nextRow][nextCol] = true;
                if (map[nextRow][nextCol] == initialValue) {
                    queue.add(new Location(nextRow, nextCol));
                }
            }
        }

        return result;
    }

    private static int[][] copy2darr(int[][] map) {
        int[][] copy = new int[map.length][map[0].length];
        for (int rowIdx = 0; rowIdx < map.length; rowIdx++) {
            for (int colIdx = 0; colIdx < map[0].length; colIdx++) {
                copy[rowIdx][colIdx] = map[rowIdx][colIdx];
            }
        }

        return copy;
    }

    static class State {
        int score;
        int depth;
        int[][] map;

        public State(int score, int depth, int[][] map) {
            this.score = score;
            this.depth = depth;
            this.map = copy2darr(map);
        }

        public State nextState(int rowIdx, int colIdx) {
            return null;
        }
    }

    static class Location {
        int row;
        int col;

        public Location(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
