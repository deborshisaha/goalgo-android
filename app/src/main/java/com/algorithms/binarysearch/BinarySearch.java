package com.algorithms.binarysearch;

public class BinarySearch {

    public static void driver() {
        BinarySearch bs = new BinarySearch();
        int[] arr = new int[]{20, 32, 87, 103, 293, 431};
        System.out.println("Binary Search for 103:"+bs.find(arr, 103));
    }

    private int find(int[] input, int searchItem) {
        int ans = -1;
        int low = 0;
        int high = input.length - 1;

        while (low <= high) {

            int middle = (low + high) / 2;
            System.out.println(input[middle]);

            if (input[middle] > searchItem) {
                // a[m-1] > a[m] > a[m+1]
                high = middle - 1;
            } else if (input[middle] < searchItem) {
                // a[m-1] < a[m] < a[m+1]
                low = middle + 1;
            } else if (input[middle] == searchItem) {
                // a[m-1] < a[m] > a[m+1]
                ans = middle;
                break;
            }
        }
        
        return ans;
    }
}
