package com.algorithms.dp;

public class LongestIncreasingSubequence {

    public static void driver() {
        LongestIncreasingSubequence obj = new LongestIncreasingSubequence();
        int[] input = new int[]{3, 4, -1, 0, 6, 2, 3};
        System.out.println("LongestIncreasingSubequence length: " + obj.lengthN2(input));
    }

    public int lengthN2(int[] input) {

        int[] LIS = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            LIS[i] = 1;
        }

        int maxLength = 1;

        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < i; j++) {
                if (input[j] < input[i]) {
                    if ((LIS[j] + 1) > LIS[i]) {
                        LIS[i] = LIS[j] + 1;
                    }

                }

                if (maxLength < LIS[i]) {
                    maxLength = LIS[i];
                }
            }
        }

        for (int i = 0; i < LIS.length; i++) {
            System.out.print(LIS[i] + " ");
        }

        return maxLength;
    }
}
