package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.TreeNode;
import com.algorithms.trees.BinarySearchTree;
import com.algorithms.trees.BinaryTree;
import com.algorithms.trees.SumTree;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by dsaha on 9/4/17.
 */

public class SumTreeTest {

    @Test
    public void basic_test () throws Exception{

        BinaryTree bst =new BinaryTree();
        bst.setRoot(new TreeNode(26));
        bst.getRootNode().setLeft(new TreeNode(10));
        bst.getRootNode().setRight(new TreeNode(3));
        bst.getRootNode().getLeft().setLeft(new TreeNode(4));
        bst.getRootNode().getLeft().setRight(new TreeNode(6));
        bst.getRootNode().getRight().setRight(new TreeNode(3));

        SumTree sumTree = new SumTree();
        assertTrue(sumTree.isSumTree(bst));
    }
}
