class  MaximumXORForEachQuery:
    def getMaximumXor(self, nums: list[int], maximumBit: int) -> list[int]:
        xor = 0
        for num in nums:
            xor ^= num
        n = len(nums)
        res = [] 
        mask = (1 << maximumBit) - 1 # 2^maximumBit - 1
        
        for i in reversed(nums):
            res.append(xor ^ mask)
            xor ^= i
        return res

def main():
    nums = [0,1,1,3]
    maximumBit = 2
    mxfeq = MaximumXORForEachQuery()
    print(mxfeq.getMaximumXor(nums, maximumBit))

if __name__ == "__main__":
    main()
        
        