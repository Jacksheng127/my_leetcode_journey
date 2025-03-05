package leetcode_2579;

class CountTotalNumberOfColoredCells{
    public long coloredCells(int n) {
        // For Loop Approach
        // long res = 1;
        // for (int i=0; i<n; i++)
        // {
        //     res += (4 * i);
        // }
        // return res;

        // Mathematical Approach
        return 1 + 4L * n * (n-1) / 2;
    }

    public static void main(String[] args) {
        CountTotalNumberOfColoredCells obj = new CountTotalNumberOfColoredCells();
        System.out.println(obj.coloredCells(3));
    }
}