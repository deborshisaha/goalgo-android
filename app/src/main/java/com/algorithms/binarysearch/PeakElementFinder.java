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
public class PeakElementFinder {
    public static void driver() {
        PeakElementFinder peakElementFinder = new PeakElementFinder();
        int[] arr = new int[]{1,2,3,4,5,6,5,4};
        
        System.out.println("The number:"+peakElementFinder.find(arr));
    }

    private int find(int[] input) {
        int ans = 0;
        int low = 0;
        int high = input.length -1;
        
        while (low < high) {
            
            int middle = (low+high)/2;
            
            if (input[middle] > input[middle+1] && input[middle] < input[middle-1]) {
                // a[m-1] > a[m] > a[m+1]
                high = middle - 1;
            } else if (input[middle] < input[middle+1] && input[middle] > input[middle-1]) {
                // a[m-1] < a[m] < a[m+1]
                low = middle + 1;
            } else if (input[middle] > input[middle+1] && input[middle] > input[middle-1]) {
                // a[m-1] < a[m] > a[m+1]
                ans = input[middle];
                break;
            }
        }
        
        return ans;
    }
        
}
