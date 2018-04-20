package probs.prob29;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static probs.RunAllSuite.TEST_PROJECT_ROOT;

public class PermutationMainTest {

    @Test
    public void getInputAndPrintSolution() throws FileNotFoundException {
        String prefix = TEST_PROJECT_ROOT + "/prob29/";
        Scanner scanner = new Scanner(new File(prefix + "case01.in"));
        PermutationMain.getInputAndPrintSolution(scanner);
    }
}