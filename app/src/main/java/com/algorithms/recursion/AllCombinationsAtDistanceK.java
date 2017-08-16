package com.algorithms.recursion;

import java.util.ArrayList;

public class AllCombinationsAtDistanceK {

    ArrayList<Integer> result = new ArrayList();

    public static void driver() {
        AllCombinationsAtDistanceK obj = new AllCombinationsAtDistanceK();
        int[] input = new int[]{1, 2, 3, 4};
        //int result[] = new int[input.length];
        obj.combination(input, 2, 0);

        //System.out.println(llp.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }

    public void combination(int input[], int k, int pos) {

        if (pos == input.length) {
            print();
            return;
        }

        for (int i = pos; i < pos + k && i < input.length; i++) {
            result.add(formNumber(input, pos, i));
            combination(input, k, i + 1);
            result.remove(result.size() - 1);
        }
    }

    private void print() {
        result.forEach((lol) -> {
            System.out.print(lol + " ");
        });
        System.out.println();
    }

    public int formNumber(int[] a, int start, int end) {

        int number = 0;

        for (int l = start; l <= end; l++) {
            number = number * 10 + a[l];
        }

        return number;
    }
}
