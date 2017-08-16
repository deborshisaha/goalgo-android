package com.algorithms.dp;

public class LongestCommonSubsequence {

    String string1 = null;
    String string2 = null;

    public static void driver() {
        LongestCommonSubsequence obj = new LongestCommonSubsequence("abcdef", "abcdf");
        System.out.println("lengthOfCommonSequence: " + obj.lengthOfCommonSequence());
    }

    public LongestCommonSubsequence(String string1, String string2) {
        this.string1 = string1;
        this.string2 = string2;
    }

    public int lengthOfCommonSequence() {

        int[][] T = new int[this.string1.length() + 1][this.string2.length() + 1];

        for (int c = 0; c < this.string2.length() + 1; c++) {
            T[0][c] = 0;
        }

        for (int r = 0; r < this.string1.length() + 1; r++) {
            T[r][0] = 0;
        }

        int max = 0;

        for (int r = 1; r <= this.string1.length(); r++) {
            for (int c = 1; c <= this.string2.length(); c++) {
                if (this.string2.charAt(c-1) == this.string1.charAt(r-1)) {
                    T[r][c] = T[r - 1][c - 1] + 1;
                } else {
                    T[r][c] = Math.max(T[r - 1][c], T[r][c - 1]);
                }

                if (T[r][c] > max) {
                    max = T[r][c];
                }
            }
        }

        return max;
    }
}
