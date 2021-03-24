package com.example.sample.algorithm.inflearn.graph;

public class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x){
        this.val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
