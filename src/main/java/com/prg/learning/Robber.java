package com.prg.learning;

import java.util.Arrays;

public class Robber {
    public static void main(String[] args) {
        System.out.println(new Robber().rob(new int[]{6, 3, 10, 8, 2, 10, 3, 5, 10, 5, 3}));
    }

    private int rob(int[] nums) {
        int[] mem = new int[nums.length];

        if (nums.length == 1) {
            return nums[0];
        }
        mem[0] = nums[0];
        mem[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {

            System.out.println("Max Of " + nums[i - 1] + "," + nums[i] + "+" + mem[i - 2]);
            mem[i] = Math.max(mem[i - 1], nums[i] + mem[i - 2]);
        }
        System.out.println(Arrays.toString(mem));
        return Math.max(mem[nums.length - 2], mem[nums.length - 1]);
    }
}
