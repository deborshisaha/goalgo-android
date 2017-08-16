package com.algorithms.dp;

public class MinimumJumpToReachEnd {

    public static void driver() {
        MinimumJumpToReachEnd obj = new MinimumJumpToReachEnd();
        int[] arr = new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        obj.jumps(arr);
        System.out.println();
        System.out.println();
    }

    public int jumps(int[] arr) {

        if (arr.length <= 1) {
            return 0;
        }

        // Return -1 if not possible to jump
        if (arr[0] == 0) {
            return -1;
        }

        // initialization
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;

        // Start traversing array
        for (int i = 1; i < arr.length; i++) {
            System.out.println();
            System.out.println("step 1: "+step);
            System.out.println("arr:"+arr[i]+"   i:"+i);
            // Check if we have reached the end of the array
            if (i == arr.length - 1) {
                return jump;
            }

            // updating maxReach
            maxReach = Math.max(maxReach, i + arr[i]);
            System.out.println("maxReach: "+maxReach+" arr:"+arr[i]+"   i:"+i);
            // we use a step to get to the current index
            step--;
            System.out.println("step 2: "+step);
            // If no further steps left
            if (step == 0) {
                //  we must have used a jump
                jump++;

                //Check if the current index/position  or lesser index
                // is the maximum reach point from the previous indexes
                if (i >= maxReach) {
                    return -1;
                }

                // re-initialize the steps to the amount
                // of steps to reach maxReach from position i.
                step = maxReach - i;
                System.out.println("steps left: "+step);
            }
        }

        return -1;
    }
}
