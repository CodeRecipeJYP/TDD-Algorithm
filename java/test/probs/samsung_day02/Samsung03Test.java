package probs.samsung_day02;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Samsung03Test {

    @Test
    public void getMinimumAbilityDiff() {
    }

    @Test
    public void getEveryCombination() {
        List<List<Integer>> actual = Samsung03.getEveryCombination(4);

        List<List<Integer>> expected = List.of(
                List.of(0, 1),
                List.of(0, 2),
                List.of(0, 3)
        );

        assertEquals(expected, actual);
    }

    @Test
    public void getEveryCombination_2() {
        List<List<Integer>> actual = Samsung03.getEveryCombination(6);

        List<List<Integer>> expected = List.of(
                List.of(0, 1, 2),
                List.of(0, 1, 3),
                List.of(0, 1, 4),
                List.of(0, 1, 5),
                List.of(0, 2, 3),
                List.of(0, 2, 4),
                List.of(0, 2, 5),
                List.of(0, 3, 4),
                List.of(0, 3, 5),
                List.of(0, 4, 5)
        );

        assertEquals(expected, actual);
    }

    @Test
    public void getCombinations() {
    }
}