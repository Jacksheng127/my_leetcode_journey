package leetcode_3392;

class CountSubarraysOfLengthThreeWithACondition {
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            int total = (nums[i] + nums[i+2]) * 2;
            if(total == nums[i+1])
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        CountSubarraysOfLengthThreeWithACondition countSubarrays = new CountSubarraysOfLengthThreeWithACondition();
        int[] nums = {1, 2, 1, 4, 1};
        System.out.println(countSubarrays.countSubarrays(nums));
    }
}