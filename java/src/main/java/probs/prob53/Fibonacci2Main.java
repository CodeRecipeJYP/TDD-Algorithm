package probs.prob53;

import java.util.Scanner;

public class Fibonacci2Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

//        for (n = 1; n <= 90; n++) {
        System.out.println(getFibonacci(n));
//        }
    }

    private static long getFibonacci(int n) {
        long[] saved = new long[n + 1];

        if (n == 1) {
            return 1;
        }

        saved[0] = 0;
        saved[1] = 1;

        for (int idx = 2; idx <= n; idx++) {
            saved[idx] = saved[idx - 1] + saved[idx - 2];
        }

        return saved[n];
    }
}
