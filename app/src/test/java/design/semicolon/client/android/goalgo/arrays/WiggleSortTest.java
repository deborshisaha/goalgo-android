package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.arrays.WiggleSort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class WiggleSortTest {

    @Test
    public void basic_test () throws Exception {
        WiggleSort obj = new WiggleSort();

        int[] input = new int[]{6, 2, 1, 6, 8, 9, 6};
        int[] output = obj.sort(input);

        int[] expected = new int[]{2,6,1,8,6,9,6};

        assertArrayEquals(expected, output);
    }
}
