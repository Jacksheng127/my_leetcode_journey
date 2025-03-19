package leetcode_3191;

class MinimumOperationsToMakeBinaryArrayElementsEqualToOneI {
    public int minOperations(int[] nums) {
        int res = 0;
        int n = nums.length;

        /*
         * XOR
         * 0 ^ 0 = 0
         * 0 ^ 1 = 1
         * 1 ^ 0 = 1
         * 1 ^ 1 = 0
         */
        // Bitwise XOR Approach
        for(int i = 0; i < n-2; i++)
        {
            if(nums[i] == 0)
            {
                nums[i] ^= 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                res++;
            }
        }

        // External Flip Function Approach
        // for(int i = 0; i < n-2; i++)
        // {
        //     if(nums[i] == 0)
        //     {
        //         flip(nums, i);
        //         flip(nums, i+1);
        //         flip(nums, i+2);
        //         res++;
        //     }
        // }

        return (nums[n-1] == 0 || nums[n-2] == 0) ? -1 : res;
    }

    // private void flip(int [] nums, int i)
    // {
    //     if(nums[i] == 0)
    //         nums[i] = 1;
    //     else
    //         nums[i] = 0;
    // }

    public static void main(String[] args) {
        MinimumOperationsToMakeBinaryArrayElementsEqualToOneI obj = new MinimumOperationsToMakeBinaryArrayElementsEqualToOneI();
        int[] nums = {0,1,1,1,0,0};
        System.out.println(obj.minOperations(nums));
    }
}