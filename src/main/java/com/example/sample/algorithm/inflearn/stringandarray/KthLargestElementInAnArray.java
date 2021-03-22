package com.example.sample.algorithm.inflearn.stringandarray;

import java.util.Arrays;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{3,2,1,5,6,4} , 2));
        System.out.println(solve(new int[]{3,2,3,1,2,4,5,5,6} , 4));
    }

    public static int solve(int[] nums , int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

}
