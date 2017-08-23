package com.algorithms.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Incorrect
 * Incorrect
 * Incorrect
 * Incorrect
 * Incorrect
 * Incorrect
 * Incorrect
 * Incorrect
 * Incorrect
 * Incorrect
 * Incorrect
 * Incorrect
 * Incorrect
 * Incorrect
 */

public class CountSmallerOnRight {

    public int[] getCount (int[] input) {

        int[] result = new int[input.length];

        NumberNode[] temp = new NumberNode[input.length];

        // Create a list of number nodes
        for (int i = 0; i < input.length; i++) {
            temp[i] = new NumberNode(i,input[i]);
        }

        // Sort the array
        Arrays.sort(temp, new Comparator<NumberNode>() {
            @Override
            public int compare(NumberNode n1, NumberNode n2) {
                return n2.value - n1.value;
            }
        });

        // Now we know where the ranks of the numbers are
        for (int rank = 0; rank < temp.length; rank++) {
            NumberNode node = temp[rank];

            // Rank is where the number belongs when the numbers are sorted in ascending order
            // Node position is the position of the number in the original input array
            // Difference will tell us how many numbers are there to the right of the element in the original array
            result[node.position] = rank - node.position;
        }

        return result;
    }

    public static class NumberNode {
        int position;
        int value;

        public NumberNode(int position, int value) {
            this.position = position;
            this.value = value;
        }
    }
}
