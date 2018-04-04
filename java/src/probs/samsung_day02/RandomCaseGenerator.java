package probs.samsung_day02;

import java.util.Random;

public class RandomCaseGenerator {
    public static void main(String[] args) {
        int n = 20;
        int limit = 5;

        new Random().ints(n)
                .forEach(
                        unused -> {
                            new Random().ints(n)
                                    .map(it -> Math.abs(it))
                                    .map(it -> it % (limit + 1))
                                    .map(it -> (int) Math.pow(2, it))
                                    .forEach(it -> System.out.print(it + " "));
                            System.out.println();
                        }
                );

    }
}