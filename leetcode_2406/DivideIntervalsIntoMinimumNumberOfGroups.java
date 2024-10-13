package leetcode_2406;

import java.util.Arrays;

class DivideIntervalsIntoMinimumNumberOfGroups{
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for(int i = 0; i < n; i++)
        {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        // Solution 1
        int j = 0, groupCounts = 0;
        for (int st : start)
        {
            if (st > end[j])
                j++;
            else
                groupCounts++;
        }
        return groupCounts;

        // Solution 2
        // int i = 0, j = 0, res = 0;
        // while(i < n)
        // {
        //     if(start[i] <= end[j])
        //     {   
        //         i++;
        //     }
        //     else
        //     {
        //         j++;
        //     }
        //     res = Math.max(res, i - j);
        // }
        // return res;
    }

    public static void main(String[] args) {
        DivideIntervalsIntoMinimumNumberOfGroups d = new DivideIntervalsIntoMinimumNumberOfGroups();
        System.out.println(d.minGroups(new int[][]{{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}}));
    }
}