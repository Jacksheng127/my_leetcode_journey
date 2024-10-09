class MinimumNumberOfSwapToMakeTheStringBalanced:
    # Solution 1
    def min_swaps(self, s: str) -> int:
        count = 0
        for c in s:
            if c == '[':
                count += 1
            elif count > 0:
                count -= 1
        return (count + 1) // 2

    # Solution 2
    # def minSwaps(self, s: str) -> int:
    #     closeBracket, count = 0, 0
    #     for c in s:
    #         if c == '[':
    #             closeBracket -= 1
    #         else:
    #             closeBracket += 1
    #         count = max(count, closeBracket)
    #     return  (count + 1) // 2


def main():
    main_instance = MinimumNumberOfSwapToMakeTheStringBalanced()
    print(main_instance.min_swaps("][]["))


if __name__ == "__main__":
    main()
