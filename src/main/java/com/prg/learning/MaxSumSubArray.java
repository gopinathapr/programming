package com.prg.learning;

public class MaxSumSubArray {
    public static void main(String[] args) {
        int result = new MaxSumSubArray().findSolution(new int[]{-3, -4, 5, -1, 2, -4, 6, -1});
        // int result = new MaxSumSubArray().findSolution(new int[]{-2, 1});
        System.out.println("Result " + result);
    }

    private int findSolutionMem(int[] nums) {
        if (nums.length == 1) return nums[0];
        int sum = nums[0];
        int[] mem = new int[nums.length];
        mem[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            mem[i] = mem[i - 1] > 0 ? mem[i - 1] + nums[i] : nums[i];
            sum = Math.max(mem[i], sum);
        }
        return sum;
    }

    private int findSolution(int[] nums) {
        if (nums.length == 1) return nums[0];
        int sum = nums[0];
        int sumSofar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sumSofar = sumSofar > 0 ? sumSofar + nums[i] : nums[i];
            sum = Math.max(sumSofar, sum);
        }
        return sum;
    }


}
