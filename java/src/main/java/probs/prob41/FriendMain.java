package probs.prob41;

import java.util.Arrays;
import java.util.Scanner;

public class FriendMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentCount = scanner.nextInt();
        int relationCount = scanner.nextInt();
        scanner.nextLine();

        int[] friendCounts = new int[studentCount];
        for (int relationIdx = 0; relationIdx < relationCount; relationIdx++) {
            int friendAidx = scanner.nextInt() - 1;
            int friendBidx = scanner.nextInt() - 1;
            friendCounts[friendAidx]++;
            friendCounts[friendBidx]++;
            scanner.nextLine();
        }

        Arrays.stream(friendCounts).forEach(System.out::println);
    }
}
