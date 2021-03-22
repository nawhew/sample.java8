package com.example.sample.algorithm.inflearn.stringandarray;

import java.util.Arrays;
import java.util.List;

public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public static int solve(int[] boxHeights) {

        int sum = 0;
        int[] leftHeight = new int[boxHeights.length];
        int[] rightHeight = new int[boxHeights.length];

        // get left
        for (int i = boxHeights.length - 1; i > 0; i--) {
            int leftTallest = boxHeights[i];
            for (int j = 0; j < i; j++) {
                leftTallest = Math.max(boxHeights[j], leftTallest);
            }
            leftHeight[i] = leftTallest;
        }

        // get right
        for (int i = 0 ; i < boxHeights.length; i++) {
            int rightTallest = boxHeights[i];
            for (int j = i + 1; j < boxHeights.length; j++) {
                rightTallest = Math.max(boxHeights[j], rightTallest);
            }
            rightHeight[i] = rightTallest;
        }

        for (int i = 0; i < boxHeights.length; i++) {
            sum += Math.min(leftHeight[i], rightHeight[i]) - boxHeights[i];
        }

        System.out.println(Arrays.toString(leftHeight));
        System.out.println(Arrays.toString(rightHeight));
        return sum;
    }
}
