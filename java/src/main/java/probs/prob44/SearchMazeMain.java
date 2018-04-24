package probs.prob44;

import java.util.*;

public class SearchMazeMain {
    private static final int[][] DIRECTIONS = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };
    private static final int ROW = 0;
    private static final int COL = 1;

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
        Location initialPosition = new Location(0, 0);
        if (map.length == 1 && map[0].length == 1) {
            return 1;
        }

        Set<Location> uniqueSet = new HashSet<>();
        List<Location> currDepthArr = new ArrayList<>();
        uniqueSet.add(initialPosition);
        currDepthArr.add(initialPosition);

        int depth = 1;

        while (true) {
            if (currDepthArr.isEmpty()) {
                break;
            }

            List<Location> nextDepthArr = new ArrayList<>();
            for (Location location :
                    currDepthArr) {
                for (int directionIdx = 0; directionIdx < DIRECTIONS.length; directionIdx++) {
                    Location nextLocation = new Location(location.row + DIRECTIONS[directionIdx][ROW],
                            location.col + DIRECTIONS[directionIdx][COL]);

                    if (!(0 <= nextLocation.row && nextLocation.row < map.length
                        && 0 <= nextLocation.col && nextLocation.col < map[0].length)) {
                        continue;
                    }

                    if (map[nextLocation.row][nextLocation.col] == 0) {
                        continue;
                    }

                    if (nextLocation.row == map.length - 1
                            && nextLocation.col == map[0].length - 1) {
                        return depth + 1;
                    }

                    if (uniqueSet.contains(nextLocation)) {
                        continue;
                    }

                    uniqueSet.add(nextLocation);
                    nextDepthArr.add(nextLocation);
                }
            }

            currDepthArr = nextDepthArr;
            depth++;
        }

        return -1;
    }

    static class Location {
        int row;
        int col;

        public Location(int row, int col) {
            this.row = row;
            this.col = col;
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
    }
}
