package com.algorithms.arrays;

public class PositiveAndNegativeNumberAlternatively {

    public static void driver() {
        PositiveAndNegativeNumberAlternatively obj = new PositiveAndNegativeNumberAlternatively();

        int[] arr = new int[]{-1, 2, -3, 4, 5, 6, -7, 8, 9};  //4 -3 5 -1 -7 6 2 8 9  ,  4 -3 5 -1 6 -7 2 8 9
        obj.rearrange(arr);
        obj.print(arr);
    }

    public int[] rearrange(int[] a) {

        int lastNegativeNumberIndex = -1;

        // collect negative numbers to the front 
        for (int j = 0; j < a.length; j++) {

            int temp = 0;

            if (a[j] < 0) {

                lastNegativeNumberIndex++;

                temp = a[j];
                a[j] = a[lastNegativeNumberIndex];
                a[lastNegativeNumberIndex] = temp;
            }
        }

        int posStart = lastNegativeNumberIndex + 1;
        int temp = 0;
        int k = 0;

        while (k < posStart) {

            if (posStart == a.length) {
                break;
            }

            if (k % 2 == 0 && a[k] < 0) {
                // Positives
                temp = a[k];
                a[k] = a[posStart];
                a[posStart] = temp;
                
                posStart++;
                k++;
                continue;
            }

            k++;
        }

        return a;
    }

    void rearrange2(int arr[])
    {
        // The following few lines are similar to partition
        // process of QuickSort.  The idea is to consider 0
        // as pivot and divide the array around it.
        int i = -1, temp = 0;
        for (int j = 0; j < arr.length; j++)
        {
            if (arr[j] < 0)
            {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        // Now all positive numbers are at end and negative numbers at
        // the beginning of array. Initialize indexes for starting point
        // of positive and negative numbers to be swapped
        int pos = i+1, neg = 0;
        print(arr);
        // Increment the negative index by 2 and positive index by 1, i.e.,
        // swap every alternate negative number with next positive number
        while (pos < arr.length && neg < pos && arr[neg] < 0)
        {
            temp = arr[neg];
            arr[neg] = arr[pos];
            arr[pos] = temp;
            pos++;
            neg += 2;
        }
    }
    
    private void print(int[] a) {
        System.out.println();
        for (Integer i : a) {
            System.out.print(i + " ");
        }
    }
}
