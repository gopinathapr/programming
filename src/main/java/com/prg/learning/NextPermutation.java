package com.prg.learning;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NextPermutation().findNextPermutation(new int[]{1, 3, 2})));
    }

    private int[] findNextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--; // Find 1st id i that breaks descending order
        if (i >= 0) {                           // If not entirely descending
            int j = nums.length - 1;              // Start from the end
            while (nums[j] <= nums[i]) j--;           // Find rightmost first larger id j
            swap(nums, i, j);                     // Switch i and j
        }
        reverse(nums, i + 1, nums.length - 1);
        return nums;
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while (i < j) swap(A, i++, j--);
    }
}
