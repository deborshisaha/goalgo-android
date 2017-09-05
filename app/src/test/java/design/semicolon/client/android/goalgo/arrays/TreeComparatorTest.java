package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.trees.BinarySearchTree;
import com.algorithms.trees.TreeComparator;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeComparatorTest {

    @Test
    public void basic_test () throws Exception {
        BinarySearchTree bst = BinarySearchTree.create();
        BinarySearchTree bst2 = BinarySearchTree.create();

        TreeComparator comparator = new TreeComparator();
        assertTrue(comparator.isSame(bst, bst2));
    }

    @Test
    public void failure_test () throws Exception {
        BinarySearchTree bst = BinarySearchTree.create();
        BinarySearchTree bst2 = BinarySearchTree.create();
        bst2.insert(1000);

        TreeComparator comparator = new TreeComparator();
        assertFalse(comparator.isSame(bst, bst2));
    }
}
