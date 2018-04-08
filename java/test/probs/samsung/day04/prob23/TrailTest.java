package probs.samsung.day04.prob23;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
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

    @Test
    public void getLongestTrail_case03() throws FileNotFoundException {
        List<Case> cazes = getCases("case03");

        for (int caseIdx = 0; caseIdx < cazes.size(); caseIdx++) {
            Case caze = cazes.get(caseIdx);
            assertEquals(caze.output,
                    Trail.getLongestTrail(caze.input.map,
                            caze.input.kSize));
        }
    }

    @Test
    public void getLongestTrail_case04() throws FileNotFoundException {
        Case caze = getCase("case04");

        assertEquals(caze.output,
                Trail.getLongestTrail(caze.input.map,
                        caze.input.kSize));
    }

    @Test
    public void getLongestTrail_case05() throws FileNotFoundException {
        Case caze = getCase("case05");

        assertEquals(caze.output,
                Trail.getLongestTrail(caze.input.map,
                        caze.input.kSize));
    }

    @Test
    public void getLongestTrail_case06() throws FileNotFoundException {
        Case caze = getCase("case06");

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

    private List<Case> getCases(String filename) throws FileNotFoundException {
        String prefix = "test/probs/samsung/day04/prob23/" + filename;
        String inputPath = prefix + ".in";
        String outputPath = prefix + ".out";
        List<Trail.Input> inputs = Trail.getInputs(new Scanner(new File(inputPath)));
        List<Integer> outputs = getOutputs(new Scanner(new File(outputPath)));

        List<Case> cazes = new ArrayList<>();

        for (int caseIdx = 0; caseIdx < inputs.size(); caseIdx++) {
            Trail.Input input = inputs.get(caseIdx);
            int expected = outputs.get(caseIdx);
            cazes.add(new Case(input, expected));
        }

        return cazes;
    }

    private List<Integer> getOutputs(Scanner scanner) {
        List<Integer> result = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String s = scanner.next();

            result.add(scanner.nextInt());
            scanner.nextLine();
        }

        return result;
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