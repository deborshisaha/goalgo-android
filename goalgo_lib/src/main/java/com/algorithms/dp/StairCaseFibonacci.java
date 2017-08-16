package com.algorithms.dp;

public class StairCaseFibonacci {

    int[] result = null;
    int target;
    
    public StairCaseFibonacci(int target) {
        this.result = new int[target+1];
        this.target = target;
        
        for (int i=0; i< target; i++) {
            result[i] = 0;
        }
        
        result[2] = 1;
        result[3] = 1;
    }

    // function for Debugging purposes
    public int numberOfWays() {
        int finalValue = f(this.target);
        return finalValue;
    }

    private int f(int target) {
        
        if (target >= 0 && target < this.result.length ) {
            
            // inside the range
            if ( result[target] == 0){
                // if zero, compute
                result[target] = f(target - 2) + f(target - 3);
            } 
        } else {
            // not positive then ignore and put 0
            return 0;
        }
        //Integer.min(target, target)
        // return stored value
        return result[target];
    }

    public static void driver() {
        StairCaseFibonacci obj = new StairCaseFibonacci(10);
        System.out.println("numberOfWays: " + obj.numberOfWays());
    }
}
