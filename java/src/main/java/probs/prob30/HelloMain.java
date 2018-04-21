package probs.prob30;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class HelloMain {
    private static final String PROJECT_ROOT = "src/main/java/probs/";
    private static final int IDX_MAX = 9;
    private static final int ARR_LENGTH = 7;

    public static void main(String[] args) {
//        try {
//            System.setIn(new FileInputStream(PROJECT_ROOT + "prob30/case01.in"));
//        } catch (FileNotFoundException ignore) {
//        }

        Scanner scanner = new Scanner(System.in);
        int expectedN = scanner.nextInt();
        findHelloWorld(expectedN);
    }

    private static void findHelloWorld(int expectedN) {
        int idx = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        boolean[] checked = new boolean[IDX_MAX + 1];
        go(idx, arr, checked, expectedN);
        System.out.println("No Answer");
    }

    private static void go(int idx, ArrayList<Integer> arr, boolean[] checked, int expectedN) {
        if (arr.size() == ARR_LENGTH) {
            if (!(arr.get(5) != 0 && arr.get(6) != 0)) {
                return;
            }

            int valFormer = getFullValue(arr, "hello");
            int valLatter = getFullValue(arr, "world");

            if ((valFormer + valLatter) == expectedN) {
                System.out.println(String.format("  %5d\n+ %5d\n-------\n %6d\n", valFormer, valLatter, expectedN));
                System.exit(0);
            }

            return;
        }

        if (idx > IDX_MAX) {
            return;
        }

        for (int uncheckedIdx = 0; uncheckedIdx <= IDX_MAX; uncheckedIdx++) {
            if (checked[uncheckedIdx]) {
                continue;
            }

            arr.add(uncheckedIdx);
            checked[uncheckedIdx] = true;
            go(idx + 1, arr, checked, expectedN);
            checked[uncheckedIdx] = false;
            arr.remove(arr.size() - 1);
        }


    }

    private static int getFullValue(ArrayList<Integer> arr, String seq) {
        String str = "relodhw";
        int ret = 0;

        for (char each :
                seq.toCharArray()) {
            ret = ret * 10 + arr.get(str.indexOf(each));
        }

        return ret;

    }
}
