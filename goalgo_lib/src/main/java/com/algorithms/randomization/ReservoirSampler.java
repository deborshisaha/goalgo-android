package com.algorithms.randomization;

public class ReservoirSampler {
    
    public int[] samples(int size, int[] array) {
        
        int[] result = new int[size];
        
        if (array.length < size) {
            return null;
        }
        
        int i = 0;
        
        // copy all items
        for (; i < size; i++) {
            result[i] = array[i];
        }
        
        for (;i<array.length;i++) {
            int random = (int)(Math.random()*i);
            if (random < size) {
                result[random] = array[i];
            }
        }

        return result;
    }
    
    public static void driver() {
        int[] array = new int[]{5,2,3,1,0,9,6,7,4,8};
        ReservoirSampler sampler = new ReservoirSampler();
        int[] reservoir = sampler.samples(5, array);
        
        for (Integer i: reservoir) {
            System.out.println(i+" ");
        }
        
    }
}
