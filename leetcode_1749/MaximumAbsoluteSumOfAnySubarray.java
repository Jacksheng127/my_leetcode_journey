package leetcode_1749;

class MaximumAbsoluteSumOfAnySubarray{
    public int maxAbsoluteSum(int[] nums) {
        // Kadane's Algorithm Approach
        int maxEnding = 0, minEnding = 0, maxSum = 0, minSum = 0;
        for(int a : nums)
        {
            maxEnding = Math.max(a, maxEnding + a);
            maxSum = Math.max(maxSum, maxEnding);
            minEnding = Math.min(a, minEnding + a);
            minSum = Math.min(minSum, minEnding);
        }
        return Math.max(maxSum, -minSum);

        // Prefix Sum Approach
        // int maxSum = 0, minSum = 0, sum = 0;
        // for(int a : nums)
        // {
        //     sum += a;
        //     if(sum > maxSum)
        //         maxSum = sum;
        //     if(sum < minSum)
        //         minSum = sum;
        // }
        // return Math.abs(maxSum - minSum);

    }

    public static void main(String[] args) {
        MaximumAbsoluteSumOfAnySubarray obj = new MaximumAbsoluteSumOfAnySubarray();
        System.out.println(obj.maxAbsoluteSum(new int[]{1, -3, 2, 3, -4}));
        System.out.println(obj.maxAbsoluteSum(new int[]{2, -5, 1, -4, 3, -2}));
    }
}