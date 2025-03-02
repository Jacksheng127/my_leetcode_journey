package leetcode_2460;

class ApplyOperationsToAnArray {
    public int[] applyOperations(int[] nums) {
        // Two Pass Approach 
        // int n = nums.length;

        // for(int i=0; i<n-1; i++)
        // {
        //     if(nums[i] == nums[i+1])
        //     {
        //         nums[i] *= 2;
        //         nums[i+1] = 0;
        //     }
        // }

        // int [] res = new int[n];
        // int index = 0;
        // for(int i=0; i<n; i++)
        // {
        //     if(nums[i] != 0)
        //         res[index++] = nums[i];
        // }

        // return res;


        // One Pass Approach
        int n = nums.length;
        int [] res = new int[n];
        int count = 0;
        int i; 

        for(i=0; i < n - 1; i++)
        {   
            if(nums[i] != 0)
            {
                if(nums[i] == nums[i+1])
                {
                    res[count] = nums[i] * 2;
                    i++;
                }
                else
                    res[count] = nums[i];
                count++;
            }
        }

        // If the last element is not 0 and is not added to the result array
        if(i != n)
            res[count] = nums[n - 1];

        return res;
        
    }

    public static void main(String[] args) {
        ApplyOperationsToAnArray obj = new ApplyOperationsToAnArray();
        int[] res = obj.applyOperations(new int[]{1, 2, 2, 1, 1, 0});
        for(int a : res)
        {
            System.out.print(a + " ");
        }
    }
}