package com.algorithms.trees;

import com.algorithms.TreeNode;
import com.algorithms.binarysearch.BinarySearch;

/**
 * Created by dsaha on 9/3/17.
 */

public class ConstructBSTFromPreOrder {

    public void construct(int[] pre) {

        BinarySearchTree bst = new BinarySearchTree();

        int startIndex = 0;
        int endIndex = pre.length -1 ;
        bst.setRoot(constructUtil(pre, startIndex, endIndex));
        bst.printEachLevelInEachLine();
    }

    private TreeNode<Integer> constructUtil (int[] pre, int startIndex,int endIndex) {

        if (startIndex > endIndex) {
            return null;
        }

        int rootValue = pre[startIndex];
        TreeNode<Integer> root = new TreeNode<>(rootValue);

        if (startIndex == endIndex){
            return root;
        }

        int partition = partition(rootValue, pre, (startIndex+1), endIndex);

        root.setLeft(constructUtil(pre, startIndex+1, partition));
        root.setRight(constructUtil(pre, partition+1, endIndex));

        return root;
    }

    private int partition (int pivot , int[] arr, int startIndex, int endIndex) {

        int i = startIndex;

        for (; i < endIndex;) {
            if (arr[i] < pivot) {
                i++;
            } else {
                break;
            }
        }
        System.out.println(" ----------------------- pivotPoint: "+(i-1));
        return i-1;
    }

}
