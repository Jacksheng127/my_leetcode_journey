package leetcode_368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LargestDivisibleSubset{
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Approach 1: Bottom-Up DP with Sorting (Tabulation) 
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n]; // dp[i]: length of the largest divisible subset ending at index i
        int[] parent = new int[n]; // parent[i]: index of the previous element in the subset
        Arrays.fill(dp, 1); // Every element alone is a subset of length 1
        Arrays.fill(parent, -1); // No parent initially

        int maxLen = 1, maxIndex = 0;

        for(int i=1; i<n; i++)
        {
            for(int j=1; j<i; j++)
            {
                if(nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i])
                {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if(dp[i] > maxLen)
            {
                maxLen = dp[i];
                maxIndex = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        while(maxIndex != -1)
        {
            res.add(nums[maxIndex]);
            maxIndex = parent[maxIndex];
        }
        Collections.reverse(res);
        return res;

        // Approach 2: Top-Down DP with Memoization (Recursive DFS)
        // Arrays.sort(nums);
        // Map<Integer, List<Integer>> memo = new HashMap<>();
        // return dfs(nums, -1, memo); // prevIdx = -1 (meaning: no previous number yet)
    }

    private List<Integer> dfs(int[] nums, int prevIndex, Map<Integer, List<Integer>> memo)
    {
        if(memo.containsKey(prevIndex))
            return memo.get(prevIndex);
        
        List<Integer> bestList = new ArrayList<>();
        for(int i=prevIndex + 1; i<nums.length; i++)
        {
            if(prevIndex == -1 || nums[i] % nums[prevIndex] == 0)
            {
                List<Integer> currentList = dfs(nums, i, memo);
                if(currentList.size() > bestList.size())
                    bestList = currentList;
            }
        }
        List<Integer> res = new ArrayList<>();
        if(prevIndex != -1)
            res.add(nums[prevIndex]);
        res.addAll(bestList);
        memo.put(prevIndex, res);

        return res;
        
    }

    public static void main(String[] args) {
        LargestDivisibleSubset solution = new LargestDivisibleSubset();
        int[] nums = {1, 2, 4, 8};
        List<Integer> result = solution.largestDivisibleSubset(nums);
        System.out.println("Largest Divisible Subset: " + result);
    }
}