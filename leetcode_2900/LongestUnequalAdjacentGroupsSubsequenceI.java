package leetcode_2900;

import java.util.ArrayList;
import java.util.List;

class LongestUnequalAdjacentGroupsSubsequenceI {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);

        for(int i = 1; i < words.length; i++) {
            if(groups[i] != groups[i-1])
                result.add(words[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        LongestUnequalAdjacentGroupsSubsequenceI solution = new LongestUnequalAdjacentGroupsSubsequenceI();
        String[] words = {"e", "a", "b"};
        int[] groups = {0, 0, 1};
        List<String> result = solution.getLongestSubsequence(words, groups);
        System.out.println(result); // Output: [a, b, c, d]
    }
}