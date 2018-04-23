package probs.prob39;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertOperatorMain {
    private static final int OPERATOR_TYPE_COUNT = 4;
    private static final int PLUS = 0;
    private static final int MINUS = 1;
    private static final int MULTIPLY = 2;
    private static final int DIVIDE = 3;
    private static int[] sNumberArr;
    private static int sMin = Integer.MAX_VALUE;
    private static int sMax = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberCount = scanner.nextInt();
        scanner.nextLine();

        sNumberArr = new int[numberCount];
        for (int numberIdx = 0; numberIdx < numberCount; numberIdx++) {
            sNumberArr[numberIdx] = scanner.nextInt();
        }
        scanner.nextLine();

        int[] operatorCounts = new int[OPERATOR_TYPE_COUNT];
        for (int operatorIdx = 0; operatorIdx < OPERATOR_TYPE_COUNT; operatorIdx++) {
            operatorCounts[operatorIdx] = scanner.nextInt();
        }

        backTrack(new ArrayList<>(), operatorCounts, 0, numberCount - 1);
        System.out.println(sMax);
        System.out.println(sMin);
    }

    private static void backTrack(List<Integer> selectedOperators, int[] operatorCounts, int depth, int length) {
        if (depth == length) {
            sMin = Math.min(sMin, calculate(selectedOperators));
            sMax = Math.max(sMax, calculate(selectedOperators));
            return;
        }

        for (int operatorType = 0; operatorType < OPERATOR_TYPE_COUNT; operatorType++) {
            if (operatorCounts[operatorType] == 0) {
                continue;
            }

            selectedOperators.add(operatorType);
            operatorCounts[operatorType]--;
            backTrack(selectedOperators, operatorCounts, depth + 1, length);
            selectedOperators.remove(selectedOperators.size() - 1);
            operatorCounts[operatorType]++;
        }
    }

    private static int calculate(List<Integer> selectedOperators) {
        int result = sNumberArr[0];
        for (int idx = 0; idx < selectedOperators.size(); idx++) {
            int currValue = sNumberArr[idx + 1];

            switch (selectedOperators.get(idx)) {
                case PLUS:
                    result = result + currValue;
                    break;
                case MINUS:
                    result = result - currValue;
                    break;
                case MULTIPLY:
                    result = result * currValue;
                    break;
                case DIVIDE:
                    result = c14Divide(result, currValue);
                    break;
                default:
                    assert(false);
                    break;
            }
        }

        return result;
    }

    static int c14Divide(int v1, int v2) {
        return v1 / v2;
    }
}
