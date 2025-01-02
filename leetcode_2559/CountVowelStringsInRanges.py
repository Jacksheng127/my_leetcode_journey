class CountVowelStringsInRanges:
    def vowelStrings(self, words: list[str], queries: list[list[int]]) -> list[int]:
        vowels = set("aeiou")
        prefix_cnt = [0] * (len(words) + 1)
        prev = 0
        
        for i, w in enumerate(words):
            if w[0] in vowels and w[-1] in vowels:
                prev += 1
            prefix_cnt[i + 1] = prev
        
        res = [0] * len(queries)
        for i, q  in enumerate(queries):
            l, r = q
            res[i] = prefix_cnt[r + 1] - prefix_cnt[l]
        
        return res

def main():
    v = CountVowelStringsInRanges()
    words = ["aba","bcb","ece","aa","e"]
    queries = [[0, 2], [1, 4], [1, 1]]
    print(v.vowelStrings(words, queries))
    
if __name__ == "__main__":
    main()

