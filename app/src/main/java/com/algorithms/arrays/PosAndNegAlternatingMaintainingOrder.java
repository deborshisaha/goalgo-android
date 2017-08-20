package com.algorithms.arrays;

// {1, 2, 3, -4, -1, 4}
// {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
public class PosAndNegAlternatingMaintainingOrder {

    public int[] alternatify (int[] input) {

        int outOfPlaceIndex = Integer.MIN_VALUE;

        for (int i = 0; i < input.length ; i++) {

            boolean isEven = (i % 2 == 0 );
            boolean isPositive = (input[i] >= 0);


            if (outOfPlaceIndex >= 0) {
                if ((input[outOfPlaceIndex] >= 0 && !isPositive) || (input[outOfPlaceIndex] < 0 && isPositive)) {

                    rightRotate(input, i, outOfPlaceIndex);

                    if (i - outOfPlaceIndex > 2 ) {
                        outOfPlaceIndex = outOfPlaceIndex+2;
                    } else {
                        outOfPlaceIndex = Integer.MIN_VALUE;
                    }
                }
            }

            // Update status incase the values were moved around
            isPositive = (input[i] >= 0);

            if (outOfPlaceIndex == Integer.MIN_VALUE) {
                if ((isPositive && isEven) || (!isEven && !isPositive)) {
                    outOfPlaceIndex = i;
                }
            }
        }

        return input;

    }

    private void rightRotate (int[] in, int high, int low) {

        int temp = in[high];

        for (int i = high ; i > low; i--) {
            in[i] = in[i-1];
        }

        in[low] = temp;

    }
}
