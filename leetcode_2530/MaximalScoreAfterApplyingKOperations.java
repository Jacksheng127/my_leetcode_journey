package leetcode_2530;

import java.util.PriorityQueue;

class MaximalScoreAfterApplyingKOperations{
    public long maxKElements(int[] nums, int k) {
        long res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for (int num : nums)
            pq.offer(num);
        
        while (!pq.isEmpty() && k > 0)
        {
            res += pq.peek();
            int top = (int)Math.ceil(pq.poll() / 3.0);
            pq.offer(top);
            k--;
        }
        return res;
    }

    public static void main(String[] args) {
        MaximalScoreAfterApplyingKOperations msako = new MaximalScoreAfterApplyingKOperations();
        int[] nums = {1,10,3,3,3};
        int k = 3;
        System.out.println(msako.maxKElements(nums, k));
    }
}