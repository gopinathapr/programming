package com.prg.learning;


public class Desserts {

    public static void main(String[] args) {
        int result = new Desserts().closestCost(new int[]{2, 3}, new int[]{4, 5,  100}, 18);
        System.out.println("Result -> " + result);
    }

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {


        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < baseCosts.length; i++) {

            int remaining = target - baseCosts[i];
            int curr = 0;
            if (baseCosts[i] >= target) {
                curr = baseCosts[i];
            } else {
                int rem = findCost(remaining, toppingCosts, 0);
                curr = baseCosts[i] + remaining - rem;
            }

            closest = Math.min(closest, curr);
        }
        return closest;
    }

    private int findCost(int target, int[] t, int index) {

        if (target == 0) {
            return 0;
        }

        for (int i = index; i < t.length; i++) {

            int current = t[i];
            int r1 = findCost(target, t, i + 1);
            if (r1 == 0) {
                return 0;
            }
            if ((current * 2) < target) {
                int r2 = findCost(target - (current * 2), t, i + 1);
                if (r2 == 0) {
                    return 0;
                }
                int r3 = findCost(target - current, t, i + 1);
                return Math.min(Math.min(r2, r3), r1);
            }

            if (current <= target) {
                int r2 = findCost(target - current, t, i + 1);
                return Math.min(r1, r2);
            }
        }

        return target;
    }


}