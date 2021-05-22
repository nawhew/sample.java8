package com.example.sample.algorithm.inflearn.stringandarray;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.*;

public class K_ClosestPointstoOrigin {

    public static void main(String[] args) {
        int[][] results = kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);
    }

    public static int[][] kClosest(int[][] inputPoints, int K) {
        Map<Integer, Point> points = new HashMap<>();

        // set distance and point
        for (int[] inputPoint : inputPoints) {
            Point point = new Point(inputPoint);
            points.put(point.calculateDistanceByZeroPoint(), point);
        }

        Integer max = points.keySet().stream().max((o1, o2) -> o1 - 02).get();

        return null;
    }
}

@Getter @AllArgsConstructor @ToString
class Point {
    private int x;
    private int y;

    public Point(int[] point) {
        this(point[0], point[1]);
    }

    public int calculateDistanceByZeroPoint() {
        return (int) (Math.pow(x, 2) + Math.pow(y, 2));
    }
}
