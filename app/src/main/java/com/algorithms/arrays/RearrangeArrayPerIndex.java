package com.algorithms.arrays;

import java.util.HashSet;

/**
 * Created by dsaha on 8/19/17.
 */

public class RearrangeArrayPerIndex {

    public int[] rearrange (int[] input) {

        int val = 0;

        // 1,3,0,2 - 2,0,3,1
        HashSet<Integer> numberSet = new HashSet();

        int i = input[0];

        numberSet.add(input[0]);

        while (i != 0) {
            // Save the next i
            if (numberSet.contains(input[i])) {
                return null;
            } else {
                numberSet.add(input[i]);
            }
            int next_i = input[i];

            input[i] = val;

            val = i;

            i = next_i;

        }

        input[i] = val;

        return input;
    }
}
