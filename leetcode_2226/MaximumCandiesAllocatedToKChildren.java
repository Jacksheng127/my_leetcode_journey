package leetcode_2226;

import java.util.Arrays;

class MaximumCandiesAllocatedToKChildren {
    public int maximumCandies(int[] candies, long k) {
        long total = Arrays.stream(candies).asLongStream().sum();
        if(total < k)
            return 0;
        
        int left = 1, right = (int) (total / k);
        int res = 0;

        while(left <= right)
        {
            int mid = left + (right - left) / 2; // prevent potential overflow
            long count = 0;

            for(int candy : candies)
            {
                count += candy / mid; // count how many pile can we get for each k children
                if(count >= k) // if we can get more then or equal to k piles, no need to futher scan the rest of the array
                    break;
            }
            if(count >= k) // if we can get more then or equal to k piles, we can try to increase the pile size
            {
                res = mid;
                left = mid + 1;
            }
            else // if we can't get more then or equal to k piles, we need to decrease the pile size
                right = mid - 1;
        }

        return res;
    }

    public static void main(String[] args) {
        MaximumCandiesAllocatedToKChildren obj = new MaximumCandiesAllocatedToKChildren();
        int[] candies = {5,8,6};
        long k = 3;
        System.out.println(obj.maximumCandies(candies, k));
    }
}