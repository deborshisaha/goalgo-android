package com.algorithms.dp;

public class DistinctSubsequences {

    public static void driver() {
        System.out.println();
        System.out.println();
        DistinctSubsequences obj = new DistinctSubsequences();
        System.out.println("DistinctSubsequences:" + obj.getNumberOfDistinctSubsequences("Rabbbit", "rabbit"));
    }

    public int getNumberOfDistinctSubsequences(String source, String target) {

        int m = source.length();
        int n = target.length();

        int[][] T = new int[m + 1][n + 1];

        for (int c = 0; c <= n; c++) {
            T[0][c] = 0;
        }

        for (int r = 0; r <= m; r++) {
            T[r][0] = 1;
        }

        for (int r = 1; r <= m; r++) {
            for (int c = 1; c <= n; c++) {

                if (source.toLowerCase().charAt(r - 1) == target.toLowerCase().charAt(c - 1)) {
                    T[r][c] = T[r - 1][c - 1] + T[r - 1][c];
                } else {
                    T[r][c] = T[r - 1][c];
                }
            }
        }

        print(source.toLowerCase(), T);

        return T[m][n];
    }

    private void print(String source, int[][] T) {
        int m = T.length;
        int n = T[0].length;

        for (int r = 0; r < m; r++) {

            if (r != 0) {
                System.out.print(source.charAt(r - 1) + " ");
            } else {
                System.out.print("  ");
            }
            
            for (int c = 0; c < n; c++) {
                System.out.print(T[r][c] + " ");
            }
            
            System.out.println();
        }
    }
}
