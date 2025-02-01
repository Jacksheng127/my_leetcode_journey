class SpecialArray1:
   def isArraySpecial(self, nums: list[int]) -> bool:
        n = len(nums)
        # Approach 1: Using Bit Manipulation
        for i in range(1, n):
            if nums[i] & 1 == nums[i-1] & 1:
                return False
        
        # Approach 2: Using Modulo Operator
        for i in range(1, n):
            if nums[i] % 2 == nums[i-1] % 2:
                return False
        return True
    
def main():
    specialArray1 = SpecialArray1()
    print(specialArray1.isArraySpecial([2, 1, 4]))

if __name__ == "__main__":
    main()
    