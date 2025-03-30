package leetcode_763;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        // HashMap Approach
        Map<Character, Integer> lastIndex = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }
        
        List<Integer> res = new ArrayList<>();
        int size = 0, end = 0;

        for(int i = 0; i < s.length(); i++) 
        {
            size++;
            end = Math.max(end, lastIndex.get(s.charAt(i)));
            if(i == end) {
                res.add(size);
                size = 0;
            }
        }
        return res;

        // Array Approach
        // int[] lastIndex = new int[26];

        // for(int i = 0; i < s.length(); i++) {
        //     lastIndex[s.charAt(i) - 'a'] = i;
        // }

        // List<Integer> res = new ArrayList<>();
        // int size = 0, end = 0;

        // for(int i = 0; i < s.length(); i++) 
        // {
        //     size++;
        //     end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
        //     if(i == end) {
        //         res.add(size);
        //         size = 0;
        //     }
        // }

        // return res;
    }

    public static void main(String[] args) {
        PartitionLabels obj = new PartitionLabels();
        String s = "ababcbacadefegdehijhklij";
        List<Integer> result = obj.partitionLabels(s);
        System.out.println(result); // Output: [9, 7, 8]
    }
}