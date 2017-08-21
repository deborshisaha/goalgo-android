package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.arrays.AdditiveNumbers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dsaha on 8/20/17.
 */

public class AdditiveNumbersTest {
    @Test
    public void basic_test () throws Exception {
        AdditiveNumbers obj = new AdditiveNumbers();
        assertTrue(obj.isAdditiveNumber("29112031"));
    }

    @Test
    public void basic_test_2 () throws Exception {
        AdditiveNumbers obj = new AdditiveNumbers();
        assertFalse(obj.isAdditiveNumber("191020"));
    }
}
