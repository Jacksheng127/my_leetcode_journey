package leetcode_1358;

import java.util.HashMap;

class NumberOfSubstringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        // HashMap Approach
        int n = s.length();
        int left = 0;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int right = 0; right < n; right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            while(map.size() == 3) {
                res += (n - right);
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar) == 0)
                    map.remove(leftChar);
                left++;
            }
        }
        return res;

        // Array Approach
        // int n = s.length();
        // int left = 0;
        // int res = 0;
        // int[] count = new int[3];

        // for(int right = 0; right < n; right++) {
        //     count[s.charAt(right) - 'a']++;
            
        //     while(count[0] > 0 && count[1] > 0 && count[2] > 0) {
        //         res += (n - right);
        //         count[s.charAt(left) - 'a']--;
        //         left++;
        //     }
        // }
        // return res;
    }

    public static void main(String[] args) {
        NumberOfSubstringsContainingAllThreeCharacters obj = new NumberOfSubstringsContainingAllThreeCharacters();
        String s = "abcabc";
        System.out.println(obj.numberOfSubstrings(s));
    }
}