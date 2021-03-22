package com.example.sample.algorithm.inflearn.stringandarray;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(solve(matrix));

        int[][] matrix2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        System.out.println(solve(matrix2));
    }

    public static List<Integer> solve(int[][] matrix) {

        int rowEndIndex = matrix.length - 1;
        int colEndIndex = matrix[0].length - 1;
        int rowStartIndex = 0;
        int colStartIndex = 0;

        int matrixCount = matrix.length * matrix[0].length;
        List<Integer> result = new ArrayList<>();

        while (result.size() < matrixCount) {
            // goto right
            for (int i = colStartIndex; i <= colEndIndex; i++) {
                result.add(matrix[rowStartIndex][i]);
            }
            rowStartIndex++;
            if(result.size() >= matrixCount) break; // m x n 행렬에서 m과 n이 다를때 추가해주어야함. (아래도 같음)

            // goto down
            for (int i = rowStartIndex; i <= rowEndIndex; i++) {
                result.add(matrix[i][colEndIndex]);
            }
            colEndIndex--;
            if(result.size() >= matrixCount) break;

            // goto left
            for (int i = colEndIndex; i >= colStartIndex; i--) {
                result.add(matrix[rowEndIndex][i]);
            }
            rowEndIndex--;
            if(result.size() >= matrixCount) break;

            // goto up
            for (int i = rowEndIndex; i >= rowStartIndex; i--) {
                result.add(matrix[i][colStartIndex]);
            }
            colStartIndex++;
        }
        return result;
    }

}
