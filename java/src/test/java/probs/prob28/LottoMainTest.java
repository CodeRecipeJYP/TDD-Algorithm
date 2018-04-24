package probs.prob28;

import org.junit.Test;
import probs.utils.FileioUtils;


public class LottoMainTest {

    @Test
    public void getInputAndPrintOutput() {
        FileioUtils.checkWith(LottoMain.class,
                "prob28",
                "case01");
    }
}