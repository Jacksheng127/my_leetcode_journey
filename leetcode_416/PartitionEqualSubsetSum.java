package leetcode_416;

class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] dp = new boolean [target + 1];
        dp[0] = true;
        for(int num : nums)
        {
            for(int currSum = target; currSum >= num; currSum--)
            {
                dp[currSum] = dp[currSum] || dp[currSum - num];
                if(dp[target]) return true;
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum solution = new PartitionEqualSubsetSum();
        int[] nums = {1, 5, 11, 5};
        boolean result = solution.canPartition(nums);
        System.out.println(result); 
    }
}