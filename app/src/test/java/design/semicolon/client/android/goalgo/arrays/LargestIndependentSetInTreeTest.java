package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.TreeNode;
import com.algorithms.trees.BinaryTree;
import com.algorithms.trees.LargestIndependentSetInTree;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class LargestIndependentSetInTreeTest {

    @Test
    public void basic_test () throws  Exception {
        LargestIndependentSetInTree LISFinder = new LargestIndependentSetInTree ();

        BinaryTree t = new BinaryTree();
        t.setRoot(new TreeNode(10));

        t.getRootNode().setRight(new LargestIndependentSetInTree.LISNode(30));
        t.getRootNode().getRight().setRight(new LargestIndependentSetInTree.LISNode(60));


        t.getRootNode().setLeft(new LargestIndependentSetInTree.LISNode(20));
        t.getRootNode().getLeft().setLeft(new LargestIndependentSetInTree.LISNode(40));
        t.getRootNode().getLeft().setRight(new LargestIndependentSetInTree.LISNode(50));

        t.getRootNode().getLeft().getRight().setRight(new LargestIndependentSetInTree.LISNode(80));
        t.getRootNode().getLeft().getRight().setLeft(new LargestIndependentSetInTree.LISNode(70));


        assertTrue(LISFinder.find(t) == 5);
    }
}
