package leetcode_3356;

class ZeroArrayTransformationII {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int queryCount = 0, sum = 0;
        int[] diffArray = new int[n+1];

        for(int i=0; i<n; i++)
        {
            while(sum + diffArray[i] < nums[i])
            {
                queryCount++;
                if(queryCount > queries.length)
                    return -1;
                
                int left = queries[queryCount-1][0];
                int right = queries[queryCount-1][1];
                int value = queries[queryCount-1][2];

                if(right >= i)
                {
                    diffArray[Math.max(left, i)] += value;
                    if(right+1 < n)
                        diffArray[right+1] -= value;
                }
            }
            sum += diffArray[i];
        }

        return queryCount;
    }

    public static void main(String[] args) {
        ZeroArrayTransformationII obj = new ZeroArrayTransformationII();
        int[] nums = {2,0,2};
        int[][] queries = {{0,2,1},{0,2,1},{1,1,3}};
        System.out.println(obj.minZeroArray(nums, queries));
    }
}