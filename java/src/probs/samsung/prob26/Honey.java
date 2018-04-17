package probs.samsung.prob26;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Honey {
    static int[][] sHoneybox = new int[11][11];
    static boolean[] sChecked = new boolean[6];
    static int[] sCurrBoxRow;
    static int sSelectLengthM;
    static int sCapacityC;
    static int sDfsResult;
    static Queue<Integer> sPq = new PriorityQueue<>();

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(new File("src/probs/samsung/prob26/case01.in"));
        Scanner scanner = new Scanner(new File("src/probs/samsung/prob26/case02.in"));

        int caseCount = scanner.nextInt();
        scanner.nextLine();
        for (int caseIdx = 1; caseIdx <= caseCount; caseIdx++) {
            int boxSize = scanner.nextInt();
            sSelectLengthM = scanner.nextInt();
            sCapacityC = scanner.nextInt();
            scanner.nextLine();

            int profit = 0;
            sPq.clear();
            for (int rowIdx = 1; rowIdx <= boxSize; rowIdx++) {
                for (int colIdx = 1; colIdx <= boxSize; colIdx++) {
                    sHoneybox[rowIdx][colIdx] = scanner.nextInt();
                }
                profit += getMaximumProfit(sHoneybox[rowIdx], boxSize);
            }

            int first = sPq.poll();
            int second = sPq.poll();
            System.out.println(String.format("#%d %d", caseIdx, first + second));
        }
    }

    private static int getMaximumProfit(int[] sHoneybox, int length) {
        int[] localOptima = new int[length + 1];
        for (int idx = 1; idx <= length; idx++) {
            if (idx < sSelectLengthM) {
                localOptima[idx] = 0;
                continue;
            }

            int currOptima = localOptima[idx - sSelectLengthM]
                                + getProfit(sHoneybox, idx - sSelectLengthM + 1, idx);

            boolean isLocalOptimal = true;

            for (int backwardIdx = idx; backwardIdx > (idx - sSelectLengthM); backwardIdx--) {
                if (localOptima[backwardIdx] > currOptima) {
                    isLocalOptimal = false;
                    break;
                }
            }

            if (isLocalOptimal) {
                localOptima[idx] = currOptima;
            }
        }

        return localOptima[length];
    }

    private static int getProfit(int[] sHoneybox, int startIdx, int endIdx) {
        int currAmount = 0;
        sCurrBoxRow = sHoneybox;

        for (int idx = startIdx; idx <= endIdx; idx++) {
            sChecked[idx] = true;
        }

        currAmount = getCurrAmount(sHoneybox, sChecked, startIdx, endIdx);
        int currProfit = getCurrProfit(sHoneybox, sChecked, startIdx, endIdx);
        if (currAmount <= sCapacityC) {
            return currProfit;
        }

        sDfsResult = 0;
        dfs(startIdx, startIdx, endIdx);

        return sDfsResult;
    }

    private static void dfs(int currIdx, int startIdx, int endIdx) {
        for (int i = 0; i < 2; i++) {
            sChecked[currIdx] = (i != 0);
            if (currIdx == endIdx) {
                int currAmount = getCurrAmount(sCurrBoxRow, sChecked, startIdx, endIdx);
                int currProfit = getCurrProfit(sCurrBoxRow, sChecked, startIdx, endIdx);
                if (currAmount <= sCapacityC) {
                    if (sDfsResult < currProfit) {
                        sDfsResult = currProfit;
                    }
                }
            } else {
                dfs(currIdx + 1, startIdx, endIdx);
            }
        }
    }

    private static int getCurrAmount(int[] sHoneybox, boolean[] checked, int startIdx, int endIdx) {
        int result = 0;

        for (int idx = startIdx; idx <= endIdx; idx++) {
            if (sChecked[idx]) {
                result += sHoneybox[idx];
            }
        }

        return result;
    }

    private static int getCurrProfit(int[] sHoneybox, boolean[] checked, int startIdx, int endIdx) {
        int result = 0;

        for (int idx = startIdx; idx <= endIdx; idx++) {
            if (sChecked[idx]) {
                result += Math.pow(sHoneybox[idx], 2);
            }
        }

        return result;
    }
}
