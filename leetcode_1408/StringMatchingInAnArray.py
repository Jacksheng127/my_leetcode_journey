class StringMatchingInAnArray:
    def stringMatching(self, words: list[str]) -> list[str]:
        res = []
        
        # Brute force Approach
        # for i in range(len(words)):
        #     for j in range(len(words)):
        #         if i != j and words[i] in words[j]:
        #             res.append(words[i])
        #             break
        
        # Rabin-Karp Algorithm Approach
        for i in range(len(words)):
            for j in range(len(words)):
                if i != j and self.isSubstringRabinKarp(words[j], words[i]):
                    res.append(words[i])
                    break
        return res
    

    def isSubstringRabinKarp(self, text: str, pattern: str) -> bool:
        m, n = len(pattern), len(text)
        if m > n:
            return False  # Pattern cannot be a substring if it's longer than the text

        base = 26  # Base for rolling hash
        mod = int(1e9 + 7)  # Large prime to minimize hash collisions

        # Compute the hash of the pattern and the first window in the text
        pattern_hash = 0
        window_hash = 0
        base_power = 1  # base^(m-1)

        for i in range(m):
            pattern_hash = (pattern_hash * base + (ord(pattern[i]) - ord('a') + 1)) % mod
            window_hash = (window_hash * base + (ord(text[i]) - ord('a') + 1)) % mod
            if i < m - 1:
                base_power = (base_power * base) % mod

        # Slide the window over the text
        for i in range(n - m + 1):
            # Check if hashes match
            if pattern_hash == window_hash:
                # Confirm by checking the actual substring
                if text[i:i + m] == pattern:
                    return True

            # Update the hash for the next window
            if i < n - m:
                window_hash = (window_hash - (ord(text[i]) - ord('a') + 1) * base_power % mod + mod) % mod
                window_hash = (window_hash * base + (ord(text[i + m]) - ord('a') + 1)) % mod

        return False

def main():
    v = StringMatchingInAnArray()
    words = ["mass","as","hero","superhero"]
    print(v.stringMatching(words))
    
if __name__ == "__main__":
    main()
