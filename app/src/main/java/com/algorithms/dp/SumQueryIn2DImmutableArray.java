package com.algorithms.dp;

public class SumQueryIn2DImmutableArray {

    public static void driver() {
        int[][] input = {{3, 0, 1, 4, 2},
        {5, 6, 3, 2, 1},
        {1, 2, 0, 1, 5},
        {4, 1, 0, 1, 7},
        {1, 0, 3, 0, 5}};

        SumQueryIn2DImmutableArray sumQueryFinder = new SumQueryIn2DImmutableArray(input);
        int sum = sumQueryFinder.sumAt(1, 1);
        System.out.println("Sum: " + sum);
    }

    private int[][] input;

    public SumQueryIn2DImmutableArray(int[][] input) {
        this.input = input;
    }

    public int sumAt(int tr, int tc) {

        int nR = this.input.length;
        int nC = this.input[0].length;

        int[][] T = new int[tr + 2][tc + 2];

        for (int r = 0; r <= tr+1; r++) {
            T[r][0] = 0;
        }

        for (int c = 0; c <= tc+1; c++) {
            T[0][c] = 0;
        }

        for (int r = 1; r <= tr+1; r++) {
            for (int c = 1; c <= tc+1; c++) {
                T[r][c] = this.input[r-1][c-1] + T[r - 1][c] + T[r][c - 1] - T[r - 1][c - 1];
            }
        }

        // Query into the matrix and pick x,y
        return T[tr+1][tc+1];
    }
}
