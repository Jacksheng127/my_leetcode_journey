class SeperateBlackAndWhiteBalls:
    def min_steps(self, s: str) -> int:
        # Solution 1 
        # white, res = 0, 0
        # for c in s:
        #     if c == '0':
        #         res += white
        #     else:
        #         white += 1
        # return res
    
        # Solution 2
        left, res = 0, 0
        for right in range(len(s)):
            if s[right] == '0':
                res += (right - left)
                left += 1
        return res
    
def main():
    main_instance = SeperateBlackAndWhiteBalls()
    print(main_instance.min_steps("100"))
    
if __name__ == "__main__":
    main()