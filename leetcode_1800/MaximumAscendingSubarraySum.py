class MaximumAscendingSubarraySum:
    def maxAscendingSum(self, nums: list[int]) -> int:
        res, sum = 0, nums[0]
        for i in range(1, len(nums)):
            if nums[i] > nums[i-1]:
                sum += nums[i]
            else:
                res = max(res, sum)
                sum = nums[i]
        
        return max(res, sum)
    
def main():
    maxAscendingSubarraySum = MaximumAscendingSubarraySum()
    print(maxAscendingSubarraySum.maxAscendingSum([10,20,30,5,10,50]))
    print(maxAscendingSubarraySum.maxAscendingSum([10,20,30,40,50]))
    print(maxAscendingSubarraySum.maxAscendingSum([12,17,15,13,10,11,12]))
    print(maxAscendingSubarraySum.maxAscendingSum([100,10,1]))

if __name__ == "__main__":
    main()