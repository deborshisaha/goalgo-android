package com.algorithms.dp;

public class StockBuySellKtransactions {

    public static void driver() {
        StockBuySellKtransactions obj = new StockBuySellKtransactions();
        int[] prices = new int[]{2,5,7,1,4,3,1,3};
        System.out.println("StockBuySellKtransactions:"+obj.maxProfit(prices, 3));
    }

    public int maxProfit(int[] prices, int transactions) {

        int[] Tx = new int[prices.length];
        int[] pTx = new int[prices.length];

        for (int c = 0; c < prices.length; c++) {
            pTx[c] = 0;
        }

        for (int r = 0; r <= transactions; r++) {

            int maxDiff = -prices[0];
            for (int c = 1; c < prices.length; c++) {
                Tx[c] = Math.max(Tx[c - 1], prices[c] + maxDiff);
                maxDiff = pTx[c] - prices[c];
            }

            // My current becomes my previous
            for (int c = 1; c < prices.length; c++) {
                pTx[c] = Tx[c];
            }
        }

        return Tx[prices.length-1];
    }
}
