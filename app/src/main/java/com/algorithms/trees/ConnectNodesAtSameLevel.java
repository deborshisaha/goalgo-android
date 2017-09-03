package com.algorithms.trees;

import com.algorithms.TreeNode;

/**
 * Use of O(1) space
 */

public class ConnectNodesAtSameLevel {

    public void connect (BinaryTree binaryTree) {

        if (binaryTree == null || binaryTree.getRootNode() == null) {
            return;
        }

        TreeNode<Integer> leftMostPtr = binaryTree.getRootNode();

        while (leftMostPtr != null) {

            TreeNode<Integer> temp = leftMostPtr;

            while (temp != null) {

                if (temp.getLeft() != null && temp.getRight() != null) {
                    temp.getLeft().setAuxPtr(temp.getRight());
                    temp.getRight().setAuxPtr(getNextRight(temp.getAuxPtr()));
                } else if (temp.getLeft() == null && temp.getRight() != null) {
                    temp.getRight().setAuxPtr(getNextRight(temp.getAuxPtr()));
                } else if (temp.getLeft() != null && temp.getRight()==null) {
                    temp.getLeft().setAuxPtr(getNextRight(temp.getAuxPtr()));
                }

                temp = temp.getAuxPtr();
            }

            if (leftMostPtr.getLeft()!= null) {
                leftMostPtr = leftMostPtr.getLeft();
            } else if (leftMostPtr.getRight() != null) {
                leftMostPtr = leftMostPtr.getRight();
            } else {
                leftMostPtr = leftMostPtr.getAuxPtr();
            }

        }


    }


    private TreeNode<Integer> getNextRight (TreeNode<Integer> t) {

        TreeNode<Integer> nextPtr = t.getAuxPtr();

        while (nextPtr != null) {
            if (nextPtr.getLeft()!= null) {
                return nextPtr.getLeft();
            }

            if (nextPtr.getRight() != null) {
                return nextPtr.getRight();
            }

            nextPtr = nextPtr.getAuxPtr();
        }

        return null;
    }
}
