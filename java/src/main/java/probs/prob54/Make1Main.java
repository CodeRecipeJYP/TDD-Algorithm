package probs.prob54;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Make1Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int givenN = scanner.nextInt();
        scanner.nextLine();

        System.out.println(getOperatorCount(givenN));
    }

    private static int getOperatorCount(int givenN) {
        int[] counts = new int[givenN + 1];

        counts[1] = 0;

        for (int n = 2; n <= givenN; n++) {
            List<Integer> currCases = new ArrayList<>();
            currCases.add(counts[n - 1] + 1);
            if (n % 2 == 0) {
                currCases.add(counts[n / 2] + 1);
            }
            if (n % 3 == 0) {
                currCases.add(counts[n / 3] + 1);
            }

            int currMin = Integer.MAX_VALUE;
            for (int idx = 0; idx < currCases.size(); idx++) {
                currMin = Math.min(currMin, currCases.get(idx));
            }

            counts[n] = currMin;
        }

        return counts[givenN];
    }
}
