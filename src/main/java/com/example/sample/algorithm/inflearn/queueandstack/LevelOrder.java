package com.example.sample.algorithm.inflearn.queueandstack;

import java.util.*;

public class LevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(8);

        System.out.println(solve(root));
    }

    public static List<List<Integer>> solve(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            List<Integer> treeNodes = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode pollTreeNode = queue.poll();
                treeNodes.add(pollTreeNode.val);
                if(pollTreeNode.left != null) {
                    queue.offer(pollTreeNode.left);
                }
                if(pollTreeNode.right != null) {
                    queue.offer(pollTreeNode.right);
                }
            }
            System.out.println(treeNodes);
            result.add(treeNodes);
        }
        return result;
    }

    /*public static List<List<Integer>> solve2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);

        while(!nodeStack.isEmpty()) {
            List<Integer> treeNodes = new LinkedList<>();
            int size = nodeStack.size();

            for (int i = 0; i < size; i++) {
                TreeNode pollTreeNode = nodeStack.pop();
                treeNodes.add(pollTreeNode.val);
                if(pollTreeNode.left != null) {
                    nodeStack.push(pollTreeNode.left);
                }
                if(pollTreeNode.right != null) {
                    nodeStack.push(pollTreeNode.right);
                }
            }
            System.out.println(treeNodes);
            result.add(treeNodes);
        }
        return result;
    }*/
}
