package com.algorithms.arrays;

/**
 * Created by dsaha on 8/19/17.
 */

public class MaximumSumPathTwoArrays {

    public int maxSum (int[] a, int[] b) {

        int i = 0;
        int j = 0;
        int suma = 0;
        int sumb = 0;
        int maxSum = 0;
        int lastCheckpointA = 0;
        int lastCheckpointB = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                suma+= a[i++];
            } else if (a[i] > b[j]) {
                sumb+= b[j++];
            } else {
                sumb+= b[j++];
                suma+= a[i++];

                int diffa = suma - lastCheckpointA;
                int diffb = sumb - lastCheckpointB;

                if (diffa > diffb) {
                    maxSum += diffa;
                } else {
                    maxSum += diffb;
                }

                lastCheckpointA = suma;
                lastCheckpointB = sumb;

            }
        }

        while (j < b.length) {
            maxSum += b[j];
            j++;
        }

        while (i < a.length) {
            maxSum += a[i];
            i++;
        }

        return maxSum;
    }
}
