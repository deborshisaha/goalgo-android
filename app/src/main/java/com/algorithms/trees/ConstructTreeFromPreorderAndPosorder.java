package com.algorithms.trees;

import com.algorithms.TreeNode;

/**
 * Created by dsaha on 9/2/17.
 */

public class ConstructTreeFromPreorderAndPosorder {

    private BinaryTree tree;

    public void construct (int[] pre, int[] post) {

        if (tree == null) {
            tree = new BinaryTree();
        }

        int lowPre = 0;
        int lowPost = 0;
        tree.setRoot(constructUtil(pre,post,lowPost, post.length - 1));
        lowPre++;
        int highPost = find(post, pre[lowPre], lowPost);

        tree.getRootNode().setLeft(constructUtil(pre,post, 0, highPost));
        lowPost = highPost + 1;
        highPost = post.length - 2;
        tree.getRootNode().setRight(constructUtil(pre, post, lowPost, highPost));



//        int lowPre = 0;
//        int num = pre[lowPre];
//        int postIndex = indexOfLeftTree(post, num);
//        int highPre = postIndex+lowPre;
//        TreeNode<Integer> node = constructUtil(pre, post, 1, pre.length - 1, 0, post.length - 2);
//        tree.getRootNode().setLeft(node);

    }

    private TreeNode<Integer> getNextChildNode (int[] pre, int startIndex) {
        if (startIndex+1 < pre.length) {
            TreeNode<Integer> node = new TreeNode<>(pre[startIndex+1]);
            return node;
        }
        return null;
    }

    private TreeNode<Integer> constructUtil (int[] pre, int[] post, int lowPost, int highPost) {

        TreeNode<Integer> node = new TreeNode<>(post[highPost]);
        return node;
    }

    private int find (int[] post, int num, int from) {

        for (int i = from; i < post.length; i++) {
            if (post[i] == num) {
                return i;
            }
        }

        return -1;
    }
}
