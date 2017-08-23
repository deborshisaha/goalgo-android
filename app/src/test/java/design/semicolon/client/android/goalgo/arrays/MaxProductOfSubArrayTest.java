package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.arrays.MaxProductSubArray;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by dsaha on 8/22/17.
 */

public class MaxProductOfSubArrayTest {

    @Test
    public void basic_test () throws Exception {
        MaxProductSubArray obj = new MaxProductSubArray();
        int[] input = new int[]{-6, -3, 8, -9, -1, -1, 3, 6, 9, 0, 3, -1};
        int ans = obj.maxProduct(input);
        System.out.print(ans);
        assertTrue(ans == 34992);
    }
}
