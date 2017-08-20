package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.arrays.MaximumSumPathTwoArrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by dsaha on 8/20/17.
 */

public class MaximumSumPathTwoArraysTest {

    @Test
    public void basic() throws Exception {
        MaximumSumPathTwoArrays obj = new MaximumSumPathTwoArrays();
        int[] a = new int[]{2, 3, 7, 10, 12, 15, 30, 34};//{2, 3, 7, 10, 12};
        int[] b = new int[]{1, 5, 7, 8, 10, 15, 16, 19};//{1, 5, 7, 8};
        int result = obj.maxSum(a,b);
        System.out.println("Sum:"+obj.maxSum(a,b));
        assertTrue(result == 122);
    }

    @Test
    public void basic_test1() throws Exception {
        MaximumSumPathTwoArrays obj = new MaximumSumPathTwoArrays();
        int[] a = new int[]{10, 12};
        int[] b = new int[]{5, 7, 9};

        int result = obj.maxSum(a,b);
        System.out.println("Sum:"+obj.maxSum(a,b));
        assertTrue(result == 22);
    }

    @Test
    public void basic_test2() throws Exception {
        MaximumSumPathTwoArrays obj = new MaximumSumPathTwoArrays();
        int[] a = new int[]{2, 3, 7, 10, 12};
        int[] b = new int[]{1, 5, 7, 8};

        int result = obj.maxSum(a,b);
        System.out.println("Sum:"+obj.maxSum(a,b));
        assertTrue(result == 35);
    }
}
