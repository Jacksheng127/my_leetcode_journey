package leetcode_1422;

class MaximumScoreAfterSplittingAString {
    public int maxScore(String s) {
        int zero = 0;
        int one = 0;
        int res = 0;

        for(char c : s.toCharArray())
            if(c == '1')
                one++;
        
        for(int i=0; i<s.length() -1; i++)
        {
            if(s.charAt(i) == '0')
                zero++;
            else
                one--;
            
            res = Math.max(res, zero + one);
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumScoreAfterSplittingAString sol = new MaximumScoreAfterSplittingAString();
        String s = "011101";
        System.out.println(sol.maxScore(s));
    }
}