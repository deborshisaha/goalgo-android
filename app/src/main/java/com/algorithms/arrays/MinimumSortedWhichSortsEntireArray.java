package com.algorithms.arrays;

public class MinimumSortedWhichSortsEntireArray {

    public static void driver() {
        MinimumSortedWhichSortsEntireArray obj = new MinimumSortedWhichSortsEntireArray();
        int[] input = new int[]{-7,-6,0, 1, 2, -5, 5, 3, 4, 10};
        Range r = obj.getRange(input);

        System.out.print("Range: " + r.start + " to " + r.end);
    }

    public Range getRange(int[] array) {

        Range r = new Range();

        int lminimum = Integer.MAX_VALUE;
        int lmaximum = Integer.MIN_VALUE;
        
        // find the first inflection point
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                r.start = i;
                lminimum = array[i+1];
                break;
            }
        }

        // find the first inflection point fromt the rear side
        for (int j = array.length - 1; j > 0; j--) {
            if (array[j] < array[j - 1]) {
                r.end = j;
                lmaximum = array[j-1];
                break;
            }
        }

        for (int i = r.start-1; i >= 0; i--) {
            if (lminimum < array[i]) {
                r.start = i;
            }
        }

        for (int i = r.end+1; i < array.length; i++) {
            if (lmaximum > array[i]) {
                r.end = i;
            }
        }
        
        return r;
    }

}

class Range {

    int start;
    int end;

    public Range() {
    }

    public Range(int a, int b) {
        this.start = a;
        this.end = b;
    }
}
