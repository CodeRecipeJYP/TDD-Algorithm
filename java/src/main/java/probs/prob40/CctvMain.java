package probs.prob40;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CctvMain {
    private static int[][] sMap;
    private static int sMin = Integer.MAX_VALUE;
    private static final int BLANK = 0;
    private static final int WALL = 6;
    private static final int ROW = 0;
    private static final int COL = 1;
    private static final int VISIBLE = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowCount = scanner.nextInt();
        int colCount = scanner.nextInt();
        scanner.nextLine();

        sMap = new int[rowCount][colCount];
        List<Cctv> cctvList = new ArrayList<>();
        for (int rowIdx = 0; rowIdx < rowCount; rowIdx++) {
            for (int colIdx = 0; colIdx < colCount; colIdx++) {
                int eachItem = scanner.nextInt();
                sMap[rowIdx][colIdx] = eachItem;
                if (0 < eachItem && eachItem < WALL) {
                    cctvList.add(new Cctv(eachItem, rowIdx, colIdx));
                }
            }
        }

        backTrack(new ArrayList<>(), cctvList, 0, cctvList.size());
        System.out.println(sMin);
    }

    private static void backTrack(List<Integer> directionList, List<Cctv> cctvList, int depth, int length) {
        if (depth == length) {
            sMin = Math.min(sMin, getUnvisibleSize(directionList, cctvList));

            return;
        }

        Cctv currCctv = cctvList.get(depth);
        for (int directionIdx = 0; directionIdx < currCctv.directionSize(); directionIdx++) {
            directionList.add(directionIdx);
            backTrack(directionList, cctvList, depth + 1, length);
            directionList.remove(directionList.size() - 1);
        }
    }

    private static int getUnvisibleSize(List<Integer> directionList, List<Cctv> cctvList) {
        int[][] copy = deepCopy2dArr(sMap);
        for (int idx = 0; idx < directionList.size(); idx++) {
            Cctv currCctv = cctvList.get(idx);
            int[][] directions = currCctv.getDirections(directionList.get(idx));

            fillVisible(copy, currCctv.row, currCctv.col, directions);
        }

        int count = 0;
        for (int rowIdx = 0; rowIdx < copy.length; rowIdx++) {
            for (int colIdx = 0; colIdx < copy[0].length; colIdx++) {
                if (copy[rowIdx][colIdx] == BLANK) {
                    count++;
                }
            }
        }

        return count;
    }

    private static void fillVisible(int[][] map, int row, int col, int[][] directions) {
        for (int[] direction :
                directions) {
            int currRow = row;
            int currCol = col;
            while (true) {
                currRow += direction[ROW];
                currCol += direction[COL];

                if (!(0 <= currRow && currRow < map.length
                        && 0 <= currCol && currCol < map[0].length)) {
                    break;
                }

                if (map[currRow][currCol] == WALL) {
                    break;
                }
                if (map[currRow][currCol] == BLANK) {
                    map[currRow][currCol] = VISIBLE;
                }
            }
        }
    }

    private static int[][] deepCopy2dArr(int[][] arr) {
        int[][] copy = new int[arr.length][arr[0].length];
        for (int rowIdx = 0; rowIdx < arr.length; rowIdx++) {
            for (int colIdx = 0; colIdx < arr[0].length; colIdx++) {
                copy[rowIdx][colIdx] = arr[rowIdx][colIdx];
            }
        }

        return copy;
    }

    static class Cctv {
        static final int[][] DIRECTIONS = new int[][] {
                {-1, 0},
                {0, 1},
                {1, 0},
                {0, -1},
        };

        static final int[] UP = DIRECTIONS[0];
        static final int[] RIGHT = DIRECTIONS[1];
        static final int[] DOWN = DIRECTIONS[2];
        static final int[] LEFT = DIRECTIONS[3];

        static final int[][][][] DIRECTIONS_BY_TYPE = new int[][][][] {
                {{UP}, {RIGHT}, {DOWN}, {LEFT}},
                {{UP, DOWN}, {LEFT, RIGHT}},
                {{UP, RIGHT}, {RIGHT, DOWN}, {DOWN, LEFT}, {LEFT, UP}},
                {{UP, RIGHT, DOWN}, {RIGHT, DOWN, LEFT}, {DOWN, LEFT, UP}, {LEFT, UP, RIGHT}},
                {{UP, RIGHT, DOWN, LEFT}},
        };

        int type;
        int row;
        int col;

        public Cctv(int type, int row, int col) {
            this.type = type;
            this.row = row;
            this.col = col;
        }

        public int directionSize() {
            return DIRECTIONS_BY_TYPE[type - 1].length;
        }

        public int[][] getDirections(int idx) {
            return DIRECTIONS_BY_TYPE[type - 1][idx];
        }
    }
}
