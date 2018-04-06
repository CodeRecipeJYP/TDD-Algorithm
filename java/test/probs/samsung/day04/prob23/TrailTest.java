package probs.samsung.day04.prob23;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class TrailTest {

    @Test
    public void getLongestTrail_case01() throws FileNotFoundException {
        Case case01 = getCase("case01");

        assertEquals(case01.output,
                Trail.getLongestTrail(case01.input.map,
                        case01.input.kSize));
    }

    @Test
    public void getLongestTrail_case02() throws FileNotFoundException {
        Case caze = getCase("case02");

        assertEquals(caze.output,
                Trail.getLongestTrail(caze.input.map,
                        caze.input.kSize));
    }

    private Case getCase(String filename) throws FileNotFoundException {
        String prefix = "test/probs/samsung/day04/prob23/" + filename;
        String inputPath = prefix + ".in";
        String outputPath = prefix + ".out";
        Trail.Input input = Trail.getInput(new Scanner(new File(inputPath)));
        int expected = getOutput(new Scanner(new File(outputPath)));

        return new Case(input, expected);
    }

    private int getOutput(Scanner scanner) {
        return scanner.nextInt();
    }

    static class Case {
        Trail.Input input;
        int output;

        public Case(Trail.Input input, int output) {
            this.input = input;
            this.output = output;
        }
    }
}