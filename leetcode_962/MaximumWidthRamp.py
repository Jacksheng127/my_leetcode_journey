class MaximumWidthRamp:
    def max_width_ramp(self, nums: list[int]) -> int:
        stack = []
        res = 0
        # Build a decreasing stack of indices
        for i, a in enumerate(nums):
            if not stack or nums[stack[-1]] > a:
                stack.append(i)

        # Iterate through the array in reverse
        for i in range(len(nums) - 1, -1, -1):
            while stack and nums[stack[-1]] <= nums[i]:
                res = max(res, i - stack.pop())
        return res


def main():
    main_instance = MaximumWidthRamp()
    print(main_instance.max_width_ramp([6, 0, 8, 2, 1, 5]))


if __name__ == "__main__":
    main()
