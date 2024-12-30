package leetcode_2466;

import java.util.Arrays;

class CountWaysToBuildGoodStrings {
    private static final int MOD = 1000000007;
    private int [] dp;

    // Top-down approach 
    // public int countGoodStrings(int low, int high, int zero, int one) {
    //     dp = new int[high + 1];
    //     Arrays.fill(dp, -1);
        
    //     return dfs(0, low, high, zero, one);

    // }

    // private int dfs(int length, int low, int high, int zero, int one) {
    //     if(length > high)
    //         return 0;
        
    //     if(dp[length] != -1)
    //         return dp[length];
        
    //     int count = length >= low ? 1 : 0;
    //     count = (count + dfs(length + zero, low, high, zero, one)) % MOD;
    //     count = (count + dfs(length + one, low, high, zero, one)) % MOD;

    //     dp[length] = count;
    //     return dp[length];
    // }

    // Bottom-up approach
    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new int [high + 1];
        dp[0] = 1; // Base case: there is only one way to build a string of length 0

        for(int i = 1; i <= high; i++)
        {
            if(i >= zero)
                dp[i] = (dp[i] + dp[i - zero]) % MOD;
            if (i >= one)
                dp[i] = (dp[i] + dp[i - one]) % MOD;
        }

        int result = 0;
        for(int i = low; i <= high; i++)
            result = (result + dp[i]) % MOD;
        
        return result;
    }

    public static void main(String[] args) {
        CountWaysToBuildGoodStrings sol = new CountWaysToBuildGoodStrings();
        int low = 3, high = 3, zero = 1, one = 1;
        System.out.println(sol.countGoodStrings(low, high, zero, one));
    }
}