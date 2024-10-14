import heapq
import math

class MaximalScoreAfterApplyingKOperations:
    def max_k_elements(self, nums: list[int], k: int) -> int:
        res = 0
        max_heap = [-n for n in nums]
        heapq.heapify(max_heap)

        while k:
            n = -heapq.heappop(max_heap)
            res += n
            k -= 1
            heapq.heappush(max_heap, -math.ceil(n / 3))
            
        return res
    
def main():
    main_instance = MaximalScoreAfterApplyingKOperations()
    print(main_instance.max_k_elements(nums = [1,10,3,3,3], k = 3))

if __name__ == "__main__":
    main()
       