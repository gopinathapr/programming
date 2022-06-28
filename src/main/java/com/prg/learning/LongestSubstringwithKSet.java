package com.prg.learning;

import java.util.*;

class GFG {

    static int maxNormalSubstring(String P,
                                  Set<Character> Q,
                                  int K, int N) {
        if (K == 0)
            return 0;
        int count = 0;
        int left = 0, right = 0;
        int ans = 0;
        while (right < N) {
            while (right < N && count <= K) {
                if (Q.contains(P.charAt(right))) {
                    if (count + 1 > K)
                        break;
                    else
                        count++;
                }
                right++;
                if (count <= K)
                    ans = Math.max(ans, right - left);
            }
            while (left < right) {
                left++;
                if (Q.contains(P.charAt(left - 1)))
                    count--;
                if (count < K)
                    break;
            }
        }
        return ans;
    }

    // Driver code
    public static void main(String[] args) {
        String P = "giraffe";
        Set<Character> Q = new HashSet<>();

        // Construction of set
        Q.add('a');
        Q.add('f');
        Q.add('g');
        Q.add('r');

        int K = 2;
        int N = P.length();

        // Output result
        System.out.println(maxNormalSubstring(P, Q,
                K, N));
    }
}

// This code is contributed by offbeat
