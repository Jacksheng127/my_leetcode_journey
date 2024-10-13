class DivideIntervalsIntoMinimumNumberOfGroups:
    def min_number_of_groups(self, intervals: list[list[int]]) -> int:
        start, end = [], []
        for left, right in intervals:
            start.append(left)
            end.append(right)

        start.sort()
        end.sort()

        # Solution 1
        j, group_count = 0, 0
        for st in start:
            if st > end[j]:
                j += 1
            else:
                group_count += 1
        return group_count

        # Solution 2
        # i, j = 0, 0
        # res = 0
        # while i < len(intervals):
        #     if start[i] <= end[j]:
        #         i += 1
        #     else:
        #         j += 1
        #     res = max(res, i-j)
        # return res


def main():
    main_instance = DivideIntervalsIntoMinimumNumberOfGroups()
    print(main_instance.min_number_of_groups([[5, 10], [6, 8], [1, 5], [2, 3], [1, 10]]))


if __name__ == "__main__":
    main()
