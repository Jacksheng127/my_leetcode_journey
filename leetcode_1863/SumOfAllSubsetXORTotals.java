package leetcode_1863;

class SumOfAllSubsetXORTotals{
    public int subsetXORSum(int[] nums) {
        // DFS / Recursive Appraoch 
        return dfs(nums, 0, 0);

        // Bit Math and Combinatorics Approach
        // int res = 0;
        // for(int n : nums)
        //     res = res | n;
        
        // return res * (int)Math.pow(2, nums.length - 1);
    }

    private int dfs(int[] nums, int index, int total)
    {
        if(index == nums.length)
            return total;

            // Include the current element in the XOR sum and Exclude the current element in the XOR sum
            return dfs(nums, index + 1, total ^ nums[index]) + dfs(nums, index + 1, total);
    }

    public static void main(String[] args) {
        SumOfAllSubsetXORTotals solution = new SumOfAllSubsetXORTotals();
        int[] nums = {5, 1, 6};
        int result = solution.subsetXORSum(nums);
        System.out.println("Sum of all subset XOR totals: " + result);
    }
}