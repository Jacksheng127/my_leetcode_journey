package leetcode_3243;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class shortestDistanceAfterRoadAdditionQueriesI{
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adj.add(new ArrayList<>());
            adj.get(i).add(i+1);
        }

        // Result array
        int[] res = new int[queries.length];

        // Process each query
        for (int i = 0; i < queries.length; i++) {
            int src = queries[i][0];
            int dest = queries[i][1];

            adj.get(src).add(dest); // Add edge from src to dest
            res[i] = bfs(n, adj);   // Perform BFS and store the result
        }

        return res;
    }

    // BFS to calculate shortest distance
    public int bfs(int n, List<List<Integer>> adj) {
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(new int[] {0, 0}); // {node, length}
        visited.add(0);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cur = current[0];
            int length = current[1];

            if (cur == n - 1) {
                return length;
            }

            for (int neighbor : adj.get(cur)) {
                if (!visited.contains(neighbor)) {
                    queue.add(new int[] {neighbor, length + 1});
                    visited.add(neighbor);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        shortestDistanceAfterRoadAdditionQueriesI obj = new shortestDistanceAfterRoadAdditionQueriesI();
        int n = 5;
        int[][] queries = {{0, 2}, {2, 4}, {0, 4}};
        int[] res = obj.shortestDistanceAfterQueries(n, queries);
        for(int i=0; i<res.length; i++)
            System.out.print(res[i] + " ");
    }
}
