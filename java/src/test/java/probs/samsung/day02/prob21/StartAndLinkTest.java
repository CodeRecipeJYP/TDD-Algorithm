package probs.samsung.day02.prob21;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static probs.utils.ListUtils.listOf;

public class StartAndLinkTest {

    @Test
    public void getMinimumAbilityDiff() {
        int[][] table = new int[][] {
                {0, 5, 4, 5, 4, 5, 4, 5},
                {4, 0, 5, 1, 2, 3, 4, 5},
                {9, 8, 0, 1, 2, 3, 1, 2},
                {9, 9, 9, 0, 9, 9, 9, 9},
                {1, 1, 1, 1, 0, 1, 1, 1},
                {8, 7, 6, 5, 4, 0, 3, 2},
                {9, 1, 9, 1, 9, 1, 0, 9},
                {6, 5, 4, 3, 2, 1, 9, 0}
        };

        assertEquals(1,
                StartAndLink.getMinimumAbilityDiff(table));
    }

    @Test
    public void getEveryCombination() {
        List<List<Integer>> actual = StartAndLink.getEveryCombination(4);

        List<List<Integer>> expected = listOf(
                listOf(0, 1),
                listOf(0, 2),
                listOf(0, 3)
        );

        assertEquals(expected, actual);
    }

    @Test
    public void getEveryCombination_2() {
        List<List<Integer>> actual = StartAndLink.getEveryCombination(6);

        List<List<Integer>> expected = listOf(
                listOf(0, 1, 2),
                listOf(0, 1, 3),
                listOf(0, 1, 4),
                listOf(0, 1, 5),
                listOf(0, 2, 3),
                listOf(0, 2, 4),
                listOf(0, 2, 5),
                listOf(0, 3, 4),
                listOf(0, 3, 5),
                listOf(0, 4, 5)
        );

        assertEquals(expected, actual);
    }

    @Test
    public void getEveryCombination_3() {
        List<List<Integer>> actual = StartAndLink.getEveryCombination(8);

        List<List<Integer>> expected = listOf(
                listOf(0, 1, 2, 3),
                listOf(0, 1, 2, 4),
                listOf(0, 1, 2, 5),
                listOf(0, 1, 2, 6),
                listOf(0, 1, 2, 7),
                listOf(0, 1, 3, 4),
                listOf(0, 1, 3, 5),
                listOf(0, 1, 3, 6),
                listOf(0, 1, 3, 7),
                listOf(0, 1, 4, 5),
                listOf(0, 1, 4, 6),
                listOf(0, 1, 4, 7),
                listOf(0, 1, 5, 6),
                listOf(0, 1, 5, 7),
                listOf(0, 1, 6, 7),
                listOf(0, 2, 3, 4),
                listOf(0, 2, 3, 5),
                listOf(0, 2, 3, 6),
                listOf(0, 2, 3, 7),
                listOf(0, 2, 4, 5),
                listOf(0, 2, 4, 6),
                listOf(0, 2, 4, 7),
                listOf(0, 2, 5, 6),
                listOf(0, 2, 5, 7),
                listOf(0, 2, 6, 7),
                listOf(0, 3, 4, 5),
                listOf(0, 3, 4, 6),
                listOf(0, 3, 4, 7),
                listOf(0, 3, 5, 6),
                listOf(0, 3, 5, 7),
                listOf(0, 3, 6, 7),
                listOf(0, 4, 5, 6),
                listOf(0, 4, 5, 7),
                listOf(0, 4, 6, 7),
                listOf(0, 5, 6, 7)
        );

        assertEquals(expected, actual);
    }

    @Test
    public void getCombinations() {
    }

    @Test
    public void getEnemyTeam() {
        List<Integer> enemyTeam = StartAndLink.getEnemyTeam(listOf(0, 1, 3, 4));

        assertEquals(enemyTeam, listOf(2, 5, 6, 7));
    }
}