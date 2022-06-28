package com.prg.learning;

import java.util.*;

public class WaterFlow {
    public static void main(String[] args) {
        List<List<Integer>> result = new WaterFlow().pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}});
        System.out.println(Arrays.toString(result.toArray()));
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

      /*  for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (i == 0 || j == 0) {
                    pacific[i][j] = true;
                }
                if (i == heights.length - 1 || j == heights[0].length - 1) {
                    atlantic[i][j] = true;
                }
            }
        }*/

        for (int i = 0; i < heights.length; i++) {
            pacific(pacific, heights, 0, i, Integer.MIN_VALUE, new HashSet<String>());
            pacific(pacific, heights, i, 0, Integer.MIN_VALUE, new HashSet<String>());
        }

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                System.out.print(pacific[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                System.out.print(atlantic[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (atlantic[i][j] && pacific[i][j]) {
                    result.add(Arrays.asList(i, j));
                    System.out.print("True ");
                }
                System.out.print("False ");
            }
            System.out.println();
        }
        return result;
    }

    private void pacific(boolean[][] pacific, int[][] heights, int r, int c, int value, Set<String> visited) {
        if ((r == 0 || c == 0) || c == heights[0].length - 1 || r == heights[0].length - 1) {
            return;
        }
        if (visited.contains(r + "-" + c)) {
            return;
        }

        visited.add(r + "-" + c);
        if (r == 0 || c == 0) {
            pacific[r][c] = true;
        }
        if (value <= heights[r][c]) {
            pacific[r][c] = true;
        }
        pacific(pacific, heights, r + 1, c, heights[r][c], visited);
        pacific(pacific, heights, r - 1, c, heights[r][c], visited);
        pacific(pacific, heights, r, c + 1, heights[r][c], visited);
        pacific(pacific, heights, r, c - 1, heights[r][c], visited);
    }

    private void atlantic(boolean[][] atlantic, int[][] heights, int r, int c) {
        if ((r == 0 || c == 0) && (c == heights[0].length - 1 || r == heights[0].length - 1)) {
            return;
        }
        if (atlantic[r][c]) {
            return;
        }
        atlantic[r][c] = true;
        if (r > 0 && heights[r - 1][c] >= heights[r][c]) atlantic(atlantic, heights, r - 1, c);

        if (r < heights.length - 1 && heights[r + 1][c] >= heights[r][c]) atlantic(atlantic, heights, r + 1, c);

        if (c > 0 && heights[r][c - 1] >= heights[r][c]) atlantic(atlantic, heights, r, c - 1);

        if (c < heights[0].length - 1 && heights[r][c + 1] >= heights[r][c]) atlantic(atlantic, heights, r, c + 1);
    }
}
