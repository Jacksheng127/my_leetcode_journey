package leetcode_2938;

class SeperateBlackAndWhiteBalls {
    public long minimumSteps(String s) {
        // Solution 1
        int white = 0; // use to count the number of white balls
        long res = 0; // use to count the number of steps

        for (char c : s.toCharArray()) {
            if (c == '0')
                res += white;
            else // `c` is '1'
                white++;
        }
        return res;

        // Solution 2: use two pointers
        int left = 0;
        long res = 0;

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '0') {
                res += (right - left);
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeperateBlackAndWhiteBalls sbawb = new SeperateBlackAndWhiteBalls();
        String s = "100";
        System.out.println(sbawb.minimumSteps(s));
    }

}