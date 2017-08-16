package com.algorithms.dp;

public class CountNumberOfTreePreorder {

    public int count(int[] preorder) {

        int numberOfNodes = preorder.length;
        int[] T = new int[numberOfNodes + 1];
        T[0] = 1;
        T[1] = 1;

        for (int i = 2; i <= numberOfNodes; i++) {

            int sum = 0;
            for (int k = 0; k < i; k++) {
                sum += T[k] * T[i - k - 1];
            }
            
            T[i] = sum;
        }

        return T[numberOfNodes];
    }
}
