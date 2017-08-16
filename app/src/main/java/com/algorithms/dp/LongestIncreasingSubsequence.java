package com.algorithms.dp;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

    public static void driver() {
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
        int[] input = new int[]{3, 1, 5, 2, 6, 4, 9};
        obj.subsequence(input);
    }

    public void subsequence(int[] X) {
        int parent[] = new int[X.length]; //Tracking the predecessors/parents of elements of each subsequence.
        int increasingSub[] = new int[X.length + 1]; //Tracking ends of each increasing subsequence.
        int length = 0; //Length of longest subsequence.
        
        for (int i = 0; i < increasingSub.length; i++) {
            increasingSub[i] = -1;
        }
        
        for (int i = 0; i < X.length; i++) {
            //Binary search
            int low = 1;
            int high = length;
            System.out.println("Investigating index "+i+":"+X[i]);
            while (low <= high) {
                System.out.println("Doing binary search...");
                int mid = (int) Math.ceil((low + high) / 2);
                System.out.println(" increasingSub["+mid+"]:"+ increasingSub[mid]+" X["+increasingSub[mid]+"]:"+X[increasingSub[mid]]);
                if (X[increasingSub[mid]] < X[i]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            
            int pos = low;
            
            parent[i] = increasingSub[pos - 1];
            print("increasingSub before", increasingSub);
            increasingSub[pos] = i;
            print("increasingSub after", increasingSub);
            if (pos > length) {
                length = pos;
            }
        }
        
        //Generate LIS by traversing parent array
        int LIS[] = new int[length];
        int k = increasingSub[length];
        for (int j = length - 1; j >= 0; j--) {
            LIS[j] = X[k];
            k = parent[k];
        }

        for (int i = 0; i < length; i++) {
            System.out.println(LIS[i]);
        }
    }

    private void print (String string, int[] arr) {
        System.out.println();
        System.out.println(string);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
