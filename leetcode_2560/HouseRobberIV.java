package leetcode_2560;

import java.util.Arrays;

class HouseRobberIV {
    public int minCapability(int[] nums, int k) {
        int left = Arrays.stream(nums).min().getAsInt();
        int right = Arrays.stream(nums).max().getAsInt();
        int res = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2; // this is representing the capability to rob

            if (isValid(mid, nums, k)) { // if we can rob k houses with the given capability then we can try to decrease the capability since we are looking for the minimum capability
                res = mid;
                right = mid - 1;
            } else 
                left = mid + 1;
        }
        return res;
    }

    private boolean isValid(int capability, int[] nums, int k) {
        int i = 0;
        int count = 0;

        while (i < nums.length) {
            if (nums[i] <= capability) { // if the capability is greater than or equal to the house value then we can rob the house
                count++;
                i += 2; // we can't rob the adjacent houses
            } else
                i++;
            if (count == k) // Early exit if we have already robbed k houses
                break;
        }
        return count == k; 
    }

    public static void main(String[] args) {
        HouseRobberIV obj = new HouseRobberIV();
        int[] nums = { 2, 3, 5, 9 };
        int k = 2;
        System.out.println(obj.minCapability(nums, k));
    }
}