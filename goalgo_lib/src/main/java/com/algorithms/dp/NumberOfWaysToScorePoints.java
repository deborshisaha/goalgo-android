package com.algorithms.dp;

public class NumberOfWaysToScorePoints {

    public static void driver () {
        int[] steps = new int[]{1,2,3};
        NumberOfWaysToScorePoints obj = new NumberOfWaysToScorePoints();
        System.out.println(":NumberOfWaysToScorePoints"+obj.numberOfWays(steps, 4));
    }
    
    public int numberOfWays(int[] steps, int target) {

        int[] T = new int[target + 1];

        T[0] = 1;

        for (int j = 0; j < steps.length; j++) {
            for (int i = 1; i <= target; i++) {
                if (steps[j] <= i) {
                    T[i] += T[i - steps[j]];
                }
            }
        }

        return T[target];
    }
}
