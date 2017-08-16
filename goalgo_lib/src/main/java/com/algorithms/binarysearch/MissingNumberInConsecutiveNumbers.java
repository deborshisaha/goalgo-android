/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithms.binarysearch;

/**
 *
 * @author dsaha
 */
public class MissingNumberInConsecutiveNumbers {
    
    public static void driver() {
        MissingNumberInConsecutiveNumbers cbs = new MissingNumberInConsecutiveNumbers();
        int[] arr = new int[]{1,2,3,4,5,6,8,9,10,11,12};
        
        System.out.println("The number:"+cbs.find(arr));
    }
        
    public int find(int[] input) {
        
        int ans = 0;
        int low = 0;
        int high = input.length -1;
        
        while (low < high) {
            int middle = (low+high)/2;
            int computed = input[0]+middle;
            int actual = input[middle];
            if (computed == actual) {
                low = middle+1;
            } else if (computed > input[middle-1] && computed < actual) {
                ans = computed;
                break;
            } else {
                high = middle - 1;
            }
        }
        
        return ans;
    }
}
