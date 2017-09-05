package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.TreeNode;
import com.algorithms.trees.BinaryTree;
import com.algorithms.trees.FlattenLinkListToBinaryTreePreorder;

import org.junit.Test;

public class FlattenLinkListToBinaryTreePreorderTest {

    @Test
    public void flattening_test () throws Exception{
        FlattenLinkListToBinaryTreePreorder obj = new FlattenLinkListToBinaryTreePreorder();
        BinaryTree bt = new BinaryTree();

        bt.setRoot(new TreeNode(1));
        bt.getRootNode().setRight(new TreeNode(5));
        bt.getRootNode().getRight().setRight(new TreeNode(6));

        bt.getRootNode().setLeft(new TreeNode(2));
        bt.getRootNode().getLeft().setLeft(new TreeNode(3));
        bt.getRootNode().getLeft().setRight(new TreeNode(4));

        TreeNode node = obj.flatten(bt);

        while (node != null) {
            System.out.print(node.data+" ");
            node = node.getRight();
        }
    }
}
