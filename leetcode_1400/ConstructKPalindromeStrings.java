package leetcode_1400;

class ConstructKPalindromeStrings{
    public boolean canConstruct(String s, int k) {
        if (k > s.length()) return false;

        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int odd = 0;
        for (int f : freq) {
            if (f % 2 != 0) {
                odd++;
            }
        }
        return odd <= k;
    }

    public static void main(String[] args) {
        ConstructKPalindromeStrings ckps = new ConstructKPalindromeStrings();
        System.out.println(ckps.canConstruct("annabelle", 2));
        System.out.println(ckps.canConstruct("leetcode", 3));
    }
}