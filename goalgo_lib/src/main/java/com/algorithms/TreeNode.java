package com.algorithms;

public class TreeNode<T> {

    public T data;
    private TreeNode left;
    private TreeNode right;
    private Integer rank;
    private Integer id;
    
    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.id = (int)(Math.random()*1000);
    }

    public void setLeft(TreeNode tn) {
        this.left = tn;
    }

    public void setPrevious(TreeNode tn) {
        this.left = tn;
    }

    public void setRight(TreeNode tn) {
        this.right = tn;
    }

    public void setNext(TreeNode tn) {
        this.right = tn;
    }

    public void setParent(TreeNode n) {
        this.left = n;
    }

    public void setRank(Integer r) {
        this.rank = r;
    }

    public TreeNode getNext() {
        return this.right;
    }

    public Integer getRank() {
        return this.rank;
    }

    public TreeNode getPrevious() {
        return this.left;
    }

    public TreeNode getLeft() {
        return this.left;
    }

    public TreeNode getRight() {
        return this.right;
    }

    public TreeNode getParent() {
        return this.left;
    }

    public Integer getId() {
        return this.id;
    }
}
