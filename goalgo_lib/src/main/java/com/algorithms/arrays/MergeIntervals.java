package com.algorithms.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author dsaha
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 *  For example,
 *  Given [1,3],[2,6],[8,10],[15,18],
 *  return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {
    
    public List<Interval> mergedIntervals(List<Interval> intervals) {
        
        List<Interval> mergedIntervals = new ArrayList();
        
        Collections.sort(intervals, new IntervalComparator());
        
        Interval entryInterval = intervals.get(0);
        
        for (int i = 1; i<intervals.size(); i++) {

            Interval interval = intervals.get(i);
            
            if (entryInterval.getEndTime() > interval.getStartTime()) {
                // Overlap detected
                Integer startTime = Math.min(entryInterval.getStartTime(), interval.getStartTime());//(currentInterval.getStartTime() > ongoingInterval.getStartTime())?currentInterval.getStartTime():ongoingInterval.getStartTime();
                Integer endTime = Math.max(entryInterval.getEndTime(), interval.getEndTime());
                entryInterval.startTime = startTime;
                entryInterval.endTime = endTime;
            } else {
                mergedIntervals.add(entryInterval);
                entryInterval = interval;
            }
        }
        
        mergedIntervals.add(entryInterval);
        
        return mergedIntervals;
    }
    
    static public void driver() {
        
        Interval i1 = new Interval(1,3);
        Interval i2 = new Interval(2,6);
        Interval i3 = new Interval(8,10);
        Interval i4 = new Interval(15,18);

        List<Interval> intervals = new ArrayList();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        MergeIntervals sc = new MergeIntervals();
        
        List<Interval> mI = sc.mergedIntervals(intervals);
        System.out.println("Intervals are:");
        mI.forEach((i) -> {
            System.out.println(i.startTime+","+i.endTime);
        });
    }
}

class Interval {
    public Integer startTime;
    public Integer endTime;
    
    public Integer getStartTime () {
        return startTime;
    }
    
    public Integer getEndTime () {
        return endTime;
    }
    
    public Interval(Integer startTime, Integer endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

}

class IntervalComparator implements Comparator<Interval> {
    
    @Override
    public int compare (Interval interval1, Interval interval2) {
        if ( interval1.getEndTime() > interval2.getEndTime()) {
            return 1;
        } else {
            return -1;
        }
    }
}
