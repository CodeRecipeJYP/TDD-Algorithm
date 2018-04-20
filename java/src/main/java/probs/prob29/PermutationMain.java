package probs.prob29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PermutationMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        getInputAndPrintSolution(scanner);
    }

    static void getInputAndPrintSolution(Scanner scanner) {
        int numberN = scanner.nextInt();
        printList(getEveryPermutation(numberN));
    }

    private static List<int[]> getEveryPermutation(int numberN) {
        List<int[]> results = new ArrayList<>();
        int[] currArr = new int[numberN];
        boolean[] usedArr = new boolean[numberN];

        dfs(results, currArr, usedArr, 0, numberN);
        return results;
    }

    private static void printList(List<int[]> list) {
        list.stream().forEach(
                eachRow -> {
                    Arrays.stream(eachRow)
                            .mapToObj(it -> "" + it + " ")
                            .forEach(System.out::print);
                    System.out.println();
                }
        );
    }

    private static void dfs(List<int[]> results, int[] currArr, boolean[] usedArr, int depth, int length) {
        if (length == depth) {
            results.add(currArr.clone());
            return;
        }

        for (int idx = 0; idx < usedArr.length; idx++) {
            if (usedArr[idx]) {
                continue;
            }

            currArr[depth] = idx + 1;
            usedArr[idx] = true;
            dfs(results, currArr, usedArr, depth + 1, length);
            usedArr[idx] = false;
        }
    }
}
