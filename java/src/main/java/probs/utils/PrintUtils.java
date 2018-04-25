package probs.utils;

import java.io.PrintStream;

public class PrintUtils {
    private static PrintStream sStdout = System.out;

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
