package leetcode_2594;

import java.util.Arrays;

class MinimumTimeToRepairCars {
    public long repairCars(int[] ranks, int cars) {
        long left = 1;
        long right = (long) Arrays.stream(ranks).min().getAsInt() * cars * cars;
        long res = -1;

        while(left <= right)
        {
            long mid = left + (right - left) / 2;
            long count = countRepaired(mid, ranks);
            if(count >= cars)
            {
                res = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return res;
    }

    private long countRepaired(long time, int[] ranks)
    {
        long count = 0;
        for(int rank : ranks)
            count += Math.sqrt(time / rank);
        return count;
    }

    public static void main(String[] args) {
        MinimumTimeToRepairCars obj = new MinimumTimeToRepairCars();
        int[] ranks = { 4, 2, 3, 1 };
        int cars = 10;
        System.out.println(obj.repairCars(ranks, cars));
    }
}