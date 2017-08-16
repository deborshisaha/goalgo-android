package com.algorithms.arrays;

public class MultiplyAllFieldsExceptOwnPosition {
    
    public static void driver () {
        MultiplyAllFieldsExceptOwnPosition obj = new MultiplyAllFieldsExceptOwnPosition();
        int[] input = new int[]{2,4,5,6}; 
        int[] result = obj.getResultArray (input); 
        
        for (int i=0; i < result.length ; i++) {
            System.out.print(result[i]+" ");
        }
    }

    private int[] getResultArray(int[] input) {
        
        if (input == null) {
            return null;
        }
        
        int[] result = new int[input.length];
        
        if (input.length == 0) {
            return result;
        }
        
        for (int i = 0; i < input.length ; i++) {
            result[i] = 1;
        }
        
        int product = 1;
        
        for ( int i = 1 ; i < input.length ; i++ ) {
            product *= input[i-1]; 
            result[i] = product;
        }
        
        product = input[input.length - 1];
        
        for ( int j = input.length - 2 ; j >= 0 ; j-- ) {
            result[j] *= product;
            product *= input[j];
        }
        
        
        return result;
    }
}
