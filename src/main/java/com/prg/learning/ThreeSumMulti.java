package com.prg.learning;

import java.util.HashMap;

public class ThreeSumMulti {
    public static void main(String[] args) {
        int result = new ThreeSumMulti().findCount(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8);
        System.out.println(result);
    }

    private int findCount(int[] arr, int target) {
        int[] nums = new int[100];
        for (int value : arr) {
            nums[value]++;
        }

        long count = 0;
        for (int k = 100; k >= 0; k--) {
            for (int j = k; j >= 0; j--) {
                int i = target - k - j;
                if (i > j || i < 0) continue;

                long iCount = nums[i];
                long jCount = nums[j];
                long kCount = nums[k];
                long res = iCount * jCount * kCount;
                if (res == 0) {
                    continue;
                }
                if (i == j && j == k)
                    res = iCount * (jCount - 1) * (kCount - 2) / 6;   //Binomial Coefficients  c(n,k) = c*(c-1)*(c-2)/k!
                else if (i == j) res = iCount * (iCount - 1) / 2 * kCount;
                else if (j == k) res = iCount * (jCount * (jCount - 1) / 2);
                count += res;
            }
        }
        return (int) (count);
    }
}
