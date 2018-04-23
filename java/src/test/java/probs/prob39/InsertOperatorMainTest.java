package probs.prob39;

import org.junit.Test;
import probs.utils.FileioUtils;

import static org.junit.Assert.*;

public class InsertOperatorMainTest {

    @Test
    public void main() {
        FileioUtils.checkWith(InsertOperatorMain.class, "prob39/case01");
        FileioUtils.checkWith(InsertOperatorMain.class, "prob39/case02");
        FileioUtils.checkWith(InsertOperatorMain.class, "prob39/case03");
    }

    @Test
    public void c14Divide() {
        assertEquals(0, InsertOperatorMain.c14Divide(-1, 3));
        assertEquals(0, InsertOperatorMain.c14Divide(1, 3));
        assertEquals(-1, InsertOperatorMain.c14Divide(-4, 3));
        assertEquals(1, InsertOperatorMain.c14Divide(4, 3));
    }
}