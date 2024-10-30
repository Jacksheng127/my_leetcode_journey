package leetcode_1671;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Longest Increasing Subsequence (LIS) Solution from both directions
class MinimumNumberOfRemovalsToMakeMountainArray{
    // Helper function to calculate LIS lengths for each position
    private List<Integer> listLength(int[] nums)
    {
        // Start with first element
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        // Track LIS length ending at each position
        List<Integer> listlen = new ArrayList<>();
        for(int i=0; i<nums.length; i++)
            listlen.add(1);
        
        for(int i=1; i<nums.length; i++)
        {
            // If current element is larger than last LIS element, extend the sequence
            if(nums[i] > list.get(list.size() - 1))
                list.add(nums[i]);
            else
            {
                // Replace the smallest element that's >= current element
                // This maintains the potential for longer sequences
                int index = Collections.binarySearch(list, nums[i]);
                if(index < 0)
                    index = -(index+1);
                list.set(index, nums[i]);
            }
            // Store length of LIS up to current position
            listlen.set(i, list.size());
        }
        return listlen;
    }

    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;

        // Get LIS lengths from left to right (increasing part)
        List<Integer> list = listLength(nums);

        // Get LIS lengths from right to left (decreasing part)
        int[] reversed = new int[n];
        for(int i=0; i<n; i++)
            reversed[i] = nums[n-1-i];
        List<Integer> lds = listLength(reversed);
        Collections.reverse(lds);

        int removals = Integer.MAX_VALUE;

        // For each potential peak position
        for(int i=0; i<n; i++)
        {
            // Valid mountain needs both sides to have length > 1
            if(list.get(i) > 1 && lds.get(i) > 1)
            {
                // Calculate removals needed:
                // Total length - (increasing length + decreasing length - 1)
                // -1 because peak is counted twice
                removals = Math.min(removals, n+1-list.get(i)-lds.get(i));
            }
        }
        return removals;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,1,5,6,2,3,1};
        MinimumNumberOfRemovalsToMakeMountainArray obj = new MinimumNumberOfRemovalsToMakeMountainArray();
        System.out.println(obj.minimumMountainRemovals(nums));
    }
}