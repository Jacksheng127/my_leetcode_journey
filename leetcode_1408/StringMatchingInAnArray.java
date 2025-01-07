package leetcode_1408;

import java.util.ArrayList;
import java.util.List;

class StringMatchingInAnArray {
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> res = new ArrayList<>();

        // Brute Force Approach
        // for(int i=0; i<n; i++)
        // {
        //     for(int j=0; j<n; j++)
        //     {
        //         if(i != j && words[j].contains(words[i]))
        //         {
        //             res.add(words[i]);
        //             break;
        //         }
        //     }
        // }

        // Rabin-Karp Algorithm Approach
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isSubstringRabinKarp(words[j], words[i])) {
                    res.add(words[i]);
                    break;
                }
            }
        }

        return res;
    }

    private boolean isSubstringRabinKarp(String text, String pattern) 
    {
        int n = text.length();
        int m = pattern.length();

        if (m > n) return false; // Pattern cannot be a substring if it's longer than the text

        int base = 26; // Base for rolling hash (number of characters in the alphabet)  
        int mod = (int) 1e9 + 7; // Large prime number to reduce hash collisions

        // Compute the hash of the pattern and the first window in the text
        int patternHash = 0, windowHash = 0, basePower = 1;
        for (int i=0; i<m; i++)
        {
            patternHash = (patternHash * base + (pattern.charAt(i) - 'a' + 1)) % mod;
            windowHash = (windowHash * base + (text.charAt(i) - 'a' + 1)) % mod;
            if(i < m-1)
            {
                basePower = (basePower * base) % mod; // Precompute base^(m-1)
            }
        }

        // Slide the window over the text
        for (int i=0; i<=n - m; i++)
        {
            if (patternHash == windowHash)
            {
                // Hashes match, confirm by checking characters
                if(text.substring(i, i+m).equals(pattern))
                {
                    return true;
                }
            }
            
             // Update the hash for the next window
            if (i < n - m)
            {
                windowHash = (windowHash - (text.charAt(i) - 'a' + 1) * basePower % mod + mod) % mod;
                windowHash = (windowHash * base + (text.charAt(i + m) - 'a' + 1)) % mod;
            }
        }

        return false;
    }
    
    public static void main(String[] args) {
        StringMatchingInAnArray sm = new StringMatchingInAnArray();
        String[] words = {"mass","as","hero","superhero"};
        System.out.println(sm.stringMatching(words));
    }
}