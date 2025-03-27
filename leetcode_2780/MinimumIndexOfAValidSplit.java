package leetcode_2780;

import java.util.List;

class MinimumIndexOfAValidSplit {
    public int minimumIndex(List<Integer> nums) {
        int candidate = -1, votes = 0, n = nums.size();

        // Step 1: Find the candidate for majority element (dominant element)
        for(int num : nums)
        {
            if(votes == 0)
                candidate = num;
            votes += (num == candidate) ? 1 : -1;
        }

        // Step 2: Count the total occurrences of candidate
        int totalFreq = 0;;
        for(int num : nums)
        {
            if(num == candidate)
                totalFreq++;
        }

        // Step 3: Find the minimum index for a valid split
        int prefixFreq = 0;
        for(int i=0; i<n; i++)
        {
            if(nums.get(i) == candidate)
                prefixFreq++;
            
            // Check the condition: (prefixFreq > (i + 1) / 2) && ((totalFreq - prefixFreq) > ((nums.size() - i - 1) / 2)
            // (prefixFreq > (i + 1) / 2) means to ensures that the dominant element is still dominant in the first (i + 1) elements) (more than half of the left side)
            // ((totalFreq - prefixFreq) > ((nums.size() - i - 1) / 2) means to ensures that the dominant element remains dominant in the remaining (suffix) part) (more than half of the right side)
            if((prefixFreq * 2 > i+1) && ((totalFreq - prefixFreq) * 2 > (n - i - 1)))
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        MinimumIndexOfAValidSplit obj = new MinimumIndexOfAValidSplit();
        List<Integer> nums = List.of(1,2,2,2);
        System.out.println(obj.minimumIndex(nums));
    }
}