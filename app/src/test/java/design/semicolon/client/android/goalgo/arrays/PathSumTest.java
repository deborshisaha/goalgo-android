package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.TreeNode;
import com.algorithms.trees.BinaryTree;
import com.algorithms.trees.PathSum;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * Created by dsaha on 9/4/17.
 */

public class PathSumTest {

    @Test
    public void multi_path_test () throws Exception {
        BinaryTree tree = new BinaryTree();
        tree.setRoot(new TreeNode(5));
        tree.getRootNode().setRight(new TreeNode(7));
        tree.getRootNode().setLeft(new TreeNode(6));
        tree.getRootNode().getLeft().setLeft(new TreeNode(3));
        tree.getRootNode().getRight().setRight(new TreeNode(2));

        PathSum pathSum = new PathSum();
        ArrayList<ArrayList<TreeNode<Integer>>> result = pathSum.paths(tree, 14);
        printLists(result);

        assertTrue (result.size() > 1);
    }

    private void printLists (ArrayList<ArrayList<TreeNode<Integer>>> result) {
        for (ArrayList<TreeNode<Integer>> list : result) {
            for (TreeNode<Integer> node : list) {
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void single_path_test () throws Exception {
        BinaryTree tree = new BinaryTree();
        tree.setRoot(new TreeNode(5));
        tree.getRootNode().setRight(new TreeNode(7));
        tree.getRootNode().setLeft(new TreeNode(6));
        tree.getRootNode().getLeft().setLeft(new TreeNode(3));
        tree.getRootNode().getRight().setRight(new TreeNode(1));

        PathSum pathSum = new PathSum();
        ArrayList<ArrayList<TreeNode<Integer>>> result = pathSum.paths(tree, 14);
        assertTrue (result.size() == 1);
        printLists(result);
    }

    @Test
    public void no_path_test () throws Exception {
        BinaryTree tree = new BinaryTree();
        tree.setRoot(new TreeNode(5));
        tree.getRootNode().setRight(new TreeNode(7));
        tree.getRootNode().setLeft(new TreeNode(6));
        tree.getRootNode().getLeft().setLeft(new TreeNode(2));
        tree.getRootNode().getRight().setRight(new TreeNode(1));

        PathSum pathSum = new PathSum();
        ArrayList<ArrayList<TreeNode<Integer>>> result = pathSum.paths(tree, 14);
        assertTrue (result.size() == 0);
        printLists(result);
    }
}
