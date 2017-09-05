package com.algorithms.trees;

import com.algorithms.TreeNode;

public class UnivalTree {

    private Counter counter = new Counter();

    public int count(BinaryTree tree) {
        boolean flag = countUtil(tree.getRootNode());
        return counter.count;
    }

    private boolean countUtil(TreeNode<Integer> rootNode) {

        if (rootNode == null) {
            return true;
        }

        boolean left = countUtil(rootNode.getLeft());
        boolean right = countUtil(rootNode.getRight());

        if (!left || !right) {
            return false;
        }

        if (rootNode.getLeft() != null && rootNode.getLeft().data != rootNode.data) {
            return false;
        }

        if (rootNode.getRight() != null && rootNode.getRight().data != rootNode.data) {
            return false;
        }

        counter.count++;
        return true;
    }

    static public class Counter {
        int count;
    }
}
