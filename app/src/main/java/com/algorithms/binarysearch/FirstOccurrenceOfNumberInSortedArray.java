package com.algorithms.binarysearch;

public class FirstOccurrenceOfNumberInSortedArray {
        
    public static void driver() {
        FirstOccurrenceOfNumberInSortedArray fo = new FirstOccurrenceOfNumberInSortedArray();
        int[] arr = new int[]{1, 2, 2,2, 3, 3,3,4,4,4,4, 5};
        System.out.println(fo.find(arr, 4));
    }
    
    private int find(int[] input, int searchItem) {
        int ans = -1;
        int low = 0;
        int high = input.length - 1;

        while (low <= high) {

            int middle = (low + high) / 2;
            //System.out.println(input[middle]);

            if (input[middle] == searchItem && input[middle-1] < searchItem) {
                // a[m-1] == serachItem == a[m+1]
                ans = middle;
                break;
                
            } else if (input[middle] < searchItem) {
                low = middle + 1;
            } else if (input[middle] > searchItem) {
                high = middle - 1;
            } else if (input[middle] == searchItem) {
                
                if (input[middle-1] == searchItem && input[middle+1] == searchItem) {
                    high = middle - 1;
                }
            }
        }
        
        return ans;
    }
}
