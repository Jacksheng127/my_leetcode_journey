package leetcode_962;

import java.util.Stack;

class MaximumWidthRamp {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        // Build a decreasing stack of indices
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        int maxWidth = 0;

        // Iterate through the array in reverse
        for (int j = n - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                maxWidth = Math.max(maxWidth, j - stack.pop());
            }
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        MaximumWidthRamp m = new MaximumWidthRamp();
        System.out.println(m.maxWidthRamp(new int[] { 6, 0, 8, 2, 1, 5 }));
    }
}