package com;

public class DivisionWithoutSlash {
    
    public float divide (int numerator, int denominator) {
        
        float result = 0;
        
        // Error checking
        if (denominator <= 0) {
            // Exception handling
            return Integer.MAX_VALUE;
        }
        
        int quo = 0;
        
        while (numerator >= denominator) {
            numerator = numerator - denominator;
            quo++;
        }
        
        
        // remainder is numberator
        
        return result;
    }
    
    public boolean isPalindrome(String string) {
        
        if (string == null || string.length() == 0) {
            return true;
        }
        
        if (string.length() == 1) {
            return true;
        }
        
        int i=0;
        int j = 0;
                              
        for ( i=0, j = string.length()-1; i < j ; i++, j--) {
            if (string.charAt(i) != string.charAt(j)) {
                break;
            } 
        }
        
        if (i==j || j < i) {
            return true;
        }
        
        return false;
    }
}
