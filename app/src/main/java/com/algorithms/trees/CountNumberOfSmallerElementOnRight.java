package com.algorithms.trees;

/**
 * Created by dsaha on 9/3/17.
 */

public class CountNumberOfSmallerElementOnRight {

    public int[] count (int[] array) {

        if (array == null) {
            return null;
        }

        int[] results = new int[array.length];

        for (int i = 0; i < results.length ; i++ ) {
            results[i] = 0;
        }

        for (int i = 0; i < results.length ; i++) {

            int count = 0;

            for (int j = i+1; j < results.length ; j++ )
            {
                if (array[i] > array[j]) {
                    count++;
                }
            }

            results[i] = count;
        }

        return results;
    }
}
