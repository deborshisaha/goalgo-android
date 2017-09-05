package com.algorithms.trees;

import com.algorithms.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by dsaha on 9/4/17.
 */

public class PrintTwoBSTInSortedForm {

    Deque<TreeNode> q1 = new LinkedList<>();
    Deque<TreeNode> q2 = new LinkedList<>();

    public void print (BinaryTree t1, BinaryTree t2) {

        TreeNode<Integer> root1 = t1.getRootNode();
        TreeNode<Integer> root2 = t2.getRootNode();

        while ( true ) {

            if (root1!= null){
                q1.addFirst(root1);
                root1 = root1.getLeft();
                continue;
            }

            if (root2 != null) {
                q2.addFirst(root2);
                root2 = root2.getLeft();
                continue;
            }

            if (! q1.isEmpty()) {
                root1 = q1.peekFirst();
            }

            if (!q2.isEmpty()) {
                root2 = q2.peekFirst();
            }

            if (root1!= null && root2 != null) {
                if (root2.data >= root1.data) {
                    // Print root1
                    System.out.println(root1.data);
                    root1 = q1.pollFirst();
                    root1 = root1.getRight();
                    root2 = null;
                } else {
                    // Print root2
                    System.out.println(root2.data);
                    root2 = q2.pollFirst();
                    root2 = root2.getRight();
                    root1 = null;
                }
            } else if (root1 != null) {
                System.out.println(root1.data);
                root1 = q1.pollFirst();
                root1 = root1.getRight();
            } else if (root2 != null) {
                System.out.println(root2.data);
                root2 = q2.pollFirst();
                root2 = root2.getRight();
            }

            if (root1 ==null && root2 == null && q2.isEmpty() && q1.isEmpty()) {
                break;
            }

        }

    }
}
