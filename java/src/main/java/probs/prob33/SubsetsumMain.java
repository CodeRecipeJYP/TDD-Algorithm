package probs.prob33;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SubsetsumMain {
    private static int[] sNumberArr;
    private static int sTargetSumS;
    private static int sSolutionCount = 0;

    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("src/main/java/probs/prob33/case01.in"));
        } catch (FileNotFoundException ignored) {
        }

        Scanner scanner = new Scanner(System.in);
        int numberCountN = scanner.nextInt();
        sTargetSumS = scanner.nextInt();
        scanner.nextLine();

        sNumberArr = new int[numberCountN];
        for (int numberIdx = 0; numberIdx < numberCountN; numberIdx++) {
            sNumberArr[numberIdx] = scanner.nextInt();
        }

        System.out.println(getPossibleSubsetCount(numberCountN));

    }

    private static int getPossibleSubsetCount(int length) {
        backTrack(0, 0, length);
        return sSolutionCount;
    }

    private static void backTrack(int state, int depth, int length) {
        if (depth == length) {
            if (check(state)) {
                sSolutionCount++;
            }

            return;
        }

        backTrack(state, depth + 1, length);
        backTrack(state + (1 << depth), depth + 1, length);
    }

    private static boolean check(int state) {
        if (state == 0) {
            return false;
        }

        int[] arr = sNumberArr;
        int sum = 0;

        for (int arrIdx = 0; arrIdx < arr.length; arrIdx++) {
            if ((state & (1 << arrIdx)) != 0) {
                sum += arr[arrIdx];
            }
        }

        return (sTargetSumS == sum);
    }
}
