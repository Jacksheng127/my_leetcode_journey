class MaximumXORForEachQuery{
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        // xor of all elements
        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }

        int n = nums.length;
        // res stores the query results
        int[] res = new int[n];
        // mask is the maximum number that can be represented by maximumBit
        int mask = (1 << maximumBit) - 1; // 2^maximumBit - 1

        // calculate the result of each query from the last element to the first element
        for (int i = n -1; i >= 0; i--){
            // the result of the query is the xor of all elements xor with the mask
            res[n - 1 - i] = xor ^ mask;
            // we remove the last element from the xor by using xor operation on the last element
            // as same element xor with itself is 0
            xor ^= nums[i];
        }
        return res;
    }
    public static void main(String[] args) {
        MaximumXORForEachQuery obj = new MaximumXORForEachQuery();
        int[] nums = {0,1,1,3};
        int maximumBit = 2;
        int[] res = obj.getMaximumXor(nums, maximumBit);
        for(int i : res){
            System.out.print(i + " ");
        }
    }
}