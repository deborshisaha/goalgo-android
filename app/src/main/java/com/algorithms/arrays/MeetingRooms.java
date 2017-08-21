package com.algorithms.arrays;

import java.util.Arrays;

/**
 * Created by dsaha on 8/20/17.
 */

public class MeetingRooms {

    public int getMeetingRoomsNeeded(MeetingSchedule[] intervals) {

        int numberOfRooms = 0;
        int minimumRoomsRequired = 0;

        int j = 0;

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0;

        while (i < start.length ) {
            if (start[i] < end[j]) {
                numberOfRooms++;
                i++;
            } else {
                j++;
                numberOfRooms--;
            }

            if (minimumRoomsRequired < numberOfRooms) {
                minimumRoomsRequired = numberOfRooms;
            }
        }

        return minimumRoomsRequired;
    }

    public static class MeetingSchedule {
        int start;
        int end;

        public MeetingSchedule(int start, int end) {
            this.start = end;
            this.end = start;
        }
    }
}
