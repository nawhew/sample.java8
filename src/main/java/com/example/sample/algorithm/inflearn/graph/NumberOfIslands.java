package com.example.sample.algorithm.inflearn.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid= {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println("dfs : " + numsIslands(grid, SearchWay.DFS));
        char[][] grid2= {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println("bfs : " + numsIslands(grid2, SearchWay.BFS));
    }

    enum SearchWay {BFS, DFS}

    public static int numsIslands(char[][] grid, SearchWay searchWay) {
        int islandCount = 0;
        for (int ix = 0; ix < grid.length; ix++) {

            for (int iy = 0; iy < grid[ix].length; iy++) {
                if(grid[ix][iy] == '1') {
                    System.out.println("x:" + ix + ", y:" + iy);
                    if(searchWay.name().equals("BFS")) {
                        searchApproachLandUsedQueue(grid, ix, iy);
                    }
                    if(searchWay.name().equals("DFS")) {
                        searchApproachLand(grid, ix, iy);
                    }

                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    /**
     * dfs
     */
    public static void searchApproachLand(char[][] grid, int x, int y) {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[x].length) {
            return;
        }
        if(grid[x][y] == '1') {
            System.out.println("found land!! x:" + x + ", y:" + y);
            grid[x][y] = 'x';
            searchApproachLand(grid, x-1, y);
            searchApproachLand(grid, x+1, y);
            searchApproachLand(grid, x, y-1);
            searchApproachLand(grid, x, y+1);
        }
    }

    static final int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    /**
     * bfs
     */
    public static void searchApproachLandUsedQueue(char[][] grid, int x, int y) {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[x].length || grid[x][y] != '1') {
            return;
        }
        Queue<int[]> locations = new LinkedList<>();
        locations.offer(new int[]{x, y});
        grid[x][y] = 'x';

        while(!locations.isEmpty()) {
            int[] location = locations.poll();
            System.out.println("found land!! x:" + location[0] + ", y:" + location[1]);
            for (int[] dir : dirs) {
                int xx = location[0] + dir[0];
                int yy = location[1] + dir[1];
                searchApproachLandUsedQueue(grid, xx, yy);
            }
        }
    }
}
