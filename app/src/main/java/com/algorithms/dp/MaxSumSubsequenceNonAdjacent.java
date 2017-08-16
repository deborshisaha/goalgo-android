package com.algorithms.dp;

public class MaxSumSubsequenceNonAdjacent {

    public static void driver() {
        MaxSumSubsequenceNonAdjacent obj = new MaxSumSubsequenceNonAdjacent();
        int[] input = new int[]{5, 5, 10, 100, 10, 5};
        System.out.println("MaxSumSubsequence sum: " + obj.maxSumsequenceNonAdjacent(input));
    }
    
    public int maxSumsequenceNonAdjacent (int[] arr) {
        
        int inclusive = arr[0];
        int exclusive = 0;
        
        for (int i = 1; i < arr.length; i++) {
            int temp = inclusive;
            inclusive = Math.max(inclusive, exclusive + arr[i]);
            exclusive = temp;
        }
       
        return Math.max(inclusive, exclusive);
    }
}
