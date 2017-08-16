package com.algorithms.dp;

import java.util.Arrays;
import java.util.Comparator;

class Job {

    public float s;
    public float e;
    public float v;

    public Job(float s, float e, float v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }
}

class JobSorter implements Comparator<Job> {

    @Override
    public int compare(Job j1, Job j2) {
        // Ascending 1->2 (1-2)
        // Descending 2->1 (2-1)
        return (int) (j1.e - j2.e);
    }
}

public class WeightedJobScheduler {

    private float[] T;

    private void initialize(Job[] jobs) {

        int i = 0;
        
        if (T==null) {
            T = new float[jobs.length];
        }
        
        for (Job j : jobs) {
            T[i] = j.v;
            i++;
        }
    }

    public float max(Job[] jobs) {

        Arrays.sort(jobs, new JobSorter());

        initialize(jobs);

        float maxVal = 0.0f;

        for (int i = 1; i < jobs.length;) {
            for (int j = 0; j < i; j++) {
                Job jj = jobs[j];
                Job ji = jobs[i];

                if (jj.e > ji.s) {
                    break;
                } else if (ji.v + T[j] > T[i]) {
                    T[i] = ji.v + T[j];

                    if (maxVal < T[i]) {
                        maxVal = T[i];
                    }
                }
            }

            i++;
        }

        return maxVal;
    }
    
    public static void driver() {
        WeightedJobScheduler wjs = new WeightedJobScheduler();
        
        Job j1 = new Job(1,3,5);
        Job j2 = new Job(2,5,6);
        Job j3 = new Job(4,6,5);
        Job j4 = new Job(6,7,4);
        Job j5 = new Job(5,8,11);
        Job j6 = new Job(7,9,2);
        
        Job[] jobs = new Job[]{j1, j3, j2, j4, j5, j6};
        
        System.out.println("WJS max value: "+wjs.max(jobs));
        
    }
}
