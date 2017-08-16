package com.algorithms.arrays;

import java.util.Arrays;

public class NumberOfTrianglesInUnsortedArray {

    public static void driver() {
        NumberOfTrianglesInUnsortedArray obj = new NumberOfTrianglesInUnsortedArray();
        int[] input = new int[]{10, 21, 22, 100, 101, 200, 300};
        obj.getNumberOfTriangles(input);

        System.out.print("The number of possible triangles: "+obj.getNumberOfTriangles(input));
    }

    public int getNumberOfTriangles(int[] input) {
        
        int result = 0;
        
        Arrays.sort(input);
        
        for (int i = 0; i < input.length - 2; i++) {
            
            for (int j = i+1; j < input.length - 1; j++) {
                
                int k = j+1;
                
                while (k < input.length && input[i] + input[j] > input[k]) {
                    result++;
                    ++k;
                }
            }
        }
        
        return result;
    }
}
