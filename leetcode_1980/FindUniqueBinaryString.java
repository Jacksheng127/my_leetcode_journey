package leetcode_1980;

class FindUniqueBinaryString{
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < n; i++)
        {
           res.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return res.toString();
    }

    public static void main(String[] args) {
        FindUniqueBinaryString obj = new FindUniqueBinaryString();
        String [] nums = {"01", "10"};
        System.out.println(obj.findDifferentBinaryString(nums));
    }
}