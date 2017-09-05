package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.trees.BinarySearchTree;
import com.algorithms.trees.SinkNegativeToBottom;

import org.junit.Test;

public class SinkNegativeToBottomTest {

    @Test
    public void basic_test () throws Exception {
        SinkNegativeToBottom sinker = new SinkNegativeToBottom();
        BinarySearchTree bst = new BinarySearchTree();
        sinker.sinkZero(bst.getRootNode());
    }
}
