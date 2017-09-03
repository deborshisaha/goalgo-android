package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.trees.BinaryTree;
import com.algorithms.trees.ConnectNodesAtSameLevel;

import org.junit.Test;

/**
 * Created by dsaha on 9/2/17.
 */

public class ConnectNodesAtSameLevelTest {

    @Test
    public void basic_test () throws  Exception {

        ConnectNodesAtSameLevel obje = new ConnectNodesAtSameLevel();
        obje.connect(BinaryTree.createBalancedBT());

    }
}
