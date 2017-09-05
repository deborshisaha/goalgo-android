package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.trees.SortedOrderPrintCompleteTreeArray;

import org.junit.Test;

public class SortedOrderPrintCompleteTreeArrayTest {

    @Test
    public void basic_test() throws Exception {
        int arr[] = {4, 2, 5, 1, 3};
        SortedOrderPrintCompleteTreeArray object = new SortedOrderPrintCompleteTreeArray();
        object.print(arr);
    }
}
