package com.algorithms.arrays;

import java.util.ArrayList;

/**
 * Created by dsaha on 8/20/17.
 */

public class CommonInThreeSortedArray {

    public int[] find (int[] a, int[] b, int[] c) {

        ArrayList<Integer> result = new ArrayList();

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < a.length && j < b.length && k < c.length) {

            if (a[i] == b[j] && b[j] == c[k]) {
                result.add(a[i]);
                i++;
                j++;
                k++;
            } else if (a[i] < b[j]) {
                i++;
            } else if (b[j] < c[k]) {
                j++;
            } else {
                k++;
            }
        }

        int[] arr = new int[result.size()];

        for(int m = 0; m < result.size(); m++) {
            arr[m] = result.get(m);
            System.out.print(arr[m]+" ");
        }

        return arr;
    }
}
