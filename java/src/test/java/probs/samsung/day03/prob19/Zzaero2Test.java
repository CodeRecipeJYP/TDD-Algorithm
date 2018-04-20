package probs.samsung.day03.prob19;

import org.junit.Test;
import probs.samsung.day01.prob19.Zzaero;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.*;
import static probs.RunAllSuite.TEST_PROJECT_ROOT;
import static probs.samsung.day03.prob19.Zzaero2.DIRECTIONS;
import static probs.samsung.day03.prob19.Zzaero2.LEFT;
import static probs.samsung.day03.prob19.Zzaero2.getCleanMap;

public class Zzaero2Test {
    private static final String CLASS_ROOT = TEST_PROJECT_ROOT + "/samsung/day03/prob19";

    @Test
    public void getMinimumTrials() throws FileNotFoundException {
        String prefix = CLASS_ROOT+ "/case01";
        String path = prefix + ".in";
        char[][] input = Zzaero2.getInput(new Scanner(new File(path)));

        assertEquals(1, Zzaero2.getMinimumTrials(input));
    }

    @Test
    public void getMinimumTrials_2() throws FileNotFoundException {
        String prefix = CLASS_ROOT+ "/case02";
        String path = prefix + ".in";
        char[][] input = Zzaero2.getInput(new Scanner(new File(path)));

        assertEquals(5, Zzaero2.getMinimumTrials(input));
    }

    @Test
    public void getMinimumTrials_3() throws FileNotFoundException {
        String prefix = CLASS_ROOT+ "/case03";
        String path = prefix + ".in";
        char[][] input = Zzaero2.getInput(new Scanner(new File(path)));

        assertEquals(5, Zzaero2.getMinimumTrials(input));
    }

    @Test
    public void getMinimumTrials_4() throws FileNotFoundException {
        String prefix = CLASS_ROOT+ "/case04";
        String path = prefix + ".in";
        char[][] input = Zzaero2.getInput(new Scanner(new File(path)));

        assertEquals(-1, Zzaero2.getMinimumTrials(input));
    }

    @Test
    public void getMinimumTrials_5() throws FileNotFoundException {
        String prefix = CLASS_ROOT+ "/case05";
        String path = prefix + ".in";
        char[][] input = Zzaero2.getInput(new Scanner(new File(path)));

        assertEquals(1, Zzaero2.getMinimumTrials(input));
    }

    @Test
    public void getMinimumTrials_6() throws FileNotFoundException {
        String prefix = CLASS_ROOT+ "/case06";
        String path = prefix + ".in";
        char[][] input = Zzaero2.getInput(new Scanner(new File(path)));

        assertEquals(7, Zzaero2.getMinimumTrials(input));
    }

    @Test
    public void getMinimumTrials_7() throws FileNotFoundException {
        String prefix = CLASS_ROOT+ "/case07";
        String path = prefix + ".in";
        char[][] input = Zzaero2.getInput(new Scanner(new File(path)));

        assertEquals(-1, Zzaero2.getMinimumTrials(input));
    }

    @Test
    public void executeTilt_left_withnocollision() throws FileNotFoundException {
        String prefix = CLASS_ROOT+ "/executetilt01";
        String inputPath = prefix + ".in";
        String outputPath = prefix + "_left.out";
        char[][] map = Zzaero2.getInput(new Scanner(new File(inputPath)));
        char[][] expected = Zzaero2.getInput(new Scanner(new File(outputPath)));

        assertEquals(Zzaero2.getState(expected),
                Zzaero2.executeTilt(getCleanMap(map), Zzaero2.getState(map), DIRECTIONS[LEFT]));
    }

    @Test
    public void executeTilt_left_withcollision() throws FileNotFoundException {
        String prefix = CLASS_ROOT+ "/executetilt02";
        String inputPath = prefix + ".in";
        String outputPath = prefix + "_left.out";
        char[][] map = Zzaero2.getInput(new Scanner(new File(inputPath)));
        char[][] expected = Zzaero2.getInput(new Scanner(new File(outputPath)));

        assertEquals(Zzaero2.getState(expected),
                Zzaero2.executeTilt(getCleanMap(map), Zzaero2.getState(map), DIRECTIONS[LEFT]));
    }

    public static void printMap(String message, char[][] map) {
        System.out.println(message);

        for (char[] eachRow:
                map) {
            System.out.println(eachRow);
        }
    }

}