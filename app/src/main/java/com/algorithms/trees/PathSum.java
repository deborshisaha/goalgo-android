package com.algorithms.trees;

import com.algorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    public ArrayList<ArrayList<TreeNode<Integer>>> paths (BinaryTree binaryTree, int sum){

        ArrayList<ArrayList<TreeNode<Integer>>> lists = pathUtil(binaryTree.getRootNode(), sum);

        return lists;
    }

    private ArrayList<ArrayList<TreeNode<Integer>>> pathUtil (TreeNode<Integer> root, int sum) {

        if (root == null) {
            return null;
        }

        if (root.getRight() == null && root.getLeft() == null) {

            if (root.data == sum) {
                ArrayList<TreeNode<Integer>> list = new ArrayList<>();
                ArrayList<ArrayList<TreeNode<Integer>>> arrayList = new ArrayList<>();
                list.add(root);
                arrayList.add(list);
                return arrayList;
            }

            return null;
        }

        ArrayList<ArrayList<TreeNode<Integer>>> leftPaths = pathUtil(root.getLeft(), sum - root.data);
        ArrayList<ArrayList<TreeNode<Integer>>> rightPaths =pathUtil(root.getRight(), sum - root.data);

        ArrayList<ArrayList<TreeNode<Integer>>> mergeLists = mergeList(leftPaths, rightPaths);

        if (mergeLists.size() > 0) {
            appendNodeToAllList( root, mergeLists);
        }

        return mergeLists;
    }

    private ArrayList<ArrayList<TreeNode<Integer>>> mergeList(ArrayList<ArrayList<TreeNode<Integer>>> leftPaths, ArrayList<ArrayList<TreeNode<Integer>>> rightPaths) {
        ArrayList<ArrayList<TreeNode<Integer>>> result = new ArrayList<ArrayList<TreeNode<Integer>>>();

        if (leftPaths != null) {
            result.addAll(leftPaths);
        }

        if (rightPaths != null) {
            result.addAll(rightPaths);
        }

        return result;
    }

    private void appendNodeToAllList( TreeNode<Integer> node, ArrayList<ArrayList<TreeNode<Integer>>> arrayList) {

        for (ArrayList<TreeNode<Integer>> list: arrayList) {
            list.add(node);
        }
    }

}
