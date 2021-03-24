package com.example.sample.algorithm.inflearn.graph;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIslands {
    public static void main(String[] args) {
        int[][] grid =
                {       {1,1,0,1,1},
                        {0,1,1,0,0},
                        {0,0,0,0,0},
                        {1,1,0,1,1},
                        {1,0,1,1,1},
                        {1,0,1,1,1}};

        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        int max = 0;
        for (int ix = 0; ix < grid.length; ix++) {

            for (int iy = 0; iy < grid[ix].length; iy++) {
                if(grid[ix][iy] == 1) {
                    max = Math.max(max, findApproachLand(grid, ix, iy, 0));
                }
            }
        }

        return max;
    }

    public static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static int findApproachLand(int[][] grid, int x, int y, int count) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[x].length || grid[x][y] != 1) {
            return count;
        }

        grid[x][y] = 0;
        count++;
        System.out.println("find land : " + x + " / " + y);

        for (int[] dir : dirs) {
            count = findApproachLand(grid, x + dir[0], y + dir[1], count);
        }
        return count;
    }

}
