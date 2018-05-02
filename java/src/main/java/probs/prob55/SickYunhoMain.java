package probs.prob55;

import java.util.Scanner;

public class SickYunhoMain {
    private static final String MATCHER = "BLD";
    private static final int MORNING = 0;
    private static final int LUNCH = 1;
    private static final int DINNER = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dayN = scanner.nextInt();
        scanner.nextLine();
        String input = scanner.nextLine();

        System.out.println(getMaximumPillCount(dayN, input.toCharArray()));
    }

    private static int getMaximumPillCount(int dayN, char[] inputs) {
        return getSubsetMaximum(inputs, 0, inputs.length - 1, MORNING);
    }

    private static int getSubsetMaximum(char[] inputs, int headIdx, int tailIdx, int time) {
        if (headIdx == tailIdx) {
            if (MATCHER.indexOf(inputs[headIdx]) == time) {
                return 1;
            } else {
                return 0;
            }
        }

        int head = MATCHER.indexOf(inputs[headIdx]);
        int tail = MATCHER.indexOf(inputs[tailIdx]);

        if (head == tail && head == time) {
            return Math.max(getSubsetMaximum(inputs, headIdx + 1, tailIdx, nextTime(time)),
                    getSubsetMaximum(inputs, headIdx, tailIdx - 1, nextTime(time))) + 1;
        }

        if (head == time) {
            return getSubsetMaximum(inputs, headIdx + 1, tailIdx, nextTime(time)) + 1;
        }

        if (tail == time) {
            return getSubsetMaximum(inputs, headIdx, tailIdx - 1, nextTime(time)) + 1;
        }

        return 0;
    }

    private static int nextTime(int time) {
        return (time + 1) % 3;
    }
}
