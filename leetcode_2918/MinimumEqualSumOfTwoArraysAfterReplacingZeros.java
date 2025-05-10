package leetcode_2918;

class MinimumEqualSumOfTwoArraysAfterReplacingZeros {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, zeros1 = 0, sum2 = 0, zeros2 = 0;
        for (int num : nums1) {
            if (num == 0)
                zeros1++;
            else
                sum1 += num;
        }
        for (int num : nums2) {
            if (num == 0)
                zeros2++;
            else
                sum2 += num;
        }

        long minSum1 = sum1 + zeros1;
        long minSum2 = sum2 + zeros2;

        // If both arrays don't have zeros
        if (zeros1 == 0 && zeros2 == 0)
            return sum1 == sum2 ? sum1 : -1;
        else if (zeros1 == 0) // If only nums1 has zeros
            return minSum2 <= sum1 ? sum1 : -1;
        else if (zeros2 == 0) // If only nums2 has zeros
            return minSum1 <= sum2 ? sum2 : -1;

        // If both arrays have zeros
        return Math.max(minSum1, minSum2);
    }

    public static void main(String[] args) {
        MinimumEqualSumOfTwoArraysAfterReplacingZeros solution = new MinimumEqualSumOfTwoArraysAfterReplacingZeros();
        int[] nums1 = { 3, 2, 0, 1, 0 };
        int[] nums2 = { 6, 5, 0 };
        System.out.println(solution.minSum(nums1, nums2));
    }
}