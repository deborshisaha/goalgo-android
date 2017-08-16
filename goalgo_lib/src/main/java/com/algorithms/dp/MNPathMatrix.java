package com.algorithms.dp;

public class MNPathMatrix {
    public static void driver() {
        MNPathMatrix pathFinder = new MNPathMatrix();
        System.out.println("MNPathMatrix:"+pathFinder.numberOfWays(4,4));
    }

    private int numberOfWays(int m, int n) {
        int[][] T = new int[m][n];
        
        for (int r = 0; r < m; r++) {
            T[r][0] = 1;
        }
        
        for (int c = 0; c < n; c++) {
            T[0][c] = 1;
        }
        
        for (int r=1; r < m; r++ ) {
            for (int c=1; c < n; c++ ) {
                T[r][c] = T[r-1][c]+T[r][c-1]; 
            }
        }
        
        return T[m-1][n-1];
    }
}
