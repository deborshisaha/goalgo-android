package com.algorithms.trees;

public class BSTOneChildPreOrderTraversal {

    public boolean hasOneChild (int[] preorder) {

        int nextDiff = 0;
        int lastDiff = 0;

        for (int i = 0; i < preorder.length - 1; i++) {
            nextDiff = preorder[i] - preorder[i+1];
            lastDiff = preorder[i] - preorder[preorder.length - 1];

            if (nextDiff * lastDiff < 0 ) {return false;}
        }

        return true;
    }
}
