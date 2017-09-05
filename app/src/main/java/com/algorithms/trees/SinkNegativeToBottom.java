package com.algorithms.trees;

import com.algorithms.TreeNode;

public class SinkNegativeToBottom {

    public void sinkZero (TreeNode<Integer> root) {

        if (root == null) {
            return;
        }

        sinkZero(root.getLeft());
        sinkZero(root.getRight());

        if (root.data < 0) {
            pushDown(root);
        }
    }

    private void pushDown (TreeNode<Integer> root) {

        if (root == null || root.getLeft() == null || root.getRight() == null) {
            return;
        }

        TreeNode<Integer> left = root.getLeft();
        TreeNode<Integer> right = root.getRight();

        if ( left != null && left.data > 0) {
            int temp = left.data;
            left.data = root.data;
            root.data = temp;
            pushDown(left);
        } else if (right != null && right.data > 0) {
            int temp = right.data;
            right.data = root.data;
            root.data = temp;
            pushDown(right);
        }
    }
}
