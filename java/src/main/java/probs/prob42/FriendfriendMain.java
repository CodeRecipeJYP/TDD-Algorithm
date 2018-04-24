package probs.prob42;

import java.util.Arrays;
import java.util.Scanner;

import static probs.utils.MemoryUtils.showMemoryUsage;

public class FriendfriendMain {
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

//        showMemoryUsage();
        Arrays.stream(friendCounts).forEach(System.out::println);
    }
}
