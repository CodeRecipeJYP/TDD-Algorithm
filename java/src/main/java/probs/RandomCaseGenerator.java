package probs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class RandomCaseGenerator {


    public static void main(String[] args) {

        int n = 101;
        int rangeMin = -4000;
        int rangeMax = 4000;

//        linebyline(n, rangeMin, rangeMax);
//        linebyline(n, 0, 10);
//        relation(11, 1, 5);

        fileWrite("src/test/java/probs/prob42/case01.in");
        int relationCountM = 1000000;
        int studentCountN = 100000;
        System.out.println("" + studentCountN + " " + relationCountM);
        relation(relationCountM, 1, studentCountN);
//        square();
    }

    private static void fileWrite(String filepath) {
        try {
            System.setOut(new PrintStream(new File(filepath)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void relation(int n, int rangeMin, int rangeMax) {
        int limit = Math.abs(rangeMax - rangeMin + 1);
        int count = 0;
        Random random = new Random();

        Set uniqueSet = new HashSet();
        while (true) {
            if (count == n) {
                break;
            }
            int relationA = random.nextInt(limit);
            int relationB;
            while (true) {
                relationB = random.nextInt(limit);
                if (relationB != relationA) {
                    break;
                }
            }

            Pair pair = new Pair(relationA + rangeMin, relationB + rangeMin);

            if (uniqueSet.contains(pair)) {
                continue;
            }
            uniqueSet.add(pair);
            System.out.println(pair);
            count++;
        }
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

    static class Pair {
        int smaller;
        int larger;

        public Pair(int a, int b) {
            assert(a != b);
            this.smaller = Math.min(a, b);
            this.larger = Math.max(a, b);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return smaller == pair.smaller &&
                    larger == pair.larger;
        }

        @Override
        public int hashCode() {

            return Objects.hash(smaller, larger);
        }

        @Override
        public String toString() {
            return "" + smaller + " " + larger;
        }
    }
}