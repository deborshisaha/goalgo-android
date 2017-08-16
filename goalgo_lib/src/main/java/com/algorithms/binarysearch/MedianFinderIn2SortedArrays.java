package com.algorithms.binarysearch;

public class MedianFinderIn2SortedArrays {

    public static void driver() {
        int[] arr1 = new int[]{1, 2, 5, 9};
        int[] arr2 = new int[]{0, 3, 4, 6, 7, 8};

        MedianFinderIn2SortedArrays medianFinder = new MedianFinderIn2SortedArrays();
        System.out.println("median:" + medianFinder.find(arr1, arr2));

    }

    public double find(int[] longer, int[] shorter) {

        // Massage data in a way that longer.length >= shorter.length
        // Error handling
        // Edge cases
        // Compute which one is the longer array
        if (shorter.length > longer.length) {
            find(shorter, longer);
        }

        // When one of the array is of length zero
        if (shorter.length == 0) {
            return median(longer);
        }

        // Start working on the crux

        
        int shorterLen = shorter.length;
        int longerLength = longer.length;

        int l2 = 0;
        int h2 = shorterLen;
        
        while (l2 <= h2) {
            int cutOfShorter = (l2 + h2) / 2;
            int cutOfLonger = (shorterLen + longerLength + 1) / 2 - cutOfShorter;

            // b belongs to smaller
            int blmax = (cutOfShorter == 0) ? Integer.MIN_VALUE : shorter[cutOfShorter-1];
            int brmin = (cutOfShorter == shorterLen) ? Integer.MAX_VALUE : shorter[cutOfShorter];

            // a belongs to smaller
            int almax = (cutOfLonger == 0) ? Integer.MIN_VALUE : longer[cutOfLonger-1];
            int armin = (cutOfLonger == longerLength) ? Integer.MAX_VALUE : longer[cutOfLonger];

            if (blmax <= armin && brmin >= almax) {
                // This is it, fount the cut

                if ((shorterLen + longerLength) % 2 == 0) {
                    return ((double) Math.max(almax, blmax) + Math.min(armin, brmin)) / 2;
                } else {
                    return (double) Math.max(armin, brmin);
                }
            } else if (blmax > armin) {
                // move increase cutOfLonger
                l2 = cutOfShorter + 1;
            } else if (armin < blmax) {
                // move decrease cutOfLonger
                h2 = cutOfShorter - 1;
            }

        }

        return 0;
    }

    private double median(int[] arr) {

        double median = 0;

        if (arr.length % 2 == 0) {
            // Even
            int mid = arr.length / 2;

            median = (arr[mid] + arr[mid + 1]) / 2;
        } else {
            // Odd
            median = arr[arr.length / 2];
        }

        return median;
    }
}
