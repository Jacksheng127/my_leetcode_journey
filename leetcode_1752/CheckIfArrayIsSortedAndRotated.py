class CheckIfArrayIsSortedAndRotated:
    def check(self, nums: list[int]) -> bool:
        n = len(nums)
        count = 1
        
        for i in range(1 * 2*n):
            if nums[(i - 1) % n] <= nums[i % n]:
                count += 1
            else:
                count = 1
            if count == n:
                return True

        return n == 1

def main():
    checkIfArrayIsSortedAndRotated = CheckIfArrayIsSortedAndRotated()
    print(checkIfArrayIsSortedAndRotated.check([3, 4, 5, 1, 2]))
   
if __name__ == "__main__":
    main()