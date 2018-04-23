package probs.prob37;

import java.util.Scanner;

public class WardrobedoorMain {
    private static int sMin = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int doorCount = scanner.nextInt();
        scanner.nextLine();

        int firstDoorIdx = scanner.nextInt() - 1;
        int secondDoorIdx = scanner.nextInt() - 1;
        scanner.nextLine();

        int doorOrderCount = scanner.nextInt();
        scanner.nextLine();

        int[] doorOrder = new int[doorOrderCount];
        for (int doorOrderIdx = 0; doorOrderIdx < doorOrderCount; doorOrderIdx++) {
            doorOrder[doorOrderIdx] = scanner.nextInt() - 1;
            scanner.nextLine();
        }

        System.out.println(getShortestSequence(doorOrder, firstDoorIdx, secondDoorIdx));
    }

    private static int getShortestSequence(int[] doorOrder, int firstDoorIdx, int secondDoorIdx) {
        backTrack(doorOrder, firstDoorIdx, secondDoorIdx, 0, 0, doorOrder.length);
        return sMin;
    }

    private static void backTrack(int[] doorOrder, int firstDoorIdx, int secondDoorIdx, int sum, int depth, int length) {
        if (depth == length) {
            sMin = Math.min(sMin, sum);
            return;
        }

        backTrack(doorOrder, doorOrder[depth], secondDoorIdx,
                sum + Math.abs(firstDoorIdx - doorOrder[depth]),
                depth + 1, length);

        backTrack(doorOrder, firstDoorIdx, doorOrder[depth],
                sum + Math.abs(secondDoorIdx - doorOrder[depth]),
                depth + 1, length);
    }
}
