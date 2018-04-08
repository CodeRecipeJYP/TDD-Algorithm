package probs.samsung.day05.prob24;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HomeSecurity {
    static final int[][] DIRECTIONS = new int[][] {
            {1, -1},
            {1, 1},
            {-1, 1},
            {-1, -1}
    };

    static final int ROW = 0; 
    static final int COL = 1; 

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        String filepath = "test/probs/samsung/day05/prob24/case01.in";
        Scanner sc = new Scanner(new File(filepath));
        List<Input> inputs = getInputs(sc);

        for (int caseIdx = 0; caseIdx < inputs.size(); caseIdx++) {
            Input eachInput = inputs.get(caseIdx);
            int result = getMaximumHousesInServiceArea(eachInput.map, eachInput.cost);
            System.out.println(String.format("#%d %d", caseIdx + 1, result));
        }
    }

    static int getMaximumHousesInServiceArea(boolean[][] map, int cost) {
        int rowCount = map.length;
        int colCount = map.length;

        int max = 0;

        int maximumCost = getHouseCount(map) * cost;
        int maximumSolutionSize = 1;
        while (true) {
            int maintenanceCost = getMaintenanceCost(maximumSolutionSize);
            if (maximumCost < maintenanceCost) {
                break;
            }

            maximumSolutionSize += 1;
        }

        maximumSolutionSize -= 1;

        for (int rowIdx = 0; rowIdx < rowCount; rowIdx++) {
            for (int colIdx = 0; colIdx < colCount; colIdx++) {
                int result = getMaximumHousesFromCertainPoint(map,
                        cost, maximumSolutionSize,
                        rowIdx, colIdx);
                if (result > max) {
                    max = result;
                }
            }
        }

        return max;
    }

    private static int getMaintenanceCost(int solutionSize) {
        return (int) (Math.pow(solutionSize, 2) + Math.pow(solutionSize - 1, 2));
    }

    static int getHouseCount(boolean[][] map) {
        int count = 0;
        int rowCount = map.length;
        int colCount = map.length;

        for (int rowIdx = 0; rowIdx < rowCount; rowIdx++) {
            for (int colIdx = 0; colIdx < colCount; colIdx++) {
                if (map[rowIdx][colIdx]) {
                    count++;
                }
            }
        }

        return count;
    }

    static int getMaximumHousesFromCertainPoint(boolean[][] map, int cost, int maximumSolutionSize, int centerRowIdx, int centerColIdx) {
        int houseCount = 0;
        for (int solutionSize = 1; solutionSize <= maximumSolutionSize; solutionSize++) {
            int rowIdxMin = centerRowIdx - (solutionSize - 1);
            int rowIdxMax = centerRowIdx + (solutionSize - 1);
            int colIdxMin = centerColIdx - (solutionSize - 1);
            int colIdxMax = centerColIdx + (solutionSize - 1);
            
            int rowIdx = rowIdxMin;
            int colIdx = centerColIdx;

            for (int directionIdx = 0; directionIdx < DIRECTIONS.length; directionIdx++) {
                int[] direction = DIRECTIONS[directionIdx];
                while (true) {
                    int nextRowIdx = rowIdx + direction[ROW];
                    int nextColIdx = colIdx + direction[COL];

                    if (!(rowIdxMin <= nextRowIdx && nextRowIdx <= rowIdxMax
                            && colIdxMin <= nextColIdx && nextColIdx <= colIdxMax)) {
                        break;
                    }

                    rowIdx = nextRowIdx;
                    colIdx = nextColIdx;

                    if (safeGet(map, rowIdx, colIdx)) {
                        houseCount++;
                    }
                }
            }
        }

        return houseCount;
    }

    private static boolean safeGet(boolean[][] map, int rowIdx, int colIdx) {
        if (!(0 <= rowIdx && rowIdx < map.length &&
                0 <= colIdx && colIdx < map[0].length)) {
            return false;
        }
        return map[rowIdx][colIdx];
    }

    private static void printMap(int[][] map) {
        System.out.println();
        for (int rowIdx = 0; rowIdx < map.length; rowIdx++) {
            System.out.println(Arrays.toString(map[rowIdx]));
        }
    }

    static List<Input> getInputs(Scanner scanner) {
        int caseCount = scanner.nextInt();
        scanner.nextLine();
        List<Input> inputs = new ArrayList<>();

        for (int idx = 0; idx < caseCount; idx++) {
            inputs.add(getInput(scanner));
        }

        return inputs;
    }

    static Input getInput(Scanner scanner) {
        int mapSize = scanner.nextInt();
        int cost = scanner.nextInt();
        scanner.nextLine();

        boolean[][] map = new boolean[mapSize][mapSize];

        for (int rowIdx = 0; rowIdx < mapSize; rowIdx++) {
            for (int colIdx = 0; colIdx < mapSize; colIdx++) {
                map[rowIdx][colIdx] = (scanner.nextInt() != 0);
            }

            scanner.nextLine();
        }

        return new Input(map, cost);
    }

    static class Input {
        boolean[][] map;
        int cost;

        public Input(boolean[][] map, int cost) {
            this.map = map;
            this.cost = cost;
        }
    }
}
