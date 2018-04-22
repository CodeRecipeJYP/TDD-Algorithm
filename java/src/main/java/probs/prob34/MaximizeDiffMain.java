package probs.prob34;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaximizeDiffMain {
    private static int[] sNumberArr;
    private static int sMax = 0;

    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("src/main/java/probs/prob34/case01.in"));
        } catch (FileNotFoundException ignored) {
        }

        Scanner scanner = new Scanner(System.in);
        int numberCountN = scanner.nextInt();
        sNumberArr = new int[numberCountN];
        for (int numberIdx = 0; numberIdx < numberCountN; numberIdx++) {
            sNumberArr[numberIdx] = scanner.nextInt();
        }

        System.out.println(getMaxDiff());
    }

    private static int getMaxDiff() {
        boolean[] state = new boolean[sNumberArr.length];
        backTrack(new ArrayList<>(), state, 0, sNumberArr.length);

        return sMax;
    }

    private static void backTrack(List<Integer> selected, boolean[] checked, int depth, int length) {
        if (depth == length) {
            sMax = Math.max(getDiff(selected), sMax);
            return;
        }

        for (int unselectedIdx = 0; unselectedIdx < length; unselectedIdx++) {
            if (checked[unselectedIdx]) {
                continue;
            }

            selected.add(unselectedIdx);
            checked[unselectedIdx] = true;
            backTrack(selected, checked, depth + 1, length);
            selected.remove(selected.size() - 1);
            checked[unselectedIdx] = false;
        }
    }

    private static int getDiff(List<Integer> selected) {
        int sum = 0;

        for (int selectedIdx = 0; selectedIdx < (selected.size() - 1); selectedIdx++) {
            int orderedNumberIdx1 = selected.get(selectedIdx);
            int orderedNumberIdx2 = selected.get(selectedIdx + 1);
            sum += Math.abs(sNumberArr[orderedNumberIdx1] - sNumberArr[orderedNumberIdx2]);
        }

        return sum;
    }
}
