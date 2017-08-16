package com.algorithms.arrays;

/**
 *
 * @author dsaha
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {
    
    public float findMedian(int[] arr1, int[] arr2) {
        
        int len = arr1.length + arr2.length;
        
        if (len%2 == 1) {
            return findKthElement(0, arr1, 0, arr2, len/2 +1);
        } else {
            return (findKthElement(0, arr1, 0, arr2, len/2)+findKthElement(0, arr1, 0, arr2, len/2+1))/2;
        }
    }

    private float findKthElement (int AStart, int[] A, int BStart, int[] B, int k) {
        // The length of A is 0 is covered by the length of A greater than 0
        if (A.length <= AStart) {
            return B[BStart+k-1];
        }
        // The length of B is 0
        if (B.length <= BStart) {
            return A[AStart+k-1];
        }
        // let k = 1
        if (k==1) {
            return Math.min(A[AStart], B[BStart]);
        } 

        // recursive
        float AKey = (AStart+ k/2 -1 ) < A.length ? A[AStart+k/2-1]:Float.MAX_VALUE;
        float BKey = (BStart+ k/2 -1 ) < B.length ? B[BStart+k/2-1]:Float.MAX_VALUE;
        
        if (AKey > BKey) {
            // Look into B
            return findKthElement(AStart, A, BStart+k/2, B,k-k/2);
        } else {
            // Look into A
            return findKthElement(AStart+k/2, A, BStart, B,k-k/2);
        }
    }
    
    static public void driver() {
         
        int[] arr1 = new int[]{2,3,4,72,76,83,85,99};
        int[] arr2 = new int[]{5,15,17,49,100};

        MedianOfTwoSortedArrays medianFinder = new MedianOfTwoSortedArrays();
        System.out.println("Median:" + medianFinder.findMedian(arr1, arr2));

    }
}
