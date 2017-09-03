package com.algorithms.trees;

import com.algorithms.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class NextInOrderSuccessorIterator {

    Queue<TreeNode<Integer>> queue;

    public NextInOrderSuccessorIterator() {
        super();
        this.queue = new LinkedList<>();
    }

    public NextInOrderSuccessorIterator(BinaryTree tree) {
        this.queue =new LinkedList<>();
        process(tree.getRootNode());
    }

    public void setBinaryTree(BinaryTree tree) {

        if (this.queue == null) {
            this.queue = new LinkedList<>();
        }

        process(tree.getRootNode());
    }

    private void process(TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }

        process(rootNode.getLeft());
        this.queue.offer(rootNode);
        process(rootNode.getRight());
    }

    public TreeNode<Integer> next () {

        if (queue == null) {
            return null;
        }

        if (queue.isEmpty()) {
            return null;
        }

        return queue.poll();
    }

    public boolean hasNext() {
        return this.queue.peek() != null;
    }
}
