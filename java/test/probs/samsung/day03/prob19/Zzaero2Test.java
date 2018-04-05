package probs.samsung.day03.prob19;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class Zzaero2Test {

    @Test
    public void getMinimumTrials() throws FileNotFoundException {
        String prefix = "test/probs/samsung/day03/prob19/case01";
        String path = prefix + ".in";
        char[][] input = Zzaero2.getInput(new Scanner(new File(path)));
        Zzaero2.getMinimumTrials(input);
    }
}