package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.arrays.SortedArrayTransformation;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortedArrayTransformationTest {

    @Test
    public void transformation_test () throws Exception {

        SortedArrayTransformation obj = new SortedArrayTransformation();

        int[] input = new int[]{-4, -2, 2, 4};
        int[] expected = new int[]{3, 9, 15, 33};
        int[] output = obj.sortTransformedArray(input, 1,3,5);

        assertArrayEquals(expected, output);
    }


    @Test
    public void transformation_test_2 () throws Exception {

        SortedArrayTransformation obj = new SortedArrayTransformation();

        int[] input = new int[]{-4, -2, 2, 4};
        int[] expected = new int[]{-23, -5, 1, 7};
        int[] output = obj.sortTransformedArray(input, -1,3,5);

        assertArrayEquals(expected, output);
    }
}
