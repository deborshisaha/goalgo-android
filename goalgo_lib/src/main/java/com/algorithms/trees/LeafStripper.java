package com.algorithms.trees;

import com.algorithms.TreeNode;
import java.util.ArrayList;

public class LeafStripper {
    
    private final BinaryTree bt;

    public LeafStripper(BinaryTree t) {
        this.bt = t;
    }
    
    public ArrayList<TreeNode> strippedLeaves() {
        
        ArrayList<TreeNode> result = new ArrayList<>();
        
        strippedLeavesUtil(this.bt.getRootNode(),result);
        
        return result;
    }
    
    private void strippedLeavesUtil(TreeNode n, ArrayList<TreeNode> result) {
        
        if (n==null) {return;}
        
        if ( n.getLeft() == null && n.getRight() == null) {
            result.add(n);
            return;
        }
        
        strippedLeavesUtil(n.getLeft(), result);
        strippedLeavesUtil(n.getRight(), result);
    }
    
    public static void driver() {
        LeafStripper ls = new LeafStripper(BinaryTree.createNotBST());

        System.out.println("Leaf Stripper");
        ls.strippedLeaves().forEach((t) -> {
            System.out.print(t.data+" ");
        });
        System.out.println();
    }
}
