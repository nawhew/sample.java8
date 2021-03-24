package com.example.sample.algorithm.inflearn.graph;

import lombok.val;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(4);

        recursive(root);
        System.out.println("recursive : " + max);

        System.out.println("queue : " + solveQueue(root));
        System.out.println("stack : " + solveStack(root));
    }

    static int max = 0;
    public static int recursive(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = recursive(root.left);
        int right = recursive(root.right);
        max = Math.max(left + right, max);
        System.out.println("val: " + root.val + ", max: " + max + ", left: " + left + ", right: " + right);
        return Math.max(left, right) + 1;
    }

    public static int solveQueue(TreeNode root) {
        int maxDepth = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            int nodeQueueSize = nodeQueue.size();
            for (int i = 0; i < nodeQueueSize; i++) {
                TreeNode currentNode = nodeQueue.poll();

                if(currentNode.left != null) {
                    nodeQueue.offer(currentNode.left);
                }
                if(currentNode.right != null) {
                    nodeQueue.offer(currentNode.right);
                }
            }
            maxDepth++;
        }
        return maxDepth;
    }

    public static int solveStack(TreeNode root) {
        int maxDepth = 0;
        TreeNode tempNode = null;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> levelStack = new Stack<>();
        nodeStack.push(root);
        levelStack.push(1);
        while(!nodeStack.isEmpty()) {
            TreeNode currentNode = nodeStack.pop();
            int level = levelStack.pop();
            maxDepth = Math.max(maxDepth, level);

            if(currentNode.right != null) {
                nodeStack.push(currentNode.right);
                levelStack.push(level + 1);
            }
            if(currentNode.left != null) {
                nodeStack.push(currentNode.left);
                levelStack.push(level + 1);
            }
        }
        return maxDepth;
    }
}
