package probs.prob35;

import org.junit.Test;
import probs.utils.FileioUtils;

import java.io.*;

public class EscapeBall2MainTest {

    @Test
    public void main_1() {
        for (int caseIdx = 1; caseIdx <= 7; caseIdx++) {
            FileioUtils.checkWith(EscapeBall2Main.class,
                    "prob35",
                    "case0" + caseIdx,
                    String.format("caseIdx = %d", caseIdx));
        }
    }

//    @Test
//    public void main_2() throws IOException {
//        String prefix = "src/main/java/probs/prob35/case07";
//
//        System.setIn(new FileInputStream(prefix + ".in"));
//
//        EscapeBall2Main.main(null);
//    }
}