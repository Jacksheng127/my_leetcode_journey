class  NumberOfWaysToSplitArray{
    public int waysToSplitArray(int[] nums) {
        long leftSum = 0, rightSum = 0;
        for(int n : nums)
            rightSum += n;
        int validSplit = 0;

        for(int i=0; i<nums.length - 1; i++)
        {
            leftSum += nums[i];
            rightSum -= nums[i];
            if(leftSum >= rightSum)
                validSplit++;
        }
        return validSplit;
    }

    public static void main(String[] args) {
        NumberOfWaysToSplitArray obj = new NumberOfWaysToSplitArray();
        int[] nums = {10,4,-8,7};
        System.out.println(obj.waysToSplitArray(nums));
    }
}