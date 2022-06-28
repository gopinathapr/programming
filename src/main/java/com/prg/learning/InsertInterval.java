package com.prg.learning;

public class InsertInterval {

    public static void main(String[] args) {
        int[][] result = new InsertInterval().insert(new int[][]{}, new int[]{});
    }

    private int[][] insert(int[][] intervals, int[] newInterval) {

        int[][] res = new int[intervals.length + 1][2];
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        int i = 0;
        while (i < intervals.length && intervals[i][0] < newInterval[0] && intervals[i][0] < newInterval[1]) {
            i++;
        }

        if (intervals[i][0] <= newInterval[0] && intervals[i][1] <= newInterval[0]) {

        }

        return res;
    }
}
