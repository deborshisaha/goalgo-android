package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.arrays.FourSum;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class FourSumTest {

    @Test
    public void basic_test () throws  Exception {

        FourSum obj = new FourSum();

        int[] input = new int[] {10, 20, 30, 40, 1, 2};
        int target = 91;

        int[][] expected = new int[][]{{20, 1, 30, 40}};

        int[][] output = obj.find(input, target);

        assertTrue(expected.length == output.length);

        for (int i = expected.length ; i < expected.length; i++) {
            assertArrayEquals(expected[i],output[i]);
        }
    }
}
