package com.algorithms.arrays;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * Best Meeting Point - Manhattan Distance : distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|
 * 
 * A group of two or more people wants to meet and minimize the total travel distance. 
 * You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group.
 * The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 * For example, given three people living at (0,0), (0,4), and (2,2):
 * 
 * 1 - 0 - 0 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * 
 * The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal.
 * So return 6.
 */
public class BestMeetingPoint {

    public int minimumTotalDistance (int[][] arr) {

        int minDistance = 0;

        if (arr.length == 0 || arr[0].length == 0) {
            return minDistance;
        }

        ArrayList<Integer> vertical = new ArrayList();
        ArrayList<Integer> horizontal = new ArrayList();

        for (int r = 0; r < arr.length ; r++) {
            for (int c = 0; c < arr[r].length ; c++) {
                if (arr[r][c] == 1) {
                    vertical.add(r);
                    horizontal.add(c);
                }
            }
        }

        Collections.sort(vertical);
        Collections.sort(horizontal);

        int meanY = vertical.get(vertical.size()/2);
        int meanX = horizontal.get(horizontal.size()/2);

        for (int r = 0; r < arr.length ; r++) {
            for (int c = 0; c < arr[r].length ; c++) {
                if (arr[r][c] == 1) {
                    minDistance += Math.abs(meanX - c) + Math.abs(meanY - r);
                }
            }
        }

        System.out.print("Minimum Distance : "+ minDistance);

        return minDistance;
    }
}
