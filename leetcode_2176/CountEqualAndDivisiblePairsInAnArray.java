package leetcode_2176;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CountEqualAndDivisiblePairsInAnArray {
    public int countPairs(int[] nums, int k) {
        int count = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        // Store the indices of each number in the map
        for(int i = 0; i<nums.length; i++)
        {
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }

        // Precompute the divisors of k
        List<Integer> divisors = new ArrayList<>();
        for(int d = 1; d*d <= k; d++)
        {
            if(k % d == 0)
            {
                divisors.add(d);
                if(d != k/d)
                    divisors.add(k/d);
            }
        }

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet())
        {
            Map<Integer, Integer> freq = new HashMap<>();
            List<Integer> indices = entry.getValue();
            for(int i : indices)
            {
                int gcdd = gcd(i, k);
                int need = k / gcdd;
                count += freq.getOrDefault(need, 0);
                for(int d : divisors)
                {
                    if(i % d == 0)
                        freq.put(d, freq.getOrDefault(d, 0) + 1);
                }
            }
        }
        return count;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}