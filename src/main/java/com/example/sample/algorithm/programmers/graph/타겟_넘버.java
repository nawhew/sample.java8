package com.example.sample.algorithm.programmers.graph;

import java.util.LinkedList;
import java.util.Queue;

public class 타겟_넘버 {
    public static void main(String[] args) {
        타겟_넘버 test = new 타겟_넘버();
        System.out.println("answer : " + test.solution(new int[]{1,1,1,1,1}, 3));
        System.out.println("answer : " + test.solution(new int[]{2,2}, 0));
        System.out.println("answer : " + test.solution(new int[]{1,2,1,2}, 2));

//        Solution solution = new Solution();
//        System.out.println("answer : " + solution.solution(new int[]{1,1,1,1,1}, 3)); // 5
//        System.out.println("answer : " + solution.solution(new int[]{2,2}, 0)); // 2
//        System.out.println("answer : " + solution.solution(new int[]{1,2,1,2}, 2)); // 3
    }

    public int solution(int[] numbers, int target) {
        int answer = 0;

        // first dummy node
        TreeNode dumpHeaderNode = new TreeNode(0);

        // set nodes data
        for(int i = 0; i < numbers.length; i++) {
            int value = numbers[i];
            setNodes(dumpHeaderNode, value);
        }

        // found target
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(dumpHeaderNode);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if(node.leftNode != null) {
                nodes.offer(node.leftNode);
            }
            if(node.rightNode != null) {
                nodes.offer(node.rightNode);
            }
            if(node.leftNode == null && node.rightNode == null && node.val == target) {
                answer++;
            }
        }
        System.out.println();

        return answer;
    }

    public void setNodes(TreeNode node, int value) {
//        System.out.println("-------------------set node : " + node.val + ", value :" + value);
        System.out.print("= " + node.val + " =");
        if(node.rightNode != null && node.leftNode != null) {
            setNodes(node.leftNode, value);
            setNodes(node.rightNode, value);
            return;
        }
        node.leftNode = new TreeNode(node.val + value);
        node.rightNode = new TreeNode(node.val - value);
    }

}

class TreeNode {
    int val;
    TreeNode leftNode;
    TreeNode rightNode;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                "\n, leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }
}

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }
    int dfs(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, n + 1, sum + numbers[n], target)
                + dfs(numbers, n + 1, sum - numbers[n], target);
    }
}
