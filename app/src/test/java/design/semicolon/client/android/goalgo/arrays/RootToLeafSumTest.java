package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.trees.BinarySearchTree;
import com.algorithms.trees.RootToLeafSum;

import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by dsaha on 9/4/17.
 */

public class RootToLeafSumTest {

    @Test
    public void basic_test () throws Exception {
        RootToLeafSum object = new RootToLeafSum();

        BinarySearchTree bst1 = new BinarySearchTree();

        bst1.insert(10);
        bst1.insert(15);
        bst1.insert(5);
        bst1.insert(7);
        bst1.insert(19);
        bst1.insert(20);
        bst1.insert(-1);

        assertTrue(object.isPathPresent(bst1, 14));
        assertFalse(object.isPathPresent(bst1, 40));
    }
}
