package com.algorithms.dp;

public class MinimumNumberOfCoins {

    public static void driver() {
        int[] coins = new int[]{7,3,2,6};
        MinimumNumberOfCoins coincounter = new MinimumNumberOfCoins(coins);
        System.out.println();
        System.out.println("Minimum number of coins required:"+coincounter.coinsRequiredToForm(13));
    }
    
    private int[] coins;

    public MinimumNumberOfCoins(int[] coins) {
        this.coins = coins;
    }

    public int coinsRequiredToForm(int target) {

        int[] min = new int[target + 1];

        int[] indices = new int[target + 1];

        for (int i = 0; i <= target; i++) {
            min[i] = Integer.MAX_VALUE;
            indices[i] = -1;
        }

        min[0] = 0;

        for (int c = 0; c < this.coins.length; c++) {

            for (int i = 1; i <= target; i++) {
                if (i >= this.coins[c] && min[i - this.coins[c]] != Integer.MAX_VALUE) {
                    min[i] = Math.min(min[i], (1 + min[i - this.coins[c]]));
                }
            }
        }

        return min[target];
    }
}
