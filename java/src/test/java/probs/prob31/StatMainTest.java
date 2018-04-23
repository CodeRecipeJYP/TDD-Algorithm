package probs.prob31;

import org.junit.Test;
import probs.utils.FileioUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;
import static probs.Const.PROJECT_ROOT;
import static probs.RunAllSuite.TEST_PROJECT_ROOT;

public class StatMainTest {

    @Test
    public void case01() {
        for (int caseIdx = 1; caseIdx <= 3; caseIdx++) {
            String prefix = TEST_PROJECT_ROOT + "/prob31/" + "case0" + caseIdx;
            FileioUtils.checkWith(() -> StatMain.main(null),
                    prefix + ".in", prefix + ".out",
                    String.format("caseIdx = %d", caseIdx));
        }
    }
}