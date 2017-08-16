/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithms.arrays;

/**
 *
 * @author dsaha
 */
public class SelfCrossing {
    
    public boolean doesSelfCross(int[] x) {
        
        if (x.length <= 3) {return false;}
       
        int i= 2;
        
        // while it takes all the outward spiral
        while (i<x.length && x[i-2]>x[i]){
            i++;
        }
        
        // detect when it takes in ward spiral
        if (i==x.length) {return false;}
        
       /*      2
        *   +-----+
        *   |     |  1
        *   +     +
        * 3 |
        *   +     +
        *   |     |  1
        *   +-----+
        *      2
        */
        if ((i >= 4 && x[i] + x[i - 4] >= x[i - 2]) || 
            (i == 3 && x[i] == x[i - 2])) {
            x[i - 1] -= x[i - 3];
        }
        
        i++;
        
        // inside spiral
        while (i<x.length && x[i] < x[i-2]) {
            i++;
        }

        return i!=x.length;        
    }
    
    static public void driver() {
        
        int[] array = new int[]{1,3, 4, 2, 3, 1, 2};

        SelfCrossing sc = new SelfCrossing();
        System.out.println(sc.doesSelfCross(array));
    }
}
