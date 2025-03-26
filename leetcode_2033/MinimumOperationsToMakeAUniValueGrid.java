import java.util.Arrays;

class MinimumOperationsToMakeAUniValueGrid {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int totalLength = m * n, totalOperations = 0;
        int[] nums = new int[totalLength];
        int index = 0;

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
                nums[index++] = grid[i][j];
        }

        Arrays.sort(nums);
        int mid = totalLength / 2;
        int median = nums[mid];

        for(int val : nums)
        {
            if(Math.abs(val - median) % x != 0)
                return -1;
            totalOperations += Math.abs(val - median) / x;
        }

        return totalOperations;
    }

    public static void main(String[] args) {
        MinimumOperationsToMakeAUniValueGrid obj = new MinimumOperationsToMakeAUniValueGrid();
        int[][] grid = {{2,4},{6,8}};
        int x = 2;
        System.out.println(obj.minOperations(grid, x));
    }
}