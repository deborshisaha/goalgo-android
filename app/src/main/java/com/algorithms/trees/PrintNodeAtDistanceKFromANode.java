/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithms.trees;

import com.algorithms.TreeNode;

/**
 *
 * @author dsaha
 */
public class PrintNodeAtDistanceKFromANode {

    public static void driver() {
        BinaryTree tree = BinaryTree.simpleBT();
        PrintNodeAtDistanceKFromANode obj = new PrintNodeAtDistanceKFromANode(tree);
        obj.printNodesAtDistance(2, 1);
    }

    BinaryTree t;

    public PrintNodeAtDistanceKFromANode(BinaryTree t) {
        this.t = t;
    }

    public void printNodesAtDistance(int k, int sI) {
        printNodesAtDistanceUtil(k, sI, this.t.getRootNode());
    }

    public int printNodesAtDistanceUtil(int k, int searchItem, TreeNode<Integer> n) {

        if (k < 0) {
            return 0;
        }

        if (n == null) {
            return k;
        }

        if (k == 0) {
            System.out.println(n.data);
            return 0;
        }

        if (searchItem != n.data) {
            int dL = printNodesAtDistanceUtil(k, searchItem, n.getLeft());
            int dR = printNodesAtDistanceUtil(k, searchItem, n.getRight());

            if (dL == 0) {
                System.out.println(n.data);
            } else if (dL != k) {
                findInChild(dL - 1, n.getRight());
                return dL - 1;
            }

            if (dR == 0) {
                System.out.println(n.data);
            } else if (dR != k) {
                findInChild(dR - 1, n.getLeft());
                return dR - 1;
            }

        } else if (n.data == searchItem) {
            findInChild(k, n);
            return k - 1;
        }

        return k;
    }

    private void findInChild(int k, TreeNode<Integer> n) {

        if (n == null) {
            return;
        }

        if (k == 0) {
            System.out.print(n.data);
        } else {
            findInChild(k - 1, n.getLeft());
            findInChild(k - 1, n.getRight());
        }
    }
}
