package com.example.sample.algorithm.inflearn.stringandarray;

public class MaximumSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4,2}));
    }

    public static int maxSubArray(int[] nums) {

        int max = nums[0];
        int newSum = nums[0];

        for (int index = 1; index < nums.length; index++) {
            newSum = Math.max(nums[index], newSum + nums[index]);
            max = Math.max(newSum, max);
        }
        return max;
    }
}
