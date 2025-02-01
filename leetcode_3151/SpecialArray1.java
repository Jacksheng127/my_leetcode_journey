package leetcode_3151;

class SpecialArray1 {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        // Approach 1: Using Bit Manipulation
        for (int i = 1; i < n; i++) 
        {
            if ((nums[i] & 1) == (nums[i-1] & 1)) 
                return false;
        }

        // // Approach 2: Using Modulo Operator
        // for (int i = 1; i < n; i++) 
        // {
        //     if (nums[i] % 2 == nums[i-1] % 2) 
        //         return false;
        // }

        return true;
    }

    public static void main(String[] args) {
        SpecialArray1 sa = new SpecialArray1();
        int[] nums = {2, 1, 4};
        System.out.println(sa.isArraySpecial(nums));
    }
}