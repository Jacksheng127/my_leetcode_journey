package leetcode_2206;

class DivideArrayIntoEqualPairs{
    public boolean divideArray(int[] nums) {
        int [] freq = new int[501];

        for(int num : nums)
            freq[num]++;
        
        for (int i = 0; i < 501; i++)
        {
            if(freq[i] % 2 != 0)
                return false;
        }
        return true;    
    }

    public static void main(String[] args) {
        DivideArrayIntoEqualPairs obj = new DivideArrayIntoEqualPairs();
        int[] nums = {3,2,3,2,2,2};
        System.out.println(obj.divideArray(nums));
    }
}