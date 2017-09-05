package com.algorithms.trees;

import com.algorithms.TreeNode;

import java.util.Stack;

/**
 * Created by dsaha on 9/4/17.
 */

public class FlattenLinkListToBinaryTreePreorder {
    
    public TreeNode flatten (BinaryTree tree) {
        return flatten (tree.getRootNode());
    }

    private TreeNode flatten(TreeNode rootNode) {

        Stack<TreeNode> stack = new Stack<>();

        stack.push(rootNode);

        TreeNode prev = null;

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();

            if (prev != null) {
                prev.setRight(node);
            }

            prev = node;

            if (node.getRight() != null) {
                stack.push(node.getRight());
            }

            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }

            node.setLeft(null);
            node.setRight(null);
        }


        return rootNode;
    }
}
