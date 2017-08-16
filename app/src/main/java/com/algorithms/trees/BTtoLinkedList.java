package com.algorithms.trees;

import com.algorithms.TreeNode;
import com.algorithms.linkedlist.LinkedList;

public class BTtoLinkedList {

    private final BinaryTree t;

    public BTtoLinkedList(BinaryTree t) {
        this.t = t;
    }

    public LinkedList toCLL() {

        TreeNode startNode = convert(this.t.getRootNode());
        TreeNode it = startNode;
        int i = 7;
        while (i != 0) {
            System.out.print(it.data + " ");
            it = it.getRight();
            i--;
        }

        return null;
    }

    private TreeNode convert(TreeNode n) {

        // If this has passed the leaf node
        if (n == null) {
            return null;
        }

        // This is the leaf node, point both pointers to self and pass it on
        if (n.getLeft() == null && n.getRight() == null) {
            n.setLeft(n);
            n.setRight(n);
            return n;
        }

        TreeNode left = convert(n.getLeft());
        TreeNode right = convert(n.getRight());

        n.setLeft(n);
        n.setRight(n);

        left = join(left, n);
        System.out.println("j 1--> "+left.data+" : "+left.getRight().data);
        
        left = join(left, right);
        System.out.println("--> "+right.data+" : "+right.getRight().data+" : "+right.getRight().getRight().data);
        System.out.println("j 2--> "+left.data+" : "+left.getRight().data);
        
        return left;
    }

    private TreeNode join(TreeNode r1, TreeNode r2) {
        if (r1 == null) {
            return r2;
        }

        if (r2 == null) {
            return r1;
        }
        //Node t1 = r2.left;
        TreeNode tail = r2.getLeft();

        //r1.left.right = r2;
        r1.getLeft().setRight(r2);

        // r2.left = r1.left;
        r2.setLeft(r2.getLeft());

        // r2.left = r1.left;
        r2.setLeft(r1.getLeft());

        //r1.left = r2.left; 
        r1.setLeft(tail);

        return r1;
    }

    public static void driver() {
        BinaryTree tree = new BinaryTree();
        tree.insert(1);
        tree.getRootNode().setLeft(new TreeNode(2));
        tree.getRootNode().setRight(new TreeNode(3));
        tree.getRootNode().getLeft().setLeft( new TreeNode(4));
        tree.getRootNode().getLeft().setRight( new TreeNode(5));

        tree.getRootNode().getRight().setLeft(new TreeNode(6));
        tree.getRootNode().getRight().setRight(new TreeNode(7));

        BTtoLinkedList obj = new BTtoLinkedList(tree);
        obj.toCLL();
    }
}
