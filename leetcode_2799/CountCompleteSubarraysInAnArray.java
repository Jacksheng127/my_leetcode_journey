package leetcode_2799;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class CountCompleteSubarraysInAnArray {
    public int countCompleteSubarrays(int[] nums) {
        // Brute Force Approach
        // int res = 0;
        // int totalDistinct = (int) Arrays.stream(nums).distinct().count();
        // int n = nums.length;
        
        // for(int i=0; i<n; i++)
        // {
        //     Set<Integer> currDistinct = new HashSet<>();
        //     for(int j=i; j<n; j++)
        //     {
        //         currDistinct.add(nums[j]);
        //         if(currDistinct.size() == totalDistinct)
        //         {
        //             res += (n - j);
        //             break;
        //         }
        //     }
        // }
        // return res;

        // Sliding Window Approach
        int left = 0, res = 0;
        int totalDistinct = (int) Arrays.stream(nums).distinct().count();
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while(map.size() == totalDistinct)
            {
                res += (n - i);
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0)
                    map.remove(nums[left]);
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountCompleteSubarraysInAnArray countCompleteSubarrays = new CountCompleteSubarraysInAnArray();
        int[] nums = {1, 3, 1, 2, 2};
        System.out.println(countCompleteSubarrays.countCompleteSubarrays(nums));
    }
}