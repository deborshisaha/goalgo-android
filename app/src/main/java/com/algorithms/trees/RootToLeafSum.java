package com.algorithms.trees;

import com.algorithms.TreeNode;

/**
 * Created by dsaha on 9/4/17.
 */

public class RootToLeafSum {

    public boolean isPathPresent (BinaryTree tree, int num) {

        return isPathPresent(tree.getRootNode(), num);
    }

    private boolean isPathPresent (TreeNode<Integer> root , int num) {

        if (root == null) {
            return false;
        }

        if (root.getLeft() == null && root.getRight() == null ) {
            if (root.data == num) {
                System.out.println(root.data);
                return true;
            }
            return false;
        }

        boolean left = isPathPresent(root.getLeft(), num - root.data);
        boolean right = isPathPresent(root.getRight(), num - root.data);

        if (left || right) {
            System.out.println(root.data);
            return true;
        }

        return false;
    }
}
