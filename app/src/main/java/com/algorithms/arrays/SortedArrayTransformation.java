package com.algorithms.arrays;

/**
 * Created by dsaha on 8/20/17.
 */

public class SortedArrayTransformation {

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int start = 0;
        int end = nums.length - 1;
        int[] result = new int[nums.length];
        int index = (a >= 0 ? nums.length - 1 : 0);
        while (start <= end) {
            int x = apply(nums[start], a, b, c);
            int y = apply(nums[end], a, b, c);
            boolean condition = (a >= 0 ? x >= y : x <= y);
            if (condition) {
                result[index] = x;
                start++;
            } else {
                result[index] = y;
                end--;
            }
            index = index + (a >= 0 ? -1 : 1);
        }
        return result;
    }

    private int apply(int x, int a, int b, int c) {
        return a*x*x + b * x + c;
    }

}
