package com.algorithms.dp;

public class SubsetSum {

    int[] numbers;
    int sum = Integer.MIN_VALUE;

    public SubsetSum(int[] numbers, int sum) {
        this.numbers = numbers;
        this.sum = sum;
    }

    public boolean isSubsetSum() {

        boolean[][] T = new boolean[this.numbers.length+1][this.sum + 1];

        for (int row = 0; row <= this.numbers.length; row++) {
            T[row][0] = true;
        }
        
        for (int row = 1; row <= this.numbers.length; row++) {

            for (int col = 1; col <= this.sum; col++) {

                    if ((col - this.numbers[row-1]) >= 0) {
                        T[row][col] = T[row - 1][col] || T[row - 1][col - this.numbers[row-1]];
                    } else {
                        T[row][col] = T[row - 1][col] ;
                    }
            }
        }
        boolean isSubsetSum = T[this.numbers.length - 1][this.sum];
        return isSubsetSum;
    }
    
    public static void driver() {
        int[] arr  = new int[]{3,34,4,12,5,2};
        SubsetSum obj = new SubsetSum(arr, 7);
        System.out.println("isSubsetSum: " + obj.isSubsetSum());
    }
}
