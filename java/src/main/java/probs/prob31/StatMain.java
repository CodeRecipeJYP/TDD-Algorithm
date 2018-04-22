package probs.prob31;

import java.util.*;
import java.util.stream.Collectors;

public class StatMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberCount = scanner.nextInt();
        int[] numberArr = new int[numberCount];

        for (int numberIdx = 0; numberIdx < numberCount; numberIdx++) {
            numberArr[numberIdx] = scanner.nextInt();
        }
        System.out.println(getAverage(numberArr));
        System.out.println(getMedian(numberArr));
        System.out.println(getMode(numberArr));
        System.out.println(getRange(numberArr));
    }

    private static Integer getMode(int[] numberArr) {
        Map<Integer, Integer> collected = new HashMap<>();

        for (int numIdx = 0; numIdx < numberArr.length; numIdx++) {
            int each = numberArr[numIdx];
            if (collected.containsKey(each)) {
                collected.replace(each, collected.get(each) + 1);
            } else {
                collected.put(each, 1);
            }
        }

        int max = 0;
        List<Integer> maxArr = new ArrayList<>();
        for (int key :
                collected.keySet()) {
            if (collected.get(key) > max) {
                maxArr.clear();
                maxArr.add(key);
                max = collected.get(key);
            } else if (collected.get(key) == max) {
                maxArr.add(key);
            }
        }

        if (maxArr.size() > 1) {
            List<Integer> sorted = maxArr.stream()
                    .sorted()
                    .collect(Collectors.toList());

            return sorted.get(1);
        }

        return maxArr.get(0);
    }

    private static int getMedian(int[] numberArr) {
        int[] sorted = Arrays.stream(numberArr)
                .sorted()
                .toArray();

        return sorted[(sorted.length - 1)/ 2];
    }

    private static int getAverage(int[] numberArr) {
        int sum = 0;

        for (int numIdx = 0; numIdx < numberArr.length; numIdx++) {
            sum += numberArr[numIdx];
        }

        return (int) Math.round(((double) sum) / numberArr.length);
    }

    private static int getRange(int[] numberArr) {
        int[] sorted = Arrays.stream(numberArr)
                .sorted()
                .toArray();


        return sorted[sorted.length - 1] - sorted[0];
    }
}
