package com.algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;

class Activity implements Comparable<Activity> {

    int s;
    int e;
    String n;

    public Activity(int startTime, int endTime, String name) {
        this.s = startTime;
        this.e = endTime;
        this.n = name;
    }

    @Override
    public int compareTo(Activity that) {
        return this.e - that.e;
    }
}

public class ActivitySelection {

    public static void driver() {
        ActivitySelection activitySelector = new ActivitySelection();
        ArrayList<Activity> activities = new ArrayList<Activity>();

        activities.add(new Activity(1, 2,"One"));
        activities.add(new Activity(3, 4,"Two"));
        activities.add(new Activity(0, 6,"Three"));
        activities.add(new Activity(5, 7,"Four"));
        activities.add(new Activity(8, 10,"Five"));
        activities.add(new Activity(5, 6,"Six"));

        activitySelector.print(activitySelector.getActivities(activities));
    }

    public ArrayList<Activity> getActivities(ArrayList<Activity> activities) {

        ArrayList<Activity> result = new ArrayList<Activity>();

        if (activities == null || activities.size() == 0) {
            return result;
        }
print(activities);
        Collections.sort(activities);
print(activities);
        result.add(activities.get(0));

        int e = activities.get(0).e;

        for (int i = 0; i < activities.size(); i++) {
            if (e <= activities.get(i).s) {
                result.add(activities.get(i));
                e = activities.get(i).e;
            }
        }

        return result;
    }
    
    void print (ArrayList<Activity> activities) {
        System.out.println();
        for (Activity activity: activities) {
            System.out.print(activity.n+" ");
        }
    }
}
