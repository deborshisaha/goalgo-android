package com.algorithms.binarysearch;

public class ArithmeticProgressionSearch {
    
    public static void driver() {
        ArithmeticProgressionSearch aps = new ArithmeticProgressionSearch();
        int[] a = new int[]{1,3,5,9,11};
        System.out.println("MissingAP:"+aps.search(a));
    }
    
    public int search (int[] a) {
        
        int answer = 0;
        int high = a.length-1;
        int low = 0;
        int middle = 0;
        int total = high-low+1;

        int ap = (a[high] - a[low])/total;

        while (low < high) {
            // middle
            middle = (low+high)/2;
            
            int computedAP = a[0]+ap*middle;
            int actualAP = a[middle];
            
            System.out.println("computedAP:"+computedAP+" actualAP:"+actualAP);
            
            if (computedAP ==  actualAP) {
                low = middle + 1;
            } else if ((computedAP < actualAP) &&(computedAP > a[middle-1])) {
                answer = computedAP;
                break;
            } else {
                high = middle-1;
            }
        }
        
        return answer;
    }
}
