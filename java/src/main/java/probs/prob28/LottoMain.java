package probs.prob28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class LottoMain {
    private static final int LOTTO_LENGTH = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        getInputAndPrintOutput(scanner);
    }

    static void getInputAndPrintOutput(Scanner scanner) {
        while (true) {
            int numCountK = scanner.nextInt();
            if (numCountK == 0) {
                break;
            }

            int[] numArrS = new int[numCountK];
            for (int numIdx = 0; numIdx < numCountK; numIdx++) {
                numArrS[numIdx] = scanner.nextInt();
            }

            List<int[]> everyCombinations = getEveryCombinations(numArrS);
            printList(everyCombinations);
            System.out.println();
        }
    }

    private static List<int[]> getEveryCombinations(int[] numArrS) {
        final int idxCount = numArrS.length;
        final int length = LOTTO_LENGTH;

        List<int[]> everyIdxCombinations = getEveryIdxCombinations(length, idxCount);
        List<int[]> everyComb = everyIdxCombinations.stream()
                .map(eachIdxComb -> {
                    int[] eachValComb = new int[length];
                    for (int valIdx = 0; valIdx < length; valIdx++) {
                        int eachIdx = eachIdxComb[valIdx];
                        eachValComb[valIdx] = numArrS[eachIdx];
                    }
                    return eachValComb;
                })
                .collect(Collectors.toList());

        return everyComb;
    }

    private static void printList(List<int[]> list) {
        list.stream().forEach(eachComb -> {
                    Arrays.stream(eachComb)
                            .mapToObj(it -> "" + it + " ")
                            .forEach(System.out::print);
                    System.out.println();
                }
        );
    }

    static List<int[]> getEveryIdxCombinations(int length, int idxCount) {
        List<int[]> everyCombinations = new ArrayList<>();
        int[] initialArr = new int[length];

        dfs(everyCombinations, initialArr, 0, length, idxCount);

        return everyCombinations;
    }

    static void dfs(List<int[]> results, int[] currArr, int currIdx, int length, int size) {
        if (currIdx == length) {
            results.add(currArr.clone());

            return;
        }

        int startVal = 0;

        if (currIdx > 0) {
            startVal = currArr[currIdx - 1] + 1;
        }

        int iterCount = (size - length) - (startVal - currIdx) + 1;

        for (int value = startVal; value < startVal + iterCount; value++) {
            currArr[currIdx] = value;
            dfs(results, currArr, currIdx + 1, length, size);
        }
    }
}
