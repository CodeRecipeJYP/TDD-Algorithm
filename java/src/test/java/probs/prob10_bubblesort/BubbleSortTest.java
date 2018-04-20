package probs.prob10_bubblesort;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static probs.utils.ListUtils.listOf;

public class BubbleSortTest {

    @Test
    public void bubbleSort() {
        assertEquals(listOf(
                -10, -9, -8, -7, -6,
                -5, -4, -3, -2, -1,
                0, 1, 2, 3, 4,
                5, 6, 7, 8, 9
                ),
                BubbleSort.bubbleSort(listOf(
                        9, 8, 6, 7, 5,
                        4, 3, 2, 1, 0,
                        -1, -2, -3, -4, -5,
                        -6, -7, -9, -8, -10
                ))
        );
    }

    @Test
    public void bubbleSort_1() {
        assertEquals(listOf(
                1, 2, 3, 4, 5
                ),
                BubbleSort.bubbleSort(listOf(
                        5, 2, 3, 4, 1
                ))
        );
    }

    @Test
    public void bubbleSort_2() {
        assertEquals(listOf(
                0, 0, 0, 1, 1
                ),
                BubbleSort.bubbleSort(listOf(
                        0, 1, 0, 1, 0
                ))
        );
    }
}