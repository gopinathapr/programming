package com.prg.learning;

import java.util.*;

public class KFrequentElements {
    public static void main(String[] args) {
        int[] ans = new KFrequentElements().kFrequentElements(new int[]{4, 1, -1, 2, -1, 2, 3}, 2);
        System.out.println(Arrays.toString(ans));
    }


    private int[] kFrequentElements(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        map.forEach((x, y) -> {
            if (buckets[y] == null) {
                buckets[y] = new ArrayList<>();
            }
            buckets[y].add(x);
        });
        List<Integer> ans = new ArrayList();
        for (int i = buckets.length - 1, j = 0; i >= 0; i--) {
            if (buckets[i] != null && !buckets[i].isEmpty()) {
                ans.addAll(buckets[i]);
                j++;
                if (j == k || ans.size() >= k) {
                    break;
                }
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
