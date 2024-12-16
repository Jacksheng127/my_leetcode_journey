from heapq import heapify, heapreplace


class FinalArrayStateAfterKMultiplicationOperations1:
    def getFinalState(self, nums: list[int], k: int, multiplier: int) -> list[int]:
        # # Greedy approach
        # for _ in range(k):
        #     mins = nums.index(min(nums))
        #     nums[mins] *= multiplier
        # return nums
    
        # Min heap approach
        heap = [(num, i) for i , num in enumerate(nums)]
        heapify(heap)
        for _ in range(k):
            num, i = heap[0]
            heapreplace(heap, (num * multiplier, i))
        for x, i in heap:
            nums[i] = x
        return nums

def main():
    finalArrayStateAfterKMultiplicationOperations1 = FinalArrayStateAfterKMultiplicationOperations1()
    print(finalArrayStateAfterKMultiplicationOperations1.getFinalState([2,1,3,5,6], 5, 2)) # [32, 64, 96, 128]

if __name__ == "__main__":
    main()
    