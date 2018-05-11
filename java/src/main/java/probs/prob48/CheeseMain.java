package probs.prob48;

import java.util.*;

public class CheeseMain {
    private static final int[][] DIRECTIONS = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    private static final int ROW = 0;
    private static final int COL = 1;

    private static final int INVALID = -1;
    private static final int EMPTY = 0;
    private static final int CHEESE = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowCount = scanner.nextInt();
        int colCount = scanner.nextInt();
        scanner.nextLine();

        int[][] map = new int[rowCount][colCount];
        for (int rowIdx = 0; rowIdx < rowCount; rowIdx++) {
            for (int colIdx = 0; colIdx < colCount; colIdx++) {
                map[rowIdx][colIdx] = scanner.nextInt();
            }
            scanner.nextLine();
        }

        executeMelt(map);
    }

    private static void executeMelt(int[][] map) {
        int passedHours = 0;
        int size = 0;

        while (true) {
//            probs.utils.PrintUtils.printMap(map, "passedHours=" + passedHours);

            Set<Location> exposedCheeses = getExposedCheeses(map);
            if (exposedCheeses.isEmpty()) {
                break;
            }

            size = exposedCheeses.size();

            for (Location each :
                    exposedCheeses) {
                map[each.row][each.col] = EMPTY;
            }

            passedHours++;
        }

        System.out.println(passedHours);
        System.out.println(size);
    }

    private static Set<Location> getExposedCheeses(int[][] map) {
        Location initialLocation = new Location(0, 0);
        Set<Location> exposedCheeses = new HashSet<>();

        Set<Location> currDepthLocation = new HashSet<>();
        Set<Location> uniqueLocations = new HashSet<>();
        currDepthLocation.add(initialLocation);
        uniqueLocations.add(initialLocation);

        while (!currDepthLocation.isEmpty()) {
            Set<Location> nextDepthLocation = new HashSet<>();
            for (Location eachLocation:
            currDepthLocation) {
                for (int[] direction :
                        DIRECTIONS) {
                    Location moved = eachLocation.copyAndMove(direction);
                    switch (safeGet(map, moved)) {
                        case INVALID:
                            continue;
                        case EMPTY:
                            if (uniqueLocations.contains(moved)) {
                                continue;
                            }
                            nextDepthLocation.add(moved);
                            uniqueLocations.add(moved);
                            break;
                        case CHEESE:
                            exposedCheeses.add(moved);
                            break;
                    }
                }
            }

            currDepthLocation = nextDepthLocation;
        }

        return exposedCheeses;
    }

    private static int safeGet(int[][] map, Location moved) {
        if (!(0 <= moved.row && moved.row < map.length
                && 0 <= moved.col && moved.col < map[0].length)) {
            return INVALID;
        }

        return map[moved.row][moved.col];
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

        public Location copyAndMove(int[] direction) {
            Location copy = copy();
            copy.move(direction);

            return copy;
        }

        private void move(int[] direction) {
            row += direction[ROW];
            col += direction[COL];
        }

        private Location copy() {
            return new Location(row, col);
        }
    }
}
