package com.algorithms.trees;

public class IdenticalTrees {

    public boolean areIdentical (int[] arr1, int[] arr2) {
        return areIdenticalUtil( arr1, arr2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean areIdenticalUtil(int[] arr1, int[] arr2, int index1, int index2, int minimum, int maximum) {


        int i = 0;
        int k = 0;

        for (i = index1; i < arr1.length ; i++) {
            if (arr1[i] > minimum && arr1[i] < maximum) {
                break;
            }
        }

        for (k = index2; k < arr2.length ; k++) {
            if (arr2[k] > minimum && arr2[k] < maximum) {
                break;
            }
        }

        if (k == arr2.length && i == arr1.length) {
            return true;
        }

        // If any one of the index has reached the end means that they are not identical
        if (((i == arr1.length) ^ (k == arr2.length)) || arr1[i] != arr2[k]) {
            return false;
        }

        return (areIdenticalUtil(arr1, arr2, index1+1, index2+1, arr1[i], maximum) &&
                areIdenticalUtil(arr1, arr2, index1+1, index2+1, minimum, arr1[i]));
    }
}
