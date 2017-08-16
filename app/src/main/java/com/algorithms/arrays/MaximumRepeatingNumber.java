package com.algorithms.arrays;

public class MaximumRepeatingNumber {

    public static void driver() {
        MaximumRepeatingNumber object = new MaximumRepeatingNumber();

        int[] arr = new int[]{0, 1, 2, 3, 3, 4, 4};
        System.out.print("Maximum repeating number:" + object.getMaximumRepeatingNumber(arr));
    }

    public int getMaximumRepeatingNumber(int[] a) {

        int res = -1;

        if (a == null || a.length == 0) {
            return res;
        }

        int[] T = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            T[i] = 0;
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            T[a[i]]++;

            if (max < T[a[i]]) {
                max = T[a[i]];
                res = a[i];
            }

        }

        return res;
    }
}
