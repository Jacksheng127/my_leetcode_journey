class CheckIfNandItsDoubleExist:
    def checkIfExist(self, arr: list[int]) -> bool:
        seen = set()
        
        for num in arr:
            if (num * 2 in seen) or (num % 2 == 0 and num // 2 in seen):
                return True
            seen.add(num)
        return False
    
def main():
    arr = [10,2,5,3]
    cind = CheckIfNandItsDoubleExist()
    print(cind.checkIfExist(arr))

if __name__ == "__main__":
    main()