package com.algorithms.dp;

public class PalindromePartitioning {

    public static void driver() {
        PalindromePartitioning obj = new PalindromePartitioning("jbdbk");
        System.out.println("PalindromePartitioning:" + obj.numberOfPartitions());

    }

    private String input;

    public PalindromePartitioning(String input) {
        this.input = input;
    }

    private int numberOfPartitions() {

        if (this.input == null && this.input.length() == 0) {
            return 0;
        }

        int[][] T = getT();

        return T[0][this.input.length() - 1];
    }

    private int[][] getT() {
        int[][] T = new int[this.input.length()][this.input.length()];

        for (int l = 0; l < this.input.length(); l++) {
            for (int i = 0; i + l < this.input.length(); i++) {
                int j = l + i;
                
                if (j == i) {
                    T[i][j] = 0;
                    continue;
                }
                
                if (this.input.charAt(i) == this.input.charAt(j)) {
                    T[i][j] = T[i + 1][j - 1];
                } else {
                    T[i][j] = 1 + Math.min(T[i][i] + T[i + 1][j], T[j][j] + T[i][j - 1]);
                }
            }
        }

        return T;
    }
}
