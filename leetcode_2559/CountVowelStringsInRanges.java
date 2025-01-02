package leetcode_2559;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class CountVowelStringsInRanges {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int n = words.length;
        int [] prefix = new int[n + 1];
        int prev = 0;

        for(int i=0; i<n; i++)
        {
            if(vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length() - 1)))
                prev++;
            prefix[i + 1] = prev;
        }

        int [] res = new int [queries.length];

        for(int i=0; i<queries.length; i++)
        {
            res[i] = prefix[queries[i][1] + 1] - prefix[queries[i][0]];
        }

        return res;
    }

    public static void main(String[] args) {
        CountVowelStringsInRanges sol = new CountVowelStringsInRanges();
        String [] words = {"aba","bcb","ece","aa","e"};
        int [][] queries = {{0, 2}, {1, 4}, {1, 1}};
        int [] res = sol.vowelStrings(words, queries);
        for(int i : res)
            System.out.print(i + " ");
    }
}