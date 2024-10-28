package leetcode_2501;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class LongestSquareStreakInAnArray{
    public int longestSquareStreak(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        int res = -1;

        for (int num : nums)
        {
            int sqrt =(int) Math.sqrt(num);
            if (sqrt * sqrt == num && map.containsKey(sqrt))
            {
                map.put(num, map.get(sqrt) + 1);
                res = Math.max(res, map.get(num));
            }
            else
            {
                map.put(num, 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,6,16,8,2};
        LongestSquareStreakInAnArray obj = new LongestSquareStreakInAnArray();
        System.out.println(obj.longestSquareStreak(nums));
    }
}