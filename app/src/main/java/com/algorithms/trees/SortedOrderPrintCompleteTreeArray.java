package com.algorithms.trees;

public class SortedOrderPrintCompleteTreeArray {

    private void printBST(int[] array, int current) {

        if (current >= array.length) {
            return;
        }

        printBST(array, (2*current + 1));
        System.out.print(array[current]);
        printBST(array, (2*current + 2));
    }

    public void print(int[] array) {
        printBST(array, 0);
    }

}
