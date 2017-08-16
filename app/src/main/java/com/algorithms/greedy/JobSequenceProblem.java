package com.algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class JobSequenceProblem {
    
    public static void driver () {
        JobSequenceProblem sequencer = new JobSequenceProblem();
        
        Job j1 = new Job(2,100,"a");
        Job j2 = new Job(1,19,"b");
        Job j3 = new Job(2,27,"c");
        Job j4 = new Job(1,25,"d");
        Job j5 = new Job(3,15,"e");
        
        ArrayList<Job> jobs = new ArrayList();
        jobs.add(j1);
        jobs.add(j2);
        jobs.add(j3);
        jobs.add(j4);
        jobs.add(j5);
        
        ArrayList<Job> res = sequencer.sequence(jobs);
        
        res.forEach((j) -> {
            System.out.print(j.i+" ");
        });
    }
    
    public ArrayList<Job> sequence(ArrayList<Job> jobs) {
        
        Collections.sort(jobs);
        
        Job[] timeSlot = new Job[jobs.size()];
        timeSlot[0] = jobs.get(0);
        
        for (int i = 1 ; i < jobs.size(); i++) {
            
            for (int k = Math.min(jobs.size(), jobs.get(i).d)-1; k >=0 ; k--) {
                if (timeSlot[k] == null ) {
                    timeSlot[k] = jobs.get(i);
                } 
            }
        }
        
        ArrayList<Job> result = new ArrayList();
        
        for (Job j: timeSlot) {
            if (j!=null) {
                result.add(j);
            }
        }
        
        return result;
    }
}

class Job implements Comparable<Job> {
    
    int d;
    int v;
    String i;
    
    public Job (int deadline, int value, String identifier) {
        this.d = deadline;
        this.v = value;
        this.i = identifier;
    }

    @Override
    public int compareTo(Job that) {
        return that.v - this.v;
    }
}