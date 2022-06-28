package com.prg.learning;

public class RotateArray {

    public static void main(String[] args) {
        new Solution().solution(new int[]{3, 8, 9, 7, 6}, 3);
    }
}

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8

        if (K == A.length) {
            return A;
        }

        int[] res = new int[A.length];
        int i = K - 1;
        int j = 0;
        while (j < A.length) {
            res[j++] = A[i];
            i++;
            if (i == A.length) {
                i = 0;
            }
        }


        return res;
    }
}
