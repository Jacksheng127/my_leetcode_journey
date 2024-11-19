package leetcode_2461;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class MaximumSumOfDistinctSubarraysWithLengthK{
    public long maximumSubarraySum(int[] nums, int k) {
        // HashMap + Sliding window approach
        // long res = 0;
        // Map<Integer, Integer> prevIdx = new HashMap<>();
        // long curSum = 0;

        // int l = 0;

        // for(int r = 0; r<nums.length; r++)
        // {
        //     curSum += nums[r];
            
        //     // Used to store the index of the previous occurrence of the current element
        //     int i = prevIdx.getOrDefault(nums[r], -1);
            
        //     // If the current element has been seen before and the previous occurrence is within the current window
        //     // or the window size is greater than k, move the left pointer to the right
        //     // and remove the element that is sliding out of the window from the sum
        //     while(l <= i || r - l + 1 > k)
        //     {
        //         curSum -= nums[l];
        //         l++;
        //     }
            
        //     // If the window size is k, update the result to find the maximum sum
        //     if(r - l + 1 == k)
        //         res = Math.max(res, curSum);
            
        //     // Update the index of the current element as the current index only appears once
        //     prevIdx.put(nums[r], r);
        // }
        // return res;

        // HashSet + Sliding window approach
        long res = 0;
        Set<Integer> elements = new HashSet<>(); // Used to store the elements in the current window
        long curSum = 0;
        int l = 0;

        for(int r = 0; r<nums.length; r++)
        {
            // If the current element is not in the set, add it to the sum and the set
            if(!elements.contains(nums[r]))
            {
                curSum += nums[r];
                elements.add(nums[r]);

                // If the window size is k, update the result to find the maximum sum
                if (r - l + 1 == k)
                {
                    res = Math.max(res, curSum);
                    curSum -= nums[l];
                    // Remove the element from the set as it is sliding out of the window
                    elements.remove(nums[l]);
                    l++;
                }
            }
            // If the current element is already in the set or we have a duplicate element in the window
            else
            {
                // Move left pointer to right until nums[l] is equal to nums[r] which reached the duplicate element
                while(nums[l] != nums[r])
                {
                    curSum -= nums[l];
                    elements.remove(nums[l]);
                    l++;
                }
                // This is to move the left pointer to the right of the duplicate element which is same position as right pointer
                l++;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        MaximumSumOfDistinctSubarraysWithLengthK obj = new MaximumSumOfDistinctSubarraysWithLengthK();
        int [] nums = {1,5,4,2,9,9,9};
        int k = 3;
        System.out.println(obj.maximumSubarraySum(nums, k));
    }
}