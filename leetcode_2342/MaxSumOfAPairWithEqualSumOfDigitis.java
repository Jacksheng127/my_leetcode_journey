import java.util.Arrays;

class MaxSumOfAPairWithEqualSumOfDigitis {
    public int maximumSum(int[] nums) {
        /*
            Why 82 as Array Size?
            Each number in nums is ≤ 10⁹, so:
            Max possible digit sum occurs when 999999999
            9+9+9+9+9+9+9+9+9 = **81**
            We use size 82 (0 to 81) for direct indexing
         */
        int [] mp = new int [82];
        Arrays.fill(mp, -1);
        int ans = -1;

        for(int num : nums)
        {
            int sumDigits = 0, temp = num;
            while(temp > 0)
            {
                sumDigits += temp % 10;
                temp /= 10;
            }
            if(mp[sumDigits] != -1)
            {
                ans = Math.max(ans, num + mp[sumDigits]);
            }
            mp[sumDigits] = Math.max(mp[sumDigits], num);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxSumOfAPairWithEqualSumOfDigitis obj = new MaxSumOfAPairWithEqualSumOfDigitis();
        int [] nums = {18,43,36,13,7};
        System.out.println(obj.maximumSum(nums));
    }
}