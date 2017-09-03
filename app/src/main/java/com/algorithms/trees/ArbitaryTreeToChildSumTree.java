package com.algorithms.trees;

import com.algorithms.TreeNode;

public class ArbitaryTreeToChildSumTree {

    public TreeNode<Integer> childrenSumTree (TreeNode<Integer> root) {
        convert(root);
        return root;
    }

    private Integer convert (TreeNode<Integer> root) {

        if (root == null) {
            return 0;
        }

        // Leaf node
        if (root.getLeft() == null && root.getRight() == null) {
            return root.data;
        }

        Integer sumL = convert(root.getLeft());
        Integer sumR = convert(root.getRight());

        Integer sumOfChildren = sumL+sumR;

        if (sumOfChildren == root.data) {
            return root.data;
        }

        Integer delta = root.data - sumOfChildren;

        if (delta < 0) {
            root.data += delta*-1;
        } else {
            // Increment child
            delta = delta;
            increment(root.getLeft(), delta);
        }

        return root.data;
    }

    private void increment(TreeNode<Integer> root, Integer incrementBy) {

        if (root == null) {
            return;
        }

        root.data += incrementBy;

        if (root.getLeft()!= null && root.getRight()!=null) {
            Integer delta = (Integer) root.data + (Integer)root.getRight().data - (Integer)root.getLeft().data;
            increment(root.getLeft(), delta);
        }
    }
}
