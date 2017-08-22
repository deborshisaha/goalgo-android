package com.algorithms.arrays;

/**
 * Created by dsaha on 8/21/17.
 */

public class WiggleSort {

    public int[] sort(int[] input) {

        boolean flag = true;  // when true look for input[i] < input[i+1]  and swap

        for (int i = 0; i < input.length - 1 ; i++) {

            if (flag) {
                if (input[i] > input[i+1]) {
                    swap (input, i, i+1);
                }
            } else { // when false look for input[i] >= input[i+1] swap
                if (input[i] < input[i+1]) {
                    swap(input, i, i+1);
                }
            }

            flag = !flag; // toggle for the situation
        }

        return input;
    }

    private void swap (int[] input , int i , int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
