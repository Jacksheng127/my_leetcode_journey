package leetcode_1295;

class FindNumberWithEvenNumberOfDigits {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums)
        {
            // Approach 1:  Convert to String
            // int length = String.valueOf(num).length();

            // Approach 2: Using Logarithm
            // int length = (int) Math.log10(num) + 1;
            
            // if(length % 2 == 0)
            //     count++;

            // Approach 3: Range Check
            if((num > 9 && num < 100) || (num > 999 && num < 10000) || (num > 99999 && num < 1000000))
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        FindNumberWithEvenNumberOfDigits findNumber = new FindNumberWithEvenNumberOfDigits();
        int[] nums = {12, 345, 2, 6, 7896};
        System.out.println(findNumber.findNumbers(nums));
    }
}