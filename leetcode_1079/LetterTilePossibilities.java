package leetcode_1079;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class LetterTilePossibilities {
    // Appraoch 1: Backtracking with HashMap
    // public int numTilePossibilities(String tiles) {
    //     Map<Character, Integer> count = new HashMap<>();
    //     for(char c : tiles.toCharArray())
    //         count.put(c, count.getOrDefault(c, 0) + 1);
        
    //     return backtrack(count);
    // }

    // private int backtrack(Map<Character, Integer> count) {
    //     int res = 0;
    //     for(Map.Entry<Character, Integer> c : count.entrySet())
    //     {
    //         if(c.getValue() > 0)
    //         {
    //             count.put(c.getKey(), c.getValue() - 1);
    //             res+=1;
    //             res += backtrack(count);
    //             count.put(c.getKey(), c.getValue() + 1);
    //         }
    //     }
    //     return res;
    // }

    // Approach 2: Backtracking with Array and Memoization
    // public int numTilePossibilities(String tiles) {
    //     int [] count = new int[26];
    //     for(char c : tiles.toCharArray())
    //         count[c - 'A']++;
    //     return dfs(count, new HashMap<>());
    // }

    // private int dfs(int [] count, Map<String, Integer> memo) {
    //     String key = Arrays.toString(count);
    //     if(memo.containsKey(key))
    //         return memo.get(key);
        
    //     int res = 0;
    //     for(int i = 0; i < 26; i++)
    //     {
    //         if(count[i] > 0)
    //         {
    //             count[i]--;
    //             res++;
    //             res += dfs(count, memo);
    //             count[i]++;
    //         }
    //     }
    //     memo.put(key, res);
    //     return res;
    // }

    // Approach 3: Backtracking with Array and without Memoization
    public int numTilePossibilities(String tiles) {
        int [] count = new int[26];
        for(char c : tiles.toCharArray())
            count[c - 'A']++;
        return buildChar(count);
    }

    private int buildChar(int [] count) {
        int res = 0;
        for(int i = 0; i < 26; i++)
        {
            
            if(count[i] > 0)
            {
                count[i]--;
                res++;
                res += buildChar(count);
                count[i]++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LetterTilePossibilities obj = new LetterTilePossibilities();
        String tiles = "AAB";
        System.out.println(obj.numTilePossibilities(tiles));
    }

}