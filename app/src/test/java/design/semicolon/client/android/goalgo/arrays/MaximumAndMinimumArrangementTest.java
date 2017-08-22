package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.arrays.MaximumAndMinimumArrangement;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MaximumAndMinimumArrangementTest {

    @Test
    public void basic_even_test () throws  Exception {
        MaximumAndMinimumArrangement obj = new MaximumAndMinimumArrangement();

        int[] input = new int[]{6,8,10,11,13,15};
        int[] output = obj.rearrange(input);

        int[] expected = new int[]{15,6,13,8,11,10};

        assertArrayEquals(expected, output);
    }

    @Test
    public void basic_odd_test () throws  Exception {
        MaximumAndMinimumArrangement obj = new MaximumAndMinimumArrangement();

        int[] input = new int[]{6,8,10,11,13,15,18};
        int[] output = obj.rearrange(input);

        int[] expected = new int[]{18,6,15,8,13,10,11};
        System.out.println();
        for (int i = 0; i < output.length; i++) {
            System.out.print(" "+output[i]);
        }
        assertArrayEquals(expected, output);
    }
}
