package leetcode_3264;

import java.util.PriorityQueue;

class FinalArrayStateAfterKMultiplicationOperations1
{
    public int[] getFinalState(int[] nums, int k, int multiplier)
    {
        // Greedy Approach
        int [] arr = new int [2];

        for(int i=0; i<k; i++)
        {
            arr = getMin(nums);
            nums[arr[1]] = arr[0] * multiplier;
        }
        return nums;
        
        // // Min Heap Approach
        // int n = nums.length;
        // PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[0]==b[0] ? a[1] - b[1] : a[0] - b[0]);

        // for(int i=0; i<n; i++)
        // {
        //     pq.add(new int[] {nums[i], i});
        // }

        // for(int i=0; i<k; i++)
        // {
        //     int[] arr = pq.poll();
        //     int val = arr[0];
        //     int idx = arr[1];
        //     nums[idx] = val * multiplier;
        //     pq.add(new int[] {nums[idx], idx});
        // }
        // return nums;
    }
    
    private int[] getMin(int[] nums)
    {
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] < min)
            {
                min = nums[i];
                idx = i;
            }
        }
        return new int[] {min, idx};
    }

    public static void main(String[] args) {
        FinalArrayStateAfterKMultiplicationOperations1 obj = new FinalArrayStateAfterKMultiplicationOperations1();
        int[] nums = {2,1,3,5,6};
        int k = 5;
        int multiplier = 2;
        int[] res = obj.getFinalState(nums, k, multiplier);
        for(int i=0; i<res.length; i++)
        {
            System.out.print(res[i] + " ");
        }
    }
}