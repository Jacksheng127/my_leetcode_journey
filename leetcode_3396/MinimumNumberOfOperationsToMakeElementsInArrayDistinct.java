package leetcode_3396;

class MinimumNumberOfOperationsToMakeElementsInArrayDistinct {
    public int minimumOperations(int[] nums) {
        int [] freq = new int[101];

        for(int i = nums.length - 1; i >= 0; i--)
        {
            freq[nums[i]]++;
            if(freq[nums[i]] > 1)
                return (i + 3) / 3;
        }

        return 0;
    }

    public static void main(String[] args) {
        MinimumNumberOfOperationsToMakeElementsInArrayDistinct solution = new MinimumNumberOfOperationsToMakeElementsInArrayDistinct();
        int[] nums = {1,2,3,4,2,3,3,5,7};
        int result = solution.minimumOperations(nums);
        System.out.println(result);
    }
}