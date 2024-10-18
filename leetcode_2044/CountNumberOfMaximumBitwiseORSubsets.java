package leetcode_2044;

class CountNumberOfMaximumBitwiseORSubsets{
    public void backtrack(int[] nums, int index, int currentOR, int maxOR, int[] count){
        // Base case
        if(currentOR == maxOR){
            count[0] += (1 << (nums.length - index));
            return;
        }

        // Recursive case
        // Include the current element
        for (int i=index; i<nums.length; i++){
            backtrack(nums, i + 1, currentOR | nums[i], maxOR, count);
        }
    }

    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;

        // Step 1: Compute the maximum OR value
        for(int num : nums){
            maxOR |= num;
        }

        // Step 2: Backtracking to find the number of subsets with maximum OR value
        int [] count = new int[1];
        backtrack(nums, 0, 0, maxOR, count);

        return count[0];
    }

    public static void main(String[] args){
        CountNumberOfMaximumBitwiseORSubsets obj = new CountNumberOfMaximumBitwiseORSubsets();
        int[] nums = {3, 2, 1, 5};
        System.out.println(obj.countMaxOrSubsets(nums));
    }

}