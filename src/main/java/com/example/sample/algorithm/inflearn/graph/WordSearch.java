package com.example.sample.algorithm.inflearn.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordSearch {
    public static void main(String[] args) {
        char[][] grid ={
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(solve(grid, "ABCCEED"));
        System.out.println(solve(grid, "SEE"));
        System.out.println(solve(grid, "ABCB"));
    }

    static Queue<Character> words = new LinkedList<>();
    public static boolean solve(char[][] grid, String word) {

        // set word
        char[] chars = word.toCharArray();
        for (char character : chars) {
            words.offer(character);
        }

        char startWord = words.poll();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == startWord) {
                    char[][] tempGrid = grid.clone();
                    searchApproachWord(tempGrid, i, j, startWord);
                    if(words.isEmpty()) {
                        return true;
                    } else {
                        resetWordQueue(chars);
                    }
                }
            }
        }
        if(words.isEmpty()) {
            return true;
        }
        return false;
    }

    private static void resetWordQueue(char[] chars) {
        words.clear();
        for (char character : chars) {
            words.offer(character);
        }
        char startWord = words.poll();
    }

    static final int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void searchApproachWord(char[][] grid, int x, int y, char word) {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[x].length || grid[x][y] == ' ') {
            return;
        }

        grid[x][y] = ' ';
        while (!words.isEmpty()) {
            Character polledWord = words.poll();
            System.out.println("find words!! " + polledWord + " / " + x + ", " + y);
            for (int[] dir : dirs) {
                searchApproachWord(grid, x + dir[0], y + dir[1], word);
            }
        }
    }
}
