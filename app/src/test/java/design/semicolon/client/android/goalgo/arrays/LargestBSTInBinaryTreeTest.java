package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.TreeNode;
import com.algorithms.trees.BinarySearchTree;
import com.algorithms.trees.BinaryTree;
import com.algorithms.trees.LargestBSTInBinaryTree;

import org.junit.Test;

public class LargestBSTInBinaryTreeTest {

    @Test
    public void sucess_test() throws Exception {

        BinaryTree tree = new BinaryTree();
        BinaryTree BST = BinarySearchTree.create();

        tree.setRoot(new TreeNode(-1));
        tree.getRootNode().setRight(BST.getRootNode());
        tree.getRootNode().setLeft(new TreeNode(0));

        tree.printEachLevelInEachLine();
        LargestBSTInBinaryTree bstInBinaryTree = new LargestBSTInBinaryTree();

        System.out.print(bstInBinaryTree.find(tree));
    }
}
