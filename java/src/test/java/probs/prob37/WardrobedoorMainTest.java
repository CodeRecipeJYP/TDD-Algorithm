package probs.prob37;

import org.junit.Test;
import probs.utils.FileioUtils;


public class WardrobedoorMainTest {

    @Test
    public void main() {
        String prefix = "src/test/java/probs/prob37/case01";
        FileioUtils.checkWith(WardrobedoorMain.class,
                "prob37",
                "case01");
    }
}