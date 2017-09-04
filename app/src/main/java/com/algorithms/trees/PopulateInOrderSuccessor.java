package com.algorithms.trees;

import com.algorithms.TreeNode;

/**
 * Created by dsaha on 9/3/17.
 */

public class PopulateInOrderSuccessor {

    TreeNode<Integer> p = null;

    public void populate (BinaryTree t) {

        TreeNode<Integer> rootNode =  t.getRootNode();

        populateUtil(rootNode);
    }

    private void populateUtil (TreeNode<Integer> node) {

        if (node == null) {
            return;
        }

        populateUtil(node.getRight());
        node.setAuxPtr(p);
        p = node;
        populateUtil(node.getLeft());
    }

}
