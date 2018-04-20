package probs.prob10_bubblesort;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BubbleSortTest {

    @Test
    public void bubbleSort() {
        assertEquals(List.of(
                -10, -9, -8, -7, -6,
                -5, -4, -3, -2, -1,
                0, 1, 2, 3, 4,
                5, 6, 7, 8, 9
                ),
                BubbleSort.bubbleSort(List.of(
                        9, 8, 6, 7, 5,
                        4, 3, 2, 1, 0,
                        -1, -2, -3, -4, -5,
                        -6, -7, -9, -8, -10
                ))
        );
    }

    @Test
    public void bubbleSort_1() {
        assertEquals(List.of(
                1, 2, 3, 4, 5
                ),
                BubbleSort.bubbleSort(List.of(
                        5, 2, 3, 4, 1
                ))
        );
    }

    @Test
    public void bubbleSort_2() {
        assertEquals(List.of(
                0, 0, 0, 1, 1
                ),
                BubbleSort.bubbleSort(List.of(
                        0, 1, 0, 1, 0
                ))
        );
    }
}