package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.TreeNode;
import com.algorithms.trees.BinaryTree;
import com.algorithms.trees.ArbitaryTreeToChildSumTree;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by dsaha on 9/2/17.
 */

public class ArbitraryTreeToChildSumTreeTest {
    @Test
    public void basic_test () throws Exception {
        ArbitaryTreeToChildSumTree obj = new ArbitaryTreeToChildSumTree();
        BinaryTree bt = BinaryTree.createBalancedBT();
        bt.printEachLevelInEachLine();
        obj.childrenSumTree(bt.getRootNode());
        bt.printEachLevelInEachLine();
        TreeNode<Integer> treeNode = bt.getRootNode();

        assertTrue(treeNode.data == 54);
    }

}
