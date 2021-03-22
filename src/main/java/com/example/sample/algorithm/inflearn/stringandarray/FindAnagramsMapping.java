package com.example.sample.algorithm.inflearn.stringandarray;

import java.util.Arrays;

public class FindAnagramsMapping {

    public static void main(String[] args) {
        int[] a = new int[] {12, 28, 46, 32, 50};
        int[] b = new int[] {50, 12, 32, 46, 28};
        System.out.println(Arrays.toString(anagramMappings(a, b)));
    }

    public static int[] anagramMappings(int[] A, int[] B) {
        int[] result = new int[A.length];
        for (int indexA = 0; indexA < A.length; indexA++) {
            int aUnit = A[indexA];

            for (int indexB = 0; indexB < B.length; indexB++) {
                if(aUnit == B[indexB]) {
                    result[indexA] = indexB;
                }
            }
        }
        return result;
    }
}
