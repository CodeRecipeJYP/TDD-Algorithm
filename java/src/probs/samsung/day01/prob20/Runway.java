package probs.samsung.day01.prob20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Runway {
    private static char CANNOT_INSTALL_RUNWAY = 'A';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mapSize = scanner.nextInt();
        int runwayLength = scanner.nextInt();
        
        scanner.nextLine();
        char[][] map = new char[mapSize][mapSize];
        for (int rowIdx = 0; rowIdx < mapSize; rowIdx++) {
            for (int colIdx = 0; colIdx < mapSize; colIdx++) {
                map[rowIdx][colIdx] = (char) scanner.nextInt();
            }
        }

        System.out.println(getPassableWayCount(map, runwayLength));
//        printMap(map);
    }

    public static int getPassableWayCount(char[][] map, int runwayLength) {
        List<char[]> everyCandidates = getEveryCandidates(map);
        int count = 0;

        for (char[] candidate:
            everyCandidates){
            if (isPassable(candidate, runwayLength)) {
                count++;
            }
        }

        return count;
    }

    public static boolean isPassable(char[] candidate, int runwayLength) {
        return _isPassable(candidate, runwayLength)
                || _isPassable(arrReverse(candidate), runwayLength);
    }

    public static char[] arrReverse(char[] candidate) {
        char[] reversed = new char[candidate.length];

        for (int idx = 0; idx < candidate.length; idx++) {
            reversed[idx] = candidate[candidate.length - idx - 1];
        }

        return reversed;
    }

    public static boolean _isPassable(char[] candidate, int runwayLength) {
        char[] copy = candidate.clone();

        int prevHeight = copy[0];

        for (int idx = 1; idx < copy.length; idx++) {
            int currHeight = copy[idx];
            int heightDiff = currHeight - prevHeight;

            if (Math.abs(heightDiff) > 1) {
                return false;
            } else if (heightDiff == 1) {
                boolean isRunwayInstallable = true;

                for (int idxDiff = 1; idxDiff <= runwayLength; idxDiff++) {
                    int backwardIdx = idx - idxDiff;

                    if (backwardIdx < 0 || copy[backwardIdx] != prevHeight) {
                        isRunwayInstallable = false;
                        break;
                    }
                }

                if (!isRunwayInstallable) {
                    return false;
                }
            } else if (heightDiff == -1) {
                boolean isRunwayInstallable = true;

                for (int idxDiff = 0; idxDiff < runwayLength; idxDiff++) {
                    int forwardIdx = idx + idxDiff;

                    if (forwardIdx >= copy.length
                            || copy[forwardIdx] != currHeight) {
                        isRunwayInstallable = false;
                        break;
                    }

                    copy[forwardIdx] = CANNOT_INSTALL_RUNWAY;
                }

                if (!isRunwayInstallable) {
                    return false;
                }

                idx += (runwayLength - 1);
            }

            prevHeight = currHeight;
        }

        return true;
    }

    public static List<char[]> getEveryCandidates(char[][] map) {
        List<char[]> candidates = new ArrayList<>();

        candidates.addAll(Arrays.asList(map));

        int rowCount = map.length;
        int colCount = map[0].length;

        for (int colIdx = 0; colIdx < colCount; colIdx++) {
            char[] verticalColumn = new char[colCount];
            for (int rowIdx = 0; rowIdx < rowCount; rowIdx++) {
                verticalColumn[rowIdx] = map[rowIdx][colIdx];
            }

            candidates.add(verticalColumn);
        }

        return candidates;
    }
}
