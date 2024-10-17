class MinimumAddToMakeParenthesesValid:
    def min_add_to_make_valid(self, s: str) -> int:
        leftCount, rightCount = 0, 0
        for c in s:
            if c == '(':
                leftCount += 1
            elif leftCount > 0:
                leftCount -= 1
            else:
                rightCount += 1
        return leftCount + rightCount


def main():
    main_instance = MinimumAddToMakeParenthesesValid()
    print(main_instance.min_add_to_make_valid("())"))
    print(main_instance.min_add_to_make_valid("((("))


if __name__ == "__main__":
    main()