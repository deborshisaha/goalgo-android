package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.arrays.ChunkMerge;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChunkMergeTest {
    @Test
    public void merging_is_correct() throws Exception {

        ChunkMerge merger = new ChunkMerge();

        Integer arr1[] = {1, 5, 6, 9, 21};
        Integer arr2[] = {4, 6, 11, 14};
        Integer arr3[] = {-1, 0, 7};
        Integer arr4[] = {-4, -2, 11, 14, 18};
        Integer arr5[] = {2, 6};
        Integer arr6[] = {-5, -2, 1, 5, 7, 11, 14};
        Integer arr7[] = {-6, -1, 0, 15, 17, 22, 24};

        List<Integer> list1 = Arrays.asList(arr1);
        List<Integer> list2 = Arrays.asList(arr2);
        List<Integer> list3 = Arrays.asList(arr3);
        List<Integer> list4 = Arrays.asList(arr4);
        List<Integer> list5 = Arrays.asList(arr5);
        List<Integer> list6 = Arrays.asList(arr6);
        List<Integer> list7 = Arrays.asList(arr7);

        List<List<Integer>> chunks = new ArrayList();
        chunks.add(list1);
        chunks.add(list2);
        chunks.add(list3);
        chunks.add(list4);
        chunks.add(list5);
        chunks.add(list6);
        chunks.add(list7);

        ArrayList<Integer> merged = merger.merge(chunks);
        Integer[] desiredResult = new Integer[]{-6, -5, -4, -2, -2, -1, -1, 0, 0, 1, 1, 2, 4, 5, 5, 6, 6, 6, 7, 7, 9, 11, 11, 11, 14, 14, 14, 15, 17, 18, 21, 22, 24};

        assertArrayEquals(merged.toArray(), desiredResult);
    }
}