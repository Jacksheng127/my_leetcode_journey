class MaximumAscendingSubarraySum {
    public int maxAscendingSum(int[] nums) {
        int res = 0, sum = nums[0];
        for(int i=1; i<nums.length; i++)
        {
            if(nums[i] > nums[i-1])
                sum += nums[i];
            else
            {
                res = Math.max(res, sum);
                sum = nums[i];
            }
        }
        return Math.max(res, sum);
    }

    public static void main(String[] args) {
        MaximumAscendingSubarraySum obj = new MaximumAscendingSubarraySum();
        System.out.println(obj.maxAscendingSum(new int[]{10,20,30,5,10,50}));
        System.out.println(obj.maxAscendingSum(new int[]{10,20,30,40,50}));
        System.out.println(obj.maxAscendingSum(new int[]{12,17,15,13,10,11,12}));
        System.out.println(obj.maxAscendingSum(new int[]{100,10,1}));
    }
}