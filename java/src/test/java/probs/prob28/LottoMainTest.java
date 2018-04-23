package probs.prob28;

import org.junit.Test;
import probs.utils.FileioUtils;

import java.io.FileNotFoundException;

import static probs.RunAllSuite.TEST_PROJECT_ROOT;

public class LottoMainTest {

    @Test
    public void getInputAndPrintOutput() throws FileNotFoundException {
        String prefix = TEST_PROJECT_ROOT + "/prob28/"+ "case01";

        FileioUtils.checkWith(() -> LottoMain.main(null),
                prefix + ".in", prefix + ".out");
    }
}