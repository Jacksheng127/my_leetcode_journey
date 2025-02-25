package leetcode_1524;

class NumberOfSubarrayWithOddSum {
    private final int MOD = 1000000007;
    public int numOfSubarrays(int[] arr){
        // Prefix Sum Approach
        // long prefixSum = 0, oddCount = 0, evenCount = 1, res = 0;

        // for(int a : arr)
        // {
        //     prefixSum += a;
        //     if(prefixSum % 2 == 1)
        //     {
        //         res += evenCount;
        //         oddCount++;
        //     }
        //     else // prefixSum % 2 == 0
        //     {
        //         res += oddCount;
        //         evenCount++;
        //     }
        // }
        // return (int)(res % MOD);


        // Optimized Mathematical Approach with Prefix Sum
        long prefixSum = 0, oddCount = 0;
        for(int a : arr)
        {
            prefixSum += a;
            oddCount += (prefixSum % 2 );
        }
        oddCount += (arr.length - oddCount) * oddCount;
        return (int)(oddCount % MOD);
    }

    public static void main(String[] args) {
        NumberOfSubarrayWithOddSum obj = new NumberOfSubarrayWithOddSum();
        System.out.println(obj.numOfSubarrays(new int[]{1, 3, 5}));
        System.out.println(obj.numOfSubarrays(new int[]{2, 4, 6}));
        System.out.println(obj.numOfSubarrays(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }
}