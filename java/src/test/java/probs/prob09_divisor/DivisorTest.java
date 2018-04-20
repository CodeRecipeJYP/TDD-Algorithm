package probs.prob09_divisor;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static probs.utils.ListUtils.listOf;

public class DivisorTest {
    @Test
    public void getDivisors_1() {
        int number = 1;
        List<Integer> expected = listOf(
                1
        );

        assertEquals(expected,
                Divisor.getDivisors(number));
    }

    @Test
    public void getDivisors_2() {
        int number = 2;
        List<Integer> expected = listOf(
                1, 2
        );

        assertEquals(expected,
                Divisor.getDivisors(number));
    }

    @Test
    public void getDivisors_3() {
        int number = 3;
        List<Integer> expected = listOf(
                1, 3
        );

        assertEquals(expected,
                Divisor.getDivisors(number));
    }

    @Test
    public void getDivisors_4() {
        int number = 15;
        List<Integer> expected = listOf(
                1, 3, 5, 15
        );

        assertEquals(expected,
                Divisor.getDivisors(number));
    }
}