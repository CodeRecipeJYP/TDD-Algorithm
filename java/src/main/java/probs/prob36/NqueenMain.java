package probs.prob36;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NqueenMain {
    private static int sCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queenCountN = scanner.nextInt();

        getNqueen(queenCountN);
        System.out.println(sCount);
    }

    private static void getNqueen(int queenCountN) {
        List<Integer> arr = new ArrayList<>();
        backTrack(arr, 0, 0, queenCountN);
    }

    private static void backTrack(List<Integer> arr, int checked, int depth, int length) {
        if (!validateOnlyLastItem(arr)) {
            return;
        }

        if (depth == length) {
            sCount++;
            return;
        }

        for (int value = 0; value < length; value++) {
            if ((checked & (1 << value)) != 0) {
                continue;
            }

            arr.add(value);
            backTrack(arr, checked + (1 << value), depth + 1, length);
            arr.remove(arr.size() - 1);
        }
    }

    private static boolean validateOnlyLastItem(List<Integer> arr) {
        if (arr.size() < 2) {
            return true;
        }

        int lastRow = arr.size() - 1;
        int lastCol = arr.get(arr.size() - 1);
        int lastLeftDownXintercept = lastRow + lastCol;
        int lastLeftUpXintercept = lastRow - lastCol;

        for (int rowIdx = 0; rowIdx < arr.size() - 1; rowIdx++) {
            int colIdx = arr.get(rowIdx);

            int leftDownXintercept = rowIdx + colIdx;
            int leftUpXintercept = rowIdx - colIdx;

            if (lastLeftDownXintercept == leftDownXintercept
                    || lastLeftUpXintercept == leftUpXintercept) {
                return false;
            }
        }

        return true;
    }
}
