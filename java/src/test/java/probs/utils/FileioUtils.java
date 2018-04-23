package probs.utils;

import probs.prob35.EscapeBall2Main;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class FileioUtils {

    public static void checkWith(Action executable, String inputFilepath, String outputFilepath, String message) {
        PrintStream stdout = System.out;
        try {
            System.setIn(new FileInputStream(inputFilepath));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(byteArrayOutputStream));

            executable.run();
            String actual = trimEachLine(byteArrayOutputStream.toString());

            String expected = getStringFrom(outputFilepath).trim();
            assertEquals(expected, actual);

            System.setOut(stdout);
//            printLog(expected, actual, message);
            printLogShortly(expected, actual, message);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printLogShortly(String expected, String actual, String message) {
        printLog(expected, actual, message, true);
    }

    private static String trimEachLine(String s) {
        StringBuilder result = new StringBuilder();

        String[] splittedExpected = s.split("\n");
        for (String eachLine:
             splittedExpected) {
            result.append(eachLine.trim());
            result.append("\n");
        }

        return result.toString().trim();
    }

    private static void printLog(String expected, String actual, String message) {
        printLog(expected, actual, message, false);
    }

    private static void printLog(String expected, String actual, String message, boolean shortly) {
        String headMessage = "";
        if (message != null) {
            headMessage += "[" + message + "] ";
        }

        String[] splittedExpected = expected.split("\n");
        String[] splittedActual = actual.split("\n");

        if (shortly) {
            splittedExpected = new String[] {
                    splittedExpected[0]
            };
            splittedActual = new String[] {
                    splittedActual[0]
            };
        }

        int splittedExpectedLength = maxLength(splittedExpected);
        int splittedActualLength = maxLength(splittedActual);
        int lineCount = Math.max(splittedExpected.length, splittedActual.length);

        for (int lineIdx = 0; lineIdx < lineCount; lineIdx++) {
            StringBuilder eachLine = new StringBuilder();
            eachLine.append("expected = [");
            if (lineIdx < splittedActual.length) {
                eachLine.append(String.format("%1$" + splittedExpectedLength + "s", splittedExpected[lineIdx]));
            }
            eachLine.append("]");

            eachLine.append(", actual = [");
            if (lineIdx < splittedExpected.length) {
                eachLine.append(String.format("%1$" + splittedActualLength + "s", splittedActual[lineIdx]));
            }
            eachLine.append("]");

            if (shortly) {
                System.out.println(headMessage + eachLine.toString() + "...");
            } else {
                System.out.println(headMessage + eachLine.toString());
            }
        }
    }

    private static int maxLength(String[] splittedActual) {
        int max = 0;

        for (String eachLine :
                splittedActual) {
            max = Math.max(max, eachLine.length());
        }

        return max;
    }

    private static String getStringFrom(String filepath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(filepath));

        StringBuilder expectedBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            expectedBuilder.append(scanner.nextLine().trim());
            expectedBuilder.append("\n");
        }

        return expectedBuilder.toString();
    }

    public static void checkWith(Action executable, String inputFilepath, String outputFilepath) {

        checkWith(executable, inputFilepath, outputFilepath, null);
    }
}
