from math import sqrt


class MinimumTimeToRepairCars:
    def repairCars(self, ranks: list[int], cars: int) -> int:
        
        def count_repaired(time):
            count = 0
            for rank in ranks:
                count += int(sqrt(time / rank))
            return count
        
        left = 1
        right = min(ranks) * cars * cars
        res = -1
        
        while left <= right:
            mid = left + (right - left) // 2
            count = count_repaired(mid)
            if count >= cars:
                res = mid
                right = mid - 1
            else:
                left = mid + 1
        return res
    
def main():
    ranks = [4, 3, 2, 1]
    cars = 10
    result = MinimumTimeToRepairCars().repairCars(ranks, cars)
    print(result)
    
if __name__ == "__main__":
    main()