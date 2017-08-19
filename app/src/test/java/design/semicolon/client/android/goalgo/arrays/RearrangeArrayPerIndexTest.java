package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.arrays.RearrangeArrayPerIndex;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by dsaha on 8/19/17.
 */

public class RearrangeArrayPerIndexTest {

    @Test
    public void basicTest() throws Exception {
        int[] input = new int[]{1,3,0,2};
        int[] output = new int[]{2,0,3,1};

        RearrangeArrayPerIndex obj = new RearrangeArrayPerIndex();
        input = obj.rearrange(input);

        assertArrayEquals(input, output);
    }

    @Test
    public void duplicateNumberTest() throws Exception {
        int[] input = new int[]{1,3,3,2};
        int[] output = new int[]{2,0,3,1};

        RearrangeArrayPerIndex obj = new RearrangeArrayPerIndex();
        input = obj.rearrange(input);

        assertTrue(input == null);
    }
}
