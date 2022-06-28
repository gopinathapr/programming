package com.prg.learning;

import java.util.*;

public class PacificAtlantic {


    public static void main(String[] args) {
        List<List<Integer>> result = new PacificAtlantic().pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}});
        System.out.println(Arrays.toString(result.toArray()));
    }

    public List<List<Integer>> pacificAtlantic(int[][] m) {
        List<List<Integer>> result = new ArrayList<>();
        if (m.length == 0) {
            return result;
        }
        if (m.length == 1) {
            result.add(Arrays.asList(0,0));
            return result;
        }

        boolean[][] atlantic = new boolean[m.length][m[0].length];
        boolean[][] pacific = new boolean[m.length][m[0].length];

        for (int i = 0; i < m.length; i++) {
            atlantic[0][i] = true;
            atlantic[i][0] = true;
        }


        for (int i = 0; i < m.length; i++) {
            pacific[i][m.length - 1] = true;
            pacific[m[0].length - 1][i] = true;
        }

        atlantic = explore(m, atlantic);
        pacific = explore(m, pacific);

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(atlantic[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < pacific.length; i++) {
            for (int j = 0; j < pacific[0].length; j++) {
                System.out.print(pacific[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
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

    public boolean[][] explore(int[][] m, boolean[][] sea) {

        boolean[][] visited = new boolean[m.length][m[0].length];

        Queue<String> q = new LinkedList<>();

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (sea[i][j]) {
                    q.offer(i + "-" + j);
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            String s = q.poll();
            int r = Integer.parseInt(s.split("-")[0]);
            int c = Integer.parseInt(s.split("-")[1]);

            int[][] n = new int[][]{
                    {r + 1, c},
                    {r - 1, c},
                    {r, c + 1},
                    {r, c - 1},
            };

            for (int i = 0; i < n.length; i++) {
                int x = n[i][0];
                int y = n[i][1];
                if (x >= 0 && x < m.length && y >= 0 && y < m.length && !visited[x][y] && m[x][y] >= m[r][c]) {
                    q.offer(x + "-" + y);
                    visited[x][y] = true;
                }
            }
        }
        return visited;
    }
}