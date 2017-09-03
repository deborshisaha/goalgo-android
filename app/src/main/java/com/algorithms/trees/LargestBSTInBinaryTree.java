package com.algorithms.trees;

import com.algorithms.TreeNode;

public class LargestBSTInBinaryTree {

    Result max = new Result();

    static class Result {

        int size;
        boolean isBST;
        TreeNode<Integer> root;

        Result() {
            this.size = Integer.MIN_VALUE;
            this.root = null;
            this.isBST = false;
        }

        Result(int size, TreeNode<Integer> node, boolean isBST) {
            this.size = size;
            this.root = node;
            this.isBST = isBST;
        }
    }

    public int find (BinaryTree binaryTree) {

        Result result = findUtil(binaryTree.getRootNode());
        return max.size;

    }

    private Result findUtil (TreeNode<Integer> node) {

        if ( node == null ) {
            Result result = new Result(0, null, true);

            if (result.size > max.size) {
                max = result;
            }

            return result;
        }

        Result left = findUtil(node.getLeft());
        Result right = findUtil(node.getRight());

        if (node.getRight() == null || node.getRight() == null) {

            Result result = new Result(1, node, true);

            if (result.size > max.size) {
                max = result;
            }

            return result;
        }

        Integer rightData = (Integer) node.getRight().data;
        Integer leftData = (Integer) node.getLeft().data;
        if (rightData >= node.data && leftData < node.data && left.isBST && right.isBST) {
            Result res = new Result(left.size+right.size+1, node, true);

            if (res.size > max.size) {
                max = res;
            }

            return res;
        }

        return new Result(left.size+right.size+1, node, false);
    }
}
