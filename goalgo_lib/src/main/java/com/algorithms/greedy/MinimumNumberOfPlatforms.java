package com.algorithms.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MinimumNumberOfPlatforms {
    
    public static void driver () {
        MinimumNumberOfPlatforms platformFinder = new MinimumNumberOfPlatforms();
        
        Integer[] arrivals = new Integer[]{900,  940, 950,  1100, 1500, 1800};
        Integer[] departures = new Integer[]{910, 1200, 1120, 1130, 1900, 2000};
        
        System.out.print("Number of platforms required: "+ platformFinder.getMinimumNumberOfPlatforms(arrivals, departures) );
        
    }
    
    public int getMinimumNumberOfPlatforms (Integer[] arrivals, Integer[] departures) {
        Arrays.sort(arrivals, new IntegerComparator());
        Arrays.sort(departures, new IntegerComparator()); 
        int i = 0;
        int j = 1;
        int maxPlatforms = 1;
        int platformsRequired = 1;
        for (Integer k:departures) {
            System.out.print(k+" ");
        }
        while ( i < arrivals.length && j < departures.length ) {
            
            if (arrivals[i] < departures[j]) {
                
                platformsRequired++;
                i++;
                
                if (maxPlatforms > platformsRequired) {
                    maxPlatforms = platformsRequired;
                }

            } else {
                j++;
                platformsRequired--;
            }
        }
        
        return maxPlatforms;
    }
}

class IntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return -1 * (o2 - o1);
    }
}
