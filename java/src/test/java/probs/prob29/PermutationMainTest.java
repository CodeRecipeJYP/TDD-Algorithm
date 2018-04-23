package probs.prob29;

import org.junit.Test;
import probs.utils.FileioUtils;

import java.io.FileNotFoundException;


public class PermutationMainTest {

    @Test
    public void getInputAndPrintSolution() throws FileNotFoundException {
        String prefix = "src/test/java/probs/prob29/case01";

        FileioUtils.checkWith(() -> PermutationMain.main(null), prefix + ".in", prefix + ".out");
    }
}