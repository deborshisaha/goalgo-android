package com.algorithms.randomization;

public class Rand7UsingRand5 {
    
    public int rand() {
        
        int random = ((rand5()-1)*5) + rand5();

        while(random>20) {
            random = ((rand5()-1)*5) + rand5();
        }

        return (random%7)+1;
    }
    
    private int rand5() {
        return (int)Math.ceil(Math.random()*5);
    }
    
    public static void driver() {
        Rand7UsingRand5 r7r5 = new Rand7UsingRand5();
        System.out.println("Random generated:"+r7r5.rand());
    }
}
