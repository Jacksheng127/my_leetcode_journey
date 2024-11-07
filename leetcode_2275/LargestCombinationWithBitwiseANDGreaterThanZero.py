class LargestCombinationWithBitwiseANDGreaterThanZero:
    def largestCombination(self, candidates: list[int]) -> int:
        res = 0
        for i in range(32):
            count = sum(1 for candidate in candidates if candidate & (1 << i))
            res = max(res, count)
        return res

def main():
    candidates = [16,17,71,62,12,24,14]
    lcb = LargestCombinationWithBitwiseANDGreaterThanZero()
    print(lcb.largestCombination(candidates))

if __name__ == "__main__":
    main()
        