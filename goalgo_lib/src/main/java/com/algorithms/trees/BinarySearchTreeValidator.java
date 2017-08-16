package com.algorithms.trees;

import com.algorithms.TreeNode;

public class BinarySearchTreeValidator {
    
    public static boolean isBST(BinaryTree tree) {
        boolean isBST = true;
        
        TreeNode root = tree.getRootNode();
        
        isBST = isBSTUtil(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        
        return isBST;
    }
    
    private static boolean isBSTUtil(TreeNode<Integer> node, Integer max, Integer min) {
        
        if (node==null) {
            return true;
        }
        
        boolean outOfRange = node.data > max || node.data <= min;

        if (outOfRange){
            return false;
        }
        
        return (isBSTUtil(node.getLeft(), node.data-1, min) &&
                isBSTUtil(node.getRight(), max, node.data));
    }
    
    public static void driver() {
        boolean isBSTOne = BinarySearchTreeValidator.isBST(BinarySearchTree.create());
        System.out.println("Tree "+(isBSTOne?"is":"is not")+ " a BST");
        boolean isBSTTwo = BinarySearchTreeValidator.isBST(BinaryTree.createNotBST());
        System.out.println("Tree "+(isBSTTwo?"is":"is not")+ " a BST");
        
        System.out.println("Tree "+(BinaryTree.createBalancedBT().isBalanced()?"is":"is not")+ " balanced");
        System.out.println("Tree "+(BinaryTree.createNotBST().isBalanced()?"is":"is not")+ " balanced");
    }
}
