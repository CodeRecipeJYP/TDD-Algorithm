package probs.prob31;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;
import static probs.Const.PROJECT_ROOT;
import static probs.RunAllSuite.TEST_PROJECT_ROOT;

public class StatMainTest {

    @Test
    public void main() {
        String filepath = TEST_PROJECT_ROOT + "/prob31/" + "case01.in";
        filepath = TEST_PROJECT_ROOT + "/prob31/" + "case02.in";

        try {
            System.setIn(new FileInputStream(filepath));
        } catch (FileNotFoundException ignore) {
        }

        StatMain.main(null);
    }
}