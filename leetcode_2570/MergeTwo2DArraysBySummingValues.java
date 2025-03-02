package leetcode_2570;

import java.util.ArrayList;
import java.util.List;

class MergeTwo2DArraysBySummingValues {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();

        while(i < m && i < n)
        {
            // If the 1st element keys value is same in both arrays
            if(nums1[i][0] == nums2[j][0])
            {
                res.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            }
            // If the 1st element key value in nums1 array is less than the 1st element key value in nums2 array
            else if(nums1[i][0] < nums2[j][0])
            {
                res.add(new int[]{nums1[i][0], nums1[i][1]});
                i++;
            }
            // If the 1st element key value in nums1 array is greater than the 1st element key value in nums2 array
            else
            {
                res.add(new int[]{nums2[j][0], nums2[j][1]});
                j++;
            }
        }

        // If there are still elements left in the nums1 array
        while(i < m)
        {
            res.add(nums1[i]);
            i++;
        }
        // If there are still elements left in the nums2 array
        while(j < n)
        {
            res.add(nums2[j]);
            j++;
        }

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        MergeTwo2DArraysBySummingValues obj = new MergeTwo2DArraysBySummingValues();
        int[][] res = obj.mergeArrays(new int[][]{{1, 2}, {2, 3}, {4, 5}}, new int[][]{{1, 4}, {3, 2}, {4, 1}});
        for(int[] a : res)
        {
            System.out.println(a[0] + " " + a[1]);
        }
    }
}