package com.algorithms.arrays;

/**
 *
 * @author dsaha
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * 
 * Example 1: Input: [7, 1, 5, 3, 6, 4] Output: 5 
 * 
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price) Example 2: Input: [7, 6, 4, 3, 1] Output: 0
 * 
 * In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyAndSellAStock {
    
    private Integer maxProfit(int[] array) {
        
        int maxProfit = 0;

        if (array.length == 0) {
            return maxProfit;
        }

        int min = array[0];
        int maximum = array[0];
        
        for (int i=0; i< array.length; i++) {
            min = Math.min(array[i], min);
            maxProfit = Math.max(maxProfit, array[i]- min);
        }
        
        return maxProfit;
    }
    
    static public void driver() {
        BestTimeToBuyAndSellAStock bestTimeToBuyAndSellAStock = new BestTimeToBuyAndSellAStock();
        
        int[] array = new int[]{1,6,17,50};
        System.out.println("Max profit: $" +bestTimeToBuyAndSellAStock.maxProfit(array));
    }
}
