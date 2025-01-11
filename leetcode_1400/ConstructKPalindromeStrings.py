from typing import Counter


class ConstructKPalindromeStrings:
    def canConstruct(self, s: str, k: int) -> bool:
        if k > len(s):
            return False

        # Count the frequency of each character
        freq = Counter(s)
        odd = 0
        for count in freq.values():
            if count % 2:
                odd += 1

        return odd <= k

def main():
    v = ConstructKPalindromeStrings()
    s = "annabelle"
    k = 2
    print(v.canConstruct(s, k))

if __name__ == "__main__":
    main()