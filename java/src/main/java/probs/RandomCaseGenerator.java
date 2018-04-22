package probs;

import java.util.Random;

public class RandomCaseGenerator {


    public static void main(String[] args) {

        int n = 101;
        int rangeMin = -4000;
        int rangeMax = 4000;

//        linebyline(n, rangeMin, rangeMax);
        linebyline(n, 0, 10);
//        square();
    }

    private static void square(int n, int rangeMin, int rangeMax) {
        int limit = Math.abs(rangeMax - rangeMin);

        new Random().ints(n)
                .forEach(
                        unused -> {
                            new Random().ints(n)
                                    .map(it -> Math.abs(it))
                                    .map(it -> it % (limit + 1))
                                    .map(it -> it + rangeMin)
                                    .forEach(it -> System.out.print(it + " "));
                            System.out.println();
                        }
                );
    }

    private static void linebyline(int n, int rangeMin, int rangeMax) {
        int limit = Math.abs(rangeMax - rangeMin);
        new Random().ints(n)
                .map(it -> Math.abs(it))
                .map(it -> it % (limit + 1))
                .map(it -> it + rangeMin)
                .forEach(System.out::println);
    }
}