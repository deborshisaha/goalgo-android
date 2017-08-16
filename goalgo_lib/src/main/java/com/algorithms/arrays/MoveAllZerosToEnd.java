package com.algorithms.arrays;

public class MoveAllZerosToEnd {
    
    public static void driver () {
        int[] input = new int[]{0,1,2,10,15,3,0,51,32,0,0,13,50};
        MoveAllZerosToEnd mover = new MoveAllZerosToEnd();
        mover.moveZeroToEndApproach2(input);
        
        for ( int i=0; i < input.length; i++) {
            System.out.print(input[i]+" ");
        }
    }
    
    public void moveZeroToEndApproach1(int[] input) {
        
        for (int i=0, j=input.length-1; i < j;) {
            
            if (input[i] ==0 && input[j]!=0 ) {
                swap(input, i, j);
                i++;
                j--;
            } else if (input[i]!=0) {
                i++;
            } else if (input[j]==0) {
                j--;
            }
            
        }
    }
    
    public void moveZeroToEndApproach2(int[] input) {
        
        int zeroSkipper = 0;
        int i = 0;
        
        while (zeroSkipper < input.length) {
            if (input[zeroSkipper] == 0) {
                zeroSkipper++;
                continue;
            }
            
            input[i] = input[zeroSkipper];
            i++;
            zeroSkipper++;
        }
        
        while (i<input.length) {
            input[i]=0;
            i++;
        }
    }
    
    void swap (int[] input, int i, int j) {
        
        int temp = 0;
        
        temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
