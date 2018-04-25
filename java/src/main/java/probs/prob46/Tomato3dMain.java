package probs.prob46;

import java.util.*;

public class Tomato3dMain {
    private static final int RIPEN = 1;
    private static final int RAW = 0;
    private static final int EMPTY = -1;

    private static final int ROW = 0;
    private static final int COL = 1;
    private static final int HEIGHT = 2;

    private static final int[] UP = new int[] { 0, 0, 1 };
    private static final int[] DOWN = new int[] { 0, 0, -1 };
    private static final int[] EAST = new int[] { 0, 1, 0 };
    private static final int[] WEST = new int[] { 0, -1, 0 };
    private static final int[] NORTH = new int[] { -1, 0, 0 };
    private static final int[] SOUTH = new int[] { 1, 0, 0 };

    private static final int[][] DIRECTIONS = new int[][] { UP, DOWN, EAST, WEST, NORTH, SOUTH };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int colCountM = scanner.nextInt();
        int rowCountN = scanner.nextInt();
        int heightCountH = scanner.nextInt();
        scanner.nextLine();

        int[][][] tomatoMap = new int[rowCountN][colCountM][heightCountH];
        for (int heightIdx = 0; heightIdx < heightCountH; heightIdx++) {
            for (int rowIdx = 0; rowIdx < rowCountN; rowIdx++) {
                for (int colIdx = 0; colIdx < colCountM; colIdx++) {
                    tomatoMap[rowIdx][colIdx][heightIdx] = scanner.nextInt();
                }
                scanner.nextLine();
            }
        }

        System.out.println(bfs(tomatoMap));
    }

    private static int bfs(int[][][] tomatoMap) {
        int depth = 0;

        Set<Location> currDepthRipenTomato = findTomatos(tomatoMap, RIPEN);

        while (!currDepthRipenTomato.isEmpty()) {
            Set<Location> nextDepthRipenTomato = new HashSet<>();
            for (Location ripenTomato :
                    currDepthRipenTomato) {
                for (int[] direction :
                        DIRECTIONS) {
                    Location moved = ripenTomato.copyAndMove(direction);
                    if (isRawTomato(tomatoMap, moved)) {
                        nextDepthRipenTomato.add(moved);
                        tomatoMap[moved.row][moved.col][moved.height] = RIPEN;
                    }
                }
            }

            if (nextDepthRipenTomato.isEmpty()) {
                break;
            }

            depth++;
            currDepthRipenTomato = nextDepthRipenTomato;
        }

        if (!findTomatos(tomatoMap, RAW).isEmpty()) {
            return -1;
        }

        return depth;
    }

    private static boolean isRawTomato(int[][][] tomatoMap, Location ripenTomato) {
        int rowCount = tomatoMap.length;
        int colCount = tomatoMap[0].length;
        int heightCount = tomatoMap[0][0].length;

        if (!(0 <= ripenTomato.row && ripenTomato.row < rowCount
            && 0 <= ripenTomato.col && ripenTomato.col < colCount
            && 0 <= ripenTomato.height && ripenTomato.height < heightCount)) {
            return false;
        }

        if (tomatoMap[ripenTomato.row][ripenTomato.col][ripenTomato.height] == RAW) {
            return true;
        }

        return false;
    }

    private static Set<Location> findTomatos(int[][][] tomatoMap, int target) {
        Set<Location> results = new HashSet<>();

        for (int heightIdx = 0; heightIdx < tomatoMap[0][0].length; heightIdx++) {
            for (int rowIdx = 0; rowIdx < tomatoMap.length; rowIdx++) {
                for (int colIdx = 0; colIdx < tomatoMap[0].length; colIdx++) {
                    if (tomatoMap[rowIdx][colIdx][heightIdx] == target) {
                        results.add(new Location(rowIdx, colIdx, heightIdx));
                    }
                }
            }
        }

        return results;
    }

    static class Location {
        int row;
        int col;
        int height;

        public Location(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Location location = (Location) o;
            return row == location.row &&
                    col == location.col &&
                    height == location.height;
        }

        @Override
        public int hashCode() {

            return Objects.hash(row, col, height);
        }

        private void move(int[] direction) {
            row += direction[ROW];
            col += direction[COL];
            height += direction[HEIGHT];
        }

        private Location copy() {
            return new Location(row, col, height);
        }

        public Location copyAndMove(int[] direction) {
            Location copy = copy();
            copy.move(direction);

            return copy;
        }
    }
}
