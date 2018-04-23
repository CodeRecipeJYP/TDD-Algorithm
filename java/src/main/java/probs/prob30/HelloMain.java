package probs.prob30;


import java.util.*;

public class HelloMain {
    private static final String FORMER = "hello";
    private static final String LATTER = "world";
    private static final String UNIQUE_ALPHABET = "helowrd";
    private static int sExpectedN;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        sExpectedN = scanner.nextInt();

        backTrack(new ArrayList<>(), 0, 0, 10);
        System.out.println("No Answer");
    }

    private static void backTrack(List<Integer> selectedList, int selected, int depth, int length) {
        if (selectedList.size() == UNIQUE_ALPHABET.length()) {
            calculate(selectedList);
            return;
        }

        if (depth == length) {
            return;
        }

        if ((selectedList.size() + (length - depth)) < UNIQUE_ALPHABET.length()) {
            return;
        }

        for (int idx = 0; idx < length; idx++) {
            if ((selected & (1 << idx)) != 0) {
                continue;
            }
            selectedList.add(idx);
            backTrack(selectedList, selected + (1 << idx), depth + 1, length);
            selectedList.remove(selectedList.size() - 1);
        }
    }

    private static void calculate(List<Integer> state) {
        int hIdx = UNIQUE_ALPHABET.indexOf(FORMER.charAt(0));
        int wIdx = UNIQUE_ALPHABET.indexOf(LATTER.charAt(0));
        if (state.get(hIdx) == 0 || state.get(wIdx) == 0) {
            return;
        }

        int formerResult = 0;
        int latterResult = 0;

        for (int idx = 0; idx < FORMER.length(); idx++) {
            int formerIdx = UNIQUE_ALPHABET.indexOf(FORMER.charAt(idx));
            int latterIdx = UNIQUE_ALPHABET.indexOf(LATTER.charAt(idx));
            int formerValue = state.get(formerIdx);
            int latterValue = state.get(latterIdx);
            formerResult = formerResult * 10 + formerValue;
            latterResult = latterResult * 10 + latterValue;
        }

        if (sExpectedN == formerResult + latterResult) {
            printResult(formerResult, latterResult, sExpectedN);
            System.exit(0);
        }
    }

    private static void printResult(int former, int latter, int expected) {
        System.out.println("  " + former);
        System.out.println("+ " + latter);
        System.out.println("-------");
        System.out.println(String.format(" %6d", expected));
    }
}
