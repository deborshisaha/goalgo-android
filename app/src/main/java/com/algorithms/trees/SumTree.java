package com.algorithms.trees;

import com.algorithms.TreeNode;

public class SumTree {

    public boolean isSumTree (BinaryTree bt){

        return isSumTreeUtilApproach1(bt.getRootNode());
    }

    private boolean isSumTreeUtilApproach1(TreeNode<Integer> rootNode) {

        if (rootNode == null || (rootNode.getRight() == null && rootNode.getLeft() == null)) {
            return true;
        }

        TreeNode<Integer> left = rootNode.getLeft();
        TreeNode<Integer> right = rootNode.getRight();

        int leftData = 0;
        int rightData = 0;

        if (left == null) {leftData = 0;} else {leftData = sum(left);}
        if (right == null) {rightData = 0;} else {rightData = sum(right);}

        boolean result =(isSumTreeUtilApproach1(left) && isSumTreeUtilApproach1(right) && (leftData + rightData == rootNode.data));

        return result;
    }

    private int sum(TreeNode<Integer> node) {
        if (node == null) return 0;

        return sum(node.getLeft()) + node.data + sum(node.getRight());
    }

    private boolean isSumTreeUtilApproach2(TreeNode<Integer> root) {

        return false;
    }
}
