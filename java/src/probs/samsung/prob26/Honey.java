package probs.samsung.prob26;

import java.util.Scanner;

public class Honey {
    static int[][] sHoneybox = new int[11][11];
    static int sSelectLengthM;
    static int sCapacityC;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int caseCount = scanner.nextInt();
        scanner.nextLine();
        for (int caseIdx = 1; caseIdx <= caseCount; caseIdx++) {
            int boxSize = scanner.nextInt();
            sSelectLengthM = scanner.nextInt();
            sCapacityC = scanner.nextInt();
            scanner.nextLine();

            int profit = 0;
            for (int rowIdx = 1; rowIdx <= boxSize; rowIdx++) {
                for (int colIdx = 1; colIdx <= boxSize; colIdx++) {
                    sHoneybox[rowIdx][colIdx] = scanner.nextInt();
                    profit += getMaximumProfit(sHoneybox[rowIdx]);
                }

            }
            System.out.println(String.format("#%d %d", caseIdx, profit);
        }
    }

    private static int getMaximumProfit(int[] sHoneybox) {
        return 0;
    }
}
