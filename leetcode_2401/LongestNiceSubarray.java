package leetcode_2401;

class LongestNiceSubarray {
    public int longestNiceSubarray(int[] nums) {
        int left = 0, res = 0, cur = 0;

        for(int right = 0; right < nums.length; right++)
        {
            while((cur & nums[right]) != 0) // if the bitwise AND of cur and nums[right] is not 0
            {
                cur = cur ^ nums[left]; // we remove the left element (nums[left]) from cur
                left++;
            }
            res = Math.max(res, right - left + 1);
            cur = cur | nums[right]; // we add the right element (nums[right]) to cur. The reason is to include the influence of nums[r] in cur.
            /*
                We are not setting cur to 0000 when we remove nums[l]
                Instead, we are only "turning off" the bits contributed by nums[l]
                This is why when we remove nums[l], cur does not go to 0000, but rather retains other numbers' influence.
             */
        }
        return res;
    }

    public static void main(String[] args) {
        LongestNiceSubarray obj = new LongestNiceSubarray();
        int[] nums = {1,3,8,48,10};
        System.out.println(obj.longestNiceSubarray(nums));
    }
}