package com.algorithms.dp;

public class LongestPalindromeSubsequence {

    public static void driver() {
        LongestPalindromeSubsequence obj = new LongestPalindromeSubsequence("agbdba");
        System.out.println("LongestPalindromeSubsequence:" + obj.longestSubsequence());
    }

    private final String input;

    public LongestPalindromeSubsequence(String input) {
        this.input = input;
    }

    private int longestSubsequence() {

        if (this.input == null && this.input.length() == 0) {
            return 0;
        }

        int[][] T = getT();

        char[] sequeunce = getSequence(T, T[0][this.input.length() - 1]);

        return T[0][this.input.length() - 1];
    }

    private int[][] getT() {
        int[][] T = new int[this.input.length()][this.input.length()];

        for (int l = 0; l < this.input.length(); l++) {
            for (int i = 0; i + l < this.input.length(); i++) {
                int j = l + i;
                if (i == j) {
                    T[i][j] = 1;
                    continue;
                }
                if (this.input.charAt(i) == this.input.charAt(j)) {
                    T[i][j] = 2 + T[i + 1][j - 1];
                } else {
                    T[i][j] = Math.max(T[i][j - 1], T[i + 1][j]);
                }
            }
        }

        return T;
    }

    private char[] getSequence(int[][] T, int count) {

        char[] result = new char[count];
        int insertIdx = 0;
        int r = 0;
        int c = this.input.length() - 1;
        while (r != c) {

            if (insertIdx == count - insertIdx) {
                break;
            }

            if (T[r][c] == T[r + 1][c]) {
                r++;
            } else if (T[r][c] == T[r][c - 1]) {
                c--;
            } else if ((T[r][c] - T[r + 1][c - 1]) == 2) {

                char ch = this.input.charAt(r);
                result[insertIdx] = ch;
                result[count - 1 - insertIdx] = ch;

                r = r + 1;
                c = c - 1;
                insertIdx++;
            }

        }
        
        if (r==c) {
            result[insertIdx] = this.input.charAt(r);
        }
        
        return result;
    }
}
