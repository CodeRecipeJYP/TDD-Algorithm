package probs.prob45;

import org.junit.Test;
import probs.utils.FileioUtils;

import static org.junit.Assert.*;

public class BipartiteGraphMainTest {

    @Test
    public void main() {
        FileioUtils.checkWith(BipartiteGraphMain.class, "prob45", "case01", false);
    }
}