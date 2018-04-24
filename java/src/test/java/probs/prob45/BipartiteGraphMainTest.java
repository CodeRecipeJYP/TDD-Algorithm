package probs.prob45;

import org.junit.Test;
import probs.utils.FileioUtils;

import static org.junit.Assert.*;

public class BipartiteGraphMainTest {

    @Test
    public void main() {
        FileioUtils.checkWith(BipartiteGraphMain.class, "prob45", "case09", false);
        FileioUtils.checkWith(BipartiteGraphMain.class, "prob45", "case08", false);
        FileioUtils.checkWith(BipartiteGraphMain.class, "prob45", "case07", false);
        FileioUtils.checkWith(BipartiteGraphMain.class, "prob45", "case06", false);
        FileioUtils.checkWith(BipartiteGraphMain.class, "prob45", "case05", false);
        FileioUtils.checkWith(BipartiteGraphMain.class, "prob45", "case04", false);
        FileioUtils.checkWith(BipartiteGraphMain.class, "prob45", "case03", false);
        FileioUtils.checkWith(BipartiteGraphMain.class, "prob45", "case02", false);
        FileioUtils.checkWith(BipartiteGraphMain.class, "prob45", "case01", false);
    }
}