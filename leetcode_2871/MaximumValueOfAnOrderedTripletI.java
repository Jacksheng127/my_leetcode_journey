class MaximumValueOfAnOrderedTripletI {
    public long maximumTripletValue(int[] nums) {
        // O(n^3) Approach
        int n = nums.length;
        long res = 0;

        // O(n^3) Approach
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         for (int k = j + 1; k < n; k++) {
        //             res = Math.max(res, (long) ((nums[i] - nums[j]) * nums[k]));
        //         }
        //     }
        // }
        
        // O(n^2) Approach
        int left = nums[0];
        for(int i=1; i<n; i++)
        {
            if(nums[i] > left)
                left = nums[i];
            for(int j=i+1; j<n; j++)
                res = Math.max(res, (long)((left - nums[i]) * nums[j]));
        }

        return res;
    }

    public static void main(String[] args) {
        MaximumValueOfAnOrderedTripletI obj = new MaximumValueOfAnOrderedTripletI();
        int[] nums = {12, 6, 1, 2, 7 };
        System.out.println(obj.maximumTripletValue(nums));
    }
}