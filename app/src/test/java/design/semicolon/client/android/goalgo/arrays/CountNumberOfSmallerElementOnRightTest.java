package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.trees.CountNumberOfSmallerElementOnRight;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dsaha on 9/3/17.
 */

public class CountNumberOfSmallerElementOnRightTest {

    @Test
    public void basic_test () throws Exception {
        CountNumberOfSmallerElementOnRight obj = new CountNumberOfSmallerElementOnRight();
        int[] input = new int[]{12, 1, 2, 3, 0, 11, 4};
        int[] expected = new int[]{6, 1, 1, 1, 0, 1, 0};
        int[] output = obj.count(input);

        assertArrayEquals(expected, output);
    }
}
