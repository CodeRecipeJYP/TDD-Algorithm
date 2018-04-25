package probs.utils;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class FileioUtils {
    private static final String PROJECT_TEST_ROOT = "src/test/java";

    public static void checkWith(Class clazz, String packageName, String casefileName, boolean shortly) {
        checkWith(clazz, packageName, casefileName, "", shortly);
    }

    public static void checkWith(Class clazz, String packageName, String casefileName, String message) {
        checkWith(clazz, packageName, casefileName, message, true);
    }

    public static void checkWith(Class clazz, String packageName, String casefileName) {
        checkWith(clazz, packageName, casefileName, "", true);
    }

    public static void checkWith(Class clazz, String packageName, String casefileName, String message, boolean shortly) {
        String filepath = packageName + "/" + casefileName;
        String prefix = "src/test/java/probs/" + filepath;
        Action action = () -> {};
        Method methods[] = clazz.getDeclaredMethods();
        for (Method method:
                methods) {
            if ("main".equals(method.getName())) {
                action = () -> {
                    try {
                        method.invoke(null, (Object) null);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                };
                break;
            }
        }

        checkWith(action, prefix + ".in", prefix + ".out", message, shortly);
    }

    private static void checkWith(Action executable, String inputFilepath, String outputFilepath, String message, boolean shortly) {
        PrintUtils.init();
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
            printLog(expected, actual, message, shortly);
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

    private static void printLog(String expected, String actual, String message, boolean shortly) {
        String headMessage = "";
        if (message != null && !message.equals("")) {
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

    public static void check(boolean shortly) {
        String testClassName = new Throwable().getStackTrace()[1].getClassName();
        String[] splittedClassName = testClassName.split(Pattern.quote("."));
        String path = PROJECT_TEST_ROOT;

        for (int idx = 0; idx < splittedClassName.length - 1; idx++) {
            String directoryName = splittedClassName[idx];
            path += "/" + directoryName;
        }

        List<String> inputFiles = Arrays.stream(new File(path).list())
                .filter(it -> it.matches(".*" + Pattern.quote(".") + "in"))
                .map(it -> it.replace(".in", ""))
                .collect(Collectors.toList());

        try {
            String className = testClassName.replace("Test", "");
            Class clazz = Class.forName(className);

            for (String inputFile :
                    inputFiles) {
                checkWith(clazz, path + "/" + inputFile, shortly);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void checkWith(Class clazz, String inputFile, boolean shortly) {
        Action action = () -> {};
        Method methods[] = clazz.getDeclaredMethods();
        for (Method method:
                methods) {
            if ("main".equals(method.getName())) {
                action = () -> {
                    try {
                        method.invoke(null, (Object) null);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                };
                break;
            }
        }

        checkWith(action, inputFile + ".in", inputFile + ".out", "", shortly);
    }
}
