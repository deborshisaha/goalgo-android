package com.algorithms.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumCostPath {
    
    public class Coordinate {
    	int r;
    	int c;

        private Coordinate(int row, int col) {
            this.r = row;
            this.c = col;
        }
    }

    public int cost(int[][] cost, int tr, int tc) {

    	int[][] T = getT(cost, tr, tc);

    	return T[tr][tc];
    }

    private int[][] getT(int[][] cost, int tr, int tc) {
        
        // Initialize a matrix to keep track of my result
    	int[][] T = new int[tr+1][tc+1];
        
        // Initialize T[0][0] with cost[0][0]
    	T[0][0] = cost[0][0];

    	// 0,0,-> 0,1
    	for (int col = 1; col<=tc; col++) {
    		T[0][col] = T[0][col-1] + cost[0][col];
    	}

    	// 0,0,-> 1,0
    	for (int row = 1; row<=tr; row++) {
    		T[row][0] = T[row-1][0] + cost[row][0];
    	}

    	for (int row = 1; row <= tr; row++) {
    		for (int col = 1; col <= tc; col++) {
    			T[row][col] = Integer.min(T[row-1][col],T[row][col-1]) + cost[row][col];
    		}
    	}
        
        return T;
    }
    
    public List<Coordinate> path(int[][] cost, int tr, int tc) {
    	
        int[][] T = getT(cost, tr, tc);
        int row = tr;
        int col = tc;
        List<Coordinate> list = new ArrayList();
        list.add(new Coordinate(tr,tc));
        while (true) {

            int costToPreviousStep = T[row][col] - cost[row][col];

            int previousRow = row - 1;
            int previousCol = col - 1;
            
            if (previousRow <0) {previousRow=0;}
            if (previousCol <0) {previousCol=0;}
            
            if (T[previousRow][col] == costToPreviousStep) {
                list.add(new Coordinate(previousRow,col));
                row--;
            } else if (T[row][previousCol] == costToPreviousStep) {
                list.add(new Coordinate(row,previousCol));
                col--;
            }
            
            if (previousRow==0 && previousCol==0) {
                break;
            }
        }
        Collections.reverse(list);
        return list;
    }

    public static void driver() {
        MinimumCostPath mcp = new MinimumCostPath();
        int[][] cost = new int[][]{{1,2,3},{4,8,2},{1,5,3}};
        List<Coordinate> list = mcp.path(cost, 2, 2);
        for (Coordinate c: list) {
            System.out.println(c.r+","+c.c);
        }
        System.out.println("Minimum cost path: "+mcp.cost(cost, 2, 2));
    }
}