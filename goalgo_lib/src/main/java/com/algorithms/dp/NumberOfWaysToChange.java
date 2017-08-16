package com.algorithms.dp;

public class NumberOfWaysToChange {

    int[] coins;

    public static void driver() {
        System.out.println();
        System.out.println();

        int[] coins = new int[]{2, 4};
        NumberOfWaysToChange obj = new NumberOfWaysToChange(coins);
        int target = 5;
        int ways = obj.waysToGet(target);
        System.out.println("Number of ways: " + ways);
    }

    public NumberOfWaysToChange(int[] coins) {
        this.coins = coins;
    }

    public NumberOfWaysToChange() {
    }

    public int waysToGet(int target) {

        int[][] cost = new int[this.coins.length][target + 1];

        for (int r = 0; r < this.coins.length; r++) {
            cost[r][0] = 1;
        }

        for (int r = 0; r < this.coins.length; r++) {
            for (int c = 1; c <= target; c++) {

                if (c < this.coins[r]) {
                    if (r == 0) {
                        cost[r][c] = 0;
                    } else {
                        cost[r][c] = cost[r - 1][c];
                    }

                } else {
                    if (r == 0) {
                        cost[r][c] = cost[r][c - this.coins[r]];
                    } else {
                        cost[r][c] = cost[r - 1][c] + cost[r][c - this.coins[r]];
                    }
                }
            }
        }

        return cost[this.coins.length-1][target];
    }
}
