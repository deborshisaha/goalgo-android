package com.algorithms.dp;

public class CountNumberOfBinaryWithoutConsecutive1s {

    public static void driver() {
        CountNumberOfBinaryWithoutConsecutive1s obj = new CountNumberOfBinaryWithoutConsecutive1s();
        System.out.println("Count:"+obj.count(5));
    }
    
    public int count(int N) {
        
        int a = 1;
        int b = 1;
        
        for (int i = 1; i <= N; i++) {
            int temp = a;
            a = a+b;
            b = temp;
        }
        
        return a;
    }
}
