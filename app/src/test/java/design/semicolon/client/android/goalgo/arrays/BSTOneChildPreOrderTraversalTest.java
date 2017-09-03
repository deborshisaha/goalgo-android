package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.trees.BSTOneChildPreOrderTraversal;

import org.junit.Test;

import static junit.framework.Assert.*;

public class BSTOneChildPreOrderTraversalTest {

    @Test
    public void basic_failure_test () throws Exception {
        int[] array = new int[]{20,5,9,6,11,10,12};
        BSTOneChildPreOrderTraversal obj = new BSTOneChildPreOrderTraversal();

        assertFalse(obj.hasOneChild(array));
    }

    @Test
    public void basic_success_test () throws Exception {
        int[] array = new int[]{20, 10, 11, 13, 12};
        BSTOneChildPreOrderTraversal obj = new BSTOneChildPreOrderTraversal();

        assertTrue(obj.hasOneChild(array));
    }
}
