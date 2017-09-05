package com.algorithms.trees;

import com.algorithms.TreeNode;

public class TreeComparator {

    public boolean isSame (BinaryTree t1, BinaryTree t2) {

        return isSameUtil(t1.getRootNode(),t2.getRootNode());

    }

    private boolean isSameUtil(TreeNode r1, TreeNode r2) {

        if (r1 == null && r2 == null) {
            return true;
        }

        if (r1 == null || r2 == null) {
            return false;
        }


        return r1.data == r2.data && isSameUtil(r1.getLeft(), r2.getLeft()) && isSameUtil(r1.getRight(), r2.getRight());
    }


}
