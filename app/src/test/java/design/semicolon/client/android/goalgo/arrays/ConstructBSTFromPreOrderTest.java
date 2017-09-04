package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.trees.ConstructBSTFromPreOrder;

import org.junit.Test;

/**
 * Created by dsaha on 9/3/17.
 */

public class ConstructBSTFromPreOrderTest {

    @Test
    public void basic () throws Exception {
        ConstructBSTFromPreOrder object = new  ConstructBSTFromPreOrder();
        int[] arr = new int[]{10, 5, 1, 7, 40, 50};
        object.construct(arr);
    }
}
