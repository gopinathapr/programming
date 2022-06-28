package com.prg.learning;

/*
https://leetcode.com/problems/island-perimeter/
 */
public class IcelandPerimeter {
    public static void main(String[] args) {
        int result = new IcelandPerimeter().findPerimeterLen(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}});
        System.out.println("Result -> " + result);
    }

    private int findPerimeterLen(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) count++; // UP
                    if (j == 0 || grid[i][j - 1] == 0) count++; // LEFT
                    if (i == r - 1 || grid[i + 1][j] == 0) count++; // DOWN
                    if (j == c - 1 || grid[i][j + 1] == 0) count++; // RIGHT
                }
            }
        }
        return count;
    }
}
