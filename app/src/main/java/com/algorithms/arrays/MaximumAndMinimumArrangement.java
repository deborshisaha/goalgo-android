package com.algorithms.arrays;

import java.util.HashSet;

/**
 * Created by dsaha on 8/21/17.
 */

public class MaximumAndMinimumArrangement {

    public int[] rearrange (int[] input) {

        int newTarget = 0;

        boolean isOdd = (input.length %2 != 0);

        int counter = 0;

        HashSet<Integer> set = new HashSet();

        for (int i = 0; i < input.length || set.size() != input.length; i++) {

            if (set.contains(i)) {
                System.out.println("skiping: "+i);
                continue;
            }

            int target = i;
            int prev = input[target];

            while (!set.contains(target)) {

                if  ( target < (input.length/2)) {
                    newTarget = 2*target+1;
                } else  {
                    newTarget = 2*(input.length - 1 - target);
                }
                System.out.print("target: "+target+" new target: "+ newTarget);
                int temp = input[newTarget];
                input[newTarget] = prev;
                prev = temp;

                if (!set.contains(target)) {
                    System.out.println(" Adding:"+target);
                    set.add(target);
                }

                target = newTarget;

            }
        }


        return input;
    }
}
