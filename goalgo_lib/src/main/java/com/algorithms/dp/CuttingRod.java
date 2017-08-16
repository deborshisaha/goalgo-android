/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithms.dp;

public class CuttingRod {

    public static void driver() {
        int[] price = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        CuttingRod obj = new CuttingRod();
        System.out.println("Cutting Rod pricE:"+obj.max(price));
    }

    public int max(int[] price) {

        int[] max = new int[price.length + 1];

        // initialize the array with lets say no cuts
        for (int i = 1; i <= price.length; i++) {
            max[i] = price[i - 1];
        }

        // then we start chopping
        for (int l = 1; l <= price.length; l++) {
            for (int s = 1; s < l; s++) {
                max[l] = Math.max(max[l], max[l - s] + max[s]);
            }
        }

        return max[price.length];
    }
}
