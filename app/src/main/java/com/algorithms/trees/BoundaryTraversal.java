package com.algorithms.trees;

import com.algorithms.TreeNode;

public class BoundaryTraversal {

    BinaryTree tree;

    public static void driver() {
        System.out.println();
        BinaryTree tree = BinaryTree.createBalancedBT();
        BoundaryTraversal boundaryPrinter = new BoundaryTraversal(tree);
        boundaryPrinter.print();
    }

    public BoundaryTraversal() {
    }

    public BoundaryTraversal(BinaryTree t) {
        this.tree = t;
    }

    public void print() {
        if (this.tree.getRootNode() == null) {
            return;
        }
        System.out.print(this.tree.getRootNode().data + " ");
        printLeft(this.tree.getRootNode().getLeft());
        printLeaves(this.tree.getRootNode());
        printRight(this.tree.getRootNode().getRight());
    }

    private void printLeft(TreeNode n) {
        if (n == null || (n.getLeft() == null && n.getRight() == null)) {
            // Second parameter is to avoid printing the leaves twice
            return;
        }

        System.out.print(n.data + " ");
        if (n.getLeft() != null) {
            // Left subtree is there
            printLeft(n.getLeft());
        } else {
            // No left subtree
            printRight(n.getRight());
        }
    }

    private void printLeaves(TreeNode n) {
        if (n == null) {
            return;
        }

        if (n.getLeft() == null && n.getRight() == null) {
            System.out.print(n.data + " ");
            return;
        }

        printLeaves(n.getLeft());
        printLeaves(n.getRight());
    }

    private void printRight(TreeNode n) {
        if (n == null || (n.getLeft() == null && n.getRight() == null)) {
            // Second parameter is to avoid printing the leaves twice
            return;
        }

        System.out.print(n.data + " ");
        if (n.getRight() != null) {
            // Right subtree is there
            printRight(n.getRight());
        } else {
            // No right subtree
            printRight(n.getLeft());
        }
    }
}
