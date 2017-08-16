package com.algorithms.arrays;

public class DistanceBetweenTwoNumbers {
    
    public static void driver () {
    
        DistanceBetweenTwoNumbers object = new DistanceBetweenTwoNumbers();
        
        int[] input = new int[]{3,5,4,2,6,5,6,6,5,4,8,3};  
        System.out.print(object.getDistance(input, 3, 6));
    }
    
    public int getDistance (int[] input, int x, int y) {
        
        int result = Integer.MAX_VALUE;
        int indexOneWasFound = -1;
        int lastValueThatWasFound = Integer.MAX_VALUE;
        
        for (int i = 0; i < input.length ; i++) {
            
            // first time found
            if ((input[i] == x || input[i] == y) && lastValueThatWasFound==Integer.MAX_VALUE) {
                lastValueThatWasFound = input[i];
                indexOneWasFound = i;
            } else if (input[i] == x || input[i] == y ) { 
                // check what the last found character is
                if (lastValueThatWasFound == input[i]) {
                    // Same was last one found
                    indexOneWasFound =i;
                } else {
                    // This is a new one
                    if (result > i - indexOneWasFound ) {
                        result = i - indexOneWasFound;
                    }
                    
                    lastValueThatWasFound = input[i];
                    indexOneWasFound = i;
                }
            }
        }
        
        return result;
    }
}
