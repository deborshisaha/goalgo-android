package com.algorithms.trees;

import com.algorithms.TreeNode;

public class NodesWithNoSibling {

    private BinaryTree tree;

    public NodesWithNoSibling(BinaryTree t) {
        this.tree = t;
    }
    
    public NodesWithNoSibling() {}
    
    public static void driver() {
        System.out.println();
        NodesWithNoSibling obj = new NodesWithNoSibling();
        obj.printNoSiblingNodes(BinaryTree.simpleBT());
        obj.printNoSiblingNodes(BinaryTree.createNotBST());
    }

    public void printNoSiblingNodes() {
        x(this.tree.getRootNode());
    }

    public void printNoSiblingNodes(BinaryTree t) {
        if (t!=null) {
            x(t.getRootNode());
        }
    }

    private void x(TreeNode n) {
        if (n == null) {
            return;
        }

        if (n.getLeft() == null || n.getRight() == null) {

            if (n.getLeft() != null) {
                System.out.print(n.getLeft().data + " ");
            } else if (n.getRight() != null) {
                System.out.print(n.getRight().data + " ");
            }
        }

        x(n.getLeft());
        x(n.getRight());
    }
}
