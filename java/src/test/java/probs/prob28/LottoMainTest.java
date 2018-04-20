package probs.prob28;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.*;
import static probs.RunAllSuite.TEST_PROJECT_ROOT;

public class LottoMainTest {

    @Test
    public void getInputAndPrintOutput() throws FileNotFoundException {
        String prefix = TEST_PROJECT_ROOT + "/prob28/";
        Scanner scanner = new Scanner(new File(prefix + "case01.in"));
        LottoMain.getInputAndPrintOutput(scanner);

    }
}