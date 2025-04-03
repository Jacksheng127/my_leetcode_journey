package leetcode_2874;

class MaximumValueOfAnOrderedTripletII {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long prefixMax = nums[0];
        long res = 0;
        long maxDiff = 0;
        
        for(int k = 1; k < n; k++)
        {
            res = Math.max(res, maxDiff * nums[k]);
            // Actually no matter we update prefixMax first or maxDiff first, the result is the same.

            // If we update prefixMax first and if the current element is greater than prefixMax, prefixMax will be updated, then the maxDiff will be 0
            // If we update maxDiff first and if current element is greater than prefixMax, maxDiff will remain the same as prefixMax - nums[k] will be negative value
            prefixMax = Math.max(prefixMax, nums[k]);
            maxDiff = Math.max(maxDiff, prefixMax - nums[k]);
        }

        return res;
    }

    public static void main(String[] args) {
        MaximumValueOfAnOrderedTripletII solution = new MaximumValueOfAnOrderedTripletII();
        int[] nums = {12,6,1,2,7};
        long result = solution.maximumTripletValue(nums);
        System.out.println("Maximum value of an ordered triplet: " + result);
    }
}