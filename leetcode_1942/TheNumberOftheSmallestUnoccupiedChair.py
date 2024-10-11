import heapq


class TheNumberOftheSmallestUnoccupiedChair:
    def smallestChair(self, times: list[list[int]], targetFriend: int) -> int:
        index = [i for i in range(len(times))]
        index.sort(key=lambda x: times[x][0])

        used_chairs = []  # (leaving, chair)
        available_chairs = [i for i in range(len(times))]  # (chair)

        for i in index:
            arrive, leaving = times[i]
            while used_chairs and used_chairs[0][0] <= arrive:
                leaving, chair = heapq.heappop(used_chairs)
                heapq.heappush(available_chairs, chair)

            chair = heapq.heappop(available_chairs)
            heapq.heappush(used_chairs, (leaving, chair))

            if i == targetFriend:
                return chair


def main():
    main_instance = TheNumberOftheSmallestUnoccupiedChair()
    print(main_instance.smallestChair([[1, 4], [2, 3], [4, 6]], 1))


if __name__ == "__main__":
    main()
