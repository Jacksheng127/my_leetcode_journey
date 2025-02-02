package leetcode_1752;

class CheckIfArrayIsSortedAndRotated {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 1;

        for(int i=1; i<2*n; i++)
        {
            if(nums[(i - 1) % n] <= nums[i % n])
                count++;
            else
                count = 1;
    
            if(count == n)
                return true;
        }

        return n == 1;
    }

    public static void main(String[] args) {
        CheckIfArrayIsSortedAndRotated obj = new CheckIfArrayIsSortedAndRotated();
        int[] nums = {3,4,5,1,2};
        System.out.println(obj.check(nums));
    }
}