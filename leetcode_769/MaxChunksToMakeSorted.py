class MaxChunksToMakeSorted:
    def maxChunksToSorted(self, arr: list[int]) -> int:
        cur_max = -1
        res = 0
        
        for i, n in enumerate(arr):
            cur_max = max(cur_max, n)
            if cur_max == i:
                res += 1
        return res

def main():
    maxChunksToMakeSorted = MaxChunksToMakeSorted()
    print(maxChunksToMakeSorted.maxChunksToSorted([4,3,2,1,0])) # 1

if __name__ == "__main__":
    main()