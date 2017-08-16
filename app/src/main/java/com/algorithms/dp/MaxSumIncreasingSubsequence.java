package com.algorithms.dp;

public class MaxSumIncreasingSubsequence {

    public static void driver() {
        MaxSumIncreasingSubsequence obj = new MaxSumIncreasingSubsequence();
        int[] input = new int[]{4, 6, 1, 3, 8, 4, 6};
        System.out.println("MaxSumIncreasingSubsequence sum: " + obj.maxSum(input));
    }

    public int maxSum(int[] arr) {

        int[] result = new int[arr.length];
        int[] sequence = new int[arr.length];
        int max = 0;
        int maxIdex = 0;

        // Initializing
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i];
        }

        for (int r = 1; r < arr.length; r++) {
            for (int l = 0; l < r; l++) {

                if (arr[l] < arr[r]) {

                    int newSum = result[l] + arr[r];
                    result[r] = Math.max(result[r], newSum);

                    if (newSum > max) {
                        max = newSum;
                        maxIdex = r;
                    }
                }

            }
        }

        return max;
    }

}
