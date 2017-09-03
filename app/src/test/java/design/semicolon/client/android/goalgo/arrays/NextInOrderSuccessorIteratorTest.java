package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.trees.BinarySearchTree;
import com.algorithms.trees.BinaryTree;
import com.algorithms.trees.NextInOrderSuccessorIterator;

import org.junit.Test;

/**
 * Created by dsaha on 9/3/17.
 */

public class NextInOrderSuccessorIteratorTest {

    @Test
    public void basic_test() throws Exception {
        NextInOrderSuccessorIterator iterator = new NextInOrderSuccessorIterator();
        iterator.setBinaryTree(BinarySearchTree.create());

        while (iterator.hasNext()) {
            System.out.print(iterator.next().data + " ");
        }
    }
}
