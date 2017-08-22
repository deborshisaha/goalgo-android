package com.algorithms.arrays;

/**
 * Created by dsaha on 8/21/17.
 */

public class MaximumGap {
    public int maxGap (int[] input) {

        int result = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MIN_VALUE;

        for (int i = 0; i < input.length; i++) {
            min = Math.min(min, input[i]);
            max = Math.max(max, input[i]);
        }

        return result;
    }
}
