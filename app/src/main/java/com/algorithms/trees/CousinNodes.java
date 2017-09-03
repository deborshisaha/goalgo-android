package com.algorithms.trees;

import com.algorithms.TreeNode;

/**
 * Created by dsaha on 9/3/17.
 */

public class CousinNodes {

    private int level (TreeNode<Integer> root , TreeNode<Integer> node, int level) {

        if (root == null) {
            return 0;
        }

        if (root.data == node.data) {
            return level;
        }

        int levelLeft = level(root.getLeft(), node, level+1);

        if (levelLeft != 0) {
            return levelLeft;
        }

        return level(root.getRight(), node, level+1);
    }

    private boolean areSiblings (TreeNode<Integer> root , TreeNode<Integer> one, TreeNode<Integer> two) {

        if (root == null) {
            return false;
        }

        if (root.getLeft() == null || root.getRight() == null) {
            return false;
        }

        return ((root.getLeft().data == one.data && root.getRight().data == two.data) ||
                (root.getRight().data == one.data && root.getLeft().data == two.data) ||
                areSiblings(root.getLeft(), one, two) || areSiblings(root.getRight(), one, two));
    }

    public boolean areCousins (BinaryTree bt , int value1, int value2) {


        if (bt == null) {
            return false;
        }

        if (bt.getRootNode() == null) {
            return false;
        }

        TreeNode<Integer> a = new TreeNode<>(value1);
        TreeNode<Integer> b = new TreeNode<>(value2);

        return ((level(bt.getRootNode(), a, 1) == level(bt.getRootNode(), b, 1)) && !areSiblings(bt.getRootNode(), a, b));
    }
}
