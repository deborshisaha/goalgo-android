package com.algorithms.arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dsaha on 8/20/17.
 */

public class FourSum {

    public int[][] find (int[] input , int target) {

        ArrayList<Result> results = new ArrayList();

        if (input.length < 4) {
            System.out.println("1");
            return null;
        }

        Arrays.sort(input);

        if (input[0]+input[1]+input[2]+input[3]> target) {
            System.out.println("2");
            return null;
        }

        if (input[input.length-1]+input[input.length-2]+input[input.length-3]+input[input.length-4] < target) {
            System.out.println("3");
            return null;
        }

        for (int i = 0; i < input.length - 3; i++) {

            // if this is same as previos number then continue
            if (i!=0 && input[i] == input[i-1]) {
                continue;
            }

            if (input[i] + input[i+1] + input[i+2] + input[i+3] > target) {
                break;
            }

            if (input[i] + input[input.length - 1] + input[input.length-2] + input[input.length - 3] < target) {
                continue;
            }

            for (int j = i+1; j < input.length - 2; j++ ) {
                if (j!= i+1 && input[j] == input[j-1]) {
                    continue;
                }

                if (input[i] + input[j] + input[j+2] + input[j+1] > target) {
                    break;
                }

                if (input[i] + input[j] + input[input.length - 2] + input[input.length - 1] < target) {
                    continue;
                }

                // binary search in the range j+1 and high
                int remainingTarget = (target - input[i] - input[j]);
                searchAndFill (input, j+1, input.length -1, remainingTarget, results, input[i] , input[j]);

            }
        }

        return resultsIn2D(results);

    }

    private void searchAndFill(int[] input , int low, int high, int target, ArrayList<Result> result, int a, int b) {

        while (low < high) {
            if (low!= 0 && input[low] == input[low - 1]) {
                low++;
                continue;
            }

            if (high!= input.length -1 && input[high] == input[high+1]) {
                high --;
                continue;
            }

            int sum = input[low]+input[high];

            if (sum == target) {
                result.add(new Result(input[low], input[high], a, b));
                low++;
                high--;
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
    }

    private int[][] resultsIn2D(ArrayList<Result> results) {

        int[][] arr = new int[results.size()][4];

        for (int r = 0; r < results.size(); r++) {
            Result res = results.get(r);
            arr[r][0] = res.a;
            arr[r][1] = res.b;
            arr[r][2] = res.c;
            arr[r][3] = res.d;
        }

        return arr;
    }
}

class Result {
    int a;
    int b;
    int c;
    int d;

    public Result(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        System.out.println("a:"+a+" b:"+b+" c:"+c+" d:"+d);
    }
}
