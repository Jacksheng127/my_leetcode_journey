class  NumberOfWaysToSplitArray:
    def waysToSplitArray(self, nums: list[int]) -> int:
        leftSum, rightSum = 0, sum(nums)
        validSplit = 0
        
        for i in range(len(nums) - 1):
            leftSum += nums[i]
            rightSum -= nums[i]
            if leftSum >= rightSum:
                validSplit += 1
        return validSplit
    
def main():
    v = NumberOfWaysToSplitArray()
    nums = [10, 4, -8, 7]
    print(v.waysToSplitArray(nums))

if __name__ == "__main__":
    main()