package com.algorithms.dp;

public class LongestCommonSubstring {

    String string1 = null;
    String string2 = null;

    public static void driver() {
        LongestCommonSubstring obj = new LongestCommonSubstring("abcdef", "abcdf");
        System.out.println("LongestCommonSubstring length: " + obj.length());
    }

    public LongestCommonSubstring(String string1, String string2) {

        this.string1 = string1;
        this.string2 = string2;

    }

    public int length() {

        int[][] T = new int[this.string1.length() + 1][this.string2.length() + 1];

        for (int c = 0; c <= this.string2.length(); c++) {
            T[0][c] = 0;
        }

        for (int r = 0; r <= this.string1.length(); r++) {
            T[r][0] = 0;
        }

        int maxLength = 0;

        for (int r = 1; r <= this.string1.length(); r++) {
            for (int c = 1; c <= this.string2.length(); c++) {

                if (this.string1.charAt(r-1) == this.string2.charAt(c-1)) {
                    T[r][c] = T[r - 1][c - 1] + 1;
                } else {
                    T[r][c] = 0;
                }

                if (T[r][c] > maxLength) {
                    maxLength = T[r][c];
                }
            }
        }

        return maxLength;
    }
}
