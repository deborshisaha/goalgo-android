package com.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ChunkMerge {

    public static void driver() {
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

        if (merged != null) {
            merged.forEach((in) -> {
                System.out.print(in + " ");
            });
        }

    }

    public ArrayList<Integer> merge(List<List<Integer>> chunks) {

        ArrayList<Integer> result = new ArrayList();

        PriorityQueue<TopTracker> q = new PriorityQueue(new TopTrackerComparator());

        int i = 0;

        for (List<Integer> chunk : chunks) {
            TopTracker tt = new TopTracker(chunk.get(0), i, 0);
            q.add(tt);
            i++;
        }

        while (!q.isEmpty()) {

            TopTracker tt = q.poll();
            Integer value = tt.val;
            result.add(value);

            // Update Top tracker
            tt.index++;
            
            List<Integer> chunk = chunks.get(tt.chunkNumber);
            
            if (chunk.size() > tt.index) {
                tt.val = chunks.get(tt.chunkNumber).get(tt.index);
                q.add(tt);
            }

        }

        return result;
    }
}

class TopTracker {

    int val;

    int chunkNumber;

    int index;

    public TopTracker(int v, int cn, int i) {
        this.val = v;
        this.chunkNumber = cn;
        this.index = i;
    }

}

class TopTrackerComparator implements Comparator<TopTracker> {

    @Override
    public int compare(TopTracker first, TopTracker second) {
        return first.val - second.val;
    }

}
