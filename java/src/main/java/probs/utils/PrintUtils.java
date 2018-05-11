package probs.utils;

import java.io.PrintStream;
import java.util.Arrays;

public class PrintUtils {
    private static PrintStream sStdout = System.out;

    public static void printMap(int[][] map, String tag) {
        PrintUtils.println(tag);

        Arrays.stream(map).forEach(
                eachRow -> {
                    Arrays.stream(eachRow)
                            .forEach(it -> PrintUtils.print(it + " "));
                    PrintUtils.println();
                }
        );

        PrintUtils.println();
    }

    public static void init() {
    }

    public static void println(String s) {
        sStdout.println(s);
    }

    public static void println() {
        sStdout.println();
    }

    public static void print(String s) {
        sStdout.print(s);
    }
}
