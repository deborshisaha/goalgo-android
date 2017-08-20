package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.arrays.PosAndNegAlternatingMaintainingOrder;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class PosAndNegAlternatingMaintainingOrderTest {

    @Test
    public void alternatification_is_success() throws Exception {
        int[] input = new int[] {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        int[] expected = new int[]{-5, 5, -2, 2, -8, 4, 7, 1, 8, 0};

        PosAndNegAlternatingMaintainingOrder obj = new PosAndNegAlternatingMaintainingOrder();
        int[] output = obj.alternatify(input);

        assertArrayEquals(output, expected);
    }
}
