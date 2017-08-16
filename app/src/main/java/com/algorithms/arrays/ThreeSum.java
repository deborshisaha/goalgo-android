/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author dsaha
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 */
public class ThreeSum {
    
    public List<List<Integer>> getListOfListOfIntegers(int targetSum, int[] arrayOfIntegers) {
        
        List<List<Integer>> threeSumSets = new ArrayList<List<Integer>>();
        
        Arrays.sort(arrayOfIntegers);
        
        for (int i=0; i < arrayOfIntegers.length - 2; i++) {
            int left = i+1;
            int right = arrayOfIntegers.length - 1;
            
            while (left < right) {
                if (arrayOfIntegers[i]+arrayOfIntegers[left]+arrayOfIntegers[right] == targetSum) {
                    List<Integer> threeSumSet;
                    threeSumSet = new ArrayList<Integer>();
                    threeSumSet.add(arrayOfIntegers[i]);
                    threeSumSet.add(arrayOfIntegers[left]);
                    threeSumSet.add(arrayOfIntegers[right]);

                    threeSumSets.add(threeSumSet);
                    left++;
                    right--;
                } else if (arrayOfIntegers[i]+arrayOfIntegers[left]+arrayOfIntegers[right] < targetSum ) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return threeSumSets;
    }
}
