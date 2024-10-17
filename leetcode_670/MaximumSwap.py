class MaximumSwap:
    def maximumSwap(self, num: int) -> int:
        num = list(str(num))
        
        max_digit = "0"
        max_i = 0
        swap_i = swap_j = -1 
        for i in (reversed(range(len(num)))):
            # find the max digit
            if num[i] > max_digit:
                max_digit = num[i]
                max_i = i
            # find the swap index
            elif num[i] < max_digit:
                swap_i, swap_j = i, max_i
        
        num[swap_i], num[swap_j] = num[swap_j], num[swap_i]

        return int("".join(num))

def main():
    main_instance = MaximumSwap()
    print(main_instance.maximumSwap(2736))

if __name__ == "__main__":
    main()