package leetcode_3306;

import java.util.HashMap;

class CountOfSubstringsContainingEveryVowelAndKConsonantsII {
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private long atLeastK(String word, int k) {
        int n = word.length();
        int left = 0;
        long res = 0;
        int consonants = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char c = word.charAt(right);
            if (isVowel(c))
                map.put(c, map.getOrDefault(c, 0) + 1);
            else
                consonants++;

            while (map.size() == 5 && consonants >= k) {
                res += n - right;
                char leftChar = word.charAt(left);
                if (isVowel(leftChar)) {
                    map.put(leftChar, map.get(leftChar) - 1);
                    if (map.get(leftChar) == 0)
                        map.remove(leftChar);
                } else
                    consonants--;
                left++;
            }
        }

        return res;
    }

    public long countOfSubstrings(String word, int k) {
        return atLeastK(word, k) - atLeastK(word, k + 1);
    }

    public static void main(String[] args) {
        CountOfSubstringsContainingEveryVowelAndKConsonantsII obj = new CountOfSubstringsContainingEveryVowelAndKConsonantsII();
        String word = "ieaouqqieaouqq";
        int k = 1;
        System.out.println(obj.countOfSubstrings(word, k));
    }
}