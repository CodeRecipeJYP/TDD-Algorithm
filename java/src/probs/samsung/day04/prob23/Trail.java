package probs.samsung.day04.prob23;

import java.util.*;

public class Trail {
    static final int[][] DIRECTIONS = new int[][] {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    static final int UP = 0;
    static final int DOWN = 1;
    static final int LEFT = 2;
    static final int RIGHT = 3;

    static final int ROW = 0;
    static final int COL = 1;

    public static void main(String[] args) {
        List<Input> inputs = getInputs(new Scanner(System.in));

        for (int caseIdx = 0; caseIdx < inputs.size(); caseIdx++) {
            Input input = inputs.get(caseIdx);

            System.out.print(String.format("#%d ", caseIdx + 1));
            System.out.println(getLongestTrail(input.map, input.kSize));
        }
    }

    public static int getLongestTrail(int[][] map, int kSize) {
        Stack<Node> stack = new Stack<>();
        int max = 0;
        int mapSize = map.length;

        List<Location> heighestLocations = findHeighestLocations(map);

        for (Location heightest :
                heighestLocations) {

            stack.push(new Node(
                    new Location(heightest.row, heightest.col),
                    UP));
        }

        while (!stack.isEmpty()) {
            Node currNode = stack.pop();
            boolean hasPushed = false;

            if (currNode.nextDirection != RIGHT) {
                stack.push(currNode.copyNextDirection());

                hasPushed = true;
            }

            int[] direction = DIRECTIONS[currNode.nextDirection];
            int nextRow = currNode.currLocation.row + direction[ROW];
            int nextCol = currNode.currLocation.col + direction[COL];
            Location nextLocation = new Location(nextRow, nextCol);
            if (nextLocation.isValidLocation(mapSize)) {
                int currHeight = map[currNode.currLocation.row][currNode.currLocation.col];
                if (currNode.hasClippedJustNow) {
                    currHeight -= kSize;
                    currNode.hasClippedJustNow = false;
                }
                int nextHeight = map[nextRow][nextCol];

                if (!currNode.hasVisited(nextLocation)) {
                    if (currHeight > nextHeight) {
                        currNode.move(nextLocation);
                        stack.push(currNode);

                        hasPushed = true;
                    } else if (!currNode.hasClipped && currHeight > nextHeight - kSize) {
                        currNode.hasClipped = true;
                        currNode.hasClippedJustNow = true;
                        currNode.move(nextLocation);
                        stack.push(currNode);

                        hasPushed = true;
                    }
                }
            }

            if (!hasPushed) {
                int length = currNode.length();
                if (length > max) {
                    max = length;
                }
            }
        }

        return max;
    }

    public static List<Location> findHeighestLocations(int[][] map) {
        List<Location> results = new ArrayList<>();

        int max = 0;

        for (int rowIdx = 0; rowIdx < map.length; rowIdx++) {
            for (int colIdx = 0; colIdx < map[0].length; colIdx++) {
                int currHeight = map[rowIdx][colIdx];
                if (max < currHeight) {
                    max = currHeight;
                    results.clear();
                    results.add(new Location(rowIdx, colIdx));
                } else if (max == currHeight) {
                    results.add(new Location(rowIdx, colIdx));
                }
            }
        }

        return results;
    }

    static class Node {
        public Location currLocation;
        public int nextDirection;
        public boolean hasClippedJustNow;
        public boolean hasClipped;
        public List<Location> prevLocations = new ArrayList<>();

        public Node(Location currLocation, int nextDirection) {
            this.currLocation = currLocation;
            this.nextDirection = nextDirection;
        }

        public void move(int nextRow, int nextCol) {
            move(new Location(nextRow, nextCol));
        }

        public boolean hasVisited(Location nextLocation) {
            for (Location visited :
                    prevLocations) {
                if (visited.equals(nextLocation)) {
                    return true;
                }
            }

            return false;
        }

        public void move(Location nextLocation) {
            prevLocations.add(currLocation);
            currLocation = nextLocation;
            nextDirection = UP;
        }

        public int length() {
            return prevLocations.size() + 1;
        }

        public Node copyNextDirection() {
            Node node = new Node(currLocation.copy(),
                    nextDirection + 1);

            node.hasClipped = hasClipped;
            node.hasClippedJustNow = hasClippedJustNow;
            node.prevLocations = new ArrayList<>(prevLocations);
            return node;
        }
    }

    static class Location {
        public int row;
        public int col;

        public Location(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Location)) return false;
            Location location = (Location) o;
            return row == location.row &&
                    col == location.col;
        }

        @Override
        public int hashCode() {

            return Objects.hash(row, col);
        }

        public Location copy() {
            return new Location(row, col);
        }

        public boolean isValidLocation(int mapSize) {
            return 0 <= row && row < mapSize &&
                    0 <= col && col < mapSize;
        }
    }

    static List<Input> getInputs(Scanner sc) {
        int caseCount = sc.nextInt();
        sc.nextLine();

        List<Input> inputs = new ArrayList<>();

        for (int caseIdx = 0; caseIdx < caseCount; caseIdx++) {
            inputs.add(getInput(sc));
        }

        return inputs;
    }

    static Input getInput(Scanner sc) {
        int mapSize = sc.nextInt();
        int kSize = sc.nextInt();
        sc.nextLine();

        int[][] map = new int[mapSize][mapSize];

        for (int rowIdx = 0; rowIdx < mapSize; rowIdx++) {
            for (int colIdx = 0; colIdx < mapSize; colIdx++) {
                map[rowIdx][colIdx] = sc.nextInt();
            }
            sc.nextLine();
        }

        return new Input(map, mapSize, kSize);
    }

    static class Input {
        public int map[][];
        public int mapSize;
        public int kSize;

        public Input(int[][] map, int mapSize, int kSize) {
            this.map = map;
            this.mapSize = mapSize;
            this.kSize = kSize;
        }
    }
}
