package design.semicolon.client.android.goalgo.arrays;


import com.algorithms.arrays.CommonInThreeSortedArray;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CommonInThreeSortedArrayTest {

    @Test
    public void basic_test () throws Exception {
        CommonInThreeSortedArray obj = new CommonInThreeSortedArray();

        int a[] = {1, 5, 10, 20, 40, 80};
        int b[] = {6, 7, 20, 80, 100};
        int c[] = {3, 4, 15, 20, 30, 70, 80, 120};

        int expected[] = {20, 80};

        int[] result = obj.find(a,b,c);

        assertArrayEquals(expected,result);
    }
}
