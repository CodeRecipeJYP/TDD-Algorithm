package probs.prob11_retrievetree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RetrieveTreeTest {

    @Test
    public void estimatePreOrder() {
        List<Integer> preOrders = RetrieveTree.estimatePreOrder(
                List.of(
                        9, 12, 14, 17, 19,
                        23, 50, 54, 67, 72,
                        76
                ),
                List.of(
                        12, 14, 9, 19, 23,
                        17, 67, 72, 54, 76,
                        50
                )
        );

        List<Integer> expectedOrders = List.of(
                50, 17, 9, 14, 12,
                23, 19, 76, 54, 72,
                67
        );

        assertEquals(expectedOrders, preOrders);
    }

    @Test
    public void estimateTree() {
    }
}