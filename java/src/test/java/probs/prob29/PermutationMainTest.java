package probs.prob29;

import org.junit.Test;
import probs.utils.FileioUtils;

public class PermutationMainTest {

    @Test
    public void getInputAndPrintSolution() {
        FileioUtils.checkWith(PermutationMain.class, "prob29", "case01");
    }
}