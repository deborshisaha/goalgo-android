package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.trees.IdenticalTrees;

import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by dsaha on 9/3/17.
 */

public class IdenticalTreesTest {

    @Test
    public void succuess_test () throws  Exception {

        int[] arr1 = new int[]{8, 3, 6, 1, 4, 7, 10, 14, 13};

        int[] arr2 = new int[]{8, 10, 14, 3, 6, 4, 1, 7, 13};

        IdenticalTrees identicalTrees = new IdenticalTrees();

        assertTrue(identicalTrees.areIdentical(arr1,arr2));
    }

    @Test
    public void failure_test () throws  Exception {

        int[] arr1 = new int[]{8, 10, 14, 3, 6, 4, 1, 7, 13};

        int[] arr2 = new int[]{8, 3, 4, 1, 6, 7, 10, 14, 13};

        IdenticalTrees identicalTrees = new IdenticalTrees();

        assertFalse(identicalTrees.areIdentical(arr1,arr2));
    }
}
