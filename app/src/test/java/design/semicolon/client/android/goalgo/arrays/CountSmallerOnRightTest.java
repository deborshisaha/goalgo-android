package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.arrays.CountSmallerOnRight;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountSmallerOnRightTest {

    @Test
    public void basic_test() throws Exception {
        CountSmallerOnRight obj = new CountSmallerOnRight();

        int[] input = new int[]{5, 2, 6, 1, 0, 3};
        int[] output = obj.getCount(input);
        int[] expected = new int[]{4,2,3,1,0,0};

        assertArrayEquals(output, expected);
    }
}
