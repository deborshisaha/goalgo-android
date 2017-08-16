package com.algorithms.trees;

import com.algorithms.math.NextPowerOf2;

public class SegmentTree {

    private int[] inputArray;
    private int[] segmentTree;

    public SegmentTree(int[] ia) {
        this.inputArray = ia;
        int nextPowerOf2 = (new NextPowerOf2(ia.length)).next();

        int segmentTreeArraySize = (int) (2*Math.pow(2, nextPowerOf2) - 1);
        this.segmentTree = new int[segmentTreeArraySize];

        construct();
    }

    public int min(RangeQuery rQ) {

        int result = minUtil(rQ, 0, this.inputArray.length - 1, 0);

        return result;
    }

    private int minUtil(RangeQuery rQ, int low, int high, int position) {

        if (rQ.getStart() <= low && rQ.getEnd() >= high) {
            return this.segmentTree[position];
        } else if (rQ.getStart() > high || rQ.getEnd() < low) {
            // no overlap
            return Integer.MAX_VALUE;
        }
        
        int mid = (low + high) / 2;
        int left = (2 * position) + 1;
        int right = (2 * position) + 2;

        return Math.min(minUtil(rQ, low, mid, left), minUtil(rQ, mid + 1, high, right));
    }

    private void construct() {

        for (int i = 0; i < segmentTree.length; i++) {
            segmentTree[i] = Integer.MAX_VALUE;
        }

        constructUtil(0, this.inputArray.length - 1, 0);
    }

    private void constructUtil(int low, int high, int position) {

        if (low == high) {
            this.segmentTree[position] = this.inputArray[low];
            return;
        }
        int mid = (high + low) / 2;
        constructUtil(low, mid, (2 * position) + 1);
        constructUtil(mid + 1, high, (2 * position) + 2);
        this.segmentTree[position] = Math.min(this.segmentTree[(2 * position) + 1], this.segmentTree[(2 * position) + 2]);
    }

    public static void driver() {
        int[] input = new int[]{-1, 3, 4, 0, 2, 1};
        SegmentTree tree = new SegmentTree(input);
        tree.print();
        RangeQuery rQ = new RangeQuery(2, 4);
        System.out.println("Min: "+tree.min(rQ));
    }

    private void print() {
        for (int i=0; i<this.segmentTree.length; i++) {
            System.out.print(this.segmentTree[i]+" ");
        }
    }
}

class RangeQuery {

    private Integer start = 0;
    private Integer end = 0;

    public Integer getStart() {return start;}
    
    public Integer getEnd() {return end;}
    
    public RangeQuery(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }
}
