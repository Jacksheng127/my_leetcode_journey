package leetcode_2529;

class MaximumCountOfPositiveIntegerAndNegativeInteger{
    public int maximumCount(int[] nums) {
        // O(n) Approach
        // int negCount = 0, posCount = 0;
        // for(int num : nums)
        // {
        //     if(num < 0)
        //         negCount++;
        //     else if(num > 0)
        //         posCount++;
        // }
        // return Math.max(negCount, posCount);

        // O(logn) Approach using Binary Search
        int n = nums.length;
        // Find the fist index where value is >= 0 (give us negative count)
        int negCount = binarySearch(nums, 0);
        // Find the first index where value is >= 1 (give us positive count)
        int posCount = n - binarySearch(nums, 1);

        return Math.max(negCount, posCount);
        
    }

    public static void main(String[] args) {
        MaximumCountOfPositiveIntegerAndNegativeInteger obj = new MaximumCountOfPositiveIntegerAndNegativeInteger();
        int[] nums = {-2,-1,-1,1,2,3};
        System.out.println(obj.maximumCount(nums));
    }

    private int binarySearch(int[] nums, int target)
    {
        int left = 0, right = nums.length - 1, res = nums.length;
        while(left <= right)
        {
            int mid = (left + right) / 2 ;
            if(nums[mid] < target)
                left = mid + 1;
            else
            {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }
}