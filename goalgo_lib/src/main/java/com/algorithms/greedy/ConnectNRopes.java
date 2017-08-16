package com.algorithms.greedy;

import java.util.PriorityQueue;

public class ConnectNRopes {

    public static void driver() {
        ConnectNRopes costFinder = new ConnectNRopes();

        int[] ropes = new int[]{4, 3, 2, 6};

        System.out.println("4,3,2,6 =" + costFinder.findCostToJoin(ropes));
    }

    public int findCostToJoin(int[] ropes) {

        int result = 0;

        PriorityQueue<Integer> q = new PriorityQueue(ropes.length);

        for (int i = 0; i < ropes.length; i++) {
            q.offer(ropes[i]);
        }

        while (!q.isEmpty()) {
            result = q.poll();
            Integer b = 0;
            if (!q.isEmpty()) {
                b = q.poll();
            } else {
                break;
            }

            result = result + b;

            q.offer(result);
        }
        
        return result;
    }
}
