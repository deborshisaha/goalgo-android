package com.algorithms.trees;

import com.algorithms.TreeNode;

public class LargestIndependentSetInTree {

    Integer max = Integer.MIN_VALUE;

    public static class LISNode extends TreeNode<Integer> {

        int LISSize = 0;

        public int getLISSize() {
            return LISSize;
        }

        public LISNode(Integer data) {
            super(data);
            this.LISSize = 0;
        }

        public LISNode(TreeNode<Integer> treeNode, int size) {
            super(treeNode.data);
            this.setLeft(treeNode.getLeft());
            this.setRight(treeNode.getRight());
            this.LISSize = size;
        }
    }

    public int find (BinaryTree t) {
        max = Integer.MIN_VALUE;
        int size = find( new LISNode(t.getRootNode(),0));

        return size;
    }

    private int find (LISNode treeNode) {

        if (treeNode == null) {
            return 0;
        }

        if (treeNode.getLISSize() != 0) {
            return treeNode.getLISSize();
        }

        if (treeNode.getLeft() == null && treeNode.getRight() == null) {
            treeNode.LISSize = 1;
            return treeNode.getLISSize();
        }

        // get count of LIS of children
        int childrenLISCount = 0;

        if (treeNode.getLeft() == null) {
            childrenLISCount = find((LISNode) treeNode.getRight());
        } else if  (treeNode.getRight() == null){
            childrenLISCount = find((LISNode) treeNode.getLeft());
        } else {
            childrenLISCount = find((LISNode) treeNode.getLeft()) + find((LISNode) treeNode.getRight());
        }

        int leftGrandChild = 0;
        int rightGrandChild = 0;

        if (treeNode.getRight() == null) {
            rightGrandChild = 0;
        } else {
            rightGrandChild = find((LISNode) treeNode.getRight().getRight());
            rightGrandChild += find((LISNode) treeNode.getRight().getLeft());
        }

        if (treeNode.getLeft() == null) {
            leftGrandChild = 0;
        } else {
            leftGrandChild = find((LISNode) treeNode.getLeft().getLeft());
            leftGrandChild += find((LISNode) treeNode.getLeft().getRight());
        }

        int grandChildrenLISCount = leftGrandChild + rightGrandChild +1;

        treeNode.LISSize = Math.max(grandChildrenLISCount, childrenLISCount);
        max = Math.max(treeNode.getLISSize(), max);

        return treeNode.getLISSize();
    }

}
