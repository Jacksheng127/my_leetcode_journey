class FindIfArrayCanBeSorted:
    def canSortArray(self, nums: list[int]) -> bool:
        cur_min, cur_max = nums[0], nums[0]
        prev_max = float("-inf")
        # count the number of 1s in the binary representation of the first element in nums
        prev_count = nums[0].bit_count()
        
        for n in nums:
            # count the number of 1s in the binary representation of the current element in nums
            cur_count = n.bit_count()
            
            # if the number of 1s in the binary representation of the current element is equal to the previous element
            if cur_count == prev_count:
                # update the current min and max
                cur_min = min(cur_min, n)
                cur_max = max(cur_max, n)
            # If the current min is less than the previous max, return False
            # this is because we can't sort the array in ascending order as the current min is less than the previous max
            # by default, our current min should be greater than the previous max
            elif cur_min < prev_max:
                return False
            else:
                # we move to the next group of elements / partition
                prev_max = cur_max
                cur_min, cur_max = n, n
                prev_count = cur_count
        
        return cur_min >= prev_max

def main():
    nums = [8,4,2,30,15]
    ca = FindIfArrayCanBeSorted()
    print(ca.canSortArray(nums))

if __name__ == "__main__":
    main()
        