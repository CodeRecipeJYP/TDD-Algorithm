package probs.prob32;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class GeneratePasswordMain {
    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("src/main/java/probs/prob32/case01.in"));
        } catch (FileNotFoundException ignore) {
        }

        Scanner scanner = new Scanner(System.in);
        int passLengthL = scanner.nextInt();
        int candidateCountC = scanner.nextInt();
        scanner.nextLine();

        int[] candidateArr = new int[candidateCountC];
        String candidates = scanner.nextLine();

        for (int candidateIdx = 0; candidateIdx < candidateCountC; candidateIdx++) {
            char candidate = candidates.charAt(2 * candidateIdx);
            candidateArr[candidateIdx] = candidate;
        }

        int[] sorted = Arrays.stream(candidateArr)
                .sorted()
                .toArray();

        backTrack(sorted, 0, 0, 0, passLengthL);
    }

    private static void backTrack(int[] arr, int state, int depth, int selectedLength, int targetLength) {
        if (targetLength == selectedLength) {
            String selected = getSelected(arr, state);
            if (isValid(selected)) {
                System.out.println(selected);
            }

            return;
        }

        if (depth == arr.length) {
            return;
        }

        int addedState = state + (1 << depth);
        backTrack(arr, addedState, depth + 1 ,selectedLength + 1, targetLength);
        backTrack(arr, state, depth + 1, selectedLength, targetLength);
    }

    private static String getSelected(int[] arr, int state) {
        StringBuilder result = new StringBuilder();
        for (int idx = 0; idx < arr.length; idx++) {
            if ((state & (1 << idx)) != 0) {
                result.append((char) arr[idx]);
            }
        }
        return result.toString();
    }

    private static boolean isValid(String selected) {
        String vowels = "aeiou";
        int consonantCount = 0;
        int vowelCount = 0;

        for (int charIdx = 0; charIdx < selected.length(); charIdx++) {
            if (vowels.indexOf(selected.charAt(charIdx)) != -1) {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }

        return (vowelCount >= 1 && consonantCount >= 2);
    }
}
