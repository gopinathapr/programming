package com.prg.learning;

import java.util.HashSet;
import java.util.Set;

public class Indicators {
    public static void main(String[] args) {
        int count1 = new Indicators().getIndicators1(new int[]{1, 2, 2, 3, 3, 3, 2, 2, 4, 4, 4, 4, 5, 2, 1, 3, 3});
        int count2 = new Indicators().getIndicators2(new int[]{1, 2, 2, 3, 3, 3, 2, 2, 4, 4, 4, 4, 5, 2, 1, 3, 3});
        System.out.println("----> " + count1 + "   " + count2);
    }

    private int getIndicators1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int[] occ = new int[nums.length];
        occ[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                occ[i] = occ[i - 1] + 1;
            } else {
                if (occ[i - 1] == nums[i - 1]) {
                    set.add(nums[i - 1]);
                }
                occ[i] = 1;
            }
        }
        return set.size();
    }

    private int getIndicators2(int[] nums) {
        int indicator2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = i + 1;
            int end = i + i;
            if (end + 1 >= nums.length) {
                break;
            }
            if (nums[end + 1] != val) {
                indicator2++;
                for (int j = i; j <= end || j < nums.length; j++) {
                    if (nums[j] != val) {
                        indicator2--;
                        break;
                    }
                }
            }
        }
        return indicator2;
    }
}
