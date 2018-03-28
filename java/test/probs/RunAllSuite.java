package probs;

import org.junit.extensions.cpsuite.ClasspathSuite;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;

import static org.junit.extensions.cpsuite.SuiteType.JUNIT38_TEST_CLASSES;
import static org.junit.extensions.cpsuite.SuiteType.TEST_CLASSES;

@RunWith(ClasspathSuite.class)
@ClasspathSuite.SuiteTypes({ JUNIT38_TEST_CLASSES, TEST_CLASSES })
public class RunAllSuite {
    public static void main(String args[]) {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        junit.run(RunAllSuite.class);
    }
}
