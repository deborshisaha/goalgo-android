package com.algorithms.dp;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class KnapSack01Calculator {
    
    public class Index{
        public Integer wt;
        public Integer val;

        public Index(int value, int weight) {
            this.wt = weight;
            this.val = value;
        }

        private void print() {
            System.out.println("wt: "+ wt + " val: "+val);
        }
    }
    
    class IndexComparator implements Comparator<Index>{

        @Override
        public int compare(Index o1, Index o2) {
            return o1.wt - o2.wt;
        }
    }
    
    private Index[] listOfInputs = null;
    private Integer capacity = 0;
    
    private int[][] computeMatrix() {
        
        int[][] T = new int[this.listOfInputs.length+1][this.capacity+1];
        
        for (int row = 0; row <= this.listOfInputs.length; row++) {
            
            for (int column = 0; column <= this.capacity; column++) {
  
                // logic goes here
                if(column == 0 || row == 0) {
                    T[row][column] = 0;
                    continue;
                } 
                
                Index idx = this.listOfInputs[row-1];
                //idx.print();
                if (column < idx.wt ) {
                    T[row][column] = T[row-1][column];
                } else {
                    Integer effectiveCol = column-idx.wt;
                    Integer inclusiveVal = idx.val+T[row-1][effectiveCol];
                    
                    Integer exclusiveVal = T[row-1][column];
                    T[row][column] = Integer.max(inclusiveVal, exclusiveVal);
                }
            }
        }
        
        return T;
    }
    
    public int maxValue() {
        
        int[][] matrix = computeMatrix();
        
        return matrix[this.listOfInputs.length][this.capacity];
    }
    
    public List<Integer> weightsToPick() {
        
        ArrayList<Integer> weightsToPick = new ArrayList<Integer>();
        
        return weightsToPick;
    }
    
    public KnapSack01Calculator (int[] weights, int[] values, int capacity) {
        this.listOfInputs = new Index[values.length];
        this.capacity = capacity;
        for (int i=0, j=0; i<values.length && j<weights.length; i++,j++) {
            Index index = new Index(values[i], weights[j]);
            this.listOfInputs[i] = index;
        }
        
        Arrays.sort(this.listOfInputs, new IndexComparator());
    }
    
    public static void driver() {
        
        int[] wts = new int[]{1,3,4,5};
        int[] values = new int[]{1,4,5,7};
        KnapSack01Calculator knapSack01Calculator = new KnapSack01Calculator(wts,values,7);
        System.out.println("Max value:" + knapSack01Calculator.maxValue());
    }
}
