package com.algorithms.randomization;

public class RandomCountrySelectionByPopulation {
    
    public int random (int[] array) {
        
        // Handle error case
        
        
        // Handling happy cases
        int resultIndex = 0;
        
        int[] sum = new int[array.length];
        
        sum[0] = array[0];
        
        // total value to be used to generate random number 
        int total = array[0];
        
        // Pre process the string
        for (int i=1;i<array.length;i++) {
            sum[i] = sum[i-1]+array[i];
            total += array[i];
        }
        
        // random varies [0,total]
        int random = (int)(Math.random()*total);
        
        // Binary search to find the point where the random number is in between
        // for e.g. for 5,15,45 a random number with 30 should result in returning 45
        int low = 0;
        int high = array.length-1;
        
        resultIndex = (low+high)/2;
        
        while (true) {
            if (sum[resultIndex] > random && (resultIndex-1 == -1 || sum[resultIndex-1] <= random)) {
                break;
            }
            
            if (sum[resultIndex] > random) {
                high = resultIndex-1;
            } else {
                low = resultIndex+1;
            }
            
            resultIndex = (low+high)/2;
        }
        
        return array[resultIndex];
    }
    
    public static void driver() {
        RandomCountrySelectionByPopulation randomCountry = new RandomCountrySelectionByPopulation();
        int[] array = new int[]{10,15,20,25,30}; 
        System.out.print(randomCountry.random(array)+" ");
        
    }
}
