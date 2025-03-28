package leetcode_2503;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class MaximumNumberOfPointsFromGridQueries {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int rows = grid.length, cols = grid[0].length;
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int n = queries.length;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        List<int[]> sortedQueries = new ArrayList<>();
        int[][] visited = new int[rows][cols];
        int[] res  = new int[n];

        for(int i=0; i<n; i++) {
            sortedQueries.add(new int[]{queries[i], i}); // store query value and index
        }
        sortedQueries.sort(Comparator.comparingInt(a -> a[0]));

        minHeap.offer(new int[]{grid[0][0], 0, 0}); // store value, row, col
        visited[0][0] = 1; // mark the starting cell as visited
        int points = 0;

        for(int[] q : sortedQueries)
        {
            int queryValue = q[0], queryIndex = q[1];

            // Process the minHeap until the top element is less than or equal to the current query value
            while(!minHeap.isEmpty() && minHeap.peek()[0] < queryValue)
            {
                int[] top = minHeap.poll();
                int row = top[1], col = top[2];
                points++; // increment points for each valid cell processed

                for(int[] dir : directions)
                {
                    int nr = row + dir[0], nc = col + dir[1];

                    if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && visited[nr][nc] == 0)
                    {
                        minHeap.offer(new int[]{grid[nr][nc], nr, nc}); // add the neighboring cell to the minHeap
                        visited[nr][nc] = 1; // mark as visited
                    }
                }
            }
            res[queryIndex] = points; // store the result for the current query
        }

        return res;
    }

    public static void main(String[] args) {
        MaximumNumberOfPointsFromGridQueries obj = new MaximumNumberOfPointsFromGridQueries();
        int[][] grid = {
            {1, 2, 3},
            {2, 5, 7},
            {3, 5, 1}
        };
        int[] queries = {5, 6, 2};
        int[] result = obj.maxPoints(grid, queries);
        for(int res : result) {
            System.out.print(res + " ");
        }
    }
}