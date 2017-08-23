package com.algorithms.arrays;

import java.util.ArrayList;

/**
 * Created by dsaha on 8/22/17.
 */

public class MaxProductSubArray {

    public int maxProduct2 (int[] input) {

        int min = 1;
        int max = 1;
        int maxSoFar = 1;

        for (int i = 0; i < input.length; i++) {

            if (input[i] > 0) {
                // This will always contribute towards increasing the magnitude
                max = max * input[i];
                maxSoFar = Math.max(maxSoFar, max);
                min = Math.min( min * input[i],1);

            } else if (input[i] < 0) {
                // This will mostly contribut towards increasing the magnitude in the negative values
                int temp = max * input[i]; // This will make the min either extremely negative or if it was negative it may push the value to the positive side with greater magnitude than max

                maxSoFar = Math.max(max, min * input[i]);

                max = Math.max(1, min*input[i]);

                min = temp;
            } else {
                min = 1;
                max = 1;
                maxSoFar = Math.max(maxSoFar, 0);
            }

        }

        return maxSoFar;
    }

    public int maxProduct(int[] nums) {
        int min = 1;
        int max = 1;
        int maxSoFar = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                max = max * nums[i];
                min = Math.min(min * nums[i], 1);
                maxSoFar = Math.max(maxSoFar, max);
            } else if (nums[i] == 0) {
                min = 1;
                max = 1;
                maxSoFar = Math.max(maxSoFar, 0);
            } else {
                int t = max * nums[i];
                maxSoFar = Math.max(maxSoFar, min * nums[i]);
                max = Math.max(1, min*nums[i]);
                min = t;
            }
        }
        return maxSoFar;
    }
}
