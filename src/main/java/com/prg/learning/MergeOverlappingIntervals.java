package com.prg.learning;

import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        // int[][] result = new MergeOverlappingIntervals().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        int[][] result = new MergeOverlappingIntervals().merge(new int[][]{{1, 4}, {0, 2}, {3, 5}});
        System.out.println();
        Arrays.stream(result).forEach(it -> System.out.print(Arrays.toString(it)));
    }


    private int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[][] result = new int[intervals.length][2];
        result[0] = intervals[0];
        int k = 0;
        for (int[] interval : intervals) {
            if (result[k][1] >= interval[0]) {
                result[k][1] = Math.max(result[k][1], interval[1]);
            } else {
                result[++k] = interval;
            }
        }
        int[][] r = new int[k + 1][2];
        System.arraycopy(result, 0, r, 0, k + 1);
        return r;
    }
}