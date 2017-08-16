package com.algorithms.trees;

import com.algorithms.TreeNode;

public class TreeFromPreorderAndInorder {

    private final int[] inorder;
    private final int[] preorder;

    public TreeFromPreorderAndInorder(int[] in, int[] pre) {
        this.inorder = in;
        this.preorder = pre;
    }

    private int preorderIndex = 0;

    public TreeNode<Integer> constructTree(int inStart, int inEnd) {

        if (inStart > inEnd) {
            return null;
        }

        TreeNode<Integer> tn = new TreeNode(this.preorder[preorderIndex++]);

        if (inStart == inEnd) {
            return tn;
        }

        int inIndex = search(tn.data);

        if (inIndex != -1) {
            tn.setLeft(constructTree(inStart, inIndex - 1));
            tn.setRight(constructTree(inIndex + 1, inEnd));
        }

        return tn;
    }

    private int search(int data) {
        int i = 0;
        while (i < this.inorder.length) {

            if (this.inorder[i] == data) {
                return i;
            }

            i++;
        }

        return -1;
    }
    
    public static void driver() {
        int[] pre = new int[]{1,2,4,5,3,6,7};
        int[] in = new int[]{4,2,5,1,6,3,7};
        TreeFromPreorderAndInorder obj = new TreeFromPreorderAndInorder(in,pre);
        TreeNode<Integer> root = obj.constructTree(0, in.length-1);
        BinaryTree tree = new BinaryTree(root);
        tree.printEachLevelInEachLine();
        
        // level order print
    }
}
