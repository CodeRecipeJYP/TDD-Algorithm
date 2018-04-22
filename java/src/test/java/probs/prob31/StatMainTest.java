package probs.prob31;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;
import static probs.Const.PROJECT_ROOT;
import static probs.RunAllSuite.TEST_PROJECT_ROOT;

public class StatMainTest {

    @Test
    public void case01() {
        String filepath;
        filepath = TEST_PROJECT_ROOT + "/prob31/" + "case01.in";

        try {
            System.setIn(new FileInputStream(filepath));
        } catch (FileNotFoundException ignore) {
        }

        StatMain.main(null);
    }

    @Test
    public void case02() {
        String filepath;
        filepath = TEST_PROJECT_ROOT + "/prob31/" + "case02.in";

        try {
            System.setIn(new FileInputStream(filepath));
        } catch (FileNotFoundException ignore) {
        }

        StatMain.main(null);
    }

    @Test
    public void case03() {
        String filepath;
        filepath = TEST_PROJECT_ROOT + "/prob31/" + "case03.in";

        try {
            System.setIn(new FileInputStream(filepath));
        } catch (FileNotFoundException ignore) {
        }

        StatMain.main(null);
    }
}