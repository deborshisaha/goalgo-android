package com.algorithms.trees;

import com.algorithms.TreeNode;

public class BinarySearchTree extends BinaryTree {

    private TreeNode<Integer> root;

    @Override
    public void insert(Integer data) {

        // If the root is null
        if (this.root == null) {
            this.root = new TreeNode(data);
            return;
        }

        TreeNode<Integer> node = this.root;
        TreeNode<Integer> prev = null;

        while (node != null) {
            prev = node;
            if (node.data > data) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }

        if (prev.data > data) {
            prev.setLeft(new TreeNode(data));
        } else {
            prev.setRight(new TreeNode(data));
        }

    }

    // Constructors
    public static void driver() {
        BinarySearchTree bst = BinarySearchTree.create();
        System.out.println("LCA: " + bst.lowestCommonAncestor(10, 12).data);
    }

    public static BinarySearchTree create() {

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(5);
        bst.getRootNode().setLeft(new TreeNode<Integer>(2));
        bst.getRootNode().getLeft().setLeft(new TreeNode<Integer>(1));
        bst.getRootNode().getLeft().setRight(new TreeNode<Integer>(3));
        bst.getRootNode().setRight(new TreeNode<Integer>(11));
        bst.getRootNode().getRight().setRight(new TreeNode<Integer>(12));
        bst.getRootNode().getRight().setLeft(new TreeNode<Integer>(10));

        return bst;
    }

    public TreeNode lowestCommonAncestor(int n1, int n2) {

        return lowestCommonAncestorUtil(BinarySearchTree.create().getRootNode(), n1, n2);
    }

    public TreeNode lowestCommonAncestorUtil(TreeNode<Integer> t, int n1, int n2) {

        if (t == null) {
            return null;
        }

        if (t.data >= n1 && t.data >= n2) {
            return lowestCommonAncestorUtil(t.getLeft(), n1, n2);
        } else if (t.data < n1 && t.data < n2) {
            return lowestCommonAncestorUtil(t.getRight(), n1, n2);
        } else {
            return t;
        }
    }

    public TreeNode getRootNode() {
        return root;
    }
}
