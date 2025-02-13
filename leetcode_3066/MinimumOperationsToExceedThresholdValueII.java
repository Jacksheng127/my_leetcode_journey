package leetcode_3066;

import java.util.PriorityQueue;

class MinimumOperationsToExceedThresholdValueII{
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(); // Min Heap
        int ops = 0;

        for(int num : nums)
            pq.add((long) num);
        
        while(pq.peek() < k) // Smallest element is less than k
        {
            long x = pq.poll(); // Smallest element
            long y = pq.poll(); // 2nd smallest element
            long newValue = 2 * x + y;
            pq.add(newValue);
            ops++;
        }

        return ops;
    }

    public static void main(String[] args) {
        MinimumOperationsToExceedThresholdValueII obj = new MinimumOperationsToExceedThresholdValueII();
        int [] nums = {2,11,10,1,3};
        int k = 10;
        System.out.println(obj.minOperations(nums, k));
    }
}