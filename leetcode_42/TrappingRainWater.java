package leetcode_42;

class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        int leftMax = height[left], rightMax = height[right];

        while(left < right)
        {
            if(leftMax < rightMax)
            {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
            }
            else
            {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappingRainWater.trap(height));
    }
}