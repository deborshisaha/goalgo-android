package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.trees.BinaryTree;
import com.algorithms.trees.CousinNodes;

import org.junit.Test;

import static junit.framework.Assert.*;

public class CousinNodesTest {

    @Test
    public void success_test() throws Exception {

        CousinNodes cousinNodes = new CousinNodes();

        BinaryTree binaryTree = BinaryTree.createNotBST();

        assertTrue( cousinNodes.areCousins(binaryTree, 18, 19));
    }

    @Test
    public void basic_test() throws Exception {

        CousinNodes cousinNodes = new CousinNodes();

        BinaryTree binaryTree = BinaryTree.createNotBST();

        assertFalse(cousinNodes.areCousins(binaryTree, 18, 15));
    }
}
