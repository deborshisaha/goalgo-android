package com.algorithms.dp;

public class DiceWays {

    public static void driver() {
        DiceWays obj = new DiceWays();
        System.out.print("ways: " + obj.numberOfWays(3, 6, 17));
    }

    public int numberOfWays(int dices, int sides, int target) {

        int[][] T = new int[dices + 1][target + 1];

        for (int c = 0; c <= target; c++) {
            T[0][c] = 0;
        }

        for (int r = 0; r <= dices; r++) {
            T[r][0] = 0;
        }

        for (int c = 1; c <= target; c++) {

            if (c <= sides && c <= target) {
                T[1][c] = 1;
            } else {
                T[1][c] = 0;
            }

        }

        for (int r = 0; r <= 1; r++) {
            for (int c = 0; c <= target; c++) {
                System.out.print(T[r][c] + " ");
            }
            System.out.println();
        }
        
        
        for (int r = 2; r <= dices; r++) {
            System.out.print(T[r][0] + " ");
            for (int k = 1; k <= target; k++) {

                for (int c = 1; c <= sides && c < k; c++) {
                    T[r][k] += T[r - 1][k - c];

                }
                System.out.print(T[r][k] + " ");
            }
            System.out.println();
        }

        return T[dices][target];
    }
}
