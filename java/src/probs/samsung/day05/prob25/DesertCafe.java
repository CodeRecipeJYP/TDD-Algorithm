package probs.samsung.day05.prob25;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DesertCafe {
    static final int[][] DIRECTIONS = new int[][] {
            {1, -1},
            {1, 1},
            {-1, 1},
            {-1, -1}
    };

    static int[][] map;
    static Set<Integer> prevDesserts = new HashSet();

    static final int ROW = 0;
    static final int COL = 1;
    static final int IMPOSSIBLE = -1;
    private static int dessertSizeMax = 0;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner = new Scanner(System.in);
        String filepath = "test/probs/samsung/day05/prob25/case01.in";
        Scanner scanner = new Scanner(new File(filepath));

        int caseCount = scanner.nextInt();
        scanner.nextLine();

        for (int caseIdx = 0; caseIdx < caseCount; caseIdx++) {
            getInput(scanner);
            int result = getSolution();
            System.out.println(String.format("#%d %d", caseIdx + 1, result));
            System.out.println(dessertSizeMax);
            dessertSizeMax = 0;
        }
    }

    static int getSolution() {
        int result = IMPOSSIBLE;
        int len = 4;

        while (getSolutionWithLength(len)) {
            result = len;
            len += 2;
        }

        return result;
    }

    private static boolean getSolutionWithLength(int length) {
        assert length >= 4;

        int totalMovement = length / 2;

        for (int southEastMovement = 1; southEastMovement < totalMovement; southEastMovement++) {
            int southWestMovement = totalMovement - southEastMovement;
            if (getSolutionWithMovement(southEastMovement, southWestMovement)) {
                return true;
            }
        }

        return false;
    }

    private static boolean getSolutionWithMovement(int southEastMovement, int southWestMovement) {
        int rowCount = map.length;
        int colCount = map[0].length;

        for (int startRowIdx = 0; startRowIdx < rowCount; startRowIdx++) {
            for (int startColIdx = 0; startColIdx < colCount; startColIdx++) {
                boolean impossibleFlag = false;
                int rowIdx = startRowIdx;
                int colIdx = startColIdx;

                int maximumRowIdx = startRowIdx + southEastMovement + southEastMovement;
                int maximumColIdx = startColIdx + southEastMovement;
                int minimumColIdx = startColIdx - southWestMovement;
                if (!(maximumRowIdx < rowCount && maximumColIdx < colCount && minimumColIdx >= 0)) {
                    continue;
                }

                prevDesserts.clear();

                for (int directionIdx = 0; directionIdx < DIRECTIONS.length; directionIdx++) {
                    if (impossibleFlag) {
                        break;
                    }

                    int[] direction = DIRECTIONS[directionIdx];

                    int movement = 0;
                    if (direction[ROW] * direction[COL] > 0) {
                        movement = southEastMovement;
                    } else {
                        movement = southWestMovement;
                    }

                    for (int moveIdx = 0; moveIdx < movement; moveIdx++) {
                        if (!(0 <= rowIdx && rowIdx < rowCount
                                && 0 <= colIdx && colIdx < colCount)) {
                            impossibleFlag = true;
                            break;
                        }

                        int dessertType = map[rowIdx][colIdx];
                        if (prevDesserts.contains(dessertType)) {
                            impossibleFlag = true;
                            break;
                        }
                        prevDesserts.add(dessertType);

                        if (dessertSizeMax < prevDesserts.size()) {
                            dessertSizeMax = prevDesserts.size();
                        }


                        rowIdx = rowIdx + direction[ROW];
                        colIdx = colIdx + direction[COL];
                    }
                }

                if (!impossibleFlag) {
                    return true;
                }
            }
        }

        return false;
    }

    private static void printMap(int[][] map) {
        System.out.println();
        for (int rowIdx = 0; rowIdx < map.length; rowIdx++) {
            System.out.println(Arrays.toString(map[rowIdx]));
        }
    }

    static void getInput(Scanner scanner) {
        int mapSize = scanner.nextInt();
        scanner.nextLine();

        map = new int[mapSize][mapSize];

        for (int rowIdx = 0; rowIdx < mapSize; rowIdx++) {
            for (int colIdx = 0; colIdx < mapSize; colIdx++) {
                map[rowIdx][colIdx] = scanner.nextInt();
            }

            scanner.nextLine();
        }
    }
}
